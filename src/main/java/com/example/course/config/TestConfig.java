package com.example.course.config;

import java.time.Instant;
import java.util.Arrays;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.Category;
import com.example.course.entities.Order;
import com.example.course.entities.Product;
import com.example.course.entities.User;
import com.example.course.entities.enums.OrderStatus;
import com.example.course.repositories.CategoryRepository;
import com.example.course.repositories.OrderRepository;
import com.example.course.repositories.ProductRepository;
import com.example.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria", "maria@gmail.com", "98435454", "password123");
		User u2 = new User(null, "Bob", "bob@uol.com", "99120223", "123456");
		
		Order o1 = new Order(null, Instant.parse("2024-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2025-08-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u2);
		
		Category c1 = new Category(null, "Electronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of The Rings", "Lorem ipsum dolor sit", new BigDecimal(90.5), "");
		Product p2 = new Product(null, "Smart TV", "Amet consectetur nulla eu imperdiet", new BigDecimal(2190.0), "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor", new BigDecimal(1250.0), "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus", new BigDecimal(1200.0), "");
		Product p5 = new Product(null, "Ruby on Rails for Dummies", "Cras fringilla convallis", new BigDecimal(100.99), "");

		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
	}
	
	
}
