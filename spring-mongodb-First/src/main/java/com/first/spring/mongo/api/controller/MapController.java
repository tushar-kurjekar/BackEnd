package com.first.spring.mongo.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first.spring.mongo.api.model.Distance;
import com.first.spring.mongo.api.model.MapC;
import com.first.spring.mongo.api.model.MapC2;
import com.first.spring.mongo.api.repository.Map2Repository;
import com.first.spring.mongo.api.repository.MapRepository;

@RestController
@CrossOrigin(origins="*")

public class MapController {
	
	@Autowired
	private MapRepository repository;
	
	@Autowired
	private Map2Repository repo;
	
	List<Distance> ld = new ArrayList<Distance>();
	List<MapC> list = new ArrayList<MapC>();
	List<MapC2> list2 = new ArrayList<MapC2>();
	
	@GetMapping("/getNerbyLoc")
	public List<Distance> getData(@RequestParam("lat1")Double lat1, @RequestParam("log1")Double log1){
		
		//System.out.println("Lattitude is "+lat1);
		//System.out.println("Longitude is "+log1);
		
		list = repository.findAll();
		ld.clear();
		
		for(int i=0; i<list.size(); i++)
		{
				Double theta = log1 - list.get(i).getLog1();
				Double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(list.get(i).getLat1()))
+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(list.get(i).getLat1())) * Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.1515;
				dist = dist * 1.609344;
				Distance dh = new Distance();
				dh.setD(dist);
				dh.setHotelN(list.get(i).getHotelName());
				ld.add(dh);
		}
		
		Collections.sort(ld,new Comparator<Distance>() {
			@Override
			public int compare(Distance d1,Distance d2) {
				return Double.compare(d1.getD(), d2.getD());
			}
		});
		
		return ld;	
	}
	
	@GetMapping("/getCinema")
	public List<Distance> getDataC(@RequestParam("lat1")Double lat1, @RequestParam("log1")Double log1){
		
		//System.out.println("Lattitude is "+lat1);
		//System.out.println("Longitude is "+log1);
		
		list2 = repo.findAll();
		
		/*for(int i=0; i<list2.size(); i++)
		{
			System.out.println(list2.get(i));
		}*/
		
		ld.clear();
		
		for(int i=0; i<list2.size(); i++)
		{
				Double theta = log1 - list2.get(i).getLog1();
				Double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(list2.get(i).getLat1()))
+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(list2.get(i).getLat1())) * Math.cos(Math.toRadians(theta));
				dist = Math.acos(dist);
				dist = Math.toDegrees(dist);
				dist = dist * 60 * 1.1515;
				dist = dist * 1.609344;
				Distance dh = new Distance();
				dh.setD(dist);
				dh.setHotelN(list2.get(i).getCinemaName());
				ld.add(dh);
		}
		Collections.sort(ld,new Comparator<Distance>() {
			@Override
			public int compare(Distance d1,Distance d2) {
				return Double.compare(d1.getD(), d2.getD());
			}
		});
		
		return ld;	
		
	}
}
