package hu.kalee.diplomacy.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.kalee.diplomacy.data.domain.Region;

/**
 * RegionRepository.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

}
