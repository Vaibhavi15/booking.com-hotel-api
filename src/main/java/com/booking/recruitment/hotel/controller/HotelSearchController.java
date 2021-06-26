package com.booking.recruitment.hotel.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.HotelSearchService;

@RestController
@RequestMapping("/search")
public class HotelSearchController {
  private final HotelSearchService hotelSearchService;

  @Autowired
  public HotelSearchController(HotelSearchService hotelSearchService) {
    this.hotelSearchService = hotelSearchService;
  }

  @GetMapping("/{cityId}/?sortBy=(distance)")
  @ResponseStatus(HttpStatus.OK)
  public List<Hotel> getHotel(@PathVariable @NotNull Long cityId)
  {
	  return hotelSearchService.searchClosestHotelsByCity(cityId);
  }
}
