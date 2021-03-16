package com.zipcode.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.zipcode.model.Zipcode;

/**
 * @author varun 
 * This class is merges the zipcode ranges and returns the final list
 */
public class ZipcodeMerger {

	/**
	 * method is to sort By LowerBounds list and return List
	 * @param zipcodeRangeList
	 * @return
	 */
	public List<Zipcode> sortByLowerBounds(List<Zipcode> zipcodeRangeList) {
		Collections.sort(zipcodeRangeList, new ZipcodeComparator());
		return zipcodeRangeList;
	}

	/**
	 * method is to mergeZipCodes and return List
	 * @param sortedZipCodeList
	 * @return
	 */
	public List<Zipcode> mergeZipcodes(List<Zipcode> sortedZipCodeList) {
		List<Zipcode> mergedZipcodeList = new LinkedList<Zipcode>();
		Zipcode zipcode = null;
		for (Zipcode zipcodeInterval : sortedZipCodeList) {
			if (zipcode == null)
				zipcode = zipcodeInterval;
			else {
				if (zipcode.getUpperBound() >= zipcodeInterval.getLowerBound()) {
					zipcode.setUpperBound(Math.max(zipcode.getUpperBound(), zipcodeInterval.getUpperBound()));
				} else {
					mergedZipcodeList.add(zipcode);
					zipcode = zipcodeInterval;
				}
			}
		}
		mergedZipcodeList.add(zipcode);
		return mergedZipcodeList;
	}

}
