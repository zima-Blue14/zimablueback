package nb.fr.service.mapper;


import nb.fr.domain.*;
import nb.fr.service.dto.ApplicationUserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ApplicationUser} and its DTO {@link ApplicationUserDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface ApplicationUserMapper extends EntityMapper<ApplicationUserDTO, ApplicationUser> {

    @Mapping(source = "internalUser.id", target = "internalUserId")
    ApplicationUserDTO toDto(ApplicationUser applicationUser);

    @Mapping(source = "internalUserId", target = "internalUser")
    @Mapping(target = "articles", ignore = true)
    @Mapping(target = "removeArticle", ignore = true)
    @Mapping(target = "removeFriends", ignore = true)
    @Mapping(target = "followers", ignore = true)
    @Mapping(target = "removeFollowers", ignore = true)
    ApplicationUser toEntity(ApplicationUserDTO applicationUserDTO);

    default ApplicationUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setId(id);
        return applicationUser;
    }
}
