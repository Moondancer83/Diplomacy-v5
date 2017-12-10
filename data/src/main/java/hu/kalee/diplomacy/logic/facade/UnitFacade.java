package hu.kalee.diplomacy.logic.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.data.repository.UnitRepository;
import hu.kalee.diplomacy.logic.converter.UnitEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.UnitViewDTO;

/**
 * UnitFacade.
 *
 * @author mkalinovits
 * @since 2017. 12. 10.
 */
@Component
public class UnitFacade {
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private UnitEntityToViewDTOConverter unitEntityToViewDTOConverter;

    public List<UnitViewDTO> getUnits() {
        return Lists.transform((List<Unit>) unitRepository.findAll(), unitEntityToViewDTOConverter::convert);
    }
}
