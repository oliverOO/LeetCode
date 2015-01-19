package com.leetcode;

public class ZigZagConversion {

	public static String convert(String s, int nRows) {
		String result = "";
		int index = 0;
		
		for(int i=1; i<=nRows; i++){
			index = i - 1;
			if(index >= s.length()) break;
			result = result + s.charAt(index);
			//最后一行
			if(nRows - i == 0){
				while(index <= s.length() - 1){
					index = index + 2 * (i - 1);
					if(index <= s.length() - 1){						
						result = result + s.charAt(index);
					}
				}
			}else{				
				while((index + 2 * (nRows - i)) <= s.length() - 1){
					index = index + 2 * (nRows - i);
					result = result + s.charAt(index);
					if((nRows - i) % (nRows-1) != 0){
						index = index + 2 * (i - 1);
						if(index <= s.length() - 1){						
							result = result + s.charAt(index);
						}
					}
				}
			}
		}

		return result;
	}
	
	public static String convert1(String s, int nRows) {
        StringBuffer[] sbs = new StringBuffer[nRows];
        for (int i = 0; i < nRows; i++)
            sbs[i] = new StringBuffer();
        int i = 0, n = s.length();
        while (i < n) {
            for (int j = 0; j < nRows && i < n; j++, i++)
                sbs[j].append(s.charAt(i));
            for (int j = nRows - 2; j > 0 && i < n; j--, i++)
                sbs[j].append(s.charAt(i));
        }
        for (i = 1; i < nRows; i++)
            sbs[0].append(sbs[i]);
        return sbs[0].toString();
    }
	
	public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("ABCDEFGHIJKLMNOPQ", 4));
//		System.out.println(convert1("ABCDEFGHIJKLMNOPQ", 4));
		System.out.println(convert("AB", 4));
	}
}
