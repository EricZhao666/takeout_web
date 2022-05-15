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
import takeout.mainweb.entiy.Good;

import java.util.List;

@Controller
@RequestMapping("/checked")
@Api("管理员审核")
public class CheckController {

    @Autowired
    GoodMapper goodMapper;

    @ApiOperation("查看所有待审核商品")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Good> findAllCh(){
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("state", "审核中");
        List<Good> list = goodMapper.selectList(wrapper);
        return list;

    }

    @ApiOperation("通过ID，审核通过商品")
    @RequestMapping(value = "/checkGood", method = RequestMethod.PUT)
    @ResponseBody
    public Object checkGood(@RequestParam("goodID") String goodID){
        QueryWrapper<Good> wrapper = new QueryWrapper<>();
        wrapper.eq("id", goodID);
        Good good = goodMapper.selectOne(wrapper);
        good.setState("上架中");
        int result=goodMapper.updateById(good);
        return JSON.toJSONString(new JsonUtils(1,"审核成功"));

    }

}