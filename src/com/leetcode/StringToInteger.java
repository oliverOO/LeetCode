package com.leetcode;

import java.util.regex.Pattern;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author zhangjingbo
 * @date 2015年1月19日
 * @version 1.0
 */
public class StringToInteger {

	//The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
	//Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
	//The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
	//If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
	//If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
	public static int atoi(String str) {
		Pattern p = Pattern.compile("\\d"); 
		
		if(str == null || str.trim() == "") return 0;
		String result = str.trim();
		int sign = 1;
		int num = 0;
		if(result.startsWith("-")){
			sign = -1;
			result = result.substring(1, result.length());
		}
		for(int i=0; i<result.length(); i++){
			if(!p.matcher(String.valueOf(result.charAt(i))).matches()){
				return 0;
			}
			//如果最后一位>最大值的最后一位
			if(num > Integer.MAX_VALUE/10 || Integer.MAX_VALUE - 10 * num < Integer.parseInt(String.valueOf(result.charAt(i)))){
				if(sign == -1){
					return Integer.MIN_VALUE;
				}
				return Integer.MAX_VALUE;
			}
			num = 10 * num + Integer.parseInt(String.valueOf(result.charAt(i)));
		}
		
		return num * sign;
	}
	
	public static int atoi1(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;
        int result = 0, i = 0;
        boolean negtive = false;
        if (str.charAt(0) == '-') {
            negtive = true;
            i = 1;
        } else if (str.charAt(0) == '+') {
            i = 1;
        }
        int maxSubTen = Integer.MAX_VALUE / 10;
        for (; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++) {
            if (maxSubTen < result || Integer.MAX_VALUE - (result * 10) < (str.charAt(i) - '0')) {
                if (negtive) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            result = result * 10 + (str.charAt(i) - '0');
        }
        if (negtive)
            result = -result;
        return result;
    }

	public static void main(String[] args){
		System.out.println(atoi("-44699"));
		System.out.println(atoi("123"));
		System.out.println(atoi("    123"));
		System.out.println(atoi("+123"));
		System.out.println(atoi(" -123"));
		System.out.println(atoi("123ABC"));
		System.out.println(atoi(" abc123ABC"));
		System.out.println(atoi("2147483647"));
		System.out.println(atoi("-2147483648"));
		System.out.println(atoi("2147483648"));
		System.out.println(atoi("-2147483649"));
		System.out.println(atoi("2147483639"));
	}
}
