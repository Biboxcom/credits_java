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

package com.bibox.credits.model;

import com.alibaba.fastjson.JSONObject;
import com.bibox.credits.model.enums.DepositStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter(value = AccessLevel.PROTECTED)
@ToString
public class DepositEntry {

    // 币种
    private String symbol;

    // 充值地址
    private String address;

    // 充值数量
    private BigDecimal amount;

    // 充值确认数
    private int confirmations;

    // 充值时间
    private long time;

    // 充值状态
    private DepositStatus status;

    public static DepositEntry parseResult(JSONObject obj) {
        DepositEntry a = new DepositEntry();
        a.setSymbol(obj.getString("coin_symbol"));
        a.setAddress(obj.getString("to_address"));
        a.setAmount(obj.getBigDecimal("amount"));
        a.setConfirmations(obj.getInteger("confirmCount"));
        a.setTime(obj.getLong("createdAt"));
        a.setStatus(DepositStatus.fromInteger(obj.getInteger("status")));
        return a;
    }

}
