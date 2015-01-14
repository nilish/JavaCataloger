package goynaa.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.FileItemStream;

public class FileUpload {
	private boolean result;
	public boolean processFile(String path, FileItemStream item){
		try{
		//File f = new File(path+File.separator+"images"+File.separator+"products");
	    //File f = new File(path+File.separator+"images"+File.separator+"product");
			File f = new File(path+File.separator);	
		if(!f.exists()) 
			f.mkdir();
		File savedFile = new File(f.getAbsolutePath()+ File.separator+item.getName());
		FileOutputStream fos = new FileOutputStream(savedFile);
		InputStream is = item.openStream();
		int x = 0;
		byte[] b = new byte[1024];
		while((x=is.read(b)) != -1){
		    fos.write(b, 0, x);	
		}
		fos.flush();
		fos.close();
		result = true;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return result;
		}
	}


