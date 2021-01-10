package Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Raw 
{
	/* ========================================================
	 * Row Type을 사용하지 말자. 
	 * 자바에 제네릭 타입이 늦게 도입되었기 때문에  호환성 문제가 있어서 어쩔 수 없이 허용되긴 하지만
	 * 잠재적 오류가 발생할 수 있기 때문에 사용하지 않는게 최선이다.
	 * ======================================================== */
	public static <E> void main(String[] args)
	{
		/* RowType : 타입이 지정 되지 않은 */
		Collection lowType = new ArrayList<String>();
		lowType.add(10); // 타입 지정을 해주지 않아서 String이 아닌 요소를 삽입해도 컴파일 오류에서 잡히지 않는다. 
						 // 모든 오류는 되도록 컴파일 시간에 잡혀야 한다. 
		
		/* prameterized Type : 타입이 지정됨*/
		List<String> paramterType = new ArrayList<>();
		//paramterType.add(10); // 위와 다르게 구문 오류. 즉, 컴파일 오류 내에 잡힌다. 
		
		/* Generic Type */
		List<E> genericType = new ArrayList<E>();
		//genericType.add(10);
		
		List<String> strs = new ArrayList<>();
		unSafeAdd(strs, Integer.valueOf(99));
		//String s = strs.get(0); // 컴파일러가 자동으로 형변환 코드 삽입. ( List.get -> element(?) -> cast to String -> add ) 이렇게?
	}
	
	private static void unSafeAdd(List list, Object o)
	{
		list.add(o); // 컴파일 오류 :: ClassCastException 
	}
	

}
