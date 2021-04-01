package org.richardinnocent.feefo.api.v10.reviews.reviews.shared.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains feedback information. This can contain personally identifiable or business-sensitive
 * information, so is only returned from authorised requests.
 */
public abstract class EnrichedFeedback extends Feedback {

  private final List<CustomQuestion> customQuestions = new ArrayList<>();

  /**
   * Gets the custom questions that were asked when gathering this feedback.
   * @return The custom questions that were asked when gathering this feedback.
   * @see CustomQuestion
   */
  public List<CustomQuestion> getCustomQuestions() {
    return new ArrayList<>(customQuestions);
  }

  /**
   * Sets the custom questions that were asked when gathering this feedback.
   * @param customQuestions The custom question that were asked when gathering this feedback.
   * @see CustomQuestion
   */
  public void setCustomQuestions(List<CustomQuestion> customQuestions) {
    this.customQuestions.clear();
    if (customQuestions != null) {
      this.customQuestions.addAll(customQuestions);
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
    EnrichedFeedback that = (EnrichedFeedback) o;
    return Objects.equals(customQuestions, that.customQuestions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), customQuestions);
  }
}
