
package org.btsoft.jf.cloud.config.lookup.service;

import org.btsoft.jf.cloud.config.lookup.dto.LookupAddDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupDeleteDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupQueryDTO;
import org.btsoft.jf.cloud.config.lookup.dto.LookupUpdateDTO;
import org.btsoft.jf.cloud.config.lookup.vo.LookupVO;
import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;

/**
 * lookup service接口
 * 
 * @author chenbin
 * @date 2018-12-05 23:22
 */
public interface ILookupService {

	CommonResult<Integer> createSingle(LookupAddDTO dto);

	CommonResult<LookupVO> findSingle(Long id);

	CommonResult<Integer> updateSingle(LookupUpdateDTO dto);

	CommonResult<Integer> deleteSingle(Long id);

	CommonResult<Integer> deleteMultiple(AppBatchDTO<LookupDeleteDTO> dto);

	CommonResult<PageResult<LookupVO>> findPageList(LookupQueryDTO dto);

}
