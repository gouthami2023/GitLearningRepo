package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {

	public static void main(String[] args) {
		
		String regex = "\\b(\\d{3})(\\d{3})(\\d{4})\\b";

	    Pattern p = Pattern.compile(regex);
	    String source = "1234567890, 12345,  and  9876543210";

	    Matcher m = p.matcher(source);

	    while (m.find()) {
	      System.out.println("Phone: " + m.group() + ", Formatted Phone:  ("
	          + m.group(1) + ") " + m.group(2) + "-" + m.group(3));
	    }
	    
	    
	    
	    
	    /**
	     * 
	     * $n, where n is a group number, inside a replacement text refers to the matched text for group n.
		 *	
		 *For example, $1 refers to the first matched group. To reformat phone numbers, we would use ($1) $2-$3.
	     * 
	     */
	    
	    
	    regex = "\\b(\\d{3})(\\d{3})(\\d{4})\\b";
	    String replacementText = "($1) $2-$3";
	    source = "1234567890, 12345, and 9876543210";

	    p = Pattern.compile(regex);
	    m = p.matcher(source);

	    String formattedSource = m.replaceAll(replacementText);

	    System.out.println("Text: " + source);
	    System.out.println("Formatted Text: " + formattedSource);

	}

}
