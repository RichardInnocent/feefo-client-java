package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Contains details regarding the net promoter score (NPS).
 */
public class NetPromoterScore {

  @JsonProperty("created_at")
  private OffsetDateTime creationTime;

  private Integer rating;

  private String reason;

  /**
   * Gets the time that the NPS was created.
   * @return The time that the NPS was created.
   */
  public OffsetDateTime getCreationTime() {
    return creationTime;
  }

  /**
   * Sets the time that the NPS was created.
   * @param creationTime The time that the NPS was created.
   */
  public void setCreationTime(OffsetDateTime creationTime) {
    this.creationTime = creationTime;
  }

  /**
   * Gets the rating. This will be on the scale of 0 to 10.
   * @return The rating.
   */
  public Integer getRating() {
    return rating;
  }

  /**
   * Sets the rating. This should be on a scale of 0 to 10.
   * @param rating The rating.
   */
  public void setRating(Integer rating) {
    this.rating = rating;
  }

  /**
   * Gets the reason that the consumer supplied for providing this NPS.
   * @return The reason that the consumer supplied for providing this NPS.
   */
  public String getReason() {
    return reason;
  }

  /**
   * Sets the reason that the consumer supplied for providing this NPS.
   * @param reason The reason that the consumer supplied for providing this NPS.
   */
  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NetPromoterScore that = (NetPromoterScore) o;
    return Objects.equals(creationTime, that.creationTime) && Objects
        .equals(rating, that.rating) && Objects.equals(reason, that.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationTime, rating, reason);
  }
}
