package alliswell.demo.switchdemo;

/**
 * @Title: switchdemo
 * @Package alliswell.demo
 * @Description: TODO(用一句话来说明)
 * @Author Administrator
 * @CreateDate 2019/5/20 16:53
 * @Version V1.0
 * <p>
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
public class SwitchDemo {

    public static void main(String[] args) {
        // 不允许long、float、double、Long、Float、Double和自定义类型
        // byte
        byte b = "1".getBytes()[0];
        switch (b) { }
        // char
        switch ('1') { }
        // short
        switch ((short)1) { }
        // int
        switch (1) { }
        // Byte
        switch (new Byte("1")) { }
        // Character
        switch (new Character('1')) { }
        // Short
        switch (new Short("1")) { }
        // Integer
        switch (new Integer("1")) { }
        // String
        switch ("1") { }
        // Enum
        switch (State.OK) { }
    }

    enum State {
        OK, Error
    }

}
