package com.talanlabs.avatargenerator.avatar.vo;

import java.awt.Image;
import java.io.Serializable;

public class AvatarResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String chartName;
  private String disclaimer;
  private Image image;

  public String getChartName() {
    return chartName;
  }

  public void setChartName(String chartName) {
    this.chartName = chartName;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public void setDisclaimer(String disclaimer) {
    this.disclaimer = disclaimer;
  }

}
