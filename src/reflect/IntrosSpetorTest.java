package reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author loris
 * @date 2018/4/12 20:34
 */
public class IntrosSpetorTest {

    public static void main(String[] args) throws Exception {
        //通过内省的方法获取javabean的属性值
        ReflectPoint reflectPoint = new ReflectPoint(2, 3);
        String propertyName = "x";
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, reflectPoint.getClass());
        Method getMethod = pd.getReadMethod();
        Object x = getMethod.invoke(reflectPoint);
        System.out.println(x);


        //设置javabean的属性值

        Method setMethod = pd.getWriteMethod();
        setMethod.invoke(reflectPoint,8);
        System.out.println(reflectPoint.getX());

    }

}
