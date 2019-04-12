package org.btsoft.jf.cloud.config.i18n.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.config.i18n.dto.I18nAddDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nDeleteDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nQueryDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nUpdateDTO;
import org.btsoft.jf.cloud.config.i18n.entity.I18n;
import org.btsoft.jf.cloud.config.i18n.mapper.II18nMapper;
import org.btsoft.jf.cloud.config.i18n.service.II18nService;
import org.btsoft.jf.cloud.config.i18n.vo.I18nVO;
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
 * 国际化service实现类
 * @author chenbin
 * @date 2018-12-07 19:15
 */
@Service
public class I18nServiceImpl implements II18nService {

	@Autowired
	private II18nMapper mapper;

	@Override
	public CommonResult<Integer> createSingle(I18nAddDTO dto) {
		I18n entity = EntityUtils.copyProperties(dto, I18n.class);
		int count = mapper.createSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<I18nVO> findSingle(Long id) {
		I18n entity = new I18n();
		entity.setI18nId(id);
		entity = mapper.findSingle(entity);
		I18nVO vo = EntityUtils.copyProperties(entity  , I18nVO.class);
		return CommonResultUtils.success(vo);
	}

	@Override
	public CommonResult<Integer> updateSingle(I18nUpdateDTO dto) {
		I18n entity = EntityUtils.copyProperties(dto, I18n.class);
		int count = mapper.updateSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteSingle(Long id) {
		I18n entity = new I18n();
		entity.setI18nId(id);
		int count = mapper.deleteSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteMultiple(AppBatchDTO<I18nDeleteDTO> dto) {
		List<I18nDeleteDTO> deleteList=dto.getList(); 
		if (!CollectionUtils.isEmpty(deleteList)) {
			List<I18n> list = EntityUtils.dtoToEntityList(deleteList, I18n.class);
			BatchEntity<I18n> batch = new BatchEntity<I18n>();
			batch.setList(list);
			int count = mapper.deleteMultiple(batch);
			return CommonResultUtils.success(count);
		}
		return CommonResultUtils.success(0);
	}

	@Override
	public CommonResult<PageResult<I18nVO>> findPageList(I18nQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		I18n i18n = EntityUtils.copyProperties(dto, I18n.class);
		List<I18n> result = mapper.findList(i18n);
		List<I18nVO> list = EntityUtils.dtoToEntityList(result, I18nVO.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(list, dto.getCurPage(), dto.getPageSize()));
	}
}
