package com.atguigu.atcrowdfunding.velocity.directive;

import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

public class DemoDirective extends Directive {
	@Override
	public String getName() {
		return "demo";// 自定义指令的名称
	}

	@Override
	public int getType() {
		return 2;// 配置不带结束符
	}

	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {

		// 获取参数的值
		String str1 = node.jjtGetChild(0).value(context).toString();// 第一个参数的值
		String str2 = node.jjtGetChild(1).value(context).toString();// 第二个参数的值
		StringBuffer str = new StringBuffer();// 创建字符串对象
		if (str1 != null) {
			str = str.append("<p>测试结果1：" + str1 + "</p>");// 显示一段html
		}
		if (str2 != null) {
			str = str.append("<p>测试结果2：" + str2 + "</p>");
		}
		writer.write(str.toString());// 输出结果
		return true;
	}

}
