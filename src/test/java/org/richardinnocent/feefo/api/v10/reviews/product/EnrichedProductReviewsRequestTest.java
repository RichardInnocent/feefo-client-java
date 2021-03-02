package org.richardinnocent.feefo.api.v10.reviews.product;

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
import org.richardinnocent.feefo.api.v10.reviews.product.params.SortField;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.EmptyProductCommentInclusion;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.Inclusion;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.MediaInclusion;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.TagFilter;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.TimeFrame;
import org.richardinnocent.feefo.api.v10.reviews.shared.params.UnansweredFeedbackInclusion;

class EnrichedProductReviewsRequestTest {

  @Test
  public void getBasePath_Always_AsExpected() {
    assertEquals(
        "/10/reviews/product",
        EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .build()
            .getBasePath()
    );
  }

  @Test
  public void getRequestParameters_Always_SpecifiesMerchantIdentifierAndProductOrParentSku() {
    String merchantIdentifier = "test-merchant";
    String productSku = "test-product-sku";
    String parentSku = "test-parent-sku";

    Collection<QueryParameter> expectedParametersWithProductSku = Arrays.asList(
        new QueryParameter("merchant_identifier", EqualityOperator.EQUALS, merchantIdentifier),
        new QueryParameter("product_sku", "test-product-sku")
    );
    assertEquals(
        expectedParametersWithProductSku,
        EnrichedProductReviewsRequest
            .builder()
            .forMerchant(merchantIdentifier)
            .withProductSku(productSku)
            .build()
            .getQueryParameters()
    );

    Collection<QueryParameter> expectedParametersWithParentSku = Arrays.asList(
        new QueryParameter("merchant_identifier", EqualityOperator.EQUALS, merchantIdentifier),
        new QueryParameter("parent_product_sku", "test-parent-sku")
    );
    assertEquals(
        expectedParametersWithParentSku,
        EnrichedProductReviewsRequest
            .builder()
            .forMerchant(merchantIdentifier)
            .withParentProductSku(parentSku)
            .build()
            .getQueryParameters()
    );
  }

  @Test
  public void requiresAuthentication_Always_ReturnsTrue() {
    assertTrue(
        EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .build()
            .requiresAuthentication()
    );
  }

