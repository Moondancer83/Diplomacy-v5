package hu.kalee.diplomacy.logic.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.repository.CommandRepository;
import hu.kalee.diplomacy.logic.converter.CommandEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.CommandViewDTO;

/**
 * MapFacade.
 *
 * @author mkalinovits
 * @since 2017. 12. 08.
 */
@Component
public class CommandFacade {
    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private CommandEntityToViewDTOConverter commandEntityToViewDTOConverter;

    public List<CommandViewDTO> getCommands() {
        List<Command> commands = (List<Command>) commandRepository.findAll();
        return Lists.transform(commands, commandEntityToViewDTOConverter::convert);
    }
}
