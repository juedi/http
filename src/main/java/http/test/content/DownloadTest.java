package http.test.content;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import http.HttpServer;

public class DownloadTest {
	private static final String WEB_ROOT = "D:\\code\\javaee\\http\\http\\index.html";
	
	public static void main(String[] args) throws IOException {
		String headerString = "HTTP/1.1 200 OK\r\n"
				+ "Content-Type: application/octet-stream\r\n"
				+ "Content-Disposition: attachment; filename=\"index.html\"\r\n"
				+ "\r\n";
		
		//头部
		byte[] header = headerString.getBytes("utf-8");
		
		//静态资源
		File file = new File(WEB_ROOT);
		byte[] body = FileUtils.readFileToByteArray(file);
		
		
		byte[] rsp = merge(header, body);
		HttpServer server = new HttpServer(rsp);
		server.start();
		
	}

	private static byte[] merge(byte[] header, byte[] body) {
		byte[] rsp = new byte[header.length + body.length];
		//拷贝header到响应中
		System.arraycopy(header, 0, rsp, 0, header.length);
		//拷贝body到响应中
		System.arraycopy(body, 0, rsp, header.length , body.length);
		return rsp;
	}

}