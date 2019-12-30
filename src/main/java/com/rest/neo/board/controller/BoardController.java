package com.rest.neo.board.controller;

import com.rest.neo.board.model.Board;
import com.rest.neo.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("board")
    public List<Board> boardList(HttpServletRequest request, @ModelAttribute Board board) throws Exception {
        return this.boardService.selectBoardList(request, board);
    }

    @GetMapping("board/{boardIdx}")
    public Board detailBoard(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) int boardIdx) throws Exception {
        return this.boardService.selectBoard(request, boardIdx);
    }

    @PostMapping("board")
    public void insertBoard(HttpServletRequest request, @RequestBody Board board) throws Exception {
        this.boardService.insertBoard(request, board);
    }

    @PutMapping("board/{boardIdx}")
    public void updateBoard(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) int boardIdx, @RequestBody Board board) throws Exception {
        board.setBoardIdx(boardIdx);
        this.boardService.updateBoard(request, board);
    }

    @DeleteMapping("board/{boardIdx}")
    public void deleteBoard(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) int boardIdx) throws Exception {
        this.boardService.deleteBoard(request, boardIdx);
    }

}