package com.java.example;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.aop.example.LoggingBeforeAspect;

	public class App {
		public static void main(String[] args) throws SQLException {
			//ApplicationContext context = new FileSystemXmlApplicationContext(
			//		"C:\\SpringExample\\Spring\\WebContent\\WEB-INF\\applicationContext.xml");
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

			HelloWorld obj = (HelloWorld) context.getBean("helloBean");
			obj.getMachineDetails();
			//AbstractBean aBean = (AbstractBean) context.getBean("patentbean");
			//System.out.println(aBean.getType());
			//LoggingBeforeAspect log = (LoggingBeforeAspect) context.getBean("aspectBean");
			//log.add(); log.substract();
		
			
			//CustomerService customer = (CustomerService)context.getBean("customer");
			
			String name=null;
			if("vishak".equals(name)) {
				System.out.println("Into if!!!");
			} else {
				System.out.println("Into else!!!");
			}
			((AbstractApplicationContext) context).close();
		}
	}

