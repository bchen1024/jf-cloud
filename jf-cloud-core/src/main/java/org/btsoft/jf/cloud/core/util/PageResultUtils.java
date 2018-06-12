package org.btsoft.jf.cloud.core.util;

import java.util.ArrayList;
import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.PageDTO;
import org.btsoft.jf.cloud.core.base.result.PageResult;
import org.btsoft.jf.cloud.core.base.vo.PageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @author chenbin
 * @date 2018年6月8日 下午10:43:28
 */
public class PageResultUtils {
	
	private final static Logger logger=LoggerFactory.getLogger(PageResultUtils.class);

	public static <T> PageResult<T> toPageResult(List<T> list,PageDTO pageDTO){
		PageVO pageVO=new PageVO();
		BeanUtils.copyProperties(pageDTO, pageVO);
		PageInfo<T> pageInfo=new PageInfo<>(list);
		pageVO.setTotalRows(pageInfo.getTotal());
		PageResult<T> result=new PageResult<>(list, pageVO);
		return result;
	}
	
	public static <T> PageResult<T> entityToVO(Class<T> clazz,PageResult<?> source){
		PageResult<T> result=new PageResult<>();
		List<T> list=new ArrayList<T>();
		if(source!=null && source.getResult()!=null && !source.getResult().isEmpty()){
			try {
				for (Object sourceObj : source.getResult()) {
					T t=clazz.newInstance();
					BeanUtils.copyProperties(sourceObj, t);
					list.add(t);
				}
			} catch (Exception e) {
				logger.error(String.format("DTO object conversion entity object error: %s", e.getMessage()));
			}
		}
		result.setResult(list);
		result.setPageVO(source.getPageVO());
		return result;
	}
}
