package com.bibox.example.websocket;

import com.bibox.credits.BiboxCreditsClient;

public class SubOrderBookEvent {

    public static void main(String[] args) {
        BiboxCreditsClient client = new BiboxCreditsClient();
        String symbol = "BIX_USDT";
        client.subscribeOrderBook(symbol, x -> {
            System.out.println(x.getAskBook().getPriceLevel(0));
            System.out.println(x.getBidBook().getPriceLevel(0));
            // ...
        });
    }

}
