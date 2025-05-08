/**
 * 
 */
package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 */
public class ConfigReader {
	
	// Solid Single usability principle used here :)
	
	private Properties prop;
	
	public Properties init_prop() {
		
		prop= new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
		
	}

}
