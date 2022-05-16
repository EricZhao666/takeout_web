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
import takeout.mainweb.Mapper.CommentMapper;
import takeout.mainweb.component.ResponseResult;
import takeout.mainweb.entiy.Comment;

import java.util.List;

@Controller
@Api("用户操作评论")
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentMapper commentMapper;

    @ApiOperation("查找对应商品的评论")
    @RequestMapping(value = "/findComment", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult findSellingGood(@RequestParam("goodID") String goodID) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("good_id", goodID);
        List<Comment> list = commentMapper.selectList(wrapper);
        return new ResponseResult(200,"查询成功",list);
    }

    @ApiOperation("发布评论")
    @RequestMapping(value = "/findComment", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult postComment(@RequestParam("good_id") String goodID,
                                     @RequestParam("publisher_id") String publisherID,
                                     @RequestParam("content") String content) {
        Comment comment = new Comment();
        comment.setGoodId(goodID);
        comment.setPublisherId(publisherID);
        comment.setContent(content);
        int result = commentMapper.insert(comment);
        return new ResponseResult(200,"评论成功");
    }

}
