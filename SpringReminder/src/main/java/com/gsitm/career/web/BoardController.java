package com.gsitm.career.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.career.dto.BoardDTO;
import com.gsitm.career.service.BoardService;

import lombok.extern.java.Log;

/**
 * @author pyhan
 *
 */
@Controller
@RequestMapping("/Reminder")

public class BoardController {
	@Autowired
	BoardService mBoardService;
	/**
	 * 리스트 페이지
	 * @param request
	 * @param model
	 * @param BoardDTO
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	private String selectBoardList(HttpServletRequest request, Model model,BoardDTO BoardDTO) throws Exception {

		int Cnt = mBoardService.boardCount();

		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		int perPageRow = 10;
		int beginRow = (pageNumber-1)*perPageRow;
		int lastPage = Cnt/perPageRow;

		List<BoardDTO> list = mBoardService.boardListService(beginRow,perPageRow);

		model.addAttribute("boardList", list);
		model.addAttribute("perPageRow", perPageRow);
		model.addAttribute("beginRow", beginRow);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("pageNumber", pageNumber);
		return "board/board";
	}

	/**
	 * 상세페이지
	 * @param boardID
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detail/{boardID}")
	private String selectBoardDetail(@PathVariable String boardID, Model model) throws Exception {
		model.addAttribute("detail", mBoardService.boardDetailService(boardID));
		return "board/view";
	}

	/**
	 * 게시판 글작성 페이지
	 * @return
	 */
	@RequestMapping("/insert")
	private String boardInsertForm() {
		return "board/posting";
	}

	/**
	 * 게시판 글 작성
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request) throws Exception {
		BoardDTO board = new BoardDTO();
		HttpSession session = request.getSession();
		board.setBoardTitle(request.getParameter("bbsTitle"));
		board.setBoardContent(request.getParameter("bbsContent"));
		board.setUserID((String) session.getAttribute("ID"));
		mBoardService.boardInsertService(board);
		return "redirect:/Reminder/list";
	}

	/**
	 * 게시판 글 수정 페이지
	 * @param boardID
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update/{boardID}")
	private String boardUpdateForm(@PathVariable String boardID, Model model) throws Exception {
		model.addAttribute("update", mBoardService.boardDetailService(boardID));
		return "board/update";
	}

	/**
	 * 게시판 글 수정
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateProc")
	private String boardUpdateProc(HttpServletRequest request) throws Exception {
		BoardDTO board = new BoardDTO();
		board.setBoardTitle(request.getParameter("bbsTitle"));
		board.setBoardContent(request.getParameter("bbsContent"));
		board.setBoardID(request.getParameter("boardID"));
		mBoardService.boardUpdateService(board);
		return "redirect:/Reminder/list";
	}

	/**
	 * 게시판 글 삭제
	 * @param boardID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete/{boardID}")
	private String boardDelete(@PathVariable String boardID) throws Exception {
		mBoardService.boardDeleteService(boardID);
		return "redirect:/Reminder/list";
	}
}
