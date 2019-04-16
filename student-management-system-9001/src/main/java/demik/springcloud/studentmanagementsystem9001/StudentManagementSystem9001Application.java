package demik.springcloud.studentmanagementsystem9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
//本服务启动以后会注册到eureka注册中心
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"demik.springcloud.entity.feignservice", "demik.springcloud.studentmanagementsystem9001"})
@EnableFeignClients(basePackages =
		{"demik.springcloud.entity.feignservice","demik.springcloud.studentmanagementsystem9001"})
public class StudentManagementSystem9001Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystem9001Application.class, args);
	}

}
