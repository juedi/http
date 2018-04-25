package http.test;

import http.HttpServer;

public class CookieTest {

	public static void main(String[] args) {
		String rsp = "HTTP/1.1 200 OK\r\n"
				+ "Content-Type: text/html\r\n"
				+ "Set-Cookie: jsessionid=abcde;domain=dly.com;HttpOnly\r\n"
				+ "\r\n" 
				+ "<h1>Hello world</h1>";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}

}
