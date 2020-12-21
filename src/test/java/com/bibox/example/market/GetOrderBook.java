package com.bibox.example.market;

import com.bibox.credits.BiboxCreditsClient;
import com.bibox.credits.model.OrderBook;

public class GetOrderBook {
    public static void main(String[] args) throws Throwable {
        BiboxCreditsClient client = new BiboxCreditsClient();
        OrderBook orderBook = client.getOrderBook("BTC_USDT");

        // ask1->askN
        orderBook.getAskBook().iterator().forEachRemaining(priceLevel ->
                System.out.println("the ask: " + priceLevel)
        );
        // bid1->bidN
        orderBook.getBidBook().iterator().forEachRemaining(priceLevel ->
                System.out.println("the bid: " + priceLevel)
        );

        // ...
    }
}
