package com.first.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MapC")
public class MapC {
	@Id
	public String id;
	public String hotelName;
	public double lat1;
	public double log1;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getLat1() {
		return lat1;
	}
	public void setLat1(double lat1) {
		this.lat1 = lat1;
	}
	public double getLog1() {
		return log1;
	}
	public void setLog1(double log1) {
		this.log1 = log1;
	}
	@Override
	public String toString() {
		return "MapC [id=" + id + ", hotelName=" + hotelName + ", lat1=" + lat1 + ", log1=" + log1 + "]";
	}
	
	

}
