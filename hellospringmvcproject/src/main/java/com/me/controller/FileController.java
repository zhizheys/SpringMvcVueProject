package com.me.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.me.controller.framework.BaseController;
import com.me.controller.viewobject.ApiResult;
import com.me.service.dto.BookDTO;

@RestController
@RequestMapping("/file")
public class FileController extends BaseController {
	
	//通过表单上传多少个文件
//	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
//	public ApiResult saveProduct(HttpServletRequest servletRequest) {
//		
//		ApiResult apiResult = new ApiResult();
//	
//
//		List<MultipartFile> files = product.getImages();
//		System.out.println("文件数量是" + files.size());
//		if (null != files && files.size() > 0) {
//			for (MultipartFile file : files) {
//				String fileName = file.getOriginalFilename(); // 获得文件名称
//				//String filePath=servletRequest.getServletContext().getRealPath("/static/images");
//				String filePath="E:" + File.separator + "Test";
//				
//				File imagFile = new File(filePath, fileName);
//				try {
//					file.transferTo(imagFile);// 用于将文件写到服务器本地
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		apiResult.setIsSuccess(true);
//		apiResult.setMessage("success");
//		apiResult.setData(null);
//
//		return apiResult;
//	}
//	
//	@RequestMapping(value = "/uploadmultiplefile", method = RequestMethod.POST)
//	public ApiResult saveProduct(HttpServletRequest servletRequest) {
//		
//		ApiResult apiResult = new ApiResult();
//	
//
//		List<MultipartFile> files = product.getImages();
//		System.out.println("文件数量是" + files.size());
//		if (null != files && files.size() > 0) {
//			for (MultipartFile file : files) {
//				String fileName = file.getOriginalFilename(); // 获得文件名称
//				//String filePath=servletRequest.getServletContext().getRealPath("/static/images");
//				String filePath="E:" + File.separator + "Test";
//				
//				File imagFile = new File(filePath, fileName);
//				try {
//					file.transferTo(imagFile);// 用于将文件写到服务器本地
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		apiResult.setIsSuccess(true);
//		apiResult.setMessage("success");
//		apiResult.setData(null);
//
//		return apiResult;
//	}
		
}
