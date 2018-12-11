package com.inter.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inter.annotation.Log;
import com.inter.base.BaseController;
import com.inter.exception.CustomException;
import com.inter.exception.ReturnViewException;
import com.inter.pojo.system.User;
import com.inter.service.system.UserService;
import com.inter.utils.PageHelper;
import com.inter.vo.UserStudentVo;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/s/view.do")
	@Log(operationType="系统管理",operationName="用户管理页面",operationSource="教师端")
	public String initUserListView() throws ReturnViewException, CustomException {
		checkPermissionToView("USER_VIEW");
		return "system/user/user_list";
	}
	
	@RequestMapping("/check/name.do")
	@ResponseBody
	public Map<String,Object> checkName(String username){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(username == null || username == ""){
			map.put("code", 5000);
			map.put("message", "传参异常");
			return map;
		}
		
		
		if(!username.startsWith("bdqn")) {
			map.put("code", 5000);
			map.put("message", "用户名请以bdqn开头");
			return map;
		}
		
		User user = userService.findUserByUsername(username);
		
		if(user != null) {
			map.put("code", 5000);
			map.put("message", "该用户名已存在");
			return map;
		}
		
		return map;
		
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	//@Log(operationName="加载用户列表",operationType="用户管理")
	public PageHelper<User> getUserListByPage(String userName,Integer offset, Integer limit)throws CustomException{
		checkPermissionToMessage("USER_LIST");
		return userService.getUserListByPage(userName,offset,limit);
	}
	
	
	@RequestMapping("/show/addentity.do")
	public String showAddUserView(Model model,Integer userId)throws CustomException, ReturnViewException {
		if(userId != null) {
			checkPermissionToView("USER_EDIT");
			User user = userService.selectByPrimaryKey(userId);
			model.addAttribute("dataUser",user);
		}
		checkPermissionToView("USER_SAVE");
		return "system/user/user_add";
	}
	
	@RequestMapping("add/entity.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="新增用户",operationSource="教师端")
	public Map<String,Object> saveOrUpdateUser(String[] roleIds,User user)throws CustomException{
		
		if(user.getId() == null) {
			checkPermissionToMessage("USER_SAVE");
		}else {
			checkPermissionToMessage("USER_EDIT");
		}
		
		return userService.saveOrUpdateUser(roleIds,user);
	}
	
	@RequestMapping("/opt/entity.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="启禁用户",operationSource="教师端")
	public Map<String,Object> optUser(Integer userId)throws CustomException{
		checkPermissionToMessage("USER_OPT");
		return userService.optUser(userId);
	}
	
	@RequestMapping("/del/entity.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="删除用户",operationSource="教师端")
	public Map<String,Object> delUser(Integer userId)throws CustomException{
		checkPermissionToMessage("USER_DEL");
		return userService.delUser(userId);
	}
	
	
	@RequestMapping("/add/student.do")
	@ResponseBody
	@Log(operationType="系统管理",operationName="新增学生",operationSource="教师端")
	public Map<String,Object> saveUser4Student(String[] roleIds,UserStudentVo vo)throws CustomException{
		return userService.saveUser4Student(roleIds,vo);
	}
	
	@RequestMapping("/get/checkUser.do")
	@ResponseBody
	public Map<String,Object> checkNickNameAndTelephoneA(String nickName,String telephoneA)throws CustomException{
		return userService.checkNickNameAndTelephoneA(nickName,telephoneA);
	}
	
	/**
	 * 
	* @Title: getUser1
	* @Description:  加载网咨集合
	* @author 石家庄北大青鸟Y2教员 韩志彬   
	* @date 2018年11月25日 下午9:46:22 
	* @return
	 * @throws CustomException 
	 */
	@RequestMapping("/get/user1.do")
	@ResponseBody
	public List<User> getUser1() throws CustomException{
		return userService.getTeachListByIdentity("11");//11是网咨
	}
	
	@RequestMapping("/get/user2.do")
	@ResponseBody
	public List<User> getUser2() throws CustomException{
		return userService.getTeachListByIdentity("12");//12是助理
	}
	
	@RequestMapping("/get/user3.do")
	@ResponseBody
	public List<User> getUser3() throws CustomException{
		return userService.getTeachListByIdentity("13");//13是咨询
	}
	
	//锁屏 根据用户获得登录密码
	@RequestMapping("get/unlock.do")
	@ResponseBody
	public Map<String,Object> userUnlock(String pwd) throws CustomException{
		return userService.userUnlock(pwd);
	}
}
