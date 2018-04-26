package http.test.status;

import http.server.HttpServer;

public class HttpStatusCode301Test {
	
	
	public static void main(String[] args) {
		//资源永久移动，默认客户端会缓存
		String rsp = "HTTP/1.1 301 Moved Permanently\r\n"
				+ "Location: http://www.baidu.com\r\n"
				+ "\r\n";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
