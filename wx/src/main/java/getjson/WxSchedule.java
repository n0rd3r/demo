package getjson;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class WxSchedule {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Scheduled(fixedRate = 300000)
    public void fetchWeather() {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = System.getenv("FORECAST_IO_KEY");
        Wx wx = restTemplate.getForObject("https://api.forecast.io/forecast/" + apiKey + "/40.0992,-83.1141", Wx.class);
        log.info(wx.toString());
        log.info("TEMP: " + wx.getCurrently().getTemperature().toString());
    }
}