/**
 * @Title: FileDemo
 * @Package org.org.alliswell.demo.file
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
package alliswell.demo.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author alliswell008
 * @ClassName: FileDemo
 * @Description: 获取CLASSPATH下文件的绝对路径
 * 当使用相对路径写入文件时候，就需要用到绝对路径。下面是个例子：
 * @date 2016/11/22 15:29
 */
public class FileDemo {

    /**
     * CLASSPATH文件的绝对路径获取测试
     *
     * @author leizhimin 2010-1-18 9:33:02
     */
    //classpath的文件路径
    private static String cp = "/a.txt";

    public static void main(String[] args) throws Exception {
        String fpath = "/D:/alliswell/workspace/WTest/Alliswell/JavaSE/src/../target/classes/test/..\\a.txt";
        File f = new File(FileDemo.class.getResource(cp).getFile());
        f = new File(fpath);
        getFileAttribute(f);
        System.out.println("============");
        getFileByClassPath();
        System.out.println("============");

        writeFileByChars(f, "明朝", true);
        String fileStr = readFileByChars(f, 1024);
        System.out.println(fileStr);
        System.out.println("============");
        writeFileByBytes(f, "黑夫曼树", true);
        readFileByBytes(f, 1024);
        System.out.println("============");
        writeFileByRandomAccess(f, "秦吏");
        readFileByRandomAccess(f);
    }

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
    }

    /**
     * 文件转换为字符串
     *
     * @param f       文件
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
     * @param in      字节流
     * @param charset 文件的字符集
     * @return 文件内容
     */
    public static String stream2String(InputStream in, String charset) {
        StringBuffer sb = new StringBuffer();
        try {
            Reader r = new InputStreamReader(in, charset);
            int length = 0;
            // 每次最多读取1024个字符
            for (char[] c = new char[1024]; (length = r.read(c)) != -1; ) {
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

    /**
     * 获取文件或目录属性
     *
     * @param file 指定的文件或目录
     */
    public static void getFileAttribute(File file) throws IOException {
        // 文件名= 前缀名+后缀名
        System.out.println("\n文件名= 前缀名+后缀名："+file.getName());

        // 文件路径
        System.out.println("\n文件路径");
        // 相对路径，相对路径创建时才可以返回相对路径，否则返回与绝对路径一样，且会包含冗余的名称，例如"."和".."
        System.out.println("文件路径："+file.getPath());
        // 绝对路径
        // 是否绝对路径
        System.out.println("是否绝对路径创建：" + file.isAbsolute());
        System.out.println("绝对路径："+file.getAbsolutePath());
        // 标准路径，会从路径名中删除冗余名称，例如"."和".."
        System.out.println("标准路径："+file.getCanonicalPath());

        // 文件大小
        System.out.println("\n文件大小："+file.length());

        // 文件最后修改时间
        System.out.println("\n文件最后修改时间："+ new Date(file.lastModified()));

        // 文件读写执行权限
        System.out.println("\n文件读写执行权限");
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());

        // 文件或目录
        System.out.println("\n文件或目录");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        // 文件或目录是否存在
        System.out.println("\n文件或目录是否存在" + file.exists());

        // 文件或目录是否隐藏
        System.out.println("\n文件或目录是否隐藏" + file.isHidden());

        // 列出可用的文件系统根
        System.out.println("\n列出可用的文件系统根");
        File[] files = File.listRoots();
        for (File f : files) {
            System.out.print(f.getPath());
            System.out.print("  总量：" + (f.getTotalSpace() / 1024 / 1024 / 1024) + "G");
            System.out.print("  余量：" + (f.getFreeSpace() / 1024 / 1024 / 1024) + "G");
            System.out.print("  可用量：" + (f.getUsableSpace() / 1024 / 1024 / 1024) + "G");
            System.out.println();
        }
    }

    /**
     * 按字符读取文件
     *
     * @param file       被读取的文件
     * @param bufferSize 缓冲区大小 小于1按1个计
     */
    public static String readFileByChars(File file, int bufferSize) {
        StringBuffer sb = new StringBuffer();
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));

            if (bufferSize < 1) {
                bufferSize = 1;
            }

            char[] buffer = new char[bufferSize];
            int length = 0;
            while ((length = reader.read(buffer)) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (length == buffer.length && buffer[buffer.length - 1] != '\r') {
//                    System.out.print(buffer);
                    sb.append(buffer, 0, length);
                } else {
                    for (int i = 0; i < length; i++) {
                        if (buffer[i] == '\r') {
                            continue;
                        } else {
//                            System.out.print(buffer[i]);
                            sb.append(buffer[i]);
                        }
                    }
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    /**
     * 按字节读取文件
     *
     * @param file       被读取的文件
     * @param bufferSize 缓冲区大小 小于1按1个计
     */
    public static void readFileByBytes(File file, int bufferSize) {
        InputStream in = null;
        try {
            in = new FileInputStream(file);

            if (bufferSize < 1) {
                bufferSize = 1;
            }

            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = in.read(buffer)) != -1) {
                System.out.write(buffer, 0, length);
            }

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 按行读取文件
     *
     * @param file 被读取的文件
     */
    public static void readFileByRows(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));

            String lineContent = null;
            int line = 1;
            while ((lineContent = reader.readLine()) != null) {
                System.out.println("line" + line + "：" + lineContent);
                line++;
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 随机访问文件读取
     *
     * @param file 被读取的文件
     */
    public static void readFileByRandomAccess(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");

            long flieLength = randomAccessFile.length();
            int beginIndex = 6;
            // 设置文件读取的开始位置
            randomAccessFile.seek(beginIndex);

            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = randomAccessFile.read(buffer)) != -1) {
                System.out.write(buffer, 0, length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 随机访问写入文件
     *
     * @param file    写入文件
     * @param content 写入的内容
     */
    public static void writeFileByRandomAccess(File file, String content) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");

            long fileLength = randomAccessFile.length();
            randomAccessFile.seek(fileLength);
            randomAccessFile.write(content.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 按字符写入文件
     *
     * @param file    写入文件
     * @param content 写入的内容
     * @param append  true：内容追加，false：内容覆盖
     */
    public static void writeFileByChars(File file, String content, boolean append) {
        try {
            FileWriter fw = new FileWriter(file, append);
            fw.write(content);
            fw.flush();

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按字节写入文件
     *
     * @param file    写入文件
     * @param content 写入的内容
     * @param append  true：内容追加，false：内容覆盖
     */
    public static void writeFileByBytes(File file, String content, boolean append) {
        try {
            FileOutputStream fos = new FileOutputStream(file, append);
            fos.write(content.getBytes());
            fos.flush();

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
