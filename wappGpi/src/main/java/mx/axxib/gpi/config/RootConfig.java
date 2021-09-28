package mx.axxib.gpi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.PropertySource;


@Configuration
@Import(value = { ValidationConfig.class})  
@ComponentScan(basePackages = { "mx.axxib.gpi.eml", "mx.axxib.gpi.serv"}, excludeFilters = @ComponentScan.Filter(Controller.class))

public class RootConfig {

}
