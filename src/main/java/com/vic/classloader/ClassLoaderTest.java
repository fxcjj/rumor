package com.vic.classloader;


/**
 * 加载：将类静态结构映射到方法区
 * 验证：文件格式、元数据、字节码、符号引用
 * 准备：赋予系统默认值
 * 解析：将符号引用解析成直接引用的过程
 * 初始化：将变量赋予程序员指定具体值
 * 使用
 * 卸载
 *
 *
 * 这个例子
 * 在“准备”环节，为以下情况
 * test = null;
 * x = 0;
 * y = 0;
 *
 * 在“初始化”环节，有两步
 * 第1步：
 * test = new ClassLoaderTest(); // 此时x=1,y=1
 * 第2步：
 * y = 0;
 *
 * 所以输出如下内容：
 * 1
 * 0
 *
 * https://blog.csdn.net/qq_35868412/article/details/89360250
 * https://blog.csdn.net/tzllxya/article/details/90412771
 *
 *
 */
public class ClassLoaderTest {
    private static ClassLoaderTest test = new ClassLoaderTest();

    static int x;
    static int y = 0;

    public ClassLoaderTest() {
        System.out.println("ClassLoaderTest()");
        x++;
        y++;
    }

    public static void main(String[] args) {
        System.out.println(test.x);
        System.out.println(test.y);

    }

}
