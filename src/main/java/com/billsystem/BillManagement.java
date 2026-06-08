

package com.billsystem;
import java.util.Scanner;
import javax.swing.UIManager;

public class BillManagement {

    public static void main(String[] args) {
         try {

            for (UIManager.LookAndFeelInfo info
                    : UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {

                    UIManager.setLookAndFeel(
                            info.getClassName());

                    break;
                }
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        
      new loginform().setVisible(true);
      
    }
}
