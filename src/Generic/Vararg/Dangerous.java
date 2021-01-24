package Generic.Vararg;

import java.util.Arrays;
import java.util.List;

// Generic varargs 배열 매개 변수에 값을 저장하는 것은 안전하지 않다. 
public class Dangerous {
	// 제네릭과 가변 인자를 혼용하면 타입 안전성이 깨진다. 
	
	static void dangerous(List<String>... stringLists) {
		List<Integer> intList = Arrays.asList(42);
		Object[] objects = stringLists;
		objects[0] = intList; // Heap Pollution 발생
		String s = stringLists[0].get(0); // ClassCastException
	}
	
	public static void main(String[] args) {
		dangerous(Arrays.asList("There be dragons"));
	}
}
