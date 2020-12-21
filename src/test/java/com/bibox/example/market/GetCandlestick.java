package com.bibox.example.market;

import com.bibox.credits.BiboxCreditsClient;
import com.bibox.credits.model.Candlestick;
import com.bibox.credits.model.enums.TimeInterval;

import java.util.List;

public class GetCandlestick {
    public static void main(String[] args) throws Throwable {
        BiboxCreditsClient client = new BiboxCreditsClient();
        List<Candlestick> haveLimit = client.getCandlestick("BTC_USDT",
                TimeInterval.WEEKLY, 10);
        List<Candlestick> noLimit = client.getCandlestick("BTC_USDT", TimeInterval.DAILY);
        System.out.println(haveLimit);
        System.out.println(noLimit);
    }
}
