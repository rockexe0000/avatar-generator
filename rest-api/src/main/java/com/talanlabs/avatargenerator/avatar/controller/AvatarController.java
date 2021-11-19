package com.talanlabs.avatargenerator.avatar.controller;

import java.awt.image.BufferedImage;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.avatar.service.AvatarService;
import com.talanlabs.avatargenerator.avatar.service.AvatarShowing;
import com.talanlabs.avatargenerator.cat.CatAvatar;

@RestController
@RequestMapping("avatar")
public class AvatarController {
  @Autowired
  private AvatarService avatarService;



  @GetMapping("aaa")
  public String getAAA() {
    return "aaa";
  }



  // @GetMapping("get")
  // @GetMapping(path = "/get", produces = "image/png")
  @GetMapping(value = "/get", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getAvatar(@RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h,
      @RequestParam(name = "id", required = false) String id) {
    try {

      if (w == null || w < 1) {
        w = 1;
      }
      if (h == null || h < 1) {
        h = 1;
      }

      if (id == null) {
        id = "";
      }

      String s = id;
      long code = UUID.nameUUIDFromBytes(s.getBytes()).getMostSignificantBits();

      System.out.println("w=[" + w + "]");
      System.out.println("h=[" + h + "]");
      System.out.println("id=[" + id + "]");
      System.out.println("code=[" + code + "]");

      Avatar avatar = CatAvatar.newAvatarBuilder().build();

      BufferedImage bufferedImage = AvatarShowing.getAvatar(avatar, code, w, h);



      return bufferedImage;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }


}
