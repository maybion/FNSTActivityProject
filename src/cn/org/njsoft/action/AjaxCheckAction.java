package cn.org.njsoft.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.org.njsoft.model.User;
import cn.org.njsoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 2015/12/9
 * 注册的Action
 * @see cn.org.njsoft.action#AjaxCheckAction
 * @author JAQ
 */
@SuppressWarnings("serial")
@Scope("request")
@Controller("ajaxCheckAction")
public class AjaxCheckAction extends ActionSupport {
	User user = new User(); //实例化User类
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService; //UserService类型的属性

	@Override
	public String execute() throws Exception {
		 HttpServletResponse response=ServletActionContext.getResponse();//response实例化
		 PrintWriter out = response.getWriter();
		 if (userService.IscheckUser(user)){//判断userName是否存在		
			out.print(0); //userName不存在，可以注册
			out.flush();//强制请求清空缓冲区
			out.close();//关闭输出流
		} else{
			out.print(1);//userName存在，不可以注册
			out.flush();//强制请求清空缓冲区
			out.close();//关闭输出流
		}
		return null;
	}
	/**
	 * get，set 方法
	 * @return
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}			
}