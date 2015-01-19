package com.leetcode;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author zhangjingbo
 * @date 2015年1月19日
 * @version 1.0
 */
public class PalindromeNumber {

	public static boolean isPalindrome(int x) {
		x = Math.abs(x);
		String str = String.valueOf(x);
		for(int i=0; i<str.length()/2; i++){
			if(str.charAt(i) != str.charAt(str.length() - 1 -i)){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int temp = x, result = 0;
        while (temp != 0) {
            if (result > (Integer.MAX_VALUE - temp % 10) / 10)
                return false;
            result = result * 10 + temp % 10;
            temp /= 10;
        }
        return result == x;
    }
	
	public static void main(String[] args){
		System.out.println(isPalindrome(2142));
		System.out.println(isPalindrome1(2142));
	}
}
