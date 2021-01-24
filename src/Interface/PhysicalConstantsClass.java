package Interface;

/*
 * 상수 인터페이스를 방지하기 위해 '유틸리티 클래스' 형태로 만든 모습.
 * */
public class PhysicalConstantsClass {
	
	private PhysicalConstantsClass() {} // 인스턴스화 방지
	
	public static final double AVOGADROS_NUMBERS = 6.022_140_857e23;
	
	public static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
	
	public static final double ELECTRON_MASS = 9.109_383_56e-31;
}