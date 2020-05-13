package cs544.project.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cs544.project.domain.Appointment;
import cs544.project.service.response.AppointmentResponse;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class AppointmentResponseMapper extends ConfigurableMapper {
	/*
	private MapperFacade facade;
	
	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(Appointment.class, AppointmentResponse.class)
				.byDefault()
				.register();
	}
	
	private BoundMapperFacade<Appointment, AppointmentResponse>  mapper; 
	@Autowired
	private Appointment sourceType;
	@Autowired
	private AppointmentResponse targetType;
	
	@Autowired
	public AppointmentResponseMapper(MapperFactory mapperFactory, Appointment sourceType,
			AppointmentResponse targetType) {
		this.sourceType = sourceType;
		this.targetType = targetType;
		mapper = registerMapper(mapperFactory);
	}
	
	protected BoundMapperFacade<Appointment, AppointmentResponse> registerMapper(MapperFactory mapperFactory) {
		mapperFactory.classMap(sourceType, targetType)
			.byDefault() // copies all the fields that have the same name and ignores the rest
			.register();
	
		return mapperFactory.getMapperFacade(sourceType, targetType);
	}
	*/
}
