package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
public class App {
    static Properties prop = new Properties();
    static InputStream input = null;
    public static void main(String[] args) {
        String[] a = new String[1];
        try {
            input = new FileInputStream(".rest.properties");
            prop.load(input);
            a[0] = prop.getProperty("forecast.io.key");
            SpringApplication.run(App.class, a);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
