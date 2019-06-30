package com.target.casestudy.transit.model.response;

import com.target.casestudy.transit.model.BusTiming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NextBusResponse {

    private String busNumber;
    private LocalTime busTime;
    private String stopName;
    private String routeName;

    private BusTiming.Direction direction;

    public String getTimeRemaining() {
        Duration duration = Duration.between(LocalTime.now(),busTime);

        long millis = duration.toMillis();

        if(millis < 0){
            millis = millis + TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);
        }

        return String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }

    public void setDirection(Integer direction){
        this.direction = BusTiming.Direction.getEnum(direction);
    }
}
