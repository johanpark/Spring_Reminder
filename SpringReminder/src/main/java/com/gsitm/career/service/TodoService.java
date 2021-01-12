package com.gsitm.career.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsitm.career.dto.TodoDTO;
import com.gsitm.career.mapper.TodoMapper;

@Service
public class TodoService {
	@Autowired
	TodoMapper todoMapper;
	/*TODO 리스트 출력*/
	public List<TodoDTO> todoListService(String userID) throws Exception{
		return todoMapper.todoList(userID);
	}
	/*TODO 이벤트 추가*/
	public int todoInsertService(TodoDTO todos) throws Exception{
		return todoMapper.todoInsert(todos);
	}

	/* TODO 이벤트 삭제 */
	public int todoDeleteService(String todoID) throws Exception{
		return todoMapper.todoDelete(todoID);
	}
}
