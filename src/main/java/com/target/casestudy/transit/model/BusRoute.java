package com.target.casestudy.transit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bus_route")
public class BusRoute extends BaseModel {

    @Column(name="route_name")
    private String routeName;

    @Column(name="bus_number")
    private String busNumber;

    @OneToMany(mappedBy = "busRoute", fetch = FetchType.LAZY)
    private Set<BusStop> busStops;
}
