package Lamda;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
	
	/* 람다를 인스턴스 필드에 저장해 상수별 동작을 구현한 열거 타입 */
	PLUS ("+", (x,y) -> x + y),
	MINUS ("-", (x,y) -> x - y),
	TIMES ("*", (x,y) -> x * y),
	DIVIDE ("/", (x,y) -> x / y);
	
	private final String symbol;
	private final DoubleBinaryOperator op;
	
	Operation(String symbol, DoubleBinaryOperator op) {
		this.symbol = symbol;
		this.op = op;
	}
	
	@Override
	public String toString() { return symbol; }
	
	public double apply(double x, double y) {
		return op.applyAsDouble(x, y);
	}
	
	public static void main(String[] args) {
		double x = 3.1;
		double y = 4.5;
		for (Operation op : Operation.values()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}
	
	
	
}
