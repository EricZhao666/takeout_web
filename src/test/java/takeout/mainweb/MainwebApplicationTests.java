package takeout.mainweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static takeout.mainweb.component.KeyUtil.getUniqueKey;

@SpringBootTest
    class MainwebApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(getUniqueKey());
    }

}
