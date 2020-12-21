package com.bibox.example.market;

import com.bibox.credits.BiboxCreditsClient;

public class GetCurrencyPair {
    public static void main(String[] args) throws Throwable {
        BiboxCreditsClient client = new BiboxCreditsClient();
        System.out.println(client.getCurrencyPair());
    }
}
