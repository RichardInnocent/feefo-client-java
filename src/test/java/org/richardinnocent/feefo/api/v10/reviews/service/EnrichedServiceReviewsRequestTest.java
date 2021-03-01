package org.richardinnocent.feefo.api.v10.reviews.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.richardinnocent.feefo.api.requests.EqualityOperator;
import org.richardinnocent.feefo.api.requests.QueryParameter;
import org.richardinnocent.feefo.api.v10.reviews.service.params.SortField;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.Inclusion;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.MediaInclusion;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.TagFilter;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.TimeFrame;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.UnansweredFeedbackInclusion;

class EnrichedServiceReviewsRequestTest {

  @Test
  public void getBasePath_Always_AsExpected() {
    assertEquals(
        "/10/reviews/service",
        EnrichedServiceReviewsRequest.builder().forMerchant("test-merchant").build().getBasePath()
    );
  }

  @Test
  public void getRequestParameters_Always_SpecifiesMerchantIdentifier() {
    String merchantIdentifier = "test-merchant";

    Collection<QueryParameter> expectedParameters = Collections.singletonList(
        new QueryParameter("merchant_identifier", EqualityOperator.EQUALS, merchantIdentifier)
    );
    assertEquals(
        expectedParameters,
        EnrichedServiceReviewsRequest
            .builder().forMerchant(merchantIdentifier).build().getQueryParameters()
    );
  }

  @Test
  public void requiresAuthentication_Always_ReturnsTrue() {
    assertTrue(
        EnrichedServiceReviewsRequest
            .builder().forMerchant("test-merchant").build().requiresAuthentication()
    );
  }

