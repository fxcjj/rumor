package com.vic.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Servlet implementation class FileServlet
 */
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//下载文件，通过OutputStream流
		//downloadFileByOutputStream(response);
		
		//下载文件，通过PrintWriter流
		downloadFileByPrintWriter(response);
	}

	//下载文件，通过OutputStream流
	private void downloadFileByOutputStream(HttpServletResponse response) throws IOException {
		//1.获取要下载的文件的绝对路径
		//String path = this.getServletContext().getRealPath("/WEB-INF/resources/cat.jpg");
		//中文文件名
		String path = this.getServletContext().getRealPath("/WEB-INF/resources/猫.jpg");
		//2.获取文件名
		String fileName = path.substring(path.lastIndexOf("\\") + 1);
		
		//3.设置content-disposition响应头控制浏览器以下载形式打开文件
		//response.setHeader("content-disposition", "attachment;filename="+fileName);
		//处理中文乱码
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		
		//4.获取要下载的文件输入流
		InputStream in = new FileInputStream(path);
		
		//5.创建数据缓冲区
		int len = 0;
		byte[] buffer = new byte[1024];
		
		//6.通过response对象获取OutputStream流
		OutputStream out = response.getOutputStream();
		
		//7.将FileInputStream流写入到buffer缓冲区
		while((len = in.read(buffer)) > 0) {
			//8.使用OutputStream流将缓冲区的数据输出到客户端浏览器
			out.write(buffer, 0, len);
		}
		in.close();
	}
	
	//下载文件，通过PrintWriter流，虽然也能够实现下载，但是会导致数据丢失，因此不推荐使用PrintWriter流下载文件
	private void downloadFileByPrintWriter(HttpServletResponse response) throws IOException {
		//1.获取要下载的文件的绝对路径
		//中文文件名
		String path = this.getServletContext().getRealPath("/WEB-INF/resources/猫.jpg");
		//2.获取文件名
		String fileName = path.substring(path.lastIndexOf("\\") + 1);
		
		//3.设置content-disposition响应头控制浏览器以下载形式打开文件
		//处理中文乱码
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		
		//4.获取要下载的文件输入流
		FileReader in = new FileReader(path);
		//5.创建数据缓冲区
		int len = 0;
		char[] buffer = new char[1024];
		
		//6.通过response对象获取PrintWriter流
		PrintWriter out = response.getWriter();
		
		//7.将FileReader流写入到buffer缓冲区
		while((len = in.read(buffer)) > 0) {
			//8.使用PrintWriter流将缓冲区的数据输出到客户端浏览器
			out.write(buffer, 0, len);
		}
		in.close();
	}
	
	

}
