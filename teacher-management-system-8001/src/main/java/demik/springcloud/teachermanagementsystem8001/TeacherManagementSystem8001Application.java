package demik.springcloud.teachermanagementsystem8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//本服务启动以后会注册到eureka注册中心
@EnableDiscoveryClient
@SpringBootApplication
//支持熔断机制
@EnableCircuitBreaker
public class TeacherManagementSystem8001Application {

	public static void main(String[] args) {
		SpringApplication.run(TeacherManagementSystem8001Application.class, args);
	}

}
