package com.first.spring.mongo.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MapC2")
public class MapC2 {
	@Id
	public String id;
	public String cinemaName;
	public double lat1;
	public double log1;
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
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
		return "MapC2 [cinemaName=" + cinemaName + ", lat1=" + lat1 + ", log1=" + log1 + "]";
	}
	

}
