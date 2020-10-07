package com.pony101.taskgeo.dto.convertion;

import com.pony101.taskgeo.dto.VehicleDTO;
import com.pony101.taskgeo.models.Vehicle;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class VehicleToVehicleDTOConverter implements Converter<Vehicle, VehicleDTO> {
    @Override
    public VehicleDTO convert(MappingContext<Vehicle, VehicleDTO> context) {
        Vehicle source = context.getSource();
        VehicleDTO dto = new VehicleDTO();
        dto.setId(source.getId());
        dto.setLatitude(source.getLocation()[0]);
        dto.setLongitude(source.getLocation()[1]);
        return dto;
    }
}
