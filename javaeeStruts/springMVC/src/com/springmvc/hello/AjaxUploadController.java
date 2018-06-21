package com.springmvc.hello;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ajax_upload")
public class AjaxUploadController {

	@RequestMapping("/show")
	public String show() {
		return "ajax_upload";
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam(value = "myfile", required = false) MultipartFile[] files,
			HttpServletRequest request) throws Exception {
		if (files != null && files.length > 0) {
			for (MultipartFile file : files) {
				saveFile(request, file);
			}
		}
		// 这里要解决中文乱码问题
		return new String("上传成功".getBytes("utf-8"), "iso-8859-1");
	}

	private void saveFile(HttpServletRequest request, MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				String filePath = request.getServletContext().getRealPath("/") + "upload/" + file.getOriginalFilename();

				File newFile = new File(filePath);
				if (!newFile.getParentFile().exists()) {
					newFile.getParentFile().mkdirs();
				}

				file.transferTo(newFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
