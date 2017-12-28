package hu.kalee.diplomacy.presentation.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hu.kalee.diplomacy.logic.facade.NationFacade;

/**
 * NationControllerTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 09.
 */
@RunWith(MockitoJUnitRunner.class)
public class NationControllerTest {
    @InjectMocks
    private NationController underTest;
    @Mock
    private NationFacade facade;

    @Test
    public void testNationsShouldCallGetNationsFromFacade() {
        underTest.nations();
        Mockito.verify(facade).getNations();
    }
}
