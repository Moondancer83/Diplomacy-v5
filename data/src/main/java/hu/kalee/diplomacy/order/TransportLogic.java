package hu.kalee.diplomacy.order;

import hu.kalee.diplomacy.domain.Command;
import hu.kalee.diplomacy.domain.RegionType;
import hu.kalee.diplomacy.domain.UnitType;

/**
 * TransportLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class TransportLogic extends AbstractCommandLogic implements CommandLogic {
    @Override
    protected boolean specificChecks(final Command command) {
        return precheck(command)
                && isCapableOfTransporting(command)
                && areBaseAndTargetReachable(command)
                && isTargetValidForTransportee(command)
                && isTargetUnoccupied(command);
    }

    private boolean precheck(final Command command) {
        return command.getUnit() != null && command.getBase() != null && command.getTarget() != null;
    }

    private boolean isCapableOfTransporting(final Command command) {
        return command.getUnit().getType().equals(UnitType.NAVY);
    }

    private boolean areBaseAndTargetReachable(final Command command) {
        return command.getUnit().getLocation().getAdjacent().contains(command.getBase());
    }

    private boolean isTargetValidForTransportee(final Command command) {
        return command.getBase().getUnit().getType().equals(UnitType.ARMY) && !command.getTarget().getType().equals(RegionType.SEA)
                || command.getBase().getUnit().getType().equals(UnitType.NAVY) && !command.getTarget().getType().equals(RegionType.LAND);
    }

    private boolean isTargetUnoccupied(final Command command) {
        return command.getTarget().getUnit() == null;
    }
}
