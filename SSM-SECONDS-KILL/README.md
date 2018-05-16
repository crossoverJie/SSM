1. 简单的 web 层，service 层( `dubbo` 通信)，数据库不做限制，出现超卖现象。
2. 数据库采用乐观锁更新，库存总数放入 Redis(并不会经常更新)
3. web 层，service 层分布式部署，提高吞吐量。
4. web 层做限流，每个 UID 限制每秒 N 次请求，多余的请求直接过滤(不能将过多的请求到 DB)。
5. service 层限流，先用单机限流，如令牌桶算法。再用 Redis 做全局限流。
6. 异步创建订单，将创建订单用 `Kafka` 解耦。


具体案例：

[https://crossoverjie.top/2018/05/07/ssm/SSM18-seconds-kill/](https://crossoverjie.top/2018/05/07/ssm/SSM18-seconds-kill/)