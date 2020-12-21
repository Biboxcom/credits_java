package com.bibox.example.websocket;

import com.bibox.credits.BiboxCreditsClient;
import com.bibox.credits.model.enums.TimeInterval;

public class SubCandlestickEvent {

    public static void main(String[] args) {
        BiboxCreditsClient client = new BiboxCreditsClient();
        String symbol = "BIX_USDT";
        client.subscribeCandlestick(symbol, TimeInterval.ONE_MINUTE, (x) -> {
            x.forEach(System.out::println);
            // ...
        });
        // client.unSubscribeCandlestickEvent(symbol,CandlestickInterval.ONE_MINUTE);
    }

}
