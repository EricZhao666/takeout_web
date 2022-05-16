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
import takeout.mainweb.component.ResponseResult;
import takeout.mainweb.entiy.Good;
import takeout.mainweb.entiy.Order;

import java.util.List;

import static takeout.mainweb.component.KeyUtil.getUniqueKey;

@Controller
@Api("用户操作商品")
@RequestMapping("/good")

public class GoodController {

    @Autowired
    GoodMapper goodMapper;

    @Autowired
    OrderMapper orderMapper;


    @ApiOperation("查找所有上架中的商品")
    @RequestMapping(value = "/findSellingGood", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findSellingGood() {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("state", "上架中");
        List<Good> list = goodMapper.selectList(wrapper);
        return new ResponseResult(200,"查询成功",list);
    }

    @ApiOperation("用户模糊搜索商品")
    @RequestMapping(value = "/searchGood/{goodName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findGood(@RequestParam("goodName") String goodName) {

        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.like("good_name", goodName);
        List<Good> list = goodMapper.selectList(wrapper);
        return new ResponseResult(200,"查询成功",list);
    }

    @ApiOperation("用户上传商品，等待审核")
    @RequestMapping(value = "/uploadGood", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult uploadGood(@RequestParam("goodName") String goodName,
                             @RequestParam("price") double price,
                             @RequestParam("type") String type,
                             @RequestParam("sellerID") String sellerID) {
        String id = getUniqueKey();
        Good good = new Good();
        good.setId(id);
        good.setGoodName(goodName);
        good.setPrice(price);
        good.setType(type);
        good.setSellerId(sellerID);
        good.setState("审核中");
        int insert = goodMapper.insert(good);
        return new ResponseResult(200,"上传成功");
    }


    @ApiOperation("买家购买商品,创造订单")
    @RequestMapping(value = "/buyGood/{goodID}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult buyGood(@RequestParam("goodID") String goodID,
                          @RequestParam("buyerID") String buyerID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("交易中");
        good.setBuyerId(buyerID);
        int result = goodMapper.updateById(good);

        Order order = new Order();
        order.setId(getUniqueKey());
        order.setGoodId(good.getId());
        order.setGoodName(good.getGoodName());
        order.setPrice(good.getPrice());
        order.setType(good.getType());
        order.setSellerId(good.getSellerId());
        order.setBuyerId(good.getBuyerId());
        order.setState(good.getState());
        int result2 = orderMapper.insert(order);

        return new ResponseResult(200,"开始交易");
    }

    @ApiOperation("买家/卖家取消订单，系统帮卖家重新上架商品")
    @RequestMapping(value = "/cancelOrder/{goodID}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult cancelOrder(@RequestParam("goodID") String goodID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("上架中");
        good.setBuyerId(null);
        int result = goodMapper.updateById(good);

        QueryWrapper<Order> wrapper2 = new QueryWrapper<>();
        wrapper.eq("good_id", goodID)
                .eq("state", "交易中");
        Order order = orderMapper.selectOne(wrapper2);
        order.setState("交易关闭");
        int result2 = orderMapper.updateById(order);

        return new ResponseResult(200,"订单取消，商品重新上架");
    }

    @ApiOperation("卖家下架商品（此时商品还没有买家拍下）")
    @RequestMapping(value = "/offGood/{goodID}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult offGood(@RequestParam("goodID") String goodID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("商品下架");
        int result = goodMapper.updateById(good);

        QueryWrapper<Order> wrapper2 = new QueryWrapper<>();
        wrapper.eq("good_id", goodID)
                .eq("state", "交易中");
        Order order = orderMapper.selectOne(wrapper2);
        order.setState("交易关闭");
        int result2 = orderMapper.updateById(order);

        return new ResponseResult(200,"商品下架成功");
    }

    @ApiOperation("商品交易成功")
    @RequestMapping(value = "/GoodOver/{goodID}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult buyGood(@RequestParam("goodID") String goodID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("交易成功");
        int result = goodMapper.updateById(good);

        QueryWrapper<Order> wrapper2 = new QueryWrapper<>();
        wrapper.eq("good_id", goodID)
                .eq("state", "交易中");
        Order order = orderMapper.selectOne(wrapper2);
        order.setState("交易成功");
        int result2 = orderMapper.updateById(order);

        return new ResponseResult(200,"商品交易成功");
    }

}
