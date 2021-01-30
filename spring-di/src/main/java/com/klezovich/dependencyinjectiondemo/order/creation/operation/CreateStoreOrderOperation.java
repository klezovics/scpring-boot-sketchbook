package com.klezovich.dependencyinjectiondemo.order.creation.operation;

import com.klezovich.dependencyinjectiondemo.order.domain.Order;
import com.klezovich.dependencyinjectiondemo.order.domain.OrderType;
import com.klezovich.dependencyinjectiondemo.order.creation.request.CreateOrderRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateStoreOrderOperation extends CreateOrderOperation {

    public CreateStoreOrderOperation() {
        super(OrderType.STORE);
    }

    @Override
    public Order create(CreateOrderRequest request) {
        var order = new Order();
        order.setDescription("store order");
        return order;
    }
}
