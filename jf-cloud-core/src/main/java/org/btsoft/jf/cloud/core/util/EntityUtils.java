package org.btsoft.jf.cloud.core.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

/**
 * 实体工具类
 * @author chenbin
 * @date 2018年6月8日 下午11:08:16
 */
public class EntityUtils {
	
	private final static Logger logger=LoggerFactory.getLogger(EntityUtils.class);

	public static <T> T copyProperties(Object source,Class<T> clazz){
		try {
			if(source!=null){
				T target=clazz.newInstance();
				BeanUtils.copyProperties(source, target);
				return target;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error(String.format("DTO object conversion entity object error: %s", e.getMessage()));
		}
		return null;
	}
	
	public static <T> List<T> dtoToEntityList(List<?> source,Class<T> clazz){
		List<T> list = new ArrayList<>();
		try {
			if (source != null) {
				for (Object sourceObj : source) {
					T t = clazz.newInstance();
					BeanUtils.copyProperties(sourceObj, t);
					list.add(t);
				}
			}
		} catch (Exception e) {
			logger.error(String.format("DTO set conversion entity set error: %s", e.getMessage()));
		}
		return list;
	}
}
