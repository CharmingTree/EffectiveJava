package Generic.Vararg;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// 배열대신 List를 이용해 안전하게 바뀐 PickTwo
public class SafePickTwo {
	static <T> List<T> pickTwo(T a, T b, T c) {
		switch (ThreadLocalRandom.current().nextInt(3)) {
			case 0 : return Arrays.asList(a, b);
			case 1 : return Arrays.asList(a, c);
			case 2 : return Arrays.asList(b, c);
		}
		throw new AssertionError();
	}
	
	public static void main(String[] args) {
		List<String> attributes = pickTwo("좋은", "빠른", "저렴한");
		System.out.println(attributes);
	}
}
