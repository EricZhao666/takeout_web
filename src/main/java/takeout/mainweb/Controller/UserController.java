package takeout.mainweb.Controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import takeout.mainweb.Mapper.GoodMapper;
import takeout.mainweb.Mapper.UserMapper;
import takeout.mainweb.Service.LoginService;
import takeout.mainweb.component.*;
import takeout.mainweb.entiy.Good;
import takeout.mainweb.entiy.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
@Api("用户功能")
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    GoodMapper goodMapper;

    @ApiOperation("登录方法")
    @RequestMapping (value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult login(@RequestParam("username") String name,
                                @RequestParam("password") String pwd,
                                HttpServletResponse response,
                                HttpSession session){

        return loginService.login(name,pwd);

    }

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @ApiOperation("退出方法")
    @RequestMapping(value="/user/logout",method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult logout(){
        return loginService.logout();

    }

    @ApiOperation("注册方法")
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public Object regist(@RequestParam("username") String name,
                         @RequestParam("password") String pwd) {
        String id = KeyUtil.getUniqueKey();
        User user = new User(id, name, pwd, "user", "", 0);
        int insert = userMapper.insert(user);
        return JSON.toJSONString(new JsonUtils(0, "注册成功"));

    }

    @ApiOperation("卖家查看自己所有的商品（审核的，上架的，卖出的）")
    @RequestMapping(value = "/sellerGoods/{goodID}", method = RequestMethod.GET)
    @ResponseBody
    public Object sellerGoods(@RequestParam("sellerID") String sellerID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("seller_id", sellerID);
        List<Good> list = goodMapper.selectList(wrapper);
        return list;
    }

    @ApiOperation("买家查看自己所有的商品（买到的）")
    @RequestMapping(value = "/buyerGoods/{goodID}", method = RequestMethod.GET)
    @ResponseBody
    public Object buyerGoods(@RequestParam("buyerID") String buyerID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("buyer_id", buyerID);
        List<Good> list = goodMapper.selectList(wrapper);
        return list;
    }

}
