# 测试Jersey2.x 功能
> 几个基本概念
- REST是一种跨平台、跨语言的架构风格
- REST式的Web服务是对REST在WEB领域的实现
- JAX-RS标准是JAVA领域对REST式的Web服务制定的实现标准
- Jersey是JAX-RS标准的参考实现，是Java EE参考实现项目GlassFish的成员项目

> 环境信息
- Eclipse 4.7
- Jdk 1.8
- tomcat 7
- Jersey 2.25.1
- SoupUI 5.3
- Postman 

## 统一接口测试 
> 快速实现基本的增删改查

> 


## 资源定位


## 传输格式


## 处理响应

## 


# REST客户端


# Issue

## 1. soupui与Postman返回数据格式差异

## 2. 在使用Jersey时，把提供服务的类设计为接口，配置在web.xml中，运行Tomcat之后访问服务出现异常 

``` java
java.lang.NoSuchMethodException: Could not find a suitable constructor in coursemanager.resource.CourseResource class.
```

- 注解写在实现类上  

```
 本测试用例实现类BookResourceImpl完成注解 
 
 https://stackoverflow.com/questions/20148269/restful-service-interface-with-jersey 
```
 
- 使用配置类 

``` 
public class RestConfig extends ResourceConfig{
	 public RestConfig() {
	        super(BookResourceImpl.class); // 实现类
	    }
}

web.xml修改 
	     <init-param>
            <param-name>javax.ws.rs.Application</param-name>
            <param-value>com.wade.resource.impl.RestConfig</param-value>
        </init-param> 

```

- 直接配置使用实现类 

``` 
web.xml直接写实现类
	     <init-param>
            <param-name>javax.ws.rs.Application</param-name>
            <param-value>com.wade.resource.impl.BookResourceImpl</param-value>
        </init-param> 
```

# References
 
- http://blog.csdn.net/Ezfen/article/details/47725271
- http://blog.csdn.net/qq_24548569/article/details/53524699
- https://stackoverflow.com/questions/20148269/restful-service-interface-with-jersey
