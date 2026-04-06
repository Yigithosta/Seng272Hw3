package gui;

import model.Profile;

import javax.swing.*;
import java.awt.*;

public class Step1ProfilePanel extends JPanel {

    public Step1ProfilePanel(MainFrame frame) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Step 1 - Profile");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField usernameField = new JTextField(frame.getProfile().getUsername(), 20);
        JTextField schoolField = new JTextField(frame.getProfile().getSchool(), 20);
        JTextField sessionField = new JTextField(frame.getProfile().getSessionName(), 20);

        formPanel.add(new JLabel("Username:"));
        formPanel.add(usernameField);
        formPanel.add(new JLabel("School:"));
        formPanel.add(schoolField);
        formPanel.add(new JLabel("Session Name:"));
        formPanel.add(sessionField);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton nextButton = new JButton("Next");

        nextButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String school = schoolField.getText().trim();
            String session = sessionField.getText().trim();

            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter your username to continue.",
                        "Missing Field",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (school.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter your school name to continue.",
                        "Missing Field",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (session.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter your session name to continue.",
                        "Missing Field",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            Profile profile = frame.getProfile();
            profile.setUsername(username);
            profile.setSchool(school);
            profile.setSessionName(session);

            frame.showStep("2");
        });

        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}