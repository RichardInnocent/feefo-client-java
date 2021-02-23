package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains sentiment information on review content.
 */
public class Sentiment {

  private final List<Feature> features = new ArrayList<>();

  @JsonProperty("positive_snippets")
  private final List<Feature> positiveSnippets = new ArrayList<>();

  @JsonProperty("negative_snippets")
  private final List<Feature> negativeSnippets = new ArrayList<>();

  /**
   * Gets all of the prominent features that were detected in the text.
   * @return The prominent features that were detected in the text.
   */
  public List<Feature> getFeatures() {
    return new ArrayList<>(features);
  }

  /**
   * Sets the prominent features that were detected in the text.
   * @param features The prominent features that were detected in the text.
   */
  public void setFeatures(List<Feature> features) {
    this.features.clear();
    if (features != null) {
      this.features.addAll(features);
    }
  }

  /**
   * Gets the short snippets of text from the review that were deemed to have a positive sentiment.
   * @return The short snippets of text from the review that were deemed to have a positive
   * sentiment.
   */
  public List<Feature> getPositiveSnippets() {
    return new ArrayList<>(positiveSnippets);
  }

  /**
   * Sets the short snippets of text from the review that were deemed to have a positive sentiment.
   * @param positiveSnippets The short snippets of text from the review that were deemed to have a
   * positive sentiment.
   */
  public void setPositiveSnippets(List<Feature> positiveSnippets) {
    this.positiveSnippets.clear();
    if (positiveSnippets != null) {
      this.positiveSnippets.addAll(features);
    }
  }

  /**
   * Gets the short snippets of text from the review that were deemed to have a negative sentiment.
   * @return The short snippets of text from the review that were deemed to have a negative
   * sentiment.
   */
  public List<Feature> getNegativeSnippets() {
    return new ArrayList<>(negativeSnippets);
  }

  /**
   * Sets the short snippets of text from the review that were deemed to have a negative sentiment.
   * @param negativeSnippets The short snippets of text from the review that were deemed to have a
   * negative sentiment.
   */
  public void setNegativeSnippets(List<Feature> negativeSnippets) {
    this.negativeSnippets.clear();
    if (negativeSnippets != null) {
      this.negativeSnippets.addAll(negativeSnippets);
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
    Sentiment sentiment = (Sentiment) o;
    return Objects.equals(features, sentiment.features)
        && Objects.equals(positiveSnippets, sentiment.positiveSnippets)
        && Objects.equals(negativeSnippets, sentiment.negativeSnippets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(features, positiveSnippets, negativeSnippets);
  }
}
