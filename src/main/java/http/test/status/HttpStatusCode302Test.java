package http.test.status;

import http.HttpServer;

public class HttpStatusCode302Test {
	
	public static void main(String[] args) {
		//资源临时移动，默认客户端不会缓存
		String rsp = "HTTP/1.1 302 Found\r\n"
				+ "Location: http://www.baidu.com\r\n"
				+ "\r\n";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
