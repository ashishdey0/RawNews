package com.bokaromart.rawnews.pojo;

/**
 * Created by ashdey on 8/21/16.
 */
public class NewsCommonAttributes {
    private String pageTitle;
    private String pageLink;
    private String pageDescription;
    private String pageLanguage;
    private String pageCopyRight;
    private String pageDocs;
    private String pageAtomLink;
    private NewsPageImage newsPageImage;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public String getPageLanguage() {
        return pageLanguage;
    }

    public void setPageLanguage(String pageLanguage) {
        this.pageLanguage = pageLanguage;
    }

    public String getPageCopyRight() {
        return pageCopyRight;
    }

    public void setPageCopyRight(String pageCopyRight) {
        this.pageCopyRight = pageCopyRight;
    }

    public String getPageDocs() {
        return pageDocs;
    }

    public void setPageDocs(String pageDocs) {
        this.pageDocs = pageDocs;
    }

    public String getPageAtomLink() {
        return pageAtomLink;
    }

    public void setPageAtomLink(String pageAtomLink) {
        this.pageAtomLink = pageAtomLink;
    }

    public NewsPageImage getNewsPageImage() {
        return newsPageImage;
    }

    public void setNewsPageImage(NewsPageImage newsPageImage) {
        this.newsPageImage = newsPageImage;
    }
}
