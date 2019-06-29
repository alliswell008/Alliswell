package alliswell.demo.spi;

import java.util.ServiceLoader;

/**
 * SPI 全称为 (Service Provider Interface) ,是JDK内置的一种服务提供发现机制。
 *
 * 其运行流程是运用java.util.ServiceLoader这个类的load方法，去目录/META-INF/services/寻找对应的全路径接口名称的文件，
 * 然后在文件中找到对应的实现类全名并注入实现
 */
public class SPITest {

    public static void main(String[] args) throws Exception {
        ServiceLoader<DogService> loaders = ServiceLoader.load(DogService.class);
        for (DogService d : loaders) {
            d.sleep();
        }
    }
}