package com.sortable.productmatcher.objects;

/**
 * A Product object.
 */
public class Product {
	private String productName;
	private String manufacturer;
	private String family;
	private String model;
	private String announcedDate;
	
	/**
	 * Get the name of the product.
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * Set the name of the product.
	 * @param productName the name to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**
	 * Get the product manufacturer.
	 * @return the product manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * Set the manufacturer of the product 
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/**
	 * Get the product family
	 * @return the product family
	 */
	public String getFamily() {
		return family;
	}
	
	/**
	 * Set the product family.
	 * @param family the product family
	 */
	public void setFamily(String family) {
		this.family = family;
	}
	
	/**
	 * Get the model of the product.
	 * @return the product model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Set the product model.
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * Get the date the product was announced.
	 * @return the product announcement date
	 */
	public String getAnnouncedDate() {
		return announcedDate;
	}
	
	/**
	 * Set the date the product was announced.
	 * @param announcedDate the product announcement date to set
	 */
	public void setAnnouncedDate(String announcedDate) {
		this.announcedDate = announcedDate;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		
		strBuf.append("Product name: ");
		strBuf.append(productName);
		strBuf.append(", ");
		strBuf.append("Manufacturer: ");
		strBuf.append(manufacturer);
		strBuf.append(", ");
		strBuf.append("Family: ");
		strBuf.append(family);
		strBuf.append(", ");
		strBuf.append("Model: ");
		strBuf.append(model);
		strBuf.append(", ");
		strBuf.append("Announced date: ");
		strBuf.append(announcedDate);
		
		return strBuf.toString();
	}
}
