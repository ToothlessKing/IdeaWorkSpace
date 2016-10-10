package action;

/**
 * Created by Administrator on 2016-09-27.
 */
public class HelloWorld  {
    public final static String MESSAGE = "struts is running .." ;

    private  String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String execute() throws Exception{
        setMessage(MESSAGE);
        return "SUCCESS";
    }
}
