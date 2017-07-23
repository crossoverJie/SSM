# SSM

I'll update some skills in actual development aperiodically.There are no complicated operation flows or xxx system,just some practical shares about skills.

## Directory Structure

```shell
├── SSM-API                                    // 通用API  
│   ├── src/main
│   ├── ├──java/com/crossoverJie               // 具体代码。  
│   ├── ├──resources
├── SSM-BOOT                                   // 提供给内部使用的dubbo依赖
│   ├── ├──resources/spring                    // dubbo consumer相关配置
├── SSM-SERVICE                                // dubbo应用的service实现
│   ├── src/main
│   ├── ├──java/com/crossoverJie/api           // 具体代码
│   ├── ├──├──controller                       // 心跳检测接口
│   ├── ├──├──dubbo                            // dubbo相关代码
│   ├── ├──├──├──dao                           // dao层
│   ├── ├──├──├──pojo                          // pojo包
│   ├── ├──├──├──service                       // service层
│   ├── ├──├──├──util                          // 工具类
│   ├── ├──├──impl                             // dubbo API实现
│   ├── ├──resources                           // 配置文件
│   ├── ├──├──mapping                          // *.mapper配置文件
│   ├── ├──├──spring                           // spring相关配置文件
├── SSM-WEB                                    // web应用
│   ├── src/main
│   ├── ├──java/com/crossoverJie               // 具体代码
│   ├── ├──├──controller                       // 控制器层
│   ├── ├──├──cxf                              // CXF相关代码
│   ├── ├──├──dao                              // dao层
│   ├── ├──├──enums                            // 枚举包
│   ├── ├──├──intercept                        // 拦截器
│   ├── ├──├──lucene                           // Lucene 相关包
│   ├── ├──├──pojo                             // pojo包
│   ├── ├──├──req                              // 请求类
│   ├── ├──├──res                              // 响应类
│   ├── ├──├──service                          // service层
│   ├── ├──├──shiro                            // shiro相关代码
│   ├── ├──├──util                             // 工具类
│   ├── ├──├──vo                               // vo包
│   ├── ├──resources
│   ├── ├──├──mapping                          // *.mapper配置文件
│   ├── ├──webapp                              // 前端文件
├── doc
│   ├──lucene                                  // lucene文件
│   ├──sql                                     // sql脚本
├── .gitignore                                 // git忽略项
├── pom.xml                                    // 父pom
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
* [x] [乐观锁与悲观锁的实际应用](https://crossoverjie.top/2017/07/09/SSM15/)

--- 

# Quick Start

1. Import SQL Script

导入以下两个`SQL脚本`:
[https://github.com/crossoverJie/SSM/tree/master/doc/sql](https://github.com/crossoverJie/SSM/tree/master/doc/sql)


# Common Problem

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



---

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badge/)

