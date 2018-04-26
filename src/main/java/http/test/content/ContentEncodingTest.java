package http.test.content;

import java.io.UnsupportedEncodingException;

import http.server.HttpServer;
import http.util.GzipUtils;

public class ContentEncodingTest {
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String headerString = "HTTP/1.1 200 OK\r\n"
				+ "Content-Type: text/html;charset=utf-8\r\n"
				+ "Content-Encoding: gzip\r\n"
				+ "\r\n";
		
		//头部数据
		byte[] header = headerString.getBytes("utf-8");
		
		//body数据
		byte[] body = GzipUtils.compress("<h1>当前服务不存在</h1>", "utf-8");
		
		//合并header和body
		byte[] rsp = merge(header, body);
		
		//打印下响应信息
//		System.out.println(new String(rsp));
		
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
