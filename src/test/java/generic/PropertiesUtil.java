package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	public Properties p1;
	
	public PropertiesUtil(String fileName) {
		
		p1 =new Properties();
		File f1= new File(System.getProperty("user.dir")+"//ConfigData//"+fileName+".properties");
		
	try {
		FileInputStream fs= new FileInputStream(f1);
		
		p1.load(fs);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public String getData(String key) {
		
		return p1.getProperty(key);
	
	}

}
