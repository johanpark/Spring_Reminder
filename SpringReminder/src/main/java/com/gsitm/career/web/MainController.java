package com.gsitm.career.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.career.dto.TodoDTO;
import com.gsitm.career.service.TodoService;

/**
 * @author pyhan
 *
 */
@Controller
@RequestMapping("/Reminder")
public class MainController {
	@Autowired
	TodoService todoService;

	/**
	 * 메인 페이지 출력 및 todoList출력
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/main")
	private String todoList(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		model.addAttribute("todoList", todoService.todoListService(id));
		return "main/main";
	}

	/**
	 * TODO 추가
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/create")
	private String todoInsert(HttpServletRequest request) throws Exception{
	 TodoDTO todos = new TodoDTO();
	 HttpSession session = request.getSession();
	 todos.setTodoContent(request.getParameter("todoinput"));
	 todos.setUserID((String) session.getAttribute("ID"));
	 todoService.todoInsertService(todos);
	 return "redirect:/Reminder/main";
	 }

	/**
	 * TODO 삭제
	 * @param TodoID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/todoDelete/{TodoID}")
	private String todoDelete(@PathVariable String TodoID) throws Exception{
		todoService.todoDeleteService(TodoID);
		return "redirect:/Reminder/main";
	}
}
