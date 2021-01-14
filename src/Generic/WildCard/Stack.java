package Generic.WildCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

// 와일드 카드 타입을 이용해 대량 작업을 수행하는 메서드를 포함한 제네릭 스택
public class Stack<E> {

	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 15;
	
	// 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
	// 따라서 타입 안정성을 보장하지만
	// 이 배열의 런타임 타입은 E[]가 아닌 Object[] 이다.
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	// E 생산자(producer) 매개변수에 와일드 카드 타입 적용
	public void pushAll(Iterable<? extends E> src) {
		for (E e : src)
			push(e);
	}
	
	// E 소비자(consumer) 매개변수에 와일드 카드 타입 적용
	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}
	
	public static void main(String[] args)
	{
		Stack<Number> numberStack = new Stack<>();
		Iterable<Integer> integers = Arrays.asList(3, 1, 2, 5, 6, 4, 7);
		numberStack.pushAll(integers);
		
		Collection<Object> objects = new ArrayList<>();
		numberStack.popAll(objects);
		
		System.out.println(objects);
	}
	
}
