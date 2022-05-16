package takeout.mainweb.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import takeout.mainweb.Mapper.GoodMapper;
import takeout.mainweb.Mapper.OrderMapper;
import takeout.mainweb.Mapper.UserMapper;
import takeout.mainweb.component.ResponseResult;
import takeout.mainweb.entiy.Good;
import takeout.mainweb.entiy.Order;
import takeout.mainweb.entiy.User;

import java.util.List;

@Controller
@RequestMapping("/checked")
@Api("管理员功能")
public class AdminController {

    @Autowired
    GoodMapper goodMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;

    @ApiOperation("查看所有商品")
    @RequestMapping(value = "/findAllGood", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findAllGood() {
        List<Good> list = goodMapper.selectList(null);
        return new ResponseResult(200,"查询成功",list);
    }

    @ApiOperation("查看所有订单")
    @RequestMapping(value = "/findAllOrder", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findAllOrder() {
        List<Order> list = orderMapper.selectList(null);
        return new ResponseResult(200,"查询成功",list);
    }

    @ApiOperation("查看所有用户")
    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findAllUser() {
        List<User> list = userMapper.selectList(null);
        return new ResponseResult(200,"查询成功",list);
    }

    @ApiOperation("查看所有待审核商品")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findAllCh() {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("state", "审核中");
        List<Good> list = goodMapper.selectList(wrapper);
        return new ResponseResult(200,"查询成功",list);

    }

    @ApiOperation("管理员通过ID搜索商品")
    @RequestMapping(value = "/searchGoodByID/{goodID}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findGoodByID(@RequestParam("goodID") String goodID) {

        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        List<Good> list = goodMapper.selectList(wrapper);
        return new ResponseResult(200,"查询成功",list);
    }

    @ApiOperation("管理员通过ID搜索用户")
    @RequestMapping(value = "/searchUserByID/{userID}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findUserByID(@RequestParam("userID") String userID) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userID);
        List<User> list = userMapper.selectList(wrapper);
        return new ResponseResult(200,"查询成功",list);
    }

    @ApiOperation("通过ID，审核通过商品")
    @RequestMapping(value = "/checkGood", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult checkGood(@RequestParam("goodID") String goodID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("上架中");
        int result = goodMapper.updateById(good);
        return new ResponseResult(200,"审核成功，商品上架");

    }

    @ApiOperation("通过ID，审核不通过商品")
    @RequestMapping(value = "/checkBadGood", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult checkBadGood(@RequestParam("goodID") String goodID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("审核不通过");
        int result = goodMapper.updateById(good);

        String sellerID = good.getSellerId();
        QueryWrapper<User> wrapper2 = new QueryWrapper<>();
        wrapper.eq("id", sellerID);
        User user = userMapper.selectOne(wrapper2);
        user.setFail(user.getFail() + 1);
        int result2 = userMapper.updateById(user);

        return new ResponseResult(200,"审核不通过，商品等待修改");

    }

}