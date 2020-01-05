package com.hr.ecommerce.order.tasks;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.common.OrderStatus;
import com.hr.ecommerce.common.OrderUtils;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.order.model.ItemInfo;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;
import com.hr.ecommerce.rquest.beans.AddToCartRequest;

@Service
public class OrderCreationFactoryImpl implements OrderCreationFactory {
	
	@Autowired
	private HREcommerceExceptionFactory exceptionFactory;
	
	public Order addToCart(Product product,AddToCartRequest addToCartRequest) {
		Order order = new Order();
		order.setOrderItems(getOrderItem(order,product,addToCartRequest));
		order.setOrderStatus(OrderStatus.PENDING.toString());
		return order;
		
	}

	private List<OrderItem> getOrderItem(Order order,Product product, AddToCartRequest addToCartRequest) {
		List<OrderItem> orderItems = (null != order.getOrderItems()) ? order.getOrderItems() : new ArrayList<OrderItem>();
		OrderItem orderItem = new OrderItem();
		orderItem.setItemInfo(getItemInfo(product,addToCartRequest));
		orderItems.add(orderItem);
		return orderItems;
	}

	private ItemInfo getItemInfo(Product product, AddToCartRequest addToCartRequest) {
		ItemInfo itemInfo = new ItemInfo();
	    itemInfo.setPrice(product.getPrice());	
	    itemInfo.setProductCode(product.getProductCode());
	    itemInfo.setQuantity(addToCartRequest.getQuantity());
	    itemInfo.setTotalProduct(getTotalProduct(itemInfo.getQuantity(),itemInfo.getPrice()));
	    return itemInfo;
	}

	private String getTotalProduct(String quantity, String price) {
		
	    if(StringUtils.isEmpty(quantity) || StringUtils.isEmpty(price)) {
	    	throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_MISSING_QUANTITY_OR_PRICE);	
	    }
	   return  OrderUtils.convertAmount(quantity).multiply( OrderUtils.convertAmount(price)).setScale(2, RoundingMode.HALF_DOWN).toPlainString();
	}

	
}
