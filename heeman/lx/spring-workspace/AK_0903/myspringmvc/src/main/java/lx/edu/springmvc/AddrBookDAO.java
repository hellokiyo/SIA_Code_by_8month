package lx.edu.springmvc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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

	public AddrBookVO updateDB(AddrBookVO ab){
		return this.session.selectOne("updateDB",ab);
	}
	
	public AddrBookVO deleteDB(int abId){
		return this.session.selectOne("deleteDB",abId);
	}

}
