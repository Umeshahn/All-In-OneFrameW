package Utils;

import java.io.File;

public class FolderCreation {
	
	public static String createFolder(String path, String folderName) {
		try {
			String folderPath = path+"/"+folderName;
			File file = new File(folderPath);
			
			if(!file.exists()) {
				if(file.mkdir()) 
					Log.message("The Folder is created succesfully...");
				else
					Log.message("Failed to create the Folder...");
			}else {
				Log.message("The Folder is already existed...");
			}
			return folderPath;
		}catch(Exception e) {
			Log.message("The error message is "+e.getMessage());
		}
		return null;
		
	}
	
	

}
