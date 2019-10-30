package com.atguigu.atcrowdfunding.handler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class SystemWebSocketHandler implements WebSocketHandler {
	private static final Logger logger;

	private static final HashSet<WebSocketSession> users;

	static {
		users = new HashSet<>();
		logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);
	}

//    @Autowired
//    IWebSocketService webSocketService;

	@Override
	public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
		users.add(webSocketSession);
		System.out.println("===SystemWebSocketHandler====afterConnectionEstablished===users的大小="+users.size()+"id="+webSocketSession.getId());
	}

	@Override
	public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage)
			throws Exception {

	}

	@Override
	public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

		if (webSocketSession.isOpen()) {
			webSocketSession.close();
		}
		logger.info("handleTransportError ==========websocket连接关闭......id="+webSocketSession.getId());
		users.remove(webSocketSession);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
		logger.info("afterConnectionClosed ========websocket 连接关闭.....id="+webSocketSession.getId());
		users.remove(webSocketSession);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 向所有用户推送消息
	 *
	 * @param message
	 */
	public void sendMessageToUsers(TextMessage message) {
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
//                    synchronized(user) {
					user.sendMessage(message);
//                    }
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 指定用户推送消息
	 *
	 * @param roleId
	 * @param message
	 */
	public void sendMessageToUser(int roleId, TextMessage message) {
//		System.err.println("线程名："+Thread.currentThread().getName()+"=======sendMessageToUser========="+message);
		for (WebSocketSession user : users) {
//			LoginUser loginUser = (LoginUser) user.getAttributes().get("user");
//			if (loginUser.getRoleId() == roleId || loginUser.getRoleId() == 0) {
				try {
					if (user.isOpen()) {
//						synchronized (loginUser) {
							user.sendMessage(message);
//						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
//			}
		}
	}

	/**
	 * 查看是否存在未处理的举报
	 */
	public void doTask() {
		boolean hasinfo = false;
		Random random=new Random();
		/**
		 * 逻辑处理代码段
		 **/
		//推送内容
//		if (hasinfo) {
			sendMessageToUser(2, new TextMessage("恭喜"+Thread.currentThread().getName()+"中了"+random.nextInt(500)+"万元的大奖！"));
//		}

	}

}
