package br.com.home.help.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public abstract class AbstractResource {

	protected Mapper mapper;

	protected Logger log = LoggerFactory.getLogger(this.getClass());	

	protected <T, E extends Object> List<T> mapList(List<E> sourceList, Class<T> clazz) {
		if (sourceList == null)
			return null;

		List<T> destinationList = new ArrayList<T>();

		for (Object item : sourceList){
			destinationList.add(mapper.map(item, clazz));
		}
		return destinationList;
	}

	protected <T> T map(Object source, Class<T> clazz) {
		if (source == null)
			return null;
		return mapper.map(source, clazz);
	}

}
