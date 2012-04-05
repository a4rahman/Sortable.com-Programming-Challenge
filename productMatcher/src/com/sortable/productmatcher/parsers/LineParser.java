package com.sortable.productmatcher.parsers;

import java.util.regex.Pattern;

/**
 * Object providing basic functionality to parse an input file line.
 */
public abstract class LineParser {
	
	// Properties representing text from input files
	
	protected static final String LINE_BEGINNING = "{\"";
	protected static final String LINE_END = "\"}";
	protected static final Pattern PROPERTY_DELIMITER = Pattern.compile("\",\"");
	protected static final Pattern VALUE_DELIMITER = Pattern.compile("\":\"");
	protected static final String PRODUCT_NAME = "product_name";
	protected static final String MANUFACTURER = "manufacturer";
	protected static final String FAMILY = "family";
	protected static final String MODEL = "model";
	protected static final String ANNOUNCED_DATE = "announced-date";
	protected static final String TITLE = "title";
	protected static final String CURRENCY = "currency";
	protected static final String PRICE = "price";
	
	/**
	 * Strip the beginning and ending of a String given the subStrings to remove.
	 * @param original the original String
	 * @param beginning the subString to strip from the beginning of the original String
	 * @param end the subString to strip from the end of the original String
	 * @return the stripped String
	 */
	protected String stripString(String original, String beginning, String end) {
		int strLength = original.length();
		
		// Validate the original String
		if (original.isEmpty() || strLength < 4) {
			throw new IllegalArgumentException("String length too short");
		}
		
		String firstTwoCharacters = original.substring(0, 2);
		String lastTwoCharacters = original.substring(strLength - 2);
		
		// More validation - assume the String starts and ends with the provided characters
		if (!beginning.equals(firstTwoCharacters) || !end.equals(lastTwoCharacters)) {
			throw new IllegalArgumentException("Invalid String format, must begin with " + beginning + " and end with " + end);
		}
		
		// Return the stripped version of the original String
		return original.substring(2, strLength - 2);
	}
	
	/**
	 * Parse an input file line.
	 * @param line the line to parse
	 * @return an instance of an object populated with the parse results
	 */
	protected abstract Object parse(String line);
}
