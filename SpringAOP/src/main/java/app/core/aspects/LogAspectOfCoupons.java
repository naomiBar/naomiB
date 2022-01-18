package app.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspectOfCoupons {

	/* {execution()} - a pointcut designator
	 * if not specified - any or no modifiers
	 * {*} - any return type
	 * {*.} - any declaring type
	 * {*} - any method name
	 * {(..)} - 0 or more arguments of any type
	 * if not specified can throw anything or not throw
	 */
	@Before("execution(* *.*(..))") //most general
	public void logAll() {
		System.out.print(">>> ");
	}
	
	
	/* below is an advice method of type 'before',
	 * it is annotation @Before,
	 * the annotation has a pointcut expression [execution(void addCompany(int))]
	 */
	@Before("execution(public void add*(int))") //most specific
	public void logSpecific() {
		System.out.println("methods name with add:");
	}
	
	@Before("execution(public void *d*(..))") //most specific
	public void logSpecific2(JoinPoint jp) {
		System.out.println("methods name with 'd': " + jp.getSignature().getName());
	}
	
	@Before("execution(public void *())") //most specific
	public void logSpecific3() {
		System.out.println("methods with 0 arguments:");
	}
	
	//define pointcuts to use on advice methods
	@Pointcut("execution(* *.*(app.core.beans.Company))") //match on any methods that accepts Company parameter
	public void companyParameter() {
	}
	
	private int numberOfCalls;

//	@Before("execution(* *.*(app.core.beans.Company))") //most specific
	@Before("companyParameter()")
	public void counterAdvice() {
		numberOfCalls++;
		System.out.print("+++");
	}

	public int getNumberOfCalls() {
		return numberOfCalls;
	}
	
}
