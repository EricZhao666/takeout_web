package takeout.mainweb.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullGood {
    private String id;
    private String goodDescrip;
    private double price;
    private String type; //商品标签 用于推荐和展示
    private String sellerId; //卖家ID
    private String buyerId; //卖家ID
    private String state; //交易状态
    private List pictureURL;  //图片URL
    private LocalDateTime createTime;  //上架时间
    private LocalDateTime updateTime;  //交易时间
}

