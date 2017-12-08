package hu.kalee.diplomacy.logic.order;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.RegionType;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.data.domain.UnitType;

/**
 * MoveLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 01.
 */
public class MoveLogic extends AbstractCommandLogic implements CommandLogic {

    @Override
    protected boolean specificChecks(final Command command) {
        return check(command.getUnit(), command.getTarget());
    }

    private boolean check(Unit unit, Region destination) {
        return isAdjacent(unit, destination)
                    && isValidForUnitType(unit, destination)
                    && isTargetOccupied(destination);
    }

    private boolean isAdjacent(final Unit unit, final Region destination) {
        return unit.getLocation().getAdjacent().contains(destination);
    }

    private boolean isValidForUnitType(final Unit unit, final Region destination) {
        return isValidIfArmy(unit, destination)
                || isValidIfNavy(unit, destination);
    }

    private boolean isValidIfNavy(final Unit unit, final Region destination) {
        return unit.getType() == UnitType.NAVY
             && (destination.getType() == RegionType.SEA
             || destination.getType() == RegionType.COASTAL);
    }

    private boolean isValidIfArmy(final Unit unit, final Region destination) {
        return unit.getType() == UnitType.ARMY
                    && (destination.getType() == RegionType.LAND
                    || destination.getType() == RegionType.COASTAL);
    }

    private boolean isTargetOccupied(final Region destination) {
        return destination.getUnit() == null;
    }


}
