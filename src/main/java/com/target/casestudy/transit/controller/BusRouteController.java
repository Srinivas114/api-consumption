package com.target.casestudy.transit.controller;

import com.target.casestudy.transit.model.BusTiming;
import com.target.casestudy.transit.model.response.NextBusResponse;
import com.target.casestudy.transit.service.NextBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("NextTrip")
public class BusRouteController {


    @Autowired
    NextBusService nextBusService;

    @GetMapping("/{route}/{direction}/{stop}")
    List<NextBusResponse> getNextBuses(@PathVariable("route") String route,
                                       @PathVariable("direction") BusTiming.Direction direction,
                                       @PathVariable("stop") String stop) throws Exception{

        return  nextBusService.findRouteBuses(route, direction, stop);

    }

}
