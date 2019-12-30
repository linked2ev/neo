package com.rest.neo.board.service;

import com.rest.neo.board.mapper.BoardMapper;
import com.rest.neo.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public int selectBoardListCnt(HttpServletRequest request, Board board) throws Exception {
        return boardMapper.selectBoardListCnt(board);
    }

    public List<Board> selectBoardList(HttpServletRequest request, Board board) throws Exception {
        return boardMapper.selectBoardList(board);
    }

    public Board selectBoard(HttpServletRequest request, int boardIdx) throws Exception {
        return boardMapper.selectBoard(boardIdx);
    }

    public void insertBoard(HttpServletRequest request, Board board) throws Exception {
        boardMapper.insertBoard(board);
    }

    public void updateBoard(HttpServletRequest request, Board board) throws Exception {
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(HttpServletRequest request, int boardIdx) throws Exception {
        boardMapper.deleteBoard(boardIdx);
    }

    public int selectBoardCnt(int boardIdx) throws Exception {
        return boardMapper.selectBoardCnt(boardIdx);
    }

    public Integer insertBoardSelectKey(Board board) throws Exception {
        boardMapper.insertBoardSelectKey(board);
        return board.getBoardIdx();
    }

    public Integer updateBoard(Board board) throws Exception {
        return boardMapper.updateBoard(board);
    }

    public Integer deleteBoard(int boardIdx) throws Exception {
        return boardMapper.deleteBoard(boardIdx);
    }
}