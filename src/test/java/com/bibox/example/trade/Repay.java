package com.bibox.example.trade;

import com.bibox.credits.BiboxCreditsClient;

import java.math.BigDecimal;

public class Repay {

    public static void main(String[] args) throws Throwable {
        String apiKey = "2aa4a99148c65c4dbaed3a9718c87f83fc5d333e";
        String secretKey = "a05f00a59a1ffbf7e3a88b10f0e658e6a77ba474";
        BiboxCreditsClient client = new BiboxCreditsClient(apiKey, secretKey);
        client.repay("USDT", BigDecimal.valueOf(3.1), "BTC_USDT");
    }


}
