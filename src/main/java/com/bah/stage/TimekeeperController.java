package com.bah.stage;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.Clock;

@RestController
public class TimekeeperController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Greeting index(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/time")
    public StageTime time() {
      Clock clock = Clock.systemDefaultZone();
      return new StageTime(counter.incrementAndGet(), String.valueOf(clock.millis()));
    }
}
