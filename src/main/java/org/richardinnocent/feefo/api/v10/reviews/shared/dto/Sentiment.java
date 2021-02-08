package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentiment {

  private final List<Feature> features = new ArrayList<>();

  @JsonProperty("positive_snippets")
  private final List<Feature> positiveSnippets = new ArrayList<>();

  @JsonProperty("negative_snippets")
  private final List<Feature> negativeSnippets = new ArrayList<>();

  public void setFeatures(List<Feature> features) {
    this.features.clear();
    if (features != null) {
      this.features.addAll(features);
    }
  }

  public List<Feature> getFeatures() {
    return new ArrayList<>(features);
  }

  public void setPositiveSnippets(List<Feature> positiveSnippets) {
    this.positiveSnippets.clear();
    if (positiveSnippets != null) {
      this.positiveSnippets.addAll(features);
    }
  }

  public List<Feature> getPositiveSnippets() {
    return new ArrayList<>(positiveSnippets);
  }

  public void setNegativeSnippets(List<Feature> negativeSnippets) {
    this.negativeSnippets.clear();
    if (negativeSnippets != null) {
      this.negativeSnippets.addAll(negativeSnippets);
    }
  }

  public List<Feature> getNegativeSnippets() {
    return new ArrayList<>(negativeSnippets);
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
