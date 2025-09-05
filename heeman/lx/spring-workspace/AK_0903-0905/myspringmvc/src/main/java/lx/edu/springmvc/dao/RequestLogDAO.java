package lx.edu.springmvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lx.edu.springmvc.vo.RequestLogVO;

@Repository
public class RequestLogDAO {

	@Autowired
	SqlSession session;

	public int reqInsertDB(RequestLogVO vo) {
		return session.insert("reqInsertDB",vo);
	}

}
