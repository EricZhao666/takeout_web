package takeout.mainweb.entiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int publisherID;
    private String time;
    private int goodID;
    private int content;
}
