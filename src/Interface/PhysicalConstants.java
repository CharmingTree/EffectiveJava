package Interface;

/* 상수용 공개 인터페이스를 만들지 말라고 한다.
 * 내부 구현 클래스의 api를 노출하는 행위라고하며,
 * 클래스가 어떤 상수 인터페이스를 사용하든 사용자에게는 아무런 의미가 없다. 오히려 사용자에게 혼란을준다고 한다.
 * 심하게 말하면 클라이언트 코드가 내부 구현에 해당하는 이 상수들에 종속되게 한다고 한다. 이후 이 상수를 사용하지 않는다고 해도
 * 바이너리 호환성을 위해 여전히 상수 인터페이스를 구현하고 있어야 한다.
 * 
 * 내 생각 : 
 * 오픈 소스 규모 정도가 아니라면 굳이 안쓸 이유도 없어보인다. 어차피 
 * 일반 개발자들은 내부에 같은 비즈니스 로직을 공유하기 때문에. 그러한 코드들은 재사용성을 위해 
 * 공개하거나 하지 않아 보임.
 * */
public interface PhysicalConstants {
	
	static final double AVOGADROS_NUMBERS = 6.022_140_857e23;
	
	static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
	
	static final double ELECTRON_MASS = 9.109_383_56e-31;
	
}