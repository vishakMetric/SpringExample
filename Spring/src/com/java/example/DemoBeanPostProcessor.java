package com.java.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DemoBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		//System.out.println("After Init::"+arg1);
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		//System.out.println("Before Init::"+arg1);
		return arg0;
	}

}
