import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator extends JFrame implements ActionListener {
    private JLabel nameLabel, mathLabel, scienceLabel, socialLabel, frenchLabel,  englishLabel, totalLabel, averageLabel, gradeLabel;
    private JTextField nameField, mathField, scienceField, socialField, frenchField,  englishField, totalField, averageField, gradeField;
    private JButton calculateButton;

    public GradeCalculator() {
        setTitle("Student Grade Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        mathLabel = new JLabel("Math Grade:");
        add(mathLabel);
        mathField = new JTextField();
        add(mathField);

        scienceLabel = new JLabel("Science Grade:");
        add(scienceLabel);
        scienceField = new JTextField();
        add(scienceField);

        socialLabel = new JLabel("Social Grade:");
        add(socialLabel);
        socialField = new JTextField();
        add(socialField);

        frenchLabel = new JLabel("French Grade:");
        add(frenchLabel);
        frenchField = new JTextField();
        add(frenchField);


        englishLabel = new JLabel("English Grade:");
        add(englishLabel);
        englishField = new JTextField();
        add(englishField);

        totalLabel = new JLabel("Total:");
        add(totalLabel);
        totalField = new JTextField();
        totalField.setEditable(false);
        add(totalField);

        averageLabel = new JLabel("Average:");
        add(averageLabel);
        averageField = new JTextField();
        averageField.setEditable(false);
        add(averageField);

        gradeLabel = new JLabel("Grade:");
        add(gradeLabel);
        gradeField = new JTextField();
        gradeField.setEditable(false);
        add(gradeField);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double mathGrade = Double.parseDouble(mathField.getText());
                double scienceGrade = Double.parseDouble(scienceField.getText());
                double englishGrade = Double.parseDouble(englishField.getText());
                double socialGrade = Double.parseDouble(socialField.getText());
                double frenchGrade = Double.parseDouble(frenchField.getText());

                double total = mathGrade + scienceGrade + socialGrade + frenchGrade + englishGrade;
                double average = total / 5;
                String grade;

                if (average >= 90) {
                    grade = "A";
                } else if (average >= 80) {
                    grade = "B";
                } else if (average >= 70) {
                    grade = "C";
                } else if (average >= 60) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                totalField.setText(String.valueOf(total));
                averageField.setText(String.valueOf(average));
                gradeField.setText(grade);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid grades.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GradeCalculator();
            }
        });
    }
}

