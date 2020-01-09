package com.hr.ecommerce.product;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hr.ecommerce.order.model.Order;

public interface MongoOrderRepository  extends MongoRepository<Order, Long> {

}
