package com.talanlabs.avatargenerator.avatar.controller;

import java.awt.image.BufferedImage;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.talanlabs.avatargenerator.Avatar.AvatarBuilder;
import com.talanlabs.avatargenerator.GitHubAvatar;
import com.talanlabs.avatargenerator.IdenticonAvatar;
import com.talanlabs.avatargenerator.SquareAvatar;
import com.talanlabs.avatargenerator.TriangleAvatar;
import com.talanlabs.avatargenerator.avatar.service.AvatarService;
import com.talanlabs.avatargenerator.avatar.service.AvatarShowing;
import com.talanlabs.avatargenerator.cat.CatAvatar;
import com.talanlabs.avatargenerator.eightbit.EightBitAvatar;
import com.talanlabs.avatargenerator.smiley.SmileyAvatar;
import io.swagger.annotations.ApiParam;

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
  public BufferedImage getCatAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(CatAvatar.newAvatarBuilder(), id, w, h, width, height);
  }

  @GetMapping(value = "/eightbit/male", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getEightBitMaleAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(EightBitAvatar.newMaleAvatarBuilder(), id, w, h, width, height);
  }

  @GetMapping(value = "/eightbit/female", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getEightBitFemaleAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(EightBitAvatar.newFemaleAvatarBuilder(), id, w, h, width, height);
  }


  @GetMapping(value = "/github", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getGitHubAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(GitHubAvatar.newAvatarBuilder(), id, w, h, width, height);
  }



  @GetMapping(value = "/identicon", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getIdenticonAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(IdenticonAvatar.newAvatarBuilder(), id, w, h, width, height);
  }



  @GetMapping(value = "/smiley/accessories", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSmileyAccessoriesAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(SmileyAvatar.newAccessoriesAvatarBuilder(), id, w, h, width, height);
  }

  @GetMapping(value = "/smiley/eyemouth", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSmileyEyeMouthAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(SmileyAvatar.newEyeMouthAvatarBuilder(), id, w, h, width, height);
  }

  @GetMapping(value = "/smiley/ghost", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSmileyGhostAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(SmileyAvatar.newGhostAvatarBuilder(), id, w, h, width, height);
  }

  @GetMapping(value = "/smiley/default", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSmileyDefaultAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(SmileyAvatar.newDefaultAvatarBuilder(), id, w, h, width, height);
  }



  @GetMapping(value = "/square", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getSquareAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(SquareAvatar.newAvatarBuilder(), id, w, h, width, height);
  }

  @GetMapping(value = "/triangle", produces = MediaType.IMAGE_PNG_VALUE)
  public BufferedImage getTriangleAvatar(
      @ApiParam(value = "序號", required = false) @RequestParam(name = "id",
          required = false) String id,
      @ApiParam(value = "產生行數", required = false) @RequestParam(name = "w",
          required = false) Integer w,
      @ApiParam(value = "產生列數", required = false) @RequestParam(name = "h",
          required = false) Integer h,
      @ApiParam(value = "圖片寬度", required = false) @RequestParam(name = "width",
          required = false) Integer width,
      @ApiParam(value = "圖片高度", required = false) @RequestParam(name = "height",
          required = false) Integer height) {

    return getAvatar(TriangleAvatar.newAvatarBuilder(), id, w, h, width, height);
  }



  private BufferedImage getAvatar(AvatarBuilder avatarBuilder, String id, Integer w, Integer h,
      Integer width, Integer height) {
    try {

      if (id == null) {
        id = "";
      }

      if (w == null || w < 1) {
        w = 1;
      }

      if (h == null || h < 1) {
        h = 1;
      }

      if (width == null || width < 1) {
        width = 128;
      }

      if (height == null || height < 1) {
        height = 128;
      }



      String s = id;
      long code = UUID.nameUUIDFromBytes(s.getBytes()).getMostSignificantBits();


      System.out.println("id=[" + id + "]");
      System.out.println("code=[" + code + "]");
      System.out.println("w=[" + w + "]");
      System.out.println("h=[" + h + "]");


      BufferedImage bufferedImage =
          AvatarShowing.getAvatar(avatarBuilder.size(width, height).build(), code, w, h);



      return bufferedImage;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }



}
