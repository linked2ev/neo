package com.rest.neo.board.mapper;

import com.rest.neo.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int selectBoardListCnt(Board board) throws Exception;

    List<Board> selectBoardList(Board board) throws Exception;

    Board selectBoard(int boardIdx) throws Exception;

    int insertBoard(Board board) throws Exception;

    int updateBoard(Board board) throws Exception;

    int selectBoardCnt(int boardIdx) throws Exception;

    int deleteBoard(int boardIdx) throws Exception;

    int insertBoardSelectKey(Board board);
}