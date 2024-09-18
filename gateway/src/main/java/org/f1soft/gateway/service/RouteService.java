package org.f1soft.gateway.service;

import org.f1soft.gateway.entity.ApiRoute;
import org.f1soft.gateway.repository.RouteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class RouteService {
    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Flux<ApiRoute> getAll(){
        return this.routeRepository.findAll();
    }

    public Mono<ApiRoute> create(ApiRoute apiRoute) {
        Mono<ApiRoute> route = this.routeRepository.save(apiRoute);
        return route;
    }

    public Mono<ApiRoute> getById(String id){
        return this.routeRepository.findById(id);
    }
}
