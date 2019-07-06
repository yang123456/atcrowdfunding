package com.atguigu.atcrowdfunding.velocity.directive;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.xml.sax.Attributes;
 
/**
 * @author Yi. on 2018/1/15
 */
public class PermissionDirective extends Directive {
	static List<String>  permissionList=new ArrayList<String>();
	
	static {
		permissionList=new ArrayList<String>();
		permissionList.add("user:add");
		permissionList.add("user:update");
	}
    @Override
    public String getName() {  // 指令名称
        return "hasPermission";
    }

    @Override
    public int getType() {  // 指令类型
        return BLOCK;
    }

    @Override
    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException { // 具体渲染方式
        String permissionName = String.valueOf(node.jjtGetChild(0).value(context));  // 获取页面设置的所需的权限内容字符串
//        List<String> permissionList = (List<String>) context.get(Attributes.SESSION_PERMISSION);  // 从request中获取当前拥有的所有权限
        if (permissionList.contains(permissionName)) {
            Node body = node.jjtGetChild(1); // 当用户拥有指定权限时，获取指令块内容
            StringWriter sw = new StringWriter();
            body.render(context, sw);
            String bodyContent = sw.toString();  // 获取渲染之后的文本内容
            writer.write(bodyContent); // 输出到页面
        }
        return true;
    }
}