package com.zipcode.util;

import java.util.Comparator;

import com.zipcode.model.Zipcode;

/**
 * @author varun
 * ZipcodeComparator.class is to sort based on the lower bound of zipcode from the list
 */
public class ZipcodeComparator implements Comparator<Zipcode> {
  public int compare(Zipcode interval1, Zipcode interval2) {
    if (interval1.getLowerBound() > interval2.getLowerBound())
      return 1;
    else
      return -1;
  }
}
