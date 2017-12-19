package org.enania.chessstats.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.HeaderGroup;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {

    private HttpClient client;
    private HttpGet request;
    String content = "";

    public String getResponse(String url){
        client = HttpClientBuilder.create().build();
        request = new HttpGet(url);

        try {
            request.setHeaders(getHeaders());

            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            // Read the contents of an entity and return it as a String.
            content = EntityUtils.toString(entity);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    private Header[] getHeaders(){
        HeaderGroup headergroup = new HeaderGroup();

        headergroup.updateHeader(new BasicHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Mobile Safari/537.36"));
        headergroup.updateHeader(new BasicHeader("Cookie", "__gads=ID=20dd4f38e0d652af:T=1463184301:S=ALNI_Maw7o_WyuH6tWYqsl4Ko0KZH6bqPQ; sc_is_visitor_unique=rx10502233.1467582291.0F298E3441B54FFA3F7B590D530BF73C.5.5.5.4.4.4.2.2.1; __uis=ab233143-c596-5330-aa5b-ec1dc1efd850; localeEditionShown_en=true; permutive-id=688c8100-8053-4fd2-b9d5-ff39fb6c97a3; vg=cdb4a62d-98c7-4093-a8ae-98bca7d4ffb9; ip=3097585185; permutive-session=%7B%22session_id%22%3A%22c25469e5-b003-4cd0-b857-bda1f25253b9%22%2C%22last_updated%22%3A%222017-09-16T16%3A25%3A47.788Z%22%7D; _psegs=%5B1920%2C1930%2C2126%2C2137%2C1907%2C2441%2C2300%5D; __atuvc=0%7C42%2C0%7C43%2C0%7C44%2C0%7C45%2C1%7C46; visid_incap_774904=0IXyLmhQSZuau6mzUjtvmsaDMlcAAAAAQ0IPAAAAAACAfjF9AUo5mBJLDcjaoHszGt2/N2UgScVy; _ga=GA1.2.685398370.1462928332; _gid=GA1.2.2076104392.1513352612; incap_ses_531_774904=4AOGIemMIxDnIHTXPX5eBy88N1oAAAAAQJOP5ZMRMWtDoQ2ijYyWIg=="));

        return headergroup.getAllHeaders();
    }

}
