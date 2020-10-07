package com.pony101.taskgeo.repositories;

import com.pony101.taskgeo.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
