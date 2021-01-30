package com.klezovich.dependencyinjectiondemo.order.creation;

import com.klezovich.dependencyinjectiondemo.order.domain.OrderType;
import com.klezovich.dependencyinjectiondemo.order.creation.request.CreateOrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@SpringBootTest
class OrderCreatorTest {

    @Autowired
    private OrderCreator creator;

    @Test
    void testOrderCreator() {
        var onlineOrder = creator.create(CreateOrderRequest.builder().type(OrderType.ONLINE).build());
        assertThat(onlineOrder.getDescription(), containsString("online"));

        var storeOrder = creator.create(CreateOrderRequest.builder().type(OrderType.STORE).build());
        assertThat(storeOrder.getDescription(), containsString("store"));
    }
}