
[![](https://badge.juejin.im/entry/5856c00061ff4b0063be6be0/likes.svg?style=flat-square)](https://juejin.im/post/585677f561ff4b00685aff42)
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badge/)


# SSM

[中文简介](https://github.com/crossoverJie/SSM/blob/master/README-ZH.md)
 
I'll update some skills in actual development aperiodically.There are no complicated operation flows or xxx system,just some practical shares about skills.

## Directory Structure

```shell
├── SSM-API                                    // common API  
│   ├── src/main
│   ├── ├──java/com/crossoverJie               // specific code。  
│   ├── ├──resources
├── SSM-BOOT                                   // Available for internal use of dubbo dependencies 
│   ├── ├──resources/spring                    // dubbo consumer configuration
├── SSM-SERVICE                                // The service implementation of the dubbo application 
│   ├── src/main
│   ├── ├──java/com/crossoverJie/api           // specific code
│   ├── ├──├──controller                       // Heartbeat detection interface
│   ├── ├──├──dubbo                            // Dubbo related code
│   ├── ├──├──├──dao                           // dao package
│   ├── ├──├──├──pojo                          // pojo package
│   ├── ├──├──├──service                       // service package
│   ├── ├──├──├──util                          // Toolkit
│   ├── ├──├──impl                             // implement dubbo API
│   ├── ├──resources                           // configuration file
│   ├── ├──├──mapping                          // *.mapper configuration file
│   ├── ├──├──spring                           // Spring related configuration file
├── SSM-WEB                                    // web application
│   ├── src/main
│   ├── ├──java/com/crossoverJie               // specific code
│   ├── ├──├──controller                       // controller package
│   ├── ├──├──cxf                              // CXF related code
│   ├── ├──├──dao                              // dao package
│   ├── ├──├──enums                            // enum package
│   ├── ├──├──intercept                        // Interceptor
│   ├── ├──├──lucene                           // Lucene related code
│   ├── ├──├──pojo                             // pojo package
│   ├── ├──├──req                              // request package
│   ├── ├──├──res                              // response package
│   ├── ├──├──service                          // service pachage
│   ├── ├──├──shiro                            // shiro related code
│   ├── ├──├──util                             // Toolkit
│   ├── ├──├──vo                               // vo package
│   ├── ├──resources
│   ├── ├──├──mapping                          // *.mapper configuration file
│   ├── ├──webapp                              // front code
├── doc
│   ├──lucene                                  // lucene related code
│   ├──sql                                     // sql scripts
├── .gitignore                                 // gitignore 
├── pom.xml                                    // parent pom
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
* [ ] SSM(十六)`Kafka consumer`消费异常处理

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

![封面.jpg](https://ooo.0o0.ooo/2017/05/24/59253bc0291c1.jpg)

![dubbo-http封面.jpg](https://user-gold-cdn.xitu.io/2017/5/3/fa1a532f5289bb58f887a8561ec236ed.jpg)

![2.jpg](https://ooo.0o0.ooo/2017/04/07/58e66e4917dd1.jpg)

![](http://i.imgur.com/nRcHFQg.png)


# More Information

[使用`springBoot+SpringCloud`构建微服务项目](https://github.com/crossoverJie/springboot-cloud)

# Contact Author
- [crossoverJie@gmail.com](mailto:crossoverJie@gmail.com)

![weixinchat.jpg](https://ooo.0o0.ooo/2017/07/05/595c77b2a080d.jpg)


