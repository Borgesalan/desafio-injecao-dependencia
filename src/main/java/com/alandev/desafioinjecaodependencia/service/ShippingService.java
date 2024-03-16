package com.alandev.desafioinjecaodependencia.service;

import com.alandev.desafioinjecaodependencia.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double shipmentValue = 0.0;
        if (order.getBasic() < 100.0) {
            shipmentValue = 20.0;
        } else if (order.getBasic() < 200.0) {
            shipmentValue = 12.0;
        }
        return shipmentValue;
    }
}
