package com.klezovich.dependencyinjectiondemo.order.creation;

import com.klezovich.dependencyinjectiondemo.order.domain.Order;
import com.klezovich.dependencyinjectiondemo.order.domain.OrderType;
import com.klezovich.dependencyinjectiondemo.order.creation.operation.CreateOrderOperation;
import com.klezovich.dependencyinjectiondemo.order.creation.request.CreateOrderRequest;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;

@Component
public class OrderCreator {

    private EnumMap<OrderType, CreateOrderOperation> orderTypeToCreationOperation = new EnumMap<>(OrderType.class);

    public OrderCreator(List<CreateOrderOperation> createOrderOperations) {
        createOrderOperations.stream()
                .forEach(op -> orderTypeToCreationOperation.put(op.getOrderType(), op));
    }

    public Order create(CreateOrderRequest request) {
        return orderTypeToCreationOperation.get(request.getType()).create(request);
    }
}
