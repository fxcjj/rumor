package com.vic.base;

/**
 * The difference between i++ and ++i
 * @author victor
 * date: 2019/12/23 11:53
 * https://blog.csdn.net/xialei199023/article/details/76383013
 */
public class IPlusByteCodeTest {

    public static void main(String[] args) {

        testSelf();

//        testPlusI();

//        testIPlus();
    }

    /**
     * test i++
     */
    public static void testIPlus() {
        int i = 0;
        int j = i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);

    }

    /**
     * test ++i
     */
    public static void testPlusI() {
        int i = 0;
        int j = ++i;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }

    /*
    bytecode:
     public static void testSelf();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=3, locals=1, args_size=0
         0: iconst_0
         1: istore_0
         2: iload_0
         3: iinc          0, 1
         6: istore_0
         7: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
        10: new           #4                  // class java/lang/StringBuilder
        13: dup
        14: invokespecial #5                  // Method java/lang/StringBuilder."<init>":()V
        17: ldc           #6                  // String i =
        19: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        22: iload_0
        23: invokevirtual #8                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        26: invokevirtual #9                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        29: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        32: return
      LineNumberTable:
        line 45: 0
        line 46: 2
        line 47: 7
        line 48: 32
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            2      31     0     i   I
     */
    public static void testSelf() {
        int i = 0;
        i = i++;
        System.out.println("i = " + i);

        int j = 0;
        j = ++j; // equivalent to ++j
        System.out.println("j = " + j);
    }
}
