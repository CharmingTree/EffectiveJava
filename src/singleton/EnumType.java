package singleton;

// ���� Ÿ�� ����� �̱���
public enum EnumType {
	INSTANCE;
	
	public void leaveTheBuilding() {
		System.out.println("Wait Honey!");
	}

	public static void main(String[] args)
	{
		EnumType enumType = EnumType.INSTANCE;
		enumType.leaveTheBuilding();
	}
}
