package com.booking.recruitment.hotel.util;

import java.util.Comparator;

import com.booking.recruitment.hotel.model.Hotel;

public class DistanceComparator implements Comparator<Object>{

	@Override
	public int compare(Object object1, Object object2) {
		Hotel hotel1 = (Hotel)object1;
		Hotel hotel2 = (Hotel)object2;
		
		double h1Distance = HaversineDistance.haversine(hotel1.getLatitude(), hotel1.getLongitude(), hotel1.getCity().getCityCentreLatitude(), hotel1.getCity().getCityCentreLongitude());
		
		double h2Distance = HaversineDistance.haversine(hotel2.getLatitude(), hotel2.getLongitude(), hotel2.getCity().getCityCentreLatitude(), hotel2.getCity().getCityCentreLongitude());

		if(h1Distance == h2Distance)
		{
			return 0;
		}
		else if(h1Distance > h2Distance)
		{
			return 1;
		}
		else
			return -1;
	}

}
