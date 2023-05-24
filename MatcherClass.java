package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherClass {

	public static void main(String[] args) {
		
		/**
		 * Method 1 : find() - It is mainly used for searching multiple occurrences of the regular expressions in the text.
		 * 
		 * The find() method of Matcher Class attempts to find the next subsequence of the input sequence that find the
		 * pattern. It returns a boolean value showing the same.
		 *
		 * Syntax: public boolean find()
		 * 
		 * Return value: Return Value: This method returns a boolean value showing whether a subsequence of the input
		 * sequence find this matcher’s pattern
		 * 
		 */
		
		String regex = "geeks";
		String inputString = "geeks for geeks";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputString);

		System.out.println("find method result - "+ matcher.find()); //get the subseq using find() method
		System.out.println("matches method result - "+ matcher.matches()); //returns false
		
		/* Note: The matches() method returns true If the regular expression matches the whole text. If not, the matches()
		method returns false. Whereas find() search for the occurrence of the regular expression passes to Pattern. */
		
		
		/**
		 * Method 2: find(int start) - It is used for searching occurrences of the regular expressions in the text
		 * starting from the given index. 
		 * 
		 * Syntax: public boolean find(int start)
		 * 
		 * Return Value: This method returns a boolean value showing whether a subsequence of the input sequence find
		 * this matcher’s pattern
		 * 
		 * Exception: This method throws IndexOutOfBoundsException if start is less than zero or greater than the length
		 * of the input sequence.
		 */
		
		String regex1 = "geeks";
		Pattern pattern1 = Pattern.compile(regex1);
		String inputString1 = "geeks for geeeeeeks";
		Matcher matcher1 = pattern1.matcher(inputString1);
		System.out.println(matcher1.find(1)); //returns false
		System.out.println(matcher.find(1)); //returns true since matcher reference is used
		
		
		/**
		 * Method 3: The start() method of Matcher Class is used to get the start index of the match result already done.
		 *
		 * Syntax: public int start()
		 * 
		 * Return Value: This method returns the index of the first character matched.0
		 *
		 * Exception: This method throws IllegalStateException if no match has yet been attempted, 
		 * or if the previous match operation failed.
		 */
		
		Pattern patternEx = Pattern.compile("geeks");
		 
        // Search above pattern in "geeksforgeeks.org"
        Matcher m = patternEx.matcher("geeksforgeeks.org");
 
        // Finding string using find() method
        while (m.find())
 
            // Print starting and ending indexes of the pattern in the text
            // using this functionality of this class
            System.out.println("Pattern found from "+ m.start() + " to " + (m.end() - 1));
		
		
        /**** ------------------ */
        
        
        Pattern patternEx1 = Pattern.compile("ge*");
        
        // Searching for the above pattern in "geeksforgeeks.org"
        Matcher m1 = patternEx1.matcher("geeksforgeeks.org");
 
        // Checking whether the pattern is there or not using find() method
        while (m1.find())
 
            // Print starting and ending indexes of the pattern in text using method functionality of this class
            System.out.println("Pattern found from " + m1.start() + " to "
                               + (m1.end() - 1));
        
        
        /**** ------------------ */
        
        
		String regex3 = "(G*k)";
		Pattern pattern3 = Pattern.compile(regex3);
		String inputString3 = "Geeks";
		Matcher matcher3 = pattern3.matcher(inputString3);
		while(matcher3.find()){
			System.out.println(matcher3.start());
		}
		
		
		/**** ------------------ */
		
		
		regex3 = "G*G"; //check replacing * with F
		inputString3 = "GFG";
		pattern3 = Pattern.compile(regex3);
		matcher3 = pattern3.matcher(inputString3);
		
		while(matcher3.find()){
			System.out.println(matcher3.start()); //prints 0,2 since G char is avaialble in those indexes
		}
		
		/**
		 * Method 4: end() - The end() method of Matcher Class is used to get the offset after the last character matched 
		 * of the match result already done.
		 * 
		 * Syntax: public int end()
		 * 
		 * Return Value: This method returns the offset after the last character matched
		 * 
		 * Exception: This method throws IllegalStateException if no match has yet been attempted, or if the previous match
		 * operation failed.
		 *  
		 */
		
		String regex4 = "(G*S)";
		String inputString4 = "GeeksForGeeks";
		Pattern pattern4 = Pattern.compile(regex4);
		Matcher matcher4 = pattern4.matcher(inputString4);
		while(matcher4.find()){
			System.out.println(matcher4.end());//considers n+1 as end index, Geeks end index is 4,12 so result will be 5,13
		}
		
		regex4 = "(G*G)";
		inputString4 = "GFG FGF GFG";
		pattern4 = Pattern.compile(regex4);
		matcher4 = pattern4.matcher(inputString4);
		while(matcher4.find()){
			System.out.println(matcher4.end());/*considers n+1 as end index, G char available in 0,2,5,8,10. result would
			be 1,2,6,9,11*/ 
		}
		
		/**
		 * Method 5: groupCount() - It is used to find the total number of the matched subsequence.
		 * 
		 * This method of Matcher Class is used to get the number of capturing groups in this matcher’s pattern.
		 * 
		 * Syntax: public int groupCount()
		 * 
		 * Return Value: This method returns the number of capturing groups in this matcher’s pattern.
		 * 
		 */
		
		String regex5 = "Geeks";
		String inputString5 = "GeeksForGeeks";
		Pattern pattern5 = Pattern.compile(regex5);
		Matcher matcher5 = pattern.matcher(inputString5);
		System.out.println(matcher5.groupCount());
		
		regex5 = "(GFG)";
		inputString5 = "GFG GFG";
		pattern5 = Pattern.compile(regex5);
		matcher5 = pattern5.matcher(inputString5);
		System.out.println(matcher5.groupCount());
		
		/**
		 * Method 6: group() - The group() method of Matcher Class is used to get the input subsequence matched
		 * by the previous match result.
		 * 
		 * Syntax: public String group()
		 * 
		 * Return Value: This method returns the String which is the input subsequence matched by the previous match.
		 * 
		 * Exception: This method throws IllegalStateException if no match has yet been attempted, or 
		 * if the previous match operation failed.
		 * 
		 */
		
		String regex6 = "(G*s)";
		String inputString6 = "GeeksForGeeks";
		Pattern pattern6 = Pattern.compile(regex6);
		Matcher matcher6 = pattern6.matcher(inputString6);
		while(matcher6.find()){
			System.out.println(matcher6.group());
		}
		
		
		regex6 = "(GFG)";
		inputString6 = "GFG FGF GFG";
		pattern6 = Pattern.compile(regex6);
		matcher6 = pattern5.matcher(inputString6);
		while(matcher6.find()){
			System.out.println(matcher6.group());
		}
		
		regex6 = "(G*G)";
		inputString6 = "GFG FGF GFG";
		pattern6 = Pattern.compile(regex6);
		matcher6 = pattern5.matcher(inputString6);
		while(matcher6.find()){
			System.out.println(matcher6.group());
		}
		
		/**
		 * method 7: matches() - is used to get the result whether this pattern matches with this matcher or not. 
		 * It returns a boolean value showing the same. 
		 * 
		 * Return Value: This method returns a boolean value showing whether this pattern matches with this matcher or not.
		 *  
		 */
		
		String regex7 = "geeks";
		String inputString7 = "geeks for geeks";
		Pattern pattern7 = Pattern.compile(regex7);
		Matcher matcher7 = pattern7.matcher(inputString7);
		System.out.println("matches method result - "+ matcher7.matches()); //returns false

	}
	
	
	

}
