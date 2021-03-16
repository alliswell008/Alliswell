package alliswell.demo.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2020/12/29
 */
public class NioTest {
    public static void main(String[] args) {
        Path path = Paths.get("2.png");
        System.out.println(path);
    }
}
