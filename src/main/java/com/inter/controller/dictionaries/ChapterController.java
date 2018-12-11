package com.inter.controller.dictionaries;

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
import com.inter.pojo.dictionaries.Chapter;
import com.inter.service.dictionaries.ChapterService;
import com.inter.utils.PageHelper;

@Controller
@RequestMapping("/chapter")
public class ChapterController extends BaseController{

	
	
	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="章节字典管理页面",operationSource="教师端")
	public String initChapterListView() throws ReturnViewException, CustomException {
		checkPermissionToView("DICTIONARIES_CHAPTER");
		return "dictionaries/chapter_list";
	}
	
	@RequestMapping("/show/chapter.do")
	public String initAddOrUpdateChapterView(Model model,Integer id) throws CustomException{
		if(id != null) {
			Chapter chapter = chapterService.selectPrimaryKey(id);
			System.err.println(chapter);
			model.addAttribute("chapter", chapter);
		}
		return "dictionaries/chapter_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Chapter> getChapterlistByPage(String name,Integer offset,Integer limit) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHAPTER");
		return chapterService.getChapterlistByPage(name,offset,limit);
	}
	
	@RequestMapping("/add/chapter.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="新增删除章节字典",operationSource="教师端")
	public Map<String,Object> saveOrUpdateChapter(Chapter chapter) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHAPTER");
		return chapterService.saveOrUpdateChapter(chapter);
	}
	
	
	@RequestMapping("/opt/chapter.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="启禁章节字典",operationSource="教师端")
	public Map<String,Object> optChapter(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHAPTER");
		return chapterService.optChapter(id);
	}
	
	@RequestMapping("/del/chapter.do")
	@ResponseBody
	@Log(operationType="字典管理",operationName="删除章节字典",operationSource="教师端")
	public Map<String,Object> delChapter(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_CHAPTER");
		return chapterService.delChapter(id);
	}
	
	@RequestMapping("/get/chapter.do")
	@ResponseBody
	public List<Chapter> getChapterListByBooksId(Integer booksId){
		return chapterService.getChapterListByBooksId(booksId);
	}
}
