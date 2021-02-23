package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains feedback information. This will not contain personally identifiable or
 * business-sensitive information, so can be returned from unauthenticated requests.
 */
public class SimpleFeedback {

  private Rating rating;
  private String id;
  private String review;

  @JsonProperty("created_at")
  private OffsetDateTime creationTime;

  @JsonProperty("helpful_votes")
  private Integer helpfulVotes;

  private final List<Media> media = new ArrayList<>();

  private Sentiment sentiment;

  /**
   * Gets the rating that was assigned to the feedback.
   * @return The rating that was assigned to the feedback.
   */
  public Rating getRating() {
    return rating;
  }

  /**
   * Sets the rating that was assigned to the feedback.
   * @param rating The rating that was assigned to the feedback.
   */
  public void setRating(Rating rating) {
    this.rating = rating;
  }

  /**
   * Gets the feedback ID.
   * @return The feedback ID.
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the feedback ID.
   * @param id The feedback ID.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the consumer's review.
   * @return The consumer's review.
   */
  public String getReview() {
    return review;
  }

  /**
   * Sets the consumer's review.
   * @param review The consumer's review.
   */
  public void setReview(String review) {
    this.review = review;
  }

  /**
   * Gets the time that the feedback was left.
   * @return The time that the feedback was left.
   */
  public OffsetDateTime getCreationTime() {
    return creationTime;
  }

  /**
   * Sets tht time that the feedback was left.
   * @param creationTime The time that the feedback was left.
   */
  public void setCreationTime(OffsetDateTime creationTime) {
    this.creationTime = creationTime;
  }

  /**
   * Gets the number of helpful votes that the feedback has received.
   * @return The number of helpful votes that the feedback has received.
   */
  public Integer getHelpfulVotes() {
    return helpfulVotes;
  }

  /**
   * Sets the number of helpful votes that the feedback has received.
   * @param helpfulVotes The number of helpful votes that the feedback has received.
   */
  public void setHelpfulVotes(Integer helpfulVotes) {
    this.helpfulVotes = helpfulVotes;
  }

  /**
   * Gets the media attached to the feedback.
   * @return The media attached to the feedback.
   */
  public List<Media> getMedia() {
    return new ArrayList<>(media);
  }

  /**
   * Sets the media attached to the feedback.
   * @param media The media attached to the feedback.
   */
  public void setMedia(List<Media> media) {
    this.media.clear();
    if (media != null) {
      this.media.addAll(media);
    }
  }

  /**
   * Gets the sentiment information for this review. This will not be {@code null} if the merchant
   * does not have
   * <a href="https://www.feefo.com/en/business/products/smart-themes">Smart Themes</a> enabled, or
   * if the request didn't specifically enable enhanced insight.
   * @return The sentiment information for this review.
   * @see Sentiment
   */
  public Sentiment getSentiment() {
    return sentiment;
  }

  /**
   * Sets the sentiment information for this review.
   * @param sentiment The sentiment information for this review.
   */
  public void setSentiment(Sentiment sentiment) {
    this.sentiment = sentiment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimpleFeedback feedback = (SimpleFeedback) o;
    return Objects.equals(helpfulVotes, feedback.helpfulVotes)
        && Objects.equals(rating, feedback.rating)
        && Objects.equals(id, feedback.id)
        && Objects.equals(review, feedback.review)
        && Objects.equals(creationTime, feedback.creationTime)
        && Objects.equals(media, feedback.media)
        && Objects.equals(sentiment, feedback.sentiment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rating, id, review, creationTime, helpfulVotes, media, sentiment);
  }

}
