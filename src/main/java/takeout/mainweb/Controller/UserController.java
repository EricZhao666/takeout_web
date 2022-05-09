package takeout.mainweb.Controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import takeout.mainweb.Mapper.UserMapper;
import takeout.mainweb.Service.LoginService;
import takeout.mainweb.component.JsonUtils;
import takeout.mainweb.component.MD5Util;
import takeout.mainweb.component.ResponseResult;
import takeout.mainweb.component.UuidTool;
import takeout.mainweb.entiy.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Api("登录注册")
public class UserController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("登录方法")
    @PostMapping (value = "/login")
    @ResponseBody
    public ResponseResult login(@RequestParam("username") String name,
                                @RequestParam("password") String pwd,
                                HttpServletResponse response,
                                HttpSession session){

        return loginService.login(name,pwd);

    }

}
