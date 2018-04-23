/*package com.blog.blogback.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSocketMessageBroker  // enable broker based stomp messaging
@ComponentScan(basePackages="com.blog")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {
	@Override
	public void configureClientInboundChannel(ChannelRegistration  registration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureClientOutboundChannel(ChannelRegistration registration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry configurer) {
		System.out.println("CONFIGURE MESSAGE BROKER REGISTRY");
		configurer.enableSimpleBroker("/queue/", "/topic/");
		configurer.setApplicationDestinationPrefixes("/app");
		
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		System.out.println("REGISTER STOMP ENDPOINTS...");
		registry.addEndpoint("/chatmodule").withSockJS();
		
	}
}
*/