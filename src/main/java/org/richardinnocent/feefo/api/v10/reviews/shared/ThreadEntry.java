package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Objects;

public class ThreadEntry {

  @JsonProperty("created_at")
  private LocalDateTime creationTime;

  private ThreadType type;

  private String author;

  private String comment;

  @JsonProperty("old_rating")
  private Integer previousRating;

  @JsonProperty("new_rating")
  private Integer newRating;

  @JsonProperty("old_title")
  private String previousTitle;

  @JsonProperty("new_title")
  private String newTitle;

  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(LocalDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public ThreadType getType() {
    return type;
  }

  public void setType(ThreadType type) {
    this.type = type;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Integer getPreviousRating() {
    return previousRating;
  }

  public void setPreviousRating(Integer previousRating) {
    this.previousRating = previousRating;
  }

  public Integer getNewRating() {
    return newRating;
  }

  public void setNewRating(Integer newRating) {
    this.newRating = newRating;
  }

  public String getPreviousTitle() {
    return previousTitle;
  }

  public void setPreviousTitle(String previousTitle) {
    this.previousTitle = previousTitle;
  }

  public String getNewTitle() {
    return newTitle;
  }

  public void setNewTitle(String newTitle) {
    this.newTitle = newTitle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThreadEntry that = (ThreadEntry) o;
    return Objects.equals(creationTime, that.creationTime)
        && Objects.equals(type, that.type) && Objects.equals(author, that.author)
        && Objects.equals(comment, that.comment)
        && Objects.equals(previousRating, that.previousRating)
        && Objects.equals(newRating, that.newRating)
        && Objects.equals(previousTitle, that.previousTitle)
        && Objects.equals(newTitle, that.newTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTime, type, author, comment, previousRating, newRating, previousTitle, newTitle
    );
  }
}
