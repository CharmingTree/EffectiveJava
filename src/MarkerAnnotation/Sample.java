package MarkerAnnotation;

public class Sample {

	@Test
	public static void m1() {} // 성공 
	public static void m2() {} 
	@Test public static void m3() { // 실패 
		throw new RuntimeException("fail");
	}
	public static void m4() {} // 테스트 아님
	@Test public void m5() {} // 잘못 사용한 예) 정적메소드 아님 
	public static void m6() {}
	@Test public static void m7() { // 실패 
		throw new RuntimeException("fail");
	}
	public static void m8() {}
}
