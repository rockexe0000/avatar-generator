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
import com.talanlabs.avatargenerator.GitHubAvatar;
import com.talanlabs.avatargenerator.IdenticonAvatar;
import com.talanlabs.avatargenerator.SquareAvatar;
import com.talanlabs.avatargenerator.TriangleAvatar;
import com.talanlabs.avatargenerator.avatar.service.AvatarService;
import com.talanlabs.avatargenerator.avatar.service.AvatarShowing;
import com.talanlabs.avatargenerator.cat.CatAvatar;
import com.talanlabs.avatargenerator.eightbit.EightBitAvatar;
import com.talanlabs.avatargenerator.smiley.SmileyAvatar;

@RestController
@RequestMapping("avatar")
public class AvatarController {

  @Autowired
  private AvatarService avatarService;


  @GetMapping("aaa")
  public String getAAA() {
    return "aaa";
  }



  @GetMapping(value = "/cat", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getCatAvatar(@RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(CatAvatar.newAvatarBuilder().build(), id, w, h);
  }

  @GetMapping(value = "/eightbit/male", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getEightBitMaleAvatar(@RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(EightBitAvatar.newMaleAvatarBuilder().build(), id, w, h);
  }

  @GetMapping(value = "/eightbit/female", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getEightBitFemaleAvatar(
      @RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(EightBitAvatar.newFemaleAvatarBuilder().build(), id, w, h);
  }


  @GetMapping(value = "/github", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getGitHubAvatar(@RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(GitHubAvatar.newAvatarBuilder().build(), id, w, h);
  }



  @GetMapping(value = "/identicon", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getIdenticonAvatar(@RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(IdenticonAvatar.newAvatarBuilder().build(), id, w, h);
  }



  @GetMapping(value = "/smiley/accessories", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSmileyAccessoriesAvatar(
      @RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(SmileyAvatar.newAccessoriesAvatarBuilder().build(), id, w, h);
  }

  @GetMapping(value = "/smiley/eyemouth", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSmileyEyeMouthAvatar(
      @RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(SmileyAvatar.newEyeMouthAvatarBuilder().build(), id, w, h);
  }

  @GetMapping(value = "/smiley/ghost", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSmileyGhostAvatar(@RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(SmileyAvatar.newGhostAvatarBuilder().build(), id, w, h);
  }

  @GetMapping(value = "/smiley/default", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSmileyDefaultAvatar(
      @RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(SmileyAvatar.newDefaultAvatarBuilder().build(), id, w, h);
  }



  @GetMapping(value = "/square", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSquareAvatar(@RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(SquareAvatar.newAvatarBuilder().build(), id, w, h);
  }


  @GetMapping(value = "/triangle", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getTriangleAvatar(@RequestParam(name = "id", required = false) String id,
      @RequestParam(name = "w", required = false) Integer w,
      @RequestParam(name = "h", required = false) Integer h) {

    return getAvatar(TriangleAvatar.newAvatarBuilder().build(), id, w, h);
  }



  private BufferedImage getAvatar(Avatar avatar, String id, Integer w, Integer h) {
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


      System.out.println("id=[" + id + "]");
      System.out.println("code=[" + code + "]");
      System.out.println("w=[" + w + "]");
      System.out.println("h=[" + h + "]");


      BufferedImage bufferedImage = AvatarShowing.getAvatar(avatar, code, w, h);



      return bufferedImage;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }



}
