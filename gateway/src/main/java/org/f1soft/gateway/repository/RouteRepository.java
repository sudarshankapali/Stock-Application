package org.f1soft.gateway.repository;

import org.f1soft.gateway.entity.ApiRoute;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RouteRepository extends ReactiveCrudRepository<ApiRoute,String> {
}
