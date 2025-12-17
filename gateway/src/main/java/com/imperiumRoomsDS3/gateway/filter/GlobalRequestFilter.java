package com.imperiumRoomsDS3.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Filtro global placeholder para futura validación JWT y políticas transversales.
 * Actualmente solo registra información básica de la petición y deja pasar.
 */
@Component
public class GlobalRequestFilter implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(GlobalRequestFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        // Logging mínimo y punto de extensión futuro para JWT
        log.debug("Gateway request: {} {}", request.getMethod(), request.getURI());
        // Ejemplo: en el futuro, extraer y validar JWT del header Authorization
        // String authHeader = request.getHeaders().getFirst("Authorization");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // Ejecutar temprano pero después de pre-built filters de Gateway
        return Ordered.LOWEST_PRECEDENCE;
    }
}

