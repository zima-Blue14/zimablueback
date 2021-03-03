package nb.fr.service.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link nb.fr.domain.Article} entity.
 */
@ApiModel(description = "Article entity.\n@author Boubziz Nassim.")
public class ArticleDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer userId;

    @NotNull
    private String title;

    @NotNull
    private String articleBody;

    @NotNull
    private LocalDate dateArticle;

    private Set<TagDTO> tags = new HashSet<>();

    private Long applicationUserId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public LocalDate getDateArticle() {
        return dateArticle;
    }

    public void setDateArticle(LocalDate dateArticle) {
        this.dateArticle = dateArticle;
    }

    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
    }

    public Long getApplicationUserId() {
        return applicationUserId;
    }

    public void setApplicationUserId(Long applicationUserId) {
        this.applicationUserId = applicationUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ArticleDTO)) {
            return false;
        }

        return id != null && id.equals(((ArticleDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ArticleDTO{" +
            "id=" + getId() +
            ", userId=" + getUserId() +
            ", title='" + getTitle() + "'" +
            ", articleBody='" + getArticleBody() + "'" +
            ", dateArticle='" + getDateArticle() + "'" +
            ", tags='" + getTags() + "'" +
            ", applicationUserId=" + getApplicationUserId() +
            "}";
    }
}
