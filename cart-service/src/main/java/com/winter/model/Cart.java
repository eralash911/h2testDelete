package com.winter.model;

import com.example.api.ProductDto;
import com.winter.core.entity.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Data

public class Cart {
    private BigDecimal totalPrice;
    private List<CartItem> items;

    public Cart(){
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(ProductDto product){
        for (CartItem item :
                items) {
            if (product.getId().equals(item.getProductId())){
                item.changeQuantity(1);
                recalculate();
                return;
            }
        }
        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
    }

    private void recalculate() {
        totalPrice = BigDecimal.ZERO;
        for (CartItem item : items) {
            totalPrice = totalPrice.add(item.getPrice()).setScale(2, RoundingMode.HALF_DOWN);
        }
    }

    public void increaseProd(Product product){
        for (CartItem item :
                items) {
            if (product.getId().equals(item.getProductId())) { //TODO разобраться с equals
                item.setQuantity(item.getQuantity() + 1);
                recalculate();
                return;
            }
            }
    }

    public void decrement(Long product) {
        Iterator<CartItem> iter = items.iterator();
        while (iter.hasNext()) {
            CartItem o = iter.next();
            if (product.getId().equals(o.getProductId())) {
                o.changeQuantity(-1);
                if (o.getQuantity() <= 0) {
                    iter.remove();
                }
                recalculate();
                return;
            }
        }
    }

    public void merge(Cart another) {
        for (CartItem anotherItem : another.items) {
            boolean merged = false;
            for (CartItem myItem : items) {
                if (myItem.getProductId().equals(anotherItem.getProductId())) {
                    myItem.changeQuantity(anotherItem.getQuantity());
                    merged = true;
                    break;
                }
            }
            if (!merged) {
                items.add(anotherItem);
            }
        }
        recalculate();
        another.clear();
    }





    public void remove(Long productId) {
        items.removeIf(o -> o.getProductId().equals(productId));
        recalculate();
    }

    public void clear(){
        items.clear();
        setTotalPrice(BigDecimal.valueOf(0));
    }

    private void setTotalPrice(BigDecimal valueOf) {
    }


}
