package org.richardinnocent.feefo.api.v10.reviews.shared;

/**
 * Specifies the type of entry on the thread.
 */
public enum ThreadType {

  /**
   * The customer replied to the thread.
   */
  CUSTOMER_COMMENT,

  /**
   * The consumer updated the rating on their feedback.
   */
  CUSTOMER_RERATE,

  /**
   * The merchant replied to the thread.
   */
  MERCHANT_COMMENT,

  /**
   * The customer changed the review title.
   */
  CUSTOMER_RETITLE,

  /**
   * The consumer re-rated one or more of their attributes.
   */
  CUSTOMER_ATTRIBUTE_RERATE
}