  @Test
  public void builder$forMerchant_MerchantIdentifierIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest.builder().forMerchant(null)
    );
  }

  @Test
  public void builder$forMerchant_MerchantIdentifierSet_OnlyParameterSet() {
    String merchantIdentifier = "test-merchant";
    EnrichedServiceReviewsRequest request =
        EnrichedServiceReviewsRequest.builder().forMerchant(merchantIdentifier).build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(1, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("merchant_identifier", merchantIdentifier))
    );
  }

  @Test
  public void builder$withSortField_NotNull_SetsParameter() {
    SortField sortField = SortField.HELPFUL_VOTES;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withSortField(sortField)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(2, queryParameters.size());
    assertTrue(queryParameters.contains(new QueryParameter("sort", sortField.getQueryKey())));
  }

  @Test
  public void builder$withPage_PositivePage_SetsParameter() {
    int page = 5;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withPage(page)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(2, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page", Integer.toString(page)))
    );
  }

  @Test
  public void builder$withPage_SmallestAllowablePage_SetsParameter() {
    int page = 1;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withPage(page)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(2, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page", Integer.toString(page)))
    );
  }

  @Test
  public void builder$withPage_PageIsZero_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest.builder().forMerchant("test-merchant").withPage(0)
    );
  }

  @Test
  public void builder$withPage_PageIsNegative_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest.builder().forMerchant("test-merchant").withPage(-1)
    );
  }

  @Test
  public void builder$withPageSize_Valid_SetsParameter() {
    int pageSize = 5;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withPageSize(pageSize)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(2, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page_size", Integer.toString(pageSize)))
    );
  }

  @Test
  public void builder$withPageSize_MinimumAllowedSize_SetsParameter() {
    int pageSize = 1;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withPageSize(pageSize)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(2, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page_size", Integer.toString(pageSize)))
    );
  }

  @Test
  public void builder$withPageSize_MaximumAllowedSize_SetsParameter() {
    int pageSize = 100;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withPageSize(pageSize)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(2, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page_size", Integer.toString(pageSize)))
    );
  }

  @Test
  public void builder$withPageSize_SizeTooSmall_ThrowsException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withPageSize(0)
            .build()
    );
  }

  @Test
  public void builder$withPageSize_SizeTooLarge_ThrowsException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withPageSize(101)
            .build()
    );
  }

  @Test
  public void builder$withResponseField_FieldNotNull_SetsParameter() {
    String field = "testField";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withResponseField(field)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("fields", field)));
  }

  @Test
  public void builder$withResponseField_FieldNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withResponseField(null)
    );
  }

  @Test
  public void builder$withResponseFieldsVarargs_FirstFieldNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withResponseFields(null, "testField")
    );
  }

  @Test
  public void builder$withResponseFieldsVarargs_LaterFieldNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withResponseFields("testField1", "testField2", null, "testField3")
    );
  }

  @Test
  public void builder$withResponseFieldsVarargs_OneField_ParameterSet() {
    String field = "testField";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withResponseFields(field)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("fields", field)));
  }

  @Test
  public void builder$withResponseFieldsVarargs_MultipleFields_ParameterSet() {
    String field1 = "testField1";
    String field2 = "testField2";
    String field3 = "testField3";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withResponseFields(field1, field2, field3)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("fields", field1 + ',' + field2 + ',' + field3))
    );
  }

  @Test
  public void builder$withResponseFieldsCollection_FieldsNull_ParameterNotSet() {
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withResponseFields(null)
        .build();
    assertEquals(1, request.getQueryParameters().size()); // Only contains the merchant
  }

  @Test
  public void builder$withResponseFieldsCollection_FieldsEmpty_ParameterNotSet() {
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withResponseFields(Collections.emptyList())
        .build();
    assertEquals(1, request.getQueryParameters().size()); // Only contains the merchant
  }

  @Test
  public void builder$withResponseFieldsCollection_OneFieldNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withResponseFields(Arrays.asList("testField1", null, "testField3"))
    );
  }

  @Test
  public void builder$withResponseFieldsCollection_OneField_ParameterSet() {
    String field = "testField";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withResponseFields(Collections.singletonList(field))
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("fields", field)));
  }

  @Test
  public void builder$withResponseFieldsCollection_MultipleFields_ParameterSet() {
    String field1 = "testField1";
    String field2 = "testField2";
    String field3 = "testField3";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withResponseFields(Arrays.asList(field1, field2, field3))
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("fields", field1 + ',' + field2 + ',' + field3))
    );
  }

  @Test
  public void builder$withTagFilter_FilterNotNull_SetsParameter() {
    String result = "result";
    TagFilter tagFilter = createTagFilter(result);

    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withTagFilter(tagFilter)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("tags", result)));
  }

  @Test
  public void builder$withTagFilter_FilterNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withTagFilter(null)
    );
  }

  @Test
  public void builder$withTagFilterVarargs_FirstFilterNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withTagFilters(null, mock(TagFilter.class))
    );
  }

  @Test
  public void builder$withTagFiltersVarargs_LaterFilterNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withTagFilters(
                mock(TagFilter.class),
                mock(TagFilter.class), null, mock(TagFilter.class)
            )
    );
  }

  @Test
  public void builder$withTagFiltersVarargs_OneFilter_ParameterSet() {
    String result = "result";
    TagFilter tagFilter = createTagFilter(result);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withTagFilters(tagFilter)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("tags", result)));
  }

  @Test
  public void builder$withTagFiltersVarargs_MultipleFilters_ParameterSet() {
    String result1 = "testField1";
    String result2 = "testField2";
    String result3 = "testField3";
    TagFilter tagFilter1 = createTagFilter(result1);
    TagFilter tagFilter2 = createTagFilter(result2);
    TagFilter tagFilter3 = createTagFilter(result3);

    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withTagFilters(tagFilter1, tagFilter2, tagFilter3)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("tags", result1 + ',' + result2 + ',' + result3))
    );
  }

  @Test
  public void builder$withTagFiltersCollection_FiltersNull_ParameterNotSet() {
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withTagFilters(null)
        .build();
    assertEquals(1, request.getQueryParameters().size()); // Only contains the merchant
  }

  @Test
  public void builder$withTagFiltersCollection_FiltersEmpty_ParameterNotSet() {
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withTagFilters(Collections.emptyList())
        .build();
    assertEquals(1, request.getQueryParameters().size()); // Only contains the merchant
  }

  @Test
  public void builder$withTagFiltersCollection_OneFilterNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withTagFilters(Arrays.asList(mock(TagFilter.class), null, mock(TagFilter.class)))
    );
  }

  @Test
  public void builder$withTagFiltersCollection_OneField_ParameterSet() {
    String result = "result";
    TagFilter tagFilter = createTagFilter(result);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withTagFilters(Collections.singletonList(tagFilter))
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("tags", result)));
  }

  @Test
  public void builder$withTagFiltersCollection_MultipleFields_ParameterSet() {
    String result1 = "testField1";
    String result2 = "testField2";
    String result3 = "testField3";
    TagFilter tagFilter1 = createTagFilter(result1);
    TagFilter tagFilter2 = createTagFilter(result2);
    TagFilter tagFilter3 = createTagFilter(result3);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withTagFilters(Arrays.asList(tagFilter1, tagFilter2, tagFilter3))
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("tags", result1 + ',' + result2 + ',' + result3))
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtExactly_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewCreationTimeAtExactly(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("date_time", dateTime.toString()))
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtExactly_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewCreationTimeAtExactly(null)
    );
  }

  @Test
  public void builder$withReviewCreationTimeBefore_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewCreationTimeBefore(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(
                   new QueryParameter("date_time", EqualityOperator.LESS_THAN, dateTime.toString()
                   )
               )
    );
  }

  @Test
  public void builder$withReviewCreationTimeBefore_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewCreationTimeBefore(null)
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtOrBefore_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewCreationTimeAtOrBefore(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(
                   new QueryParameter(
                       "date_time", EqualityOperator.LESS_THAN_OR_EQUAL_TO, dateTime.toString()
                   )
               )
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtOrBefore_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewCreationTimeAtOrBefore(null)
    );
  }

  @Test
  public void builder$withReviewCreationAfter_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewCreationTimeAfter(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(
                   new QueryParameter(
                       "date_time", EqualityOperator.GREATER_THAN, dateTime.toString())
               )
    );
  }

  @Test
  public void builder$withReviewCreationTimeAfter_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewCreationTimeAfter(null)
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtOrAfter_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewCreationTimeAtOrAfter(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(
                   new QueryParameter(
                       "date_time", EqualityOperator.GREATER_THAN_OR_EQUAL_TO, dateTime.toString()
                   )
               )
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAtExactly_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewUpdatedTimeAtExactly(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("updated_date_time", dateTime.toString()))
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAtExactly_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewUpdatedTimeAtExactly(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeBefore_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewUpdatedTimeBefore(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(
                   new QueryParameter(
                       "updated_date_time", EqualityOperator.LESS_THAN, dateTime.toString()
                   )
               )
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeBefore_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewUpdatedTimeBefore(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAtOrBefore_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewUpdatedTimeAtOrBefore(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(
                   new QueryParameter(
                       "updated_date_time",
                       EqualityOperator.LESS_THAN_OR_EQUAL_TO,
                       dateTime.toString()
                   )
               )
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAtOrBefore_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewUpdatedTimeAtOrBefore(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedAfter_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewUpdatedTimeAfter(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(
                   new QueryParameter(
                       "updated_date_time", EqualityOperator.GREATER_THAN, dateTime.toString())
               )
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAfter_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewUpdatedTimeAfter(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAtOrAfter_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewUpdatedTimeAtOrAfter(dateTime)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(
                   new QueryParameter(
                       "updated_date_time",
                       EqualityOperator.GREATER_THAN_OR_EQUAL_TO,
                       dateTime.toString()
                   )
               )
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtOrAfter_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withReviewUpdatedTimeAtOrAfter(null)
    );
  }

  @Test
  public void builder$withReviewCreatedIn_TimeFrameProvided_ParameterSet() {
    TimeFrame timeFrame = TimeFrame.LAST_WEEK;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewCreatedIn(timeFrame)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("since_period", timeFrame.getQueryValue()))
    );
  }

  @Test
  public void builder$withReviewCreatedIn_TimeFrameNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () ->
            EnrichedServiceReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withReviewCreatedIn(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedIn_TimeFrameProvided_ParameterSet() {
    TimeFrame timeFrame = TimeFrame.LAST_WEEK;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withReviewUpdatedIn(timeFrame)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("since_updated_period", timeFrame.getQueryValue()))
    );
  }

  @Test
  public void builder$withReviewUpdatedIn_TimeFrameNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () ->
            EnrichedServiceReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withReviewUpdatedIn(null)
    );
  }

  @Test
  public void builder$withRequestOrigin_OriginProvided_ParameterSet() {
    String origin = "test origin";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withRequestOrigin(origin)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("origin", origin))
    );
  }

  @Test
  public void builder$withFeedbackId_FeedbackIdProvided_ParameterSet() {
    String feedbackId = "feedbackId";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackId(feedbackId)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("id", feedbackId))
    );
  }

  @Test
  public void builder$withParentProductSku_SkuIdProvided_ParameterSet() {
    String productSku = "product-sku";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withParentProductSku(productSku)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("parent_product_sku", productSku))
    );
  }

  @Test
  public void builder$withProductSku_SkuIdProvided_ParameterSet() {
    String productSku = "product-sku";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku(productSku)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("product_sku", productSku))
    );
  }

  @Test
  public void builder$withCustomerReference_ReferenceProvided_ParameterSet() {
    String customerReference = "customer-reference";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withCustomerReference(customerReference)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("customer_reference", customerReference))
    );
  }

  @Test
  public void builder$withCustomerEmail_EmailProvided_ParameterSet() {
    String email = "customer@test.com";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withCustomerEmail(email)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("customer_email", email))
    );
  }

  @Test
  public void builder$withOrderReference_ReferenceProvided_ParameterSet() {
    String reference = "order-ref";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withOrderReference(reference)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("order_reference", reference))
    );
  }

  @Test
  public void builder$withFeedbackScore_MinimumAllowedScore_ParameterSet() {
    int score = 1;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScore(score)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("rating", Integer.toString(score)))
    );
  }

  @Test
  public void builder$withFeedbackScore_MaximumAllowedScore_ParameterSet() {
    int score = 5;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScore(score)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("rating", Integer.toString(score)))
    );
  }

  @Test
  public void builder$withFeedbackScore_ScoreTooLow_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScore(0)
    );
  }

  @Test
  public void builder$withFeedbackScore_ScoreTooHigh_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScore(6)
    );
  }

  @Test
  public void builder$withFeedbackScoreVarargs_FirstScoreTooLow_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScores(0, 2, 3)
    );
  }

  @Test
  public void builder$withFeedbackScoreVarargs_FirstScoreTooHigh_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScores(6, 2, 3)
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_LaterScoreTooLow_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScores(2, 3, 0, 4)
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_LaterScoreTooHigh_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScores(2, 3, 6, 4)
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_OneScoreAtMinValue_ParameterSet() {
    int score = 1;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScores(score)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("rating", Integer.toString(score)))
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_OneScoreAtMaxValue_ParameterSet() {
    int score = 5;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScores(score)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("rating", Integer.toString(score)))
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_MultipleScores_ParameterSet() {
    int score1 = 1;
    int score2 = 3;
    int score3 = 5;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScores(score1, score2, score3)
        .build();
    assertEquals(4, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("rating", Integer.toString(score1)))
    );
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("rating", Integer.toString(score2)))
    );
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("rating", Integer.toString(score3)))
    );
  }

  @Test
  public void builder$withFeedbackScoresCollection_ScoresNull_ParameterNotSet() {
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScores(null)
        .build();
    assertEquals(1, request.getQueryParameters().size()); // Only contains the merchant
  }

  @Test
  public void builder$withFeedbackScoresCollection_ScoresEmpty_ParameterNotSet() {
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScores(Collections.emptyList())
        .build();
    assertEquals(1, request.getQueryParameters().size()); // Only contains the merchant
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScores(Arrays.asList(1, null, 3))
    );
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreTooLow_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScores(Arrays.asList(2, 0, 3))
    );
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreTooHigh_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedServiceReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withFeedbackScores(Arrays.asList(2, 6, 3))
    );
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreAtMinValue_ParameterSet() {
    int score = 1;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScores(Collections.singletonList(score))
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters()
                      .contains(new QueryParameter("rating", Integer.toString(score))));
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreAtMaxValue_ParameterSet() {
    int score = 5;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScores(Collections.singletonList(score))
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters()
                      .contains(new QueryParameter("rating", Integer.toString(score))));
  }

  @Test
  public void builder$withFeedbackScoresCollection_MultipleScores_ParameterSet() {
    int score1 = 1;
    int score2 = 3;
    int score3 = 5;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackScores(Arrays.asList(score1, score2, score3))
        .build();
    assertEquals(4, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("rating", Integer.toString(score1)))
    );
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("rating", Integer.toString(score2)))
    );
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("rating", Integer.toString(score3)))
    );
  }

  @Test
  public void builder$withFeedbackFromSubMerchants_InclusionProvided_ParameterSet() {
    Inclusion inclusion = Inclusion.EXCLUDE;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeedbackFromSubMerchants(inclusion)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("children", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withMediaInclusion_InclusionProvided_ParameterSet() {
    MediaInclusion inclusion = MediaInclusion.MUST_HAVE_MEDIA;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withMediaInclusion(inclusion)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("media", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withUnansweredFeedbackInclusion_InclusionProvided_ParameterSet() {
    UnansweredFeedbackInclusion inclusion = UnansweredFeedbackInclusion.EXCLUDE_NEGATIVE;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withUnansweredFeedbackInclusion(inclusion)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("unanswered_feedback", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withFullThread_InclusionProvided_ParameterSet() {
    Inclusion inclusion = Inclusion.EXCLUDE;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFullThread(inclusion)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("full_thread", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withEnhancedInsight_InclusionProvided_ParameterSet() {
    Inclusion inclusion = Inclusion.EXCLUDE;
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withEnhancedInsight(inclusion)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("enhanced_insight", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withFeature_FeatureProvided_ParameterSet() {
    String feature = "test feature";
    EnrichedServiceReviewsRequest request = EnrichedServiceReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withFeature(feature)
        .build();
    assertEquals(2, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("feature", feature))
    );
  }

  private TagFilter createTagFilter(String queryValue) {
    TagFilter tagFilter = mock(TagFilter.class);
    when(tagFilter.toQueryValue()).thenReturn(queryValue);
    return tagFilter;
  }

}