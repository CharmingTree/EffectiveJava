package chapter8;

import java.util.Date;

public class Period {

	private final Date start;
	private final Date end;
	
	/*
	public Period(Date start, Date end) {
		if (start.compareTo(end) > 0)
			throw new IllegalArgumentException();
		this.start = start;
		this.end = end;
	}
	
	public Date start() {
		return start;
	}
	
	public Date end() {
		return end;
	}
	
	public String toString() {
		return start + " - " + end;
	}
	*/
	
	/* 방어적 복사본 만들어 내부 보호 */
	public Period(Date start, Date end)  {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException();
		}
	}
	
	public Date start() {
		return new Date(start.getTime());
	}
	
	public Date end() {
		return new Date(end.getTime());
	}
	
	public String toString() {
		return start + " - " + end;
	}
}
