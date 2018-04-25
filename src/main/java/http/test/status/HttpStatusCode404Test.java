package http.test.status;

import http.HttpServer;

public class HttpStatusCode404Test {
	
	
	public static void main(String[] args) {
		String rsp = "HTTP/1.1 400 Bad Request\r\n"
				+ "Content-Type: text/html;charset=utf-8\r\n"
				+ "\r\n" 
				+ "<h1>客户端错误</h1>";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
