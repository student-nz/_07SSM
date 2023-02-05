package com.yjxz.spring.test;

import com.yjxz.spring.aop.annotation.Calculator;
import com.yjxz.spring.aop.annotation.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AOPByAnnotationTest {

    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(10, 1);
    }

}
