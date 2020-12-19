package alliswell;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class CompareUtil {

    public static void main(String[] args) throws Exception {

        User u1 = new User("张三", 20);
        User u2 = new User("张三", 21);
        CompareUtil.compare(u1, u2);
    }

    public static <T, K> void compare(T beforeObj, K afterObj) throws Exception {
        Field[] declaredFields = beforeObj.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {

            System.out.println(declaredField.getName());
        }
        Method[] declaredMethods = beforeObj.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            String methodName = declaredMethod.getName();
            System.out.println(methodName);
            if (methodName.contains("get")) {
                Method beforeMethod = beforeObj.getClass().getMethod(methodName);
                Method afterMethod = afterObj.getClass().getMethod(methodName);

                Object beforeInvoke = beforeMethod.invoke(beforeObj);
                Object afterInvoke = afterMethod.invoke(afterObj);
                System.out.println(beforeInvoke);
                System.out.println(afterInvoke);

                if (beforeInvoke != afterInvoke && !beforeInvoke.equals(afterInvoke)) {
                    System.out.println("值发生了变更");
                    DataLog dataLog = new DataLog();
                    dataLog.setBatchNo("");

                    dataLog.setTableName(beforeObj.getClass().getSimpleName());
                    dataLog.setTableKeyName("");
                    dataLog.setTableKeyValue("");

                    dataLog.setColumnName(methodName.replace("get", "").toLowerCase());

                    dataLog.setBeforeValue(beforeInvoke.toString());
                    dataLog.setAfterValue(afterInvoke.toString());
                    dataLog.setOperateName("操作人");
                    dataLog.setOperateTime(LocalDateTime.now());
                    System.out.println(dataLog);
                }
            }
        }
    }
}

class User {

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Long id;

    private String name;

    private int age;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}

class DataLog {
    private Long id;
    private String batchNo;
    private String tableName;

    private String tableKeyName;
    private String tableKeyValue;

    private String columnName;

    private String beforeValue;
    private String afterValue;

    private String operateName;
    private LocalDateTime operateTime;

    public Long getId() {
        return id;
    }

    public DataLog setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public DataLog setBatchNo(String batchNo) {
        this.batchNo = batchNo;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public DataLog setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getTableKeyName() {
        return tableKeyName;
    }

    public DataLog setTableKeyName(String tableKeyName) {
        this.tableKeyName = tableKeyName;
        return this;
    }

    public String getTableKeyValue() {
        return tableKeyValue;
    }

    public DataLog setTableKeyValue(String tableKeyValue) {
        this.tableKeyValue = tableKeyValue;
        return this;
    }

    public String getColumnName() {
        return columnName;
    }

    public DataLog setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public String getBeforeValue() {
        return beforeValue;
    }

    public DataLog setBeforeValue(String beforeValue) {
        this.beforeValue = beforeValue;
        return this;
    }

    public String getAfterValue() {
        return afterValue;
    }

    public DataLog setAfterValue(String afterValue) {
        this.afterValue = afterValue;
        return this;
    }

    public String getOperateName() {
        return operateName;
    }

    public DataLog setOperateName(String operateName) {
        this.operateName = operateName;
        return this;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public DataLog setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
        return this;
    }

    @Override
    public String toString() {
        return "DataLog{" +
                "id=" + id +
                ", batchNo='" + batchNo + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableKeyName='" + tableKeyName + '\'' +
                ", tableKeyValue='" + tableKeyValue + '\'' +
                ", columnName='" + columnName + '\'' +
                ", beforeValue='" + beforeValue + '\'' +
                ", afterValue='" + afterValue + '\'' +
                ", operateName='" + operateName + '\'' +
                ", operateTime=" + operateTime +
                '}';
    }
}