package takeout.mainweb.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collect {  //商品收藏
    private String id;
    private String userId;
    private String goodId;
}
