package datastructures;

import java.util.Locale;
import java.util.Properties;

/**
 * @author dongwq
 * @date 2025/05/2025/5/6
 **/
public class TestStash {

    private static Properties staticProperties ;

    public static void main(String[] args) {
        properties(args);
        System.out.println("hello");
        String workDir = System.getProperty("user.dir");
        System.out.println(System.getProperty("user.dir"));
        String path = staticProperties.getProperty("jfile");
        System.out.println(path);
        String separator = System.getProperty("file.separator");
        System.out.println(workDir+separator+path);
    }


    private static void properties(String[] args){
        Properties properties = new Properties();
        for(String arg:args){
            String[] split = arg.split("=");
            properties.setProperty(split[0].trim(),split.length>1?split[1].trim():"");
        }
        staticProperties = properties;
    }
}
