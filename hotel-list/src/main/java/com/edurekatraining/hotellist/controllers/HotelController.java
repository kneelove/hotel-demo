package com.edurekatraining.hotellist.controllers;

import com.edurekatraining.hotellist.models.Hotel;
import com.edurekatraining.hotellist.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping(value = "/hotels",params = {"page","size"})
    private List<Hotel> getAllHotels(@RequestParam("page") int page, @RequestParam("size") int size, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        return hotelService.findPaginated(page,size);    }

    @GetMapping("/hotels/{id}")
    private Hotel getHotel(@PathVariable("id") int id) {
        return hotelService.getHotelById(id);
    }

    @DeleteMapping("/hotels/{id}")
    private void deleteHotel(@PathVariable("id") int id) {
       hotelService.delete(id);
    }

    @PutMapping("/hotels")
    private void savePerson(@RequestBody Hotel hotel) {
        hotelService.saveOrUpdate(hotel);
    }
}
