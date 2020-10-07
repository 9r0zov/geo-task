package com.pony101.taskgeo.repositories;

import com.pony101.taskgeo.models.Vehicle;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository {

    @Query("{" +
            "  location: {" +
            "     $geoWithin: {" +
            "        $box: [" +
            "          [ ?0, ?2 ]," +
            "          [ ?1, ?3 ]" +
            "        ]" +
            "     }" +
            "  }" +
            "}")
    List<Vehicle> searchInsideBox(Double minLat, Double maxLat, Double minLong, Double maxLong);

    @Query("{" +
            "     location: {" +
            "       $geoWithin: {" +
            "          $geometry: {" +
            "             type : 'Polygon' ," +
            "             coordinates: [ [ [ ?0 ], [ ?1 ], [ ?2 ], [ ?3 ] ] ]" +
            "          }" +
            "       }" +
            "     }" +
            "   }")
    List<Vehicle> searchInsideRect(Point topLeft, Point topRight, Point bottomRight, Point bottomLeft);

}
