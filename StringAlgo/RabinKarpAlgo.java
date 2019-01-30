package com.tree.random;
import java.util.*;

public class RabinKarpAlgo {
	// Rabin-karp Algorithm
	public static void main(String[] args) {
		String inputString = "abcaabb";
		String pattern = "abb";
		System.out.println(getHashValue("abb"));
		System.out.println(isPatternPresent(inputString,pattern));
	}
	
	
	private static boolean isPatternPresent(String master,String slave) {
		boolean flag = false;;
		Map<Integer,List<String>> patternMatch = new HashMap<Integer,List<String>>();
		if(master.length() < slave.length()) {
			return false;
		}
		int getFirstHash = getHashValue(master.substring(0, slave.length()-1));
		int getSlaveHash = getHashValue(slave);
		List<String> list = new ArrayList<>();
		list.add(master.substring(0, slave.length()-1));
		patternMatch.put(getFirstHash, list);
		for(int i =slave.length();i<master.length();i++) {
			System.out.println(getFirstHash + " " + getSlaveHash);
			if(getFirstHash == getSlaveHash) {
				flag = searchInList(patternMatch.get(getFirstHash),slave);
				if(flag) {
					return true;
				}
			}
			System.out.println(master.charAt(i-slave.length()+1));
			getFirstHash = getFirstHash - getHashValue(master.charAt(i-slave.length()+1)+"") + getHashValue(master.charAt(i-slave.length()+1)+"");
		}
		
		
		return flag;
	}
	
	private static boolean searchInList(List<String> resultList,String pattern) {
		if(resultList.contains(pattern)) {
			return true;
		}return false;
	}
	
	private static int getHashValue(String str) {
		int sum = 0;
		for(int i=0;i<str.length();i++) {
			sum += str.charAt(i)-'a'+1;
		}
		return sum;
		
	}
}
