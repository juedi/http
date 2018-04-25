package http.test.keepalive;

import http.HttpServer;

public class ContentLengthTest {
	public static void main(String[] args) {
		
		String rsp = "HTTP/1.1 200 OK\r\n"
				+ "Content-Type: text/html\r\n"
				+ "Content-Length: 27\r\n"
				+ "\r\n"
				+ "<p>hello Content-Length</p>";
		HttpServer server = new HttpServer(rsp);
		
		System.out.println("<p>hello Content-Length</p>".getBytes().length);
		server.start();
	}
}
