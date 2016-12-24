package hu.kalee.diplomacy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.kalee.diplomacy.domain.Region;

/**
 * RegionRepository.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

}
