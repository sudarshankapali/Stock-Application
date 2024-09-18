package org.f1soft.gateway.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("apiRoutes")
public class ApiRoute {
    @Id
    private String id;

    private String routeIdentifier;

    private String uri;

    private String method;

    private String path;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getRouteIdentifier() {
        return routeIdentifier;
    }

    public void setRouteIdentifier(String routeIdentifier) {
        this.routeIdentifier = routeIdentifier;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
