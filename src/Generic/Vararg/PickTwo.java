package Generic.Vararg;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// 미묘한 힙 오염 발생 
public class PickTwo {
	static <T> T[] toArray(T... args) {
		return args;
	}
	
	static <T> T[] pickTwo(T a, T b, T c) {
		switch (ThreadLocalRandom.current().nextInt(3)) {
			case 0 : return toArray(a, b);
			case 1 : return toArray(a, c);	
			case 2 : return toArray(b, c);
		}
		throw new AssertionError();
	}
	
	public static void main(String[] args) {
		String[] attributes = pickTwo("좋은", "빠른", "저렴한"); // ClassCastException :: pickTwo의 반환은 object[]인데 Object[]는 String[]의 하위 타입이 아님으로 에러
		System.out.println(Arrays.toString(attributes));
	}
}
