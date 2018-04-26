package http.test.content;

import http.server.HttpServer;

public class JsonContentTest {
	public static void main(String[] args) {
		String rsp = "HTTP/1.1 200 OK\r\n"
				+ "Content-Type: application/json;charset=utf-8\r\n"
				+ "\r\n" 
				+ "{\"name\": \"Eric\", \"gender\": \"男\"}";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
