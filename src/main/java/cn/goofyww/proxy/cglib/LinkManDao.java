package cn.goofyww.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * cglib 实际上是生成了目标类的子类来增强
 */
public class LinkManDao {

    public void save() {
        System.out.println("持久层：联系人保存....");
    }

    public static void main(String[] args) {

        final LinkManDao linkManDao = new LinkManDao();

        // 创建cglib核心对象
        Enhancer enhancer = new Enhancer();

        // 设置父类
        enhancer.setSuperclass(linkManDao.getClass());

        /**
         * 当你调用目标方法时，实质上是调用该方法
         * intercept四个参数：
         * proxy:代理对象
         * method:目标方法
         * args：目标方法的形参
         * methodProxy:代理方法
         */
        // 设置回调
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("记录日志");
            return method.invoke(linkManDao, objects);
        });

        // 创建代理对象
        LinkManDao proxy = (LinkManDao) enhancer.create();
        proxy.save();
    }
}
