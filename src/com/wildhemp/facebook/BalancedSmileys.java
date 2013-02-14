package com.wildhemp.facebook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedSmileys {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
	BufferedReader dis = new BufferedReader(new InputStreamReader(
		new FileInputStream(args[0])));
	
	int testNum = Integer.parseInt(dis.readLine());
	for (int test = 0; test < testNum; test++) {
	    char[] str = dis.readLine().toCharArray();

	    System.out.println("Case #" + (test + 1) + ": "
		    + (isBalanced(str, 0, str.length - 1) ? "YES" : "NO"));
	}
    }

    private static boolean isBalanced(char[] str, int sIdx, int eIdx) {
	boolean wasColon = false;
	while (sIdx <= eIdx) {
	    if (str[sIdx] == '(') {
		boolean ok = false;
		int teIdx = eIdx;
		while (teIdx > sIdx) {
		    if (str[teIdx] == ')') {
			if (isBalanced(str, sIdx + 1, teIdx - 1)) {
			    sIdx = teIdx + 1;
			    ok = true;
			    break;
			}
		    }
		    
		    teIdx --;
		}
		
		if (ok) {
		    continue;
		} else if (!wasColon) {
		    return false;
		}
	    } else if (str[sIdx] == ')' && !wasColon) {
		return false;
	    }
	    
	    wasColon = str[sIdx] == ':';

	    sIdx ++;
	}

	return true;
    }
}
