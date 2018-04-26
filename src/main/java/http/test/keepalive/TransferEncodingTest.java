package http.test.keepalive;

import http.server.HttpServer;

public class TransferEncodingTest {

	public static void main(String[] args) {
		String rsp = "HTTP/1.1 200 OK\r\n"
				+ "Content-Type: text/html\r\n"
				+ "Transfer-Encoding: chunked\r\n"
				+ "\r\n" 
				+ "6\r\n"
				+ "123456\r\n"
				+ "22\r\n"
				+ "<div>hello Transfer-Encoding</div>\r\n"
				+ "0\r\n"
				+ "\r\n";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
