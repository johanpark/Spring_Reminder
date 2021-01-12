package com.gsitm.career.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.BoardDTO;
import com.gsitm.career.mapper.BoardMapper;


@Service
@Transactional
public class BoardService {
	@Autowired
	BoardMapper mBoardMapper;

	/* 게시판 리스트 출력 */
	public List<BoardDTO> boardListService(int beginRow ,int perPageRow)throws Exception{
		return mBoardMapper.boardList(beginRow,perPageRow);
	}

	/* 게시판 상세 페이지 */
	public BoardDTO boardDetailService(String boardID) throws Exception{
		return mBoardMapper.boardDetail(boardID);
	}

	/* 게시판 글 작성 */
	public int boardInsertService(BoardDTO board) throws Exception{
		return mBoardMapper.boardInsert(board);
	}

	/* 게시판 글 수정 */
	public int boardUpdateService(BoardDTO board) throws Exception{
		return mBoardMapper.boardUpdate(board);
	}

	/* 게시판 글 삭제 */
	public int boardDeleteService(String boardID) throws Exception{
		return mBoardMapper.boardDelete(boardID);
	}

	/* 게시판 글 개수 */
	public int boardCount() throws Exception {
		return mBoardMapper.boardCount();
	}
}
