package http.test.status;

import http.server.HttpServer;

public class HttpStatusCode503Test {
	
	
	public static void main(String[] args) {
		String rsp = "HTTP/1.1 503 Service Unavailable\r\n"
				+ "Content-Type: text/html;charset=utf-8\r\n"
				+ "Retry-After: 30\r\n"
				+ "\r\n" 
				+ "<h1>当前服务不存在</h1>";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
