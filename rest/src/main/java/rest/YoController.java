package rest;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YoController {

    private static final String template = "Yo, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/yo")
    public Yo greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Yo(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

