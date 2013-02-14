package com.wildhemp.facebook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class BeautifulStrings {

    /**
     * @param args
     * @throws IOException 
     * @throws NumberFormatException 
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader dis = new BufferedReader(new InputStreamReader(
		new FileInputStream(args[0])));
	int testNum = Integer.parseInt(dis.readLine());
	System.setOut(new PrintStream("testout_beautiful.txt"));
	for (int test = 0; test < testNum; test++) {
	    char[] chars = dis.readLine().toUpperCase().toCharArray();
	    int[] charNums = new int['Z' - 'A' + 1];
	    for (char ch: chars) {
		if (ch >= 'A' && ch <= 'Z') {
		    charNums[ch - 'A'] ++;
		}
	    }
	    Arrays.sort(charNums);
	    int sum = 0;
	    for (int idx = 0; idx < charNums.length; idx ++) {
		sum += charNums[idx] * (idx + 1);
	    }
	    
	    System.out.println("Case #" + (test + 1) + ": " + sum);
	}
    }

}
