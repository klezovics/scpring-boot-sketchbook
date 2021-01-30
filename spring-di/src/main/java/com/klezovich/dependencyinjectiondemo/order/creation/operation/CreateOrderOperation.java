package com.klezovich.dependencyinjectiondemo.order.creation.operation;

import com.klezovich.dependencyinjectiondemo.order.domain.Order;
import com.klezovich.dependencyinjectiondemo.order.domain.OrderType;
import com.klezovich.dependencyinjectiondemo.order.creation.request.CreateOrderRequest;
import lombok.Getter;

@Getter
public abstract class CreateOrderOperation {

    protected final OrderType orderType;

    protected CreateOrderOperation(OrderType orderType) {
        this.orderType = orderType;
    }

    public abstract Order create(CreateOrderRequest request);

    protected String createOrderId() {
        return String.valueOf(System.currentTimeMillis());
    }
}
