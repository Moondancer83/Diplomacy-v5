package hu.kalee.diplomacy.logic.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.data.domain.Nation;
import hu.kalee.diplomacy.data.repository.NationRepository;
import hu.kalee.diplomacy.logic.converter.NationEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.NationViewDTO;

/**
 * NationFacade.
 *
 * @author mkalinovits
 * @since 2017. 12. 09.
 */
@Component
public class NationFacade {
    @Autowired
    private NationRepository nationRepository;
    @Autowired
    private NationEntityToViewDTOConverter nationEntityToViewDTOConverter;

    public List<NationViewDTO> getNations() {
        List<Nation> nations = (List<Nation>) nationRepository.findAll();
        return Lists.transform(nations, nationEntityToViewDTOConverter::convert);
    }
}
