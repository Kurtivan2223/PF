package FinalProject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class EditFrameWindow
{
    private static int patientID;

    public static JFrame visibility(Object[] data)
    {
        int editFrameWidth = 650;
        int editFrameHeight = 530;

        JFrame editFrame = new JFrame("Patient Record Manager | Edit a New Record");
        editFrame.setMinimumSize(new Dimension(editFrameWidth, editFrameHeight));
        editFrame.setMaximumSize(new Dimension(editFrameWidth, editFrameHeight));
        editFrame.setPreferredSize(new Dimension(editFrameWidth, editFrameHeight));
        editFrame.setResizable(false);

        //JPanel
        JPanel editIDPanel = new JPanel();
        JPanel editMainPanel = new JPanel();
        JPanel editFNamePanel = new JPanel();
        JPanel editLNamePanel = new JPanel();
        JPanel editAgePanel = new JPanel();
        JPanel editReasonPanel = new JPanel();
        JPanel editDoctorPanel = new JPanel();
        JPanel editDatePanel = new JPanel(); //TODO Ambot unsaon ning date sa imong database Kurt XD
        JPanel editButtonPanel = new JPanel();

        //JLabel
        JLabel idL = new JLabel("Patient ID:");
        idL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel fNameL = new JLabel("New First Name:");
        fNameL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel lNameL = new JLabel("New Last Name:");
        lNameL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel ageL = new JLabel("New Age:");
        ageL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel reasonL = new JLabel("New Admittance Reason:");
        reasonL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        JLabel doctorL = new JLabel("New Doctor In Charge:");
        doctorL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        //TODO ambot unsaon ning date Kurtttt
        JLabel dateL =new JLabel("New Date:");
        dateL.setFont(new Font("Century Gothic", Font.BOLD, 18));

        //JTextField
        JTextField idTF = new JTextField();
        idTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        idTF.setMinimumSize(new Dimension(1, 150));
        idTF.setMaximumSize(new Dimension(650, 33));

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

        //TODO Date gihapon ni Kurt HAHAHA
        JTextField dateTF = new JTextField();
        dateTF.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        dateTF.setMinimumSize(new Dimension(1, 150));
        dateTF.setMaximumSize(new Dimension(650, 33));

        //JButton
        JButton submitButton = new JButton("Submit Edits");
        submitButton.setFont(new Font("Century Gothic", Font.BOLD, 15));

        //Layout Manager
        BoxLayout editFrameMainLM = new BoxLayout(editMainPanel, BoxLayout.Y_AXIS);
        BoxLayout editFrameIDLM = new BoxLayout(editIDPanel, BoxLayout.X_AXIS);
        BoxLayout editFrameFNameLM = new BoxLayout(editFNamePanel, BoxLayout.X_AXIS);
        BoxLayout editFrameLNameLM = new BoxLayout(editLNamePanel, BoxLayout.X_AXIS);
        BoxLayout editFrameAgeLM = new BoxLayout(editAgePanel, BoxLayout.X_AXIS);
        BoxLayout editFrameReasonLM = new BoxLayout(editReasonPanel, BoxLayout.X_AXIS);
        BoxLayout editFrameDoctorLM = new BoxLayout(editDoctorPanel, BoxLayout.X_AXIS);
        BoxLayout editFrameDateLM = new BoxLayout(editDatePanel, BoxLayout.X_AXIS); //TODO Date pt. 3
        BoxLayout editFrameButtonLM = new BoxLayout(editButtonPanel, BoxLayout.X_AXIS);

        //JPanel Configuration
        editMainPanel.setLayout(editFrameMainLM);

        editIDPanel.setLayout(editFrameIDLM);
        editIDPanel.setMinimumSize(new Dimension(editFrameWidth, 50));
        editIDPanel.setMaximumSize(new Dimension(editFrameWidth, 50));
        editIDPanel.setPreferredSize(new Dimension(editFrameWidth, 50));

        editFNamePanel.setLayout(editFrameFNameLM);
        editFNamePanel.setMinimumSize(new Dimension(editFrameWidth, 50));
        editFNamePanel.setMaximumSize(new Dimension(editFrameWidth, 50));
        editFNamePanel.setPreferredSize(new Dimension(editFrameWidth, 50));

        editLNamePanel.setLayout(editFrameLNameLM);
        editLNamePanel.setMinimumSize(new Dimension(editFrameWidth, 50));
        editLNamePanel.setMaximumSize(new Dimension(editFrameWidth, 50));
        editLNamePanel.setPreferredSize(new Dimension(editFrameWidth, 50));

        editAgePanel.setLayout(editFrameAgeLM);
        editAgePanel.setMinimumSize(new Dimension(editFrameWidth, 50));
        editAgePanel.setMaximumSize(new Dimension(editFrameWidth, 50));
        editAgePanel.setPreferredSize(new Dimension(editFrameWidth, 50));

        editReasonPanel.setLayout(editFrameReasonLM);
        editReasonPanel.setMinimumSize(new Dimension(editFrameWidth, 50));
        editReasonPanel.setMaximumSize(new Dimension(editFrameWidth, 50));
        editReasonPanel.setPreferredSize(new Dimension(editFrameWidth, 50));

        editDoctorPanel.setLayout(editFrameDoctorLM);
        editDoctorPanel.setMinimumSize(new Dimension(editFrameWidth, 50));
        editDoctorPanel.setMaximumSize(new Dimension(editFrameWidth, 50));
        editDoctorPanel.setPreferredSize(new Dimension(editFrameWidth, 50));

        editDatePanel.setLayout(editFrameDateLM);
        editDatePanel.setMinimumSize(new Dimension(editFrameWidth, 50));
        editDatePanel.setMaximumSize(new Dimension(editFrameWidth, 50));
        editDatePanel.setPreferredSize(new Dimension(editFrameWidth, 50));

        editButtonPanel.setLayout(editFrameButtonLM);
        editButtonPanel.setMinimumSize(new Dimension(editFrameWidth, 50));
        editButtonPanel.setMaximumSize(new Dimension(editFrameWidth, 50));
        editButtonPanel.setPreferredSize(new Dimension(editFrameWidth, 50));

        patientID = Integer.parseInt(String.valueOf(data[0]));
        idTF.setText(String.valueOf(patientID));
        fNameTF.setText(String.valueOf(data[1]));
        lNameTF.setText(String.valueOf(data[2]));
        ageTF.setText(String.valueOf(data[3]));
        reasonTF.setText(String.valueOf(data[4]));
        doctorTF.setText(String.valueOf(data[5]));
        dateTF.setText(String.valueOf(data[6]));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = Date.valueOf(dateTF.getText());
                update(fNameTF.getText(), lNameTF.getText(), ageTF.getText(), reasonTF.getText(), doctorTF.getText(), date, editFrame);
            }
        });

        //edit Frame Setup
        editFrame.add(editMainPanel);

        editMainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        editMainPanel.add(editIDPanel);

        editIDPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        editIDPanel.add(idL);
        editIDPanel.add(Box.createRigidArea(new Dimension(73, 0)));
        editIDPanel.add(idTF);
        editIDPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        editMainPanel.add(editFNamePanel);

        editFNamePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        editFNamePanel.add(fNameL);
        editFNamePanel.add(Box.createRigidArea(new Dimension(20, 0)));
        editFNamePanel.add(fNameTF);
        editFNamePanel.add(Box.createRigidArea(new Dimension(50, 0)));
    
        editMainPanel.add(editLNamePanel);

        editLNamePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        editLNamePanel.add(lNameL);
        editLNamePanel.add(Box.createRigidArea(new Dimension(19, 0)));
        editLNamePanel.add(lNameTF);
        editLNamePanel.add(Box.createRigidArea(new Dimension(50, 0)));

        editMainPanel.add(editAgePanel);
        
        editAgePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        editAgePanel.add(ageL);
        editAgePanel.add(Box.createRigidArea(new Dimension(74, 0)));
        editAgePanel.add(ageTF);
        editAgePanel.add(Box.createRigidArea(new Dimension(50, 0)));

        editMainPanel.add(editReasonPanel);
        
        editReasonPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        editReasonPanel.add(reasonL);
        editReasonPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        editReasonPanel.add(reasonTF);
        editReasonPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        editMainPanel.add(editDoctorPanel);

        editDoctorPanel.add(Box.createRigidArea(new Dimension(50, 0)));
        editDoctorPanel.add(doctorL);
        editDoctorPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        editDoctorPanel.add(doctorTF);
        editDoctorPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        //TODO Date gihapon ni Kurt
        editMainPanel.add(editDatePanel);

        editDatePanel.add(Box.createRigidArea(new Dimension(50, 0)));
        editDatePanel.add(dateL);
        editDatePanel.add(Box.createRigidArea(new Dimension(70, 0)));
        editDatePanel.add(dateTF);
        editDatePanel.add(Box.createRigidArea(new Dimension(50, 0)));

        editMainPanel.add(editButtonPanel);
        
        editButtonPanel.add(Box.createRigidArea(new Dimension(400, 0)));
        editButtonPanel.add(submitButton);

        editFrame.setVisible(true);
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        return editFrame;
    }

    private static void update(String fname, String lname, String age, String Reason, String Doctor, Date date, JFrame frame)
    {
        try{
            Connection connection = Database.connect();
            String query = "UPDATE `patientrecord` SET FirstName = ?, LastName = ?, Age = ?, Reason = ?, DoctorInCharge = ?, DateAdmitted = ? WHERE pID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setInt(3, Integer.parseInt(age));
            preparedStatement.setString(4, Reason);
            preparedStatement.setString(5, Doctor);
            preparedStatement.setDate(6, date);
            preparedStatement.setInt(7, patientID);

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record submitted successfully!");
            
            MainFrameWindow.visibility();
            frame.dispose();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}