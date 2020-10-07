package com.pony101.taskgeo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "vehicles")
public class Vehicle {

    @Id
    private String id;
    @GeoSpatialIndexed(name="Location")
    private Double[] location;
    @Field("reporting_time")
    private LocalDateTime reportingTime = LocalDateTime.now();

}
