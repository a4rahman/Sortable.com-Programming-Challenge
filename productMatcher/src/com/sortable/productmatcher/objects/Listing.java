package com.sortable.productmatcher.objects;

/**
 * A listing object.
 */
public class Listing {
	private String title;
	private String manufacturer;
	private String currency;
	private String price;
	
	/**
	 * Get the title of the listing.
	 * @return the listing title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Set the title of the listing.
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Get the manufacturer.
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * Set the manufacturer.
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/**
	 * Get the currency.
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Set the currency.
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Get the listing price.
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * Set the listing price.
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		
		strBuf.append("Title: ");
		strBuf.append(title);
		strBuf.append(", ");
		strBuf.append("Manufacturer: ");
		strBuf.append(manufacturer);
		strBuf.append(", ");
		strBuf.append("Currency: ");
		strBuf.append(currency);
		strBuf.append(", ");
		strBuf.append("Price: ");
		strBuf.append(price);
		
		return strBuf.toString();
	}
}
