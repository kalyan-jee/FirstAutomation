package dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir")+"/Configuration/Config.properties";
	
	public ConfigFileReader()
	{
		BufferedReader bf;
		
		try {
			bf = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			
			try {
				properties.load(bf);
				bf.close();
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public String URL() {
		String urlLink = properties.getProperty("url");
		return urlLink;	
	}
	
	public String getFirstName()
	{  
		String firstName = properties.getProperty("firstName");
		return firstName;
	}

}
