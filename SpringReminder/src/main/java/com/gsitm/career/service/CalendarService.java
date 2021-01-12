package com.gsitm.career.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.career.dto.TodoDTO;
import com.gsitm.career.mapper.CalendarMapper;

@Service
public class CalendarService {
	@Autowired
	CalendarMapper calendarMapper;

	/* 달력 이벤트 추가 */
	public int calendarInsertService(TodoDTO todos) throws Exception{
		return calendarMapper.calendarInsert(todos);
	}

	/* 달력 이벤트 삭제 */
	public int calendarDeleteService(String todoID) throws Exception{
		return calendarMapper.calendarDelete(todoID);
	}

	/* 달력 이벤트 수정 */
	public int calendarUpdateService(TodoDTO todos) throws Exception{
		return calendarMapper.calendarUpdate(todos);
	}

	/* 달력 이벤트 리스트 출력 */
	public List<TodoDTO> calendarListService(String userID) throws Exception{
		return calendarMapper.calendarList(userID);
	}
}
