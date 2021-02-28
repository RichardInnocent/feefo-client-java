package org.richardinnocent.feefo.api.v10.reviews.shared.dto;

/**
 * Specifies the moderation status of content, as some content may not be appropriate for public
 * display. Uploaded content should match
 * <a href="https://www.feefo.com/en/business/content-moderation-guidelines">Feefo's moderation guidelines</a>.
 * Some merchants have the moderation package, where all specified content (e.g. reviews) go through
 * a moderation review before it is made public.
 */
public enum ModerationStatus {

  /**
   * The content is live and visible to the public. Either the owning merchant does not have
   * moderation enabled, or the content meets
   * <a href="https://www.feefo.com/en/business/content-moderation-guidelines">Feefo's moderation guidelines</a>.
   */
  PUBLISHED,

  /**
   * The content does not meet
   * <a href="https://www.feefo.com/en/business/content-moderation-guidelines">Feefo's moderation guidelines</a>,
   * so has been removed from public view.
   */
  REJECTED,

  /**
   * The owning merchant has moderation enabled, and the content is awaiting its moderation review.
   */
  PENDING,

  /**
   * The content was originally available to the public, but a merchant employee has requested its
   * moderation/re-moderation as they do not believe it meets
   * <a href="https://www.feefo.com/en/business/content-moderation-guidelines">Feefo's moderation guidelines</a>.
   */
  REQUESTED
}
