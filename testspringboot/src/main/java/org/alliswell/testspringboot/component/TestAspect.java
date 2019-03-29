package org.alliswell.testspringboot.component;

import org.alliswell.testspringboot.annotation.TestAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Order(-99)
@Component
public class TestAspect {

    TestAspect() {
        System.out.println("TestAspect 加载了...");
    }

    // 将“@TestAnnotation”注解在方法上才有效，注解在类型则无效
    @Before("@annotation(org.alliswell.testspringboot.annotation.TestAnnotation)")
    public void beforeTest(JoinPoint point) {
        // Start-通过point获取注解的属性
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        TestAnnotation testAnnotation = method.getAnnotation(TestAnnotation.class);
        String name = testAnnotation.name();
        // End-通过point获取注解的属性
        System.out.println("beforeTest:" + name);
    }

    // 与上面的作用一样，注解的属性可以直接获取而不再需要通过point来取
    @Before("@annotation(test)")
    public void beforeTest(JoinPoint point, TestAnnotation test) {
        System.out.println("beforeTest:" + test.name());
    }

    @Before("execution(* org.alliswell.testspringboot.controller.TestSpringBootController.*(..))")
    public void beforeTest1(JoinPoint point) {
        System.out.println("beforeTest1:所有public方法");
    }

    @Before("within(org.alliswell.testspringboot..*)")
    public void beforeTest2(JoinPoint point) {
        System.out.println("beforeTest2:所有public方法");
    }

//    // 将“@TestAnnotation”注解在方法上则无效，注解在类型才有效
//    @Before("@within(org.alliswell.testspringboot.annotation.TestAnnotation)")
//    public void beforeTest3(JoinPoint point) {
//        System.out.println("beforeTest3:所有public方法");
//    }

    // 将“@TestAnnotation”注解在方法上则无效，注解在类型才有效
    @Before(value = "@within(test)")
    public void beforeTest3(JoinPoint point, TestAnnotation test) {
        System.out.println("beforeTest3:所有public方法" + test.name());
    }

//    // 始终无效，不知为何--可能是新版本特性
//    @Before(value="@annotation(test) && @args(org.alliswell.testspringboot.annotation.TestAnnotation)")
//    public void before1(JoinPoint jp, TestAnnotation test) {
//        System.out.println("===param1:");
//    }

    // 与mybatis中@Param的功能一样
    @Before(value="@annotation(test) && args(param,param1)", argNames = "jp,test,param,param1")
    public void before2(JoinPoint jp, TestAnnotation test, String param, String param1) {
        System.out.println("===param2:param=" + param + ",param1=" + param1 + ",TestAnnotation.name=" +test.name());
    }

}
