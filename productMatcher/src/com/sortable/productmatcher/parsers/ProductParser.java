package com.sortable.productmatcher.parsers;

import com.sortable.productmatcher.objects.Product;

/**
 * An object to parse product file lines.
 */
public class ProductParser extends LineParser {
	
	@Override
	public Product parse(String line) {
		if (!line.isEmpty()) {
			Product product = new Product();
			
			// Strip the opening and closing curly braces
			String strippedLine = stripString(line, LINE_BEGINNING, LINE_END);
			
			// Extract the property-value pairs
			String[] properties = PROPERTY_DELIMITER.split(strippedLine);
			
			// Iterate through the array of property-value pairs and build a <code>Product</code> 
			for (String property : properties) {
				String[] propertyAndValue = VALUE_DELIMITER.split(property);
				if (2 == propertyAndValue.length) {
					String propertyToken = propertyAndValue[0];
					String valueToken = propertyAndValue[1];
					// Populate the product
					populateProduct(product, propertyToken, valueToken);
				}
			}
			return product;
		}
		return null;
	}
	
	/**
	 * Populate a product given a property token and a value.
	 * @param product the product to populate
	 * @param propertyToken the token that determines which field to populate
	 * @param valueToken the value to populate the product with
	 */
	private void populateProduct(Product product, String propertyToken, String valueToken) {
		if (PRODUCT_NAME.equals(propertyToken)) {
			product.setProductName(valueToken);
		} else if (MODEL.equals(propertyToken)) {
			product.setModel(valueToken);
		} else if (FAMILY.equals(propertyToken)) {
			product.setFamily(valueToken);
		} else if (MANUFACTURER.equals(propertyToken)) {
			product.setManufacturer(valueToken);
		} else if (FAMILY.equals(propertyToken)) {
			product.setFamily(valueToken);
		} else if (ANNOUNCED_DATE.equals(propertyToken)) {
			product.setAnnouncedDate(valueToken);
		}
	}
	
}
