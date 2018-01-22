package com.github.KKimishima.model;

public class SiteILogic {
  public void like(SiteI siteI){
    int count = siteI.getLike();
    siteI.setLike(count + 1);
  }
  public void disLike(SiteI siteI){
    int count = siteI.getDislike();
    siteI.setDislike(count -1);
  }
}
