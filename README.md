
<p align="center">
                                                                                                                    
 <img src="https://ws4.sinaimg.cn/large/006tNc79ly1fluug8kpmnj30gl07hweq.jpg" >
 <br/>
 <br/>
 <a href="https://travis-ci.org/crossoverJie/SSM">
    <img src="https://travis-ci.org/crossoverJie/SSM.svg?branch=master" >
 </a>
 <a href="https://badge.juejin.im/entry/5856c00061ff4b0063be6be0/likes.svg?style=flat-square">
    <img src="https://badge.juejin.im/entry/5856c00061ff4b0063be6be0/likes.svg?style=flat-square" >
 </a>
 <a href="https://github.com/ellerbrock/open-source-badge/">
    <img src="https://badges.frapsoft.com/os/v1/open-source.svg?v=103" >
 </a>
<p>


[中文简介](https://github.com/crossoverJie/SSM/blob/master/README-ZH.md)
 
I'll update some skills in actual development aperiodically.There are no complicated operation flows or **xxx system**,just some practical shares about skills.

## Directory Structure

```shell
├── SSM-API                                    // common API  
│   ├── src/main
│   ├── ├──java/com/crossoverJie               // specific code。  
│   ├── ├──resources
├── SSM-BOOT                                   // Available for internal use of dubbo dependencies 
│   ├── ├──resources/spring                    // dubbo consumer configuration
├── SSM-SERVICE                                // The service implementation of the dubbo application 
│   ├── src/main
│   ├── ├──java/com/crossoverJie/api           // specific code
│   ├── ├──├──controller                       // Heartbeat detection interface
│   ├── ├──├──dubbo                            // Dubbo related code
│   ├── ├──├──├──dao                           // dao package
│   ├── ├──├──├──pojo                          // pojo package
│   ├── ├──├──├──service                       // service package
│   ├── ├──├──├──util                          // Toolkit
│   ├── ├──├──impl                             // implement dubbo API
│   ├── ├──resources                           // configuration file
│   ├── ├──├──mapping                          // *.mapper configuration file
│   ├── ├──├──spring                           // Spring related configuration file
├── SSM-WEB                                    // web application
│   ├── src/main
│   ├── ├──java/com/crossoverJie               // specific code
│   ├── ├──├──controller                       // controller package
│   ├── ├──├──cxf                              // CXF related code
│   ├── ├──├──dao                              // dao package
│   ├── ├──├──enums                            // enum package
│   ├── ├──├──intercept                        // Interceptor
│   ├── ├──├──kafka                            // Kafka
│   ├── ├──├──├──official                      // Official consumption
│   ├── ├──├──├──optimization                  // Multi-threaded consumption
│   ├── ├──├──lucene                           // Lucene related code
│   ├── ├──├──pojo                             // pojo package
│   ├── ├──├──req                              // request package
│   ├── ├──├──res                              // response package
│   ├── ├──├──service                          // service pachage
│   ├── ├──├──shiro                            // shiro related code
│   ├── ├──├──util                             // Toolkit
│   ├── ├──├──vo                               // vo package
│   ├── ├──resources
│   ├── ├──├──mapping                          // *.mapper configuration file
│   ├── ├──webapp                              // front code
├── doc
│   ├──lucene                                  // lucene related code
│   ├──sql                                     // sql scripts
├── .gitignore                                 // gitignore 
├── pom.xml                                    // parent pom
├── LICENSE               
├── README.md               

```

## TODO LIST

* [x] [SSM(一)架构的整合](http://crossoverjie.top/2016/06/28/SSM1)
* [x] [SSM(二)Lucene全文检索](http://crossoverjie.top/2016/07/06/SSM2)
* [x] [SSM(三)Shiro使用详解](http://crossoverjie.top/2016/07/15/SSM3/)
* [x] [SSM(四)WebService入门详解](http://crossoverjie.top/2016/08/02/SSM4/)
* [x] [SSM(五)基于webSocket的聊天室](http://crossoverjie.top/2016/09/04/SSM5/)
* [x] [SSM(六)跨域传输](http://crossoverjie.top/2016/10/18/SSM6/)
* [x] [SSM(七)在JavaWeb应用中使用Redis](http://crossoverjie.top/2016/12/18/SSM7/)
* [x] [SSM(八)动态切换数据源](http://crossoverjie.top/2017/01/05/SSM8/)
* [x] [SSM(九) 反射的实际应用 - 构建日志对象](http://crossoverjie.top/2017/01/19/SSM9/)
* [x] [SSM(十) 项目重构-互联网项目的Maven结构](http://crossoverjie.top/2017/03/04/SSM10/)
* [x] [SSM(十一) 基于dubbo的分布式架构](http://crossoverjie.top/2017/04/07/SSM11/)
* [x] [SSM(十二) SSM(十二) dubbo日志插件](http://crossoverjie.top/2017/04/25/SSM12/)
* [x] [SSM(十三) 将dubbo暴露出HTTP服务](http://crossoverjie.top/2017/05/02/SSM13/)
* [x] [SSM(十四) 基于annotation的http防重插件](https://crossoverjie.top/2017/05/24/SSM14/)
* [x] [SSM(十五)乐观锁与悲观锁的实际应用](https://crossoverjie.top/2017/07/09/SSM15/)
* [x] [SSM(十六)曲线救国-`Kafka consumer`消费异常处理](https://crossoverjie.top/2017/09/05/SSM16/)
* [x] [SSM(十七) MQ应用](https://crossoverjie.top/2017/10/20/SSM17/)

--- 

# Special Note 

On the project,`SSM-SERVICE` `SSM-WEB` module is only used to demonstrate the use of normal circumstances will only appear a service or web module.


# Quick Start

1. Import SQL Script

[https://github.com/crossoverJie/SSM/tree/master/doc/sql](https://github.com/crossoverJie/SSM/tree/master/doc/sql)


# Q&A

#### ClassNotFoundException: *CheckReqNo*

Because there is dependence: 

https://github.com/crossoverJie/SSM-REQUEST-CHECK 

https://github.com/crossoverJie/SSM-DUBBO-HTTP 

jar。

*solution:*

- if you do not need them, please remove it.
- if you need,flow: 

https://github.com/crossoverJie/SSM-REQUEST-CHECK 

https://github.com/crossoverJie/SSM-DUBBO-HTTP 

and Installed locally。

---

# Partial Screenshots

![](https://ws4.sinaimg.cn/large/006tNc79ly1fj8jl8t42oj30bo072q3g.jpg)

![封面.jpg](https://ooo.0o0.ooo/2017/05/24/59253bc0291c1.jpg)

![dubbo-http封面.jpg](https://user-gold-cdn.xitu.io/2017/5/3/fa1a532f5289bb58f887a8561ec236ed.jpg)

![2.jpg](https://ooo.0o0.ooo/2017/04/07/58e66e4917dd1.jpg)

![](http://i.imgur.com/nRcHFQg.png)


```properties
2017-04-25 15:15:38,968 DEBUG [com.alibaba.dubbo.remoting.transport.DecodeHandler] -  [DUBBO] Decode decodeable message com.alibaba.dubbo.rpc.protocol.dubbo.DecodeableRpcInvocation, dubbo version: 2.5.3, current host: 127.0.0.1
2017-04-25 15:15:39,484 DEBUG [com.crossoverJie.dubbo.filter.DubboTraceFilter] - dubbo请求数据:{"args":[1],"interfaceName":"com.crossoverJie.api.UserInfoApi","methodName":"getUserInfo"}
2017-04-25 15:15:39,484 INFO [com.crossoverJie.api.impl.UserInfoApiImpl] - 用户查询Id=1
2017-04-25 15:15:39,505 DEBUG [org.mybatis.spring.SqlSessionUtils] - Creating a new SqlSession
2017-04-25 15:15:39,525 DEBUG [org.mybatis.spring.SqlSessionUtils] - SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6f56b29] was not registered for synchronization because synchronization is not active
2017-04-25 15:15:39,549 DEBUG [org.mybatis.spring.transaction.SpringManagedTransaction] - JDBC Connection [com.alibaba.druid.proxy.jdbc.ConnectionProxyImpl@778b3121] will not be managed by Spring
2017-04-25 15:15:39,555 DEBUG [com.crossoverJie.api.dubbo.dao.T_userDao.selectByPrimaryKey] - ==>  Preparing: select id, username, password,roleId from t_user where id = ? 
2017-04-25 15:15:39,591 DEBUG [com.crossoverJie.api.dubbo.dao.T_userDao.selectByPrimaryKey] - ==> Parameters: 1(Integer)
2017-04-25 15:15:39,616 DEBUG [com.crossoverJie.api.dubbo.dao.T_userDao.selectByPrimaryKey] - <==      Total: 1
2017-04-25 15:15:39,616 DEBUG [com.alibaba.druid.pool.PreparedStatementPool] - {conn-10003, pstmt-20000} enter cache
2017-04-25 15:15:39,617 DEBUG [org.mybatis.spring.SqlSessionUtils] - Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@6f56b29]
2017-04-25 15:15:45,473 INFO [com.crossoverJie.dubbo.filter.DubboTraceFilter] - dubbo执行成功
2017-04-25 15:15:45,476 DEBUG [com.crossoverJie.dubbo.filter.DubboTraceFilter] - dubbo返回数据{"args":[{"id":1,"password":"123456","roleId":1,"userName":"crossoverJie"}],"interfaceName":"com.crossoverJie.api.UserInfoApi","methodName":"getUserInfo"}
```



# More Information

[使用`springBoot+SpringCloud`构建微服务项目](https://github.com/crossoverJie/springboot-cloud)

# Contact Author
- [crossoverJie@gmail.com](mailto:crossoverJie@gmail.com)

![weixinchat.jpg](https://crossoverjie.top/uploads/weixinchat.jpg)

