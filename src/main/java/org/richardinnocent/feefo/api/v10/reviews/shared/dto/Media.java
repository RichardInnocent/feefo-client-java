package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.richardinnocent.feefo.api.util.Undocumented;

/**
 * Contains details on media attached to a review.
 */
public class Media {

  private String id;

  private MediaType type;

  private String url;

  @JsonProperty("thumbnail")
  private String thumbnailUrl;

  private String caption;

  @JsonProperty("helpful_votes")
  private int helpfulVotes;

  @Undocumented
  private String carouselUrl;

  @Undocumented
  @JsonProperty("social")
  private SocialNetworks socialNetworks;

  @Undocumented
  private boolean removed;

  /**
   * Gets the ID of the media item.
   * @return The ID of the media item.
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the ID of the media item.
   * @param id The ID of the media item.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the type of media attached.
   * @return The type of media attached.
   */
  public MediaType getType() {
    return type;
  }

  /**
   * Sets the type of media attached.
   * @param type The type of media attached.
   */
  public void setType(MediaType type) {
    this.type = type;
  }

  /**
   * Gets the URL to the media item.
   * @return The URL to the media item.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Sets the URL to the media item.
   * @param url The URL to the media item.
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Gets the URL to the static video thumbnail. This is only present if
   * {@code getType == MediaType.VIDEO}.
   * @return The URL to the static video thumbnail.
   */
  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  /**
   * Sets the URL to the static video thumbnail.
   * @param thumbnailUrl The URL to the static video thumbnail.
   */
  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  /**
   * Gets the consumer-provided caption for the media item.
   * @return The consumer-provided caption for the media item.
   */
  public String getCaption() {
    return caption;
  }

  /**
   * Sets the consumer-provided caption for the media item.
   * @param caption The consumer-provided caption for the media item.
   */
  public void setCaption(String caption) {
    this.caption = caption;
  }

  /**
   * Gets the number of helpful votes that the media item has received.
   * @return The number of helpful votes that the media item has received.
   */
  public int getHelpfulVotes() {
    return helpfulVotes;
  }

  /**
   * Sets the number of helpful votes that the media item has received.
   * @param helpfulVotes The number of helpful votes that the media item has received.
   */
  public void setHelpfulVotes(int helpfulVotes) {
    this.helpfulVotes = helpfulVotes;
  }

  @Undocumented
  public String getCarouselUrl() {
    return carouselUrl;
  }

  @Undocumented
  public void setCarouselUrl(String carouselUrl) {
    this.carouselUrl = carouselUrl;
  }

  /**
   * Gets the social network share links for this media item.
   * @return The social network share links for this media item.
   */
  @Undocumented
  public SocialNetworks getSocialNetworks() {
    return socialNetworks;
  }

  /**
   * Sets the social network share links for this media item.
   * @param socialNetworks The social network share links for this media item.
   */
  @Undocumented
  public void setSocialNetworks(SocialNetworks socialNetworks) {
    this.socialNetworks = socialNetworks;
  }

  @Undocumented
  public boolean isRemoved() {
    return removed;
  }

  @Undocumented
  public void setRemoved(boolean removed) {
    this.removed = removed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Media media = (Media) o;
    return helpfulVotes == media.helpfulVotes
        && Objects.equals(id, media.id)
        && Objects.equals(type, media.type)
        && Objects.equals(url, media.url)
        && Objects.equals(thumbnailUrl, media.thumbnailUrl)
        && Objects.equals(caption, media.caption)
        && Objects.equals(carouselUrl, media.carouselUrl)
        && Objects.equals(socialNetworks, media.socialNetworks)
        && removed == media.removed;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        id, type, url, thumbnailUrl, caption, helpfulVotes, carouselUrl, socialNetworks, removed
    );
  }
}
