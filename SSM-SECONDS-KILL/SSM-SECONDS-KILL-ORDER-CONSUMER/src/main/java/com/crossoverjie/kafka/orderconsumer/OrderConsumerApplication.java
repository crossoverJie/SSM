package com.crossoverjie.kafka.orderconsumer;

import com.crossoverjie.kafka.orderconsumer.kafka.ConsumerGroup;
import com.crossoverjie.kafka.orderconsumer.kafka.ConsumerTask;
import com.crossoverjie.kafka.orderconsumer.util.SpringBeanFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {MapperAutoConfiguration.class})
@MapperScan(basePackages = "com.crossoverjie.kafka.orderconsumer.mapper")
@ComponentScan("com.crossoverjie.kafka.orderconsumer")
public class OrderConsumerApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(OrderConsumerApplication.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(OrderConsumerApplication.class).
				listeners(new ApplicationPidFileWriter())
				.web(false)
				.run(args);

		ConsumerGroup consumerGroup = SpringBeanFactory.getBean(ConsumerGroup.class);
		consumerGroup.execute();

		LOGGER.info("启动成功");
	}
}
