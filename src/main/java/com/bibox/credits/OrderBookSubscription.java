/*
 * Copyright (C) 2020, Bibox.com. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.bibox.credits;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bibox.credits.model.OrderBook;
import com.bibox.util.Listener;
import com.bibox.util.ZipUtils;

class OrderBookSubscription extends Subscription<OrderBook> {

    private final String symbol;
    private OrderBook orderBook;

    OrderBookSubscription(
            BiboxCreditsClient client, String symbol, Listener<OrderBook> listener) {
        super(client, listener);
        this.symbol = symbol;
    }

    static String buildChannelName(String symbol) {
        return String.format("bibox_sub_spot_%s_depth", symbol);
    }

    @Override
    String getChannel() {
        return buildChannelName(symbol);
    }

    @Override
    public OrderBook decode(JSONObject json) {
        String data = ZipUtils.unzip(json.getBytes("data"));
        JSONObject obj = JSON.parseObject(data);

        if (!obj.containsKey("add")) {
            orderBook = OrderBook.parseResult(obj);
            return orderBook;
        }
        OrderBook.updateFromEvent(orderBook, obj);
        return orderBook;
    }

    @Override
    void onData(OrderBook data) {
        //nothing
    }

    @Override
    OrderBook getData() {
        return new OrderBook(orderBook);
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("event", "addChannel");
        json.put("channel", getChannel());
        json.put("binary", 0);
        json.put("ver", 0);
        return json.toJSONString();
    }

}
