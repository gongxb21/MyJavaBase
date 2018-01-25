/**
 * 
 */
package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author gongxb
 * @date 2018-1-25  ÐÂ½¨ 
 */
public class MyBufferedReader {
	private BufferedReader br;
	
	public void readline() throws IOException{
		br=new BufferedReader(new FileReader(new File("D:/User/Desktop/edit.txt")));
		String temp;
		while((temp=br.readLine())!=null){
			System.out.println(temp);
		}
		
		br.close();
	}
}
