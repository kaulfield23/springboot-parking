package com.haeju.uppgift_parking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.geolatte.geom.json.GeolatteGeomModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    GeolatteGeomModule geolatteGeomModule() {
        return new GeolatteGeomModule();
    }
}
