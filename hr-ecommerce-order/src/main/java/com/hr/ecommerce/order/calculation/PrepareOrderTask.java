package com.hr.ecommerce.order.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.hr.ecommerce.order.model.Discount;
import com.hr.ecommerce.order.model.ItemInfo;
import com.hr.ecommerce.order.model.Order;
import com.hr.ecommerce.order.model.OrderItem;
import com.hr.ecommerce.order.model.ShippingCharge;
import com.hr.ecommerce.order.model.Tax;

@Service
public class PrepareOrderTask {

	public static final String ZERO_CHARGE = "0.00";

	private BigDecimal totalShipping, totalNetShipping, totalShippingDiscount, totalTax, totalMerchandise,
			totalDiscount, totalBeforeTaxes, orderTotal ;

	public Order prepareOrder(Order order) {
		
	  totalShipping = totalTax = totalMerchandise = totalNetShipping = totalShippingDiscount = totalDiscount = totalBeforeTaxes = orderTotal = new BigDecimal(NumberUtils.INTEGER_ZERO);

		/**
		 * Calculate all order entities at order item level and then promote total
		 * charge to orderLevel;
		 */

		if (null != order && null != order.getOrderItems() && !order.getOrderItems().isEmpty()) {
			calculateOrder(order);
		} else {
			resetOrder(order);
		}

		return order;

	}

	private void calculateOrder(Order order) {

		for (OrderItem orderItem : order.getOrderItems()) {
			calculateOrderItem(orderItem);
		}
		setOrderTotals(order);
	}

	private void resetOrder(Order order) {
		if (null != order) {
			order.setTotalTax(ZERO_CHARGE);
			order.setTotalDiscount(ZERO_CHARGE);
			order.setTotalShipping(ZERO_CHARGE);
			order.setTotalProduct(ZERO_CHARGE);
			order.setTotalNetShipping(ZERO_CHARGE);
			order.setTotalShippingDiscount(ZERO_CHARGE);
			order.setTotalBeforeTaxes(ZERO_CHARGE);
			order.setOrderTotal(ZERO_CHARGE);
		}

	}

	private void setOrderTotals(Order order) {

		totalNetShipping = totalShipping.add(totalShippingDiscount);
		totalBeforeTaxes = totalBeforeTaxes.add(totalMerchandise).add(totalNetShipping).add(totalDiscount);
		orderTotal = orderTotal.add(totalMerchandise).add(totalNetShipping).add(totalDiscount).add(totalTax);
		order.setTotalTax(totalTax.setScale(2, RoundingMode.HALF_UP).toPlainString());
		order.setTotalDiscount(totalDiscount.setScale(2, RoundingMode.HALF_UP).toPlainString());
		order.setTotalShipping(totalShipping.setScale(2, RoundingMode.HALF_UP).toPlainString());
		order.setTotalProduct(totalMerchandise.setScale(2, RoundingMode.HALF_UP).toPlainString());
		order.setTotalNetShipping(totalNetShipping.setScale(2, RoundingMode.HALF_UP).toPlainString());
		order.setTotalShippingDiscount(totalShippingDiscount.setScale(2, RoundingMode.HALF_UP).toPlainString());
		order.setTotalBeforeTaxes(totalBeforeTaxes.setScale(2, RoundingMode.HALF_UP).toPlainString());
		order.setOrderTotal(orderTotal.setScale(2, RoundingMode.HALF_UP).toPlainString());
	}

	protected void calculateOrderItem(OrderItem orderItem) {
		totalShipping = totalShipping.add(calculateTotalShipping(orderItem.getShippingCharge()));
		totalShippingDiscount = totalShippingDiscount.add(calculateTotalShippingDiscount(orderItem.getDiscount()));
		totalTax = totalTax.add(calculateTotalTax(orderItem.getTax()));
		totalMerchandise = totalMerchandise.add(calculateTotalMerchandise(orderItem.getItemInfo()));
		totalDiscount = totalDiscount.add(calculateTotalOrderDiscount(orderItem.getDiscount()));
	}

	private BigDecimal calculateTotalOrderDiscount(Discount discount) {
		BigDecimal totalOrderDiscount = new BigDecimal(NumberUtils.INTEGER_ZERO);
		if (null == discount || StringUtils.isEmpty(discount.getOrderDiscount()))
			return totalOrderDiscount;
		totalShippingDiscount = totalShippingDiscount
				.add(StringUtils.isNotEmpty(discount.getOrderDiscount()) ? new BigDecimal(discount.getOrderDiscount())
						: new BigDecimal(NumberUtils.INTEGER_ZERO));

		return totalOrderDiscount;
	}

	protected BigDecimal calculateTotalTax(Tax tax) {
		if (null == tax)
			return new BigDecimal(NumberUtils.INTEGER_ZERO);
		return StringUtils.isNotEmpty(tax.getTotalTax()) ? new BigDecimal(tax.getTotalTax())
				: new BigDecimal(NumberUtils.INTEGER_ZERO);
	}

	protected BigDecimal calculateTotalMerchandise(ItemInfo itemInfo) {
		if (null == itemInfo)
			return new BigDecimal(NumberUtils.INTEGER_ZERO);
		return StringUtils.isNotEmpty(itemInfo.getTotalProduct()) ? new BigDecimal(itemInfo.getTotalProduct())
				: new BigDecimal(NumberUtils.INTEGER_ZERO);
	}

	protected BigDecimal calculateTotalShipping(ShippingCharge shippingCharge) {
		if (null == shippingCharge)
			return new BigDecimal(NumberUtils.INTEGER_ZERO);
		return StringUtils.isNotEmpty(shippingCharge.getTotalShipping())
				? new BigDecimal(shippingCharge.getTotalShipping())
				: new BigDecimal(NumberUtils.INTEGER_ZERO);
	}

	private BigDecimal calculateTotalShippingDiscount(Discount discount) {
		BigDecimal totalShpDiscount = new BigDecimal(NumberUtils.INTEGER_ZERO);
		if (null == discount || StringUtils.isEmpty(discount.getShippingDiscount()))
			return totalShpDiscount;
		totalShpDiscount = totalShippingDiscount.add(
				StringUtils.isNotEmpty(discount.getShippingDiscount()) ? new BigDecimal(discount.getShippingDiscount())
						: new BigDecimal(NumberUtils.INTEGER_ZERO));

		return totalShpDiscount;
	}

}
