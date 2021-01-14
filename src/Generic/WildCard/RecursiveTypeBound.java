package Generic.WildCard;

import java.util.Arrays;
import java.util.List;

// 재귀적 타입 한정
public class RecursiveTypeBound {
	public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
		if (list.isEmpty())
			throw new IllegalArgumentException("empty List");
		
		E result = null;
		for (E e : list)
			if (result == null || e.compareTo(result) > 0)
				result = e;
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> argList = Arrays.asList("ccc", "bbb", "fff", "aaa");
		System.out.println(max(argList));
	}

}
