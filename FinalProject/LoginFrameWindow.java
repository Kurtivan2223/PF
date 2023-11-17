package FinalProject;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrameWindow
{
    public static void visibility()
    {
        int loginFrameWidth = 750;
        int loginFrameHeight = 500;
        JFrame loginFrame = new JFrame("Patient Record Manager | Credentials Verification");
        loginFrame.setMinimumSize(new Dimension(loginFrameWidth, loginFrameHeight));
        loginFrame.setPreferredSize(new Dimension(loginFrameWidth, loginFrameHeight));
        loginFrame.setMaximumSize(new Dimension(loginFrameWidth, loginFrameHeight));
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        loginFrame.setResizable(false);

        //Dimension Measurements
        Dimension minSize = new Dimension(575, (int)(loginFrameHeight * 0.2));
        Dimension prefSize = new Dimension(575, (int)(loginFrameHeight * 0.2));
        Dimension maxSize = new Dimension(575, (int)(loginFrameHeight * 0.2));
        
        //Border
        //Border blackLine = BorderFactory.createLineBorder(Color.black); // !! DEVELOPER BORDER !!
        Border separatorThickness = BorderFactory.createLineBorder(Color.black);

        //Separator
        JSeparator separatorH = new JSeparator();
        separatorH.setOrientation(JSeparator.HORIZONTAL);
        separatorH.setMaximumSize(new Dimension((int)(loginFrameWidth*0.9), 5));
        separatorH.setBorder(separatorThickness);
        
        JSeparator separatorF = new JSeparator();
        separatorF.setOrientation(JSeparator.HORIZONTAL);
        separatorF.setMaximumSize(new Dimension((int)(loginFrameWidth*0.9), 5));
        separatorF.setBorder(separatorThickness);

        //JPanel
        JPanel loginMainPanel = new JPanel();
        JPanel loginHeaderPanel = new JPanel();
        JPanel loginUsernamePanel = new JPanel();
        JPanel loginPasswordPanel = new JPanel();
        JPanel loginButtonPanel = new JPanel();
        JPanel loginFooterPanel = new JPanel();

        //JLabel
        JLabel titleL = new JLabel("Patient Record Manager");
        titleL.setFont(new Font("Century Gothic", Font.BOLD, 25));

        JLabel usernameL = new JLabel("Username:");
        usernameL.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        JLabel passwordL = new JLabel("Password:");
        passwordL.setFont(new Font("Century Gothic", Font.BOLD, 20));

        JLabel footerL = new JLabel("Credentials Verification");
        footerL.setFont(new Font("Century Gothic", Font.BOLD, 25));

        //JTextfield
        JTextField usernameTF = new JTextField();
        usernameTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        usernameTF.setMinimumSize(new Dimension(0, 150));
        usernameTF.setMaximumSize(new Dimension(750, 30));

        JTextField passwordTF = new JTextField();
        passwordTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        passwordTF.setMinimumSize(new Dimension(0, 150));
        passwordTF.setMaximumSize(new Dimension(750, 30));

        //JButton
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Century Gothic", Font.BOLD, 15));

        loginButton.addActionListener(new ActionListener()
        {
            @Override 
            public void actionPerformed(ActionEvent e)
            {
                if(usernameTF.getText().equals("admin") && passwordTF.getText().equals("admin"))
                {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    loginFrame.setVisible(false);
                    MainFrameWindow.visibility();
                } else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password! Please try again.");
                }
            }
        });

        //Layout Manager
        BoxLayout loginFrameMainLM = new BoxLayout(loginMainPanel, BoxLayout.Y_AXIS);
        BoxLayout loginFrameHeaderLM = new BoxLayout(loginHeaderPanel, BoxLayout.X_AXIS);
        BoxLayout loginFrameUsernameLM = new BoxLayout(loginUsernamePanel, BoxLayout.X_AXIS);
        BoxLayout loginFramePasswordLM = new BoxLayout(loginPasswordPanel, BoxLayout.X_AXIS);
        BoxLayout loginFrameButtonLM = new BoxLayout(loginButtonPanel, BoxLayout.X_AXIS);
        BoxLayout loginFrameFooterLM = new BoxLayout(loginFooterPanel, BoxLayout.X_AXIS);

        //JPanel Configuration
        loginMainPanel.setLayout(loginFrameMainLM);
        //loginMainPanel.setBorder(blackLine);

        loginHeaderPanel.setLayout(loginFrameHeaderLM);
        //loginHeaderPanel.setBorder(blackLine);
        loginHeaderPanel.setMinimumSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.15)));
        loginHeaderPanel.setMaximumSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.15)));
        loginHeaderPanel.setPreferredSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.15)));

        loginUsernamePanel.setLayout(loginFrameUsernameLM);
        //loginUsernamePanel.setBorder(blackLine);
        loginUsernamePanel.setMinimumSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.2)));
        loginUsernamePanel.setMaximumSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.2)));
        loginUsernamePanel.setPreferredSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.2)));

        loginPasswordPanel.setLayout(loginFramePasswordLM);
        //loginPasswordPanel.setBorder(blackLine);
        loginPasswordPanel.setMinimumSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.1)));
        loginPasswordPanel.setMaximumSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.1)));
        loginPasswordPanel.setPreferredSize(new Dimension(loginFrameWidth, (int)(loginFrameHeight * 0.1)));

        loginButtonPanel.setLayout(loginFrameButtonLM);
        //loginButtonPanel.setBorder(blackLine);
        loginButtonPanel.setMinimumSize(new Dimension(750, (int)(loginFrameHeight * 0.1)));
        loginButtonPanel.setMaximumSize(new Dimension(750, (int)(loginFrameHeight * 0.1)));
        loginButtonPanel.setPreferredSize(new Dimension(750, (int)(loginFrameHeight * 0.1)));

        loginFooterPanel.setLayout(loginFrameFooterLM);
        //loginFooterPanel.setBorder(blackLine);
        loginFooterPanel.setMinimumSize(new Dimension(750, (int)(loginFrameHeight * 0.2)));
        loginFooterPanel.setMaximumSize(new Dimension(750, (int)(loginFrameHeight * 0.2)));
        loginFooterPanel.setPreferredSize(new Dimension(750, (int)(loginFrameHeight * 0.2)));

        //Login Frame Setup
        loginFrame.add(loginMainPanel);
        
        loginMainPanel.add(loginHeaderPanel);
        
        loginHeaderPanel.add(Box.createHorizontalGlue());
        loginHeaderPanel.add(titleL);
        loginHeaderPanel.add(Box.createHorizontalGlue());

        loginMainPanel.add(Box.createVerticalGlue());

        loginMainPanel.add(separatorH);

        loginMainPanel.add(Box.createVerticalGlue());

        loginMainPanel.add(loginUsernamePanel);

        loginUsernamePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        loginUsernamePanel.add(usernameL);
        loginUsernamePanel.add(Box.createRigidArea(new Dimension(15, 0)));
        loginUsernamePanel.add(usernameTF);
        loginUsernamePanel.add(Box.createRigidArea(new Dimension(50, 0)));

        loginMainPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        loginMainPanel.add(loginPasswordPanel);

        loginPasswordPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        loginPasswordPanel.add(passwordL);
        loginPasswordPanel.add(Box.createRigidArea(new Dimension(23, 0)));
        loginPasswordPanel.add(passwordTF);
        loginPasswordPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        loginMainPanel.add(loginButtonPanel);

        loginButtonPanel.add(new Box.Filler(minSize, prefSize, maxSize));

        loginButtonPanel.add(loginButton);

        loginMainPanel.add(Box.createVerticalGlue());

        loginMainPanel.add(separatorF);

        loginMainPanel.add(Box.createVerticalGlue());

        loginMainPanel.add(loginFooterPanel);

        loginFooterPanel.add(Box.createHorizontalGlue());
        loginFooterPanel.add(footerL);
        loginFooterPanel.add(Box.createHorizontalGlue());

        loginFrame.pack();
    }
}
