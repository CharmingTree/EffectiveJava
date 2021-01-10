package Generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Raw 
{
	/* ========================================================
	 * Row Type�� ������� ����. 
	 * �ڹٿ� ���׸� Ÿ���� �ʰ� ���ԵǾ��� ������  ȣȯ�� ������ �־ ��¿ �� ���� ���Ǳ� ������
	 * ������ ������ �߻��� �� �ֱ� ������ ������� �ʴ°� �ּ��̴�.
	 * ======================================================== */
	public static <E> void main(String[] args)
	{
		/* RowType : Ÿ���� ���� ���� ���� */
		Collection lowType = new ArrayList<String>();
		lowType.add(10); // Ÿ�� ������ ������ �ʾƼ� String�� �ƴ� ��Ҹ� �����ص� ������ �������� ������ �ʴ´�. 
						 // ��� ������ �ǵ��� ������ �ð��� ������ �Ѵ�. 
		
		/* prameterized Type : Ÿ���� ������*/
		List<String> paramterType = new ArrayList<>();
		//paramterType.add(10); // ���� �ٸ��� ���� ����. ��, ������ ���� ���� ������. 
		
		/* Generic Type */
		List<E> genericType = new ArrayList<E>();
		//genericType.add(10);
		
		List<String> strs = new ArrayList<>();
		unSafeAdd(strs, Integer.valueOf(99));
		//String s = strs.get(0); // �����Ϸ��� �ڵ����� ����ȯ �ڵ� ����. ( List.get -> element(?) -> cast to String -> add ) �̷���?
	}
	
	private static void unSafeAdd(List list, Object o)
	{
		list.add(o); // ������ ���� :: ClassCastException 
	}
	

}
