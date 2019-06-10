import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.awt.event.*;

public class MySendListener implements ActionListener {

    ArrayList<JCheckBox> checkboxList;

    public void actionPerformed(ActionEvent a) {
        boolean[] checkboxState = new boolean[256];

        for (int i = 0; i < 256; i++) {

            JCheckBox check = (JCheckBox) checkboxList.get(i);
            if (check.isSelected()) {
                checkboxState[i] = true;
            }
        }

        try {
            FileOutputStream fileStream = new FileOutputStream(new File("Checkbox.ser"));
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(checkboxState);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    } // 关闭方法
} // 关闭内部类
