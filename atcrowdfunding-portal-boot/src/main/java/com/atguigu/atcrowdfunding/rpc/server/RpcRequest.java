package com.atguigu.atcrowdfunding.rpc.server;

import java.util.Arrays;

public class RpcRequest {
	private String methodName;
	private String className;
	private Object[] parameters;
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Object[] getParameters() {
		return parameters;
	}
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}
	@Override
	public String toString() {
		return "RpcRequest [methodName=" + methodName + ", className=" + className + ", parameters="
				+ Arrays.toString(parameters) + "]";
	}

}
