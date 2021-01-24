package Generic.Container;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// 타입 안전 이종 컨테이너 패턴 (type safe heterogeneous container pattern)
/*
 * Set<E>, Map<K,V> 처럼 클래스 레벨에서 매개 변수화 할 수 있는 타입은 제한적 
 * 타입의 수 제한 없이 유연하게 필요한 경우 (e.g 데이터 베이스의 행에 대한 열 리스트 (DTO 같은? ) 
 * 이를 해결할 수 있는 방법은 컨테이너 대신 키를 매개변수화 하고 컨테이너 값을 넣거나 뺼때 키 타입을 제공한다 
 * */
public class Favorites {

	private Map<Class<?>, Object> favorites = new HashMap<>();
	
	public <T> void putFavorite(Class<T> type, T instance) {
		favorites.put(Objects.requireNonNull(type), instance);
	}
	
	public <T> T getFavorite(Class<T> type) {
		return type.cast(favorites.get(type));
	}
	
	// 동적 형변환으로 런타임 안전성 확보 버전 
	public <T> void putFavorite_DynamicCast(Class<T> type, T instance) {
		favorites.put(Objects.requireNonNull(type), type.cast(instance));
	}
	
	
	public static void main(String[] args) {
		Favorites f = new Favorites();
		
		f.putFavorite(String.class, "java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);
		
		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		Class<?> favoriteClass = f.getFavorite(Class.class);
		
		System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
		
	}
}
