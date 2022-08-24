package org.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.springcloud.entities.Order;

@Mapper
public interface OrderDAO {
    int create(Order payment);

    Order getBySerialNo(@Param("serialNo") String serialNo);
}
