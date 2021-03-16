package com.zipcode.model;

/**
 * @author varun 
 * This is model to store the lower bound and upper bound of zipcode
 */
public class Zipcode {
	private int lowerBound;
	private int upperBound;

	public Zipcode(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int upperBound) {
		this.upperBound = upperBound;
	}

}
