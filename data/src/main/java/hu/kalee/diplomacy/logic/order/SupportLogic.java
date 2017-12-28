package hu.kalee.diplomacy.logic.order;

import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.RegionType;
import hu.kalee.diplomacy.data.domain.UnitType;

/**
 * SupportLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
@Component
public class SupportLogic extends AbstractCommandLogic implements CommandLogic {
    @Override
    protected boolean specificChecks(final Command command) {
        return isTargetValidForUnit(command)
                && hasBaseAUnit(command)
                && isSupportedUnitTargetingTarget(command);
    }

    private boolean isTargetValidForUnit(final Command command) {
        return command.getUnit().getType().equals(UnitType.NAVY)
                && !command.getTarget().getType().equals(RegionType.LAND)
                || command.getUnit().getType().equals(UnitType.ARMY)
                && command.getTarget().getType().equals(RegionType.SEA);
    }

    private boolean hasBaseAUnit(final Command command) {
        return command.getBase().getUnit() != null;
    }

    private boolean isSupportedUnitTargetingTarget(final Command command) {
        return command.getBase().getUnit().getCommand().getTarget().equals(command.getTarget());
    }

}
