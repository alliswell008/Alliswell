/**
 * @Title: Log4jDemo
 * @Package org.alliswell.demo.log4jdemo
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/12/13 11:09
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.log4jdemo;

import org.apache.log4j.HTMLLayout;

public class DefineLayOut extends HTMLLayout {
    @Override
    public String getContentType() {
        // 修改编码方式
        return "text/html;charset=UTF-8";
    }
}
