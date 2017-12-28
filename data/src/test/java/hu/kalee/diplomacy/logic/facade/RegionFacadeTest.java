package hu.kalee.diplomacy.logic.facade;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.repository.RegionRepository;
import hu.kalee.diplomacy.logic.converter.RegionEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.RegionViewDTO;

/**
 * RegionFacadeTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 09.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegionFacadeTest {
    @InjectMocks
    private RegionFacade underTest;
    @Mock
    private RegionRepository repository;
    @Mock
    private RegionEntityToViewDTOConverter converter;

    @Before
    public void setUp() {
        final List<Region> regions = new ArrayList<>();
        regions.add(new Region());
        Mockito.when(repository.findAll()).thenReturn(regions);
        Mockito.when(converter.convert(Matchers.any(Region.class))).thenCallRealMethod();
    }

    @Test
    public void testGetRegionsShouldCallFindAllFronRepository() {
        // GIVEN
        // WHEN
        underTest.getRegions();

        // THEN
        Mockito.verify(repository).findAll();
    }

    @Test
    public void testGetRegionsShouldCallConvert() {
        // GIVEN
        // WHEN
        List<RegionViewDTO> actual = underTest.getRegions();
        // THEN
        Assertions.assertThat(actual).hasSize(1);
    }
}
