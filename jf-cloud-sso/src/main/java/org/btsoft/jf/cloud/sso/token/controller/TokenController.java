package org.btsoft.jf.cloud.sso.token.controller;

import java.util.List;

import org.btsoft.jf.cloud.core.base.entity.CommonResult;
import org.btsoft.jf.cloud.core.base.entity.PageResult;
import org.btsoft.jf.cloud.core.constants.ControllerContants;
import org.btsoft.jf.cloud.sso.token.dto.TokenQueryDTO;
import org.btsoft.jf.cloud.sso.token.service.ITokenService;
import org.btsoft.jf.cloud.sso.token.vo.TokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * token管理Controller
 * @author chenbin
 * @date 2018-11-28 22:06
 */
@RestController
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	private ITokenService service;
	
	/**
	 * @desc 分页获取用户令牌列表
	 * @param dto 查询条件DTO对象
	 * @return 用户令牌分页对象
	 * @autor chenbin
	 * @date 2018年10月19日 上午12:00:45
	 */
	@PostMapping(ControllerContants.Path.PAGE)
	public CommonResult<PageResult<TokenVO>> findPageList(@RequestBody TokenQueryDTO dto){
		return service.findPageList(dto);
	}
	
	public CommonResult<Integer> deleteTokens(List<String> list){
		return null;
	}
}
