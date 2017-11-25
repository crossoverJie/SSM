
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

使用Idea搭建的Maven项目，会不定期更新一些在实际开发中使用的技巧,没有复杂的业务流程，更不是**XXXX系统**，只有一些技术的分享

## 目录结构

```shell
├── SSM-API                                    // 通用API  
│   ├── src/main
│   ├── ├──java/com/crossoverJie               // 具体代码。  
│   ├── ├──resources
├── SSM-BOOT                                   // 提供给内部使用的dubbo依赖
│   ├── ├──resources/spring                    // dubbo consumer相关配置
├── SSM-SERVICE                                // dubbo应用的service实现
│   ├── src/main
│   ├── ├──java/com/crossoverJie/api           // 具体代码
│   ├── ├──├──controller                       // 心跳检测接口
│   ├── ├──├──dubbo                            // dubbo相关代码
│   ├── ├──├──├──dao                           // dao层
│   ├── ├──├──├──pojo                          // pojo包
│   ├── ├──├──├──service                       // service层
│   ├── ├──├──├──util                          // 工具类
│   ├── ├──├──impl                             // dubbo API实现
│   ├── ├──resources                           // 配置文件
│   ├── ├──├──mapping                          // *.mapper配置文件
│   ├── ├──├──spring                           // spring相关配置文件
├── SSM-WEB                                    // web应用
│   ├── src/main
│   ├── ├──java/com/crossoverJie               // 具体代码
│   ├── ├──├──controller                       // 控制器层
│   ├── ├──├──cxf                              // CXF相关代码
│   ├── ├──├──dao                              // dao层
│   ├── ├──├──enums                            // 枚举包
│   ├── ├──├──intercept                        // 拦截器
│   ├── ├──├──kafka                            // Kafka
│   ├── ├──├──├──official                      // 官方消费
│   ├── ├──├──├──optimization                  // 多线程消费
│   ├── ├──├──lucene                           // Lucene 相关包
│   ├── ├──├──pojo                             // pojo包
│   ├── ├──├──req                              // 请求类
│   ├── ├──├──res                              // 响应类
│   ├── ├──├──service                          // service层
│   ├── ├──├──shiro                            // shiro相关代码
│   ├── ├──├──util                             // 工具类
│   ├── ├──├──vo                               // vo包
│   ├── ├──resources
│   ├── ├──├──mapping                          // *.mapper配置文件
│   ├── ├──webapp                              // 前端文件
├── doc
│   ├──lucene                                  // lucene文件
│   ├──sql                                     // sql脚本
├── .gitignore                                 // git忽略项
├── pom.xml                                    // 父pom
├── LICENSE               
├── README.md               

```

## 特别说明

关于项目中的`SSM-SERVICE `,`SSM-WEB`模块只是为了演示使用，正常情况只会出现一个service或者是web模块。

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
* [x] [乐观锁与悲观锁的实际应用](https://crossoverjie.top/2017/07/09/SSM15/)
* [x] [SSM(十六)曲线救国-`Kafka consumer`消费异常处理](https://crossoverjie.top/2017/09/05/SSM16/)
* [x] [SSM(十七) MQ应用](https://crossoverjie.top/2017/10/20/SSM17/)

--- 

# 常见问题

#### 找不到`CheckReqNo.java`类

这是由于我再项目中有依赖: 

https://github.com/crossoverJie/SSM-REQUEST-CHECK 

https://github.com/crossoverJie/SSM-DUBBO-HTTP 

这个两个插件。

*解决方案:*

- 如果不需要这两个插件再 `pom` 依赖中去掉相关依赖即可。
- 如果需要则按照 

https://github.com/crossoverJie/SSM-REQUEST-CHECK 

https://github.com/crossoverJie/SSM-DUBBO-HTTP 

`install` 到本地即可。
- 不要clone `master`分支，使用https://github.com/crossoverJie/SSM/releases/tag/2.1.0 或之前的tag即可。


---

# 应用截图

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



# 更多信息

[使用`springBoot+SpringCloud`构建微服务项目](https://github.com/crossoverJie/springboot-cloud)

# 联系作者
- [crossoverJie@gmail.com](mailto:crossoverJie@gmail.com)

![weixinchat.jpg](https://crossoverjie.top/uploads/weixinchat.jpg)


