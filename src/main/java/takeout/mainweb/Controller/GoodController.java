package takeout.mainweb.Controller;


import com.alibaba.fastjson.JSON;
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
import takeout.mainweb.component.JsonUtils;
import takeout.mainweb.component.KeyUtil;
import takeout.mainweb.entiy.Good;

import java.util.List;

@Controller
@Api("用户操作商品")
@RequestMapping("/good")

public class GoodController {

    @Autowired
    GoodMapper goodMapper;

    @ApiOperation("查找所有上架中的商品")
    @RequestMapping(value = "/findSellingGood", method = RequestMethod.GET)
    @ResponseBody
    public List<Good> findSellingGood() {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("state", "上架中");
        List<Good> list = goodMapper.selectList(wrapper);
        return list;
    }

    @ApiOperation("用户模糊搜索商品")
    @RequestMapping(value = "/searchGood/{goodName}", method = RequestMethod.GET)
    @ResponseBody
    public List<Good> findGood(@RequestParam("goodName") String goodName) {

        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.like("good_name", goodName);
        List<Good> list = goodMapper.selectList(wrapper);
        return list;
    }

    @ApiOperation("用户上传商品，等待审核")
    @RequestMapping(value = "/uploadGood", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadGood(@RequestParam("goodName") String goodName,
                             @RequestParam("price") double price,
                             @RequestParam("type") String type,
                             @RequestParam("sellerID") String sellerID) {
        String id = KeyUtil.getUniqueKey();
        Good good = new Good();
        good.setId(id);
        good.setGoodName(goodName);
        good.setPrice(price);
        good.setType(type);
        good.setSellerId(sellerID);
        good.setState("审核中");
        int insert = goodMapper.insert(good);
        return JSON.toJSONString(new JsonUtils(0, "上传成功"));
    }


    @ApiOperation("买家购买商品")
    @RequestMapping(value = "/buyGood/{goodID}", method = RequestMethod.PUT)
    @ResponseBody
    public Object buyGood(@RequestParam("goodID") String goodID,
                          @RequestParam("buyerID") String buyerID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("交易中");
        good.setBuyerId(buyerID);
        int result=goodMapper.updateById(good);
        return JSON.toJSONString(new JsonUtils(1,"开始交易"));
    }

    @ApiOperation("商品交易成功")
    @RequestMapping(value = "/GoodOver/{goodID}", method = RequestMethod.PUT)
    @ResponseBody
    public Object buyGood(@RequestParam("goodID") String goodID) {
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("交易成功");
        int result=goodMapper.updateById(good);
        return JSON.toJSONString(new JsonUtils(1,"交易成功"));
    }

}