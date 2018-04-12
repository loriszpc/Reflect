package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author loris
 * @date 2018/4/10 21:07
 */
public class reflectTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

//        Constructor constructor = String.class.getConstructor(StringBuffer.class);
//
//        System.out.println(constructor.getName());
//
//        String test = (String) constructor.newInstance(new StringBuffer("abc"));
//
//        System.out.println(test.charAt(2));


//        ReflectPoint pt1=new ReflectPoint(2,3);
//
//        Field fieldY=pt1.getClass().getField("y");
//        // fieldY 不是对象身上的变量，
//        //而是类上的，要用fieldY所属的对象再去获取值
//        Object y=fieldY.get(pt1);
//        System.out.println(y);
//
//        Field fieldX=pt1.getClass().getDeclaredField("x");
//        fieldX.setAccessible(true);
//        System.out.println(fieldX.get(pt1));

        //将ReflectPoint字符串类型属性值中的b改成a

        changeStringValue(new ReflectPoint(2,3));
    }


    public static void changeStringValue(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            //字节码用等号进行判断
            if (field.getType() == String.class) {
                //如果当前字段类型为字符串获取字段值
                String value = (String) field.get(obj);
                value = value.replace("b", "a");
                //替换之后再将新的字符串赋值给当前的字段
                field.set(obj,value);
            }
        }

        //检验字段值是否切换过来

        for (Field field : fields) {
            field.setAccessible(true);
            //字节码用等号进行判断
            if (field.getType() == String.class) {
                String value = (String) field.get(obj);
                System.out.println(value);
            }
        }

    }

}
