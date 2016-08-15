package rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@RestController
@Component
public class YoController {

    private static final String template = "Yo, %s!";
    private final AtomicLong counter = new AtomicLong();
    private String forecastIoKey = "";
    @Autowired
    public YoController(ApplicationArguments args) {
        forecastIoKey = args.getSourceArgs()[0];
    }

    @RequestMapping("/yo")
    public Yo greeting(@RequestParam(value="name", defaultValue="World") String name) {
        System.out.println("Forecast.io Key: " + forecastIoKey);
        return new Yo(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

