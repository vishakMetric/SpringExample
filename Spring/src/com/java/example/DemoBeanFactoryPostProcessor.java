package com.java.example;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory.containsBean("helloBean")); 
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("helloBean");
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		
		propertyValues.add("name", "Vishak");
	}

}
