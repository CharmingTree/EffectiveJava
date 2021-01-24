package Generic.Vararg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 제네릭 varargs 매개변수를 List로 대체한 예 - 타입이 안전함.
public class FlattenWithList {
	static <T> List<T> flatten(List<List<? extends T>> lists) {
		List<T> result = new ArrayList<>();
		for (List<? extends T> list : lists)
			result.addAll(list);
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> flatList = flatten(Arrays.asList(Arrays.asList(1,2), Arrays.asList(3, 4, 5), Arrays.asList(6, 8)));
		
		System.out.println(flatList);
	}
}