  @Test
  public void builder$forMerchant_MerchantIdentifierIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest.builder().forMerchant(null)
    );
  }

  @Test
  public void builder$forMerchant_MerchantIdentifierIsEmpty_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest.builder().forMerchant("")
    );
  }

  @Test
  public void builder$withProductSku_ProductSkuIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () ->
            EnrichedProductReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withProductSku(null)
    );
  }

  @Test
  public void builder$withProductSku_ProductSkuIsEmpty_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            EnrichedProductReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withProductSku("")
    );
  }

  @Test
  public void builder$withParentProductSku_ParentProductSkuIsNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () ->
            EnrichedProductReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withProductSku(null)
    );
  }

  @Test
  public void builder$withParentProductSku_ParentProductSkuIsEmpty_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            EnrichedProductReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withParentProductSku("")
    );
  }

  @Test
  public void builder$withSortField_NotNull_SetsParameter() {
    SortField sortField = SortField.HELPFUL_VOTES;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withSortField(sortField)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(3, queryParameters.size());
    assertTrue(queryParameters.contains(new QueryParameter("sort", sortField.getQueryKey())));
  }

  @Test
  public void builder$withPage_PositivePage_SetsParameter() {
    int page = 5;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withPage(page)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(3, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page", Integer.toString(page)))
    );
  }

  @Test
  public void builder$withPage_SmallestAllowablePage_SetsParameter() {
    int page = 1;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withPage(page)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(3, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page", Integer.toString(page)))
    );
  }

  @Test
  public void builder$withPage_PageIsZero_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            EnrichedProductReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withProductSku("test-product-sku")
                .withPage(0)
    );
  }

  @Test
  public void builder$withPage_PageIsNegative_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () ->
            EnrichedProductReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withProductSku("test-product-sku")
                .withPage(-1)
    );
  }

  @Test
  public void builder$withPageSize_Valid_SetsParameter() {
    int pageSize = 5;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withPageSize(pageSize)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(3, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page_size", Integer.toString(pageSize)))
    );
  }

  @Test
  public void builder$withPageSize_MinimumAllowedSize_SetsParameter() {
    int pageSize = 1;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withPageSize(pageSize)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(3, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page_size", Integer.toString(pageSize)))
    );
  }

  @Test
  public void builder$withPageSize_MaximumAllowedSize_SetsParameter() {
    int pageSize = 100;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withPageSize(pageSize)
        .build();
    Collection<QueryParameter> queryParameters = request.getQueryParameters();
    assertEquals(3, queryParameters.size());
    assertTrue(
        queryParameters.contains(new QueryParameter("page_size", Integer.toString(pageSize)))
    );
  }

  @Test
  public void builder$withPageSize_SizeTooSmall_ThrowsException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withPageSize(0)
            .build()
    );
  }

  @Test
  public void builder$withPageSize_SizeTooLarge_ThrowsException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withPageSize(101)
            .build()
    );
  }

  @Test
  public void builder$withResponseField_FieldNotNull_SetsParameter() {
    String field = "testField";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withResponseField(field)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("fields", field)));
  }

  @Test
  public void builder$withResponseField_FieldNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withResponseField(null)
    );
  }

  @Test
  public void builder$withResponseFieldsVarargs_FirstFieldNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withResponseFields(null, "testField")
    );
  }

  @Test
  public void builder$withResponseFieldsVarargs_LaterFieldNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withResponseFields("testField1", "testField2", null, "testField3")
    );
  }

  @Test
  public void builder$withResponseFieldsVarargs_OneField_ParameterSet() {
    String field = "testField";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withResponseFields(field)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("fields", field)));
  }

  @Test
  public void builder$withResponseFieldsVarargs_MultipleFields_ParameterSet() {
    String field1 = "testField1";
    String field2 = "testField2";
    String field3 = "testField3";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withResponseFields(field1, field2, field3)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("fields", field1 + ',' + field2 + ',' + field3))
    );
  }

  @Test
  public void builder$withResponseFieldsCollection_FieldsNull_ParameterNotSet() {
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withResponseFields(null)
        .build();
    // Only contains the merchant and product SKU
    assertEquals(2, request.getQueryParameters().size());
  }

  @Test
  public void builder$withResponseFieldsCollection_FieldsEmpty_ParameterNotSet() {
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withResponseFields(Collections.emptyList())
        .build();
    // Only contains the merchant and product SKU
    assertEquals(2, request.getQueryParameters().size());
  }

  @Test
  public void builder$withResponseFieldsCollection_OneFieldNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withResponseFields(Arrays.asList("testField1", null, "testField3"))
    );
  }

  @Test
  public void builder$withResponseFieldsCollection_OneField_ParameterSet() {
    String field = "testField";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withResponseFields(Collections.singletonList(field))
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("fields", field)));
  }

  @Test
  public void builder$withResponseFieldsCollection_MultipleFields_ParameterSet() {
    String field1 = "testField1";
    String field2 = "testField2";
    String field3 = "testField3";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withResponseFields(Arrays.asList(field1, field2, field3))
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("fields", field1 + ',' + field2 + ',' + field3))
    );
  }

  @Test
  public void builder$withTagFilter_FilterNotNull_SetsParameter() {
    String result = "result";
    TagFilter tagFilter = createTagFilter(result);

    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withTagFilter(tagFilter)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters().contains(new QueryParameter("tags", result)));
  }

  @Test
  public void builder$withTagFilter_FilterNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withTagFilter(null)
    );
  }

  @Test
  public void builder$withTagFilterVarargs_FirstFilterNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withTagFilters(null, mock(TagFilter.class))
    );
  }

  @Test
  public void builder$withTagFiltersVarargs_LaterFilterNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
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
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withTagFilters(tagFilter)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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

    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withTagFilters(tagFilter1, tagFilter2, tagFilter3)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("tags", result1 + ',' + result2 + ',' + result3))
    );
  }

  @Test
  public void builder$withTagFiltersCollection_FiltersNull_ParameterNotSet() {
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withTagFilters(null)
        .build();
    // Only contains the merchant and product SKU
    assertEquals(2, request.getQueryParameters().size());
  }

  @Test
  public void builder$withTagFiltersCollection_FiltersEmpty_ParameterNotSet() {
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withTagFilters(Collections.emptyList())
        .build();
    // Only contains the merchant and product SKU
    assertEquals(2, request.getQueryParameters().size());
  }

  @Test
  public void builder$withTagFiltersCollection_OneFilterNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withTagFilters(Arrays.asList(mock(TagFilter.class), null, mock(TagFilter.class)))
    );
  }

  @Test
  public void builder$withTagFiltersCollection_OneField_ParameterSet() {
    String result = "result";
    TagFilter tagFilter = createTagFilter(result);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withTagFilters(Collections.singletonList(tagFilter))
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withTagFilters(Arrays.asList(tagFilter1, tagFilter2, tagFilter3))
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("tags", result1 + ',' + result2 + ',' + result3))
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtExactly_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewCreationTimeAtExactly(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("date_time", dateTime.toString()))
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtExactly_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewCreationTimeAtExactly(null)
    );
  }

  @Test
  public void builder$withReviewCreationTimeBefore_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewCreationTimeBefore(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewCreationTimeBefore(null)
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtOrBefore_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewCreationTimeAtOrBefore(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewCreationTimeAtOrBefore(null)
    );
  }

  @Test
  public void builder$withReviewCreationAfter_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewCreationTimeAfter(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewCreationTimeAfter(null)
    );
  }

  @Test
  public void builder$withReviewCreationTimeAtOrAfter_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewCreationTimeAtOrAfter(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewUpdatedTimeAtExactly(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("updated_date_time", dateTime.toString()))
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAtExactly_DateNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewUpdatedTimeAtExactly(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeBefore_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewUpdatedTimeBefore(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewUpdatedTimeBefore(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAtOrBefore_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewUpdatedTimeAtOrBefore(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewUpdatedTimeAtOrBefore(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedAfter_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewUpdatedTimeAfter(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewUpdatedTimeAfter(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedTimeAtOrAfter_DateProvided_ParameterSet() {
    OffsetDateTime dateTime = OffsetDateTime.of(2021, 2, 12, 20, 40, 0, 0, ZoneOffset.UTC);
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewUpdatedTimeAtOrAfter(dateTime)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withReviewUpdatedTimeAtOrAfter(null)
    );
  }

  @Test
  public void builder$withReviewCreatedIn_TimeFrameProvided_ParameterSet() {
    TimeFrame timeFrame = TimeFrame.LAST_WEEK;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewCreatedIn(timeFrame)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
            EnrichedProductReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withProductSku("test-product-sku")
                .withReviewCreatedIn(null)
    );
  }

  @Test
  public void builder$withReviewUpdatedIn_TimeFrameProvided_ParameterSet() {
    TimeFrame timeFrame = TimeFrame.LAST_WEEK;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withReviewUpdatedIn(timeFrame)
        .build();
    assertEquals(3, request.getQueryParameters().size());
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
            EnrichedProductReviewsRequest
                .builder()
                .forMerchant("test-merchant")
                .withProductSku("test-product-sku")
                .withReviewUpdatedIn(null)
    );
  }

  @Test
  public void builder$withRequestOrigin_OriginProvided_ParameterSet() {
    String origin = "test origin";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withRequestOrigin(origin)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("origin", origin))
    );
  }

  @Test
  public void builder$withFeedbackId_FeedbackIdProvided_ParameterSet() {
    String feedbackId = "feedbackId";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackId(feedbackId)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("id", feedbackId))
    );
  }

  @Test
  public void builder$withParentProductSku_SkuIdProvided_ParameterSet() {
    String productSku = "product-sku";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
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
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
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
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withCustomerReference(customerReference)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("customer_reference", customerReference))
    );
  }

  @Test
  public void builder$withCustomerEmail_EmailProvided_ParameterSet() {
    String email = "customer@test.com";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withCustomerEmail(email)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("customer_email", email))
    );
  }

  @Test
  public void builder$withOrderReference_ReferenceProvided_ParameterSet() {
    String reference = "order-ref";
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withOrderReference(reference)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("order_reference", reference))
    );
  }

  @Test
  public void builder$withFeedbackScore_MinimumAllowedScore_ParameterSet() {
    int score = 1;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScore(score)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("rating", Integer.toString(score)))
    );
  }

  @Test
  public void builder$withFeedbackScore_MaximumAllowedScore_ParameterSet() {
    int score = 5;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScore(score)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("rating", Integer.toString(score)))
    );
  }

  @Test
  public void builder$withFeedbackScore_ScoreTooLow_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScore(0)
    );
  }

  @Test
  public void builder$withFeedbackScore_ScoreTooHigh_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScore(6)
    );
  }

  @Test
  public void builder$withFeedbackScoreVarargs_FirstScoreTooLow_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScores(0, 2, 3)
    );
  }

  @Test
  public void builder$withFeedbackScoreVarargs_FirstScoreTooHigh_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScores(6, 2, 3)
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_LaterScoreTooLow_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScores(2, 3, 0, 4)
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_LaterScoreTooHigh_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScores(2, 3, 6, 4)
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_OneScoreAtMinValue_ParameterSet() {
    int score = 1;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScores(score)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("rating", Integer.toString(score)))
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_OneScoreAtMaxValue_ParameterSet() {
    int score = 5;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScores(score)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters().contains(new QueryParameter("rating", Integer.toString(score)))
    );
  }

  @Test
  public void builder$withFeedbackScoresVarargs_MultipleScores_ParameterSet() {
    int score1 = 1;
    int score2 = 3;
    int score3 = 5;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScores(score1, score2, score3)
        .build();
    assertEquals(5, request.getQueryParameters().size());
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
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScores(null)
        .build();
    // Only contains the merchant and product SKU
    assertEquals(2, request.getQueryParameters().size());
  }

  @Test
  public void builder$withFeedbackScoresCollection_ScoresEmpty_ParameterNotSet() {
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScores(Collections.emptyList())
        .build();
    // Only contains the merchant and product SKU
    assertEquals(2, request.getQueryParameters().size());
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreNull_ExceptionThrown() {
    assertThrows(
        NullPointerException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScores(Arrays.asList(1, null, 3))
    );
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreTooLow_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScores(Arrays.asList(2, 0, 3))
    );
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreTooHigh_ExceptionThrown() {
    assertThrows(
        IllegalArgumentException.class,
        () -> EnrichedProductReviewsRequest
            .builder()
            .forMerchant("test-merchant")
            .withProductSku("test-product-sku")
            .withFeedbackScores(Arrays.asList(2, 6, 3))
    );
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreAtMinValue_ParameterSet() {
    int score = 1;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScores(Collections.singletonList(score))
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters()
                      .contains(new QueryParameter("rating", Integer.toString(score))));
  }

  @Test
  public void builder$withFeedbackScoresCollection_OneScoreAtMaxValue_ParameterSet() {
    int score = 5;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScores(Collections.singletonList(score))
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(request.getQueryParameters()
                      .contains(new QueryParameter("rating", Integer.toString(score))));
  }

  @Test
  public void builder$withFeedbackScoresCollection_MultipleScores_ParameterSet() {
    int score1 = 1;
    int score2 = 3;
    int score3 = 5;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackScores(Arrays.asList(score1, score2, score3))
        .build();
    assertEquals(5, request.getQueryParameters().size());
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
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFeedbackFromSubMerchants(inclusion)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("children", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withMediaInclusion_InclusionProvided_ParameterSet() {
    MediaInclusion inclusion = MediaInclusion.MUST_HAVE_MEDIA;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withMediaInclusion(inclusion)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("media", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withEmptyProductCommentInclusion_InclusionProvided_ParameterSet() {
    EmptyProductCommentInclusion inclusion = EmptyProductCommentInclusion.INJECT_DEFAULT_COMMENT;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withEmptyProductCommentInclusion(inclusion)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("empty_product_comments", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withUnansweredFeedbackInclusion_InclusionProvided_ParameterSet() {
    UnansweredFeedbackInclusion inclusion = UnansweredFeedbackInclusion.EXCLUDE_NEGATIVE;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withUnansweredFeedbackInclusion(inclusion)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("unanswered_feedback", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withFullThread_InclusionProvided_ParameterSet() {
    Inclusion inclusion = Inclusion.EXCLUDE;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withFullThread(inclusion)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("full_thread", inclusion.getQueryValue()))
    );
  }

  @Test
  public void builder$withEnhancedInsight_InclusionProvided_ParameterSet() {
    Inclusion inclusion = Inclusion.EXCLUDE;
    EnrichedProductReviewsRequest request = EnrichedProductReviewsRequest
        .builder()
        .forMerchant("test-merchant")
        .withProductSku("test-product-sku")
        .withEnhancedInsight(inclusion)
        .build();
    assertEquals(3, request.getQueryParameters().size());
    assertTrue(
        request.getQueryParameters()
               .contains(new QueryParameter("enhanced_insight", inclusion.getQueryValue()))
    );
  }

  private TagFilter createTagFilter(String queryValue) {
    TagFilter tagFilter = mock(TagFilter.class);
    when(tagFilter.toQueryValue()).thenReturn(queryValue);
    return tagFilter;
  }

}