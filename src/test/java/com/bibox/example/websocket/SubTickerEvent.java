package com.bibox.example.websocket;

import com.bibox.credits.BiboxCreditsClient;

public class SubTickerEvent {

    public static void main(String[] args) {
        BiboxCreditsClient client = new BiboxCreditsClient();
        // 处理业务逻辑
        String symbol = "BIX_USDT";
        client.subscribeTicker(symbol, x -> {
            System.out.println(x);
            // ...
        });
        // client.unSubscribeTickerEvent(symbol);
    }

}
