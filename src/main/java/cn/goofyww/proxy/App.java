package cn.goofyww.proxy;

import java.io.IOException;

/**
 * AOP思想：
 * 基于代理思想，对原来目标对象，创建代理对象，在不修改原对象代码情况下，通过代理对象，调用增强功能的代码，从而对原有业务方法进行增强 ！
 * <p>
 * AOP应用场景：
 * 场景一： 记录日志
 * 场景二： 监控方法运行时间 （监控性能）
 * 场景三： 权限控制
 * 场景四： 缓存优化（第一次调用查询数据库，将查询结果放入内存对象， 第二次调用， 直接从内存对象返回，不需要查询数据库 ）
 * 场景五： 事务管理（调用方法前开启事务， 调用方法后提交关闭事务 ）
 * <p>
 * AOP的实现原理，那Spring中AOP是怎么实现的呢？Spring中AOP的有两种实现方式：
 * 1、JDK动态代理
 * 2、Cglib动态代理
 */
public class App {

    public static void main(String args[]) throws IOException {
        System.out.println("Hello Proxy");
    }

}
