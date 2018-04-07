/**
 * 
 */
package org.btsoft.jf.cloud.core.common.constant;

/**
 * @author bchen
 * 请求常量类
 */
public interface Controller {
	
	public interface PATH{
		public final static String 	CREATE="/create";
		public final static String 	SINGLE="/single";
		public final static String 	UPDATE="/update";
		public final static String 	DELETE="/delete";
		public final static String 	BATCH_DELETE="/batch/delete";
		public final static String 	LIST="/list";
		public final static String 	PAGE="/page";
	}
	
	public interface API{
		public final static String 	CREATE="创建单个对象";
		public final static String 	SINGLE="获取单个对象";
		public final static String 	UPDATE="更新单个对象";
		public final static String 	DELETE="删除单个对象";
		public final static String 	BATCH_DELETE="删除多个对象";
		public final static String 	LIST="获取对象列表";
		public final static String 	PAGE="分页获取对象列表";
	}
}
