package Generic.technqiue1;

import java.util.Arrays;
import java.util.EmptyStackException;

// E[]를 이용한 제네릭 스택
public class Stack<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITAIL_CAPACITY = 16;
	
	// 배열 element는  push(E)로 넘어온 E 인스턴스만 담는다.
	// 따라서 타입 안전성을 보장하지만,
	// 이 배열의 런타임 타입은 E[]가 아닌 Object[]다.
	
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) new Object[DEFAULT_INITAIL_CAPACITY];
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
	
	private void ensureCapacity()
	{
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	
	public static void main(String[] args){
		String[] tmp = {"aaa", "bbb", "ccc"};
		Stack<String> stack = new Stack<>();
		for (String arg : tmp)
			stack.push(arg);
		while (!stack.isEmpty())
			System.out.println(stack.pop().toUpperCase());
	}
}
