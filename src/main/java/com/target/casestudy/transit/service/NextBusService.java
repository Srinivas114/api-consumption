package com.target.casestudy.transit.service;

import com.target.casestudy.transit.model.BusStop;
import com.target.casestudy.transit.model.BusTiming;
import com.target.casestudy.transit.model.response.NextBusResponse;

import java.util.List;

public interface NextBusService {
    NextBusResponse findNextBus(String route, BusTiming.Direction direction, String stop) throws Exception;
    List<NextBusResponse> findRouteBuses(String route, BusTiming.Direction direction, String stop) throws Exception;
}
