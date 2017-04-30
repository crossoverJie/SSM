> 个人博客：http://crossoverJie.top

> 掘金主页: https://gold.xitu.io/user/576d4aaf7db2a20054ea4544

---
# 下期预告---将dubbo暴露为http服务
---
# SSM
使用Idea搭建的Maven项目，会不定期更新一些在实际开发中使用的技巧(ps:目前不是很忙基本上一周一更)。
没有复杂的业务流程，更不是XXXX系统，只有一些技术的分享。想要学习XX系统的：
- [company_open](https://github.com/crossoverJie/company_open)
- [SalesStore](https://github.com/crossoverJie/SalesStore)

这里有两个完整的项目。

*有任何问题和欢迎Issues*

> **觉得不错的朋友可以点下`star`,`watch`,`fork`也算是对我的鼓励了。**

---

# 联系作者
- [crossoverJie@gmail.com](mailto:crossoverJie@gmail.com)

![weixinchat.jpg](https://ooo.0o0.ooo/2017/04/25/58ff4d5fd9fa3.jpg)


# dubbo日志插件
博客地址：[SSM(十二) 基于dubbo的分布式架构](http://crossoverjie.top/2017/04/25/SSM12/)

掘金地址：[https://juejin.im/post/58ff1ab861ff4b006678f9c5)

效果实例：

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

- [前言](http://crossoverjie.top/2017/04/25/SSM12/#前言)
- [dubbo-filter拓展](http://crossoverjie.top/2017/04/25/SSM12/#dubbo-filter拓展)
  * [DubboTraceFilter具体拦截逻辑](http://crossoverjie.top/2017/04/25/SSM12/#DubboTraceFilter具体拦截逻辑)
  
- [总结](http://crossoverjie.top/2017/04/25/SSM12/#总结)
  * [使用方法](http://crossoverjie.top/2017/04/25/SSM12/#使用方法)
  
    - [安装](http://crossoverjie.top/2017/04/25/SSM12/#安装)
    - [使用](http://crossoverjie.top/2017/04/25/SSM12/#使用)


---

# 基于dubbo的分布式架构
博客地址：[SSM(十一) 基于dubbo的分布式架构](http://crossoverjie.top/2017/04/07/SSM11/)

掘金地址：[https://juejin.im/post/58e674ec44d904006d35af5c](https://juejin.im/post/58e674ec44d904006d35af5c)

效果实例：

![2.jpg](https://ooo.0o0.ooo/2017/04/07/58e66e4917dd1.jpg)

- [前言](http://crossoverjie.top/2017/04/07/SSM11/#前言)
- [浅谈分布式架构](http://crossoverjie.top/2017/04/07/SSM11/#浅谈分布式架构)
  * [单系统](http://crossoverjie.top/2017/04/07/SSM11/#单系统)
  * [垂直拆分-多应用](http://crossoverjie.top/2017/04/07/SSM11/#垂直拆分-多应用)
  * [SOA服务化](http://crossoverjie.top/2017/04/07/SSM11/#SOA服务化)

- [基于dubbo的实现](http://crossoverjie.top/2017/04/07/SSM11/#基于dubbo的实现)
  * [对外提供服务](http://crossoverjie.top/2017/04/07/SSM11/#对外提供服务)
  * [安装管理控制台](http://crossoverjie.top/2017/04/07/SSM11/#安装管理控制台)
  * [消费服务](http://crossoverjie.top/2017/04/07/SSM11/#消费服务)
  
- [总结](http://crossoverjie.top/2017/04/07/SSM11/#总结)

---

#  项目重构-互联网项目的Maven结构
博客地址：[SSM(十) 项目重构-互联网项目的Maven结构](http://crossoverjie.top/2017/03/04/SSM10/)

掘金地址：[https://gold.xitu.io/post/58b98ab01b69e6006b12ab83](https://gold.xitu.io/post/58b98ab01b69e6006b12ab83)

效果实例：

![1.jpg](https://ooo.0o0.ooo/2017/03/04/58b99366edad6.jpg)

- [前言](https://crossoverjie.top/2017/03/04/SSM10/#前言)
- [为什么需要分模块](https://crossoverjie.top/2017/03/04/SSM10/#为什么需要分模块)
- [各个模块的作用](https://crossoverjie.top/2017/03/04/SSM10/#各个模块的作用)
  * [ROOT](http://crossoverjie.top/2017/03/04/SSM10/#ROOT)
  * [SSM-API](http://crossoverjie.top/2017/03/04/SSM10/#SSM-API)
  * [SSM-BOOT](http://crossoverjie.top/2017/03/04/SSM10/#SSM-BOOT)
  * [SSM-SERVICE](http://crossoverjie.top/2017/03/04/SSM10/#SSM-SERVICE)
  * [SSM-WEB](http://crossoverjie.top/2017/03/04/SSM10/#SSM-WEB)
- [总结](https://crossoverjie.top/2017/03/04/SSM10/#总结)

---

#  反射的实际应用 - 构建日志对象
博客地址：[SSM(九) 反射的实际应用 - 构建日志对象](http://crossoverjie.top/2017/01/19/SSM9/)

简书地址：[http://www.jianshu.com/p/5a23ff31204f](http://www.jianshu.com/p/5a23ff31204f)

效果实例：
```java
    @Test
    public void insertSelective2() throws Exception {
        Content content = new Content();
        content.setContent("你好");
        content.setContentname("1");
        content.setCreatedate("2016-09-23");

        contentService.insertSelective(content);

        ContentLog log = new ContentLog();
        CommonUtil.setLogValueModelToModel(content, log);
        contentLogService.insertSelective(log);
    }
```

- [前言](http://crossoverjie.top/2017/01/19/SSM9/#前言)
- [传统日志](http://crossoverjie.top/2017/01/19/SSM9/#传统日志)
- [利用反射构建日志](http://crossoverjie.top/2017/01/19/SSM9/#利用反射构建日志)
- [总结](http://crossoverjie.top/2017/01/19/SSM9/#总结)

---

# 动态切换数据源
博客地址：[SSM(八)动态切换数据源](http://crossoverjie.top/2017/01/05/SSM8/)

简书地址：[http://www.jianshu.com/p/9d3d92b37c0a](http://www.jianshu.com/p/9d3d92b37c0a)

效果实例：
![3](http://img.blog.csdn.net/20170105012845706?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMTg2NjE3OTM=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

- [前言](http://crossoverjie.top/2017/01/05/SSM8/#前言)
- [手动切换数据源](http://crossoverjie.top/2017/01/05/SSM8/#手动切换数据源)
- [自动切换数据源](http://crossoverjie.top/2017/01/05/SSM8/#自动切换数据源)
- [总结](http://crossoverjie.top/2017/01/05/SSM8/#总结)

---

# 在JavaWeb应用中使用Redis
博客地址：[SSM(七)在JavaWeb应用中使用Redis](http://crossoverjie.top/2016/12/18/SSM7/)

简书地址：[http://www.jianshu.com/p/77cd4ae50c8b](http://www.jianshu.com/p/77cd4ae50c8b)

效果实例：
![01.gif](http://ww2.sinaimg.cn/large/0060lm7Tgy1fd79hp9x6qg30bo0727wn.gif
)

- [前言](http://crossoverjie.top/2016/12/18/SSM7/#前言)
- [Redis安装与使用？](http://crossoverjie.top/2016/12/18/SSM7/#Redis安装与使用)
- [Spring整合Redis](http://crossoverjie.top/2016/12/18/SSM7/#Spring整合Redis)
- [前端联调](http://crossoverjie.top/2016/12/18/SSM7/#前端联调)
- [总结](http://crossoverjie.top/2016/12/18/SSM7/#总结)

---

# 跨域传输
博客地址：[SSM(六)跨域传输](http://crossoverjie.top/2016/10/18/SSM6/)
简书地址：[http://www.jianshu.com/p/3e3d9a89fafc](http://www.jianshu.com/p/3e3d9a89fafc)
效果实例：
![](http://img.blog.csdn.net/20161018003136470)

- [前言](http://crossoverjie.top/2016/10/18/SSM6/#前言)
- [什么是跨域传输？](http://crossoverjie.top/2016/10/18/SSM6/#什么是跨域问题？)
- [JSON](http://crossoverjie.top/2016/10/18/SSM6/#JSON)
- [PostMan](http://crossoverjie.top/2016/10/18/SSM6/#PostMan)
- [JSONP](http://crossoverjie.top/2016/10/18/SSM6/#JSONP)
- [总结](http://crossoverjie.top/2016/10/18/SSM6/#总结)

---

# 基于webSocket的聊天室
博客地址：[SSM(五)基于webSocket的聊天室](http://crossoverjie.top/2016/09/04/SSM5/)
简书地址：[http://www.jianshu.com/p/79faa8af6455](http://www.jianshu.com/p/79faa8af6455)
效果实例：
![](http://i.imgur.com/6of3Z5K.gif)

- [前言](http://crossoverjie.top/2016/09/04/SSM5/#前言)
- [websocket是什么？](http://crossoverjie.top/2016/09/04/SSM5/#websocket是什么？)
- [后端](http://crossoverjie.top/2016/09/04/SSM5/#后端)
- [websocket绕坑](http://crossoverjie.top/2016/09/04/SSM5/#websocket绕坑)
- [前端](http://crossoverjie.top/2016/09/04/SSM5/#前端)
- [Ueditor相关配置](http://crossoverjie.top/2016/09/04/SSM5/#Ueditor相关配置)
- [总结](http://crossoverjie.top/2016/09/04/SSM5/#总结)

---


# WebService入门详解
博客地址：[SSM(四)WebService入门详解](http://crossoverjie.top/2016/08/02/SSM4/)
简书地址：[http://www.jianshu.com/p/5c2b01aaa7ac](http://www.jianshu.com/p/5c2b01aaa7ac)
效果实例：
![](http://img.blog.csdn.net/20160802170000891)

- [前言](http://crossoverjie.top/2016/08/02/SSM4/#前言)
- [Spring整合CXF](http://crossoverjie.top/2016/08/02/SSM4/#Spring整合CXF)
- [总结](http://crossoverjie.top/2016/08/02/SSM4/#总结)

---

# Shiro使用详解
博客地址：[SSM(三)Shiro使用详解](http://crossoverjie.top/2016/07/15/SSM3/)
简书地址：[http://www.jianshu.com/p/6786ddf54582](http://www.jianshu.com/p/6786ddf54582)
效果实例：
![1](http://i.imgur.com/zbJxEfO.gif)

- [前言](http://crossoverjie.top/2016/07/15/SSM3/#前言)
- [创建自定义MyRealm类](http://crossoverjie.top/2016/07/15/SSM3/#创建自定义MyRealm类)
- [整合Spring](http://crossoverjie.top/2016/07/15/SSM3/#整合Spring)
- [使用Shiro标签库](http://crossoverjie.top/2016/07/15/SSM3/#使用Shiro标签库)
- [整体测试](http://crossoverjie.top/2016/07/15/SSM3/#整体测试)
- [MD5加密](http://crossoverjie.top/2016/07/15/SSM3/#MD5加密)
- [总结](http://crossoverjie.top/2016/07/15/SSM3/#总结)

---

# Lucene全文检索
博客地址：[SSM(二)Lucene全文检索](http://crossoverjie.top/2016/07/06/SSM2)
效果实例：
![](http://i.imgur.com/nRcHFQg.png)
- [前言](http://crossoverjie.top/2016/07/06/SSM2/#前言)
- [获取Maven依赖](http://crossoverjie.top/2016/07/06/SSM2/#获取Maven依赖)
- [编写Lucene工具类](http://crossoverjie.top/2016/07/06/SSM2/#编写Lucene工具类)
- [查询Controller的编写](http://crossoverjie.top/2016/07/06/SSM2/#查询Controller的编写)
- [显示界面](http://crossoverjie.top/2016/07/06/SSM2/#显示界面)
- [总结](http://crossoverjie.top/2016/07/06/SSM2/#总结)

---

# SSM架构的整合
博客地址：[SSM(一)框架的整合](http://crossoverjie.top/2016/06/28/SSM1)

---

[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badge/)

