package app.core.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.log.LoginManager;

@Component
@Aspect
public class SecurityAspectToCalculator {

	@Autowired
	private LoginManager loginManager;

	@Around("calc()")
	public Object logAdvice(ProceedingJoinPoint pjp) throws Throwable {
		if (loginManager.isLogged()) {
			return pjp.proceed();
		} else {
			throw new RuntimeException("Login Error - you need to login first");
		}
	}

	@Pointcut("execution(* app.core.beans.Calculator.*(..))")
	public void calc() {
	}

}
