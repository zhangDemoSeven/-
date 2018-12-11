package com.inter.service.dictionaries.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.dictionaries.SourceMapper;
import com.inter.pojo.dictionaries.Source;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.SourceService;
import com.inter.utils.PageHelper;
import com.inter.vo.SourceVo;

@Service
@Transactional
public class SourceServiceImpl extends BaseService implements SourceService {

	@Autowired
	private SourceMapper sourceMapper;

	@Override
	public List<SourceVo> getSourceListByNoPage() throws CustomException{
		
		List<SourceVo> list =new ArrayList<SourceVo>();
		
		//先查询父节点, 把父节点名称作为map集合的key 子节点集合作为map的value
		List<Source> parentSourceList =  sourceMapper.getParentSourceListByPidIsNull();
		for (Source source : parentSourceList) {
			if(source != null) {
				//根据父节点id查询子节点集合
				Integer parentId = source.getId();
				//子节点集合
				List<Source> childSourceList = sourceMapper.getParentSourceListByPid(parentId);
			
				SourceVo vo = new SourceVo();
				
				vo.setParentName(source.getSourceName());
				
				vo.setChildSourceList(childSourceList);
				list.add(vo);
			}
		}
		
		return list;
	}

	@Override
	public PageHelper<Source> getSourceListByPage(String name,Integer offset, Integer limit) {

		Integer total = sourceMapper.getCount(name);
		
		List<Source> list = sourceMapper.getSourceListByPage(name,offset,limit);
		
		return new PageHelper<Source>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateSource(Source source, Integer pid) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(source.getId())) {
			source.setCreateTime(new Date());
			source.setCreateUser(user.getNickName());
			source.setModifyUser(user.getNickName());
			source.setModifyTime(new Date());
			source.setProhibition(STRING_NUMBER_ONE);
			source.setStatus(STRING_NUMBER_ONE);
			if(pid != null) source.setPid(pid);
			else source.setPid(0);
			
			if(sourceMapper.insertSelective(source) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			source.setModifyUser(user.getNickName());
			source.setModifyTime(new Date());
			if(source.getPid() == null) source.setPid(0);
			if(sourceMapper.updateByPrimaryKeySelective(source) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Source selectByPrimaryKey(Integer id) throws CustomException {
		return sourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optSource(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Source source = sourceMapper.selectByPrimaryKey(id);
		
		if(isExist(source)) throw new CustomException("查询异常");
		
		String prohibition = source.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) source.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) source.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		source.setModifyTime(new Date());
		source.setModifyUser(user.getNickName());
		
		if(sourceMapper.updateByPrimaryKeySelective(source) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delSource(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Source source = sourceMapper.selectByPrimaryKey(id);
		
		if(isExist(source)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		source.setStatus(STRING_NUMBER_ZERO);
		source.setProhibition(STRING_NUMBER_ZERO);
		source.setModifyTime(new Date());
		source.setModifyUser(user.getNickName());
		
		if(sourceMapper.updateByPrimaryKeySelective(source) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}


	@Override
	public List<Source> selectParentList(Integer id) {
		//获得父级时，刨去本身，不能指定自己为父级
		List<Source> s=  sourceMapper.selectParentLsit(id);
		
		return s;
	}

	@Override
	public Source getParent(Integer sourceId) throws CustomException {
		
		if(sourceId == null) throw new CustomException("回显父级失败");
		
		return sourceMapper.selectParentById(sourceId);
	}
}
