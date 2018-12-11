package com.inter.service.system.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.school.ClassesMapper;
import com.inter.mapper.school.StudentMapper;
import com.inter.mapper.system.RoleMapper;
import com.inter.mapper.system.UserAndRoleMapper;
import com.inter.mapper.system.UserMapper;
import com.inter.pojo.school.Student;
import com.inter.pojo.system.Role;
import com.inter.pojo.system.User;
import com.inter.pojo.system.UserAndRoleKey;
import com.inter.service.system.StudentService;
import com.inter.utils.PageHelper;
import com.inter.vo.UserStudentVo;


@Service
@Transactional
public class StudentServiceImpl extends BaseService implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserAndRoleMapper userAndRoleMapper;
	
	@Autowired
	ClassesMapper classesMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public PageHelper<UserStudentVo> getOkOrNoStudentByPage(UserStudentVo userStudentVo,String identity, String isTemp, String userName,String queryDate,Integer user1,Integer user2,Integer user3,Integer offset, Integer limit)throws CustomException, ParseException {
		
		Date startDate = null;
		Date endDate = null;
		if(isNotBlank(queryDate)) {
			String[] date = queryDate.split("~");
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(date[0].trim());
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(date[1].trim());
		}
		
		Integer total = studentMapper.getOkOrNoStudentCount(identity,isTemp,userName,startDate,endDate,user1,user2,user3);
		
		List<UserStudentVo> list =  studentMapper. getOkOrNoStudentByPage(userStudentVo,identity,isTemp,userName,startDate,endDate,user1,user2,user3,offset,limit);
		
		return new PageHelper<UserStudentVo>(total,list);
	}
	
	@Override
	public Map<String, Object> checkNickNameAndTelephoneA(String nickName, String telephoneA) throws CustomException{
	
		if(isBlank(nickName) || isBlank(nickName)) throw new CustomException("传参为空");
		
		User user = userMapper.checkNickNameAndTelephoneA(nickName,telephoneA);
		
		if(isExist(user)) return createBooleanAndMsgMap(false, null);//为空
		
		else return createBooleanAndMsgMap(true, "用户已存在");//不为空
		
	}

	@Override
	public Map<String, Object> checkUsername(String username)  throws CustomException{
		
		if(isBlank(username)) throw new CustomException("传参为空");
		
		User user  = userMapper.checkUsername(username);
		
		if(isExist(user)) return createBooleanAndMsgMap(false, null);//为空
		
		else return createBooleanAndMsgMap(true, "登录账号已存在");//不为空
		
	}

	@Override
	public Map<String, Object> saveOrUpdateStudent(String[] roleIds, UserStudentVo vo) throws CustomException {
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
			
			throw new  CustomException("系统异常,操作失败");
	}

	@Override
	public UserStudentVo getUserByUserId(Integer userId)throws CustomException {
		
		User user = userMapper.selectByPrimaryKey(userId);

		UserStudentVo usv = new UserStudentVo();
		
		if(user != null) {
			
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
		}
		return usv;
	}

	@Override
	public Map<String, Object> editIsTemp(Integer userId) throws CustomException, IllegalArgumentException, IllegalAccessException {
		
		User user = userMapper.selectByPrimaryKey(userId);
		
		Student student = studentMapper.getStudentByUserId(userId);
		
		if(isExist(user)) throw new CustomException("请完善该条记录的所有数据后,再发送给教质部");
		
		if(isExist(student)) throw new CustomException("请完善该条记录的所有数据后,再发送给教质部");
		

		if(isBlank(user.getAddress())||isBlank(user.getCord())||isBlank(user.getDescription())||isBlank(user.getEmail())||
			isBlank(user.getIdentity())||isBlank(user.getIsTemp())||isBlank(user.getLevel())||isBlank(user.getNickName())||
			isBlank(user.getPassword())||isBlank(user.getSex())||isBlank(user.getTelephoneA())||isBlank(user.getUsername())||
			isExist(user.getBirthday())) {
			throw new CustomException("请完善该条记录的所有数据后,再发送给教质部");
		}
		
		if(isBlank(student.getAge())||isBlank(student.getChannelId())||isBlank(student.getClassificationId())||
			isBlank(student.getEducationId())||isBlank(student.getIsOver())||isBlank(student.getMajorId())||
			isBlank(student.getQq())||isBlank(student.getSearchName())||isBlank(student.getSourceId())||
			isBlank(student.getStiuationId())||isBlank(student.getSubName())||isBlank(student.getToolId())||
			isBlank(student.getUnqueCode())||isBlank(student.getUser1())||isBlank(student.getUser2())||
			isBlank(student.getUser3())) {
			throw new CustomException("请完善该条记录的所有数据后,再发送给教质部");
		}
		
		User currUser = (User) SecurityUtils.getSubject().getPrincipal();
		user.setIsTemp(STRING_NUMBER_ONE);
		user.setModifyTime(new Date());
		user.setModifyUser(currUser.getNickName());
		
		if(userMapper.updateByPrimaryKeySelective(user) == INTEGER_NUMBER_ONE) {
			return createMessageMap(EDIT, SUCCESS);
		}else {
			return createMessageMap(EDIT, ERROR);
		} 
	}

	@Override
	public Map<String, Object> checkClasses(Integer userId) throws CustomException {
		
		if(isBlank(userId)) throw new CustomException("传参异常");
		
		Student student = studentMapper.getStudentByUserId(userId);
		
		if(isExist(student)) throw new CustomException("查询异常");
		
		Integer classesId = student.getClassesId();
		
		if(isBlank(classesId)) return createMessageMap(2000, "");
		
		else return createMessageMap(5000, "该名学生已存在班级,如想更改班级,请转班申请");
		
	}

	@Override
	public Map<String, Object> addClasses(Integer classesId, Integer userId) throws CustomException {
		
		if(isBlank(classesId)) throw new CustomException("传参异常");
		
		if(isBlank(userId))	throw new CustomException("传参异常");
	
		Student student = studentMapper.getStudentByUserId(userId);
		
		if(isExist(student)) throw new CustomException("查询异常");
		
		student.setClassesId(classesId);
		
		User user = userMapper.selectByPrimaryKey(userId);
		
		if(isExist(user)) throw new CustomException("查询异常");
		
		user.setModifyTime(new Date());
		
		User currUser = (User) SecurityUtils.getSubject().getPrincipal();
		
		user.setModifyUser(currUser.getNickName());
		
		if(userMapper.updateByPrimaryKeySelective(user) == INTEGER_NUMBER_ONE && studentMapper.updateByPrimaryKeySelective(student) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(2000, "指定班级成功");
		
		else throw new CustomException("执行异常");
	}

	@Override
	public Map<String, Object> addUser123(Integer userId, Integer types, Integer user123Id) throws CustomException{
		
		if(isBlank(types)) throw new CustomException("入参异常001");
	
		if(isBlank(userId)) throw new CustomException("入参异常002");
		
		if(isBlank(user123Id)) throw new CustomException("入参异常003");
		
		Student student = studentMapper.getStudentByUserId(userId);
		
		if(isExist(student)) throw new CustomException("查询异常");
		System.err.println(types);
		System.err.println(user123Id);
		if(types == INTEGER_NUMBER_ONE)student.setUser1(user123Id);
		
		if(types == INTEGER_NUMBER_TWO)student.setUser2(user123Id);
		
		if(types == INTEGER_NUMBER_THREE)student.setUser3(user123Id);
		
		User user = userMapper.selectByPrimaryKey(userId);
		User u = (User)getSubject().getPrincipal();
		user.setModifyTime(new Date());
		user.setModifyUser(u.getNickName());
		
		if(userMapper.updateByPrimaryKeySelective(user) == INTEGER_NUMBER_ONE) 
		
		if(studentMapper.updateByPrimaryKeySelective(student) == INTEGER_NUMBER_ONE) 
		
		return createMessageMap(EDIT, SUCCESS);	
			
		else throw new CustomException("执行异常001");
		
		else throw new CustomException("执行异常002");
	}

	@Override
	public Map<String, Object> checkClassesExamination(Integer classesId) throws CustomException {

		if(isBlank(classesId)) throw new CustomException("传参异常");
		
		//查询当前班级进行中的考试数量   传参时toString()，是因为需要使用字符串
		int examinationCount = classesMapper.selectExaminationCount(classesId);
		
		if(examinationCount == 0) return createMessageMap(2000, "");

		else return createMessageMap(5000, "目标班级正在考试中，请稍后指定");
	}
}
