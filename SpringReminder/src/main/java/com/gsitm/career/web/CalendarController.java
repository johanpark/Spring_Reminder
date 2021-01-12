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
import com.gsitm.career.service.CalendarService;

/**
 * @author pyhan
 *
 */
@Controller
@RequestMapping("/Reminder")
public class CalendarController {
	@Autowired
	CalendarService calendarService;

	/**
	 * 달력 페이지 출력
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	 @RequestMapping("/calendar")
	 private String calendarList(HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("ID");
		model.addAttribute("calendarList", calendarService.calendarListService(id));
		return"calendar/calendar";
	 }

	 /**
	  * 달력 이벤트 작성
	  * @param request
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/calendarInsert")
	 private String calendarInsert(HttpServletRequest request) throws Exception{
		 TodoDTO todos = new TodoDTO();
		 HttpSession session = request.getSession();
		 todos.setUserID((String) session.getAttribute("ID"));
		 todos.setTodoStartDate(request.getParameter("startday"));
		 todos.setTodoEndDate(request.getParameter("endday"));
		 todos.setTodoContent(request.getParameter("todoinput"));
		 calendarService.calendarInsertService(todos);
		 return "redirect:/Reminder/calendar";
	 }

	 /**
	  * 달력 이벤트 수정
	  * @param request
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/calendarUpdate")
	 private String calendarUpdate(HttpServletRequest request) throws Exception{
		 TodoDTO todos = new TodoDTO();
		 todos.setTodoID(request.getParameter("todoID"));
		 todos.setTodoStartDate(request.getParameter("todoStartDay"));
		 todos.setTodoEndDate(request.getParameter("todoEndDay"));
		 todos.setTodoContent(request.getParameter("todotitle"));
		 calendarService.calendarUpdateService(todos);
		 return "redirect:/Reminder/calendar";
	 }

	 /**
	  * 달력 이벤트 삭제
	  * @param request
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/calendarDelete")
	 private String calendarDelete(HttpServletRequest request) throws Exception{
		 String todoID = request.getParameter("todoID");
		 calendarService.calendarDeleteService(todoID);
		 return "redirect:/Reminder/calendar";
	 }
}
