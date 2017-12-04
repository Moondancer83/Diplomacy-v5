package hu.kalee.diplomacy.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.converter.NationEntityToViewDTOConverter;
import hu.kalee.diplomacy.domain.Nation;
import hu.kalee.diplomacy.dto.NationViewDTO;
import hu.kalee.diplomacy.repository.NationRepository;

/**
 * MapController.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
@RestController
public class NationController {
    @Autowired
    private NationRepository repository;
    @Autowired
    private NationEntityToViewDTOConverter converter;

    @RequestMapping(value = "nations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NationViewDTO> map() {
        return Lists.transform((List<Nation>) repository.findAll(), converter::convert);
    }
}
