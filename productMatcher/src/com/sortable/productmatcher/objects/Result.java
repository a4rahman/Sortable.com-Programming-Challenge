package com.sortable.productmatcher.objects;

import java.util.List;

/**
 * A result object.
 */
public class Result {
	private String productName;
	private List<Listing> listings;
	
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
	 * Get the listings for the product.
	 * @return the product listings
	 */
	public List<Listing> getListings() {
		return listings;
	}
	
	/**
	 * Set the listings for the product.
	 * @param listings the listings to set
	 */
	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}
	
	@Override
	public String toString() {
		StringBuffer resultBuf = new StringBuffer();
		
		resultBuf.append("Result ");
		resultBuf.append(System.getProperty("line.separator"));
		resultBuf.append("----------------------------");
		resultBuf.append(System.getProperty("line.separator"));
		resultBuf.append("Product name: ");
		resultBuf.append(productName);
		resultBuf.append(System.getProperty("line.separator"));
		resultBuf.append("Listings: ");
		resultBuf.append(System.getProperty("line.separator"));
		for (Listing listing : listings) {
			resultBuf.append(listing);
			resultBuf.append(System.getProperty("line.separator"));
		}	
		
		return resultBuf.toString();
	}
}
