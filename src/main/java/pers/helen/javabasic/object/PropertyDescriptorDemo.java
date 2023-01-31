package pers.helen.javabasic.object;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyDescriptorDemo {

    public static void main(String[] args) throws IntrospectionException{

        User u1 = new User(11,"菲儿");
        Field[] fields = u1.getClass().getDeclaredFields();
        for(Field field : fields){
            //1、反射
            System.out.println("字段："+field.getName());

            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), User.class);
            // 获取字段的get方法
            Method readMethod = propertyDescriptor.getReadMethod();
            // 读取
            try{
                Object r = readMethod.invoke(u1);
                System.out.println("读取："+r);
            }catch(IllegalAccessException | InvocationTargetException e){
                e.printStackTrace();
            }
        }

        // 2、PropertyDescriptor
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("username", User.class);
        // 获取userId的set方法
        Method writeMethod = propertyDescriptor.getWriteMethod();
        try{
            // 设置值
            writeMethod.invoke(u1, "南南");
            System.out.println("设置后："+u1);
        }catch(IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }

    }
}
