package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Contains an audit history for some feedback, including changes to the review and the conversation
 * between the consumer and merchant.
 */
public class ThreadEntry {

  @JsonProperty("created_at")
  private OffsetDateTime creationTime;

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

  /**
   * Gets the time that the event occurred.
   * @return The time that the event occurred.
   */
  public OffsetDateTime getCreationTime() {
    return creationTime;
  }

  /**
   * Sets the time that the event occurred.
   * @param creationTime The time that the event occurred.
   */
  public void setCreationTime(OffsetDateTime creationTime) {
    this.creationTime = creationTime;
  }

  /**
   * Gets the type of update that occurred.
   * @return The type of update that occurred.
   */
  public ThreadType getType() {
    return type;
  }

  /**
   * Sets the type of update that occurred.
   * @param type The type of update that occurred.
   */
  public void setType(ThreadType type) {
    this.type = type;
  }

  /**
   * Gets the author of the event.
   * @return The author of the event.
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Sets the author of the event.
   * @param author The author of the event.
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Gets the comment corresponding to the event. This will not be present if
   * {@code getType() == ThreadType.CUSTOMER_RERATE}.
   * @return The comment corresponding to the event.
   */
  public String getComment() {
    return comment;
  }

  /**
   * Sets the comment corresponding to the event.
   * @param comment The comment corresponding to the event.
   */
  public void setComment(String comment) {
    this.comment = comment;
  }

  /**
   * Gets the previous feedback rating. This will only be present if
   * {@code getType() == ThreadType.CUSTOMER_RERATE}.
   * @return The previous feedback rating.
   */
  public Integer getPreviousRating() {
    return previousRating;
  }

  /**
   * Sets the previous feedback rating.
   * @param previousRating The previous feedback rating.
   */
  public void setPreviousRating(Integer previousRating) {
    this.previousRating = previousRating;
  }

  /**
   * Gets the new feedback rating. This will only be present if
   * {@code getType() == ThreadType.CUSTOMER_RERATE}.
   * @return The new feedback rating.
   */
  public Integer getNewRating() {
    return newRating;
  }

  /**
   * Sets the new feedback rating.
   * @param newRating The new feedback rating.
   */
  public void setNewRating(Integer newRating) {
    this.newRating = newRating;
  }

  /**
   * Gets the previous feedback title. This will only be present for service reviews, where
   * {@code getType() == ThreadType.CUSTOMER_RETITLE}.
   * @return The previous feedback title.
   */
  public String getPreviousTitle() {
    return previousTitle;
  }

  /**
   * Sets the previous feedback title.
   * @param previousTitle The previous feedback title.
   */
  public void setPreviousTitle(String previousTitle) {
    this.previousTitle = previousTitle;
  }

  /**
   * Gets the new feedback title. This will only be present for service reviews, where
   * {@code getType() == ThreadType.CUSTOMER_RETITLE}.
   * @return The new feedback title.
   */
  public String getNewTitle() {
    return newTitle;
  }

  /**
   * Sets the new feedback title.
   * @param newTitle The previous feedback title.
   */
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
