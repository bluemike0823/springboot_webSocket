package com.websocket.server.config;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//    這個方法用於配置訊息代理。
//    enableSimpleBroker("/topic") 告訴系統啟用簡單的訊息代理，並將其設置為處理以 /topic 開頭的訊息主題。
//    這意味著客戶端可以訂閱以 /topic 為前綴的主題來接收來自伺服器的消息。
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }

//    這個方法用於註冊 STOMP 端點，這是客戶端連接 WebSocket 的入口。
//addEndpoint("/endPointChatroom") 創建了一個新的端點，客戶端將通過這個端點進行連接。
//withSockJS() 表示支援 SockJS，這是一個提供了回退機制的 JavaScript 庫，可以在某些瀏覽器或網路環境不支援 WebSocket 的情況下使用。
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endPointChatroom").withSockJS();
    }
}


