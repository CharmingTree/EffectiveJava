package singleton.field;

// public static final �ʵ� ����� �̱���
public class Elvis {

		public static Elvis INSTANCE = new Elvis();
		
		private Elvis() {}
		
		public void leaveTheBuilding() {
			System.out.println("Whoa baby, I'm outta here!");
		}
		
		// �� �޼���� ���� Ŭ���� �ٱ�(�ٸ� Ŭ����)�� �ۼ��ؾ� �Ѵ�.
		public static void main(String[] args)
		{
			Elvis elvis = Elvis.INSTANCE;
			elvis.leaveTheBuilding();
		}
}
