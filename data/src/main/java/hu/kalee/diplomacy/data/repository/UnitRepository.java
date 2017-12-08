package hu.kalee.diplomacy.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.kalee.diplomacy.data.domain.Unit;

/**
 * UnitRepository.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
public interface UnitRepository extends PagingAndSortingRepository<Unit, Long> {
}
