package com.zipcode.application;

import java.util.List;
import java.util.Scanner;

import com.zipcode.model.Zipcode;
import com.zipcode.util.ZipcodeMerger;
import com.zipcode.util.ZipcodeProcessor;

/**
 * @author varun
 * This class reads the input and drives the zip code
 */
public class Application {
  private static Scanner scan;

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    String zipcodeRanges = scan.nextLine();
    ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(zipcodeRanges);
    List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    ZipcodeMerger zipcodeMerger = new ZipcodeMerger();
    List<Zipcode> sortedZipCodeList = zipcodeMerger.sortByLowerBounds(zipcodeList);
    List<Zipcode> mergedZipcodeList = zipcodeMerger.mergeZipcodes(sortedZipCodeList);
    for (Zipcode zipcode : mergedZipcodeList) {
      System.out.println("[" + zipcode.getLowerBound() + "," + zipcode.getUpperBound() + "]");
    }

  }
}
