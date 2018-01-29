package org.alliswell.base.utils;

/**
 * Created by Administrator on 2017/12/20.
 */
public enum OrderTypeEnum {

    PAA("0", "生鲜订单"),
    PCZ("3", "充值订单"),
    PKD("6", "快递订单");

    private String key;
    private String value;

    OrderTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.key+":"+this.value;
    }
}
