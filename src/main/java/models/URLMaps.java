package models;

import java.util.HashMap;
import java.util.Map;

public class URLMaps {

    private Map<String, String> urlMaps = new HashMap<>();

    public URLMaps(){
        urlMaps.put("https://news.rambler.ru","https://news.rambler.ru/rss/head/");
        urlMaps.put("https://news.rambler.ru/rss/head","https://news.rambler.ru/rss/head/");
        urlMaps.put("https://lenta.ru","https://lenta.ru/rss");
        urlMaps.put("https://lenta.ru/rss","https://lenta.ru/rss");
    }

    public Map<String, String> getUrlMaps() {
        return urlMaps;
    }

    public void setUrlMaps(Map<String, String> urlMaps) {
        this.urlMaps = urlMaps;
    }
}
