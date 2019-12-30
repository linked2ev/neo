package com.rest.neo.board.service;

import com.rest.neo.board.model.Board;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface BoardService {

    int selectBoardListCnt(HttpServletRequest request, Board board) throws Exception;

    List<Board> selectBoardList(HttpServletRequest request, Board board) throws Exception;

    Board selectBoard(HttpServletRequest request, int boardIdx) throws Exception;

    void insertBoard(HttpServletRequest request, Board board) throws Exception;

    void updateBoard(HttpServletRequest request, Board board) throws Exception;

    void deleteBoard(HttpServletRequest request, int boardIdx) throws Exception;

    int selectBoardCnt(int boardIdx) throws Exception;

    Integer insertBoardSelectKey(Board board) throws Exception;

    Integer updateBoard(Board board) throws Exception;

    Integer deleteBoard(int boardIdx) throws Exception;
}