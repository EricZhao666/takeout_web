package takeout.mainweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import takeout.mainweb.Mapper.UserMapper;
import takeout.mainweb.entiy.User;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserInfo(String username){
        return userMapper.getUserByUsername(username);
    }
}
