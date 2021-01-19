package EnumType.item37;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;


class Plant {
	enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }
	
	final String name;
	public final LifeCycle lifeCycle;
	
	Plant(String name, LifeCycle lifeCycle) {
		this.name = name;
		this.lifeCycle = lifeCycle;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		Plant[] garden = {
			new Plant("바질", LifeCycle.ANNUAL),
			new Plant("캐러웨이", LifeCycle.BIENNIAL),
			new Plant("딜", LifeCycle.ANNUAL),
			new Plant("라벤더", LifeCycle.PERENNIAL),
			new Plant("파슬리", LifeCycle.BIENNIAL),
			new Plant("로즈마리", LifeCycle.PERENNIAL),
		};
		
		// ordinal()을 배열 인덱스로 사용 - 지양해야함
		Set<Plant>[] plantByLifeCycleArr = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
		
		for (int i = 0; i < plantByLifeCycleArr.length; i++)
			plantByLifeCycleArr[i] = new HashSet<>();
		
		for (Plant p : garden)
			plantByLifeCycleArr[p.lifeCycle.ordinal()].add(p);
		
		for (int i = 0; i < plantByLifeCycleArr.length; i++) {
			System.out.printf("%s : %s%n", Plant.LifeCycle.values()[i], plantByLifeCycleArr[i]);
		}
		
		/* EnumMap을 사용해 데이터와 열거 타입을 매핑한다. */
		Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
		
		for (Plant.LifeCycle lc : Plant.LifeCycle.values())
			plantsByLifeCycle.put(lc, new HashSet<>());
		
		for (Plant p : garden)
			plantsByLifeCycle.get(p.lifeCycle).add(p);
		
		System.out.println(plantsByLifeCycle);
		
		/* 스트림을 사용한 코드 EnumMap을 사용하지 않고  */
		//System.out.println(Arrays.stream(garden).collect(groupingBy(p->p.lifeCycle)));
		
		/* EnumMap을 사용한 스트림 코드  */
		System.out.println(Arrays.stream(garden).collect(groupingBy(p->p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), toSet())));
	}
}
