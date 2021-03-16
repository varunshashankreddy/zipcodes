package com.zipcode.util;

import java.util.LinkedList;
import java.util.List;

import com.zipcode.model.Zipcode;

/**
 * @author varun 
 * This class is validating the input and load them to linkedlist
 * 
 */
public class ZipcodeProcessor {
	private String zipcodeRanges;

	public ZipcodeProcessor(String zipcodeRanges) {
		this.zipcodeRanges = zipcodeRanges;
	}

	public List<Zipcode> stripZipcode() {
		String[] zipcodeIntervals = zipcodeRanges.split(" ");
		return loadZipcode(zipcodeIntervals);
	}

	/**
	 * method is to convert String to Int
	 * @param zipcode
	 * @return
	 */
	public int stringToInt(String zipcode) {
		return Integer.parseInt(zipcode);
	}

	/**
	 * method to check the zipcode Length
	 * @param zipcode
	 * @return
	 */
	public boolean checkZipLength(int zipcode) {
		if ((int) (Math.log10(zipcode) + 1) != 5)
			return false;
		return true;
	}

	/**
	 * method is to compare Zip code Range
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public boolean compareZipcodeRange(int lowerBound, int upperBound) {
		if (lowerBound > upperBound)
			return false;
		return true;
	}

	/**
	 * method is to validate the Zip code Range
	 * @param lowerBounds
	 * @param upperBound
	 * @return
	 */
	public boolean validateZipcodeRange(int lowerBound, int upperBound) {
		if (!checkZipLength(lowerBound) && !checkZipLength(upperBound))
			throw new IllegalArgumentException(lowerBound + " " + upperBound + ": " + "Zipcode should have 5 digits");
		if (compareZipcodeRange(lowerBound, upperBound) == false)
			throw new IllegalArgumentException(
					lowerBound + " " + upperBound + ":  " + "Zipcode lower bound should be less than upper bound");
		return true;
	}

	/**
	 * @param zipRange
	 * @return
	 */
	public Zipcode validateAndAdd(String[] zipRange) {
		if (zipRange.length != 2)
			throw new IllegalArgumentException(zipRange[0] + "Zipcode should have lower and upper bounds");
		int lowerBound = stringToInt(zipRange[0]);
		int upperBound = stringToInt(zipRange[1]);
		Zipcode zipcode = null;
		if (validateZipcodeRange(lowerBound, upperBound) == true)
			zipcode = new Zipcode(lowerBound, upperBound);
		return zipcode;
	}

	/**
	 * @param zipcodeRange
	 * @return
	 */
	public Zipcode getZipcodeRange(String zipcodeRange) {
		return validateAndAdd(zipcodeRange.replaceAll("\\[|\\]", "").split(","));
	}

	/**
	 * @param zipcodeRange
	 * @return
	 */
	public List<Zipcode> loadZipcode(String[] zipcodeRange) {
		List<Zipcode> zipcodesList = new LinkedList<Zipcode>();
		for (int i = 0; i < zipcodeRange.length; i++) {
			zipcodesList.add(getZipcodeRange(zipcodeRange[i]));
		}
		return zipcodesList;
	}
}
