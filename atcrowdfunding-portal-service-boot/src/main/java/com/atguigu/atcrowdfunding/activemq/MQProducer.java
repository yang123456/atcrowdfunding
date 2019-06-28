
package com.atguigu.atcrowdfunding.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;


import com.alibaba.fastjson.JSONObject;
import com.atguigu.atcrowdfunding.entity.Mail;


/**
 * <B>系统名称： </B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author bhz（Alienware）
 * @since 2014年7月2日
 */
@Service("mqProducer")
public class MQProducer {
	
	private JmsTemplate jmsTemplate;
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	
	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	/**
	 * <B>方法名称：</B>发送邮件信息对象<BR>
	 * <B>概要说明：</B>发送邮件信息对象<BR>
	 * @param mail
	 */
	public void sendMessage(final Mail mail) {
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSONObject.toJSONString(mail));
			}
		});
	}

}
