package com.klezovich.dependencyinjectiondemo.order.creation.operation;

import com.klezovich.dependencyinjectiondemo.order.domain.Order;
import com.klezovich.dependencyinjectiondemo.order.domain.OrderType;
import com.klezovich.dependencyinjectiondemo.order.creation.request.CreateOrderRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateOnlineOrderOperation extends CreateOrderOperation {

    public CreateOnlineOrderOperation() {
        super(OrderType.ONLINE);
    }

    @Override
    public Order create(CreateOrderRequest request) {
        var order = new Order();
        order.setDescription("online order");
        return order;
    }
}
