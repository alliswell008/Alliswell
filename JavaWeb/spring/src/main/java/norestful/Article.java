package norestful;

import lombok.Data;

import java.util.Date;

@Data
public class Article {

    private Long id;
    private String title;
    private Long userId;
    private Date createTime;
    private Date updateTime;
    private Date publicTime;
    private int status;
    private int type;
    private String summary;
}
