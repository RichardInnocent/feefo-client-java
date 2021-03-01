package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains service feedback information. This can contain personally identifiable or
 * business-sensitive information, so is only returned from authorised requests.
 */
public class SimpleServiceFeedback extends Feedback {

  private String title;

  @JsonProperty("thread")
  private final List<ThreadEntry> auditThread = new ArrayList<>();

  /**
   * Gets the title of the feedback.
   * @return The title of the feedback.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title of the feedback.
   * @param title The title of the feedback.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets an audit history for the feedback, including changes to the review and the conversation
   * between the consumer and merchant.
   * @return The audit history for the feedback.
   */
  public List<ThreadEntry> getAuditThread() {
    return new ArrayList<>(auditThread);
  }

  /**
   * Sets the audit history for the feedback, including changes to the review and the conversation
   * between the consumer and merchant.
   * @param auditThread The audit history for the feedback.
   */
  public void setAuditThread(List<ThreadEntry> auditThread) {
    this.auditThread.clear();
    if (auditThread != null) {
      this.auditThread.addAll(auditThread);
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
    SimpleServiceFeedback that = (SimpleServiceFeedback) o;
    return Objects.equals(title, that.title) && Objects.equals(auditThread, that.auditThread);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), title, auditThread);
  }

}
