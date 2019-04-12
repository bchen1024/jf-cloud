package org.btsoft.jf.cloud.config.property.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.config.property.dto.PropertyAddDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyDeleteDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyQueryDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyUpdateDTO;
import org.btsoft.jf.cloud.config.property.entity.Property;
import org.btsoft.jf.cloud.config.property.mapper.IPropertyMapper;
import org.btsoft.jf.cloud.config.property.service.IPropertyService;
import org.btsoft.jf.cloud.config.property.vo.PropertyVO;
import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.BatchEntity;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**
 * 数据字典Service实现类
 * @author chenbin
 * @date 2018-12-07 19:30
 */
@Service
public class PropertyServiceImpl implements IPropertyService {

	@Autowired
	private IPropertyMapper mapper;

	@Override
	public CommonResult<Integer> createSingle(PropertyAddDTO dto) {
		Property entity = EntityUtils.copyProperties(dto, Property.class);
		int count = mapper.createSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<PropertyVO> findSingle(Long id) {
		Property entity = new Property();
		entity.setPropertyId(id);
		entity = mapper.findSingle(entity);
		PropertyVO vo = EntityUtils.copyProperties(entity, PropertyVO.class);
		return CommonResultUtils.success(vo);
	}

	@Override
	public CommonResult<Integer> updateSingle(PropertyUpdateDTO dto) {
		Property entity = EntityUtils.copyProperties(dto, Property.class);
		int count = mapper.updateSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteSingle(Long id) {
		Property entity = new Property();
		entity.setPropertyId(id);
		int count = mapper.deleteSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteMultiple(AppBatchDTO<PropertyDeleteDTO> dto) {
		List<PropertyDeleteDTO> deleteList=dto.getList();
		if (!CollectionUtils.isEmpty(deleteList)) {
			List<Property> list = EntityUtils.dtoToEntityList(deleteList, Property.class);
			BatchEntity<Property> batch = new BatchEntity<Property>();
			batch.setList(list);
			int count = mapper.deleteMultiple(batch);
			return CommonResultUtils.success(count);
		}
		return CommonResultUtils.success(0);
	}

	@Override
	public CommonResult<PageResult<PropertyVO>> findPageList(PropertyQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		Property entity = EntityUtils.copyProperties(dto, Property.class);
		List<Property> result = mapper.findList(entity);
		List<PropertyVO> list = EntityUtils.dtoToEntityList(result, PropertyVO.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(list, dto.getCurPage(), dto.getPageSize()));
	}

}
