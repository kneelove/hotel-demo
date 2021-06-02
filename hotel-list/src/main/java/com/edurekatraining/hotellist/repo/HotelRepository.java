package com.edurekatraining.hotellist.repo;

import com.edurekatraining.hotellist.models.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HotelRepository extends CrudRepository<Hotel,Integer>, PagingAndSortingRepository<Hotel,Integer> {
}
