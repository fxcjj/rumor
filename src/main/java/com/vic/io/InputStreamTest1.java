package com.vic.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Tests relevant method for class  <code>InputStream</code>
 * 
 * @author Victor
 */
public class InputStreamTest1 {
    
    public static void main(String[] args) throws Exception {
        
//        testGetBytes();
        
        testMark();  
        
//        testAvailable();
       
    }

    
    /**
     * 测试{@link ByteArrayInputStream#available()}
     * Returns the number of remaining bytes that can be read (or skipped over) from this input stream.
     * The value returned is count - pos, which is the number of bytes remaining to be read from the input buffer.
     */
    private static void testAvailable() {
        byte[] bytes = {1, 2, 3, 4, 5};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        //available返回的count-pos
        while(bais.available() > 0) {
            int read = bais.read();
            System.out.println(read);
        }
    }

    /**
     * Tests the <code>mark</code> method for class <code>InputStream</code>
     * @throws IOException if an I/O error occurs.
     */
    private static void testMark() throws IOException  {

        //initial a byte array consist of five bytes
        byte[] bytes = {1, 2, 3, 4, 5};
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BufferedInputStream bis = new BufferedInputStream(bais, 3);

        //读取字节1
        System.out.println(bis.read());

        //在字节2处做标记，并设置readlimit参数为1
        //字节2指的是下次读取byte的位置
        //根据java文档mark以后最多只能读取1个字节，否则mark标记失效，调用reset异常。实际运行结果不是这样！
        System.out.println("mark");
        bis.mark(2);

        //连续读取两个字节，超过了readlimit的大小，mark标记仍有效
        System.out.println(bis.read());
        System.out.println(bis.read());
        System.out.println(bis.read());
//        System.out.println(bis.read());
//        System.out.println(bis.read());

        //调用reset方法，未发生异常，说明mark标记仍有效
        //因为，虽然readlimit参数为1，但是这个BufferedInputStream类的缓冲区大小为2
        //所以允许读取2字节
        System.out.println("reset");
        bis.reset();

        /**
         * 连续读取3个字节，超过了缓冲区大小，mark标记失效。
         * 在这个例子中BufferedInputStream类的缓冲区大小大于readlimit
         * mark标记由缓冲区大小决定
         */
        //reset后连续读取3个字节，超过了BufferedInputStream类的缓冲区大小
        System.out.println(bis.read());
        System.out.println(bis.read());
        System.out.println(bis.read());
//        System.out.println(bis.read());

        //再次调用reset，抛出异常，说明mark后读取3个字节，mark标记失效
        System.out.println("reset again");
        bis.reset();

        /*
         二种情况
         一、buf.size>readlimit
             允许读取的最大字节数为buf.size，超过buf.size，则mark标记失效，调用reset抛出异常。
             若buf.size=3, readlimit=2
             当mark(readlimit)后，若要后续的reset操作不抛出异常，那么后续的read操作次数只允许<=3次，否则，reset抛出异常。
         二、buf.size<readlimit
             允许读取的最大字节数为readlimit，超过readlimit，则mark标记失效，调用reset抛出异常。
             若buf.size=2, readlimit=4
             当mark(readlimit)后，若要后续的reset操作不抛出异常，那么后续的read操作次数只允许<=4次，否则，reset抛出异常。

        简言之，调用BufferedInputStream的mark(int readlimit)方法后，后续读取多少字节标记才失效，
        取决于readlimit和buf.size两者中的最大值，而并非完全由readlimit确定，这个在JAVA文档中是没有提到的。
         */
    }


    /**
     * 测试{@link String#getBytes()}
     */
    private static void testGetBytes() {
        //UTF-8编码
       byte[] bytes = "要".getBytes();
        for(int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]); //-24 -90 -127
        }
        
        System.out.println();
        
        byte[] bytes2 = "<l".getBytes();
        for(int i = 0; i < bytes2.length; i++) {
            System.out.println(bytes2[i]); //60 108
        }
        
    }
    
    public synchronized int read() throws IOException {
    	//refer to BufferedInputStream#read();
    	return 0;
    }
    
    //play
    public synchronized int read(byte b[]) throws IOException {
    	return read(b, 0, b.length);
    }

	private synchronized int read(byte[] b, int off, int len) throws IOException {
		if(b == null) {
			throw new NullPointerException();
		} else if(off < 0 || len < 0 || len > b.length - off) {
			throw new IndexOutOfBoundsException();
		} else if(len == 0) {
			return 0;
		}
		
		int c = read();
		if(c == -1) {
			return -1;
		}
		
		b[off] = (byte)c;
		
		int i = 1;
		try {
			for(; i < len; i++) {
				c = read();
				if(c == -1) {
					break;
				}
				b[off+i] = (byte)c;
			}
		} catch (IOException ee) {
		}
		return i;
	}
	
	public long skip(long n) throws IOException {
		long remaining = n;
		int nr;
		
		if(n <= 0) {
			return 0;
		}
		
		int size = (int)Math.min(2048L, remaining);
		byte skipBuffer[] = new byte[size];
		while(remaining > 0) {
			nr = read(skipBuffer, 0, (int)Math.min(2048L, remaining));
			if(nr < 0) {
				break;
			}
			remaining -= nr;
		}
		return n - remaining;
	}
}
