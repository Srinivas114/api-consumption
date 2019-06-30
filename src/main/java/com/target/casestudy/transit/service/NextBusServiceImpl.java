package com.target.casestudy.transit.service;

import com.target.casestudy.transit.model.BusRoute;
import com.target.casestudy.transit.model.BusTiming;
import com.target.casestudy.transit.model.response.NextBusResponse;
import com.target.casestudy.transit.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NextBusServiceImpl implements NextBusService {

    @Autowired
    BusRepository busRepository;

    @Autowired
    BusRouteRepository busRouteRepository;

    @Autowired
    BusStopRepository busStopRepository;
    @Autowired
    BusTimingRepository busTimingRepository;

    @Autowired
    NextBusDao nextBusDao;

    public NextBusResponse findNextBus(String route, BusTiming.Direction direction, String stop) throws Exception{

        BusRoute busRoute = busRouteRepository.findByRouteName(route);

//        List<NextBusResponse> busTimings = busTimingRepository.findBusTimings(route, direction, stop);

        NextBusResponse nextBusResponse = new NextBusResponse();
//        nextBusResponse.setRoute(busRoute.getRouteName());
        nextBusResponse.setBusNumber(busRoute.getBusNumber());

        return  nextBusResponse;
    }
    public List<NextBusResponse> findRouteBuses(String route, BusTiming.Direction direction, String stop) throws Exception{
        return nextBusDao.findBusTimings(stop, direction,route);
    }
}
