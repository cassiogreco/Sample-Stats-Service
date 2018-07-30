import configuration.ControllerConfiguration;
import configuration.RepositoryConfiguration;
import configuration.ServiceConfiguration;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication(scanBasePackageClasses = {ControllerConfiguration.class, ServiceConfiguration.class, RepositoryConfiguration.class})
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
