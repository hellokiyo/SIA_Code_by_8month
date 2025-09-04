package lx.edu.springmvc.aop;

import java.sql.Timestamp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lx.edu.springmvc.dao.RequestLogDAO;
import lx.edu.springmvc.vo.RequestLogVO;

@Aspect
@Component
@EnableAspectJAutoProxy
public class RequestLogAdvice {

	@Autowired
	RequestLogDAO dao;
	
	@Autowired
	RequestLogVO vo;
	
	
	@Before("execution(* lx.edu.springmvc.controller.Addr*.*(..))")
	public void beforelog(JoinPoint joinPoint) {
		System.out.println("LogAdvice.beforeLog()");

		
		//-----------값 지정--------------
		String targetClass = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		String time = new Timestamp(System.currentTimeMillis()).toString();
		//-------------------------		
		
		//---------객체에 값넣기----------------
		vo.setReqClass(targetClass);
		vo.setReqMethod(methodName);
		vo.setReqTime(time);
		
		dao.reqInsertDB(vo);
		//-------------------------
		
		
		System.out.printf("class=%s, method=%s\n, start=%s\n", targetClass, methodName,time);
	}
}
