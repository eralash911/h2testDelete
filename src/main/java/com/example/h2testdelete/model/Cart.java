package com.example.h2testdelete.model;

import com.example.h2testdelete.entity.Product;
import lombok.Data;

import java.util.*;

@Data

public class Cart {
    private int totalPrice;
    private List<CartItem> items;

    public Cart(){
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(Product product){
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
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
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

    public void decrement(Product product) {
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
        totalPrice = 0;
    }



}
