package services;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import models.Item;
import models.URLMaps;
import utils.StringParse;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParseFeedService {

    private String url;
    private SyndFeed feed;

    public boolean isStringValid(String url){
        this.url = url;

        URLMaps urlMaps = new URLMaps();
        for (Map.Entry<String, String> entry : urlMaps.getUrlMaps().entrySet())
        {
            if (entry.getKey().equals(url)){
                return true;
            }
        }
        return false;
    }

    public List<Item> getAllItemsOfFeed(){
        List<Item> selectItems = new ArrayList<>();

        try {
            feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
        } catch (FeedException | IOException e) {
            e.printStackTrace();
        }

        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {

            Item item = new Item();
            item.setLink(entry.getLink());
            item.setDescription(entry.getDescription().getValue());
            item.setTitle(entry.getTitle());
            item.setPubDate(entry.getPublishedDate().toString());
            selectItems.add(item);
        }
        return selectItems;
    }

    public List<Item> selectionOfItems(String matchesString, List<Item> items){
        List<Item> selectItems = new ArrayList<>();

        for (Item itemOuter : items) {

            String matchesSting = matchesString;
            if (new StringParse(matchesSting, itemOuter.getDescription()).matchInText()){
                Item itemInner = new Item();
                itemInner.setLink(itemOuter.getLink());
                itemInner.setDescription(itemOuter.getDescription());
                itemInner.setTitle(itemOuter.getTitle());
                itemInner.setPubDate(itemOuter.getPubDate());
                selectItems.add(itemInner);
            }
        }
        return selectItems;
    }
}
