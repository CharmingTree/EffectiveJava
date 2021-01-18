package Generic.Vararg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 제네릭 varargs 매개변수를 안전하게 사용하는 메서드 
public class FlattenWithVarargs {
	static <T> List<T> flatten(List<? extends T>... lists) {
		List<T> result = new ArrayList<>();
		for (List<? extends T> list : lists) 
			result.addAll(list);
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> flatList = flatten(Arrays.asList(1,2), Arrays.asList(3,4,5), Arrays.asList(6,7));
		System.out.println(flatList);
	}
}
