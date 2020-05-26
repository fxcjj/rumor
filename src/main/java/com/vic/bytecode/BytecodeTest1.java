package com.vic.bytecode;

/**
 * 字节码测试
 * https://blog.csdn.net/u011810352/article/details/80316870
 * https://blog.csdn.net/dyh200896/article/details/88547727
 * @author victor
 * @date: 2020/5/21 10:23
 */
public class BytecodeTest1 {

    private int num;

    /**
     *  // 从索引为0的本地变量中加载一个引用，推入到栈中
     *  // The <n> must be an index into the local variable array of the current frame (§2.6).
     *  // The local variable at <n> must contain a reference. The objectref in the local variable at <n> is pushed onto the operand stack.
     *  0 aload_0
     *  // 复制栈顶数值(这里是引用)并将复制值压入栈顶
     *  1 dup
     *  // 获取指定类的实例域（或者实例属性），并将其值压入栈顶
     *  2 getfield #2 <com/vic/bytecode/BytecodeTest2.num>
     *  // 复制栈顶一个字长的数据，弹出栈顶两个字长数据，先将复制后的数据压栈，再将弹出的两个字长数据压栈。
     *  // Duplicate the top value on the operand stack and insert the duplicated value two values down in the operand stack.
     *  5 dup_x1
     *  // 将int型常量1推入栈
     *  6 iconst_1
     *  // 将栈前两个int值出栈并相加，将相加的结果放入栈
     *  7 iadd
     *  // 为指定的类的实例域赋值
     *  8 putfield #2 <com/vic/bytecode/BytecodeTest2.num>
     *  // 从当前方法返回int
     *  11 ireturn
     * @return
     */
    public int getNum1() {
        return num++;
    }

    /**
     *  0 aload_0
     *  1 aload_0
     *  2 getfield #2 <com/vic/bytecode/BytecodeTest2.num>
     *  5 iconst_1
     *  6 iadd
     *  7 putfield #2 <com/vic/bytecode/BytecodeTest2.num>
     *  10 return
     */
    public void getNum2() {
        num = num + 1;
    }

    /**
     *  0 aload_0
     *  1 dup
     *  2 getfield #2 <com/vic/bytecode/BytecodeTest1.num>
     *  5 iconst_1
     *  6 iadd
     *  7 dup_x1
     *  8 putfield #2 <com/vic/bytecode/BytecodeTest1.num>
     * 11 ireturn
     * @return
     */
    public int getNum3() {
        return ++num;
    }


    public static void main(String[] args) {
        BytecodeTest1 b2 = new BytecodeTest1();
        // 0
        System.out.println(b2.getNum1());
        // 1
        System.out.println(b2.getNum1());
    }

}
