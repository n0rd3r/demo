package getjson;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.*;
import com.cedarsoftware.util.io.*;

@Component
public class WxSchedule {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private JedisPool pool;

    public void WxSchedule() {
        try {
            String vcap_services = System.getenv("VCAP_SERVICES");
            if (vcap_services != null && vcap_services.length() > 0) {
                // parsing rediscloud credentials
                Object obj = JsonReader.jsonToJava(vcap_services);
                /*
                JsonNode rediscloudNode = root.getNode("rediscloud");
                JsonNode credentials = rediscloudNode.getNode(0).getNode("credentials");

                pool = new JedisPool(new JedisPoolConfig(),
                        credentials.getStringValue("hostname"),
                        Integer.parseInt(credentials.getNumberValue("port")),
                        Protocol.DEFAULT_TIMEOUT,
                        credentials.getStringValue("password"));
                */
            }
        } catch (Exception ex) {
            // vcap_services could not be parsed.
        }
    }

    @Scheduled(fixedRate = 300000)
    public void fetchWeather() {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = System.getenv("FORECAST_IO_KEY");
        Wx wx = restTemplate.getForObject("https://api.forecast.io/forecast/" + apiKey + "/40.0992,-83.1141", Wx.class);
        log.info(wx.toString());
        log.info("TEMP: " + wx.getCurrently().getTemperature().toString());
        Jedis jedis = pool.getResource();
        jedis.set("temp", wx.getCurrently().getTemperature().toString());
        //String value = jedis.get("foo");
        pool.returnResource(jedis);
    }
}