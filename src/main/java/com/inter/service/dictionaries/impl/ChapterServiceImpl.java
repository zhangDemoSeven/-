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
import com.inter.mapper.dictionaries.ChapterMapper;
import com.inter.mapper.dictionaries.StageMapper;
import com.inter.pojo.dictionaries.Books;
import com.inter.pojo.dictionaries.Chapter;
import com.inter.pojo.dictionaries.Stage;
import com.inter.pojo.system.User;
import com.inter.service.dictionaries.ChapterService;
import com.inter.utils.PageHelper;

@Service
@Transactional
public class ChapterServiceImpl extends BaseService implements ChapterService {

	@Autowired
	private ChapterMapper chapterMapper;

	@Autowired
	private BooksMapper booksMapper;
	
	@Autowired
	private StageMapper stageMapper;
	
	@Override
	public PageHelper<Chapter> getChapterlistByPage(String name,Integer offset, Integer limit) throws CustomException {
		Integer total = chapterMapper.getCount(name);
		List<Chapter> list = chapterMapper.getChapterListByPage(name,offset,limit);
		if(isNotExist(list)) {
			for (Chapter chapter : list) {
				if(isNotExist(chapter)) {
					Integer booksId = chapter.getBooksId();
					if(isNotBlank(booksId)) {
						Books books = booksMapper.selectByPrimaryKey(booksId);
						if(isNotExist(books)){
							chapter.setBooksName(books.getName());
						}
						Stage stage = stageMapper.getStageByBooksId(booksId);
						if(isNotExist(stage)) {
							chapter.setStageName(stage.getName());
						}
					}
				}
			}
		}
		
		
		return new PageHelper<>(total, list);
	}

	@Override
	public Map<String, Object> saveOrUpdateChapter(Chapter chapter) throws CustomException {

		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		if(isBlank(chapter.getId())) {
			chapter.setCreateTime(new Date());
			chapter.setCreateUser(user.getNickName());
			chapter.setModifyUser(user.getNickName());
			chapter.setModifyTime(new Date());
			chapter.setProhibition(STRING_NUMBER_ONE);
			chapter.setStatus(STRING_NUMBER_ONE);
			
			if(chapterMapper.insertSelective(chapter) == INTEGER_NUMBER_ONE) return createMessageMap(SAVE, SUCCESS);
			
			else throw new CustomException("保存失败");
		}else {
			
			chapter.setModifyUser(user.getNickName());
			chapter.setModifyTime(new Date());
	
			if(chapterMapper.updateByPrimaryKeySelective(chapter) == INTEGER_NUMBER_ONE) return createMessageMap(EDIT, SUCCESS);
			
			else throw new CustomException("修改失败");
		}
	}

	@Override
	public Chapter selectPrimaryKey(Integer id) {
		return chapterMapper.selectByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> optChapter(Integer id) throws CustomException {
		
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Chapter chapter =  chapterMapper.selectByPrimaryKey(id);
		
		if(isExist(chapter)) throw new CustomException("查询异常");
		
		String prohibition = chapter.getProhibition();
		
		if(STRING_NUMBER_ONE.equals(prohibition)) chapter.setProhibition(STRING_NUMBER_ZERO);
		
		if(STRING_NUMBER_ZERO.equals(prohibition)) chapter.setProhibition(STRING_NUMBER_ONE);
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		chapter.setModifyTime(new Date());
		chapter.setModifyUser(user.getNickName());
		
		if(chapterMapper.updateByPrimaryKeySelective(chapter) == INTEGER_NUMBER_ONE)
		
		return createMessageMap(EDIT, SUCCESS);
		
		else throw new CustomException("修改失败");
	}

	@Override
	public Map<String, Object> delChapter(Integer id) throws CustomException {
	
		if(isBlank(id)) throw new CustomException("传参异常");
		
		Chapter chapter =  chapterMapper.selectByPrimaryKey(id);
		
		if(isExist(chapter)) throw new CustomException("查询异常");
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		chapter.setStatus(STRING_NUMBER_ZERO);
		chapter.setProhibition(STRING_NUMBER_ZERO);
		chapter.setModifyTime(new Date());
		chapter.setModifyUser(user.getNickName());
		
		if(chapterMapper.updateByPrimaryKeySelective(chapter) == INTEGER_NUMBER_ONE)
			
		return createMessageMap(DEL, SUCCESS);
			
		else throw new CustomException("删除失败");
	}

	@Override
	public List<Chapter> getChapterListByBooksId(Integer booksId) {
		return chapterMapper.getChapterListByBooksId(booksId);
	}
}
