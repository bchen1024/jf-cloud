package org.btsoft.jf.cloud.config.lookup.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.config.lookup.dto.LookupAddDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupDeleteDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupQueryDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupUpdateDTO;
import org.btsoft.jf.cloud.config.lookup.entity.Lookup;
import org.btsoft.jf.cloud.config.lookup.mapper.ILookupMapper;
import org.btsoft.jf.cloud.config.lookup.service.ILookupService;
import org.btsoft.jf.cloud.config.lookup.vo.LookupVO;
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
 * Lookup Service实现类
 * 
 * @author chenbin
 * @date 2018-12-07 19:30
 */
@Service
public class LookupServiceImpl implements ILookupService {

	@Autowired
	private ILookupMapper mapper;

	@Override
	public CommonResult<Integer> createSingle(LookupAddDTO dto) {
		Lookup entity = EntityUtils.copyProperties(dto, Lookup.class);
		int count = mapper.createSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<LookupVO> findSingle(Long id) {
		Lookup entity = new Lookup();
		entity.setCodeId(id);
		entity = mapper.findSingle(entity);
		LookupVO vo = EntityUtils.copyProperties(entity, LookupVO.class);
		return CommonResultUtils.success(vo);
	}

	@Override
	public CommonResult<Integer> updateSingle(LookupUpdateDTO dto) {
		Lookup entity = EntityUtils.copyProperties(dto, Lookup.class);
		int count = mapper.updateSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteSingle(Long id) {
		Lookup entity = new Lookup();
		entity.setCodeId(id);
		int count = mapper.deleteSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteMultiple(AppBatchDTO<LookupDeleteDTO> dto) {
		List<LookupDeleteDTO> deleteList=dto.getList();
		if (!CollectionUtils.isEmpty(deleteList)) {
			List<Lookup> list = EntityUtils.dtoToEntityList(deleteList, Lookup.class);
			BatchEntity<Lookup> batch = new BatchEntity<Lookup>();
			batch.setList(list);
			int count = mapper.deleteMultiple(batch);
			return CommonResultUtils.success(count);
		}
		return CommonResultUtils.success(0);
	}

	@Override
	public CommonResult<PageResult<LookupVO>> findPageList(LookupQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		Lookup entity = EntityUtils.copyProperties(dto, Lookup.class);
		List<Lookup> result = mapper.findList(entity);
		List<LookupVO> list = EntityUtils.dtoToEntityList(result, LookupVO.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(list, dto.getCurPage(), dto.getPageSize()));
	}

}
