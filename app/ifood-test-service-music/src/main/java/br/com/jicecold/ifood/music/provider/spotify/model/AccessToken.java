package br.com.jicecold.ifood.music.provider.spotify.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class AccessToken {

  @JsonProperty("access_token")
  String accessToken;

  @JsonProperty("token_type")
  String tokenType;

  @JsonProperty("expires_in")
  Integer expiresIn;

  @JsonIgnore
  ZonedDateTime dateOfRequest;

  public AccessToken() {
    this.dateOfRequest = ZonedDateTime.now();
  }

}
