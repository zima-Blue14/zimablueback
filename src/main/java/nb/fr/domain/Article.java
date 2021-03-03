package nb.fr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Article entity.\n@author Boubziz Nassim.
 */
@Entity
@Table(name = "article")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "article_body", nullable = false)
    private String articleBody;

    @NotNull
    @Column(name = "date_article", nullable = false)
    private LocalDate dateArticle;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @NotNull
    @JoinTable(name = "article_tags",
               joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "tags_id", referencedColumnName = "id"))
    private Set<Tag> tags = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "articles", allowSetters = true)
    private ApplicationUser applicationUser;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Article userId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public Article title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public Article articleBody(String articleBody) {
        this.articleBody = articleBody;
        return this;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public LocalDate getDateArticle() {
        return dateArticle;
    }

    public Article dateArticle(LocalDate dateArticle) {
        this.dateArticle = dateArticle;
        return this;
    }

    public void setDateArticle(LocalDate dateArticle) {
        this.dateArticle = dateArticle;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Article tags(Set<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Article addTags(Tag tag) {
        this.tags.add(tag);
        tag.getArticles().add(this);
        return this;
    }

    public Article removeTags(Tag tag) {
        this.tags.remove(tag);
        tag.getArticles().remove(this);
        return this;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public Article applicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
        return this;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Article)) {
            return false;
        }
        return id != null && id.equals(((Article) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Article{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            ", title='" + getTitle() + "'" +
            ", articleBody='" + getArticleBody() + "'" +
            ", dateArticle='" + getDateArticle() + "'" +
            "}";
    }
}
