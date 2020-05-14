package cs544.project.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cs544.project.common.utils.BaseMapper;
import cs544.project.domain.Reservation;
import cs544.project.service.response.ReservationResponse;
import ma.glasnost.orika.MapperFactory;

@Component
public class ReservationResponseMapper extends BaseMapper<Reservation, ReservationResponse> {

	@Autowired
	public ReservationResponseMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Reservation.class, ReservationResponse.class);
	}
	
}