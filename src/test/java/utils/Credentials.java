package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Credentials {
    public static String username;
    public static String password;

    public static String wrongPassword;
    public static Properties properties = new Properties();
    public static void properties(){
        try (InputStream inputStream = new FileInputStream("src/config.properties")) {
            properties.load(inputStream);
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            wrongPassword = properties.getProperty("wrongPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
