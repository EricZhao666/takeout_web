package takeout.mainweb.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import takeout.mainweb.entiy.User;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where username = #{username}")
     User getUserByUsername(String username);


}
