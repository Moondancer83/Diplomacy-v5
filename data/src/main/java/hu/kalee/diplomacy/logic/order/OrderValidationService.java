package hu.kalee.diplomacy.logic.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.data.domain.Command;

/**
 * OrderValidationService.
 *
 * @author mkalinovits
 * @since 2017. 12. 16.
 */
@Component
public class OrderValidationService {
    @Autowired
    private CommandLogic holdLogic;
    @Autowired
    private CommandLogic moveLogic;
    @Autowired
    private CommandLogic supportLogic;
    @Autowired
    private CommandLogic transportLogic;

    public boolean validate(final Command command) {
        boolean result;
        switch (command.getType()) {
            case HOLD:
                result = holdLogic.check(command);
                break;
            case MOVE:
                result = moveLogic.check(command);
                break;
            case SUPPORT:
                result = supportLogic.check(command);
                break;
            case TRANSPORT:
                result = transportLogic.check(command);
                break;
            default:
                result = false;
                break;
        }
        return result;
    }
}
