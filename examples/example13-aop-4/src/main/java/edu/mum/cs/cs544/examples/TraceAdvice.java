package edu.mum.cs.cs544.examples;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TraceAdvice {
	@Around("execution(* edu.mum.cs.cs544.examples.AccountService.*(..))")
	public Object profile(ProceedingJoinPoint call) throws Throwable {
		StopWatch clock = new StopWatch("");
		clock.start(call.toShortString());
		
		Object object = call.proceed();
		
		clock.stop();
		
		System.out.println(clock.prettyPrint());
		
		return object;
	}
}