package interfaces;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface ButtonFactory {

    JButton createButton(String label, ActionListener listener);
}
