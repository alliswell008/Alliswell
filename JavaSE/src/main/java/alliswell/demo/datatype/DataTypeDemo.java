/**
 * @Title: datatype
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
package alliswell.demo.datatype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alliswell008
 * @ClassName: datatype
 * @Description: Java基本数据类型的字节数,Boolean类型无此属性
 * @date 2016/11/22 17:17
 */
public class DataTypeDemo {

    public static void main(String[] args) {
       getDataTypeLength();
       Map<String,String> s = new HashMap<String,String>();
        s.put("o2oInfo1","{\"State\":true,\"Code\":0,\"Msg\":null,\"Data\":{\"privateHost\":\"http://pricloud.taichuan.com\",\"House\":{\"ID\":\"9521\",\"Name\":\"测试\",\"Mobile\":\"13613613666\",\"Account\":\"13613613666\",\"Password\":\"e10adc3949ba59abbe56e057f20f883e\",\"Address\":null,\"RegMethod\":2,\"LastModifyTime\":\"2016-12-01 02:09:26\",\"Gender\":1,\"Mail\":null,\"QQ\":null,\"HeadImage\":null,\"IdentityNo\":null,\"BirthDay\":\"2016-11-30 20:26:33\",\"NickName\":null,\"Creator\":\"taichuan\",\"UHomePassword\":null,\"IdentityType\":99,\"IsAudited\":true,\"AccountSid\":\"cNqUJHYL4uAdI7rb92kA==\",\"DefaultRoomId\":\"R16113000066\"}}}");
        s.put("o2oInfo2","{\"State\":true,\"Code\":0,\"Msg\":null,\"Data\":{\"Token\":\"c8c2f705652a4406b68db68fb72f3955\",\"House\":{\"ID\":\"9521\",\"Name\":\"测试\",\"Mobile\":\"13613613666\",\"Account\":\"13613613666\",\"Password\":\"e10adc3949ba59abbe56e057f20f883e\",\"Address\":null,\"RegMethod\":2,\"LastModifyTime\":\"2016-12-01 02:09:26\",\"Gender\":1,\"Mail\":null,\"QQ\":null,\"HeadImage\":null,\"IdentityNo\":null,\"BirthDay\":\"2016-11-30 20:26:33\",\"NickName\":null,\"Creator\":\"taichuan\",\"UHomePassword\":null,\"IdentityType\":99,\"IsAudited\":true,\"AccountSid\":\"cNqUJHYL4uAdI7rb92kA==\",\"DefaultRoomId\":\"R16113000066\"},\"PriRoomView\":{\"ID\":\"R16113000066\",\"CO_ID\":\"CO16113000003\",\"CS_ID\":\"CS16113000005\",\"Name\":\"406室\",\"LastModifyTime\":\"2016-11-30 16:48:38\",\"Creator\":\"admin\",\"AccountSidRoom\":\"cNqUJHYL4uAdI7rb92kA==\",\"COName\":\"南京太川\",\"CSName\":\"1号楼1单元\",\"FullName\":\"1号楼1单元\",\"AreaName\":\"雨花台区\",\"AddressR\":\"1号楼1单元406室\",\"ORID\":\"10000\",\"RHIsAudited\":true}}}");
        String s1 = s.get("o2oInfo1");
        String s2 = s.get("o2oInfo2");
       System.out.println(s);
       System.out.println(s1);
       System.out.println(s2);
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

