package com.hr.ecommerce.order;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.common.HREcommerceErrorConstants;
import com.hr.ecommerce.common.OrderStatusValidationUtil;
import com.hr.ecommerce.exception.HREcommerceExceptionFactory;
import com.hr.ecommerce.order.calculation.CalculateOrderTask;
import com.hr.ecommerce.order.calculation.PrepareOrderTask;
import com.hr.ecommerce.order.common.DBUtils;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;
import com.hr.ecommerce.rquest.beans.RemoveItemReqBean;

@Service
public class RemoveOrderItemTask {

	@Autowired
	private HREcommerceExceptionFactory exceptionFactory;

	@Autowired
	private PrepareOrderTask prepareOrderTask;

	@Autowired
	private CalculateOrderTask calculateOrderTask;

	public String deleteOrderItem(String orderId, RemoveItemReqBean removeItemBean) throws Exception {

		Order order = DBUtils.retrieveOrder(orderId);

		if (null == order) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ERROR_ORDER_DOES_NOT_EXIST,
					new Object[] { orderId });
		}

		OrderStatusValidationUtil.isOrderInRightState(order);
		removeItemFromOrder(order.getOrderItems(), removeItemBean.getOrderItemId());

		order = prepareOrderTask.prepareOrder(order);
		DBUtils.saveOrder(order);

		if (isOrderCalculatable(order) && removeItemBean.getCalculateOrder()) {
			calculateOrderTask.calculateOrder(orderId);
		}
		return "SUCCESS";

	}

	private boolean isOrderCalculatable(Order order) {
		return null!=order.getOrderItems() && !order.getOrderItems().isEmpty();
	}

	private void removeItemFromOrder(List<OrderItem> orderItems, String orderItemId) {
		OrderItem orderItemToDelete = null;
		if (null == orderItems || StringUtils.isEmpty(orderItemId)) {
			throw exceptionFactory.createException(HREcommerceErrorConstants.ORDER_ITEM_NOT_FOUND,
					new Object[] { orderItemId });
		}
		for (OrderItem ordItem : orderItems) {
			if (ordItem.getOrderItemId().equalsIgnoreCase(orderItemId))
				orderItemToDelete = ordItem;
		}
		if (orderItemToDelete != null)
			orderItems.remove(orderItemToDelete);
		else
			throw exceptionFactory.createException(HREcommerceErrorConstants.ORDER_ITEM_NOT_FOUND,
					new Object[] { orderItemId });
	}

}
