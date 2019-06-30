package com.target.casestudy.transit.repositories;

import com.target.casestudy.transit.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {
}
