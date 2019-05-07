package org.btsoft.jf.cloud.security.permission.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.btsoft.jf.cloud.core.base.dto.AppDTO;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author chenbin
 * @date 2018年6月9日 上午9:13:31
 */
public class PermissionAddDTO extends AppDTO {

	private static final long serialVersionUID = -1359927873073984514L;

	
	/**
	 * 权限code
	 */
	@NotBlank
	private String permissionCode;

	/**
	 * 权限点中文描述
	 */
	@NotBlank
	private String permissionDescCN;

	/**
	 * 权限点英文描述
	 */
	@NotBlank
	private String permissionDescEN;

	/**
	 * 权限点类型：resources：资源;method：方法
	 */
	@NotBlank
	private String permissionType;

	/**
	 * 权限来源，custom:自定义手动添加；annotation:注解扫描
	 */
	@NotBlank
	private String permissionSource;

	/**
	 * 父编码
	 */
	private String parentCode;

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionDescCN() {
		return permissionDescCN;
	}

	public void setPermissionDescCN(String permissionDescCN) {
		this.permissionDescCN = permissionDescCN;
	}

	public String getPermissionDescEN() {
		return permissionDescEN;
	}

	public void setPermissionDescEN(String permissionDescEN) {
		this.permissionDescEN = permissionDescEN;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public String getPermissionSource() {
		return permissionSource;
	}

	public void setPermissionSource(String permissionSource) {
		this.permissionSource = permissionSource;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
