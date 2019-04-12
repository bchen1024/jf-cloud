package org.btsoft.jf.cloud.security.app.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.BatchEntity;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.app.dto.AppAddDTO;
import org.btsoft.jf.cloud.security.app.dto.AppDeleteDTO;
import org.btsoft.jf.cloud.security.app.dto.AppQueryDTO;
import org.btsoft.jf.cloud.security.app.dto.AppUpdateDTO;
import org.btsoft.jf.cloud.security.app.entity.App;
import org.btsoft.jf.cloud.security.app.mapper.IAppMapper;
import org.btsoft.jf.cloud.security.app.service.IAppService;
import org.btsoft.jf.cloud.security.app.vo.AppVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**
 * 应用管理Service实现类
 * @author chenbin
 * @date 2018-12-07 19:28
 */
@Service
public class AppServiceImpl implements IAppService {

	@Autowired
	private IAppMapper mapper;

	@Override
	public CommonResult<Integer> createSingle(AppAddDTO dto) {
		App entity = EntityUtils.copyProperties(dto, App.class);
		int count = mapper.createSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<AppVO> findSingle(Long id) {
		App entity = new App();
		entity.setAppId(id);
		entity = mapper.findSingle(entity);
		AppVO vo = EntityUtils.copyProperties(entity  , AppVO.class);
		return CommonResultUtils.success(vo);
	}

	@Override
	public CommonResult<Integer> updateSingle(AppUpdateDTO dto) {
		App entity = EntityUtils.copyProperties(dto, App.class);
		int count = mapper.updateSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteSingle(Long id) {
		App entity = new App();
		entity.setAppId(id);
		int count = mapper.deleteSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteMultiple(AppBatchDTO<AppDeleteDTO> dto) {
		List<AppDeleteDTO> list=dto.getList();
		if (!CollectionUtils.isEmpty(list)) {
			List<App> appList = EntityUtils.dtoToEntityList(list, App.class);
			BatchEntity<App> batch = new BatchEntity<App>();
			batch.setList(appList);
			int count = mapper.deleteMultiple(batch);
			return CommonResultUtils.success(count);
		}
		return CommonResultUtils.success(0);
	}

	@Override
	public CommonResult<PageResult<AppVO>> findPageList(AppQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		App entity = EntityUtils.copyProperties(dto, App.class);
		List<App> result = mapper.findList(entity);
		List<AppVO> list = EntityUtils.dtoToEntityList(result, AppVO.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(list, dto.getCurPage(), dto.getPageSize()));
	}

	@Override
	public CommonResult<Integer> saveSingle(AppUpdateDTO dto) {
		if(dto.getAppId()!=null) {
			return this.updateSingle(dto);
		}
		return this.createSingle(dto);
	}
	
	
}
