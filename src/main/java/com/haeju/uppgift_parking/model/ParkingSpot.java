package com.haeju.uppgift_parking.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parking_spot")
public class ParkingSpot {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Getter
    @Setter
    Point<G2D> position;

    @OneToMany
    @JoinColumn(name = "parking_spot_id", referencedColumnName = "id")
    private List<ParkingEvent> parkingEvents;
}
