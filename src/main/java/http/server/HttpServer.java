package http.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	private boolean shutdown = false;

	// http响应内容
	private Object rsp;
	
	public HttpServer(Object rsp) {
		this.rsp = rsp;
	}

	public void start() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
			System.out.println("启动成功...");
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		while (!shutdown) {
			Socket socket = null;
			try {

				socket = serverSocket.accept();
				
				new Thread(new HandleThread(socket, this.rsp)).start();

				System.out.println("the client port is:" + socket.getPort());
			} catch (Exception e) {
				e.printStackTrace();
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
	}

	class HandleThread implements Runnable {
		private Socket socket;
		private Object rsp;
		boolean stop = false;

		public HandleThread(Socket socket, Object rsp) {
			this.socket = socket;
			this.rsp = rsp;
		}

		@Override
		public void run() {
			try {
				InputStream input = null;
				OutputStream output = null;
				input = socket.getInputStream();
				output = socket.getOutputStream();
				// 输入流创建一个request
				Request request = new Request(input);
				while(!stop) {
					request.parse();
					// 输出流创建一个response
					Response response = new Response(output);
					response.setRequest(request);
	
					response.send(this.rsp);
					
					stop = true;
					socket.close();
				}
			} catch (Exception e) {
				stop = true;
				e.printStackTrace();
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
