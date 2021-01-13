package Generic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Union {
	
	// 제네릭 메소드 
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}

	public static void main(String[] args) {
		Set<String> guys = new TreeSet<>(Arrays.asList("tom","dic","hyeri"));
		Set<String> stooges = new HashSet<>(Arrays.asList("rr", "ma", "kl"));
		Set<String> aflcio = union(guys, stooges);
		
		System.out.println(aflcio);
	}
}
