package com.sortable.productmatcher.matcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.sortable.productmatcher.objects.Listing;
import com.sortable.productmatcher.objects.Product;
import com.sortable.productmatcher.objects.Result;

/**
 * A class providing functionality to match products to listings.
 */
public class ProductListingMatcher {
	
	private static final char PRODUCT_NAME_DELIMITER = '_';
	private static final String SPACE = " ";
	
	/**
	 * Match products to listings.
	 * @param products set of products
	 * @param listings list of listings to match with
	 */
	public static void matchProductsAndListings(Set<Product> products, List<Listing> listings) {
		Map<String, List<Listing>> productListingMap = new HashMap<String, List<Listing>>();
		for (Product product: products) {
			String model = product.getModel();
			String manufacturer = product.getManufacturer();
			String family = product.getFamily();
			// Strip the underscores from the product name
			String spaceDelimitedProductName = product.getProductName().replace(PRODUCT_NAME_DELIMITER, ' ');
			for (Listing listing : listings) {
				String title = listing.getTitle();
				String listingManufacturer = listing.getManufacturer();
				// When a match is found, dump it in a map
				if (title.contains(convertToWord(model)) 
						&& (title.contains(manufacturer) || (listingManufacturer != null ? listingManufacturer.contains(manufacturer) : true)) 
						&& (family != null ? title.contains(convertToWord(family)) : true)) {
					if (!productListingMap.containsKey(spaceDelimitedProductName)) {
						productListingMap.put(spaceDelimitedProductName, new ArrayList<Listing>());
					}
					productListingMap.get(spaceDelimitedProductName).add(listing);
				}
			}
		}
		
		// Print out the matches
		for (Entry<String, List<Listing>> entry : productListingMap.entrySet()) {
			Result result = new Result();
			result.setProductName(entry.getKey());
			result.setListings(entry.getValue());
			System.out.println(result);
			System.out.println("Total " + entry.getValue().size());
			System.out.println(System.getProperty("line.separator"));
		}
		
	}
	
	/**
	 * Convert a String to a word by prepending and appending spaces.
	 * @param str the String to convert
	 * @return the converted String
	 */
	private static String convertToWord(String str) {
		StringBuffer strBuf = new StringBuffer();
		
		strBuf.append(SPACE);
		strBuf.append(str);
		strBuf.append(SPACE);
		
		return strBuf.toString();
	}
}
