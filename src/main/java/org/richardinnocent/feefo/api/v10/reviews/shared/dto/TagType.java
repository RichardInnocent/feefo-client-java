package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

/**
 * Specifies the type of data that a tag is associated to.
 */
public enum TagType {

  /**
   * The tag is associated with a sale.
   */
  SALE,

  /**
   * The tag is associated with a particular product.
   */
  PRODUCT,

  /**
   * The tag is associated with a particular item of feedback.
   */
  FEEDBACK
}
