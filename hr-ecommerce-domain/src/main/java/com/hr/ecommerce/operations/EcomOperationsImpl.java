package com.hr.ecommerce.operations;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.ecommerce.model.Product;
import com.hr.ecommerce.model.ProductAttributes;
import com.hr.ecommerce.persistence.helper.PersistenceHelper;
import com.hr.ecommerce.request.CreateProductRequest;



@Service
public class EcomOperationsImpl implements EcomOperations {
	
	
	@Autowired
	private PersistenceHelper persistenceHelper;

	

	public String saveProduct(CreateProductRequest productrequest) throws Exception {
		persistenceHelper.saveProduct(getProduct(productrequest));
		return "Product Added Successfully";
	}

	private Product getProduct(CreateProductRequest productrequest) {
		Product prod  = new Product();
		prod.setProductId(StringUtils.isNotEmpty(productrequest.getProductId())?productrequest.getProductId():"");
		prod.setProductCode(StringUtils.isNotEmpty(productrequest.getProductCode())?productrequest.getProductCode():"");
		prod.setProductName(StringUtils.isNotEmpty(productrequest.getProductName())?productrequest.getProductName():"");
		prod.setProductImage(StringUtils.isNotEmpty(productrequest.getProductImage())?productrequest.getProductImage():"");
		prod.setDescription(StringUtils.isNotEmpty(productrequest.getDescription())?productrequest.getDescription():"");
		prod.setProductAttributes(getProductAttributes(productrequest));
		return prod;
	}

	private ProductAttributes getProductAttributes(CreateProductRequest productrequest) {
		ProductAttributes targetAttributes= new ProductAttributes();
		if(null==productrequest.getProductAttributes()) 
			return targetAttributes;
		
		targetAttributes.setDimensions(StringUtils.isNotEmpty(productrequest.getProductAttributes().getDimensions())?productrequest.getProductAttributes().getDimensions():"");
		targetAttributes.setColor(StringUtils.isNotEmpty(productrequest.getProductAttributes().getColor())?productrequest.getProductAttributes().getColor():"");
		targetAttributes.setChipset(StringUtils.isNotEmpty(productrequest.getProductAttributes().getChipset())?productrequest.getProductAttributes().getChipset():"");
		targetAttributes.setRam(StringUtils.isNotEmpty(productrequest.getProductAttributes().getRam())?productrequest.getProductAttributes().getRam():"");
		targetAttributes.setBatteryCapacity(StringUtils.isNotEmpty(productrequest.getProductAttributes().getBatteryCapacity())?productrequest.getProductAttributes().getBatteryCapacity():"");
		return targetAttributes;
	}

	public String retrieveProduct(String productId) throws Exception {
		return new ObjectMapper().writeValueAsString(persistenceHelper.retrieveProduct(productId));
		

	}

}
