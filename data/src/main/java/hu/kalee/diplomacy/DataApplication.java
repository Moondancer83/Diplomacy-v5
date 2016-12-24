package hu.kalee.diplomacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * DataApplication.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
@SpringBootApplication
@EnableJpaRepositories
public class DataApplication {
    public static void main(final String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }
}
