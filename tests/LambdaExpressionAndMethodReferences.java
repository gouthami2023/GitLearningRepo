package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExpressionAndMethodReferences {

	public static void main(String[] args){
		List<String> L1=new ArrayList<String>(Arrays.asList("Java", "C#", "Python","Ruby"));
		//with annoymous class
		L1.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				
				System.out.println(t);
			}
			
		});
		//with Lambda 
		L1.forEach(str->System.out.println(str));
		
		//with method reference, here "::" is called method reference
		L1.forEach(System.out::println);
		
	}
	
}
