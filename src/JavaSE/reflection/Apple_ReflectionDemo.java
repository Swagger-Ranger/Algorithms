package JavaSE.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: Apple_ReflectionDemo
 * Author:   liufei32@outlook.com
 * Date:     2018/12/2 17:03
 * Description: 反射入门示例
 * Aha-eureka:
 *******************************************************************************/



/**
 * 1.反射的机制：在程序运行时，系统始终为所有的对象维护一个被称为“运行时的类型标识”，跟踪每个对象所属的类，JVM利用运行时类型信息选择相应的方法执行，并且通过Class类来访问这些信息。
 * 2.反射用途：
 *  增加程序的灵活性。 如struts中。请求的派发控制。当请求来到时。struts通过查询配置文件。找到该请求对应的action。已经方法。然后通过反射实例化action。并调用响应method。
 *  如果不适用反射，那么你就只能写死到代码里了.很少情况下是非用反射不可的。大多数情况下反射是为了提高程序的灵活性,因此一般框架中使用较多。因为框架要适用更多的情况。对灵活性要求较高
 *  */
public class Apple_ReflectionDemo {
    public int getPrice() {
        return price;
    }

    public void setPrice( int price ) {
        this.price = price;
    }

    private int price;


    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //正常调用
        Apple_ReflectionDemo apple = new Apple_ReflectionDemo();
        apple.setPrice(6);
        System.out.println("Apple's Price:" + apple.getPrice());

        //反射调用，获取类
        Class clazz = Class.forName("JavaSE.reflection.Apple_ReflectionDemo");//根据类名来使用Class获得反射的实例
        //获取类的实例，先获取构造器，再由构造器生成实例,也可以直接使用反射对象clazz.newInstance获取类的实例区别在于：
        //  通过 Constructor 对象创建类对象可以选择特定构造方法，而通过 Class 对象则只能使用默认的无参数构造方法
        Constructor constructor = clazz.getConstructor();
        Object appleObject = constructor.newInstance();
        Object appleObject2 = clazz.newInstance();
        //获得方法的实例，这里method和class是两个类，都是在java.lang.reflect包下的类,constructor也是
        //int.class是int类型的引用不是类，Integer则是包装类
        Method setPriceMethod = clazz.getMethod("setPrice", int.class);
        Method getPriceMethod = clazz.getMethod("getPrice");

        //使用方法，在获取到方法后需要调用方法的invoke方法并传入实例对象才能使用方法，不然只是获取了方法
        setPriceMethod.invoke(appleObject, 14);
        int applePrice = (int) getPriceMethod.invoke(appleObject);
        System.out.println("reflection-Apple's Price:" +applePrice );
        System.out.println("reflection-Apple's Price:" + getPriceMethod);//这里只获取了方法
    }
}
