package com.edurekatraining.hotellist.services;

import com.edurekatraining.hotellist.models.Hotel;

import java.util.List;

public interface IhotelService {
    List<Hotel> findPaginated(int pageNo, int pageSize);
}
