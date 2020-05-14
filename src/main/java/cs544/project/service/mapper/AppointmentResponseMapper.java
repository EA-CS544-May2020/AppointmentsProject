package cs544.project.service.mapper;

import org.springframework.stereotype.Component;

import cs544.project.common.utils.BaseMapper;
import cs544.project.domain.Appointment;
import cs544.project.service.response.AppointmentResponse;
import ma.glasnost.orika.MapperFactory;

@Component
public class AppointmentResponseMapper extends BaseMapper<Appointment,AppointmentResponse> {

	public AppointmentResponseMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Appointment.class, AppointmentResponse.class);
	}
}
