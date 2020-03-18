package com.yc.spirngboot.takeout.bean;

public class Dayandcount {
    private Integer weekday;

    private Integer count;

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

	@Override
	public String toString() {
		return "Dayandcount [weekday=" + weekday + ", count=" + count + "]";
	}
    
}