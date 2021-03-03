package nb.fr.service.impl;

import nb.fr.service.ApplicationUserService;
import nb.fr.domain.ApplicationUser;
import nb.fr.repository.ApplicationUserRepository;
import nb.fr.service.dto.ApplicationUserDTO;
import nb.fr.service.mapper.ApplicationUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ApplicationUser}.
 */
@Service
@Transactional
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final Logger log = LoggerFactory.getLogger(ApplicationUserServiceImpl.class);

    private final ApplicationUserRepository applicationUserRepository;

    private final ApplicationUserMapper applicationUserMapper;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository, ApplicationUserMapper applicationUserMapper) {
        this.applicationUserRepository = applicationUserRepository;
        this.applicationUserMapper = applicationUserMapper;
    }

    @Override
    public ApplicationUserDTO save(ApplicationUserDTO applicationUserDTO) {
        log.debug("Request to save ApplicationUser : {}", applicationUserDTO);
        ApplicationUser applicationUser = applicationUserMapper.toEntity(applicationUserDTO);
        applicationUser = applicationUserRepository.save(applicationUser);
        return applicationUserMapper.toDto(applicationUser);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApplicationUserDTO> findAll() {
        log.debug("Request to get all ApplicationUsers");
        return applicationUserRepository.findAllWithEagerRelationships().stream()
            .map(applicationUserMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    public Page<ApplicationUserDTO> findAllWithEagerRelationships(Pageable pageable) {
        return applicationUserRepository.findAllWithEagerRelationships(pageable).map(applicationUserMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ApplicationUserDTO> findOne(Long id) {
        log.debug("Request to get ApplicationUser : {}", id);
        return applicationUserRepository.findOneWithEagerRelationships(id)
            .map(applicationUserMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete ApplicationUser : {}", id);
        applicationUserRepository.deleteById(id);
    }
}
