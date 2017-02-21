package playweb;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@EJB
	EjbGetWebContext ejb;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		System.out.println("ContextListener.contextInitialized(): " + context);
		EjbGetWebContext.webPath = context.getRealPath(EjbGetWebContext.FOLDER_NAME);
		ejb.report();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
