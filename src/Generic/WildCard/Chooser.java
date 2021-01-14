package Generic.WildCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Chooser<T> {
	private final List<T> choiceList;
	private final Random rnd = new Random();
	
	// 생산자 매개변수에 와일드 카드 타입 적용
	public Chooser(Collection<? extends T> choices) {
		choiceList = new ArrayList<>(choices);
	}
	
	public T choose() {
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}
	
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList(Arrays.asList(1,2,3,4,5,6));
		
		Chooser<Number> chooser = new Chooser<>(intList);
		
		for (int i = 0; i  < 10; i++) {
			Number choice = chooser.choose();
			System.out.println(choice);
		}
	}

}
