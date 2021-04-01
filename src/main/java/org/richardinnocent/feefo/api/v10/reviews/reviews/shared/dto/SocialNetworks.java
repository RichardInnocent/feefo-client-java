package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Contains social network sharing information.
 */
public class SocialNetworks {

  @JsonProperty("facebook")
  private String facebookShareLink;

  @JsonProperty("twitter")
  private String twitterShareLink;

  @JsonProperty("google_plus")
  private String googlePlusShareLink;

  /**
   * Gets the link to share the resource on Facebook.
   * @return The link to share the resource on Facebook.
   */
  public String getFacebookShareLink() {
    return facebookShareLink;
  }

  /**
   * Sets the link to share the resource on Facebook.
   * @param facebookShareLink The link to share the resource on Facebook.
   */
  public void setFacebookShareLink(String facebookShareLink) {
    this.facebookShareLink = facebookShareLink;
  }

  /**
   * Gets the link to share the resource on Google+.
   * @return The link to share the resource on Google+.
   */
  public String getGooglePlusShareLink() {
    return googlePlusShareLink;
  }

  /**
   * Sets the link to share the resource on Google+.
   * @param googlePlusShareLink The link to share the resource on Google+.
   */
  public void setGooglePlusShareLink(String googlePlusShareLink) {
    this.googlePlusShareLink = googlePlusShareLink;
  }

  /**
   * Gets the link to share the resource on Twitter.
   * @return The link to share the resource on Twitter.
   */
  public String getTwitterShareLink() {
    return twitterShareLink;
  }

  /**
   * Sets the link to share the resource on Twitter.
   * @param twitterShareLink The link to share the resource on Twitter.
   */
  public void setTwitterShareLink(String twitterShareLink) {
    this.twitterShareLink = twitterShareLink;
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
    return Objects.equals(facebookShareLink, that.facebookShareLink)
        && Objects.equals(twitterShareLink, that.twitterShareLink)
        && Objects.equals(googlePlusShareLink, that.googlePlusShareLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(facebookShareLink, twitterShareLink, googlePlusShareLink);
  }
}
