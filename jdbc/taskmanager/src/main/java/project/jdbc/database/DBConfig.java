package project.jdbc.database;

import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    private static Properties props = new Properties();

    static {
        try (InputStream input = DBConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            props.load(input); // load credentials from file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return props.getProperty("db.url");
    }

    public static String getUser() {
        return props.getProperty("db.user");
    }

    public static String getPassword() {
        return props.getProperty("db.password");
    }
}
