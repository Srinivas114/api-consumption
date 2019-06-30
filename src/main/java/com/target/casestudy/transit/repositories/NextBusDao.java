package com.target.casestudy.transit.repositories;

import com.target.casestudy.transit.model.BusTiming;
import com.target.casestudy.transit.model.response.NextBusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NextBusDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<NextBusResponse> findBusTimings(@Param("stopCode") String stopCode, @Param("direction") BusTiming.Direction direction, @Param("routeName") String routeName) throws Exception{
        String query = "select b.bus_number,\n" +
                "        bt.bus_time,\n" +
                "        (bt.bus_time-LOCALTIME) AS time_remaining,\n" +
                "        bs.stop_name,\n" +
                "        br.route_name,\n" +
                "        bt.direction  from bus_timing bt  " +
                " left join bus_stop bs on bs.id=bt.bus_stop_id " +
                " left join bus_route br on br.id=bs.bus_route_id " +
                " left join bus b on b.bus_number=br.bus_number  and b.id=bt.bus_id " +
                " where bs.stop_code= ? and route_name = ? and direction= ?";


        List<NextBusResponse> rows= jdbcTemplate.query(query, new Object[]{stopCode, routeName,direction.getValue()}, new BeanPropertyRowMapper<>(NextBusResponse.class));

        return rows;
    }

}
