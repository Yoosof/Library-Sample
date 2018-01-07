package com.company.ui.widget;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;


public class MetalTextField {
    private static LookAndFeel metal;

    public static JTextField generateTextField() {
        try {
            LookAndFeel current = UIManager.getLookAndFeel(); 

            if (metal == null) {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                	
                    if ("Metal".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
                metal = UIManager.getLookAndFeel();
            }
            else
                UIManager.setLookAndFeel(metal); 
            JTextField textfield = new JTextField(); 
            UIManager.setLookAndFeel(current); 
            return textfield;
        }
        catch (Exception e) {
            e.printStackTrace();
            return new JTextField();
        }
    }
}
