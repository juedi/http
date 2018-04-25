package http.test.status;

import http.HttpServer;

public class HttpStatusCode404Test {
	
	
	public static void main(String[] args) {
		String rsp = "HTTP/1.1 404 File Not Found\r\n"
				+ "Content-Type: text/html\r\n"
				+ "\r\n" 
				+ "<h1>File Not Found</h1>";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
