package com.java.aop.example;

public class LoggingBeforeAspect {
	
	public void add() {
		System.out.println("Before Aspect called");
	}
	
	public void substract() {
		System.out.println("After Aspect is Called");
	}

}
