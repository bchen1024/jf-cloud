package org.btsoft.jf.cloud.security.group.service;

import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.security.group.dto.GroupAddDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupDeleteDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupQueryDTO;
import org.btsoft.jf.cloud.security.group.dto.GroupUpdateDTO;
import org.btsoft.jf.cloud.security.group.vo.GroupVO;

/**
 * @ClassName IGroupService
 * @Description 群组管理Service接口
 * @author bchen
 * @created 2018年4月5日 下午5:48:43
 */
public interface IGroupService {

	CommonResult<Integer> createSingle(GroupAddDTO dto);

	CommonResult<GroupVO> findSingle(Long id);

	CommonResult<Integer> updateSingle(GroupUpdateDTO dto);

	CommonResult<Integer> deleteSingle(Long id);

	CommonResult<Integer> deleteMultiple(AppBatchDTO<GroupDeleteDTO> dto);

	CommonResult<PageResult<GroupVO>> findPageList(GroupQueryDTO dto);
}
