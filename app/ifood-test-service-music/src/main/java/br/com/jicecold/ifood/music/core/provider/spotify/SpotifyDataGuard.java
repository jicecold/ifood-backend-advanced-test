package br.com.jicecold.ifood.music.core.provider.spotify;

import br.com.jicecold.ifood.music.core.provider.spotify.model.AccessToken;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Data
@Component
@Scope(SCOPE_SINGLETON)
public class SpotifyDataGuard {

  public static final String GRANT_TYPE = "grant_type";

  @Value("${spotify.account.token.grantType}")
  private String accountGrantType;

  @Value("${spotify.api.search.type}")
  private String searchType;

  @Value("${spotify.api.search.limit}")
  private Integer searchLimit;

  @Value("${spotify.api.search.offset}")
  private Integer searchOffset;

  private AccessToken token;

  public SpotifyDataGuard() {
    this.token = new AccessToken();
  }

  public String getOrDefaultAccountGrantType(String accountGrantType){
    return Objects.nonNull(accountGrantType)
        ? accountGrantType : this.accountGrantType;
  }

  public String getOrDefaultSearchType(String searchType){
    return StringUtils.isNoneBlank(searchType)
        ? searchType : this.searchType;
  }

  public Integer getOrDefaultSearchLimit(Integer searchLimit){
    return Objects.nonNull(searchLimit)
        ? searchLimit : this.searchLimit;
  }

  public Integer getOrDefaultSearchOffset(Integer searchOffset){
    return Objects.nonNull(searchOffset)
        ? searchOffset : this.searchOffset;
  }
}
