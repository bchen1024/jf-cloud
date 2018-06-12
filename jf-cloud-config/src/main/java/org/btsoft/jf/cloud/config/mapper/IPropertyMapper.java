/**
 * 
 */
package org.btsoft.jf.cloud.config.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.btsoft.jf.cloud.config.entity.Property;
import org.btsoft.jf.cloud.core.base.mapper.IBaseCRUDMapper;

/**
 * @author bchen
 *
 */
@Mapper
public interface IPropertyMapper extends IBaseCRUDMapper<Property> {

}
