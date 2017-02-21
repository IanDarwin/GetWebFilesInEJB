package playweb;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;


/**
 * Singleton Bean to find a folder in the web app context
 */
@Singleton
public class EjbGetWebContext {

	public static final String FOLDER_NAME = "/tmp";

	/** This will be set from the web tier by our ServletContextListener */
	static String webPath;
	
	/** A File object referring to webPath */
	private File folder;

	@PostConstruct
	void init() {
		
		System.out.println("EjbGetWebContext.init(): webPath = " + webPath);
		if (webPath == null) {
			throw new ExceptionInInitializerError("Path was not set");
		}
		folder = new File(webPath);
		if (webPath == null || !(folder.exists() && folder.isDirectory())) {
			throw new IllegalArgumentException("Pah! There is no directory named " + FOLDER_NAME + " here!");
		}
		System.out.println("EjbGetWebContext.execute(): folderName = " + FOLDER_NAME);
	}
	
	public void report() {
		System.out.println("EjbGetWebContext.report(): Moo!");
		for (File f : folder.listFiles()) {
			System.out.println(f);
		}
	}
}
