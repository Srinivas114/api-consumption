package com.target.casestudy.transit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bus")
public class Bus extends BaseModel {

    @Column(name="bus_number")
    private String busNumber;

    @Column(name = "bound", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Bound bound;

    @OneToMany(mappedBy = "bus", fetch = FetchType.LAZY)
    private Set<BusTiming> busTimings;

    public enum Bound{
        EAST(1),WEST(2),SOUTH(3),NORTH(4);
        private Integer direction;

        Bound(Integer direction){
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

        public static Bound getEnum(int bound) {
            for (Bound enumerator : Bound.values()) {
                if (enumerator.getValue() == bound) {
                    return enumerator;
                }
            }
            throw new RuntimeException("Enumerator not found for value = " + bound);
        }

        @Override
        public String toString() {
            return direction.toString();
        }
    }

    public void setDirection(Integer bound){
        this.bound = Bound.getEnum(bound);
    }
}
