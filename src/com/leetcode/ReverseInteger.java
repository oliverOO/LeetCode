package com.leetcode;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author zhangjingbo
 * @date 2015年1月19日
 * @version 1.0
 */
public class ReverseInteger {
	
	//直观
	public static int reverse(int x) {
		int n = 0;
		int y = 0;
		while(x != 0){
			n = x % 10;
			if(y > Integer.MAX_VALUE/10 || y < Integer.MIN_VALUE/10){
				return 0;
			}
			y = y * 10 + n;
			x = x/10;
		}
		
		return y;
	}

	public static int reverse1(int x) {
		if(x == Integer.MIN_VALUE){
			return 0;
		}
		int sign = x < 0 ? -1 : 1;
		int positive = Math.abs(x);
        int result = 0;
        while (positive != 0) {
            if (result > (Integer.MAX_VALUE - positive % 10) / 10)
                return 0;
            result = 10 * result + positive % 10;
            positive /= 10;
        }
        return result * sign;
	}

	public static void main(String[] args){
		System.out.println(reverse(2147483647));//8463847412
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
