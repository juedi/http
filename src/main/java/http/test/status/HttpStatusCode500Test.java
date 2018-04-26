package http.test.status;

import http.server.HttpServer;

public class HttpStatusCode500Test {
	
	
	public static void main(String[] args) {
		String rsp = "HTTP/1.1 500 Internal Server Error\r\n"
				+ "Content-Type: text/html;charset=utf-8\r\n"
				+ "\r\n" 
				+ "<h1>服务内部错误</h1>";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
