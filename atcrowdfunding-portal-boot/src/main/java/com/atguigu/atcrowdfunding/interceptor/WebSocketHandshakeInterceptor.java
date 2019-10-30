package com.atguigu.atcrowdfunding.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.atguigu.atcrowdfunding.domain.LoginUser;

/**
 * WebSocketHandshakeInterceptor 的配置（每次建立连接都会进行握手，会被此拦截器拦截）
 * @author Administrator
 *
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
    private static Logger logger = LoggerFactory.getLogger(HandshakeInterceptor.class);
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
    	System.out.println("========WebSocketHandshakeInterceptor==========beforeHandshake==========");
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                //使用userName区分WebSocketHandler，以便定向发送消息
               LoginUser user = (LoginUser) session.getAttribute("login");

                attributes.put("user",user);
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
