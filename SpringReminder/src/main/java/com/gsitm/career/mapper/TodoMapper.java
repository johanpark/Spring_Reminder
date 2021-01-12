package com.gsitm.career.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.gsitm.career.dto.TodoDTO;

@Repository
@Mapper
public interface TodoMapper {
	/* TODO 작성 */
public int todoInsert(TodoDTO todos) throws Exception;
	/*TODO 삭제*/
public int todoDelete(String todoID) throws Exception;
	/* TODO 리스트 출력 */
public List<TodoDTO> todoList(String userID) throws Exception;
}
