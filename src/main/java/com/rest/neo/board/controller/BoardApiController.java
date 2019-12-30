package com.rest.neo.board.controller;

import com.rest.neo.board.model.Board;
import com.rest.neo.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@Slf4j
@RestController
@RequestMapping("/v2/api/board")
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    //목록
    @GetMapping
    public ResponseEntity<List<Board>> boardList(HttpServletRequest request, @ModelAttribute Board board) throws Exception {
        List<Board> list = this.boardService.selectBoardList(request, board);
        return ResponseEntity.ok().body(list);
    }

    //상세
    @GetMapping("{boardIdx}")
    public ResponseEntity<Board> boardDetail(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) int boardIdx) throws Exception {
        Board detail = this.boardService.selectBoard(request, boardIdx);
        return ResponseEntity.ok().body(detail);
    }

    //등록
    @PostMapping
    public ResponseEntity boardInsert(@RequestBody Board board) throws Exception {
        Integer idx = this.boardService.insertBoardSelectKey(board);
        return ResponseEntity.created(linkTo(BoardApiController.class).slash(idx).toUri()).build();
    }

    //수정
    @PutMapping("{boardIdx}")
    public ResponseEntity<String> boardUpdate(@PathVariable(name="boardIdx", required=true) int boardIdx, @RequestBody Board board) throws Exception {
        int cnt = this.boardService.selectBoardCnt(boardIdx);
        if (cnt > 0) {
            board.setBoardIdx(boardIdx);
            this.boardService.updateBoard(board);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            Integer idx = this.boardService.insertBoardSelectKey(board);
            return ResponseEntity.created(linkTo(BoardApiController.class).slash(idx).toUri()).build();
        }
    }

    //삭제
    @DeleteMapping("{boardIdx}")
    public ResponseEntity<String> boardDelete(@PathVariable(name="boardIdx", required=true) int boardIdx) throws Exception {
        int ret = this.boardService.deleteBoard(boardIdx);
        if (ret > 0) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}