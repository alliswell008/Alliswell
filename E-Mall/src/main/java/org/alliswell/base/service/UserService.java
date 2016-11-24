package org.alliswell.base.service;

/*
 * Powered By [njtc]
 * Web Site: http://nj.taichuan.com
 * Since 2016 - 2016
 */


/**
* The Service Interface, for future extend
 * @author njtc
 * @create 2016-09-28*/
public interface UserService<T> {

    public void saveUser(Object dto);
    public void delUser(Object dto);
    public void updUser(Object dto);
    public void queryUser(Object dto);
}