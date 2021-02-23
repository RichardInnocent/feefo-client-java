package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Campaigns can be configured to include pre-defined custom questions that will be asked of the
 * consumer when leaving feedback. More information can be found
 * <a href="https://support.feefo.com/support/solutions/articles/8000050252-customise-form">here</a>.
 */
public class CustomQuestion {

  @JsonProperty("question_id")
  private String id;

  private String question;

  private String answer;

  /**
   * Gets the unique identifier for the question.
   * @return The unique identifier for the question.
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the unique identifier for the question.
   * @param id The unique identifier for the question.
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the title of the custom question. This is only included if the customer provided a
   * response to the question.
   * @return The title of the custom question.
   */
  public String getQuestion() {
    return question;
  }

  /**
   * Sets the title of the custom question.
   * @param question The title of the custom question.
   */
  public void setQuestion(String question) {
    this.question = question;
  }

  /**
   * Gets the consumer's response to the custom question.
   * @return The consumer's response to the custom question.
   */
  public String getAnswer() {
    return answer;
  }

  /**
   * Sets the consumer's response to the custom question.
   * @param answer The consumer's response to the custom question.
   */
  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomQuestion that = (CustomQuestion) o;
    return Objects.equals(id, that.id)
        && Objects.equals(question, that.question)
        && Objects.equals(answer, that.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, question, answer);
  }
}
