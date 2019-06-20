package com.vic.young.io;

import java.io.*;

/**
 * 六
 * Serializable
 * 
 * @author Victor
 */
public class SerializableTest {
    private static final String TMP_FILE = "tiger.ser";
    public static void main(String[] args) throws Exception {
        
        testWrite();
        testRead();
        
        /*
         Tiger [name=kitty, weight=10, height=0]
          
          weight=10 是因为初始化时，所有的Tiger只有一份这个，所以打印为10
          height=0 是因为int类型的默认值为0
         */
    }

    private static void testRead() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE));
        //Tiger
        Tiger t = (Tiger)in.readObject();
        System.out.println(t);
        in.close();
    }

    private static void testWrite() throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
        //Tiger
        Tiger t = new Tiger("kitty", 10, 15);
        out.writeObject(t);
        out.close();
    }

}

class Tiger implements Serializable {
    
    private /*transient */Thread thread = new Thread() {  
        @Override 
        public void run() {  
            System.out.println("Serializable thread");  
        }  
    }; 
    
    /**  */
    private static final long serialVersionUID = -4820656848276311924L;
    
    private String name;
    private static int weight;
    private transient int height;
    
    public Tiger(String name, int weight, int height) {
        super();
        this.name = name;
        this.weight = weight;
        this.height = height;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString() {
        return "Tiger [name=" + name + ", weight="+weight +", height=" + height + "]";
    }
}