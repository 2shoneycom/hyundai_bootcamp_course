package com.spring_boot_fileupload.mybatis.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FileDownloadController {

	@GetMapping("/fileDownloadView")
	public String fileDownloadView(Model model) {
		String downloadPath = "/Users/lsh/Documents/hyundai_bootcamp_course/springbootWorkspace/upload";

		File path = new File(downloadPath);
		String[] filelist = path.list(); // 파일 경로의 모든 파일의 경로

		model.addAttribute("filelist", filelist);	
		
		return "upload/fileDownloadListView";
	}

	@GetMapping("/fileDownload/{file}")
	public void fileDownload(@PathVariable String file, HttpServletResponse response) throws IOException {
		File f = new File("/Users/lsh/Documents/hyundai_bootcamp_course/springbootWorkspace/upload/", file);
		
		// 한글 파일명 인코딩 필요
		String encodedFileName = new String(file.getBytes("UTF-8"), "ISO-8859-1");
		
		// response 객체 헤더 구성
		response.setContentType("application/download");
		response.setContentLength((int)f.length());//파일 크기정보
		response.setHeader("Content-Disposition",
				"attatchment;filename=\"" + encodedFileName + "\"");
		
		// 파일 다운로드 처리
		FileInputStream fis = new FileInputStream(f);
		OutputStream os = response.getOutputStream();
		
		// 파일 다운로드
		FileCopyUtils.copy(fis, os);
	}
}
