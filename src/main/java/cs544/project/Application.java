package cs544.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//By using Springboot, we needn't any XML config, Java config
// Doesn't have classpath scanning
// When we run the application, Spring start from package which contains the MainApplication
// , and it automatically scanning this package and everything that is underneath
//How does the component being scanned?
//=> We need to declare @ComponentScan(package) and given to Spring which Classpath need to scan 
// , including the outside reference classpath(package)

@SpringBootApplication
@ComponentScan(basePackages = "edu.miu.common, cs544.project")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
