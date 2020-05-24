package view;

import java.awt.event.KeyEvent;

/**
 * @author Thierry
 * interface for the eventperformer
 */
public interface IEventPerformer {

    /**
     * @param keyEvent the key we used
     */
    void eventPerform(KeyEvent keyEvent);
}
