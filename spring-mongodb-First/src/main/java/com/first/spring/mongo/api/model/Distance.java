package com.first.spring.mongo.api.model;

public  class Distance{
	
	
	public double d;
	public String hotelN;
	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}
	public String getHotelN() {
		return hotelN;
	}
	public void setHotelN(String hotelN) {
		this.hotelN = hotelN;
	}
	@Override
	public String toString() {
		return "Distance [d=" + d + ", hotelN=" + hotelN + "]";
	}
/*	@Override
	public double compareTo(Distance distance) {
		double comparedis=((Distance)distance).getD();
		
		return this.d-comparedis;
	}*/
}
