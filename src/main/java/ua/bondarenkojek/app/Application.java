package ua.bondarenkojek.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "ua.bondarenkojek")
@EnableJpaRepositories("ua.bondarenkojek.repository")
@EntityScan("ua.bondarenkojek.models")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
}
