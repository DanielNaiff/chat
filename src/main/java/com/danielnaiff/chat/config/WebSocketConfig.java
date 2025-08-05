package com.danielnaiff.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //Define o endpoint que os clientes irão usar para se conectar via WebSocket: "/ws"
    //withSockJS() tenta usar WebSocket e, se não conseguir, usa alternativas como long polling
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws").withSockJS();
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //Define que mensagens enviadas pelos clientes com prefixo /app serão roteadas para os métodos no servidor anotados com @MessageMapping
        registry.setApplicationDestinationPrefixes("/app");

        //Habilita um "broker" simples em memória para tratar mensagens de saída com destino /topic.
        //Esse broker gerencia os assinantes e publica as mensagens para todos os clientes conectados.
        registry.enableSimpleBroker("/topic");
    }
}
