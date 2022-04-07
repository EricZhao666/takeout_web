package takeout.mainweb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import takeout.mainweb.entiy.User;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {



}
