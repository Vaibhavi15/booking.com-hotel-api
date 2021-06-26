package com.booking.recruitment.hotel.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.repository.HotelRepository;
import com.booking.recruitment.hotel.service.HotelSearchService;
import com.booking.recruitment.hotel.util.DistanceComparator;

@Service
public class DefaultHotelSearchService implements HotelSearchService{
	
	  private final HotelRepository hotelRepository;
	  
	  DistanceComparator distanceComparator = new DistanceComparator();

	  @Autowired
	  DefaultHotelSearchService(HotelRepository hotelRepository) {
	    this.hotelRepository = hotelRepository;
	  }
	  
	  @Override
	  public List<Hotel> searchClosestHotelsByCity(Long cityId) {
		return hotelRepository.findAll().stream()
			   .filter((hotel) -> cityId.equals(hotel.getCity().getId()))
			   .sorted(new DistanceComparator())
			   .limit(3)
			   .collect(Collectors.toList());
	  }  

}
