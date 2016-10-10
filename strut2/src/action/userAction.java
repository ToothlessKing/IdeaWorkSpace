package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

/**
 * Created by Administrator on 2016-09-28.
 */
@Namespace("/")
@ResultPath(value = "/")
public class userAction {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Action(value = "Welcome",results = {
        @Result(name="success",location = "/welcome_user.jsp")
    })
    public String execute(){
        return "SUCCESS";
    }
}
