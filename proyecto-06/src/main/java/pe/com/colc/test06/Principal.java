package pe.com.colc.test06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Principal {

    public static void main(String[] args) {
        SpringApplication.run(Principal.class, args);
        //@EnableJpaRepositories
        //@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
    }

}
