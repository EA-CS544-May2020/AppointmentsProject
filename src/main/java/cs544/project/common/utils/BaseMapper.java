package cs544.project.common.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;

@Component
public abstract class BaseMapper<Source, Target extends Serializable> {

private BoundMapperFacade<Source, Target>  mapper; 
	
	private Class<Source> sourceType;
	
	private Class<Target> targetType;
	
	public BaseMapper(MapperFactory mapperFactory, Class<Source> sourceType, Class<Target> targetType) {
		super();

		this.sourceType = sourceType;
		this.targetType = targetType;
		
		mapper = registerMapper(mapperFactory);
	}

	
	protected BoundMapperFacade<Source, Target> registerMapper(MapperFactory mapperFactory) {
		mapperFactory.classMap(sourceType, targetType)
			.byDefault() // copies all the fields that have the same name and ignores the rest
			.register();
	
		return mapperFactory.getMapperFacade(sourceType, targetType);
	}
	
	public Target map(Source source) {
		return mapper.map(source);
	}

	public Target map(Source source, Target target) {
		return mapper.map(source, target);
	}
	
	public List<Target> mapCollection(List<Source> sources){
		List<Target> targetCollection = new ArrayList<Target>();
		sources.forEach(item ->targetCollection.add(map(item)));
		return targetCollection;
	}

}
