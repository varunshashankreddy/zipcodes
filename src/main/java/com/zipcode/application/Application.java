package com.zipcode.application;

import java.util.List;
import java.util.Scanner;

import com.zipcode.model.Zipcode;
import com.zipcode.util.ZipcodeMerger;
import com.zipcode.util.ZipcodeProcessor;

public class Application {
  private static Scanner scan;

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    String zipcodeRanges = scan.nextLine();
    ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(zipcodeRanges);
    List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    ZipcodeMerger zipcode_merger = new ZipcodeMerger();
    List<Zipcode> sortedZipCodeList = zipcode_merger.sortByLowerBounds(zipcodeList);
    List<Zipcode> mergedZipcodeList = zipcode_merger.mergeZipcodes(sortedZipCodeList);
    for (Zipcode zipcode : mergedZipcodeList) {
      System.out.println("[" + zipcode.getLower_bound() + "," + zipcode.getUpper_bound() + "]");
    }

  }
}
