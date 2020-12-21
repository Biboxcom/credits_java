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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(value = AccessLevel.PROTECTED)
@ToString
public class Position {

    // 仓位名称
    private String symbol;

    // 可用资产
    private BigDecimal available;

    // 借款
    private BigDecimal loan;

    // 可借
    private BigDecimal borrowingLimit;

    // 当前保证金率
    private BigDecimal currentMargin;

    // 最大杠杠
    private int maxLeverage;

    // 当前杠杠
    private int currentLeverage;

    // 爆仓价格
    private BigDecimal liquidationPrice;

    // 维持保证金率
    private BigDecimal maintenanceMargin;

    // 币种资产
    private List<SubAccount> assets = new ArrayList<>();

    @Getter
    @Setter(value = AccessLevel.PROTECTED)
    @ToString
    public static class SubAccount {

        // 资产名称
        private String asset;

        // 可用
        private BigDecimal available;

        // 冻结
        private BigDecimal freeze;

        // 利息
        private BigDecimal interest;

        // 借款
        private BigDecimal loan;

    }

    public static Position parseResult(JSONObject obj) {
        Position a = new Position();
        a.setSymbol(obj.getString("pair"));
        a.setAvailable(obj.getBigDecimal("currency_deposit"));
        a.setLoan(obj.getBigDecimal("currency_borrow"));
        a.setBorrowingLimit(obj.getBigDecimal("currency_can_borrow"));
        a.setCurrentMargin(obj.getBigDecimal("margin_radio").divide(BigDecimal.valueOf(100)));
        a.setMaxLeverage(obj.getInteger("max_leverage_ratio"));
        a.setCurrentLeverage(obj.getInteger("current_leverage_radio"));
        a.setLiquidationPrice(obj.getBigDecimal("force_price"));
        a.setMaintenanceMargin(obj.getBigDecimal("force_deal_radio").divide(BigDecimal.valueOf(100)));
        JSONArray arr = obj.getJSONArray("items");
        for (int i = 0; i < arr.size(); i++) {
            JSONObject item = arr.getJSONObject(i);
            SubAccount s = new SubAccount();
            s.setAsset(item.getString("coin_symbol"));
            s.setAvailable(item.getBigDecimal("balance"));
            s.setLoan(item.getBigDecimal("borrow"));
            s.setFreeze(item.getBigDecimal("freeze"));
            s.setInterest(item.getBigDecimal("interest"));
            a.getAssets().add(s);
        }
        return a;
    }

}
