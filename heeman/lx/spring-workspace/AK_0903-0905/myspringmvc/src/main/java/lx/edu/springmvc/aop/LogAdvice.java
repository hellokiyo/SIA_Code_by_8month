package lx.edu.springmvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAdvice {
	@Before("execution(* lx.edu.springmvc.controller.Addr*.*(..))")
	public void beforelog(JoinPoint joinPoint) {

		System.out.println("LogAdvice.beforeLog()");

		Class targetClass = joinPoint.getTarget().getClass(); //클래스
		String methodName = joinPoint.getSignature().getName(); //메소드 이름

		System.out.printf("class=%s, method=%s\n", targetClass.getName(), methodName);
	}
}
