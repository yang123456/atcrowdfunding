package com.atguigu.atcrowdfunding.webservice.a;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

//上面package名反过来写
@WebService(targetNamespace = "http://hello.webservice.atcrowdfunding.atguigu.com")
public interface IHello {

	@WebMethod
	public @WebResult String sayHello(@WebParam(name = "userName") String userName);

}