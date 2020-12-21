package com.bibox.example.market;

import com.bibox.credits.BiboxCreditsClient;

public class GetTrades {
    public static void main(String[] args) throws Throwable {
        BiboxCreditsClient client = new BiboxCreditsClient();
        System.out.println(client.getTrades("BTC_USDT",2));
    }
}
