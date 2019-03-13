package demik.springcloud.zuulgateway8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulGateway8080Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGateway8080Application.class, args);
	}

}
