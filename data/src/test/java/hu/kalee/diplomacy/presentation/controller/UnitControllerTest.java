package hu.kalee.diplomacy.presentation.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hu.kalee.diplomacy.logic.facade.UnitFacade;

/**
 * UnitControllerTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 10.
 */
@RunWith(MockitoJUnitRunner.class)
public class UnitControllerTest {
    @InjectMocks
    private UnitController underTest;
    @Mock
    private UnitFacade facade;

    @Test
    public void testUnitsShouldCallGetUnitsFromFacade() {
        underTest.units();
        Mockito.verify(facade).getUnits();
    }
}
