package com.target.casestudy.transit.repositories;

import com.target.casestudy.transit.model.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRouteRepository extends JpaRepository<BusRoute,Long> {

    @Query("SELECT obj FROM BusRoute obj " +
            "left join fetch obj.busStops " )
    BusRoute findByRouteName(String routeName);
}
