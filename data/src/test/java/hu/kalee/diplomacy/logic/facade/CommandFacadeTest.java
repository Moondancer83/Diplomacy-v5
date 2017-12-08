package hu.kalee.diplomacy.logic.facade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.repository.CommandRepository;
import hu.kalee.diplomacy.logic.converter.CommandEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.CommandViewDTO;
import static org.junit.Assert.*;

/**
 * CommandFacadeTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 08.
 */
@RunWith(MockitoJUnitRunner.class)
public class CommandFacadeTest {
    @InjectMocks
    private CommandFacade underTest;
    @Mock
    private CommandRepository commandRepository;
    @Mock
    private CommandEntityToViewDTOConverter commandEntityToViewDTOConverter;

    @Before
    public void setup() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command());
        Mockito.when(commandRepository.findAll()).thenReturn(commands);
        Mockito.when(commandEntityToViewDTOConverter.convert(Matchers.any())).thenCallRealMethod();
    }

    @Test
    public void testGetCommandShouldCallFindAllFromRepository() {
        underTest.getCommands();
        Mockito.verify(commandRepository).findAll();
    }

    @Test
    public void testGetCommandsShouldCallConvertFromConverter() {
        List<CommandViewDTO> actual = underTest.getCommands();
        Assert.assertEquals(1, actual.size());
    }
}