package nb.fr.service.dto;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A DTO for the {@link nb.fr.domain.ApplicationUser} entity.
 */
@ApiModel(description = "ApplicationUser entity.\n@author Boubziz Nassim.")
public class ApplicationUserDTO implements Serializable {
    
    private Long id;

    private String profilBanner;

    private String profilBio;


    private Long internalUserId;
    private Set<ApplicationUserDTO> friends = new HashSet<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfilBanner() {
        return profilBanner;
    }

    public void setProfilBanner(String profilBanner) {
        this.profilBanner = profilBanner;
    }

    public String getProfilBio() {
        return profilBio;
    }

    public void setProfilBio(String profilBio) {
        this.profilBio = profilBio;
    }

    public Long getInternalUserId() {
        return internalUserId;
    }

    public void setInternalUserId(Long userId) {
        this.internalUserId = userId;
    }

    public Set<ApplicationUserDTO> getFriends() {
        return friends;
    }

    public void setFriends(Set<ApplicationUserDTO> applicationUsers) {
        this.friends = applicationUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUserDTO)) {
            return false;
        }

        return id != null && id.equals(((ApplicationUserDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUserDTO{" +
            "id=" + getId() +
            ", profilBanner='" + getProfilBanner() + "'" +
            ", profilBio='" + getProfilBio() + "'" +
            ", internalUserId=" + getInternalUserId() +
            ", friends='" + getFriends() + "'" +
            "}";
    }
}
