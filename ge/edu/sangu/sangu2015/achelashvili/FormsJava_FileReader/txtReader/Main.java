package ge.edu.sangu.sangu2015.achelashvili.FormsJava_FileReader.txtReader;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mfr = new MainFrame();
                mfr.setVisible(true);
               // mfr.pack(); // Similar as: Wrap_Content in Droid (R)
            }
        });
    }


}
