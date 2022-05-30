package takeout.mainweb.Service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import takeout.mainweb.Mapper.UserMapper;
import takeout.mainweb.entiy.LoginUser;
import takeout.mainweb.entiy.User;


import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.eq("username",username);
        User user=userMapper.selectOne(wrapper);
        //user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));


        if (user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        else {
//            List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
//            return new org.springframework.security.core.userdetails.User(user.getUsername(),
//                    new BCryptPasswordEncoder().encode(user.getPassword()),auth);
            return new LoginUser(user);

        }

    }
}
