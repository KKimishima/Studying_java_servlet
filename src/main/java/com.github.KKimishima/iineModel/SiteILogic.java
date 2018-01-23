package com.github.KKimishima.iineModel;

import com.github.KKimishima.iineModel.SiteI;

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
