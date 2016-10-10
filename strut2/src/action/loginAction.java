package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

/**
 * Created by Administrator on 2016-09-28.
 */
@Namespace("/")
@ResultPath(value="/")
@Result(name="success" ,location="/login.jsp")
public class loginAction extends ActionSupport {
}
