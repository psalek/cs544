package edu.mum.cs.cs544.examples;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceAdvice {
	@Before("execution(* edu.mum.cs.cs544.examples.AccountService.*(..)) && args(accountNumber, amount)")
	public void tracebeforemethod(JoinPoint joinpoint, long accountNumber, double amount) {
		System.out.print("before execution of method " + joinpoint.getSignature().getName());
		System.out.println(", Account# " + accountNumber + ", Amount = " + amount);
	}

	@After("execution(* edu.mum.cs.cs544.examples.AccountService.*(..))")
	public void traceaftermethod(JoinPoint joinpoint) {
		System.out.println("after execution of method " + joinpoint.getSignature().getName());
	}
}