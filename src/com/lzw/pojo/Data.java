package com.lzw.pojo;

public class Data implements java.io.Serializable{
	private String temperature;		//温度
	private String nextTemperature;
	private String time;	//时间
	private String pressure ;		//压力
	private String nextPressure ;
	public Data(String temperature, String time, String pressure) {
		super();
		this.temperature = temperature;
		this.time = time;
		this.pressure = pressure;
	}
	public String getNextTemperature() {
		return nextTemperature;
	}
	public void setNextTemperature(String nextTemperature) {
		this.nextTemperature = nextTemperature;
	}
	public String getNextPressure() {
		return nextPressure;
	}
	public Data() {
		super();
	}
	public void setNextPressure(String nextPressure) {
		this.nextPressure = nextPressure;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Data [temperature=" + temperature + ", nextTemperature=" + nextTemperature + ", time=" + time
				+ ", pressure=" + pressure + ", nextPressure=" + nextPressure + "]";
	}
}