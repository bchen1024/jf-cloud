package org.btsoft.jf.cloud.security.role.service.impl;

import java.util.List;

import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.BatchEntity;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.util.CommonResultUtils;
import org.btsoft.jf.cloud.core.util.EntityUtils;
import org.btsoft.jf.cloud.core.util.PageResultUtils;
import org.btsoft.jf.cloud.security.role.dto.RoleAddDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleDeleteDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleQueryDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleUpdateDTO;
import org.btsoft.jf.cloud.security.role.entity.Role;
import org.btsoft.jf.cloud.security.role.mapper.IRoleMapper;
import org.btsoft.jf.cloud.security.role.service.IRoleService;
import org.btsoft.jf.cloud.security.role.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;

/**
 * @ClassName RoleService
 * @Description 角色管理Service实现类
 * @author bchen
 * @created 2018年4月3日 下午7:25:05
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleMapper mapper;

	@Override
	public CommonResult<Integer> createSingle(RoleAddDTO dto) {
		Role entity = EntityUtils.copyProperties(dto, Role.class);
		int count = mapper.createSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<RoleVO> findSingle(Long id) {
		Role entity = new Role();
		entity.setRoleId(id);
		entity = mapper.findSingle(entity);
		RoleVO vo = EntityUtils.copyProperties(entity, RoleVO.class);
		return CommonResultUtils.success(vo);
	}

	@Override
	public CommonResult<Integer> updateSingle(RoleUpdateDTO dto) {
		Role entity = EntityUtils.copyProperties(dto, Role.class);
		int count = mapper.updateSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteSingle(Long id) {
		Role entity = new Role();
		entity.setRoleId(id);
		int count = mapper.deleteSingle(entity);
		return CommonResultUtils.success(count);
	}

	@Override
	public CommonResult<Integer> deleteMultiple(AppBatchDTO<RoleDeleteDTO> dto) {
		List<RoleDeleteDTO> deleteList=dto.getList();
		if (!CollectionUtils.isEmpty(deleteList)) {
			List<Role> list = EntityUtils.dtoToEntityList(deleteList, Role.class);
			BatchEntity<Role> batch = new BatchEntity<Role>();
			batch.setList(list);
			int count = mapper.deleteMultiple(batch);
			return CommonResultUtils.success(count);
		}
		return CommonResultUtils.success(0);
	}

	@Override
	public CommonResult<PageResult<RoleVO>> findPageList(RoleQueryDTO dto) {
		PageHelper.startPage(dto.getCurPage(), dto.getPageSize());
		Role entity = EntityUtils.copyProperties(dto, Role.class);
		List<Role> result = mapper.findList(entity);
		List<RoleVO> list = EntityUtils.dtoToEntityList(result, RoleVO.class);
		return CommonResultUtils.success(PageResultUtils.toPageResult(list, dto.getCurPage(), dto.getPageSize()));
	}
}
