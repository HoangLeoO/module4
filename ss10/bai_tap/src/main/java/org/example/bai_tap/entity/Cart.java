package org.example.bai_tap.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product,Integer> products) {
        this.products = products;
    }

    public Map<Product,Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    public void setProductQuantity(Product product, int quantity) {

        // 1. Nếu số lượng mới <= 0, ta xóa sản phẩm khỏi giỏ hàng
        if (quantity <= 0) {

            // Vì Key là đối tượng Product, ta cần tìm đối tượng Key chính xác
            // để đảm bảo HashMap hoạt động (do vấn đề equals/hashCode).
            Map.Entry<Product, Integer> entryToRemove = selectItemInCart(product);

            if (entryToRemove != null) {
                // Xóa sản phẩm ra khỏi Map
                this.products.remove(entryToRemove.getKey());
            }

        } else {
            // 2. Nếu số lượng > 0, ta đặt lại số lượng mới

            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);

            if (itemEntry != null) {
                // Thay thế số lượng cũ bằng số lượng mới
                products.replace(itemEntry.getKey(), quantity);
            }
            // Trường hợp sản phẩm chưa có trong giỏ hàng (hiếm khi xảy ra khi update)
            // Ta có thể thêm nó vào với số lượng mới
            else {
                products.put(product, quantity);
            }
        }
    }
}