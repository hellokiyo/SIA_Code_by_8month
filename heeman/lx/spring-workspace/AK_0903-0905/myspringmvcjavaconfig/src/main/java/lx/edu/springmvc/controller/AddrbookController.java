package lx.edu.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lx.edu.springmvc.aop.RequestLogAdvice;
import lx.edu.springmvc.dao.AddrBookDAO;
import lx.edu.springmvc.vo.AddrBookVO;

@Controller
public class AddrbookController {

	@Autowired
	AddrBookDAO dao;

	@RequestMapping("/addrbook_form.do")
	public String form() {
		return "addrbook_form"; // jsp file name
	}

//	@RequestMapping("/addrbook_list.do")
//	public String list(HttpServletRequest req) throws Exception {
//		List<AddrBookVO> list = this.dao.getDBList();
//		// list를 request에 넣는다.
//		req.setAttribute("data", list);
//		return "addrbook_list";
//	}

	@RequestMapping("/addrbook_list.do")
	public String list(HttpSession session, HttpServletRequest req){
//		Interceptor방식으로 변경
//		if(session.getAttribute("userId") ==null) {
//			return "login";
//		}
		List<AddrBookVO> list = this.dao.getDBList();
		req.setAttribute("data", list);
		return "addrbook_list";
	}

	@RequestMapping("/insert.do")
	public String insert(AddrBookVO vo) {
		// 1. 클라이언트(웹 브라우저)가 전송한 데이터를 받아와야함
		System.out.println(vo);
		// 2.
		dao.insertDB(vo);
		return "redirect:addrbook_list.do";
	}

	// addrbook_edit_form.do?abId=4 쿼리스트링 방식
	@RequestMapping("/addrbook_edit_form.do")
	public String edit(@RequestParam("abId") int abId, HttpServletRequest req) {
		AddrBookVO edit = dao.getDB(abId);
		req.setAttribute("ab", edit);
		return "addrbook_edit_form";
	}
	
	/*
	 * @RequestMapping("/update.do") public String update(AddrBookVO vo) {
	 * dao.updateDB(vo); return "redirect:addrbook_list.do"; }
	 */
	@RequestMapping("/update.do")
	public String update(@RequestParam("ab") AddrBookVO ab, HttpServletRequest req) {
		dao.updateDB(ab);
		return "redirect:addrbook_list.do";
	}


	@RequestMapping("/delete.do/{abId}")
	public String delete(@PathVariable("abId") int abId, HttpServletRequest req) {
		dao.deleteDB(abId);
		return "redirect:addrbook_list.do";
	}

}
