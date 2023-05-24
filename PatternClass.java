package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import collections.Streams;

/**
 * java.util.regex package consists of 3 classes and 1 interface. 
 * 
 * The java.util.regex package primarily consists
 * 
 * a. Pattern Class - Pattern Class used for defining patterns
 * b. Matcher class - Used for performing match operations on text using patterns
 * c. PatternSyntaxException Class - Used for indicating syntax error in a regular expression pattern
 * d. MatchResult Interface - Used for representing the result of a match operation

 */

public class PatternClass {

	public static void main(String[] args) {

		/** 
		Different methods available in the class

		1. compile(String regex) - It is used to compile the given regular expression into a pattern 

		The compile(String) method of the Pattern class in Java is used to create a pattern from the regular expression
		passed as parameter to method. Whenever you need to match a text against a regular expression pattern more than
		one time, create a Pattern instance using the Pattern.compile() method.

		Syntax: public static Pattern compile(String regex) 

		Return Value: This method returns the pattern compiled from the regex passed to the method as a parameter.

		PatternSyntaxException: This exception is thrown if the expression’s syntax is invalid.

		 */

		//Example 1
		String regex = ".*www.*";
		String actualString = "www.geeksforgeeks.org";

		Pattern pattern = Pattern.compile(regex); // compile the regex to create pattern using compile() method

		Matcher matcher = pattern.matcher(actualString); // get a matcher object from pattern

		boolean matches = matcher.matches(); //check whether Regex string is found in actual String or not
		
		//Note: The matches() method returns true If the regular expression matches the whole text. If not, the matches()
		// method returns false. Whereas find() search for the occurrence of the regular expression passes to Pattern.

		System.out.println(matches); //returns true in this scenario

		// Example 2 
		String regex1 = "brave";
		String actualString1 = "cat is cute";

		Pattern pattern1 = Pattern.compile(regex1);

		Boolean flag =  pattern1.matcher(actualString1).matches();

		System.out.println(flag);


		/**
		 * Method 2: compile(String regex, int flags)
		 * used to compile the given regular expression into a pattern with the given flags.
		 * 
		 * 
		 * The compile(String, int) method of the "Pattern" class used to create a pattern from the regular expression 
		 * with the help of flags where both expression and flags are passed as parameters to the method. 
		 * The Pattern class contains a list of flags (int constants) that can be helpful to make the Pattern matching 
		 * behave in certain ways. For example, The flag name CASE_INSENSITIVE is used to ignore the case of the text 
		 * at the time of matching.
		 * 
		 * Syntax: 
		 * public static Pattern compile(String regex, int flags)
		 * 
		 * flag: This parameter is an integer representing Match flags, a bit mask that may include CASE_INSENSITIVE, 
		 * MULTILINE, DOTALL, UNICODE_CASE, CANON_EQ, UNIX_LINES, LITERAL, UNICODE_CHARACTER_CLASS and COMMENTS.
		 * 
		 * Return Value: This method returns the pattern compiled from passed regex and flags.
		 * 
		 * PatternSyntaxException: This exception is raised if the expression’s syntax is invalid.
		 * IllegalArgumentException: This exception is raised if bit values other than those corresponding
		 *  to the defined match flags are set in flags.
		 */

		String regex2 = "(.*)(For)(.*)";
		String actualString2 = "geeks for geeks";
		Pattern pattern2 = Pattern.compile(regex2, Pattern.CASE_INSENSITIVE); 
		// case-insensitive matching assumes that only characters in the US-ASCII charset are being matched. 
		Boolean result = pattern2.matcher(actualString2).matches();
		System.out.println(result); //returns true

		/**
		 * Method 3: 
		 * flags() - It is used to return this pattern’s match flags. 
		 * 
		 * 
		 * The flags() method of the Pattern class in Java is used to return the pattern’s match flags. 
		 * The Match flags are a bit mask that may include CASE_INSENSITIVE, MULTILINE, DOTALL, UNICODE_CASE, 
		 * CANON_EQ, UNIX_LINES, LITERAL, UNICODE_CHARACTER_CLASS and COMMENTS Flags. 
		 * 
		 * Syntax: public int flags()
		 * 
		 * Return Value: This method returns the pattern’s match flag. 
		 * 
		 */

		String regex3 = "(.*)(For)(.*)";
		Pattern pattern3 = Pattern.compile(regex3, Pattern.CASE_INSENSITIVE);
		int  flag1= pattern3.flags();
		System.out.println(flag1); //prints 2, click case_insensitive to fing the flag value
		pattern3 = Pattern.compile(regex3, Pattern.CANON_EQ);
		System.out.println(pattern3.flags()); //prints 128
		
		/**
		 * Method 4:
		 * matcher(CharSequence input) - used to create a matcher that will match the given input against this pattern.
		 * 
		 * The matcher(CharSequence) method of the Pattern class used to generate a matcher that will helpful to match
		 * the given input as parameter to method against this pattern. The Pattern.matcher() method is very helpful
		 * when we need to check a pattern against a text a single time, and the default settings of the Pattern class 
		 * are appropriate. 
		 * 
		 * Syntax: public Matcher matcher(CharSequence input)
		 * 
		 * Return Value: This method returns a new matcher for this pattern. 
		 */
		
		String regex4 = "(.*)(ee)(.*)?";
		String actualString4 = "geeksforgeeks";
		Pattern pattern4 = Pattern.compile(regex4);
		Matcher matcher4 = pattern4.matcher(actualString4);
		
		boolean matchFound = false;
		
		while(matcher4.find()){
			
			String inputSubSeq = matcher.group();
			int startingIndex = matcher.start();
			int endingIndex = matcher.end();
			
			System.out.println("Found the regex in input text - " + inputSubSeq + " - at starting Index " + startingIndex
					+ " also at ending index " + endingIndex);
			
			matchFound = true;
			
		}
				
		
		/**
		 * Method 5: matches(String regex, CharSequence input) - 
		 * It is used to compile the given regular expression and attempts to match the given input against it.
		 * 
		 * The matches(String, CharSequence) method of the Pattern class in Java is used to answer whether or not 
		 * the regular expression matches on the input. To do so we compile the given regular expression and
		 * attempts to match the given input against it where both regular expression and input passed as a parameter to
		 * the method. If a pattern is to be used multiple times, compiling it once and reusing it will be more efficient
		 * than invoking this method each time.
		 * 
		 * 
		 * Syntax: public static boolean matches(String regex, CharSequence input)
		 * 
		 * Return Value: This method returns a boolean value, answering whether or not the regular expression matches 
		 * on the input.
		 * 
		 */
		
		String regex5 = "(.*)(ee)(.*)?";
		String actualString5 = "geeksforgeeks";
		
		boolean matcherResult5 = Pattern.matches(regex5, actualString5);
		System.out.println(matcherResult5);
		
		
		/**
		 * Method 6: pattern() - It is used to return the regular expression from which this pattern was compiled.
		 * 
		 * The pattern() method of the Pattern class in Java is used to get the regular expression which is compiled to 
		 * create this pattern. We use a regular expression to create the pattern and this method used to get the 
		 * same source expression. 
		 * 
		 * Syntax: public String pattern()
		 * 
		 * Return Value: This method returns the pattern’s source regular expression. 
		 * 
		 */
		
		String regex6 = "(.*)(for)(.*)";
		Pattern pattern6 = Pattern.compile(regex6);
		String compiledRegex = pattern6.pattern();
		System.out.println(compiledRegex);
		
		/**
		 * Method 7: quote(String s)
		 * 	It is used to return a literal pattern String for the specified String. This method produces a String
		 *  equivalent to s that can be used to create a Pattern.
		 * 
		 * 
		 * Method 8: Split(CharSequence input)
		 * 
		 * split(CharSequence) method of a Pattern class used to splits the given char sequence passed as parameter
		 * to method around matches of this pattern. This method can split charSequence into an array of String’s, 
		 * using the regular expression used to compile the pattern as a delimiter.so we can say that the method returns 
		 * the array of strings computed by splitting the input around matches of this pattern.
		 * 
		 * Syntax: public String[] split(CharSequence input)
		 * 
		 * Return value: This method returns the array of strings computed by splitting the input around matches
		 * of this pattern.
		 */
		
		String regex8 = "ee";
		String actualString8 = "geeksforgeeks";
		Pattern pattern8 = Pattern.compile(regex8);
		String[] patternArr = pattern8.split(actualString8);
		
		for(int i=0;i<patternArr.length;i++){
			System.out.println(patternArr[i]);
		}
		
		
		/**** ------------------ */
		
		String text = "geeks1for2geeks3";
		 
        // Specifies the string pattern which is to be searched
        String delimiter = "\\d";
        Pattern patternEx = Pattern.compile(delimiter, Pattern.CASE_INSENSITIVE);
 
        // Used to perform case insensitive search of the
        // string
        String[] resultEx = patternEx.split(text);
 
        // Iterating using for each loop
        for (String temp : resultEx)
            System.out.println(temp);
    
		
		
		/**
		 * Method 9: split(CharSequence input, int limit)
		 * 
		 * It is used to split the given input sequence around matches of this pattern. The limit parameter controls 
		 * the number of times the pattern is applied.
		 * 
		 * 
		 * Syntax: public String[] split?(CharSequence input, int limit)
		 * 
		 * Return value: This method returns the array of strings computed by splitting the input around matches
		 * of this pattern.
		 * 
		 * The limit parameter passed as int help to calculate the number of times the pattern is applied and affects
		 * the length of the resulting array. If the limit n is greater than zero then the pattern will be applied at
		 * most n – 1 time. If n is non-positive or Zero then the pattern will be applied as many times as possible. 
		 *
		 */
		
		String regex9 = "geeks";
		String actualString9 = "Welcome to geeks for geeks";
		
		Pattern pattern9 = Pattern.compile(regex9);
		String[] patternarr =pattern9.split(actualString9, 2); // so pattern can be applied at most limit - 1 time i.e 1
		
		for(String eachString : patternarr){
			System.out.println(eachString); //since pattern applies only once, 2nd word geeks is not filtered in the output
		}
		
		patternarr =pattern9.split(actualString9, 0); //pattern will apply n number of times
		
		for(String eachString : patternarr){
			System.out.println(eachString);//since pattern applies n times, 2nd word geeks will also be filtered in the o/p
		}
		
		/**
		 * Method 10: toString()
		 * It is used to return the string representation of this pattern.
		 * 
		 */
	}

}
