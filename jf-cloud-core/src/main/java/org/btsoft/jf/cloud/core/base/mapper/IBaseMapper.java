package org.btsoft.jf.cloud.core.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
/**
 * 
 * @desc 基类Mapper对象
 * @author chenbin
 * @date 2018-10-14 11:08:23
 */
public interface IBaseMapper<T> extends IBaseBatchMapper<T>{

	/**
	 * 插入单个对象
	 * @param t 插入对象
	 * @return 返回受影响行数
	 */
	int createSingle(@Param("vo") T t);

	/**
	 * 查询单个对象
	 * @param t 查询条件对象
	 * @return 返回单个对象
	 */
	T findSingle(@Param("vo") T t);

	/**
	 * 更新单个对象
	 * @param t 更新对象
	 * @return 返回受影响行数
	 */
	int updateSingle(@Param("vo") T t);

	/**
	 * 更新对象某个字段
	 * @param t 更新对象
	 * @return 返回受影响行数
	 */
	int patchSingle(@Param("vo") T t);

	/**
	 * 删除单个对象
	 * @param t 删除对象
	 * @return 返回受影响行数
	 */
	int deleteSingle(@Param("vo") T t);
	
	/**
	 * 查询对象列表
	 * @param t 查询参数对象
	 * @return 返回对象列表
	 */
	List<T> findList(@Param("vo") T t);

}
