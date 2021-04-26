package colval.qc.ca.demo_thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication(exclude = ThymeleafAutoConfiguration.class)
public class DemoThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoThymeleafApplication.class, args);
    }

}
