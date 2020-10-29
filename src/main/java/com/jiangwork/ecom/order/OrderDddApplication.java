package com.jiangwork.ecom.order;

import com.jiangwork.ecom.order.ddd.domain.Order;
import com.jiangwork.ecom.order.ddd.factory.RedisOrderIdGenerator;
import com.jiangwork.ecom.order.ddd.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@SpringBootApplication
public class OrderDddApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDddApplication.class, args);
		new ArrayList<>();
	}


	@Component
	public class Validation implements CommandLineRunner {

		@Autowired
		private OrderRepository orderRepository;

		@Autowired
		private RedisOrderIdGenerator redisOrderIdGenerator;

		@Override
		public void run(String... args) throws Exception {
			try {
				Order order = orderRepository.findById(12L);
				System.out.println(order);
			} catch(Exception e) {

			}

			System.out.println("OrderId:" + redisOrderIdGenerator.get());
		}
	}

}
