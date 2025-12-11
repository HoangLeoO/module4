package org.example.bai_tap.controller;

import org.example.bai_tap.entity.Cart;
import org.example.bai_tap.entity.OrderDetail;
import org.example.bai_tap.entity.Product;
import org.example.bai_tap.serivce.IProductService;
import org.example.bai_tap.serivce.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Optional;

@Controller
public class OrderDetailController {
    @Autowired
    private  IProductService productService;


    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

//    @GetMapping("/order-detail")
//    public String showOrderDetail(){
//        return "order-detail";
//    }

    @PostMapping("/order-detail")
    public String saveOrderDetail(@SessionAttribute("cart") Cart cart){
        Map<Product,Integer> products = cart.getProducts();
        for(Product product : products.keySet()){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(product);
            orderDetail.setUnitPrice(0);
            orderDetail.setQuantity(products.get(product));
            orderDetailService.save(orderDetail);
        }
        cart.getProducts().clear();
        return "redirect:/shop";
    }

    @PostMapping("/card/update/{id}") // Dùng POST để thay đổi trạng thái
    public String setQuantity(
            @PathVariable Long id,
            @ModelAttribute("cart") Cart cart,
            @RequestParam("quantity") int newQuantity) {

        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        Product product = productOptional.get();
        cart.setProductQuantity(product, newQuantity);

        return "redirect:/shopping-cart";
    }
}
