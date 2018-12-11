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
import com.inter.pojo.dictionaries.Books;
import com.inter.service.dictionaries.BooksService;
import com.inter.utils.PageHelper;

@Controller
@RequestMapping("/books")
public class BooksController extends BaseController {

	@Autowired
	private BooksService booksService;
	
	@RequestMapping("/get/nopage.do")
	@ResponseBody
	public List<Books> getBooksListByNoPage()throws CustomException{
		return booksService.getBooksListByNoPage();
	}
	
	@RequestMapping("/get/books.do")
	@ResponseBody
	public List<Books> getBooksListByStageId(Integer stageId)throws CustomException{
		return booksService.getBooksListByStageId(stageId);
	}
	
	@RequestMapping("/s/view.do")
	@Log(operationType="字典管理",operationName="课程字典管理页面",operationSource="教师端")
	public String initBooksListView() throws ReturnViewException, CustomException {
		checkPermissionToView("DICTIONARIES_BOOKS");
		return "dictionaries/books_list";
	}
	
	@RequestMapping("/show/books.do")
	public String initAddOrUpdateView(Model model,Integer id){
		if(id != null) {
			model.addAttribute("books", booksService.selectByPrimaryKey(id));
		}
		return "dictionaries/books_add";
	}
	
	@RequestMapping("/get/list.do")
	@ResponseBody
	public PageHelper<Books> getBooksListByPage(String booksName,Integer offset,Integer limit)throws CustomException, ReturnViewException {
		checkPermissionToView("DICTIONARIES_BOOKS");
		return booksService.getBooksListByPage(booksName,offset,limit);
	}
	
	@RequestMapping("/add/books.do")
	@ResponseBody
	@Log(operationName="保存或修改课程",operationSource="教师端",operationType="课程字典")
	public Map<String,Object> saveOrUpdateBooks(Books books) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_BOOKS");
		return booksService.saveOrUpdateBooks(books);
	}
	
	@RequestMapping("/opt/books.do")
	@ResponseBody
	@Log(operationName="启禁课程",operationSource="教师端",operationType="课程字典")
	public Map<String,Object> optBooks(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_BOOKS");
		return booksService.optBooks(id);
	}
	
	@RequestMapping("/del/books.do")
	@ResponseBody
	@Log(operationName="删除课程",operationSource="教师端",operationType="课程字典")
	public Map<String,Object> delBooks(Integer id) throws CustomException, ReturnViewException{
		checkPermissionToView("DICTIONARIES_BOOKS");
		return booksService.delBooks(id);
	}
}
