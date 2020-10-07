package com.pony101.taskgeo.dto.convertion;

import com.pony101.taskgeo.dto.VehicleDTO;
import com.pony101.taskgeo.models.Vehicle;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class VehicleDTOToVehicleConverter implements Converter<VehicleDTO, Vehicle> {
    @Override
    public Vehicle convert(MappingContext<VehicleDTO, Vehicle> context) {
        VehicleDTO source = context.getSource();
        Vehicle entity = new Vehicle();
        entity.setId(source.getId());
        entity.setLocation(new Double[]{source.getLatitude(), source.getLongitude()});
        return entity;
    }
}
