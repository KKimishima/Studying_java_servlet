package com.github.KKimishima.iineModel;

import java.io.Serializable;

public class SiteI implements Serializable{
  private int like;
  private int dislike;
  public SiteI(){
    this.like =0;
    this.dislike =0;
  }

  public int getLike() {
    return like;
  }

  public int getDislike() {
    return dislike;
  }

  public void setDislike(int dislike) {
    this.dislike = dislike;
  }

  public void setLike(int like) {
    this.like = like;
  }
}
