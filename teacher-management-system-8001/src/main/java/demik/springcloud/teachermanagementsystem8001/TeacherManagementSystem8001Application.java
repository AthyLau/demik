package demik.springcloud.teachermanagementsystem8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
//本服务启动以后会注册到eureka注册中心
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"demik.springcloud.entity.feignservice", "demik.springcloud.teachermanagementsystem8001"})
@EnableFeignClients(basePackages =
		{"demik.springcloud.entity.feignservice","demik.springcloud.teachermanagementsystem8001"})
public class TeacherManagementSystem8001Application {

	public static void main(String[] args) {
		SpringApplication.run(TeacherManagementSystem8001Application.class, args);
	}

}
