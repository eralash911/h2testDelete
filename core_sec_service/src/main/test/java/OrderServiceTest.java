import com.example.api.CartDto;
import com.example.api.CartItemDto;
import com.winter.core.entity.Order;
import com.winter.core.integrations.CartServiceIntegration;
import com.winter.core.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @MockBean
    private CartServiceIntegration cartServiceIntegration;



    @Test
    public void createTest(){
        CartDto cartDto = new CartDto();
        List<CartDto> items = new ArrayList<>();
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setPricePerProduct(22);
        cartItemDto.setProductTitle("Juce");
        cartItemDto.getQuantity(2);
        cartItemDto.setPrice(44);
        cartDto.setProductId(13002L);
        cartDto.setItems(List.of(cartItemDto));


        Mockito.doReturn(cartDto).when(cartServiceIntegration).getCurrentCart();
        Order order = orderService.createOrder("bob");

        Assertions.assertEquals(order.getTotalPrice(), 100);
    }
}
