package github.com.JoaoBraga1996.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class MscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscloudgatewayApplication.class, args);

	}

	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/clientes/**").uri("lb://msclientes"))
				.route(r -> r.path("/cartoes/**").uri("lb://mscartoes"))
				.route(r -> r.path("/avaliacoes-credito/**").uri("lb://msavaliadorcredito"))
				.build();

	}
}


/* RouteLocator: É uma interface do Spring Cloud Gateway que representa um localizador de rota. Ele define o método routes() para configurar as rotas.

routes(RouteLocatorBuilder builder): Este método é usado para construir as rotas. O parâmetro builder é usado para criar as rotas de forma declarativa.

.route(r -> r.path("/clientes/**").uri("lb://msclientes")): Aqui, estamos configurando uma rota. Estamos dizendo que qualquer 
solicitação que corresponda ao padrão /clientes/** deve ser encaminhada para o serviço registrado com o nome 
msclientes. O prefixo lb:// é usado para indicar que estamos encaminhando para um serviço registrado no balanceador de carga.


.build(): Este método finaliza a construção das rotas e retorna o objeto RouteLocator configurado com as rotas especificadas.*/