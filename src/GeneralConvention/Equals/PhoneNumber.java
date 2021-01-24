package GeneralConvention.Equals;

import java.util.*;
//전형적인 equals 메서드 예
public final class PhoneNumber 
{
	private final short areaCode, prefix, lineNum;
	
	public PhoneNumber(int areaCode, int prefix, int lineNum)
	{
		this.areaCode = rangeCheck(areaCode, 999, "지역코드");
		this.prefix = rangeCheck(prefix, 999, "프리픽스");
		this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
	}
	
	private static short rangeCheck(int val, int max, String arg)
	{
		if (val < 0 || val > max)
			throw new IllegalArgumentException(arg + ": " + val);
		return (short)val;
	}
	
	@Override
	public boolean equals(Object o) {
		/* 1. 자기 자신 참조인지 검사 한다. */
		if (o == this)
			return true;
		/* 2. 비교 대상이 올바른 타입인지 검사 한다. */
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber pn = (PhoneNumber)o;
		
		/* 3. '핵심'필드들이 같은지 비교 */
		return pn.lineNum == lineNum && pn.prefix == prefix
				&& pn.areaCode == areaCode;
	}
	
	/* 전형적인 hashCode */
//	@Override
//	public int hashCode() {
//		int result = Short.hashCode(areaCode);
//		result = 31 * result + Short.hashCode(prefix);
//		result = 31 * result + Short.hashCode(lineNum);
//		return result;
//	}
	
	
	private int hashCode; // 자동으로 0으로 초기화됨.
	
	/* 지연 초기화 기능 */
	@Override
	public int hashCode() {
		int result = hashCode;
		if (result == 0)
		{
			result = Short.hashCode(areaCode);
			result = 31 * result + Short.hashCode(prefix);
			result = 31 * result + Short.hashCode(lineNum);
			hashCode = result;
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		Map<PhoneNumber, String> m = new HashMap<>();
		m.put(new PhoneNumber(707, 867, 5309), "제니W");
		System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
	}
}
