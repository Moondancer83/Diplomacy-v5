package hu.kalee.diplomacy.presentation.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hu.kalee.diplomacy.logic.facade.RegionFacade;

/**
 * RegionControllerTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 09.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegionControllerTest {
    @InjectMocks
    private RegionController underTest;
    @Mock
    private RegionFacade facade;

    @Test
    public void testRegionsShouldCallGetRegionsFromFacade() {
        underTest.regions();
        Mockito.verify(facade).getRegions();
    }
}