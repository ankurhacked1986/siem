package siem;

import org.apache.camel.spring.Main;

public class SiemApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Main main = new Main();
    	main.setApplicationContextUri("applicationContext.xml");
    	main.enableHangupSupport();
    	System.out.println("\n\nApplication has now been started. You can press ctrl + c to stop.\n\n");
    	main.run();
	}

}
