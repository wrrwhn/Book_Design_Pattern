package proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.nio.file.Paths;

/**
 * 代理工厂类
 *
 * @author qingju.yao
 * @date 2020/04/17
 */
public class PersonProxyFactory {

    public static PersonService getInstance() {

        // Debug 模式，将代理类输出至本地环境
        String path = Paths.get("target", "cglib").toAbsolutePath().normalize().toString();
        path = "D:\\work\\git\\yao\\up\\Book_Design_Pattern\\target\\test-classes\\proxy\\cglib";
        System.out.println(path);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("Start");
                Object result = null;
                try {
                    result = methodProxy.invokeSuper(o, objects);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                System.out.println("End");
                return result;
            }
        });

        return (PersonService) enhancer.create();
    }
}
