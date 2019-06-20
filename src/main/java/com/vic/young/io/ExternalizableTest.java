package com.vic.young.io;

import java.io.*;

/**
 * 六
 * Externalizable
 * 
 * @author Victor
 */
public class ExternalizableTest {
    private static final String TMP_FILE = "girl.ser";
    public static void main(String[] args) throws Exception {
        
        testWrite();
        testRead();
        
    }

    private static void testRead() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE));
        //Girl
        Girl t = (Girl)in.readObject();
        System.out.println(t);
        in.close();
    }

    private static void testWrite() throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
        //Tiger
        Girl t = new Girl("kitty", 10, 15);
        out.writeObject(t);
        System.out.println(t);
        out.close();
    }

}

class Girl implements Externalizable {
    
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);  
        out.writeInt(weight);  
        out.writeInt(height);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();  
        weight = in.readInt();
        height = in.readInt(); 
    }
    
    private String name;
    private int weight;
    private int height;
    
    public Girl(){
    }
    
    public Girl(String name, int weight, int height) {
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
        return "Girl [name=" + name + ", weight="+weight +", height=" + height + "]";
    }
    
}