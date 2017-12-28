package hu.kalee.diplomacy.logic.order;

import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.RegionType;
import hu.kalee.diplomacy.data.domain.UnitType;

/**
 * TransportLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
@Component
public class TransportLogic extends AbstractCommandLogic implements CommandLogic {
    @Override
    protected boolean specificChecks(final Command command) {
        return isCapableOfTransporting(command)
                && areBaseAndTargetReachable(command)
                && isTargetValidForTransportee(command)
                && isTargetUnoccupied(command);
    }

    private boolean isCapableOfTransporting(final Command command) {
        return command.getUnit().getType().equals(UnitType.NAVY);
    }

    private boolean areBaseAndTargetReachable(final Command command) {
        return command.getUnit().getLocation().getAdjacent().contains(command.getBase());
    }

    private boolean isTargetValidForTransportee(final Command command) {
        return command.getBase().getUnit().getType().equals(UnitType.ARMY)
                && !command.getTarget().getType().equals(RegionType.SEA)
                || command.getBase().getUnit().getType().equals(UnitType.NAVY)
                && !command.getTarget().getType().equals(RegionType.LAND);
    }

    private boolean isTargetUnoccupied(final Command command) {
        return command.getTarget().getUnit() == null;
    }
}
