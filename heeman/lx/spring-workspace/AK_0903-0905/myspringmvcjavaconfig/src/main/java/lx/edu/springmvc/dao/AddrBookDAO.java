package lx.edu.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springmvc.vo.AddrBookVO;


@Repository
public class AddrBookDAO {

	@Autowired
	SqlSession session;

	public AddrBookVO getDB(int abId) {
		return session.selectOne("getDB",abId);
	}
	
	public List<AddrBookVO> getDBList() {
		return session.selectList("getDBList");
	}

	public AddrBookVO insertDB(AddrBookVO ab) {
		return this.session.selectOne("insertDB",ab);
	}

	public int updateDB(AddrBookVO ab){
		return this.session.update("updateDB",ab);
	}
	
	public int deleteDB(int abId){
		return this.session.delete("deleteDB",abId);
	}

}
