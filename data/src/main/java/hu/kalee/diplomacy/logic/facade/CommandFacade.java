package hu.kalee.diplomacy.logic.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.data.repository.CommandRepository;
import hu.kalee.diplomacy.data.repository.RegionRepository;
import hu.kalee.diplomacy.data.repository.UnitRepository;
import hu.kalee.diplomacy.logic.converter.CommandEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.CommandViewDTO;
import hu.kalee.diplomacy.logic.order.OrderValidationService;

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
    private UnitRepository unitRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private OrderValidationService orderValidationService;
    @Autowired
    private CommandEntityToViewDTOConverter commandEntityToViewDTOConverter;

    public List<CommandViewDTO> getCommands() {
        List<Command> commands = (List<Command>) commandRepository.findAll();
        return Lists.transform(commands, commandEntityToViewDTOConverter::convert);
    }

    public void createCommmand(final CommandViewDTO commandViewDTO) {
        if (commandViewDTO == null) {
            throw new IllegalStateException("CommandViewDTO should not be null");
        }
        Unit unit = unitRepository.findOne(commandViewDTO.getUnit());
        Region base = regionRepository.findOne(commandViewDTO.getBase());
        Region target = regionRepository.findOne(commandViewDTO.getTarget());

        final Command command = new Command();
        command.setBase(base);
        command.setUnit(unit);
        command.setTarget(target);
        command.setType(commandViewDTO.getType());
        command.setNote(commandViewDTO.getNote());

        if (!orderValidationService.validate(command)) {
            throw new IllegalStateException("Command is invalid");
        }
        commandRepository.save(command);
    }
}
