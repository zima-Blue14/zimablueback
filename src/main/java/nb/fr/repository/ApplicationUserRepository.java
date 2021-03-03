package nb.fr.repository;

import nb.fr.domain.ApplicationUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the ApplicationUser entity.
 */
@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    @Query(value = "select distinct applicationUser from ApplicationUser applicationUser left join fetch applicationUser.friends",
        countQuery = "select count(distinct applicationUser) from ApplicationUser applicationUser")
    Page<ApplicationUser> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct applicationUser from ApplicationUser applicationUser left join fetch applicationUser.friends")
    List<ApplicationUser> findAllWithEagerRelationships();

    @Query("select applicationUser from ApplicationUser applicationUser left join fetch applicationUser.friends where applicationUser.id =:id")
    Optional<ApplicationUser> findOneWithEagerRelationships(@Param("id") Long id);
}
