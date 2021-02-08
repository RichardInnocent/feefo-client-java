package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class EnrichedFeedback {

  private Rating rating;
  private String id;
  private String review;

  @JsonProperty("created_at")
  private LocalDateTime creationTime;

  @JsonProperty("helpful_votes")
  private Integer helpfulVotes;

  private final List<Media> media = new ArrayList<>();

  private final List<CustomQuestion> customQuestions = new ArrayList<>();

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

  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(LocalDateTime creationTime) {
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

  public void setCustomQuestions(List<CustomQuestion> customQuestions) {
    this.customQuestions.clear();
    if (customQuestions != null) {
      this.customQuestions.addAll(customQuestions);
    }
  }

  public List<CustomQuestion> getCustomQuestions() {
    return new ArrayList<>(customQuestions);
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
    EnrichedFeedback feedback = (EnrichedFeedback) o;
    return Objects.equals(helpfulVotes, feedback.helpfulVotes)
        && Objects.equals(rating, feedback.rating)
        && Objects.equals(id, feedback.id)
        && Objects.equals(review, feedback.review)
        && Objects.equals(creationTime, feedback.creationTime)
        && Objects.equals(media, feedback.media)
        && Objects.equals(customQuestions, feedback.customQuestions)
        && Objects.equals(sentiment, feedback.sentiment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        rating, id, review, creationTime, helpfulVotes, media, customQuestions, sentiment
    );
  }

}
