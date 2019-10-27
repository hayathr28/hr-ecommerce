package com.hr.ecommerce.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.hr.ecommerce.mongo.MongoOrderSequenceGenerator;
import com.hr.ecommerce.order.model.Order;

@Component
public class MongoOrderCreatorListner extends AbstractMongoEventListener<Order> {
	
	private MongoOrderSequenceGenerator sequenceGenerator;
	
	@Autowired
	public MongoOrderCreatorListner(MongoOrderSequenceGenerator sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}
	
	public void onBeforeConvert(BeforeConvertEvent<Order> event) {
		if(event.getSource().getOrderId() < 1) {
			event.getSource().setOrderId(sequenceGenerator.generatOrderNumber(Order.SEQUENCE_NAME));
		}
	}

}
