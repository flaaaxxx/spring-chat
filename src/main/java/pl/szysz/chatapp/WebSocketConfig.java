package pl.szysz.chatapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // utworzenie Endpint przez ktory mozna sie odwolac do protokolu STOMP
        registry.addEndpoint("/chat");
    }

    // umożliwia skonfigurowanie brokera
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // wlacza protokol STOMP sluzacy do wymiany wiadomosci tekstowych
        // "/topic" - nazwa brokera
        registry.enableSimpleBroker("/topic");
        // miejsce, do ktorego trzeba sie odwolac aby dostac sie do kolejki
        // jesli korzysta sie z zewnetrzenej aplikacji,
        // np przez javaScript nalezy najpierw odwolac sie do "/app" a potem do "/topic"
        registry.setApplicationDestinationPrefixes("/app");
    }
}




//
//import org.springframework.context.annotation.Configuration;
//        import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//        import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//        import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//        import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker // umożliwia korzystanie z WebSocket
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/chat");
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/topic"); // podajemy gdzie nasze wiadomosci maja sie znajdowac
//        registry.setApplicationDestinationPrefixes("/app");
//
//
//    }
//}