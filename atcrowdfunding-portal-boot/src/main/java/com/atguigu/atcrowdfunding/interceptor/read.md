SpringBoot拦截器和自定义注解验证是否登录
demo地址：https://github.com/luomouren/sbDemo 
参考网址：https://www.jianshu.com/p/97362fdf039e （非常感谢作者~） 
用SpringBoot开发后台用于移动端API接口，移动端登录一次后，返回accessToken字符串，移动端后面的交互只要传入accessToken即可验证其有效性，将accessToken转换成CurrentUser，在controller内可以直接使用操作其bean。需要做以下几点：

1.Token生成帮助类
2.拦截器验证是否是有效的accessToken
3.添加自定义注解LoginRequired(请求方法是否需要验证accessToken)
4.添加自定义注解CurrentUser(将accessToken转换成CurrentUser)
5.SpringBoot配置拦截器
6.测试






百战商城
https://blog.csdn.net/qq_43371556/article/details/101095879