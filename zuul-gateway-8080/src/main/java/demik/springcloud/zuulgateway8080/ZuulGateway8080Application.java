package demik.springcloud.zuulgateway8080;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScans;

@EnableZuulProxy
@SpringBootApplication(scanBasePackages = {"demik.springcloud.entity.feignservice", "demik.springcloud.zuulgateway8080"})
@EnableFeignClients(basePackages =
		{"demik.springcloud.entity.feignservice","demik.springcloud.zuulgateway8080"})
public class ZuulGateway8080Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGateway8080Application.class, args);
	}

}
