package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * @author loris
 * @date 2018/4/10 22:01
 */
public class MethodReflect {

    public static void main(String[] args) throws Exception {
//        String s="loris";
//        charAt(s,2);

//        Method method = MethodReflect.class.getMethod("test", String.class, int.class);
//        Object obj=method.invoke(new MethodReflect(),new Object[]{"loris",2});
//        System.out.println(obj);


//        String className="com.loris.util.test.reflect.TestArguments";
//        Class claz=Class.forName(className);
//        Method mainMethod=claz.getMethod("main",String[].class);
//        Object[] objects=new Object[1];
//        objects[0]=new String[]{"111","222","333"};
//
//        mainMethod.invoke(null,(Object)new String[]{"111","222","333"});

        int[] a1=new int[]{1,2,3};
        int[][] a2=new int[2][2];
        a2[0][0]=1;
        a2[0][1]=2;
        a2[1][0]=3;
        a2[1][1]=4;

        printObject(a1);
        printObject(a2);
        printObject("loris");
    }


    public static void charAt(String str, int index) throws Exception {
        Method methodCharAt = str.getClass().getMethod("charAt", int.class);
        System.out.println(methodCharAt.invoke(str, index));
    }


    public char test(String str, int index) {
        return str.charAt(index);
    }

    public static void printObject(Object obj){
        Class clazz=obj.getClass();
        if(clazz.isArray()){
            int len = Array.getLength(obj);
            for(int i=0;i<len;i++){
                System.out.println(Array.get(obj,i));
            }
        }else{
            System.out.println(obj);
        }
    }

}

class TestArguments {
    public static void main(String[] args) {
        System.out.println("我是TestArguments类的main方法");
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}