package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class CustomQuestion {

  @JsonProperty("question_id")
  private String id;

  private String question;

  private String answer;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getAnswer() {
    return answer;
  }

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
