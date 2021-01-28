package org.richardinnocent.feefo.api.v10.reviews.all;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.richardinnocent.feefo.api.v10.reviews.all.ReviewsNpsResponse.Feedback.NetPromoterScore;
import org.richardinnocent.feefo.api.v10.reviews.all.ReviewsNpsResponse.Review.Tag;
import org.richardinnocent.feefo.api.v10.pagination.PaginationMetadata;

public class ReviewsNpsResponse {

  private Summary summary;
  private final List<Review> reviews = new ArrayList<>();

  public Summary getSummary() {
    return summary;
  }

  public void setSummary(Summary summary) {
    this.summary = summary;
  }

  public List<Review> getReviews() {
    return new ArrayList<>(reviews);
  }

  public void setReviews(List<Review> reviews) {
    this.reviews.clear();
    if (reviews != null) {
      this.reviews.addAll(reviews);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReviewsNpsResponse that = (ReviewsNpsResponse) o;
    return Objects.equals(summary, that.summary) && Objects
        .equals(reviews, that.reviews);
  }

  @Override
  public int hashCode() {
    return Objects.hash(summary, reviews);
  }

  /**
   * Contains summary metadata such as the pagination details.
   */
  public static class Summary {

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

  public static class Review {

    private Merchant merchant;

    @JsonProperty("last_updated_date")
    private LocalDateTime lastUpdatedDate;

    @JsonProperty("products_purchased")
    private final List<String> productsPurchased = new ArrayList<>();

    private final List<Tag> tags = new ArrayList<>();

    private String url;

    @JsonProperty("social")
    private SocialNetworks socialNetworks;

    private Customer customer;

    @JsonProperty("service")
    private ServiceFeedback serviceFeedback;

    @JsonProperty("products")
    private final List<ProductFeedback> productFeedback = new ArrayList<>();

    @JsonProperty("nps")
    private NetPromoterScore netPromoterScore;

    public Merchant getMerchant() {
      return merchant;
    }

    public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
    }

    public LocalDateTime getLastUpdatedDate() {
      return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
      this.lastUpdatedDate = lastUpdatedDate;
    }

    public List<String> getProductsPurchased() {
      return new ArrayList<>(productsPurchased);
    }

    public void setProductsPurchased(List<String> productsPurchased) {
      this.productsPurchased.clear();
      if (productsPurchased != null) {
        this.productsPurchased.addAll(productsPurchased);
      }
    }

    public List<Tag> getTags() {
      return new ArrayList<>(tags);
    }

    public void setTags(List<Tag> tags) {
      this.tags.clear();
      if (tags != null) {
        this.tags.addAll(tags);
      }
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public SocialNetworks getSocialNetworks() {
      return socialNetworks;
    }

    public void setSocialNetworks(SocialNetworks socialNetworks) {
      this.socialNetworks = socialNetworks;
    }

    public Customer getCustomer() {
      return customer;
    }

    public void setCustomer(Customer customer) {
      this.customer = customer;
    }

    public ServiceFeedback getServiceFeedback() {
      return serviceFeedback;
    }

    public void setServiceFeedback(ServiceFeedback serviceFeedback) {
      this.serviceFeedback = serviceFeedback;
    }

    public List<ProductFeedback> getProductFeedback() {
      return new ArrayList<>(productFeedback);
    }

    public void setProductFeedback(List<ProductFeedback> productFeedback) {
      this.productFeedback.clear();
      if (productFeedback != null) {
        this.productFeedback.addAll(productFeedback);
      }
    }

    public NetPromoterScore getNetPromoterScore() {
      return netPromoterScore;
    }

    public void setNetPromoterScore(NetPromoterScore netPromoterScore) {
      this.netPromoterScore = netPromoterScore;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Review review = (Review) o;
      return Objects.equals(merchant, review.merchant)
          && Objects.equals(lastUpdatedDate, review.lastUpdatedDate)
          && Objects.equals(productsPurchased, review.productsPurchased)
          && Objects.equals(tags, review.tags)
          && Objects.equals(url, review.url)
          && Objects.equals(socialNetworks, review.socialNetworks)
          && Objects.equals(customer, review.customer)
          && Objects.equals(serviceFeedback, review.serviceFeedback)
          && Objects.equals(productFeedback, review.productFeedback)
          && Objects.equals(netPromoterScore, review.netPromoterScore);
    }

    @Override
    public int hashCode() {
      return Objects.hash(
          merchant, lastUpdatedDate, productsPurchased, tags, url, socialNetworks, customer,
          serviceFeedback, productFeedback, netPromoterScore
      );
    }

    public static class Tag {
      private String key;
      private List<String> values;
      private TagType type;

      public String getKey() {
        return key;
      }

      public void setKey(String key) {
        this.key = key;
      }

      public List<String> getValues() {
        return values;
      }

      public void setValues(List<String> values) {
        this.values = values;
      }

      public TagType getType() {
        return type;
      }

      public void setType(TagType type) {
        this.type = type;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Tag tag = (Tag) o;
        return Objects.equals(key, tag.key) && Objects.equals(values, tag.values)
            && type == tag.type;
      }

      @Override
      public int hashCode() {
        return Objects.hash(key, values, type);
      }

      public enum TagType {
        SALE,
        PRODUCT,
        FEEDBACK
      }
    }

    public static class Merchant {
      private String identifier;

      public String getIdentifier() {
        return identifier;
      }

      public void setIdentifier(String identifier) {
        this.identifier = identifier;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Merchant merchant = (Merchant) o;
        return Objects.equals(identifier, merchant.identifier);
      }

      @Override
      public int hashCode() {
        return Objects.hash(identifier);
      }
    }

    public static class SocialNetworks {

      @JsonProperty("facebook")
      private String facebookPage;

      @JsonProperty("twitter")
      private String twitterPage;

      @JsonProperty("google_plus")
      private String googlePlusPage;

      public String getFacebookPage() {
        return facebookPage;
      }

      public void setFacebookPage(String facebookPage) {
        this.facebookPage = facebookPage;
      }

      public String getGooglePlusPage() {
        return googlePlusPage;
      }

      public void setGooglePlusPage(String googlePlusPage) {
        this.googlePlusPage = googlePlusPage;
      }

      public String getTwitterPage() {
        return twitterPage;
      }

      public void setTwitterPage(String twitterPage) {
        this.twitterPage = twitterPage;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        SocialNetworks that = (SocialNetworks) o;
        return Objects.equals(facebookPage, that.facebookPage)
            && Objects.equals(twitterPage, that.twitterPage)
            && Objects.equals(googlePlusPage, that.googlePlusPage);
      }

      @Override
      public int hashCode() {
        return Objects.hash(facebookPage, twitterPage, googlePlusPage);
      }
    }

    public static class Customer {

      @JsonProperty("display_name")
      private String displayName;

      @JsonProperty("display_location")
      private String displayLocation;

      private String name;

      private String email;

      @JsonProperty("mobile")
      private String mobileNumber;

      @JsonProperty("order_ref")
      private String orderReference;

      @JsonProperty("customer_ref")
      private String customerReference;

      public String getDisplayName() {
        return displayName;
      }

      public void setDisplayName(String displayName) {
        this.displayName = displayName;
      }

      public String getDisplayLocation() {
        return displayLocation;
      }

      public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public String getEmail() {
        return email;
      }

      public void setEmail(String email) {
        this.email = email;
      }

      public String getMobileNumber() {
        return mobileNumber;
      }

      public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
      }

      public String getOrderReference() {
        return orderReference;
      }

      public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
      }

      public String getCustomerReference() {
        return customerReference;
      }

      public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(displayName, customer.displayName)
            && Objects.equals(displayLocation, customer.displayLocation)
            && Objects.equals(name, customer.name)
            && Objects.equals(email, customer.email)
            && Objects.equals(mobileNumber, customer.mobileNumber)
            && Objects.equals(orderReference, customer.orderReference)
            && Objects.equals(customerReference, customer.customerReference);
      }

      @Override
      public int hashCode() {
        return Objects.hash(displayName, displayLocation);
      }
    }
  }

  public static class ServiceFeedback extends Feedback {
    private String title;

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      if (!super.equals(o)) {
        return false;
      }
      ServiceFeedback that = (ServiceFeedback) o;
      return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
      return Objects.hash(super.hashCode(), title);
    }
  }

  public static class ProductFeedback extends Feedback {

    private Product product;

    public Product getProduct() {
      return product;
    }

    public void setProduct(Product product) {
      this.product = product;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      if (!super.equals(o)) {
        return false;
      }
      ProductFeedback that = (ProductFeedback) o;
      return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
      return Objects.hash(super.hashCode(), product);
    }

    public static class Product {
      private String title;

      @JsonProperty("parent_sku")
      private String parentSku;

      private String sku;

      private String url;

      private final List<Tag> tags = new ArrayList<>();

      @JsonProperty("reviews_url")
      private String reviewsUrl;

      @JsonProperty("image_url")
      private String imageUrl;

      public String getTitle() {
        return title;
      }

      public void setTitle(String title) {
        this.title = title;
      }

      public String getSku() {
        return sku;
      }

      public void setSku(String sku) {
        this.sku = sku;
      }

      public String getUrl() {
        return url;
      }

      public void setUrl(String url) {
        this.url = url;
      }

      public String getReviewsUrl() {
        return reviewsUrl;
      }

      public void setReviewsUrl(String reviewsUrl) {
        this.reviewsUrl = reviewsUrl;
      }

      public String getParentSku() {
        return parentSku;
      }

      public void setParentSku(String parentSku) {
        this.parentSku = parentSku;
      }

      public List<Tag> getTags() {
        return new ArrayList<>(tags);
      }

      public void setTags(List<Tag> tags) {
        this.tags.clear();
        if (tags != null) {
          this.tags.addAll(tags);
        }
      }

      public String getImageUrl() {
        return imageUrl;
      }

      public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Product product = (Product) o;
        return Objects.equals(title, product.title)
            && Objects.equals(parentSku, product.parentSku)
            && Objects.equals(sku, product.sku)
            && Objects.equals(url, product.url)
            && Objects.equals(tags, product.tags)
            && Objects.equals(reviewsUrl, product.reviewsUrl)
            && Objects.equals(imageUrl, product.imageUrl);
      }

      @Override
      public int hashCode() {
        return Objects.hash(title, parentSku, sku, url, tags, reviewsUrl, imageUrl);
      }
    }

    public static class Attribute {
      private String name;

      @JsonProperty("min")
      private double minimumAssignableRating;

      @JsonProperty("max")
      private double maximumAssignableRating;

      private double rating;

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      public double getMinimumAssignableRating() {
        return minimumAssignableRating;
      }

      public void setMinimumAssignableRating(double minimumAssignableRating) {
        this.minimumAssignableRating = minimumAssignableRating;
      }

      public double getMaximumAssignableRating() {
        return maximumAssignableRating;
      }

      public void setMaximumAssignableRating(double maximumAssignableRating) {
        this.maximumAssignableRating = maximumAssignableRating;
      }

      public double getRating() {
        return rating;
      }

      public void setRating(double rating) {
        this.rating = rating;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Attribute attribute = (Attribute) o;
        return Double.compare(attribute.minimumAssignableRating, minimumAssignableRating) == 0
            && Double.compare(attribute.maximumAssignableRating, maximumAssignableRating) == 0
            && Double.compare(attribute.rating, rating) == 0 && Objects
            .equals(name, attribute.name);
      }

      @Override
      public int hashCode() {
        return Objects.hash(name, minimumAssignableRating, maximumAssignableRating, rating);
      }
    }
  }

  public static abstract class Feedback {

    private Rating rating;
    private String id;
    private String review;

    @JsonProperty("created_at")
    private LocalDateTime creationTime;

    @JsonProperty("helpful_votes")
    private Integer helpfulVotes;

    private final List<Media> media = new ArrayList<>();

    private final List<CustomQuestion> customQuestions = new ArrayList<>();

    private Sentiment sentiment;

    @JsonProperty("thread")
    private final List<ThreadEntry> commentThread = new ArrayList<>();

    public Rating getRating() {
      return rating;
    }

    public void setRating(Rating rating) {
      this.rating = rating;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getReview() {
      return review;
    }

    public void setReview(String review) {
      this.review = review;
    }

    public LocalDateTime getCreationTime() {
      return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
      this.creationTime = creationTime;
    }

    public Integer getHelpfulVotes() {
      return helpfulVotes;
    }

    public void setHelpfulVotes(Integer helpfulVotes) {
      this.helpfulVotes = helpfulVotes;
    }

    public List<Media> getMedia() {
      return new ArrayList<>(media);
    }

    public void setMedia(List<Media> media) {
      this.media.clear();
      if (media != null) {
        this.media.addAll(media);
      }
    }

    public void setCustomQuestions(List<CustomQuestion> customQuestions) {
      this.customQuestions.clear();
      if (customQuestions != null) {
        this.customQuestions.addAll(customQuestions);
      }
    }

    public List<CustomQuestion> getCustomQuestions() {
      return new ArrayList<>(customQuestions);
    }

    public Sentiment getSentiment() {
      return sentiment;
    }

    public void setSentiment(Sentiment sentiment) {
      this.sentiment = sentiment;
    }

    public List<ThreadEntry> getCommentThread() {
      return new ArrayList<>(commentThread);
    }

    public void setCommentThread(List<ThreadEntry> commentThread) {
      this.commentThread.clear();
      if (commentThread != null) {
        this.commentThread.addAll(commentThread);
      }
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Feedback feedback = (Feedback) o;
      return helpfulVotes == feedback.helpfulVotes && Objects.equals(rating, feedback.rating)
          && Objects.equals(id, feedback.id) && Objects
          .equals(review, feedback.review) && Objects
          .equals(creationTime, feedback.creationTime);
    }

    @Override
    public int hashCode() {
      return Objects.hash(rating, id, review, creationTime, helpfulVotes);
    }

    public static class Rating {
      @JsonProperty("min")
      private int minimumAssignableRating;

      @JsonProperty("max")
      private int maximumAssignableRating;

      private int rating;

      public int getMinimumAssignableRating() {
        return minimumAssignableRating;
      }

      public void setMinimumAssignableRating(int minimumAssignableRating) {
        this.minimumAssignableRating = minimumAssignableRating;
      }

      public int getMaximumAssignableRating() {
        return maximumAssignableRating;
      }

      public void setMaximumAssignableRating(int maximumAssignableRating) {
        this.maximumAssignableRating = maximumAssignableRating;
      }

      public int getRating() {
        return rating;
      }

      public void setRating(int rating) {
        this.rating = rating;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        Rating rating1 = (Rating) o;
        return minimumAssignableRating == rating1.minimumAssignableRating
            && maximumAssignableRating == rating1.maximumAssignableRating && rating == rating1.rating;
      }

      @Override
      public int hashCode() {
        return Objects.hash(minimumAssignableRating, maximumAssignableRating, rating);
      }
    }

    public static class Media {
      private String id;

      // TODO make this an enum
      private String type;

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

      public String getType() {
        return type;
      }

      public void setType(String type) {
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
        return helpfulVotes == media.helpfulVotes && Objects.equals(id, media.id)
            && Objects.equals(type, media.type) && Objects.equals(url, media.url)
            && Objects.equals(thumbnailUrl, media.thumbnailUrl) && Objects
            .equals(caption, media.caption) && Objects.equals(questionId, media.questionId);
      }

      @Override
      public int hashCode() {
        return Objects.hash(id, type, url, thumbnailUrl, caption, helpfulVotes, questionId);
      }
    }

    public static class CustomQuestion {
      @JsonProperty("question_id")
      private String id;

      private String question;

      private String answer;

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }

      public String getQuestion() {
        return question;
      }

      public void setQuestion(String question) {
        this.question = question;
      }

      public String getAnswer() {
        return answer;
      }

      public void setAnswer(String answer) {
        this.answer = answer;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        CustomQuestion that = (CustomQuestion) o;
        return Objects.equals(id, that.id) && Objects.equals(question, that.question)
            && Objects.equals(answer, that.answer);
      }

      @Override
      public int hashCode() {
        return Objects.hash(id, question, answer);
      }
    }

    public static class Sentiment {

      private final List<Feature> features = new ArrayList<>();

      @JsonProperty("positive_snippets")
      private final List<Feature> positiveSnippets = new ArrayList<>();

      @JsonProperty("negative_snippets")
      private final List<Feature> negativeSnippets = new ArrayList<>();

      public void setFeatures(List<Feature> features) {
        this.features.clear();
        if (features != null) {
          this.features.addAll(features);
        }
      }

      public List<Feature> getFeatures() {
        return new ArrayList<>(features);
      }

      public void setPositiveSnippets(List<Feature> positiveSnippets) {
        this.positiveSnippets.clear();
        if (positiveSnippets != null) {
          this.positiveSnippets.addAll(features);
        }
      }

      public List<Feature> getPositiveSnippets() {
        return new ArrayList<>(positiveSnippets);
      }

      public void setNegativeSnippets(List<Feature> negativeSnippets) {
        this.negativeSnippets.clear();
        if (negativeSnippets != null) {
          this.negativeSnippets.addAll(negativeSnippets);
        }
      }

      public List<Feature> getNegativeSnippets() {
        return new ArrayList<>(negativeSnippets);
      }

      public static class Feature {
        private String text;
        private double score;

        public String getText() {
          return text;
        }

        public void setText(String text) {
          this.text = text;
        }

        public double getScore() {
          return score;
        }

        public void setScore(double score) {
          this.score = score;
        }

        @Override
        public boolean equals(Object o) {
          if (this == o) {
            return true;
          }
          if (o == null || getClass() != o.getClass()) {
            return false;
          }
          Feature feature = (Feature) o;
          return Double.compare(feature.score, score) == 0 && Objects
              .equals(text, feature.text);
        }

        @Override
        public int hashCode() {
          return Objects.hash(text, score);
        }
      }
    }

    public static class ThreadEntry {

      @JsonProperty("created_at")
      private LocalDateTime creationTime;

      // TODO convert to enum
      private String type;

      private String author;

      private String comment;

      @JsonProperty("old_rating")
      private Integer previousRating;

      @JsonProperty("new_rating")
      private Integer newRating;

      @JsonProperty("old_title")
      private String previousTitle;

      @JsonProperty("new_title")
      private String newTitle;

      public LocalDateTime getCreationTime() {
        return creationTime;
      }

      public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
      }

      public String getType() {
        return type;
      }

      public void setType(String type) {
        this.type = type;
      }

      public String getAuthor() {
        return author;
      }

      public void setAuthor(String author) {
        this.author = author;
      }

      public String getComment() {
        return comment;
      }

      public void setComment(String comment) {
        this.comment = comment;
      }

      public Integer getPreviousRating() {
        return previousRating;
      }

      public void setPreviousRating(Integer previousRating) {
        this.previousRating = previousRating;
      }

      public Integer getNewRating() {
        return newRating;
      }

      public void setNewRating(Integer newRating) {
        this.newRating = newRating;
      }

      public String getPreviousTitle() {
        return previousTitle;
      }

      public void setPreviousTitle(String previousTitle) {
        this.previousTitle = previousTitle;
      }

      public String getNewTitle() {
        return newTitle;
      }

      public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        ThreadEntry that = (ThreadEntry) o;
        return Objects.equals(creationTime, that.creationTime)
            && Objects.equals(type, that.type) && Objects.equals(author, that.author)
            && Objects.equals(comment, that.comment)
            && Objects.equals(previousRating, that.previousRating)
            && Objects.equals(newRating, that.newRating)
            && Objects.equals(previousTitle, that.previousTitle)
            && Objects.equals(newTitle, that.newTitle);
      }

      @Override
      public int hashCode() {
        return Objects.hash(
            creationTime, type, author, comment, previousRating, newRating, previousTitle, newTitle
        );
      }
    }

    public static class NetPromoterScore {

      @JsonProperty("created_at")
      private LocalDateTime creationTime;

      private Integer rating;

      private String reason;

      public LocalDateTime getCreationTime() {
        return creationTime;
      }

      public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
      }

      public Integer getRating() {
        return rating;
      }

      public void setRating(Integer rating) {
        this.rating = rating;
      }

      public String getReason() {
        return reason;
      }

      public void setReason(String reason) {
        this.reason = reason;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) {
          return true;
        }
        if (o == null || getClass() != o.getClass()) {
          return false;
        }
        NetPromoterScore that = (NetPromoterScore) o;
        return Objects.equals(creationTime, that.creationTime) && Objects
            .equals(rating, that.rating) && Objects.equals(reason, that.reason);
      }

      @Override
      public int hashCode() {
        return Objects.hash(creationTime, rating, reason);
      }
    }

  }

}
