package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {

	
	/**
	 * [abc] -> ab or c
	 * 
	 * [^abc] -> any character except a,b,c
	 * 
	 * [a-z] -> any character b/w a to z
	 * 
	 * [A-Z] -> any character b/w A to Z
	 * 
	 * [a-z A-Z] -> any character b/w  a to z, A to Z
	 * 
	 * [0-9] -> any number b/w 0 to 9
	 * 

	 * 
	 * below are Quantifiers :
	 * []?  -> Occurs 0 or 1 time
	 * 
	 * []+  -> Occurs 1 or more times
	 * 
	 * []* -> Occurs 0 or more times
	 * 
	 * []{n} -> occurs n times
	 * 
	 * []{n,} -> occurs n or more times
	 * 
	 * []{n,m} -> occurs at least n times but less than m times
	 * 
	 * 
	 * below are meta characters
	 * 
	 * \d  -> [0-9]
	 * 
	 * \D  -> [^0-9]
	 * 
	 * \w  -> [a-z A-Z 0-9]
	 * 
	 * \W  -> [^\w] //note: underscore, dot, hyphen \\-, plus \\+, asterisk \\* are not belong to \W 
	 * 
	 * 
	 */
	
	//Examples:
	
	//1 . mobile number starts with 8 or 9 and total digit should be 10
	
	
	String regex = "[89][0-9]{9}";
	
	//2. First character upper case, contains lower case alphabets, only one digit allowed in between
	
	String regex1 = "[A-Z][a-z]*[0-9][a-z]*";
	
	//3. email Id -> Lingala.SureSh_18-04-93@gmail.com
	
	
	String regx2 = "[A-Ba-b0-9_\'-'\'.']+[@][a-z]+[\'.'][a-z]{2,3}";
	
	
	public static void main(String args[]){
		
		Pattern p = Pattern.compile(".m"); //here '.' means any character
		Matcher m = p.matcher(".am"); 
		Boolean b = m.matches();
		System.out.println(b); //return false
		
		System.out.println(Pattern.matches(".m", "am")); //return true
		
		System.out.println(Pattern.matches("[amd]", "abc")); //return false coz, pattern is either "a" or "m or "c" should
		// match the input string contains 3 characters "abc"
		
		System.out.println(Pattern.matches("[^amd]", "c")); //will return true, coz except a/m/d should match char "c'
		
		System.out.println(Pattern.matches("[a-zA-S]", "T")); //returns false coz i/p char should lie b/w a to z or A to S
		
		System.out.println(Pattern.matches("[a-zA-Z]{6}", "Suresh")); //returns True
		
		System.out.println(Pattern.matches("[a-zA-Z]", "Suresh")); //returns false
		
		System.out.println(Pattern.matches("[xyz]?", "x")); //returns true coz x/y/z should be there 0 or once in the input
		
		System.out.println(Pattern.matches("[xyz]+", "x")); //returns true coz x/y/z should be there 1 or more in the input
		
		System.out.println(Pattern.matches("[xyz]*", "xyyza")); //print false coz x/y/z should be there 0 or mor times
																//but 'a' additional character exists in the input 
		
		System.out.println(Pattern.matches("[xyz]*", "xyyz"));//returns true coz x/y/z should be there 0/more in the input
		
		System.out.println(Pattern.matches("[\\d]", "1"));//returns true coz \d is a meta char for numerics [0-9]
		
		System.out.println(Pattern.matches("[\\D]", "1"));//returns false coz \D is a meta char for non numerics [0-9]
		
		System.out.println(Pattern.matches("[\\D]", "_"));//returns true coz \D is a meta char for non numerics [0-9]
		
		System.out.println(Pattern.matches("[\\D]", "g"));//returns true coz \D is a meta char for non numerics [0-9]
		
		System.out.println(Pattern.matches("[\\D]", "g_H"));//returns false coz \D is comparing with multiple non numerics
		
		System.out.println(Pattern.matches("[\\w]", "gH9"));//returns false coz \w is comparing with multiple chars
		
		System.out.println(Pattern.matches("[\\w]*", "gH9"));//returns true coz \w with * is comparing with multiple chars
		
		System.out.println(Pattern.matches("[\\W]*", "gH9"));//returns false coz \W with * is for non chars and numerics
		
		System.out.println(Pattern.matches("[\\W]*", "%^&$"));//returns true coz \W with * is for non chars and numerics
		
		System.out.println(Pattern.matches("[\\W]", "\\-")); //returns false coz \W doesn't match hyphen 
		
	}
	
	
}
