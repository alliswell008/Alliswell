package alliswell;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象属性工具类
 *
 * @author chengxs
 * @date 2020/12/7
 */
public class AttributeUtil {

    public static final String SERIAL_VERSION_UID = "serialVersionUID";

    /**
     * 比较两个对象的属性，并返回发生变更的属性集合
     *
     * @param beforeObj 变更前
     * @param afterObj  变更后
     * @param <T>
     */
    public static <T> List<Attribute> compare(T beforeObj, T afterObj) {
        return compare(beforeObj, afterObj, beforeObj.getClass());
    }

    /**
     * 比较两个对象的指定属性，并返回发生变更的属性集合
     *
     * @param oldObj 变更前
     * @param newObj 变更后
     * @param clazz  指定的属性类 TODO 可以改为字符串数组
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> List<Attribute> compare(T oldObj, K newObj, Class<?> clazz) {
        List<Attribute> list = new ArrayList();
        if (clazz == null) {
            clazz = oldObj.getClass();
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            // 泛型跳过或serialVersionUID属性跳过
            if (field.getGenericType() instanceof ParameterizedType || SERIAL_VERSION_UID.equals(fieldName)) {
                continue;
            }

            Object oldValue = getFieldValue(oldObj, fieldName);
            Object newValue = getFieldValue(newObj, fieldName);

            if ((oldValue == null && oldValue != newValue) || (oldValue != null && !oldValue.equals(newValue))) {
                Attribute<String, Object> result = new Attribute<>(field.getName(), oldValue, newValue);
                list.add(result);
            }
        }

        return list;
    }

    /**
     * 获取实例对象的属性值
     *
     * @param obj       实例对象
     * @param fieldName 属性名
     * @param <T>
     * @return
     */
    private static <T> Object getFieldValue(T obj, String fieldName) {
        Field field;
        Object fieldValue = null;
        try {
            field = obj.getClass().getDeclaredField(fieldName);
            if (null != obj && null != field) {
                field.setAccessible(true);
                fieldValue = field.get(obj);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
        return fieldValue;
    }

    public static class Attribute<K, T> {
        K key;
        T oldValue;
        T newValue;

        public Attribute() {
        }

        public Attribute(K key, T oldValue, T newValue) {
            this.key = key;
            this.oldValue = oldValue;
            this.newValue = newValue;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public T getOldValue() {
            return oldValue;
        }

        public void setOldValue(T oldValue) {
            this.oldValue = oldValue;
        }

        public T getNewValue() {
            return newValue;
        }

        public void setNewValue(T newValue) {
            this.newValue = newValue;
        }

        @Override
        public String toString() {
            return "Attribute{" +
                    "key=" + key +
                    ", oldValue=" + oldValue +
                    ", newValue=" + newValue +
                    '}';
        }
    }
}
