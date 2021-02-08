package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Media {

  private String id;

  private MediaType type;

  private String url;

  @JsonProperty("thumbnail")
  private String thumbnailUrl;

  private String caption;

  @JsonProperty("helpful_votes")
  private int helpfulVotes;

  private String questionId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MediaType getType() {
    return type;
  }

  public void setType(MediaType type) {
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getThumbnailUrl() {
    return thumbnailUrl;
  }

  public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public int getHelpfulVotes() {
    return helpfulVotes;
  }

  public void setHelpfulVotes(int helpfulVotes) {
    this.helpfulVotes = helpfulVotes;
  }

  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Media media = (Media) o;
    return helpfulVotes == media.helpfulVotes
        && Objects.equals(id, media.id)
        && Objects.equals(type, media.type)
        && Objects.equals(url, media.url)
        && Objects.equals(thumbnailUrl, media.thumbnailUrl)
        && Objects.equals(caption, media.caption)
        && Objects.equals(questionId, media.questionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, url, thumbnailUrl, caption, helpfulVotes, questionId);
  }
}
