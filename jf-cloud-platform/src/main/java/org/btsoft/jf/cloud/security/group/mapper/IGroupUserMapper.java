package org.btsoft.jf.cloud.security.group.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.core.base.mapper.IBaseBatchMapper;
import org.btsoft.jf.cloud.security.group.entity.GroupUser;

/**
 * @author chenbin
 * @date 2018-12-23 22:33
 */
@Mapper
public interface IGroupUserMapper extends IBaseBatchMapper<GroupUser> {
	
	/**
	 * 获取某个用户拥有的群组
	 * @param groupUser
	 * @return
	 * @autor chenbin
	 * @date 2018-12-23 22:41
	 */
	List<Map<String, Object>> findGroupListByUser(GroupUser groupUser);

}
