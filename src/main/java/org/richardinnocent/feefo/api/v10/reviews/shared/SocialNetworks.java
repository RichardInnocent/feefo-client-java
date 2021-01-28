package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class SocialNetworks {

  @JsonProperty("facebook")
  private String facebookPage;

  @JsonProperty("twitter")
  private String twitterPage;

  @JsonProperty("google_plus")
  private String googlePlusPage;

  public String getFacebookPage() {
    return facebookPage;
  }

  public void setFacebookPage(String facebookPage) {
    this.facebookPage = facebookPage;
  }

  public String getGooglePlusPage() {
    return googlePlusPage;
  }

  public void setGooglePlusPage(String googlePlusPage) {
    this.googlePlusPage = googlePlusPage;
  }

  public String getTwitterPage() {
    return twitterPage;
  }

  public void setTwitterPage(String twitterPage) {
    this.twitterPage = twitterPage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SocialNetworks that = (SocialNetworks) o;
    return Objects.equals(facebookPage, that.facebookPage)
        && Objects.equals(twitterPage, that.twitterPage)
        && Objects.equals(googlePlusPage, that.googlePlusPage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(facebookPage, twitterPage, googlePlusPage);
  }
}
