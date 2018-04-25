package http.test.keepalive;

import http.HttpServer;

public class ConnectionTest {

	public static void main(String[] args) {
		String rsp = "HTTP/1.1 200 OK\r\n"
				+ "Content-Type: text/html\r\n"
				+ "Connection: close\r\n"
				+ "Content-Length: 23\r\n"
				+ "\r\n"
				+ "<p>hello connection</p>";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
