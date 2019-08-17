package alliswell;

import java.io.File;
import java.io.IOException;

/**
 * 文件及目录操作工具
 *
 * @author chengxs
 * @date 2019/8/15
 */
public class FileUtil {

    /**
     * 删除目录及目录中的所有文件
     *
     * @param file 被删除的文件或目录
     * @return
     */
    public static boolean deleteFile(File file) {
        if (!file.exists()) {
            return false;
        }

        // 要删除目录，需先删除目录中的所有子文件及子目录
        if (file.isDirectory()) {
            // 防止删除文件系统根目录
            if (file.getParentFile() == null) {
                System.out.println(file.getPath() + "是文件系统根目录，不能删除");
                return false;
            }

            File[] files = file.listFiles();
            for (File f : files) {
                deleteFile(f);
            }
        }
        return file.delete();
    }

    /**
     * 创建文件
     *
     * @param file 被创建的文件
     * @return
     */
    public static boolean createFile(File file) {
        File parent = file.getParentFile();
        createDir(parent);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 创建目录
     *
     * @param dir 被创建的目录
     * @return
     */
    public static boolean createDir(File dir) {
        if (dir != null && !dir.exists() && !dir.isDirectory()) {
            return dir.mkdirs();
        }
        return false;
    }

    /**
     * 获取文件或目录对应的根目录
     *
     * @param file  文件或目录
     * @param level 对应根目录的层级 0：表示上级目录，1：表示上上级目录，以此类推
     * @return
     */
    public static File getRootDir(File file, int level) {
        File parent = file.getParentFile();
        if (parent == null) {
            return file;
        }
        while (level > 0) {
            parent = getRootDir(parent, --level);
        }
        return parent;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\11\\22\\aa.txt");
        createFile(file);

        System.out.println(getRootDir(file, 0));
        System.out.println(getRootDir(file, 1));
        System.out.println(getRootDir(file, 2));
        System.out.println(getRootDir(file, 3));
        deleteFile(getRootDir(file, 1));
    }
}
