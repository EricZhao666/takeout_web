package takeout.mainweb.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import takeout.mainweb.entiy.Order;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
