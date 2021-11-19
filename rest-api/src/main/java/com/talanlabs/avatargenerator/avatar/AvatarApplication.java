package com.talanlabs.avatargenerator.avatar;

import java.awt.image.BufferedImage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
@EnableJpaAuditing
public class AvatarApplication {

  @Bean
  public HttpMessageConverter<BufferedImage> bufferedImageHttpMessageConverter() {
    // log.debug("Registering BufferedImage converter");
    return new BufferedImageHttpMessageConverter();
  }

  public static void main(String[] args) {
    SpringApplication.run(AvatarApplication.class, args);
  }

}
