package http.test.status;

import http.HttpServer;

public class HttpStatusCode401Test {
	
	
	public static void main(String[] args) {
		//BASIC 认证（基本认证）
		//DIGEST 认证（摘要认证）
		//SSL 客户端认证
		//FormBase 认证（基于表单认证）
		String rsp = "HTTP/1.1 401 Unauthorized\r\n"
				+ "WWW-Authenticate: Basic realm=\"Input your username and password\"\r\n"
				+ "\r\n";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
