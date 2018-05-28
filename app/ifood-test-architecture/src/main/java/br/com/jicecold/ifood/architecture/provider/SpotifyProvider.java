package br.com.jicecold.ifood.architecture.provider;

import br.com.jicecold.ifood.architecture.provider.model.spotify.AccessToken;
import br.com.jicecold.ifood.architecture.provider.model.spotify.Search;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class SpotifyProvider {

  public static final String HTTPS_API_SPOTIFY_COM_V1_SEARCH = "https://api.spotify.com/v1/search";

  @Autowired
  private RestTemplate restTemplate;

  public AccessToken requestAccessToken() {

    HttpHeaders headers = createHeaders("4146471ddea843fb8db97bd77231ce48", "db8425e1a93f4dbe98a82ea6937f457c");
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("grant_type", "client_credentials");

    ResponseEntity<AccessToken> response = restTemplate.exchange("https://accounts.spotify.com/api/token", HttpMethod.POST,
        new HttpEntity<MultiValueMap>(map, headers), AccessToken.class);

    return response.getBody();
  }

  public Search searchTracksByType(String query, AccessToken token) {
    HttpHeaders headers = new HttpHeaders();
    headers.set(AUTHORIZATION, token.getTokenType() + " " + token.getAccessToken());
    HttpEntity<String> entity = new HttpEntity<>(headers);

    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(HTTPS_API_SPOTIFY_COM_V1_SEARCH);

    builder.queryParam("type", "track");
    builder.queryParam("q", query);
    builder.queryParam("market", "BR");
    builder.queryParam("limit", 50);

    ResponseEntity<Search> response = restTemplate.exchange(builder.buildAndExpand().toUri(),
        HttpMethod.GET, entity, Search.class);

    return response.getBody();
  }

  HttpHeaders createHeaders(String username, String password) {
    return new HttpHeaders() {{
      String auth = username + ":" + password;
      byte[] encodedAuth = Base64.encodeBase64(
          auth.getBytes(Charset.forName("US-ASCII")));
      String authHeader = "Basic " + new String(encodedAuth);
      set(AUTHORIZATION, authHeader);
    }};
  }

}
