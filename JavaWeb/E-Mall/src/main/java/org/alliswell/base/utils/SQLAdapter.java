/**
 * @Title: SQLAdapter
 * @Package com.allis.core.base.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author org.alliswell
 * @date 2016/9/27 13:49
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
 */
package org.alliswell.base.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author org.alliswell
 * @ClassName: SQLAdapter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2016/9/27 13:49
 * <p/>
 * ${TAGS}
 */
public class SQLAdapter {
    String sql;
    String tableName;
    Map<String,String> params = new HashMap<String, String>();

    public SQLAdapter(String sql) {
        this.sql = sql;
    }

    public SQLAdapter(String sql, String... params) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getParams(String key)
    {
        return params.get(key);
    }

    public void setParams(String key, String value)
    {
        this.params.put(key, value);
    }

}