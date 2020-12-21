<h1 align="center">Welcome to Bibox Credits Client 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-v1.0.0-blue.svg?cacheSeconds=2592000" />
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

> Bibox平台信用(杠杆)交易Java版本SDK

### 🏠 [Homepage](https://www.bibox.me/v2/exchange)

## Dependency

```sh
需要 jdk1.8+
```

## Usage

```sh
// 公开的api 获取kline
BiboxFuturesClient client = new BiboxFuturesClient();
List<Candlestick> res = client.getCandlestick("BTC_USD", CandlestickInterval.WEEKLY,10);
System.out.println(res);
        
// 用户的api 转入/转出信用账户
String apiKey = "use your apiKey";
String secretKey = "use your secretKey";
BiboxSpotsClient client = new BiboxSpotsClient(apiKey, secretKey);
client.transferIn("USDT", BigDecimal.valueOf(0.1));
client.transferOut("USDT", BigDecimal.valueOf(0.1));

// 用户的api 借款   
String apiKey = "use your apiKey";
String secretKey = "use your secretKey";
BiboxCreditsClient client = new BiboxCreditsClient(apiKey, secretKey);
client.borrow("USDT", BigDecimal.valueOf(1), "BTC_USDT");    

// 用户的api 还款
String apiKey = "use your apiKey";
String secretKey = "use your secretKey";
BiboxCreditsClient client = new BiboxCreditsClient(apiKey, secretKey);
client.refund("USDT", BigDecimal.valueOf(3.1), "BTC_USDT");

// 用户的api 下单
String apiKey = "use your apiKey";
String secretKey = "use your secretKey";
LimitOrder limitOrder = new LimitOrder();
limitOrder.setSymbol("ETH_USDT");
limitOrder.setQuantity(BigDecimal.valueOf(0.01));
limitOrder.setSide(TradeSide.BID);
limitOrder.setPrice(BigDecimal.valueOf(540));
limitOrder.setMode(MarginMode.ISOLATED);
String orderId = client.placeOrder(limitOrder);
System.out.println("the limit order_id: " + orderId);
        
// 公开的订阅 订阅kline
BiboxSpotsClient client = new BiboxSpotsClient();
List<Candlestick> res = client.getCandlestick("BTC_USDT", TimeInterval.DAILY);
System.out.println(res);
        
// 用户的订阅 用户订阅与委托相关的信息
String apiKey = "use your apiKey";
String secretKey = "use your secretKey";
BiboxFuturesClient client = new BiboxSpotsClient(apiKey, secretKey);
client.subscribeAccount(x -> {
     x.subscribeOrder(System.out::println);
     // ...
});
        
// 更多的可以参考测试用例
```

## Author

👤 **Biboxcom**

* Website: https://github.com/Biboxcom
* Github: [@Biboxcom](https://github.com/Biboxcom)

## Show your support

Give a ⭐️ if this project helped you!