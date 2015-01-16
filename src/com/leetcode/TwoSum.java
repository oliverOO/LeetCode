package com.leetcode;

/** 
 * Description: TODO[描述该类概要功能介绍]
 *
 * @author zhangjingbo
 * @date 2015年1月15日
 * @version 1.0 
 */
public class TwoSum {
	
	
//	Given an array of integers, find two numbers such that they add up to a specific target number.
//	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
//	Please note that your returned answers (both index1 and index2) are not zero-based.
//	You may assume that each input would have exactly one solution.
//	Input: numbers={2, 7, 11, 15}, target=9
//	Output: index1=1, index2=2
	/**
	 * 
	 * Discription:最普通的做法
	 *
	 * @param numbers
	 * @param target
	 * @return
	 * @author zhangjingbo
	 * @update [日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = 0;
        for(int i=0; i<numbers.length; i++){
        	for(int j=i+1;j<numbers.length;j++){
        		if(numbers[i] + numbers[j] == target){
        			index1 = i+1;
        			index2 = j+1;
        			break;
        		}
        	}
        }
		return new int[] {index1, index2};
    }
	
	public static void main(String[] args){
		int[] numbers = {1, 3, 5, 7 ,8 ,11, 20};
		
		int[] index = twoSum(numbers, 13);
		
		for(int i=0; i<index.length; i++){
			System.out.print(index[i] + ",");
		}
	}
}