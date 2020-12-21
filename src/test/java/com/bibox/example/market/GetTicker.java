package com.bibox.example.market;

import com.bibox.credits.BiboxCreditsClient;

public class GetTicker {
    public static void main(String[] args) throws Throwable {
        BiboxCreditsClient client = new BiboxCreditsClient();
        System.out.println(client.getTicker("BTC_USDT"));
    }
}
