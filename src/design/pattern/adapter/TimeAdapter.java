package design.pattern.adapter;

import java.util.Date;

public class TimeAdapter extends TimeService implements Client{

	@Override
	public Date getTime() {
		return new Date(getTimeMillis());
	}

}
