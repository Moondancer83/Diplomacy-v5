package hu.kalee.diplomacy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.kalee.diplomacy.domain.Unit;

/**
 * UnitRepository.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
public interface UnitRepository extends PagingAndSortingRepository<Unit, Long> {
}
