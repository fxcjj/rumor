package com.vic.bytecode;

/**
 * 字节码测试
 * @author victor
 * @date: 2020/5/21 11:01
 */
public class BytecodeTest3 {

    /**
     *  // new一个对象，对象的内存是在堆上分配，对象引用则是推入到操作数栈上
     *  0 new #2 <com/vic/bytecode/Point>
     *  // 全称duplicate，复制顶部操作数的栈值，意味着在栈顶部有两个指向Point对象的引用
     *  3 dup
     *  // 将int型常量1压入到栈
     *  4 iconst_1
     *  // 将int型常量1压入到栈
     *  5 iconst_1
     *  // 调用构造方法进行初始化，将栈中前三个销毁，剩下的就是已创建对象的原始引用（到目前为止，已成功完成初始化了）
     *  6 invokespecial #3 <com/vic/bytecode/Point.<init>>
     *  // 将栈中第一个引用类型值出栈，并放入索引为1的本地变量中，(astore_1中的a表示一个引用值)
     *  9 astore_1
     * 10 new #2 <com/vic/bytecode/Point>
     * 13 dup
     * 14 iconst_5
     * 15 iconst_3
     * 16 invokespecial #3 <com/vic/bytecode/Point.<init>>
     * 19 astore_2
     * // 从索引为1的本地变量中加载一个引用
     * 20 aload_1
     * // 从索引为2的本地变量中加载一个引用
     * 21 aload_2
     * // 调用ared方法
     * 22 invokevirtual #4 <com/vic/bytecode/Point.area>
     * 25 istore_3
     * 26 return
     * @param args
     */
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(5, 3);
        int area = a.area(b);
    }


}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int area(Point p) {
        int length = Math.abs(p.x - this.x);
        int width = Math.abs(p.y - this.y);
        return length * width;
    }

}