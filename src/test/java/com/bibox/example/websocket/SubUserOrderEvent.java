package com.bibox.example.websocket;

import com.bibox.credits.BiboxCreditsClient;

public class SubUserOrderEvent {

    public static void main(String[] args) {
        String apiKey = "2aa4a99148c65c4dbaed3a9718c87f83fc5d333e";
        String secretKey = "a05f00a59a1ffbf7e3a88b10f0e658e6a77ba474";
        BiboxCreditsClient client = new BiboxCreditsClient(apiKey, secretKey);
        client.subscribeOrder(x -> {
            x.forEach(System.out::println);
            // ...
        });
    }

}
