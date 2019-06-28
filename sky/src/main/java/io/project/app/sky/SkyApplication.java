package io.project.app.sky;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableReactiveMongoRepositories("io.project.app.sky.repositories")
@ComponentScan(basePackages = {"io.project"})
@EntityScan("io.project.app.sky.domain")
public class SkyApplication {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(SkyApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
