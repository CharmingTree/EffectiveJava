package Generic;

import java.util.function.UnaryOperator;

// 제네릭 싱글턴 패턴 
public class GenericSingletonFactory {
	
	private static UnaryOperator<Object> IDENTITY_FN = (t) ->t;
	
	@SuppressWarnings("unchecked")
	public static <T> UnaryOperator<T> identifyFunction() {
		return (UnaryOperator<T>) IDENTITY_FN;
	}
	
	public static void main(String[] args) {
		String[] strings = {"aaa", "bbb", "ccc"};
		UnaryOperator<String> sameString = identifyFunction();
		for (String s : strings) {
			System.out.println(sameString.apply(s));
		}
		
		Number[] numbers = {1, 2.0, 3L};
		UnaryOperator<Number> sameNumber = identifyFunction();
		for (Number n : numbers) {
			System.out.println(sameNumber.apply(n));
		}
	}

}
