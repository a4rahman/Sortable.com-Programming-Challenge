package com.sortable.productmatcher.matcher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sortable.productmatcher.objects.Listing;
import com.sortable.productmatcher.objects.Product;
import com.sortable.productmatcher.parsers.ListingParser;
import com.sortable.productmatcher.parsers.ProductParser;

/**
 * A class to call all relevant methods to match products with listings.
 */
public class ProductMatcherMain {
	/**
	 * Call all relevant methods to implement the match.
	 * @param args input files, the products file being the first and the listings being the second
	 * @throws FileNotFoundException when one of the input files is not found
	 * @throws IOException when there is an error reading the input files
	 */
	public static final void main(String[] args) throws FileNotFoundException, IOException {
		if (args.length != 2) {
			System.out.println("Invalid number of arguments, aborting...");
			System.exit(-1);
		}
		
		System.out.println("Reading products file...");
		Set<Product> products = retrieveProducts(args[0]);
		System.out.println("Reading listings file...");
		List<Listing> listings = retrieveListings(args[1]);	
		System.out.println("Initiating matching process, please wait...");
		ProductListingMatcher.matchProductsAndListings(products, listings);
		System.out.println("Matching process complete");
	}
	
	/**
	 * Retrieve a list of products from a given file.
	 * @param productsFilePath the path to the input file containing the product info
	 * @return a unique set of products
	 * @throws FileNotFoundException when the input file can't be found
	 * @throws IOException when there is a problem accessing the input file
	 */
	private static Set<Product> retrieveProducts(String productsFilePath) throws FileNotFoundException, IOException {
		Set<Product> products = new HashSet<Product>();
		ProductParser productParser = new ProductParser();
		
		FileReader productsFileReader = new FileReader(productsFilePath);
		BufferedReader productsFileBufferedReader = new BufferedReader(productsFileReader);
		
		String productsFileLine = null;
		int lineNum = 0;
		
		// Read the file line by line, parsing every line and populating the list
		while((productsFileLine = productsFileBufferedReader.readLine()) != null) {
			lineNum++;
			try {
				products.add(productParser.parse(productsFileLine));
			} catch (IllegalArgumentException iae) {
				System.out.println("Error at line " + lineNum + " of products file, ignoring line and "
						+ "continuing processing. Message: " + iae.getMessage());
			}
		}
		
		productsFileReader.close();
		productsFileBufferedReader.close();
		
		return products;
	}
	
	/**
	 * Retrieve a list of products from a given file.
	 * @param productsFilePath the path to the input file containing the product info
	 * @return a list of products
	 * @throws FileNotFoundException when the input file can't be found
	 * @throws IOException when there is a problem accessing/reading the input file
	 */
	private static List<Listing> retrieveListings(String listingsFilePath) throws FileNotFoundException, IOException {
		List<Listing> listings = new ArrayList<Listing>();
		ListingParser listingParser = new ListingParser();
		
		FileReader listingsFileReader = new FileReader(listingsFilePath);
		BufferedReader listingsFileBufferedReader = new BufferedReader(listingsFileReader);
		
		String listingsFileLine = null;
		int lineNum = 0;
		
		// Read the file line by line, parsing every line and populating the list
		while((listingsFileLine = listingsFileBufferedReader.readLine()) != null) {
			lineNum++;
			try {
				listings.add(listingParser.parse(listingsFileLine));
			} catch (IllegalArgumentException iae) {
				System.out.println("Error at line " + lineNum + " of listings file, ignoring line and " 
						+ "continuing processing. Message: " + iae.getMessage());
			}
		}
		
		listingsFileReader.close();
		listingsFileBufferedReader.close();
		
		return listings;
	}
}
