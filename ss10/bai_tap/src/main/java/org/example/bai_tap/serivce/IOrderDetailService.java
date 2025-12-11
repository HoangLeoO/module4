package org.example.bai_tap.serivce;

import org.example.bai_tap.entity.OrderDetail;

import java.util.Optional;

public interface IOrderDetailService {

    Optional<OrderDetail> findById(Long id);

    void save(OrderDetail orderDetail);

}
