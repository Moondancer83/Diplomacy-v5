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

import hu.kalee.diplomacy.data.domain.Nation;
import hu.kalee.diplomacy.data.repository.NationRepository;
import hu.kalee.diplomacy.logic.converter.NationEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.NationViewDTO;

/**
 * NationFacadeTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 09.
 */
@RunWith(MockitoJUnitRunner.class)
public class NationFacadeTest {
    @InjectMocks
    private NationFacade underTest;
    @Mock
    private NationRepository repository;
    @Mock
    private NationEntityToViewDTOConverter converter;

    @Before
    public void setUp() {
        final List<Nation> nations = new ArrayList<>();
        nations.add(new Nation());
        Mockito.when(repository.findAll()).thenReturn(nations);
        Mockito.when(converter.convert(Matchers.any(Nation.class))).thenCallRealMethod();
    }

    @Test
    public void testGetNationsShouldCallFindAllFromRepository() {
        underTest.getNations();
        Mockito.verify(repository).findAll();
    }

    @Test
    public void testGetNationsShouldCallConvertFromConverter() {
        List<NationViewDTO> actual = underTest.getNations();
        Assertions.assertThat(actual).hasSize(1);
    }
}