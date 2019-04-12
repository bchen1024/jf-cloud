package org.btsoft.jf.cloud.security.app.service;

import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.security.app.dto.AppAddDTO;
import org.btsoft.jf.cloud.security.app.dto.AppDeleteDTO;
import org.btsoft.jf.cloud.security.app.dto.AppQueryDTO;
import org.btsoft.jf.cloud.security.app.dto.AppUpdateDTO;
import org.btsoft.jf.cloud.security.app.vo.AppVO;

/**
 * 应用管理Service接口
 * 
 * @author chenbin
 * @date 2018-12-07 19:29
 */
public interface IAppService {

	CommonResult<Integer> createSingle(AppAddDTO dto);

	CommonResult<AppVO> findSingle(Long id);

	CommonResult<Integer> updateSingle(AppUpdateDTO dto);

	CommonResult<Integer> deleteSingle(Long id);

	CommonResult<Integer> deleteMultiple(AppBatchDTO<AppDeleteDTO> dto);

	CommonResult<PageResult<AppVO>> findPageList(AppQueryDTO dto);
	
	CommonResult<Integer> saveSingle(AppUpdateDTO dto);

}
