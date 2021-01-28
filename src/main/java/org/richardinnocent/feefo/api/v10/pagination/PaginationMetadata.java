package org.richardinnocent.feefo.api.v10.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Metadata specifying the pagination of the results.
 */
public class PaginationMetadata {

  private long count;

  private int pages;

  @JsonProperty("page_size")
  private int pageSize;

  @JsonProperty("current_page")
  private int currentPage;

  /**
   * Gets the total number of records available. If this number is greater than
   * {@link #getPageSize()}, multiple requests will be required to retrieve all results.
   * @return The total number of records available.
   */
  public long getCount() {
    return count;
  }

  /**
   * Sets the total number of records available. If this number is greater than
   * {@link #getPageSize()}, multiple requests will be required to retrieve all results.
   * @param count The total number of records available.
   */
  public void setCount(long count) {
    this.count = count;
  }

  /**
   * Gets the number of pages of results.
   * @return The number of pages of results.
   */
  public int getPages() {
    return pages;
  }

  /**
   * Sets the number of pages of results.
   * @param pages The number of pages of results.
   */
  public void setPages(int pages) {
    this.pages = pages;
  }

  /**
   * Gets the maximum number of results per page.
   * @return The maximum number of results per page.
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Sets the maximum number of results per page.
   * @param pageSize The maximum number of results per page.
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * Gets the current page of results.
   * @return The current page of results.
   */
  public int getCurrentPage() {
    return currentPage;
  }

  /**
   * Sets the current page of results.
   * @param currentPage The current page of results.
   */
  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationMetadata that = (PaginationMetadata) o;
    return count == that.count
        && pages == that.pages
        && pageSize == that.pageSize
        && currentPage == that.currentPage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, pages, pageSize, currentPage);
  }
}
