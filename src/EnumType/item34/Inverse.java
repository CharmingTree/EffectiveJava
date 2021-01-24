package EnumType.item34;

public class Inverse {
	public static Operation inverse(Operation op) {
		switch(op) {
			case PLUS: return Operation.MINUS;
			case MINUS: return Operation.PLUS;
			case TIMES: return Operation.DIVIDE;
			case DIVIDE: return Operation.TIMES;
			
			default: throw new AssertionError();
		}
	}
	
	public static void main(String[] args)
	{
		double x = 3.1;
		double y = 4.2;
		for (Operation op : Operation.values()) {
			Operation invOp = inverse(op);
			System.out.println(String.format("%f %s %f = %f%n", x, op, y, invOp.apply(x, y)));
		}
			
	}
}
