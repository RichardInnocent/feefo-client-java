package org.richardinnocent.feefo.api.v10.reviews.all;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import org.richardinnocent.feefo.api.requests.FeefoApiGetRequest;

public class EnrichedAllReviewsRequest extends FeefoApiGetRequest<EnrichedAllReviewsResponse> {

  private final String merchantIdentifier;

  public EnrichedAllReviewsRequest(String merchantIdentifier) throws NullPointerException {
    super(new TypeReference<EnrichedAllReviewsResponse>(){});
    this.merchantIdentifier =
        Objects.requireNonNull(merchantIdentifier, "Merchant identifier must be specified");
  }

  private void buildQueryParameters(FinalStageBuilder builder) {
    if (builder.sortField != null) {
      queryParameters.add(new QueryParameter("sort", builder.sortField.getQueryKey()));
    }

    if (builder.pageSize != null) {
      queryParameters.add(new QueryParameter("page_size", Integer.toString(builder.pageSize)));
    }

    if (!builder.responseFields.isEmpty()) {
      queryParameters.add(new QueryParameter("fields", String.join(",", builder.responseFields)));
    }

    queryParameters.add(new QueryParameter("merchant_identifier", builder.merchantIdentifier));

    if (!builder.tagFilters.isEmpty()) {
      queryParameters.add(
          new QueryParameter(
              "tags",
              builder.tagFilters.stream()
                                .map(TagFilter::toQueryValue)
                                .collect(Collectors.joining(","))
          )
      );
    }

    builder.reviewCreationTimeComparisons
        .stream()
        .map(
            comparison ->
                new QueryParameter(
                    "date_time", comparison.getComparator(), comparison.getReference().toString()
                )
        )
        .forEach(queryParameters::add);

    builder.reviewUpdatedTimeComparisons
        .stream()
        .map(
            comparison ->
                new QueryParameter(
                    "updated_date_time",
                    comparison.getComparator(),
                    comparison.getReference().toString()
                )
        )
        .forEach(queryParameters::add);

    if (builder.reviewCreatedSinceComparison != null) {
      queryParameters.add(
          new QueryParameter("since_period", builder.reviewCreatedSinceComparison.getReference())
      );
    }

    if (builder.reviewUpdatedSinceComparison != null) {
      queryParameters.add(
          new QueryParameter(
              "since_updated_period", builder.reviewUpdatedSinceComparison.getReference()
          )
      );
    }

    if (builder.requestOrigin != null) {
      queryParameters.add(new QueryParameter("origin", builder.requestOrigin));
    }

    if (builder.feedbackId != null) {
      queryParameters.add(new QueryParameter("id", builder.feedbackId));
    }

    if (builder.parentProductSku != null) {
      queryParameters.add(new QueryParameter("parent_product_sku", builder.parentProductSku));
    }

    if (builder.productSku != null) {
      queryParameters.add(new QueryParameter("product_sku", builder.productSku));
    }

    if (builder.customerReference != null) {
      queryParameters.add(new QueryParameter("customer_reference", builder.customerReference));
    }

    if (builder.customerEmail != null) {
      queryParameters.add(new QueryParameter("customer_email", builder.customerEmail));
    }

    if (builder.orderReference != null) {
      queryParameters.add(new QueryParameter("order_reference", builder.orderReference));
    }

    builder.feedbackScores
        .stream()
        .map(Object::toString)
        .map(score -> new QueryParameter("rating", score))
        .forEach(queryParameters::add);

    if (builder.feedbackFromSubMerchantsInclusion != null) {
      queryParameters.add(
          new QueryParameter("children", builder.feedbackFromSubMerchantsInclusion.getQueryKey())
      );
    }

    if (builder.mediaInclusion != null) {
      queryParameters.add(
          new QueryParameter("media", builder.mediaInclusion.getQueryKey())
      );
    }

    if (builder.emptyProductCommentInclusion != null) {
      queryParameters.add(
          new QueryParameter(
              "empty_product_comments", builder.emptyProductCommentInclusion.getQueryKey()
          )
      );
    }

    if (builder.unansweredFeedbackInclusion != null) {
      queryParameters.add(
          new QueryParameter(
              "unanswered_feedback", builder.unansweredFeedbackInclusion.getQueryKey()
          )
      );
    }

    if (builder.fullThreadInclusion != null) {
      queryParameters.add(
          new QueryParameter("full_thread", builder.fullThreadInclusion.getQueryKey())
      );
    }

    if (builder.enhancedInsightInclusion != null) {
      queryParameters.add(
          new QueryParameter("enhanced_insight", builder.enhancedInsightInclusion.getQueryKey())
      );
    }
  }

  @Override
  public String getBasePath() {
    return "/10/reviews/all";
  }

  @Override
  protected Map<String, String> getRequestParameters() {
    return Collections.singletonMap("merchant_identifier", merchantIdentifier);
  }

  @Override
  public boolean requiresAuthentication() {
    return true;
  }
}
