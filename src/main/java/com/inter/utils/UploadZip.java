package com.inter.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadZip {

	public static String uploadPic(MultipartFile uploadfile,String picPath, HttpServletRequest request) {
		
		try {
		
			String webPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";

			MultipartFile items_pic=uploadfile;
			//原始名称
	  		String originalFilename = items_pic.getOriginalFilename();
	  		
	  		//String nowpath=System.getProperty("user.dir");
	  		
	  		String nowPath = request.getSession().getServletContext().getRealPath("");  
	  		
	  		String projectName = request.getContextPath();
	  		
	  		String path=nowPath.replace(projectName.substring(1, projectName.length()), "");
	  		
	  		//图片保存的路径
	  		path=path+"uploadfiles/"+picPath;
	  		
	  		//访问图片的路径
	  		String path2="";
	  		path2=webPath+"uploadfiles/"+picPath;
	  		
	  		File file=new File(path);
	  		if(!file.exists()){
	  			file.mkdirs();
	  		}
	  		//上传图片
	  		if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
		  		//存储图片的物理路径
		  		//String pic_path = "E:\\testpic\\temp\\";
		  		//新的图片名称
		  		String newFileName = RandomStringUtils.randomNumeric(32) + originalFilename.substring(originalFilename.lastIndexOf("."));
		  		//新图片
		  		File newFile = new File(path+newFileName);
		  		//将内存中的数据写入磁盘
				items_pic.transferTo(newFile);

				return path2+newFileName;
	  		}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return null;
		
	}
}
