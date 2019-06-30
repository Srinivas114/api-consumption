package com.target.casestudy.transit.repositories;

import com.target.casestudy.transit.model.Bus;
import com.target.casestudy.transit.model.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop,Long> {

}
