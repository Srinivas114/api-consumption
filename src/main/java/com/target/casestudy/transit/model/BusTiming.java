package com.target.casestudy.transit.model;

import com.target.casestudy.transit.model.response.NextBusResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bus_timing")
@SqlResultSetMapping(
        name = "nextBusTimeMapping",
        classes = {
                @ConstructorResult(
                        targetClass = NextBusResponse.class,
                        columns = {
                                @ColumnResult(name = "bus_number", type = String.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = "BusTiming.findBusTimings", query = "select b.bus_number,bt.bus_time, 2 AS time_remaining,bs.stop_name,br.route_name,bt.direction from bus_timing bt  " +
        " left join bus_stop bs on bs.id=bt.bus_stop_id " +
        " left join bus_route br on br.id=bs.bus_route_id " +
        " left join bus b on b.bus_number=br.bus_number " +
        " where bs.stop_code= :stopCode and route_name = :routeName and direction= :direction",
        resultSetMapping = "nextBusTimeMapping"

)

public class BusTiming extends BaseModel {

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "bus_stop_id")
    private BusStop busStop;

    @Column(name = "bus_time", nullable = false)
    @Temporal(TemporalType.TIME)
    public Date busTime;

    @Column(name = "direction", nullable = false)
    private Direction direction;

    public void setDirection(Integer direction){
        this.direction = BusTiming.Direction.getEnum(direction);
    }

    public enum Direction{
        EAST(1),WEST(2),SOUTH(3),NORTH(4);
        private Integer direction;

        Direction(Integer direction){
            this.direction=direction;
        }

        public Integer getValue(){
            return direction;
        }

        public Integer getDirection() {
            return direction;
        }

        public void setDirection(Integer direction) {
            this.direction = direction;
        }

        public static Direction getEnum(int direction) {
            for (Direction enumerator : Direction.values()) {
                if (enumerator.getValue() == direction) {
                    return enumerator;
                }
            }
            throw new RuntimeException("Enumerator not found for value = " + direction);
        }

        @Override
        public String toString() {
            return direction.toString();
        }
    }

}
