package org.btsoft.jf.cloud.config.property.service;

import org.btsoft.jf.cloud.config.property.dto.PropertyAddDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyDeleteDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyQueryDTO;
import org.btsoft.jf.cloud.config.property.dto.PropertyUpdateDTO;
import org.btsoft.jf.cloud.config.property.vo.PropertyVO;
import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;

/**
 * 数据字典Service接口
 * 
 * @author chenbin
 * @date 2018-12-05 22:34
 */
public interface IPropertyService {

	CommonResult<Integer> createSingle(PropertyAddDTO dto);

	CommonResult<PropertyVO> findSingle(Long id);

	CommonResult<Integer> updateSingle(PropertyUpdateDTO dto);

	CommonResult<Integer> deleteSingle(Long id);

	CommonResult<Integer> deleteMultiple(AppBatchDTO<PropertyDeleteDTO> dto);

	CommonResult<PageResult<PropertyVO>> findPageList(PropertyQueryDTO dto);

}
