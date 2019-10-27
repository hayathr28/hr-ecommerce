package com.hr.ecommerce.mongo;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.order.model.OrderKey;

@Service
public class MongoOrderSequenceGenerator {

	private MongoOperations mongoOperations;

	@Autowired
	public MongoOrderSequenceGenerator(MongoOperations mongoOperations) {

		this.mongoOperations = mongoOperations;

	}
	
	public long generatOrderNumber(String orderSequenceNumber) {
		OrderKey orderCounter = mongoOperations.findAndModify(query(where("orderId").is(orderSequenceNumber)), new Update().inc("sequence",10),options().returnNew(true).upsert(true), OrderKey.class);
		return null!=orderCounter ? orderCounter.getSequence() : 1000;
	}

}


