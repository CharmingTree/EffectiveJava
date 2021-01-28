package Stream;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
	public static final <E> Collection<Set<E>> of(Set<E> s) {
		List<E> src = new ArrayList<>(s);
		if (src.size() > 30)
			throw new IllegalArgumentException("집합에 원소가 너무 많습니다(최대 30). : " + s);
		return new AbstractList<Set<E>>() {
			@Override
			public int size() {
				return 1 << src.size();
			}
			
			@Override
			public boolean contains(Object o) {
				return o instanceof Set && src.containsAll((Set)o);
			}
			
			@Override
			public Set<E> get(int index) {
				Set<E> result = new HashSet<>();
				for (int i = 0; index != 0; i++, index >>= 1)
					if ((index & 1) == 1)
						result.add(src.get(i));
				return result;
			}
		};
	}
	
	public static void main(String[] args) {
		Set s = new HashSet(Arrays.asList("a","b","c"));
		System.out.println(PowerSet.of(s));
	}
}
