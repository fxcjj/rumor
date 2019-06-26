package com.vic.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 十二
 * BufferedInputStream
 * @author victor
 *
 */
public class BufferedInputStreamTest {
	
	private static final int LEN = 5;
	
	public static void main(String[] args) throws Exception {
		InputStream in = new BufferedInputStream(new FileInputStream(new File("d:/bis.txt")), 512);
		
		//读取5个字节， abcde
		for(int i = 0; i < LEN; i++) {
			if(in.available() >= 0) {
				//读取下一个字节
				int c = in.read();
				System.out.println("c =" + Integer.toHexString(c));
			}
		}
		
		//mark支持否
		if(!in.markSupported()) {
			System.out.println("not supported mark");
			return; 
		}
		
		//标记当前索引位置，即标记第6个位置的元素f
		//1024对应marklimit
		in.mark(1024);
		
		//跳过22个字节
		in.skip(22);
		
		//读取5个字节
		byte[] buf = new byte[LEN];
		in.read(buf, 0, LEN);
		System.out.println("buf = " + new String(buf));
		
		//重置“输入流的索引”为mark()所标记的位置，即重置到f处
		in.reset();

		//从重置后的输入流中读取5个字节，即读取fghij
		in.read(buf, 0, LEN);
		
		System.out.println("buf1 = " + new String(buf));
		
		in.close();
		
	}

}
