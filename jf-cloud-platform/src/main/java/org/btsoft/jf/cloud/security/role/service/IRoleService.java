package org.btsoft.jf.cloud.security.role.service;

import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.security.role.dto.RoleAddDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleDeleteDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleQueryDTO;
import org.btsoft.jf.cloud.security.role.dto.RoleUpdateDTO;
import org.btsoft.jf.cloud.security.role.vo.RoleVO;

/**
 * @ClassName IRoleService
 * @Description 角色管理Service
 * @author bchen
 * @created 2018年4月3日 下午7:22:55
 */
public interface IRoleService {

	/**
	 * 创建单个角色
	 * 
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018-12-07 19:31
	 */
	CommonResult<Integer> createSingle(RoleAddDTO dto);

	/**
	 * 根据角色id获取单个角色
	 * 
	 * @param id
	 * @return
	 * @autor chenbin
	 * @date 2018-12-07 19:31
	 */
	CommonResult<RoleVO> findSingle(Long id);

	/**
	 * 更新单个角色
	 * 
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018-12-07 19:31
	 */
	CommonResult<Integer> updateSingle(RoleUpdateDTO dto);

	/**
	 * 删除单个角色
	 * 
	 * @param id
	 * @return
	 * @autor chenbin
	 * @date 2018-12-07 19:31
	 */
	CommonResult<Integer> deleteSingle(Long id);

	/**
	 * 删除多个角色
	 * 
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018-12-07 19:32
	 */
	CommonResult<Integer> deleteMultiple(AppBatchDTO<RoleDeleteDTO> dto);

	/**
	 * 分页查询角色列表
	 * 
	 * @param dto
	 * @return
	 * @autor chenbin
	 * @date 2018-12-07 19:32
	 */
	CommonResult<PageResult<RoleVO>> findPageList(RoleQueryDTO dto);

}
