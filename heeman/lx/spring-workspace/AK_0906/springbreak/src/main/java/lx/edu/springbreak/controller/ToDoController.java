package lx.edu.springbreak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import lx.edu.springbreak.dao.ToDoDAO;
import lx.edu.springbreak.vo.ToDoVO;

@Controller
public class ToDoController {

	//수정해야할 것 :  /update.do	
	
	@Autowired
	ToDoDAO dao;
	
//---------------- 할일 출력 -----------------------------------
	
	// 첫 화면
	@RequestMapping("/todo_list.do")
	public String form(Model model) {
		model.addAttribute("data",dao.getDBList());
		return "todo_list";
	}
	
	// 완료한 일 리스트
	@RequestMapping("/complete.do")
	public String todoComplete(Model model,boolean completed) {
		model.addAttribute("completeData", dao.getTodoCompleteList(completed)); 
		return "todoComplete";
	}

//----------------추가 -----------------------------------
	
	// 할일 추가 폼
	@RequestMapping("/add.do")
	public String add() {
		return "add-form";
	}
	
	// 할일 추가 insertDB
	@RequestMapping("/insert.do")
	public String insert(ToDoVO vo) {
		dao.insertDB(vo);
		return "redirect:todo_list.do";
	}
	
//--------------수정 -------------------------------------
	
	// 할일 수정 폼
	@RequestMapping("/edit.do")
	public String edit(@RequestParam int id,Model model) {
		model.addAttribute("vo",dao.getDB(id));
		return "edit-form";
	}
	
	//할일 수정 updateDB
	@RequestMapping("/update.do")
	public String update(ToDoVO vo) {
		dao.updateDB(vo);
		return "redirect:todo_list.do";
	}
	
	
//------------------삭제---------------------------------
	
	// 할일 삭제 deleteDB
	@RequestMapping("/delete.do")
	public String delete(@RequestParam("id") int id) {
		dao.deleteDB(id);
		return "redirect:todo_list.do";
	}
	
	// 할일 리스트 삭제 deleteDBone
	@RequestMapping("/deleteOne.do")
	public String deleteOne() {
		dao.deleteDBone();
		return "redirect:todo_list.do";
	}
	
//---------------------------------------------------
	
	
	
}
