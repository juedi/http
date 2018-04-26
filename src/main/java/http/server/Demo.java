package http.server;

public class Demo {
	public static void main(String[] args) {
		String rsp = "HTTP/1.1 200 OK\r\n"
				+ "Content-Type: text/html;charset=utf-8\r\n"
				+ "\r\n" 
				+ "<!DOCTYPE html>"
				+ "<html>"
					+ "<head>"
						+ "<title>first demo</title>"
					+ "</head>"
					+ "<body>"
						+ "<h1>Hello world</h1>"
					+ "</body>"
				+ "</html>";
		HttpServer server = new HttpServer(rsp);
		server.start();
	}
}
