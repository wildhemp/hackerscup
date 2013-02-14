package com.wildhemp.facebook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class FindTheMin {

    private static final int[] NUMBERS = new int[1000001];
    private static final int[] USED = new int[1000001];

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	BufferedReader dis = new BufferedReader(new InputStreamReader(
		new FileInputStream(args[0])));
	int testNum = Integer.parseInt(dis.readLine());
	System.setOut(new PrintStream("testout_findmin.txt"));
	for (int test = 0; test < testNum; test++) {
	    String[] nums = dis.readLine().split(" ");
	    int n = Integer.parseInt(nums[0]);
	    int k = Integer.parseInt(nums[1]);

	    nums = dis.readLine().split(" ");
	    int a = Integer.parseInt(nums[0]);
	    int b = Integer.parseInt(nums[1]);
	    int c = Integer.parseInt(nums[2]);
	    int r = Integer.parseInt(nums[3]);

	    Arrays.fill(USED, 0, k + 1, 0);
	    
	    NUMBERS[0] = a;
	    if (a <= k) {
		USED[a] ++;
	    }
	    for (int idx = 1; idx < k; idx++) {
		int num = (int)(((long)b * NUMBERS[idx - 1] + c) % r);
		NUMBERS[idx] = num;

		if (num <= k ) {
		    USED[num] ++;
		}
	    }

	    int next = 0;
	    for (int idx = 0; idx <= k; idx++) {
		for (int pos = next; pos <= k; pos ++) {
		    if (USED[pos] == 0) {
			USED[pos] ++;
			if (NUMBERS[idx] <= k) {
			    USED[NUMBERS[idx]] --;
			}
			if (NUMBERS[idx] < pos && USED[NUMBERS[idx]] == 0) {
			    next = NUMBERS[idx];
			} else {
			    next = pos;
			}
			NUMBERS[idx] = pos;
			break;
		    }
		}
	    }

	    System.out.println("Case #" + (test + 1) + ": " + NUMBERS[n % (k + 1)]);
	}
    }

}
