package Builder;

// ������ ������ ���ϰ� �ڹٺ��� ������ ������ ����.
public class NutritionFacts {

	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int calbohydrate;
	
	private NutritionFacts(Builder builder)
	{
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		calbohydrate = builder.carbohydrate;
	}
	
	public static class Builder {
		// �ʼ� �Ű�����
		private final int servingSize;
		private final int servings;
		
		// ���� �Ű����� - �⺻������ �ʱ�ȭ
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;
		
		public Builder(int servingSize, int servings)
		{
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val)
		{
			calories = val;
			return this;
		}
		
		public Builder fat(int var) {
			fat = var;
			return this;
		}
		
		public Builder sodium(int var) {
			sodium = var;
			return this;
		}
		
		public Builder carbohydrate(int var) {
			carbohydrate = var;
			return this;
		}
		
		public NutritionFacts build()
		{
			return new NutritionFacts(this);
		}

		@Override
		public String toString() {
			return "Builder [servingSize=" + servingSize + ", servings="
					+ servings + ", calories=" + calories + ", fat=" + fat
					+ ", sodium=" + sodium + ", carbohydrate=" + carbohydrate
					+ "]";
		}
		
		
	}
	
	
	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings="
				+ servings + ", calories=" + calories + ", fat=" + fat
				+ ", sodium=" + sodium + ", calbohydrate=" + calbohydrate + "]";
	}


	public static void main(String[] args)
	{
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).carbohydrate(28).build();
		System.out.println(cocaCola);
	}
}
