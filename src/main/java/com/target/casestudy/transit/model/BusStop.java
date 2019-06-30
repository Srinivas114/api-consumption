package com.target.casestudy.transit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bus_stop")
public class BusStop extends BaseModel{

    @Column(name = "stop_name", nullable = false)
    private String stopName;

    @Column(name = "stop_code", length = 4, nullable = false)
    private String stopCode;

    @ManyToOne
    @JoinColumn(name = "bus_route_id")
    private BusRoute busRoute;

    @OneToMany(mappedBy = "bus", fetch = FetchType.LAZY)
    private Set<BusTiming> busTimings;

    @Column(name = "route_order", nullable = false)
    private Integer routeOrder;
}
