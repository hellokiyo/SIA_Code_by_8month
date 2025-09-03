package lx.edu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AddrbookController {

	@Autowired
	AddrBookDAO dao;

	
	@RequestMapping("/addrbook_form.do")
	public String form() {
		return "addrbook_form"; // jsp file name
	}

	@RequestMapping("/addrbook_list.do")
	public String list(HttpServletRequest req) throws Exception {
		List<AddrBookVO> list = this.dao.getDBList();
		// list를 request에 넣는다.
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

	@RequestMapping("/update.do")
	public String update(AddrBookVO vo) {
		dao.updateDB(vo);
		return "redirect:addrbook_list.do";
	}	
	
	@RequestMapping("/addrbook_edit_form.do/abId={abId}")
	public String edit(@PathVariable("abId") int abId, HttpServletRequest req) {
		AddrBookVO edit = dao.getDB(abId);
		req.setAttribute("ab",edit);
		return "addrbook_edit_form";
	}
	
	@RequestMapping("/delete.do/abId={abId}") 
	public String delete(@PathVariable("abId") int abId, HttpServletRequest req){ 
		dao.deleteDB(abId);  
		return "redirect:addrbook_list.do"; 
	}

}
