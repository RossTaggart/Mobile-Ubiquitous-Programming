package com.example.administrator.mondayschild;

import java.io.Serializable;

/**
 * Created by Ross on 19/10/2015.
 */
public class mcRSSDataItem implements Serializable{

    private String itemTitle;
    private String itemDesc;
    private String itemLink;

    public String getItemTitle()
    {
        return this.itemTitle;
    }

    public void setItemTitle(String sItemTitle)
    {
        this.itemTitle = itemTitle;
    }

    public String getItemDesc()
    {
        return this.itemDesc;
    }

    public void setItemDesc(String sItemDesc)
    {
        this.itemDesc = sItemDesc;
    }

    public String getItemLink()
    {
        return this.itemLink;
    }

    public void setItemLink(String sItemLink)
    {
        this.itemLink = sItemLink;
    }

    public mcRSSDataItem()
    {
        this.itemTitle = "";
        this.itemDesc = "";
        this.itemLink = "";
    }

    @Override
    public String toString()
    {
        String starSignRSSHoroscopeData;

        starSignRSSHoroscopeData = "mcRSSDataItem[itemTitle=" + itemTitle;
        starSignRSSHoroscopeData = "mcRSSDataDesc[itemDesc=" + itemDesc;
        starSignRSSHoroscopeData = "mcRSSDataLink[itemLink=" + itemLink;

        return starSignRSSHoroscopeData;
    }
}
