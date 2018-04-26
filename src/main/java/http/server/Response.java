package http.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;

	public Response(OutputStream output) {
		this.output = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void send(Object rsp) throws IOException {
		
		if(request.getUri().contains("user")) {
			String json = "HTTP/1.1 200 OK\r\n"
					+ "Content-Type: application/json;charset=utf-8\r\n"
					+ "Content-Length: 33\r\n"
					+ "Connection: keep-alive\r\n"
					+ "\r\n" 
					+ "{\"name\": \"Eric\", \"gender\": \"男\"}";
			output.write(json.getBytes());
			return;
		}
		
		if(rsp instanceof String) {
			output.write(((String)rsp).getBytes());
		}else if(rsp instanceof byte[]) {
			output.write((byte[])rsp);
		}
	}
	

	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			File file = new File("", request.getUri());
			if (file.exists()) {
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				while (ch != -1) {
					output.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}
