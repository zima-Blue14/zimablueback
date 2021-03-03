package nb.fr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ApplicationUser entity.\n@author Boubziz Nassim.
 */
@Entity
@Table(name = "application_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "profil_banner")
    private String profilBanner;

    @Column(name = "profil_bio")
    private String profilBio;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private User internalUser;

    @OneToMany(mappedBy = "applicationUser")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Article> articles = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "application_user_friends",
               joinColumns = @JoinColumn(name = "application_user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "friends_id", referencedColumnName = "id"))
    private Set<ApplicationUser> friends = new HashSet<>();

    @ManyToMany(mappedBy = "friends")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnore
    private Set<ApplicationUser> followers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfilBanner() {
        return profilBanner;
    }

    public ApplicationUser profilBanner(String profilBanner) {
        this.profilBanner = profilBanner;
        return this;
    }

    public void setProfilBanner(String profilBanner) {
        this.profilBanner = profilBanner;
    }

    public String getProfilBio() {
        return profilBio;
    }

    public ApplicationUser profilBio(String profilBio) {
        this.profilBio = profilBio;
        return this;
    }

    public void setProfilBio(String profilBio) {
        this.profilBio = profilBio;
    }

    public User getInternalUser() {
        return internalUser;
    }

    public ApplicationUser internalUser(User user) {
        this.internalUser = user;
        return this;
    }

    public void setInternalUser(User user) {
        this.internalUser = user;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public ApplicationUser articles(Set<Article> articles) {
        this.articles = articles;
        return this;
    }

    public ApplicationUser addArticle(Article article) {
        this.articles.add(article);
        article.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeArticle(Article article) {
        this.articles.remove(article);
        article.setApplicationUser(null);
        return this;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Set<ApplicationUser> getFriends() {
        return friends;
    }

    public ApplicationUser friends(Set<ApplicationUser> applicationUsers) {
        this.friends = applicationUsers;
        return this;
    }

    public ApplicationUser addFriends(ApplicationUser applicationUser) {
        this.friends.add(applicationUser);
        applicationUser.getFollowers().add(this);
        return this;
    }

    public ApplicationUser removeFriends(ApplicationUser applicationUser) {
        this.friends.remove(applicationUser);
        applicationUser.getFollowers().remove(this);
        return this;
    }

    public void setFriends(Set<ApplicationUser> applicationUsers) {
        this.friends = applicationUsers;
    }

    public Set<ApplicationUser> getFollowers() {
        return followers;
    }

    public ApplicationUser followers(Set<ApplicationUser> applicationUsers) {
        this.followers = applicationUsers;
        return this;
    }

    public ApplicationUser addFollowers(ApplicationUser applicationUser) {
        this.followers.add(applicationUser);
        applicationUser.getFriends().add(this);
        return this;
    }

    public ApplicationUser removeFollowers(ApplicationUser applicationUser) {
        this.followers.remove(applicationUser);
        applicationUser.getFriends().remove(this);
        return this;
    }

    public void setFollowers(Set<ApplicationUser> applicationUsers) {
        this.followers = applicationUsers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUser)) {
            return false;
        }
        return id != null && id.equals(((ApplicationUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUser{" +
            "id=" + getId() +
            ", profilBanner='" + getProfilBanner() + "'" +
            ", profilBio='" + getProfilBio() + "'" +
            "}";
    }
}
