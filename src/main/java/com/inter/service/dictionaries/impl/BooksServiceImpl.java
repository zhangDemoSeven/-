package com.inter.service.dictionaries.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inter.base.BaseService;
import com.inter.exception.CustomException;
import com.inter.mapper.dictionaries.BooksMapper;
import com.inter.pojo.dictionaries.Books;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.BooksService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class BooksServiceImpl extends BaseService implements BooksService {

	@Autowired
	private BooksMapper booksMapper;

	@Override
	public List<Books> getBooksListByNoPage()throws CustomException {
		return booksMapper.getBooksListByNoPage();
	}

	@Override
	public PageHelper<Books> getBooksListByPage(String booksName,Integer offset, Integer limit) throws CustomException {

		Integer total = booksMapper.getCount(booksName);
		
		List<Books> list = booksMapper.getBooksListByPage(booksName,offset,limit);
		
		return new PageHelper<Books>(total,list);
	}

	@Override
	public Map<String, Object> saveOrUpdateBooks(Books books) throws CustomException {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(books.getId())) {
			
			books.setCreateTime(new Date());
			books.setCreateUser(user.getNickName());
			books.setModifyUser(user.getNickName());
			books.setModifyTime(new Date());
			books.setProhibition(STRING_NUMBER_ONE);
			books.setStatus(STRING_NUMBER_ONE);
			
			if(booksMapper.insertSelective(books) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			books.setModifyUser(user.getNickName());
			books.setModifyTime(new Date());
	
			if(booksMapper.updateByPrimaryKeySelective(books) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Books selectByPrimaryKey(Integer id) {
		return booksMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optBooks(Integer id) throws CustomException {
		
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Books books = booksMapper.selectByPrimaryKey(id);
		
		if(isExist(books)) throw new CustomException("查询异常");
		
		String prohibition = books.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) books.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) books.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		books.setModifyTime(new Date());
		books.setModifyUser(user.getNickName());
		
		if(booksMapper.updateByPrimaryKeySelective(books) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
		
	}

	@Override
	public Map<String, Object> delBooks(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Books Books = booksMapper.selectByPrimaryKey(id);
		
		if(isExist(Books)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		Books.setStatus(STRING_NUMBER_ZERO);
		Books.setProhibition(STRING_NUMBER_ZERO);
		Books.setModifyTime(new Date());
		Books.setModifyUser(user.getNickName());
		
		if(booksMapper.updateByPrimaryKeySelective(Books) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
		
	}

	@Override
	public List<Books> getBooksListByStageId(Integer stageId) throws CustomException {
		
		if(isBlank(stageId)) throw new CustomException("传参异常");
		
		return booksMapper.getBooksListByStageId(stageId);
	}
}
