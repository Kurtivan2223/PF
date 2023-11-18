package FinalProject;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainFrameWindow
{
    public static void visibility()
    {
        int mainFrameWidth = 1350;
        int mainFrameHeight = 900;
        JFrame mainFrame = new JFrame("Patient Record Manager");
        mainFrame.setMinimumSize(new Dimension(mainFrameWidth, mainFrameHeight));
        mainFrame.setMaximumSize(new Dimension(mainFrameWidth, mainFrameHeight));
        mainFrame.setPreferredSize(new Dimension(mainFrameWidth, mainFrameHeight));
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

        //Separator
        JSeparator separatorV = new JSeparator();

        //Border
        Border separatorThickness = BorderFactory.createLineBorder(Color.black);
        Border blackLine = BorderFactory.createLineBorder(Color.black);

        //JPanel
        JPanel mainMainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel databasePanel = new JPanel();

        //JButton
        JButton createButton = new JButton("Create a New Record");
        JButton editButton = new JButton("Edit an Existing Record");
        JButton deleteButton = new JButton("Delete an Existing Record");

        createButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
        editButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
        deleteButton.setFont(new Font("Century Gothic", Font.BOLD, 15));

        //Layout Manager
        BoxLayout mainMainLM = new BoxLayout(mainMainPanel, BoxLayout.X_AXIS);
        BoxLayout mainButtonLM = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);

        String[] columns = {"ID", "First Name", "Last Name", "Age", "Admitance Reason", "Doctor Incharge", "Date Admitted"};
        Object[][] data = getData();

        JTable dataTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        createButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CreateFrameWindow.visibility();
                mainFrame.dispose();
            }
        });

        editButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int row = dataTable.getSelectedRow();

                if(row != -1) {
                    Object[] rowData = new Object[columns.length];

                    for(int i = 0; i < columns.length; i++) {
                        rowData[i] = dataTable.getValueAt(row, i);
                    }

                    EditFrameWindow.visibility(rowData);
                    mainFrame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(mainFrame, "Please select a row to edit.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = dataTable.getSelectedRow();

                if(row != -1) {
                    int patienID = (int)dataTable.getValueAt(row, 0);

                    deleteData(patienID);

                    refreshData(dataTable);
                }
                else {
                    JOptionPane.showMessageDialog(mainFrame, "Please select a row to delete.");
                }
            }
        });

        //Separator Configuration
        separatorV.setMaximumSize(new Dimension( 2, 775));
        separatorV.setBorder(separatorThickness);

        //JPanel Configuration
        mainMainPanel.setLayout(mainMainLM);

        buttonPanel.setLayout(mainButtonLM);
        buttonPanel.setMinimumSize(new Dimension(225, 300));
        buttonPanel.setMaximumSize(new Dimension(225, 300));
        buttonPanel.setPreferredSize(new Dimension(225, 300));
        //buttonPanel.setBorder(blackLine); //DEVELOPER BORDER!

        databasePanel.setMinimumSize(new Dimension(900, 800));
        databasePanel.setMaximumSize(new Dimension(900, 800));
        databasePanel.setPreferredSize(new Dimension(900, 800));
        databasePanel.setBorder(blackLine);
        databasePanel.setLayout(new BorderLayout());
        databasePanel.add(scrollPane, BorderLayout.CENTER);

        //Main Frame Setup
        mainFrame.add(mainMainPanel);

        mainMainPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        mainMainPanel.add(buttonPanel);

        mainMainPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(createButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        buttonPanel.add(editButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        buttonPanel.add(deleteButton);
        buttonPanel.add(Box.createVerticalGlue());

        mainMainPanel.add(separatorV);

        mainMainPanel.add(Box.createRigidArea(new Dimension(50, 0)));

        mainMainPanel.add(databasePanel);

        mainMainPanel.add(Box.createRigidArea(new Dimension(50, 0)));
    }

    public static Object[][] getData()
    {
        String query = "SELECT * FROM `patientrecord`";

        try (Connection connection = Database.connect();
            Statement  statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query)) {

            // Get the number of columns
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Get the number of rows
            int rowCount = 0;
            while (resultSet.next()) {
                rowCount++;
            }
            resultSet.beforeFirst();

            Object[][] data = new Object[rowCount][columnCount];

            int row = 0;
            while (resultSet.next()) {
                for (int col = 0; col < columnCount; col++) {
                    data[row][col] = resultSet.getObject(col + 1);
                }
                row++;
            }
            return data;

        } catch (SQLException e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }

    private static void deleteData(int patientID) {
        String deleteQuery = "DELETE FROM `patientrecord` WHERE pID = " + patientID;

        try (Connection connection = Database.connect();
            Statement statement = connection.createStatement()) {

            statement.executeUpdate(deleteQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void refreshData(JTable dataTable) {
        String[] columns = {"ID", "First Name", "Last Name", "Age", "Admission Reason", "Doctor Incharge", "Date Admitted"};
        Object[][] data = getData();

        DefaultTableModel model = new DefaultTableModel(data, columns);
        dataTable.setModel(model);
    }
}
