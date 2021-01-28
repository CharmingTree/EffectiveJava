package Stream;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Adapters {
	/* Stream<E>를 Iterable<E>로 중개해주는 어댑터 */
	public static <E> Iterable<E> iterableOf(Stream<E> stream) {
		return stream::iterator;
	}
	
	/* Iterable<E>를 Stream<E>로 중개해주는 어댑터 */
	public static <E> Stream<E> streamOf(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false);
	}
}
