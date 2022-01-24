package com.rest.neo.board.controller;

import com.rest.neo.board.model.Board;
import com.rest.neo.board.service.BoardService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value="게시글 목록")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardIdx", value="게시글번호", dataType = "int", paramType="query"),
            @ApiImplicitParam(name = "title", value="제목", dataType = "String", paramType="query"),
            @ApiImplicitParam(name = "contents", value="내용", dataType = "String", paramType="query")
    })
    @GetMapping
    public ResponseEntity<List<Board>> boardList(HttpServletRequest request, @ModelAttribute Board board) throws Exception {
        List<Board> list = this.boardService.selectBoardList(request, board);
        return ResponseEntity.ok().body(list);
    }

    //상세
    @ApiOperation(value="게시글 상세")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardIdx", value="게시글번호", required=true, dataType = "int", paramType="path")
    })
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
    @ApiOperation(value="게시글 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardIdx", value="게시글번호", required=true, dataType = "int", paramType="path")
    })
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
    @ApiOperation(value="게시글 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardIdx", value="게시글번호", required=true, dataType = "int", paramType="path")
    })
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