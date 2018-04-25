package http.test.status;

import http.HttpServer;

public class HttpStatusCode403Test {
	
	
	public static void main(String[] args) {
		String rsp = "HTTP/1.1 403 Forbidden\r\n"
				+ "Content-type: text/html;charset=utf-8\r\n"
				+ "\r\n"
				+ "<div>没有权限</div>";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
