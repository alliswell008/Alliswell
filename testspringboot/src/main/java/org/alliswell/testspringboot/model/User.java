package org.alliswell.testspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alliswell on 2017/9/13.
 */
//@JsonIgnoreProperties({ "ctime", "mtime" })
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.ALWAYS)
public class User {
    private String name;

    private String id;
    private String account;
    private String passwd;
    private String personId;
    private String ctime;
    @SerializedName(value = "Mtime")
    private String mtime;
    private int age;
//    @JsonProperty(value = "RMB")
    private Double Money = null;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }
    @JsonIgnore
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//    @JsonIgnore
    public Double getMoney() {
        return Money;
    }
//    @JsonIgnore
    public void setMoney(Double money) {
        this.Money = money;
    }
}