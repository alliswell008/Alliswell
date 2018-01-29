package org.alliswell.demo.uuiddemo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/9.
 */
public class UuidDemo {

    public static void main(String[] args) {
        String uuid = generateShortUuid();
        System.out.println(uuid);

        Map<String, String> map = new HashMap<String, String>();
        for (long i = 0; i < 10000; i++) {
            uuid = generateShortUuid();
            map.put(uuid, uuid);
        }
        System.out.println("====" + map.size());

        String keyId = UUID.randomUUID().toString().replace("-","");

        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        System.out.println(hashCodeV);
        String id = String.format("%s", hashCodeV);

        System.out.println(id);
        System.out.println(id.length());

        String uuidStr=UUID.nameUUIDFromBytes("18325695338".getBytes()).toString().replace("-", "").substring(16);
        System.out.println(uuidStr);
        System.out.println(uuidStr.length());

        uuidStr=UUID.nameUUIDFromBytes("APP170927000003_18325695338".getBytes()).toString().replace("-", "").substring(16);
        System.out.println(uuidStr);
        System.out.println(uuidStr.length());
        uuidStr=UUID.nameUUIDFromBytes("APP170719000001_18325695338".getBytes()).toString().replace("-", "").substring(16);
        System.out.println(uuidStr);
        System.out.println(uuidStr.length());
    }


    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };


    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }
}
