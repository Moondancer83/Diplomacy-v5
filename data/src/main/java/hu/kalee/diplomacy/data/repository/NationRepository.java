package hu.kalee.diplomacy.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.kalee.diplomacy.data.domain.Nation;

/**
 * NationRepository.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
public interface NationRepository extends PagingAndSortingRepository<Nation, Long> {
}
