package com.inter.base;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;

import com.inter.enums.AuthenticationEnum;
import com.inter.exception.CustomException;
import com.inter.exception.ReturnViewException;
import com.inter.pojo.system.User;

import cn.hutool.core.util.EnumUtil;


public class BaseController {

	private static User user;

	public synchronized static User getCurrentUser() {
		
		user = (User) SecurityUtils.getSubject().getPrincipal();
		
		return user;
	}
	
	public static Object getEnumByKey(String key) {
		Map<String, Object> enumMap = EnumUtil.getNameFieldMap(AuthenticationEnum.class, "type");
		Object object = enumMap.get(key);
		return object;
	}
	
	public static boolean checkPermission(String authenticationValue) throws CustomException {
		
		boolean result = true;
		
		if(StringUtils.isBlank(authenticationValue)) throw new CustomException("权限值为空");
		
		boolean permitted = SecurityUtils.getSubject().isPermitted(getEnumByKey(authenticationValue).toString());
		
		if(permitted == false) result = false;
		
		return result;
	}
	
	public static void checkPermissionToMessage(String authenticationValue) throws CustomException {
		if(checkPermission(authenticationValue) == false) {
			throw new CustomException("权限不足");
		}
	}
	
	public static void checkPermissionToView(String authenticationValue) throws ReturnViewException, CustomException{
		if(checkPermission(authenticationValue) == false) {
			throw new ReturnViewException("no_permission"); //权限不足页面
		}
	}

	
}
