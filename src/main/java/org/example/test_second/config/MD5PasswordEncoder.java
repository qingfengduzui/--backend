package org.example.test_second.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MD5PasswordEncoder implements PasswordEncoder {

  @Override
  public String encode(CharSequence rawPassword) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(rawPassword.toString().getBytes());
      byte[] byteData = md.digest();
      // Convert the byte data to hexadecimal format
      StringBuilder sb = new StringBuilder();
      for (byte b : byteData) {
        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("MD5 algorithm not found", e);
    }
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return encode(rawPassword).equals(encodedPassword);
  }
}