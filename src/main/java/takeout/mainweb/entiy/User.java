package takeout.mainweb.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private String password;
    private String role;
    private String contact; //联系方式
    private Integer fail; //审核失败次数
}
