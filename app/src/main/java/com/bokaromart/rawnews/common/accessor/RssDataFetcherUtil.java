package com.bokaromart.rawnews.common.accessor;

import android.util.Log;

import com.bokaromart.rawnews.pojo.News;
import com.bokaromart.rawnews.pojo.NewsCommonAttributes;
import com.bokaromart.rawnews.pojo.NewsPageImage;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashdey on 8/14/16.
 */
public class RssDataFetcherUtil {
    private static final String TAG = "RssDataFetcherUtil";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String CHANNEL = "channel";
    private static final String LANGUAGE = "language";
    private static final String COPYRIGHT = "copyright";
    private static final String LINK = "link";
    private static final String ATOM = "atom:link";
    private static final String ITEM = "item";
    private static final String PUB_DATE = "pubDate";
    private static final String GUID = "guid";
    private static final String DOCS = "docs";
    private static final String IMAGE = "image";
    private static final String IMAGE_URL = "url";

    public List<News> getNews(final String feedUrl) {
        Log.d(TAG, "Inside getNews : " );
        URL url = null;
        try {
            url = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return createNewsList(url);
    }

    private List<News> createNewsList(URL url) {
        Log.d(TAG, "Inside createNewsList : " );
        return read(url);
    }

    public List<News> read(URL url) {
        List<News> newsList = new ArrayList<>();
        try {
            XmlPullParser xpp = getPullParser();
            xpp.setInput(getInputStream(url), "UTF_8");
            boolean insideItem = false;
            boolean insideChannel = false;
            boolean insideImage = false;
            int eventType = xpp.getEventType();
            News news = null;
            NewsPageImage image = null;
            NewsCommonAttributes commonAttributes = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                Log.d(TAG, "Inside while : " );
                if (eventType == XmlPullParser.START_TAG) {
                    Log.d(TAG, "Inside Start Tag : " );
                    String localName = xpp.getName().toLowerCase();
                    Log.d(TAG, "Local Name : " + localName);
                    if (localName.equalsIgnoreCase(CHANNEL)) {
                        Log.d(TAG, "Channel True : ");
                        insideChannel = true;
                        commonAttributes = new NewsCommonAttributes();
                    }
                    if (localName.equalsIgnoreCase(IMAGE)) {
                        Log.d(TAG, "Image True : ");
                        insideImage = true;
                        image = new NewsPageImage();
                    }
                    if (localName.equalsIgnoreCase(ITEM)) {
                        Log.d(TAG, "Item True : ");
                        insideItem = true;
                        news = new News();
                        newsList.add(news);
                    }
                    if (insideItem) {
                        switch (localName) {
                            case TITLE: {
                                news.setTitle(xpp.nextText());
                                Log.d(TAG, "Title is : " + news.getTitle());
                                break;
                            }
                            case LINK: {
                                news.setLink(xpp.nextText());
                                Log.d(TAG, "Link is : " + news.getLink());
                                break;
                            }
                            case DESCRIPTION: {
                                news.setDescription(xpp.nextText());
                                Log.d(TAG, "Description is : " + news.getDescription());
                                break;
                            }
                            case GUID: {
                                news.setGuid(xpp.nextText());
                                Log.d(TAG, "Guid is : " + news.getGuid());
                                break;
                            }
                            case PUB_DATE: {
                                news.setPubDate(xpp.nextText());
                                Log.d(TAG, "Pub date is : " + news.getPubDate());
                                break;
                            }

                        }
                    }
                    if (insideChannel && !insideItem && insideImage) {
                        switch (localName) {
                            case TITLE: {
                                image.setTitle(xpp.nextText());
                                break;
                            }
                            case LINK: {
                                image.setLink(xpp.nextText());
                                break;
                            }
                            case IMAGE_URL: {
                                image.setImageUrl(xpp.nextText());
                                break;
                            }
                        }
                    }
                    if (insideChannel && !insideItem && !insideImage) {
                        Log.d(TAG, "Channel Reader : ");
                        switch (localName) {
                            case TITLE: {
                                commonAttributes.setPageTitle(xpp.nextText());
                                Log.d(TAG, "Channel Title : " + commonAttributes.getPageTitle());
                                break;
                            }
                            case LINK: {
                                commonAttributes.setPageLink(xpp.nextText());
                                Log.d(TAG, "Channel Link : " + commonAttributes.getPageLink());
                                break;
                            }
                            case DESCRIPTION: {
                                commonAttributes.setPageDescription(xpp.nextText());
                                Log.d(TAG, "Channel Description : " + commonAttributes.getPageDescription
                                        ());
                                break;
                            }
                            case LANGUAGE: {
                                commonAttributes.setPageLanguage(xpp.nextText());
                                Log.d(TAG, "Channel Language : " + commonAttributes.getPageLanguage());
                                break;
                            }
                            case COPYRIGHT: {
                                commonAttributes.setPageCopyRight(xpp.nextText());
                                Log.d(TAG, "Channel CopyRight : " + commonAttributes.getPageCopyRight());
                                break;
                            }
                            case DOCS: {
                                commonAttributes.setPageDocs(xpp.nextText());
                                Log.d(TAG, "Channel Docs : " + commonAttributes.getPageDocs());
                                break;
                            }
                            case ATOM: {
                                commonAttributes.setPageAtomLink(xpp.nextText());
                                Log.d(TAG, "Channel AtomLink : " + commonAttributes.getPageAtomLink());
                                break;
                            }
                        }
                    }
                } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase
                        (ITEM)) {
                    insideItem = false;
                    news.setNewsCommonAttributes(commonAttributes);
                    Log.d(TAG, "Outside Item");
                } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase
                        (IMAGE)) {
                    insideImage = false;
                    commonAttributes.setNewsPageImage(image);

                } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase
                        (CHANNEL)) {
                    insideChannel = false;
                }

                eventType = xpp.next(); //move to next element
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    private InputStream getInputStream(URL url) {
        try {
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    private XmlPullParser getPullParser() {
        XmlPullParser xpp = null;
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            xpp = factory.newPullParser();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return xpp;
    }
}
