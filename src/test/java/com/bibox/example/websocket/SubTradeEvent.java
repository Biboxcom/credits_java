package com.bibox.example.websocket;

import com.bibox.credits.BiboxCreditsClient;

public class SubTradeEvent {

    public static void main(String[] args) {
        BiboxCreditsClient client = new BiboxCreditsClient();
        String symbol = "BIX_USDT";
        client.subscribeTrade(symbol, (x) -> {
            x.forEach(System.out::println);
            // ...
        });
        // client.unSubscribeTradeEvent(symbol);
    }

}
