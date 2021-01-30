package com.klezovich.dependencyinjectiondemo.order.creation.request;

import com.klezovich.dependencyinjectiondemo.order.domain.OrderType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateOrderRequest {

    private OrderType type = OrderType.ONLINE;
    private String description;
}
