package com.gsitm.career.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.service.MemberService;

/**
 * @author pyhan
 *
 */
@RestController
@RequestMapping("/Reminder")
public class MemberController {
	@Autowired
	MemberService memberService;

	/**
	 * 로그인 페이지
	 * @param modelAndView
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/loginForm")
	private ModelAndView selectLoginForm(ModelAndView modelAndView) throws Exception{
		modelAndView.setViewName("login/login");
		return modelAndView;
	}
	/**
	 * 계정 생성 페이지
	 * @param modelAndView
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/accountForm")
	private ModelAndView selectAccountForm(ModelAndView modelAndView) throws Exception{
		modelAndView.setViewName("login/account");
		return modelAndView;
	}
	/**
	 * 계정 생성
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/accountProc")
	private String memberAccountProc(HttpServletRequest request, HttpServletResponse response)throws Exception{
		MemberDTO member = new MemberDTO();
		member.setUserID(request.getParameter("userID"));
		member.setUserPassword(request.getParameter("userPassword"));
		member.setUserName(request.getParameter("userName"));
		member.setUserMail(request.getParameter("userMail"));
		memberService.memberInsert(member);
		response.sendRedirect("/Reminder/loginForm");
		return null;
	}
	/**
	 * 로그인
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	private String memberLogin(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String id= request.getParameter("ID");
		String password = request.getParameter("Password");
		MemberDTO member = memberService.memberSearch(id);
		if(!member.getUserPassword().equals(password)) {
			request.setAttribute("error", "check ID & Password");
			response.sendRedirect("/Reminder/loginForm");
			return null;
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("ID", member.getUserID());
			session.setAttribute("userName", member.getUserName());
			response.sendRedirect("/Reminder/main");
			return null;
		}
	}
	/**
	 * 로그아웃
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	private String memberLogout(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("/Reminder/main");
		return null;
	}

}
