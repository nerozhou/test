package design.pattern.adapter;

import java.util.Date;

public class TimeAdapter2 extends AbstactClient {
	
	private TimeService service;
	
	public TimeAdapter2 (TimeService s) {
		service = s;
	}
	
	@Override
	public Date getTime() {
		return new Date(this.currentTime + service.getTimeMillis());
	}

}
