package nb.fr.service.mapper;


import nb.fr.domain.*;
import nb.fr.service.dto.ArticleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Article} and its DTO {@link ArticleDTO}.
 */
@Mapper(componentModel = "spring", uses = {TagMapper.class, ApplicationUserMapper.class})
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {

    @Mapping(source = "applicationUser.id", target = "applicationUserId")
    ArticleDTO toDto(Article article);

    @Mapping(target = "removeTags", ignore = true)
    @Mapping(source = "applicationUserId", target = "applicationUser")
    Article toEntity(ArticleDTO articleDTO);

    default Article fromId(Long id) {
        if (id == null) {
            return null;
        }
        Article article = new Article();
        article.setId(id);
        return article;
    }
}
