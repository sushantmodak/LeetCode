package com.practice;

public class Sol {
	
	public boolean isMatch(String s,String p){
		if(p.isEmpty() && s.isEmpty()) return true;
		if(!p.isEmpty() && !s.isEmpty() && (p.charAt(0)=='.' || s.charAt(0)==p.charAt(0))){
			if(p.length()>1 && p.charAt(0)=='.' && p.charAt(1)!='*') 
				return isMatch(s.substring(1), p.substring(1));
			if(p.length()>=2 && p.charAt(1)=='*'){
				if(p.charAt(0)=='.') {
					boolean first_match = s.endsWith(p.substring(2)) 
							|| isMatch(s.length()<=p.length()?s:
									s.substring(s.length()-p.length()), p.substring(2));
					return isMatch(s, p.substring(2)) || first_match;
				}
				return isMatch(removeSame(s,p.charAt(0)), p.substring(2));
			} else return isMatch(s.substring(1), p.substring(1));
			
		} else return false;
	}
	public String removeSame(String str,char c){
		String retval = null;
		if(c=='.') c=str.charAt(0);
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==c){
				retval = str.substring(i+1);
			} else break;
		}
		return retval;
	}
	public String removeDotStar(String str){
		String retval = null;
		return retval;
	}
	public static void main(String[] args) {
		Sol sol = new Sol();
		System.out.println(sol.isMatch("abbbcd", "ab.*.d"));
		/*System.out.println(sol.isMatch("abbbcd", "ab.*.*.*.*.*.*d"));*/
	}
}
