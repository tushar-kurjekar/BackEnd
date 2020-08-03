package com.first.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.first.spring.mongo.api.model.MapC;

public interface MapRepository  extends MongoRepository<MapC,String>{

}
