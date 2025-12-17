package com.imperiumRoomsDS3.gateway.exception;

/*
 * GlobalErrorWebExceptionHandler desactivado intencionalmente.
 * Para reactivar: restaurar la implementación original o eliminar este comentario.
 * Esto permite que Spring Cloud Gateway use su manejo de errores por defecto.
 */

/*
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
@Order(-2)
public class GlobalErrorWebExceptionHandler implements ErrorWebExceptionHandler {

    private final GlobalErrorAttributes errorAttributes;
    private final ObjectMapper objectMapper;

    public GlobalErrorWebExceptionHandler(GlobalErrorAttributes errorAttributes, ObjectMapper objectMapper) {
        this.errorAttributes = errorAttributes;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        // Construir ServerRequest a partir del exchange
        ServerRequest request = ServerRequest.create(exchange, java.util.List.of());
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(request, ErrorAttributeOptions.defaults());
        int status = (int) attributes.getOrDefault("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.valueOf(status));
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        try {
            byte[] body = objectMapper.writeValueAsBytes(attributes);
            return response.writeWith(Mono.just(response.bufferFactory().wrap(body)));
        } catch (JsonProcessingException e) {
            byte[] fallback = ("{\"status\":" + status + ",\"error\":\"Unexpected Error\"}").getBytes(StandardCharsets.UTF_8);
            return response.writeWith(Mono.just(response.bufferFactory().wrap(fallback)));
        }
    }
}
*/
