package hu.kalee.diplomacy.logic.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.logic.dto.CommandViewDTO;
import hu.kalee.diplomacy.data.domain.Command;

/**
 * CommandEntityToViewDTOConverter.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
@Component
public class CommandEntityToViewDTOConverter implements Converter<Command, CommandViewDTO> {
    @Override
    public CommandViewDTO convert(final Command source) {
        CommandViewDTO result = null;
        if (source != null) {
            result = new CommandViewDTO();
            result.setId(source.getId());
            result.setType(source.getType());
            result.setUnit(source.getUnit().getId());
            result.setBase(source.getBase().getId());
            result.setTarget(source.getTarget().getId());
            result.setNote(source.getNote());
        }
        return result;
    }
}
