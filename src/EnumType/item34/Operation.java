package EnumType.item34;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operation {
	PLUS("+") {
		public double apply(double x, double y) { return x + y;}
	},
	MINUS("-"){
		public double apply(double x, double y) { return x - y;}
	},
	TIMES("*"){
		public double apply(double x, double y) { return x * y;}
	},
	DIVIDE("/"){
		public double apply(double x, double y) { return x / y;}
	};
	
	private final String symbol;
	
	Operation(String symbol) { this.symbol = symbol; }
	
	@Override
	public String toString() { return symbol; };
	
	public abstract double apply(double x, double y);
	
	// 열거 타입용 fromString 메서드 구현
	private static final Map<String, Operation> stringToEnum = Stream.of(values()).collect(
																		toMap(Object::toString, e-> e));
	
	// 파라메터 문자열이 존재하면 반환
	public static Optional<Operation> fromString(String symbol) {
		return Optional.ofNullable(stringToEnum.get(symbol));
	}
	
	public static void main(String[] args) {
		double x = 3.2;
		double y = 4.5;
		
		for (Operation op : Operation.values())
			System.out.println(String.format("%f %s %f = %f%n", x, op, y, op.apply(x, y)));
	}
}
