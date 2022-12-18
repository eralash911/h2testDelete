import com.winter.core.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrderService orderService;


    @Test
    public void createTest(){
        Assertions.assertArrayEquals(1, 1);
    }
}
