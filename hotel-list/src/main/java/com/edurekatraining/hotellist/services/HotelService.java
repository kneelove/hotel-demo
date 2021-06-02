package com.edurekatraining.hotellist.services;

import com.edurekatraining.hotellist.models.Hotel;
import com.edurekatraining.hotellist.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IhotelService {
    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> getAllHotels(){
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotelRepository.findAll().forEach(hotel->hotels.add(hotel));
        return hotels;
    }

    public Hotel getHotelById(int id){
        return hotelRepository.findById(id).get();
    }
    public void saveOrUpdate(Hotel hotel){
        hotelRepository.save(hotel);
    }
    public void delete(int id){
        hotelRepository.deleteById(id);
    }

    @Override
    public List<Hotel> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Hotel> pagedResult = hotelRepository.findAll(paging);

        return pagedResult.toList();
    }
}
