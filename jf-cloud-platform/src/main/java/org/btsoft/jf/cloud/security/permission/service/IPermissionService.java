package org.btsoft.jf.cloud.security.permission.service;

import java.util.List;
import java.util.Map;

import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.security.permission.dto.PermissionAddDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionDeleteDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionQueryDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionSyncDTO;
import org.btsoft.jf.cloud.security.permission.dto.PermissionUpdateDTO;
import org.btsoft.jf.cloud.security.permission.vo.PermissionVO;

/**
 * @ClassName IPermissionService
 * @Description 权限点Service接口
 * @author bchen
 * @created 2018-4-8 23:34:48
 */
public interface IPermissionService {

	CommonResult<Integer> createSingle(PermissionAddDTO dto);

	CommonResult<PermissionVO> findSingle(Long id);

	CommonResult<Integer> updateSingle(PermissionUpdateDTO dto);

	CommonResult<Integer> deleteSingle(Long id);

	CommonResult<Integer> deleteMultiple(List<PermissionDeleteDTO> dto);

	CommonResult<PageResult<PermissionVO>> findPageList(PermissionQueryDTO dto);

	CommonResult<Integer> sysnPermission(PermissionSyncDTO dto);
	
	CommonResult<List<Map<String, Object>>> findPermissionTree(PermissionQueryDTO dto);

}
