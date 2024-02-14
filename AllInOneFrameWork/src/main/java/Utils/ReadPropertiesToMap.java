package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ReadPropertiesToMap {
	
	/**
	 * 
	 * @param folderFilePath
	 * @param seperator Ex: = or :
	 * @return Map<String, Object>
	 */
	
	public static Map<String, Object> readPropToMap(String folderFilePath, String seperator) {
		Map<String, Object> readProp = new HashMap<>();
		try {
			
			BufferedReader bufferReader = new BufferedReader(new FileReader(folderFilePath));
			String line;
			while((line = bufferReader.readLine())!=null) {
				if(!(line.trim().length() == 0)) {
					if(!(line.startsWith("#"))) {
						int intProp = line.indexOf(seperator);
						readProp.put(line.substring(0,intProp).trim(), line.substring(intProp+1).trim());
					}
				}
			}
		}catch(Exception e) {
			Log.message("The error message is "+e.getMessage());
			return null;
		}
		return readProp;
	}

}
