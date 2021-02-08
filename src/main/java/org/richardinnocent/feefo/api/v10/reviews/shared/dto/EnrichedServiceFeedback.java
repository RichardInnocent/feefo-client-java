package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnrichedServiceFeedback extends EnrichedFeedback {

  private String title;

  @JsonProperty("thread")
  private final List<ThreadEntry> commentThread = new ArrayList<>();

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<ThreadEntry> getCommentThread() {
    return new ArrayList<>(commentThread);
  }

  public void setCommentThread(List<ThreadEntry> commentThread) {
    this.commentThread.clear();
    if (commentThread != null) {
      this.commentThread.addAll(commentThread);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    EnrichedServiceFeedback that = (EnrichedServiceFeedback) o;
    return Objects.equals(title, that.title) && Objects.equals(commentThread, that.commentThread);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), title, commentThread);
  }
}
