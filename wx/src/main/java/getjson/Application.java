package getjson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Wx wx = restTemplate.getForObject("https://api.forecast.io/forecast/[FORECASTIOKEYGOESHERE]/40.0992,-83.1141", Wx.class);
        log.info(wx.toString());
        log.info("TEMP: " + wx.getCurrently().getTemperature().toString());
    }
}
