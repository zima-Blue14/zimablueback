package nb.fr.service;

import nb.fr.service.dto.ApplicationUserDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link nb.fr.domain.ApplicationUser}.
 */
public interface ApplicationUserService {

    /**
     * Save a applicationUser.
     *
     * @param applicationUserDTO the entity to save.
     * @return the persisted entity.
     */
    ApplicationUserDTO save(ApplicationUserDTO applicationUserDTO);

    /**
     * Get all the applicationUsers.
     *
     * @return the list of entities.
     */
    List<ApplicationUserDTO> findAll();

    /**
     * Get all the applicationUsers with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    Page<ApplicationUserDTO> findAllWithEagerRelationships(Pageable pageable);


    /**
     * Get the "id" applicationUser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ApplicationUserDTO> findOne(Long id);

    /**
     * Delete the "id" applicationUser.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
