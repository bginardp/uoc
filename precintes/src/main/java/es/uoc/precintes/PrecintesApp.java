package es.uoc.precintes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(PrecintesAppConfig.class)
public class PrecintesApp extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PrecintesApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PrecintesApp.class, args);
    }

}
