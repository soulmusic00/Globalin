package com.ioex;

import java.io.*;

public class FileInputStreamEx {

	public static void main(String[] args) {

		FileInputStream fis = null;

		byte _read[] = new byte[100];
		byte console[] = new byte[100];

		try {

			System.out.print("파일명 : ");
			System.in.read(console);
			String file = new String(console).trim();

			fis = new FileInputStream(file);
			fis.read(_read, 0, _read.length);
			System.out.print(new String(_read).trim());
			
			
		} catch (FileNotFoundException fn) {
			fn.printStackTrace();
		} catch (IOException ii) {
			ii.printStackTrace();
		} finally {

			try {
				if (fis != null)
					fis.close();
			} catch (IOException eee) {

			}
		}

	}

}
