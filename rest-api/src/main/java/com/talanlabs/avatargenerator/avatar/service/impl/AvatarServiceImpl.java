package com.talanlabs.avatargenerator.avatar.service.impl;

import org.springframework.stereotype.Service;
import com.talanlabs.avatargenerator.avatar.service.AvatarService;
import com.talanlabs.avatargenerator.avatar.vo.AvatarResponse;

@Service
public class AvatarServiceImpl implements AvatarService {

  // @Value("${url}")
  // private String url;

  @Override
  public AvatarResponse getAvatar() {
    try {

      // log.debug("** GET /image called");
      //
      // Image img = cacheService.getImage();
      // if (img == null) {
      // RestTemplate restTemplate = new RestTemplate();
      // ApodImage result = restTemplate.getForObject(apodUrl + apodKey, ApodImage.class);
      // log.info("Fetched new APOD image from NASA");
      // img = new Image(result.getUrl(), result.getTitle(), result.getCopyright());
      // cacheService.putImage(img);
      // } else {
      // log.debug("Loaded APOD image from cache");
      // }
      // return img;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


}
