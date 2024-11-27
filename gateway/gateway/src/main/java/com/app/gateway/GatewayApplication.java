package com.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}

//if we want to configure mapping details using bean instead of using yml config
//@Bean
//public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//	return builder.routes()
//			.route(r -> r.path("/payment-provider/**")
//					//.filters(f -> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
//					.uri("lb://PAYMENT-SERVICE"))  // Use "lb://" if using service discovery
//			.route(r -> r.path("/amazon-payment/**")
//					//.filters(f -> f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
//					.uri("lb://SHOPPING-SERVICE")) // Use "lb://" if using service discovery
//			.build();
//}
//	@Bean
//	public RestClient.Builder restClientBuilder() {
//		return RestClient.builder();
//	}
//}
