package org.richardinnocent.feefo.api.v10.reviews.shared;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.pagination.PaginationMetadata;

/**
 * Contains summary metadata such as the pagination details.
 */
public class Summary {

  @JsonProperty("meta")
  private PaginationMetadata paginationMetadata;

  /**
   * Gets the pagination metadata for this response.
   * @return The pagination metadata for this response.
   */
  public PaginationMetadata getPaginationMetadata() {
    return paginationMetadata;
  }

  /**
   * Sets the pagination metadata for this response.
   * @param paginationMetadata The pagination metadata for this response.
   */
  public void setPaginationMetadata(PaginationMetadata paginationMetadata) {
    this.paginationMetadata = paginationMetadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Summary that = (Summary) o;
    return Objects.equals(paginationMetadata, that.paginationMetadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paginationMetadata);
  }
}
