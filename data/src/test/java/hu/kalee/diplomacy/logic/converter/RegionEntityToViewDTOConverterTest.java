package hu.kalee.diplomacy.logic.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hu.kalee.diplomacy.data.domain.Nation;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.RegionType;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.logic.dto.RegionViewDTO;

/**
 * RegionEntityToViewDTOConverterTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 09.
 */
public class RegionEntityToViewDTOConverterTest {
    private RegionEntityToViewDTOConverter underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new RegionEntityToViewDTOConverter();
    }

    @Test
    public void testConvertShouldReturnNullOnNull() {
        RegionViewDTO actual = underTest.convert(null);
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void testConvertShouldConvertAllFields() {
        final Region source = new Region();
        source.setId(1);
        source.setType(RegionType.LAND);
        source.setName("Region");
        final Unit unit = new Unit();
        unit.setId(2);
        source.setUnit(unit);
        final List<Region> adjacents = new ArrayList<>();
        final Region adjacent = new Region();
        adjacent.setId(3);
        adjacents.add(adjacent);
        source.setAdjacent(adjacents);
        final Nation nation = new Nation();
        nation.setId(4);
        source.setCore(nation);
        final Nation owner = new Nation();
        owner.setId(5);
        source.setOwner(owner);
        source.setSupplyCenter(true);

        final RegionViewDTO expected = new RegionViewDTO();
        expected.setId(1);
        expected.setType(RegionType.LAND);
        expected.setName("Region");
        expected.setUnit(2L);
        expected.setAdjacent(Collections.singletonList(3L));
        expected.setCore(4L);
        expected.setOwner(5L);
        expected.setSupplyCenter(true);

        RegionViewDTO actual = underTest.convert(source);

        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}
