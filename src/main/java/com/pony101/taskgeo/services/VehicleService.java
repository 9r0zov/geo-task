package com.pony101.taskgeo.services;

import com.pony101.taskgeo.exception.NotFoundException;
import com.pony101.taskgeo.models.Vehicle;
import com.pony101.taskgeo.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle save(Vehicle vehicle) {
//        vehicle.setId(UUID.randomUUID().toString());
        return vehicleRepository.save(vehicle);
    }

    // TODO: 06.10.2020 remove?
    public Vehicle update(String id, Vehicle vehicle) {
        return vehicleRepository.findById(id)
                .map(oldVehicle -> {
                    oldVehicle.setLocation(vehicle.getLocation());
                    return vehicleRepository.save(oldVehicle);
                })
                .orElseThrow(NotFoundException::new);
    }

    public void delete(String id) {
        vehicleRepository.findById(id).orElseThrow(NotFoundException::new);
        vehicleRepository.deleteById(id);
    }

    public Vehicle findById(String id) {
        return vehicleRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
