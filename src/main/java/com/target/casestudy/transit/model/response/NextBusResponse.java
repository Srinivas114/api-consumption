package com.target.casestudy.transit.model.response;

import com.target.casestudy.transit.model.BusTiming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NextBusResponse {

    private String busNumber;
    private Time busTime;
    private Time timeRemaining;
    private String stopName;
    private String routeName;

    private BusTiming.Direction direction;

    public void setDirection(Integer direction){
        this.direction = BusTiming.Direction.getEnum(direction);
    }
}
