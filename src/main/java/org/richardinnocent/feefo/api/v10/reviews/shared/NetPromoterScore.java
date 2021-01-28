package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Objects;

public class NetPromoterScore {

  @JsonProperty("created_at")
  private LocalDateTime creationTime;

  private Integer rating;

  private String reason;

  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(LocalDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getReason() {
    return reason;
  }

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
