package hu.kalee.diplomacy.logic.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.RegionType;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.data.domain.UnitType;

/**
 * MoveTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 01.
 */
public class MoveLogicTest {
    private CommandLogic underTest;

    @Before
    public void setUp() {
        underTest = new MoveLogic();
    }

    @Test
    public void testCheckShouldReturnFalseWhenNoCommandIsGiven() {
        boolean actual = underTest.check(null);
    }

    @Test
    public void testCheckShouldReturnFalseWhenNoUnitIsGiven() {
        final Command moveCommand = new Command();
        moveCommand.setTarget(new Region());
        boolean actual = underTest.check(moveCommand);
        Assert.assertFalse(actual);
    }

    @Test
    public void testCheckShouldReturnFalseWhenNoDestinationIsGiven() {
        final Command moveCommand = new Command();
        moveCommand.setUnit(new Unit());
        boolean actual = underTest.check(moveCommand);
        Assert.assertFalse(actual);
    }

    @Test
    public void testCheckShouldReturnTrueWhenLandUnitIsLocatedNextToLandDestination() {
        // GIVEN
        Unit unit = new Unit();
        unit.setType(UnitType.ARMY);
        final Region location = new Region();
        location.setId(1);
        location.setType(RegionType.LAND);
        unit.setLocation(location);
        final Region destination = new Region();
        destination.setId(2);
        destination.setType(RegionType.LAND);
        location.getAdjacent().add(destination);
        destination.getAdjacent().add(location);

        final Command moveCommand = new Command();
        moveCommand.setUnit(unit);
        moveCommand.setTarget(destination);
        moveCommand.setBase(unit.getLocation());

        // WHEN
        boolean actual = underTest.check(moveCommand);

        // THEN
        Assert.assertTrue(actual);
    }

    @Test
    public void testCheckShouldReturnFalseWhenLandUnitIsLocatedNextToOccupiedLandDestination() {
        // GIVEN
        Unit unit = new Unit();
        final Region location = new Region();
        location.setId(1);
        location.setType(RegionType.LAND);
        unit.setLocation(location);
        final Region destination = new Region();
        destination.setId(2);
        destination.setType(RegionType.LAND);
        location.getAdjacent().add(destination);
        destination.getAdjacent().add(location);
        Unit other = new Unit();
        destination.setUnit(other);

        final Command moveCommand = new Command();
        moveCommand.setUnit(unit);
        moveCommand.setTarget(destination);
        moveCommand.setBase(unit.getLocation());

        // WHEN
        boolean actual = underTest.check(moveCommand);

        // THEN
        Assert.assertFalse(actual);
    }

    @Test
    public void testCheckShouldReturnFalseWhenLandUnitIsLocatedNextToSeeDestination() {
        // GIVEN
        Unit unit = new Unit();
        final Region location = new Region();
        location.setId(1);
        location.setType(RegionType.LAND);
        unit.setLocation(location);
        final Region destination = new Region();
        destination.setId(2);
        destination.setType(RegionType.SEA);
        location.getAdjacent().add(destination);
        destination.getAdjacent().add(location);

        final Command moveCommand = new Command();
        moveCommand.setUnit(unit);
        moveCommand.setTarget(destination);
        moveCommand.setBase(unit.getLocation());

        // WHEN
        boolean actual = underTest.check(moveCommand);

        // THEN
        Assert.assertFalse(actual);
    }

    @Test
    public void testCheckShouldReturnFalseWhenNavalUnitIsLocatedNextToLandDestination() {
        // GIVEN
        Unit unit = new Unit();
        unit.setType(UnitType.NAVY);
        final Region location = new Region();
        location.setId(1);
        location.setType(RegionType.COASTAL);
        unit.setLocation(location);
        final Region destination = new Region();
        destination.setId(2);
        destination.setType(RegionType.SEA);
        location.getAdjacent().add(destination);
        destination.getAdjacent().add(location);

        final Command moveCommand = new Command();
        moveCommand.setUnit(unit);
        moveCommand.setTarget(destination);
        moveCommand.setBase(unit.getLocation());

        // WHEN
        boolean actual = underTest.check(moveCommand);

        // THEN
        Assert.assertTrue(actual);
    }
}