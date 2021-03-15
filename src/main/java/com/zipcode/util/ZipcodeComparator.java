package com.zipcode.util;

import java.util.Comparator;

import com.zipcode.model.Zipcode;

public class ZipcodeComparator implements Comparator<Zipcode> {
  public int compare(Zipcode interval1, Zipcode interval2) {
    if (interval1.getLower_bound() > interval2.getLower_bound())
      return 1;
    else
      return -1;
  }
}
