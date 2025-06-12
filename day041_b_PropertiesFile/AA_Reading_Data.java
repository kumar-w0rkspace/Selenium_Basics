package day041_b_PropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class AA_Reading_Data {

	public static void main(String[] args) throws IOException {

		// creating obj
		Properties propertiesObj = new Properties();
		// locating file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\config.properties");
		// loading file
		propertiesObj.load(file);
		// reading data from the file
		String url = propertiesObj.getProperty("appurl");
		String email = propertiesObj.getProperty("email");
		String password = propertiesObj.getProperty("password");
		String id = propertiesObj.getProperty("id");
		String cName = propertiesObj.getProperty("customername");
		System.out.println(url + "\n" + email + "\n" + password + "\n" + id + "\n" + cName);
// reading keys only
		Set<String> keys = propertiesObj.stringPropertyNames();// Returns a Set <String> (no duplicates)
		Set<Object> keySet = propertiesObj.keySet();

		System.out.println(keys);
		System.out.println(keySet);
// reading values only
		Collection<Object> values = propertiesObj.values();
		System.out.println(values);

		file.close();
	}

}
