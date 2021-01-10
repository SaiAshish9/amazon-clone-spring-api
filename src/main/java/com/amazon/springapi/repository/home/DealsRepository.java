package com.amazon.springapi.repository.home;

import com.amazon.springapi.entity.home.Deal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DealsRepository extends MongoRepository<Deal, Integer> {

    List<Deal> findByBestIsTrue();

}

//https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html