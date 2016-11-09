package com.music.store.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.music.store.entities.Product;

public class ProductFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
				
		if (product.getPrice() <= 0) {
			errors.rejectValue("price", "negativeValue", new Object[]{"Price"}, "price can\'t be negative");
		}
		
		if (product.getUnitStock() <= 0) {
			errors.rejectValue("unitStock", "negativeValue", new Object[]{"Unit in stock"}, "unit in stock can\'t be negative");
		}
				
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		
	}

}
