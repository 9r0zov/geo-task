package com.pony101.taskgeo.repositories.impl;

import com.pony101.taskgeo.dto.IPoint;
import com.pony101.taskgeo.models.Vehicle;
import com.pony101.taskgeo.repositories.LocationRepository;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

    private MongoTemplate mongoTemplate;

    public LocationRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Vehicle> searchInsideBox(Double minLat, Double maxLat, Double minLong, Double maxLong) {
        final BasicQuery query = new BasicQuery(String.format("{location: {$geoWithin: {$box: [[ %s, %s ], [ %s, %s ]]}}}",
                minLat, minLong, maxLat, maxLong));
        return mongoTemplate.find(query, Vehicle.class);
    }

    @Override
    public List<Vehicle> searchInsideRect(IPoint topLeft, IPoint topRight, IPoint bottomRight, IPoint bottomLeft) {
        final BasicQuery query = new BasicQuery(String.format(
                "{location: {$geoWithin: {$geometry: {type : 'Polygon' ," +
                        "coordinates: [ [ [ %s, %s ], [ %s, %s ], [ %s, %s ], [ %s, %s ] ] ]}}}}",
                topLeft.getX(), topLeft.getY(),
                topRight.getX(), topRight.getY(),
                bottomRight.getX(), bottomRight.getY(),
                bottomLeft.getX(), bottomLeft.getY()));
        return mongoTemplate.find(query, Vehicle.class);
    }

}
