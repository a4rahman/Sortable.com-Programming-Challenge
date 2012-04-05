package com.sortable.productmatcher.parsers;

import com.sortable.productmatcher.objects.Listing;

/**
 * An object to parse listing file lines.
 */
public class ListingParser extends LineParser {
	
	@Override
	public Listing parse(String line) {
		if (!line.isEmpty()) {
			Listing listing = new Listing();
			
			// Strip the opening and closing curly braces
			String strippedLine = stripString(line, LINE_BEGINNING, LINE_END);
			
			// Extract the property-value pairs
			String[] properties = PROPERTY_DELIMITER.split(strippedLine);
			
			// Iterate through the array of property-value pairs and build a <code>Listing</code> 
			for (String property : properties) {
				String[] propertyAndValue = VALUE_DELIMITER.split(property);
				if (2 == propertyAndValue.length) {
					String propertyToken = propertyAndValue[0];
					String valueToken = propertyAndValue[1];
					// Populate the listing
					populateListing(listing, propertyToken, valueToken);
				}
			}
			return listing;
		}
		return null;
	}
	
	/**
	 * Populate a listing given a property token and a value.
	 * @param listing the listing to populate
	 * @param propertyToken the token that determines which field to populate
	 * @param value the value to populate the product with
	 */
	private void populateListing(Listing listing, String propertyToken, String value) {
		if (TITLE.equals(propertyToken)) {
			listing.setTitle(value);
		} else if (CURRENCY.equals(propertyToken)) {
			listing.setCurrency(value);
		} else if (PRICE.equals(propertyToken)) {
			listing.setPrice(value);
		} else if (MANUFACTURER.equals(propertyToken)) {
			listing.setManufacturer(value);
		}
	}
}
