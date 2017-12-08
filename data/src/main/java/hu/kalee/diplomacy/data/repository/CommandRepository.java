package hu.kalee.diplomacy.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.kalee.diplomacy.data.domain.Command;

/**
 * CommandRepository.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
public interface CommandRepository extends PagingAndSortingRepository<Command, Long> {
}
