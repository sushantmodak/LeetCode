package com.reverse;

public class ReverseNumber {
	public boolean isPalindrome(int x) {
		if(x<0) return false;
		int tx = x;
		int length = 0;
		int revInt = 0;
		int i = 0;
        while(tx!=0){
        	tx=tx/10;
        	length++;
        } i = length;
        
        tx = x;
        while(tx!=0){
        	i--;
        	revInt = revInt+(tx%10) * (int)Math.pow(10, i);
        	tx=tx/10;
        }
		return revInt==x;
    }
	public static void main(String[] args) {
		System.out.println(new ReverseNumber().isPalindrome(12321));
	}
}
