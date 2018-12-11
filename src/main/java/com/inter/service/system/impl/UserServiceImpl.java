package com.inter.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.school.ClassesMapper;
import com.inter.mapper.school.StudentMapper;
import com.inter.mapper.system.RoleMapper;
import com.inter.mapper.system.UserAndRoleMapper;
import com.inter.mapper.system.UserMapper;
import com.inter.pojo.school.Classes;
import com.inter.pojo.school.Student;
import com.inter.pojo.system.Role;
import com.inter.pojo.system.User;
import com.inter.pojo.system.UserAndRoleKey;
import com.inter.service.system.UserService;
import com.inter.utils.PageHelper;
import com.inter.vo.UserStudentVo;

@Service
@Transactional
public class UserServiceImpl extends BaseService implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserAndRoleMapper userAndRoleMapper;
	
	@Autowired
	private ClassesMapper classesMapper;

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public User findUserByUsername(String username){
		return userMapper.findUserByUsername(username);
	}

	@Override
	public PageHelper<User> getUserListByPage(String userName,Integer offset, Integer limit) throws CustomException{
		
		PageHelper<User> pageHelper = new PageHelper<User>();
		
		Integer total = userMapper.getCount(userName);
		
		List<User> list = userMapper.getUserListByPage(userName, offset,  limit);
		
		pageHelper.setTotal(total);
		pageHelper.setRows(list);
		
		return pageHelper;
	}


	@Override
	public User selectByPrimaryKey(Integer userId) throws CustomException{
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public Map<String, Object> saveOrUpdateUser(String[] roleIds, User user) throws CustomException{
			
		User currentUser = (User) SecurityUtils.getSubject().getPrincipal();

		
		if(user.getId() == null) {
			//插入数据到用户表
			user.setCreateTime(new Date());
			user.setCreateUser(currentUser.getNickName());
			user.setModifyTime(new Date());
			user.setModifyUser(currentUser.getNickName());
			user.setStatus(STRING_NUMBER_ONE);
			user.setProhibition(STRING_NUMBER_ONE);
			user.setIsTemp(STRING_NUMBER_ONE);
			userMapper.saveUserAndBackPrimaryKey(user);
			
			Integer userId = user.getId();
			
			//此时,用户信息是新数据,所以在用户和角色表中,并没有存入相应数据 所以直接插入新数据到用户角色表即可
			for (String roleIdStr : roleIds) {
				if(roleIdStr != null) {
					Integer roleId = Integer.parseInt(roleIdStr);
					UserAndRoleKey key = new UserAndRoleKey();
					key.setRoleId(roleId);
					key.setUserId(userId);
					userAndRoleMapper.insert(key);
				}
			}
			return createMessageMap(SAVE, SUCCESS);
		}else { //修改操作
			user.setModifyTime(new Date());
			user.setModifyUser(currentUser.getNickName());
			userMapper.updateByPrimaryKeySelective(user);
			
			/*
			 *  因为我们不知道前台用户是否更改了角色信息,所以我们在修改的时候
			 *	先删除当前账号的中间表数据
			 *	再添加当前账号的中间表数据
			 */
			System.err.println(user.getId());
			userAndRoleMapper.deleteByUserId(user.getId());
			//遍历角色id数组
			for (String roleIdStr : roleIds) {
				if(roleIdStr != null) {
					Integer roleId = Integer.parseInt(roleIdStr);

					
					UserAndRoleKey key = new UserAndRoleKey();
					key.setRoleId(roleId);
					key.setUserId(user.getId());
					userAndRoleMapper.insert(key);
				}
			}
			return createMessageMap(EDIT, SUCCESS);
		}
	}
	
	
	@Override
	public Map<String, Object> optUser(Integer userId) throws CustomException{
		
		User currUser = (User) SecurityUtils.getSubject().getPrincipal();
		
		User user = userMapper.selectByPrimaryKey(userId);
		
		if(user == null) return createMessageMap(QUERY, ERROR);
		
		String prohibition = user.getProhibition();
		
		if(StringUtils.isBlank(prohibition)) return createMessageMap(QUERY, ERROR);

		if(prohibition.equals(STRING_NUMBER_ONE)) user.setProhibition(STRING_NUMBER_ZERO); 
		
		if(prohibition.equals(STRING_NUMBER_ZERO)) user.setProhibition(STRING_NUMBER_ONE); 
		
		user.setModifyTime(new Date());
		
		user.setModifyUser(currUser.getNickName());
		
		if(userMapper.updateByPrimaryKeySelective(user) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else return createMessageMap(EDIT, ERROR);
	}

	@Override
	public Map<String, Object> delUser(Integer userId) throws CustomException{
		
		User currUser = (User) SecurityUtils.getSubject().getPrincipal();
		
		User user = userMapper.selectByPrimaryKey(userId);
		
		if(user == null) return createMessageMap(QUERY, ERROR);
		
		user.setModifyTime(new Date());
		
		user.setModifyUser(currUser.getNickName());
		
		user.setProhibition(STRING_NUMBER_ZERO);
		
		user.setStatus(STRING_NUMBER_ZERO);
		
		if(userMapper.updateByPrimaryKeySelective(user) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(DEL, SUCCESS);
		
		else return createMessageMap(DEL, ERROR);
	}

	@Override
	public List<User> getTeachListByIdentity(String identity) throws CustomException{
		return userMapper.getTeachListByIdentity(identity);
	}

	@Override
	public PageHelper<User> getTeacherListByPage(Integer offset, Integer limit)throws CustomException {

		PageHelper<User> pageHelper = new PageHelper<User>();
		
		Integer total = userMapper.getTeacherCount(null,null,null,null,IDENTITY_STUDENT);
		
		List<User> list = userMapper.getTeacherListByPage(null,null,null,null,IDENTITY_STUDENT,offset,limit);
	
		
		
		//查询用户所管班级
		for (User teacher : list) {
			List<String> classesNameList = new ArrayList<String>();
			List<Classes> classesList = classesMapper.getClassesListByTeacherId(teacher.getId());
			for (Classes classes : classesList) {
				classesNameList.add(classes.getClassName());
			}
			
			String classesNames = StringUtils.join(classesNameList,",");
			teacher.setClassesNames(classesNames);
		} 
		
		pageHelper.setTotal(total);
		pageHelper.setRows(list);
		
		return pageHelper;
	}

	@Override
	public Map<String, Object> saveUser4Student(String[] roleIds,UserStudentVo vo) throws CustomException{

		try {
			User currUser = (User) SecurityUtils.getSubject().getPrincipal();
			
			if(vo != null && vo.getId() == null) {
				User user = new User();
				user.setCreateTime(new Date());
				user.setCreateUser(currUser.getNickName());
				user.setIsTemp(vo.getIsTemp());
				user.setStatus(STRING_NUMBER_ONE);
				user.setProhibition(STRING_NUMBER_ONE);
				user.setModifyTime(new Date());
				user.setModifyUser(currUser.getNickName());
				user.setAddress(vo.getAddress());
				user.setBirthday(vo.getBirthday());
				user.setCord(vo.getCord());
				user.setDescription(vo.getDescription());
				user.setEmail(vo.getEmail());
				user.setIdentity(vo.getIdentity());
				user.setLevel(vo.getLevel());
				user.setNickName(vo.getNickName());
				user.setPassword(vo.getPassword());
				user.setSex(vo.getSex());
				user.setTelephoneA(vo.getTelephoneA());
				user.setTelephoneB(vo.getTelephoneB());
				user.setUsername(vo.getUsername());
				userMapper.saveUserAndBackPrimaryKey(user);
				
				Integer userId = user.getId();
				
				Student student = new Student();
				student.setChannelId(vo.getChannelId());
				student.setAge(vo.getAge());
				student.setClassesId(vo.getClassesId());
				student.setClassificationId(vo.getClassificationId());
				student.setEducationId(vo.getEducationId());
				student.setExamId(null);
				student.setIsOver(STRING_NUMBER_ONE);
				student.setMajorId(vo.getMajorId());
				student.setQq(vo.getQq());
				student.setSearchName(vo.getSearchName());
				student.setSourceId(vo.getSourceId());
				student.setSubName(vo.getSubName());
				student.setStiuationId(vo.getStiuationId());
				student.setToolId(vo.getToolId());
				student.setUnqueCode(vo.getUnqueCode());
				student.setUser1(vo.getUser1());
				student.setUser2(vo.getUser2());
				student.setUser3(vo.getUser3());
				student.setUserId(userId);
				studentMapper.insertSelective(student);
				
				for (String roleIdStr : roleIds) {
					if(roleIdStr != null) {
						Integer roleId = Integer.parseInt(roleIdStr);
						UserAndRoleKey key = new UserAndRoleKey();
						key.setRoleId(roleId);
						key.setUserId(userId);
						userAndRoleMapper.insert(key);
					}
				}
				
				
				return createMessageMap(SAVE, SUCCESS);
			}else if(vo != null && vo.getId() != null){
				Integer userId = vo.getId();
				User user = userMapper.selectByPrimaryKey(userId);
				user.setIsTemp(vo.getIsTemp());
				user.setStatus(STRING_NUMBER_ONE);
				user.setProhibition(STRING_NUMBER_ONE);
				user.setModifyTime(new Date());
				user.setModifyUser(currUser.getNickName());
				user.setAddress(vo.getAddress());
				user.setBirthday(vo.getBirthday());
				user.setCord(vo.getCord());
				user.setDescription(vo.getDescription());
				user.setEmail(vo.getEmail());
				user.setIdentity(vo.getIdentity());
				user.setLevel(vo.getLevel());
				user.setNickName(vo.getNickName());
				user.setPassword(vo.getPassword());
				user.setSex(vo.getSex());
				user.setTelephoneA(vo.getTelephoneA());
				user.setTelephoneB(vo.getTelephoneB());
				user.setUsername(vo.getUsername());
				userMapper.updateByPrimaryKeySelective(user);
				
				
				Student student = studentMapper.getStudentByUserId(userId);
				student.setChannelId(vo.getChannelId());
				student.setAge(vo.getAge());
				student.setClassesId(vo.getClassesId());
				student.setClassificationId(vo.getClassificationId());
				student.setEducationId(vo.getEducationId());
				student.setExamId(null);
				student.setIsOver(STRING_NUMBER_ONE);
				student.setMajorId(vo.getMajorId());
				student.setQq(vo.getQq());
				student.setSearchName(vo.getSearchName());
				student.setSourceId(vo.getSourceId());
				student.setSubName(vo.getSubName());
				student.setStiuationId(vo.getStiuationId());
				student.setToolId(vo.getToolId());
				student.setUnqueCode(vo.getUnqueCode());
				student.setUser1(vo.getUser1());
				student.setUser2(vo.getUser2());
				student.setUser3(vo.getUser3());
				student.setUserId(userId);
				studentMapper.updateByPrimaryKeySelective(student);
				
				userAndRoleMapper.deleteByUserId(user.getId());
				//遍历角色id数组
				for (String roleIdStr : roleIds) {
					if(roleIdStr != null) {
						Integer roleId = Integer.parseInt(roleIdStr);

						UserAndRoleKey key = new UserAndRoleKey();
						key.setRoleId(roleId);
						key.setUserId(user.getId());
						userAndRoleMapper.insert(key);
					}
				}
				
				return createMessageMap(EDIT, SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return createExceptionMap();
		}
		
		return null;
		
	}

	@Override
	public Map<String, Object> checkNickNameAndTelephoneA(String nickName, String telephoneA) throws CustomException{
		
		User user = userMapper.checkNickNameAndTelephoneA(nickName,telephoneA);
		
		if(user != null) {
			UserStudentVo usv = new UserStudentVo();
			
			
			
			
			usv.setIdentityName(user.getIdentityName());
			usv.setLevelName(user.getLevelName());
			
			
			
			
			
			usv.setId(user.getId());
			usv.setUsername(user.getUsername());
			usv.setPassword(user.getPassword());
			usv.setNickName(user.getNickName());
			usv.setCord(user.getCord());
			usv.setTelephoneA(user.getTelephoneA());
			usv.setTelephoneB(user.getTelephoneB());
			usv.setEmail(user.getEmail());
			usv.setBirthday(user.getBirthday());
			usv.setIdentity(user.getIdentity());
			usv.setLevel(user.getLevel());
			usv.setProhibition(user.getProhibition());
			usv.setStatus(user.getStatus());
			usv.setCreateUser(user.getCreateUser());
			usv.setCreateTime(user.getCreateTime());
			usv.setModifyTime(user.getModifyTime());
			usv.setModifyUser(user.getModifyUser());
			usv.setDescription(user.getDescription());
			usv.setAddress(user.getAddress());
			usv.setSex(user.getSex());
			usv.setIsTemp(user.getIsTemp());
			
			Student student = studentMapper.getStudentByUserId(user.getId());
			
			usv.setEducationName(student.getEducationName());
			usv.setMajorName(student.getMajorName());
			usv.setStiuationName(student.getSituationName());
			usv.setClassificationName(student.getClassificationName());
			
			
			usv.setAge(student.getAge());
			usv.setQq(student.getQq());
			usv.setSubName(student.getSubName());
			usv.setSearchName(student.getSearchName());
			usv.setUnqueCode(student.getUnqueCode());
			usv.setIsOver(student.getIsOver());
			usv.setClassesId(student.getClassesId());
			usv.setExamId(student.getExamId());
			usv.setEducationId(student.getEducationId());
			usv.setMajorId(student.getMajorId());
			usv.setStiuationId(student.getStiuationId());
			usv.setClassificationId(student.getClassificationId());
			usv.setSourceId(student.getSourceId());
			usv.setToolId(student.getToolId());
			usv.setChannelId(student.getChannelId());
			usv.setUser1(student.getUser1());
			usv.setUser2(student.getUser2());
			usv.setUser3(student.getUser3());
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			List<Role> roleList = roleMapper.getRoleListByUserId(user.getId());
			if(roleList != null) {
				for (Role role : roleList) {
					list.add(role.getId());
				}
			}
			
			String roleIds = StringUtils.join(list,",");
			usv.setRoleIds(roleIds);
			
			return createMessageMap(2000, "用户已存在", usv); 
		}else {
			return createMessageMap(5000, "用户不存在,您可以继续填写");
		}
	}

	@Override
	public Map<String, Object> userUnlock(String pwd) throws CustomException {

		if(isBlank(pwd)) throw new CustomException("传参异常");
		
		User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
		if(isExist(currentUser)) throw new CustomException("shiro异常");
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		
		Object attribute = session.getAttribute("user");
		if(isExist(attribute)) return createMessageMap(5000, "session丢失");
		
		String password = currentUser.getPassword();
		if(isBlank(password)) throw new CustomException("获取用户密码异常");
		
		if(password.equals(pwd)) return createMessageMap(2000, "密码正确");
		else return createMessageMap(2001, "密码错误");
	}
}
