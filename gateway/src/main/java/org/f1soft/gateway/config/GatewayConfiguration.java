package org.f1soft.gateway.config;

import org.f1soft.gateway.service.ApiRouteLocator;
import org.f1soft.gateway.service.RouteService;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteService routeService, RouteLocatorBuilder routeLocatorBuilder){
        return new ApiRouteLocator(routeLocatorBuilder,routeService);
    }
}
