package com.vic.young.io;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 五
 * ObjectInputStream
 * ObjectOutputStream
 * 
 * @author Victor
 */
public class ObjectStreamTest {

    private static final String TMP_FILE = "dog.ser";
            
    public static void main(String[] args) throws Exception {
        
        testWrite();
        testRead();
        
    }

    private static void testRead() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE));
        System.out.println("boolean = "+in.readBoolean());
        System.out.println("byte = "+in.readByte());
        System.out.println("char = "+in.readChar());
        System.out.println("int = "+in.readInt());
        System.out.println("float = "+in.readFloat());
        System.out.println("double = "+in.readDouble());
        
        //map
        HashMap map= (HashMap)in.readObject();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry)it.next();  
            System.out.printf("%-6s -- %s\n" , entry.getKey(), entry.getValue());  
        }
        
        //Dog
        Dog dog = (Dog)in.readObject();
        System.out.println(dog);
        
        in.close();
    }

    private static void testWrite() throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
        out.writeBoolean(true);
        out.writeByte((byte)65);
        out.writeChar('a');
        out.writeChars("哈");
        out.writeInt(123);
        out.writeFloat(3.14F);
        out.writeDouble(1.423D);
        
        //Map
        HashMap map = new HashMap();
        map.put("a", "one");
        map.put("b", "two");
        map.put("c", "three");
        out.writeObject(map);
        
        //Dog
        Dog dog = new Dog("10J", "15CM");
        out.writeObject(dog);
        
        out.close();
    }
}

class Dog implements Serializable {
    /**  */
    private static final long serialVersionUID = -4820656848276311924L;
    
    private String weight;
    private String height;
    
    public Dog(String weight, String height) {
        super();
        this.weight = weight;
        this.height = height;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Dog [weight=" + weight + ", height=" + height + "]";
    }
    
}