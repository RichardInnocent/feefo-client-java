package org.richardinnocent.feefo.api.v10.reviews.all;

import com.fasterxml.jackson.core.type.TypeReference;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;
import org.richardinnocent.feefo.api.requests.FeefoApiGetRequest;
import org.richardinnocent.feefo.api.requests.QueryParameter;
import org.richardinnocent.feefo.api.v10.reviews.all.EnrichedAllReviewsRequest.Builder.FinalStageBuilder;
import org.richardinnocent.feefo.api.v10.reviews.all.params.SortField;
import org.richardinnocent.feefo.api.requests.EqualityOperator;
import org.richardinnocent.feefo.api.v10.reviews.shared.Comparison;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.EmptyProductCommentInclusion;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.Inclusion;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.MediaInclusion;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.TagFilter;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.TimeFrame;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.UnansweredFeedbackInclusion;

public class EnrichedAllReviewsRequest extends FeefoApiGetRequest<EnrichedAllReviewsResponse> {

  private final Collection<QueryParameter> queryParameters = new ArrayList<>();

  private EnrichedAllReviewsRequest(FinalStageBuilder builder) throws NullPointerException {
    super(new TypeReference<EnrichedAllReviewsResponse>(){});
    buildQueryParameters(builder);
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
  protected Collection<QueryParameter> getQueryParameters() {
    return new ArrayList<>(queryParameters);
  }

  @Override
  public boolean requiresAuthentication() {
    return true;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private Builder() {}

    public FinalStageBuilder forMerchant(String merchantIdentifier) throws NullPointerException {
      return new FinalStageBuilder(merchantIdentifier);
    }

    public static class FinalStageBuilder {
      private SortField sortField;
      private Integer pageSize;
      private final Collection<String> responseFields = new ArrayList<>();

      private final String merchantIdentifier;
      private final Collection<TagFilter> tagFilters = new ArrayList<>();
      private final Collection<Comparison<OffsetDateTime>> reviewCreationTimeComparisons =
          new ArrayList<>(2);
      private final Collection<Comparison<OffsetDateTime>> reviewUpdatedTimeComparisons =
          new ArrayList<>(2);
      private Comparison<String> reviewCreatedSinceComparison;
      private Comparison<String> reviewUpdatedSinceComparison;
      private String requestOrigin;
      private String feedbackId;
      private String parentProductSku;
      private String productSku;
      private String customerReference;
      private String customerEmail;
      private String orderReference;
      private final Collection<Integer> feedbackScores = new HashSet<>(5);
      private Inclusion feedbackFromSubMerchantsInclusion;
      private MediaInclusion mediaInclusion;
      private EmptyProductCommentInclusion emptyProductCommentInclusion;
      private UnansweredFeedbackInclusion unansweredFeedbackInclusion;
      private Inclusion fullThreadInclusion;
      private Inclusion enhancedInsightInclusion;

      private FinalStageBuilder(String merchantIdentifier)
          throws NullPointerException, IllegalArgumentException {
        this.merchantIdentifier =
            Objects.requireNonNull(
                merchantIdentifier, "Merchant identifier is mandatory and cannot be null");
        if (merchantIdentifier.isEmpty()) {
          throw new IllegalArgumentException(
              "Merchant identifier is mandatory and cannot be empty");
        }
      }

      public FinalStageBuilder withSortField(SortField sortField) {
        this.sortField = sortField;
        return this;
      }

      public FinalStageBuilder withPageSize(int pageSize) throws IllegalArgumentException {
        if (pageSize < 1 || pageSize > 100) {
          throw new IllegalArgumentException(
              "Page size must be between 1 and 100 (inclusive), but is " + pageSize
          );
        }
        this.pageSize = pageSize;
        return this;
      }

      public FinalStageBuilder withResponseField(String responseField) throws NullPointerException {
        this.responseFields.add(Objects.requireNonNull(responseField, "Response field is null"));
        return this;
      }

      public FinalStageBuilder withResponseFields(String responseField1, String... responseFields)
          throws NullPointerException {
        withResponseField(responseField1);
        if (responseFields != null) {
          for (String responseField : responseFields) {
            withResponseField(responseField);
          }
        }
        return this;
      }

      public FinalStageBuilder withResponseFields(Collection<String> responseFields)
          throws NullPointerException {
        if (responseFields != null) {
          responseFields.forEach(this::withResponseField);
        }
        return this;
      }

      public FinalStageBuilder withTagFilter(TagFilter tagFilter) throws NullPointerException {
        tagFilters.add(Objects.requireNonNull(tagFilter, "Tag filter is null"));
        return this;
      }

      public FinalStageBuilder withTagFilters(TagFilter tagFilter1, TagFilter... tagFilters)
          throws NullPointerException {
        withTagFilter(tagFilter1);
        if (tagFilters != null) {
          for (TagFilter filter : tagFilters) {
            withTagFilter(filter);
          }
        }
        return this;
      }

      public FinalStageBuilder withTagFilters(Collection<TagFilter> tagFilters)
          throws NullPointerException {
        if (tagFilters != null) {
          tagFilters.forEach(this::withTagFilter);
        }
        return this;
      }

      public FinalStageBuilder withReviewCreationTimeAtExactly(OffsetDateTime reviewCreationTime)
          throws NullPointerException {
        reviewCreationTimeComparisons.add(
            new Comparison<>(EqualityOperator.EQUALS, reviewCreationTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewCreationTimeBefore(
          OffsetDateTime latestReviewCreationTime) throws NullPointerException {
        reviewCreationTimeComparisons.add(
            new Comparison<>(EqualityOperator.LESS_THAN, latestReviewCreationTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewCreationTimeAtOrBefore(
          OffsetDateTime latestReviewCreationTime) throws NullPointerException {
        reviewCreationTimeComparisons.add(
            new Comparison<>(EqualityOperator.LESS_THAN_OR_EQUAL_TO, latestReviewCreationTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewCreationTimeAfter(
          OffsetDateTime earliestReviewCreationTime) throws NullPointerException {
        reviewCreationTimeComparisons.add(
            new Comparison<>(EqualityOperator.GREATER_THAN, earliestReviewCreationTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewCreationTimeAtOrAfter(
          OffsetDateTime earliestReviewCreationTime) throws NullPointerException {
        reviewCreationTimeComparisons.add(
            new Comparison<>(EqualityOperator.GREATER_THAN_OR_EQUAL_TO, earliestReviewCreationTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewUpdatedTimeAtExactly(OffsetDateTime reviewUpdatedTime)
          throws NullPointerException {
        reviewUpdatedTimeComparisons.add(new Comparison<>(EqualityOperator.EQUALS, reviewUpdatedTime));
        return this;
      }

      public FinalStageBuilder withReviewUpdatedTimeBefore(OffsetDateTime latestReviewUpdatedTime)
          throws NullPointerException {
        reviewUpdatedTimeComparisons.add(
            new Comparison<>(EqualityOperator.LESS_THAN, latestReviewUpdatedTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewUpdatedTimeAtOrBefore(
          OffsetDateTime latestReviewUpdatedTime) throws NullPointerException {
        reviewUpdatedTimeComparisons.add(
            new Comparison<>(EqualityOperator.LESS_THAN_OR_EQUAL_TO, latestReviewUpdatedTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewUpdatedTimeAfter(OffsetDateTime earliestReviewUpdatedTime)
          throws NullPointerException {
        reviewUpdatedTimeComparisons.add(
            new Comparison<>(EqualityOperator.GREATER_THAN, earliestReviewUpdatedTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewUpdatedTimeAtOrAfter(
          OffsetDateTime earliestReviewUpdatedTime) throws NullPointerException {
        reviewUpdatedTimeComparisons.add(
            new Comparison<>(EqualityOperator.GREATER_THAN_OR_EQUAL_TO, earliestReviewUpdatedTime)
        );
        return this;
      }

      public FinalStageBuilder withReviewCreatedIn(TimeFrame reviewCreationTimeFrame)
          throws NullPointerException {
        reviewCreatedSinceComparison =
            new Comparison<>(EqualityOperator.EQUALS, reviewCreationTimeFrame.getQueryKey());
        return this;
      }

      public FinalStageBuilder withReviewUpdatedIn(TimeFrame reviewUpdatedTimeFrame)
          throws NullPointerException {
        reviewUpdatedSinceComparison =
            new Comparison<>(EqualityOperator.EQUALS, reviewUpdatedTimeFrame.getQueryKey());
        return this;
      }

      public FinalStageBuilder withRequestOrigin(String requestOrigin) {
        this.requestOrigin = requestOrigin;
        return this;
      }

      public FinalStageBuilder withFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
        return this;
      }

      public FinalStageBuilder withParentProductSku(String parentProductSku) {
        this.parentProductSku = parentProductSku;
        return this;
      }

      public FinalStageBuilder withProductSku(String productSku) {
        this.productSku = productSku;
        return this;
      }

      public FinalStageBuilder withCustomerReference(String customerReference) {
        this.customerReference = customerReference;
        return this;
      }

      public FinalStageBuilder withCustomerEmail(String email) {
        this.customerEmail = email;
        return this;
      }

      public FinalStageBuilder withOrderReference(String orderReference) {
        this.orderReference = orderReference;
        return this;
      }

      public FinalStageBuilder withFeedbackScore(int score) throws IllegalArgumentException {
        if (score < 1 || score > 5) {
          throw new IllegalArgumentException("Score must be between 1 and 5 but is " + score);
        }
        this.feedbackScores.add(score);
        return this;
      }

      public FinalStageBuilder withFeedbackScores(int score1, int... scores)
          throws NullPointerException, IllegalArgumentException {
        withFeedbackScore(score1);
        if (scores != null) {
          Arrays.stream(scores).forEach(this::withFeedbackScore);
        }
        return this;
      }

      public FinalStageBuilder withFeedbackScores(Collection<Integer> scores)
          throws NullPointerException, IllegalArgumentException {
        if (scores != null) {
          scores.forEach(this::withFeedbackScore);
        }
        return this;
      }

      public FinalStageBuilder withFeedbackFromSubMerchants(Inclusion inclusion) {
        this.feedbackFromSubMerchantsInclusion = inclusion;
        return this;
      }

      public FinalStageBuilder withMediaInclusion(MediaInclusion mediaInclusion) {
        this.mediaInclusion = mediaInclusion;
        return this;
      }

      public FinalStageBuilder withEmptyProductCommentInclusion(
          EmptyProductCommentInclusion emptyProductCommentInclusion) {
        this.emptyProductCommentInclusion = emptyProductCommentInclusion;
        return this;
      }

      public FinalStageBuilder withUnansweredFeedbackInclusion(
          UnansweredFeedbackInclusion unansweredFeedbackInclusion) {
        this.unansweredFeedbackInclusion = unansweredFeedbackInclusion;
        return this;
      }

      public FinalStageBuilder withFullThread(Inclusion fullThreadInclusion) {
        this.fullThreadInclusion = fullThreadInclusion;
        return this;
      }

      public FinalStageBuilder withEnhancedInsight(Inclusion enhancedInsightInclusion) {
        this.enhancedInsightInclusion = enhancedInsightInclusion;
        return this;
      }

      public EnrichedAllReviewsRequest build() {
        return new EnrichedAllReviewsRequest(this);
      }
    }
  }
}
