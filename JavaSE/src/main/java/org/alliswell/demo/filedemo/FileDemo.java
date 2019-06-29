/**
 * @Title: FileDemo
 * @Package org.org.alliswell.demo.filedemo
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/11/22 15:29
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.filedemo;

import java.io.*;

/**
 * @author alliswell008
 * @ClassName: FileDemo
 * @Description: 获取CLASSPATH下文件的绝对路径
 *               当使用相对路径写入文件时候，就需要用到绝对路径。下面是个例子：
 * @date 2016/11/22 15:29
 */
public class FileDemo {

    public static void main(String[] args) throws Exception {
        getFileByClassPath();
    }


    /**
     * CLASSPATH文件的绝对路径获取测试
     *
     * @author leizhimin 2010-1-18 9:33:02
     */
    //classpath的文件路径
    private static String cp = "/a.txt";

    public static void getFileByClassPath() throws Exception {
        //当前类的绝对路径
        System.out.println("1:" + FileDemo.class.getResource("/").getFile());
        //指定CLASSPATH文件的绝对路径
        System.out.println("2:" + FileDemo.class.getResource(cp).getFile());
        //指定CLASSPATH文件的绝对路径
        File f = new File(FileDemo.class.getResource(cp).getFile());
        System.out.println("3:" + f.getPath());

        //读取文件
        InputStream in = FileDemo.class.getResourceAsStream(cp);
        String a = stream2String(in, "UTF8");
        System.out.println(a);

        FileInputStream fis = new FileInputStream(f);
        byte[] buffer =new byte[(int) f.length()];
        fis.read(buffer, 0, buffer.length);
        fis.close();
        String str = new String(buffer);
        System.out.println(str);
    }

    /**
     * 文件转换为字符串
     *
     * @param f             文件
     * @param charset 文件的字符集
     * @return 文件内容
     */
    public static String file2String(File f, String charset) {
        String result = null;
        try {
            result = stream2String(new FileInputStream(f), charset);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 文件转换为字符串
     *
     * @param in            字节流
     * @param charset 文件的字符集
     * @return 文件内容
     */
    public static String stream2String(InputStream in, String charset) {
        StringBuffer sb = new StringBuffer();
        try {
            Reader r = new InputStreamReader(in, charset);
            int length = 0;
            for (char[] c = new char[1024]; (length = r.read(c)) != -1;) {
                sb.append(c, 0, length);
            }
            r.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
