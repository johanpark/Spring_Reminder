package com.gsitm.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gsitm.career.dto.TodoDTO;

@Repository
@Mapper
public interface CalendarMapper {
	/* 달력 이벤트 작성 */
	public int calendarInsert(TodoDTO todos) throws Exception;

	/* 달력 이벤트 삭제 */
	public int calendarDelete(String todoID) throws Exception;

	/* 달력 이벤트 수정 */
	public int calendarUpdate(TodoDTO todos) throws Exception;

	/* 달력 이벤트 리스트 출력 */
	public List<TodoDTO> calendarList(String userID) throws Exception;
}
