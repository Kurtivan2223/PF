package FinalProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.*;

public class CreateFrameWindow
{
    public static JFrame visibility()
    {
        int createFrameWidth = 650;
        int createFrameHeight = 500;

        JFrame createFrame = new JFrame("Patient Record Manager | Create a New Record");
        createFrame.setMinimumSize(new Dimension(createFrameWidth, createFrameHeight));
        createFrame.setMaximumSize(new Dimension(createFrameWidth, createFrameHeight));
        createFrame.setPreferredSize(new Dimension(createFrameWidth, createFrameHeight));
        createFrame.setResizable(false);

        //JPanel
        JPanel createMainPanel = new JPanel();
        JPanel createFNamePanel = new JPanel();
        JPanel createLNamePanel = new JPanel();
        JPanel createAgePanel = new JPanel();
        JPanel createReasonPanel = new JPanel();
        JPanel createDoctorPanel = new JPanel();
        JPanel createDatePanel = new JPanel(); //TODO Ambot unsaon ning date sa imong database Kurt XD
        JPanel createButtonPanel = new JPanel();

        //JLabel
        JLabel fNameL = new JLabel("First Name:");
        fNameL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel lNameL = new JLabel("Last Name:");
        lNameL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel ageL = new JLabel("Age:");
        ageL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel reasonL = new JLabel("Admittance Reason:");
        reasonL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel doctorL = new JLabel("Doctor In Charge:");
        doctorL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        // TODO date gihapon ni kuuurt
        JLabel dateL =new JLabel("Date:");
        dateL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        //JTextField
        JTextField fNameTF = new JTextField();
        fNameTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        fNameTF.setMinimumSize(new Dimension(1, 150));
        fNameTF.setMaximumSize(new Dimension(650, 33));

        JTextField lNameTF = new JTextField();
        lNameTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        lNameTF.setMinimumSize(new Dimension(1, 150));
        lNameTF.setMaximumSize(new Dimension(650, 33));

        JTextField ageTF = new JTextField();
        ageTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        ageTF.setMinimumSize(new Dimension(1, 150));
        ageTF.setMaximumSize(new Dimension(650, 33));

        JTextField reasonTF = new JTextField();
        reasonTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        reasonTF.setMinimumSize(new Dimension(1, 150));
        reasonTF.setMaximumSize(new Dimension(650, 33));

        JTextField doctorTF = new JTextField();
        doctorTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        doctorTF.setMinimumSize(new Dimension(1, 150));
        doctorTF.setMaximumSize(new Dimension(650, 33));

        JTextField dateTF = new JTextField();
        dateTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        dateTF.setMinimumSize(new Dimension(1, 150));
        dateTF.setMaximumSize(new Dimension(650, 33));

        //JButton
        JButton submitButton = new JButton("Submit Record");
        submitButton.setFont(new Font("Century Gothic", Font.BOLD, 15));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fName = fNameTF.getText();
                String lName = lNameTF.getText();
                String age = ageTF.getText();
                String reason = reasonTF.getText();
                String doctor = doctorTF.getText();
                String dateStr = dateTF.getText();

                if (fName.isEmpty() || lName.isEmpty() || age.isEmpty() || reason.isEmpty() || doctor.isEmpty() || dateStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        Date date = Date.valueOf(dateStr); // Assuming dateStr is in the format "yyyy-MM-dd"
                        submitRecord(fName, lName, age, reason, doctor, date, createFrame);
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid date format!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        //Layout Manager
        BoxLayout createFrameMainLM = new BoxLayout(createMainPanel, BoxLayout.Y_AXIS);
        BoxLayout createFrameFNameLM = new BoxLayout(createFNamePanel, BoxLayout.X_AXIS);
        BoxLayout createFrameLNameLM = new BoxLayout(createLNamePanel, BoxLayout.X_AXIS);
        BoxLayout createFrameAgeLM = new BoxLayout(createAgePanel, BoxLayout.X_AXIS);
        BoxLayout createFrameReasonLM = new BoxLayout(createReasonPanel, BoxLayout.X_AXIS);
        BoxLayout createFrameDoctorLM = new BoxLayout(createDoctorPanel, BoxLayout.X_AXIS);
        BoxLayout createFrameDateLM = new BoxLayout(createDatePanel, BoxLayout.X_AXIS); //TODO Date pt. 3
        BoxLayout createFrameButtonLM = new BoxLayout(createButtonPanel, BoxLayout.X_AXIS);

        //JPanel Configuration
        createMainPanel.setLayout(createFrameMainLM);

        createFNamePanel.setLayout(createFrameFNameLM);
        createFNamePanel.setMinimumSize(new Dimension(createFrameWidth, 50));
        createFNamePanel.setMaximumSize(new Dimension(createFrameWidth, 50));
        createFNamePanel.setPreferredSize(new Dimension(createFrameWidth, 50));

        createLNamePanel.setLayout(createFrameLNameLM);
        createLNamePanel.setMinimumSize(new Dimension(createFrameWidth, 50));
        createLNamePanel.setMaximumSize(new Dimension(createFrameWidth, 50));
        createLNamePanel.setPreferredSize(new Dimension(createFrameWidth, 50));

        createAgePanel.setLayout(createFrameAgeLM);
        createAgePanel.setMinimumSize(new Dimension(createFrameWidth, 50));
        createAgePanel.setMaximumSize(new Dimension(createFrameWidth, 50));
        createAgePanel.setPreferredSize(new Dimension(createFrameWidth, 50));

        createReasonPanel.setLayout(createFrameReasonLM);
        createReasonPanel.setMinimumSize(new Dimension(createFrameWidth, 50));
        createReasonPanel.setMaximumSize(new Dimension(createFrameWidth, 50));
        createReasonPanel.setPreferredSize(new Dimension(createFrameWidth, 50));

        createDoctorPanel.setLayout(createFrameDoctorLM);
        createDoctorPanel.setMinimumSize(new Dimension(createFrameWidth, 50));
        createDoctorPanel.setMaximumSize(new Dimension(createFrameWidth, 50));
        createDoctorPanel.setPreferredSize(new Dimension(createFrameWidth, 50));

        createDatePanel.setLayout(createFrameDateLM);
        createDatePanel.setMinimumSize(new Dimension(createFrameWidth, 50));
        createDatePanel.setMaximumSize(new Dimension(createFrameWidth, 50));
        createDatePanel.setPreferredSize(new Dimension(createFrameWidth, 50));

        createButtonPanel.setLayout(createFrameButtonLM);
        createButtonPanel.setMinimumSize(new Dimension(createFrameWidth, 50));
        createButtonPanel.setMaximumSize(new Dimension(createFrameWidth, 50));
        createButtonPanel.setPreferredSize(new Dimension(createFrameWidth, 50));

        //Create Frame Setup
        createFrame.add(createMainPanel);

        createMainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        createMainPanel.add(createFNamePanel);

        createFNamePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        createFNamePanel.add(fNameL);
        createFNamePanel.add(Box.createRigidArea(new Dimension(20, 0)));
        createFNamePanel.add(fNameTF);
        createFNamePanel.add(Box.createRigidArea(new Dimension(50, 0)));
    
        createMainPanel.add(createLNamePanel);

        createLNamePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        createLNamePanel.add(lNameL);
        createLNamePanel.add(Box.createRigidArea(new Dimension(19, 0)));
        createLNamePanel.add(lNameTF);
        createLNamePanel.add(Box.createRigidArea(new Dimension(50, 0)));

        createMainPanel.add(createAgePanel);
        
        createAgePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        createAgePanel.add(ageL);
        createAgePanel.add(Box.createRigidArea(new Dimension(74, 0)));
        createAgePanel.add(ageTF);
        createAgePanel.add(Box.createRigidArea(new Dimension(50, 0)));

        createMainPanel.add(createReasonPanel);
        
        createReasonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        createReasonPanel.add(reasonL);
        createReasonPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        createReasonPanel.add(reasonTF);
        createReasonPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        createMainPanel.add(createDoctorPanel);

        createDoctorPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        createDoctorPanel.add(doctorL);
        createDoctorPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        createDoctorPanel.add(doctorTF);
        createDoctorPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        //TODO Date gihapon ni Kurt
        createMainPanel.add(createDatePanel);

        createDatePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        createDatePanel.add(dateL);
        createDatePanel.add(Box.createRigidArea(new Dimension(70, 0)));
        createDatePanel.add(dateTF);
        createDatePanel.add(Box.createRigidArea(new Dimension(50, 0)));

        createMainPanel.add(createButtonPanel);
        
        createButtonPanel.add(Box.createRigidArea(new Dimension(400, 0)));
        createButtonPanel.add(submitButton);

        createFrame.setVisible(true);
        createFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        return createFrame;
    }

    private static void submitRecord(String fName, String lName, String age, String reason, String doctor, Date date, JFrame frame)
    {
        try {
            Connection connection = Database.connect();
            String query = "INSERT INTO patientrecord (FirstName, LastName, Age, Reason, DoctorInCharge, DateAdmitted) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fName);
            preparedStatement.setString(2, lName);
            preparedStatement.setInt(3, Integer.parseInt(age));
            preparedStatement.setString(4, reason);
            preparedStatement.setString(5, doctor);
            preparedStatement.setDate(6, date);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record submitted successfully!");
            
            MainFrameWindow.visibility();
            frame.dispose();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error submitting record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
