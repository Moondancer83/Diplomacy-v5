package hu.kalee.diplomacy.logic.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hu.kalee.diplomacy.data.domain.Nation;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.logic.dto.NationViewDTO;

/**
 * NationEntityToViewDTOConverterTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 09.
 */
public class NationEntityToViewDTOConverterTest {
    private NationEntityToViewDTOConverter underTest;

    @Before
    public void setup() {
        underTest = new NationEntityToViewDTOConverter();
    }

    @Test
    public void testConvertShouldReturnNullOnNull() {
        NationViewDTO actual = underTest.convert(null);
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void testConvertShouldConvertAllFields() {
        final Nation source = new Nation();
        source.setId(1);
        source.setName("Nation");
        final List<Region> cores = new ArrayList<>();
        final Region core = new Region();
        core.setId(2);
        cores.add(core);
        source.setCores(cores);
        final Region region = new Region();
        region.setId(3);
        final List<Region> regions = new ArrayList<>();
        regions.add(region);
        source.setRegions(regions);
        final List<Unit> units = new ArrayList<>();
        final Unit unit = new Unit();
        unit.setId(4);
        units.add(unit);
        source.setUnits(units);

        final NationViewDTO expected = new NationViewDTO();
        expected.setId(1);
        expected.setName("Nation");
        expected.setCores(Collections.singletonList(2L));
        expected.setRegions(Collections.singletonList(3L));
        expected.setUnits(Collections.singletonList(4L));

        final NationViewDTO actual = underTest.convert(source);
        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }

}