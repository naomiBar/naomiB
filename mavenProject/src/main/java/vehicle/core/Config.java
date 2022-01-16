package vehicle.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan //scans classes in base package
@PropertySource("application.properties")
public class Config {
	
}
