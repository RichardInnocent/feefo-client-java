package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

  public Rating getRating() {
    return rating;
  }

  public void setRating(Rating rating) {
    this.rating = rating;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public OffsetDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(OffsetDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public Integer getHelpfulVotes() {
    return helpfulVotes;
  }

  public void setHelpfulVotes(Integer helpfulVotes) {
    this.helpfulVotes = helpfulVotes;
  }

  public List<Media> getMedia() {
    return new ArrayList<>(media);
  }

  public void setMedia(List<Media> media) {
    this.media.clear();
    if (media != null) {
      this.media.addAll(media);
    }
  }

  public Sentiment getSentiment() {
    return sentiment;
  }

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
