package br.com.jicecold.ifood.music.provider.spotify;

import br.com.jicecold.ifood.music.provider.spotify.model.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

@Slf4j
public class SpotifyContextTest {

  private SpotifyContext spotifyContext;

  @Before
  public void setUp() {
    spotifyContext = new SpotifyContext();
    AccessToken token = new AccessToken();
    token.setAccessToken("NgCXRKc...MzYjw");
    token.setTokenType("bearer");
    token.setExpiresIn(3600);
    spotifyContext.setToken(token);
  }

  @Test
  public void verifyWhenAccessTokenIsValid(){
    log.info("If total (request date + expires seconds) is greater than now, then token is valid");
    Assert.assertTrue(spotifyContext.verifyIfAccessTokenIsValid());
  }

  @Test
  public void verifyWhenAccessTokenIsNotValid(){
    log.info("If total (request date + expires seconds) is lower than now, then token is invalid");
    AccessToken token = spotifyContext.getToken();
    token.setDateOfRequest(LocalDateTime.now().minusHours(1));
    Assert.assertFalse(spotifyContext.verifyIfAccessTokenIsValid());
  }

}
