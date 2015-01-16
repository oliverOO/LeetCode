package com.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author zhangjingbo
 * @date 2015年1月16日
 * @version 1.0
 */
public class LongestSubstringWithoutRepeatingCharacters {
	//Given a string, find the length of the longest substring without repeating characters. 
	//For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
	//For "bbbbb" the longest substring is "b", with the length of 1.

	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		LinkedHashMap<String, String> tempMap2 = new LinkedHashMap<String, String>();
		for(int i=0; i<s.length(); i++){
			if(tempMap2.get(String.valueOf(s.charAt(i))) == null){
				tempMap2.put(String.valueOf(s.charAt(i)), String.valueOf(s.charAt(i)));
			}else{
				if(tempMap2.size() > max){		
					max = tempMap2.size();
					tempMap2 = remove(tempMap2, String.valueOf(s.charAt(i)));
				}
				tempMap2.put(String.valueOf(s.charAt(i)), String.valueOf(s.charAt(i)));
			}
		}
		return max;
	}
	
	private static LinkedHashMap remove(LinkedHashMap<String, String> tempMap, String str){
		Iterator iterator = tempMap.keySet().iterator();
		while(iterator.hasNext()){
			String temp = String.valueOf(iterator.next());
			if(temp.equals(str)){
				iterator.remove();
				return tempMap;
			}else{
				iterator.remove();				
			}
		}
		return tempMap;
	}
	
	public static int lengthOfLongestSubstring1(String s) {
		if(s == null){			
			return 0;
		}
		Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
		int max = 0, length = 0;
		for(int i = 0; i < s.length(); i++) {
			length++;
			//if found repeating char, check if the char is in the current substring
			if(dic.containsKey(s.codePointAt(i)) && length > (i - dic.get(s.codePointAt(i)))) {
				length = i - dic.get(s.codePointAt(i));
			}
			// get the longest substring
			max = Math.max(length, max);
			dic.put(s.codePointAt(i), i);
		}
		return max;
	}
	
	public static void main(String[] args){
		int index = lengthOfLongestSubstring("aaaaaabcdabcdefgaabbbcdebcd");
//		int index = lengthOfLongestSubstring1("张张张靖博");
		System.out.println(index);
	}
}
