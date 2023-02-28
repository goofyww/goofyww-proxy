package cn.goofyww.proxy.jdk.impl;

import cn.goofyww.proxy.jdk.UserDao;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Proxy;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("持久层：用户保存");
    }

    @Override
    public Boolean edit() {
        System.out.println("持久层：用户编辑");
        return true;
    }

    public static void main(String[] args) {
        final UserDao userDao = new UserDaoImpl();

        // newProxyInstance的三个参数解释：
        // 参数1：代理类的类加载器，同目标类的类加载器
        // 参数2：代理类要实现的接口列表，同目标类实现的接口列表
        // 参数3：回调，是一个InvocationHandler接口的实现对象，当调用代理对象的方法时，执行的是回调中的invoke方法
        // proxy为代理对象
        UserDao userDaoProxy = (UserDao) Proxy.newProxyInstance(
                userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),
                (proxy, method, arg) -> {
                    System.out.println("记录日志");
                    return method.invoke(userDao, arg);
                }
        );

        // 代理对象执行方法
        userDaoProxy.save();
        userDaoProxy.edit();
    }

}
