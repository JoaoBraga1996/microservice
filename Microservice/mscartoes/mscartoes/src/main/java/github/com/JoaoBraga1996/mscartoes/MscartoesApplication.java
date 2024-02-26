package github.com.JoaoBraga1996.mscartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MscartoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscartoesApplication.class, args);
	}

}
