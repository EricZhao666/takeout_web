package takeout.mainweb.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import takeout.mainweb.Mapper.UserMapper;
import takeout.mainweb.component.JwtUtil;
import takeout.mainweb.component.RedisCache;
import takeout.mainweb.component.ResponseResult;
import takeout.mainweb.entiy.LoginUser;
import takeout.mainweb.entiy.User;

import java.util.HashMap;
import java.util.Objects;

@Service
@Repository
public class LoginServiceImp implements LoginService{

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseResult login(String name, String pwd){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(name,pwd);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",name);
        User user=userMapper.selectOne(wrapper);
        String userId=user.getId();
        String jwt= JwtUtil.createJWT(userId);
        redisCache.setCacheObject("login:"+userId,user);
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
//        User loginUser = (User) authentication.getPrincipal();
//        String userid = loginUser.getId();
//        redisCache.deleteObject("login:"+userid);
        return new ResponseResult(200,"退出成功");
    }


}
