package com.pony101.taskgeo.config;

import com.pony101.taskgeo.dto.convertion.VehicleDTOToVehicleConverter;
import com.pony101.taskgeo.dto.convertion.VehicleToVehicleDTOConverter;
import com.pony101.taskgeo.models.Vehicle;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@Configuration
@EnableSwagger2
@ComponentScan("com.pony101.taskgeo")
@RequiredArgsConstructor
public class ApplicationConfig {

    private final MongoTemplate mongoTemplate;

    @PostConstruct
    public void init() {
        mongoTemplate.indexOps(Vehicle.class).ensureIndex(new GeospatialIndex("location"));
    }

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new VehicleToVehicleDTOConverter());
        modelMapper.addConverter(new VehicleDTOToVehicleConverter());
        return modelMapper;
    }

    @Bean
    public Docket geoServiceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(true);
    }

}
