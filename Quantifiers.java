package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quantifiers {

	public static void main(String[] args) {


		/**
		 * Quantifiers in Java allow users to specify the number of occurrences to match against. Below are some commonly
		 * used quantifiers in Java.
		 * 
		 * 
		 * X*        Zero or more occurrences of X
		 * X?        Zero or One occurrences of X
		 * 
		 * Ex: A[a-z]? 
		 * below are allowed for the above pattern
		 * A, Aa, Ab, AbFG, m3jhA, XYkAmF  becoz as per pattern after A there should be small letter or there shouldn't be)
		 * AF is not allowed becoz F is captial 
		 *
		 * 
		 * X+        One or More occurrences of X
		 * X{n}      Exactly n occurrences of X
		 * X{n, }    At-least n occurrences of X
		 * X{n, m}   Count of occurrences of X is from n to m
		 * 
		 * 
		 */


		/**
		 * Greedy Quantifiers:
		 * 
		 * By default, quantifiers are Greedy. Greedy quantifiers try to match the longest text that matches a given 
		 * pattern. Greedy quantifiers work by first reading the entire string before trying any match. 
		 * If the whole text doesn’t match, remove the last character and try again, repeating the process until a match 
		 * is found.  
		 * 
		 *  
		 */

		// Making an instance of Pattern class By default quantifier "+" is Greedy
		Pattern p = Pattern.compile("g+");

		// Making an instance of Matcher class
		Matcher m = p.matcher("ggg");

		while (m.find())
			System.out.println("Pattern found from " + m.start() + " to " + (m.end()-1));


		/**
		 * Explanation: The pattern g+ means one or more occurrences of g. Text is ggg. The greedy matcher would match
		 * the longest text even if parts of the matching text also match. In this example, g and gg also match, 
		 * but the greedy matcher produces ggg and compare with input string "ggg".
		 */


		/***
		 * Reluctant Quantifier (Appending a ? after quantifier)
		 * 
		 * This quantifier uses the approach that is the opposite of greedy quantifiers. It starts with the first character 
		 * and processes one character at a time.
		 *
		 *  
		 * 
		 */

		//      Making an instance of Pattern class
		//      Here "+" is a Reluctant quantifier because a "?' is appended after it.
		p = Pattern.compile("g+?");

		// Making an instance of Matcher class
		m = p.matcher("ggg");

		while (m.find())
			System.out.println("Pattern found from " + m.start() + " to " + (m.end()-1));

		/**
		 * Explanation: Since the quantifier is reluctant, it matches the shortest part of the test with the pattern. 
		 *  It processes one character at a time.
		 *  
		 *  "g+?" pattern i.e "g" compares the string "ggg". 
		 *  since it found in 3 places, 3 times it will loop and print the indexes 
		 *  
		 */


		
		/**
		 * Possessive Quantifier (Appending a + after quantifier) 
		 * 
		 * This quantifier matches as many characters as possible, like a greedy quantifier. But if the entire string 
		 * doesn’t match, then it doesn’t try removing characters from the end.
		 *
		 */

		//      Making an instance of Pattern class\
		//      Here "+" is a Possessive quantifier because a "+' is appended after it.

		p = Pattern.compile("g++");

		// Making an instance of Matcher class
		m = p.matcher("ggg");

		while (m.find())
			System.out.println("Pattern found from " + m.start() + " to " + (m.end()-1));

		/**
		 *  Explanation: We get the same output as Greedy because the whole text matches the pattern.
		 */
		
		
		/**
		 * 
		 * Difference Between Greedy and Possessive Quantifiers
		 * 
		 */
		

		
		// Create a pattern with Greedy quantifier
		Pattern pg = Pattern.compile("g+g");
		 
        // Create same pattern with possessive quantifier
        Pattern pp = Pattern.compile("g++g");        
 
        System.out.println("Using Greedy Quantifier");
        
        Matcher mg = pg.matcher("ggg");
        
        while (mg.find()){
        	System.out.println(mg);
            System.out.println("Pattern found from " + mg.start() + " to " + (mg.end()-1));
        }
        
        System.out.println("\nUsing Possessive Quantifier");
        
        Matcher mp = pp.matcher("ggg");
        System.out.println(mp);
        while (mp.find()){
        	System.out.println("Pattern found from " + mp.start() + " to " + (mp.end()-1));
        }

	}

}
