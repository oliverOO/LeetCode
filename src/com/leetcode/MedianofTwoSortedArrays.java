package com.leetcode;

public class MedianofTwoSortedArrays {
	
	//not done!!!!
	public static double findMedianSortedArrays(int A[], int B[]) {
		int media = 0;
		int media1 = 0;
		int media2 = 0;
		if(A.length%2 == 1){
			media = A[A.length/2];
			
			media1 = B[B.length/2 -1];
			media2 = B[B.length/2];
			
			if(media1 <= media2){
				if(media >= media2){
					return media2;
				}
			}
			
		}else{
			media = B[B.length/2];
		}
		
		
		
		return 0;
	}

	public static void main(String[] args){
		int[] array1 = {1, 3, 6, 9, 10, 13, 18, 20};
		int[] array2 = {2, 7, 8, 9, 11, 14, 17, 19, 21};
		int[] array3 = {1,2, 3, 6, 7, 8, 9, 9, 10, 11, 13, 14, 17, 18, 19, 20, 21};
		
		System.out.println(array2.length/2);
		System.out.println(findMedianSortedArrays(array1, array2));
	}
}