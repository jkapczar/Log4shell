package log4jrcepoc;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class Main {
	
	static Logger logmainger = LogManager.getLogger(Main.class);
	
    public static void main(String[] args) throws Exception {
    	System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
    	logmainger.error(System.getProperty("com.sun.jndi.ldap.object.trustURLCodebase"));
    	logmainger.error("start");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(java.util.concurrent.Executors.newCachedThreadPool());
        server.start();
    }
    static class MyHandler implements HttpHandler {
    	
    	static Logger logger = LogManager.getLogger(MyHandler.class);
        @Override
        public void handle(HttpExchange t) throws IOException {
        	Headers headers =  t.getRequestHeaders();
        	String userAgent = headers.getFirst("User-Agent");
            
            logger.error("Request User Agent:{}", userAgent);
            
            String response = "response\n";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
