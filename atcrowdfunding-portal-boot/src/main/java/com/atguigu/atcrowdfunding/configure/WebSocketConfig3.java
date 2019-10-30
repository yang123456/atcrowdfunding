package com.atguigu.atcrowdfunding.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.atguigu.atcrowdfunding.handler.SystemWebSocketHandler;
import com.atguigu.atcrowdfunding.interceptor.WebSocketHandshakeInterceptor;

/**
 * 配置WebSocket
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig3 extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
		webSocketHandlerRegistry.addHandler(systemWebSocketHandler(), "/webSocketServer")
				.addInterceptors(new WebSocketHandshakeInterceptor());
		webSocketHandlerRegistry.addHandler(systemWebSocketHandler(), "/sockjs/webSocketServer")
				.addInterceptors(new WebSocketHandshakeInterceptor()).setAllowedOrigins("*").withSockJS();
	}

	@Bean
	public WebSocketHandler systemWebSocketHandler() {
		return new SystemWebSocketHandler();
	}

}
