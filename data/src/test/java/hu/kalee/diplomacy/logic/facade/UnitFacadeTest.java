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

import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.data.repository.UnitRepository;
import hu.kalee.diplomacy.logic.converter.UnitEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.UnitViewDTO;

/**
 * UnitFacadeTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 10.
 */
@RunWith(MockitoJUnitRunner.class)
public class UnitFacadeTest {
    @InjectMocks
    private UnitFacade underTest;
    @Mock
    private UnitRepository repository;
    @Mock
    private UnitEntityToViewDTOConverter converter;

    @Before
    public void setUp() {
        final List<Unit> regions = new ArrayList<>();
        regions.add(new Unit());
        Mockito.when(repository.findAll()).thenReturn(regions);
        Mockito.when(converter.convert(Matchers.any(Unit.class))).thenCallRealMethod();
    }

    @Test
    public void testGetUnitsShouldCallFingAllFromRepository() {
        // GIVEN
        // WHEN
        underTest.getUnits();
        // THEN
        Mockito.verify(repository).findAll();
    }

    @Test
    public void testGetUnitsShouldCallConvert() throws Exception {
        // GIVEN
        // WHEN
        List<UnitViewDTO> actual = underTest.getUnits();
        // THEN
        Assertions.assertThat(actual).hasSize(1);
    }
}
