import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField display;
    private JButton[] numbers = new JButton[10];
    private JButton add = new JButton("+");
    private JButton subtract = new JButton("-");
    private JButton multiply = new JButton("*");
    private JButton divide = new JButton("/");
    private JButton equal = new JButton("=");
    private JButton clear = new JButton("Clear");
    private JButton decimal = new JButton(".");
    private JButton del = new JButton("Del");

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        display = new JTextField();
        display.setEditable(false);
        display.setBounds(30, 40, 430, 60);
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        add(display);

        JButton[] functionButtons = {add, subtract, multiply, divide, decimal, equal, clear, del};

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
        }

        for (int i = 0; i < 10; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(new Font("Arial", Font.PLAIN, 20));
        }

        clear.setBounds(40, 400, 140, 40);
        del.setBounds(240, 400, 140, 40);

        add(clear);
        add(del);

        panel = new JPanel();
        panel.setBounds(50, 100, 400, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subtract);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(multiply);
        panel.add(decimal);
        panel.add(numbers[0]);
        panel.add(equal);
        panel.add(divide);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numbers[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimal) {
            display.setText(display.getText().concat("."));
        }
        if (e.getSource() == add) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subtract) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == multiply) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divide) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if (e.getSource() == equal) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clear) {
            display.setText("");
        }
        if (e.getSource() == del) {
            String text = display.getText();
            if (!text.isEmpty()) {
                display.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
