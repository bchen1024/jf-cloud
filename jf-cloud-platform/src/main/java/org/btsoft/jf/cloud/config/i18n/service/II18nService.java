package org.btsoft.jf.cloud.config.i18n.service;

import org.btsoft.jf.cloud.config.i18n.dto.I18nAddDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nDeleteDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nQueryDTO;
import org.btsoft.jf.cloud.config.i18n.dto.I18nUpdateDTO;
import org.btsoft.jf.cloud.config.i18n.vo.I18nVO;
import org.btsoft.jf.cloud.core.base.dto.AppBatchDTO;
import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;

/**
 * 国际化Service接口
 * 
 * @author chenbin
 * @date 2018-12-05 21:07
 */
public interface II18nService {

	/**
	 * 创建单个国际化对象
	 * 
	 * @param t
	 * @return
	 * @autor chenbin
	 * @date 2018-12-05 21:08
	 */
	CommonResult<Integer> createSingle(I18nAddDTO t);

	/**
	 * 查询单个国际化对象
	 * 
	 * @param id
	 * @return
	 * @autor chenbin
	 * @date 2018-12-05 21:08
	 */
	CommonResult<I18nVO> findSingle(Long id);

	/**
	 * 更新单个国际化对象
	 * 
	 * @param t
	 * @return
	 * @autor chenbin
	 * @date 2018-12-05 21:08
	 */
	CommonResult<Integer> updateSingle(I18nUpdateDTO t);

	/**
	 * 删除单个国际化对象
	 * 
	 * @param id
	 * @return
	 * @autor chenbin
	 * @date 2018-12-05 21:08
	 */
	CommonResult<Integer> deleteSingle(Long id);

	/**
	 * 删除多个国际化对象
	 * 
	 * @param t
	 * @return
	 * @autor chenbin
	 * @date 2018-12-05 21:09
	 */
	CommonResult<Integer> deleteMultiple(AppBatchDTO<I18nDeleteDTO> t);

	/**
	 * 分页查询国际化对象
	 * 
	 * @param t
	 * @return
	 * @autor chenbin
	 * @date 2018-12-05 21:09
	 */
	CommonResult<PageResult<I18nVO>> findPageList(I18nQueryDTO t);

}
