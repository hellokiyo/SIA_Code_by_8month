package lx.edu.springbreak.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springbreak.vo.ToDoVO;

@Repository
public class ToDoDAO {

	@Autowired
	SqlSession session;
	
//---------------- 할일 출력 ---------------------------

	// 할일 리스트
	public List<ToDoVO> getDBList() {
		return this.session.selectList("mapper-todo.getDBList");
	}
	
	// 완료한일 리스트 불린 (값을 반환해서 완료/미완료 구분하기)
	public List<ToDoVO> getTodoCompleteList(boolean completed) {
		return this.session.selectList("mapper-todo.getTodoCompleteList", completed);
	}
	
//----------------추가 --------------------------------
	
	// 할일 추가
	public int insertDB(ToDoVO vo) {
		return this.session.insert("mapper-todo.insertDB",vo);
	}
	
//----------------수정 --------------------------------
	// 할일 
	public ToDoVO getDB(int id) {
		return this.session.selectOne("mapper-todo.getDB",id);
	}
	
	// 할일 수정
	public int updateDB(ToDoVO vo) {
		return this.session.update("mapper-todo.updateDB", vo);
	}
	
//----------------삭제---------------------------------
	
	// 할일 삭제
	public int deleteDB(int id) {
		return this.session.delete("mapper-todo.deleteDB",id);
	}
	
//----------------------------------------------------

}
