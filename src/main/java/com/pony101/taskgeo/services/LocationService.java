package com.pony101.taskgeo.services;

import com.pony101.taskgeo.models.IRect;
import com.pony101.taskgeo.models.ISimpleRect;
import com.pony101.taskgeo.models.Vehicle;
import com.pony101.taskgeo.repositories.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Vehicle> list(IRect rect) {
        return locationRepository.searchInsideRect(rect.getLeftTop(), rect.getRightTop(), rect.getRightBottom(), rect.getLeftBottom());
    }

    public List<Vehicle> list(ISimpleRect rect) {
        return locationRepository.searchInsideBox(rect.getMinLat(), rect.getMaxLat(), rect.getMinLong(), rect.getMaxLong());
    }

}