package alliswell.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by alliswell on 2017/9/13.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String id;
	private String name;

	private String account;
	private String passwd;
	private String personId;
	private String ctime;
	private String mtime;
}