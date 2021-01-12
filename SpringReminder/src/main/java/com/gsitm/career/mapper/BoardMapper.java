package com.gsitm.career.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.gsitm.career.dto.BoardDTO;

@Repository
@Mapper
public interface BoardMapper {
	/* 게시판 글 작성 */
	public int boardInsert(BoardDTO board) throws Exception;

	/* 게시판 글 수정 */
	public int boardUpdate(BoardDTO board) throws Exception;

	/* 게시판 글 삭제 */
	public int boardDelete(String boardID) throws Exception;

	/* 게시판 상세 페이지 */
	public BoardDTO boardDetail(String boardID) throws Exception;

	/*게시판 글 리스트 출력*/
	public List<BoardDTO> boardList(@Param("beginRow") int beginRow, @Param("perPageRow") int perPageRow) throws Exception;

	/* 게시판 글 개수 */
	public int boardCount() throws Exception;
}
