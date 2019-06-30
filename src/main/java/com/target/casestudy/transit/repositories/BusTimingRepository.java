package com.target.casestudy.transit.repositories;

import com.target.casestudy.transit.model.BusTiming;
import com.target.casestudy.transit.model.response.NextBusResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusTimingRepository  extends JpaRepository<BusTiming,Long> {


    @Query(nativeQuery = true)
    List<NextBusResponse> findBusTimings( @Param("routeName") String routeName, @Param("stopCode") String stopCode, @Param("direction") Integer direction);
}
