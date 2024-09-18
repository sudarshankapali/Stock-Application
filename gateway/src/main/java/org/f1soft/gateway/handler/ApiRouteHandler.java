package org.f1soft.gateway.handler;

import org.f1soft.gateway.config.GatewayRoutesRefresher;
import org.f1soft.gateway.entity.ApiRoute;
import org.f1soft.gateway.service.RouteService;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class ApiRouteHandler {
    private final RouteService routeService;
    private final RouteLocator routeLocator;
    private final GatewayRoutesRefresher gatewayRoutesRefresher;

    public ApiRouteHandler(RouteService routeService, RouteLocator routeLocator,GatewayRoutesRefresher gatewayRoutesRefresher) {
        this.routeService = routeService;
        this.routeLocator = routeLocator;
        this.gatewayRoutesRefresher = gatewayRoutesRefresher;
    }

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        Mono<ApiRoute> apiRoute = serverRequest.bodyToMono(ApiRoute.class);
        return apiRoute.flatMap(route ->
                ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(routeService.create(route), ApiRoute.class));
    }

    public Mono<ServerResponse> refreshRoutes(ServerRequest serverRequest) {
        gatewayRoutesRefresher.refreshRoutes();
        return ServerResponse.ok().body(BodyInserters.fromObject("Routes reloaded successfully"));
    }
}
