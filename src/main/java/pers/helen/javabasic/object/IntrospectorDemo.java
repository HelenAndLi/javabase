package pers.helen.javabasic.object;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntrospectorDemo {

    public static void main(String[] args) throws IntrospectionException{
        User u1 = new User(66, "南南");
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor propertyDescriptor : propertyDescriptors){
            System.out.println("字段：" + propertyDescriptor.getName());
            // 读取
            try{
                Method readMethod = propertyDescriptor.getReadMethod();
                Object r = readMethod.invoke(u1);
                System.out.println("读取：" + r);
            }catch(IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }
        // readMethod略，跟属性描述器类似
    }
}
