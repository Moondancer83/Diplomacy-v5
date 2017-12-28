package hu.kalee.diplomacy.presentation.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hu.kalee.diplomacy.logic.facade.CommandFacade;

/**
 * CommandControllerTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 08.
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandControllerTest {

    @InjectMocks
    private CommandController underTest;
    @Mock
    private CommandFacade commandFacade;

    @Test
    public void testCommandsShouldCallGetCommendsFromFacade() {
        underTest.commands();
        Mockito.verify(commandFacade).getCommands();
    }
}
