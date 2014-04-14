package graandy.com;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;


public class App {
  public static void main(String[] args) throws Exception {
		Server server = new Server(8081);
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setResourceBase("src/main/webapp");
		webAppContext.setContextPath("/");
		webAppContext.setParentLoaderPriority(true);
		server.setHandler(webAppContext);
		server.start();
		server.join();	
  }
}