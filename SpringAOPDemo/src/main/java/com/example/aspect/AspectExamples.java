package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 
 * An aspect is a class filled with advice
 * 
 */
@Component("myAspect")
@Aspect
public class AspectExamples {
	
	public AspectExamples() {
		
	}
	
	/*
	 * Pointcut expressions are used to select joinpoints, other words pointcuts target a subset of joinpoints
	 * 
	 * Pointcut expression symbols
	 * 	"*" is a wildcard for return types, method names, and a single parameter in the paramater list
	 *  ".." is a wildcard for the paramater list of a method
	 * 
	 * @Before("execution(* *(..)") this will execute on all the methods
	 * @Before("execution(* draw*(..))") this one will match any method with draw in the name and one or zero parameter
	 * @Before("execution(int *aw*(..))") this one will match any method that returns an integer and has aw in the method name, with one or zero parameters
	 * @Before("execution(* *(char, int)") this one will match any method that takes in a char and int as its paramaters
	 * @Before("execution(* *aw*(..,int))") this one will match any method with aw in its name, and has 1 or 2 paremeters, the second parameter being an int
	 * @Before("execution(protected * *(..)") this one will match any method with one or zero parameters that is protected
	 */
	
	@Before("execution(* *(..))")
	public void printBeforeAll(JoinPoint jp) {
		System.out.println("This should print before every method call");
	}
	
	@Before("execution(* com.example.myapp.ProxyApp.draw*(..))")
	public void buildEnthusiam(JoinPoint jp) {
		System.out.println("Builing Enthusiam");
	}
	
	@AfterThrowing("execution(* *e(..))")
	public void takeABreak(JoinPoint jp) {
		System.out.println("take a break");
		System.out.println("eat and take a nap");
		System.out.println(jp.getSourceLocation());
		System.out.println(jp.getThis());
	}
	
	@Around("execution(* scul*(..))")
	public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		//This top half before proceed acts as the @Before
		System.out.println("wetting the clay");
		System.out.println(pjp.getSignature());
		//Everything after proceed acts as the @After
		System.out.println(pjp.proceed()); //lets the method proceed with execution, the above will execute before the joinpoint
		//The rest will execute after
		System.out.println("cleaning the mess");
	}
}
