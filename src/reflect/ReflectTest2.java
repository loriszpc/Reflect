package reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

/**
 * @author loris
 * @date 2018/4/11 21:31
 */
public class ReflectTest2 {

    public static void main(String[] args) throws Exception {

//        FileInputStream fis = new FileInputStream(new File("config.properties"));
//        Properties prop = new Properties();
//        prop.load(fis);
//        fis.close();
//
//        String className = prop.getProperty("className");
//
//        System.out.println(className);
//
//        String relativePath = System.getProperty("user.dir");
//        System.out.println(Class.class.getClass().getResource("/").getPath() );

        /**
         * 获取一个文件同样可以使用类加载器,
         * 类加载器获取文件的顺序是从根目录下开始找起
         */

        InputStream is=ReflectTest2.class.getClassLoader().getResourceAsStream("reflect/config.properties");

        //由类提供的读取配置文件的方式获取配置文件是通过相对路径进行获取的
        ReflectTest2.class.getResourceAsStream("config.properties");


        Properties prop = new Properties();
        prop.load(is);
        is.close();
        String className = prop.getProperty("className");
//
//        String className = prop.getProperty("className");

        Collection collection = (Collection) Class.forName(className).newInstance();
        ReflectPoint point1 = new ReflectPoint(1, 1);
        ReflectPoint point2 = new ReflectPoint(2, 2);
        ReflectPoint point3 = new ReflectPoint(1, 1);

        collection.add(point1);
        collection.add(point2);
        collection.add(point3);
        collection.add(point1);

//        point1.y=3;

        collection.remove(point1);

        System.out.println(collection.size());
    }

}
