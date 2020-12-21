package com.bibox.example.trade;

import com.bibox.credits.BiboxCreditsClient;
import com.bibox.credits.FillQuery;
import com.bibox.credits.Pager;
import com.bibox.credits.model.Fill;

import java.util.List;

public class GetFills {

    public static void main(String[] args) throws Throwable {
        String apiKey = "2aa4a99148c65c4dbaed3a9718c87f83fc5d333e";
        String secretKey = "a05f00a59a1ffbf7e3a88b10f0e658e6a77ba474";
        BiboxCreditsClient client = new BiboxCreditsClient(apiKey, secretKey);
        List<Fill> fills = client.getFills("13095183486817244");
        System.out.println(fills);

        //按条件查询
        FillQuery query = new FillQuery();
        query.setBase("BTC");
        Pager<Fill> pfs = client.getFills(query);
        System.out.println(pfs);
    }
}
