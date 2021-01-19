package EnumType.item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public enum TestEnum {
	BOLD(1), ITALIC(2), UNDERLINE(3), STRIKETHROUGH(4);
	
	private final int number;
	
	TestEnum(int number) {
		this.number = number;
	}
	
	public static void applyStyles(Set<TestEnum> styles) {
		System.out.printf("Applying styles %s to text%n", Objects.requireNonNull(styles));
	}
	
	public static void main(String[] args) {
		TestEnum.applyStyles(EnumSet.of(TestEnum.BOLD, TestEnum.ITALIC));
	}
}
