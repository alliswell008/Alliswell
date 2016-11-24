/**
 * @Title: datatypedemo
 * @Package org.org.alliswell.demo
 * @Description: Java基本数据类型的字节数
 * @author alliswell008
 * @date 2016/11/22 17:17
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.datatypedemo;

/**
 * @author alliswell008
 * @ClassName: datatypedemo
 * @Description: Java基本数据类型的字节数,Boolean类型无此属性
 * @date 2016/11/22 17:17
 */
public class DataTypeDemo {

    public static void main(String[] args) {
       getDataTypeLength();

    }

    public static void getDataTypeLength() {
        System.out.println("Byte:       " + Byte.SIZE/8     );
        System.out.println("Character:  " + Character.SIZE/8);
        System.out.println("Integer:    " + Integer.SIZE/8  );
        System.out.println("Short:      " + Short.SIZE/8    );
        System.out.println("Long:       " + Long.SIZE/8     );
        System.out.println("Float:      " + Float.SIZE/8    );
        System.out.println("Double:     " + Double.SIZE/8   );
        System.out.println(Boolean.compare(true,false));
    }
}

