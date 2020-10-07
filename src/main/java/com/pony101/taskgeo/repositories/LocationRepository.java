package com.pony101.taskgeo.repositories;

import com.pony101.taskgeo.dto.IPoint;
import com.pony101.taskgeo.models.Vehicle;

import java.util.List;

public interface LocationRepository {

    List<Vehicle> searchInsideBox(Double minLat, Double maxLat, Double minLong, Double maxLong);
    List<Vehicle> searchInsideRect(IPoint topLeft, IPoint topRight, IPoint bottomRight, IPoint bottomLeft);

}
