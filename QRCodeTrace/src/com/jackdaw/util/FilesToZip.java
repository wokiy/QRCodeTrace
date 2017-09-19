package com.jackdaw.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author Sgoldfish
 *
 */
public class FilesToZip {
	
	public static void fileToZip(File sourceFile,File destFile) throws Exception {
		String savePath = destFile.getAbsolutePath();
		// 处理路径问题
		int index = savePath.lastIndexOf(File.separator);
		String saveDir = savePath.substring(0, index);
		File dir = new File(saveDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		FileOutputStream fos = new FileOutputStream(destFile);
		ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos));
		BufferedInputStream bis = null;
		File[] files = sourceFile.listFiles();
			 if(null != files && files.length>1){  
				 for (File file : files) {
            		 ZipEntry zipEntry = new ZipEntry(file.getName());
            		 zos.putNextEntry(zipEntry);
            		 bis = new BufferedInputStream(new FileInputStream(file));
            		 byte[] bufs = new byte[1024];  
            		 int len = 0;
            		 while((len = bis.read(bufs)) != -1) {
            			 zos.write(bufs, 0, len);
            		 }
            	 }
            	 bis.close();
            	 zos.close();
             }
		}
}
