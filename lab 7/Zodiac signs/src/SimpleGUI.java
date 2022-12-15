import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class SimpleGUI extends JFrame {

    private JButton button = new JButton("Узнать");
    private JTextField input1 = new JTextField("");
    private JTextField input2 = new JTextField("");
    private JTextField input3 = new JTextField("");

    private JTextField input4 = new JTextField("");

    private JTextField input5 = new JTextField("");

    private JTextField input6 = new JTextField("");

    private JPanel contents = new JPanel();

    public SimpleGUI() {
        super("Совместимость знаков зодиака");
        this.setBounds(10, 10, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 1, 11, 10));
        input1.setColumns(16);
        //container.add(label);
        container.add(new JLabel("День:"));
        container.add(input1);
        //container.add(new JLabel("День (партнер 2):"));
        //container.add(input4);
        container.add(new JLabel("Месяц:"));
        container.add(input2);
        //container.add(new JLabel("Месяц (партнер 2):"));
        //container.add(input5);
        container.add(new JLabel("Год:"));
        container.add(input3);
        //container.add(new JLabel("Год (партнер 2):"));
        //container.add(input6);


        NumberFormat number = new DecimalFormat();
        JFormattedTextField numberField = new JFormattedTextField(new NumberFormatter(number));
        numberField.setColumns(10);

        ButtonGroup group = new ButtonGroup();
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int d1 = Integer.parseInt(input1.getText());
            int m1 = Integer.parseInt(input2.getText());
            int y1 = Integer.parseInt(input3.getText());
            //int d2 = Integer.parseInt(input4.getText());
            //int m2 = Integer.parseInt(input5.getText());
            //int y2 = Integer.parseInt(input6.getText());
            //int num = 0;


            String message1 = "", message2 = "", message3 = "", message4 = "", message5 = "", message6 = "", message7 = "", message8 = "", message9 = "", message10 = "", message11 = "", message12 = "";
            String sign1 = "", sign2 = "", sign3 = "", sign4 = "", sign5 = "", sign6 = "", sign7 = "", sign8 = "", sign9 = "", sign10 = "", sign11 = "", sign12 = "";
            // String fin = "";

            if ((m1 == 1 && d1 <= 20) || (m1 == 12 && d1 >= 22)) {
                sign1 = "КОЗЕРОГ";
                message1 += "Знак зодиака : " + sign1 + "\n";
                JOptionPane.showMessageDialog(null, message1, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 1 || m1 == 2) && (d1 <= 19)) {
                sign2 = "ВОДОЛЕЙ";
                message2 += "Знак зодиака: " + sign2 + "\n";
                JOptionPane.showMessageDialog(null, message2, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 2 || m1 == 3) && (d1 <= 20)) {
                sign3 = ": РЫБЫ";
                message3 += "Знак зодиакаl: " + sign3 + "\n";
                JOptionPane.showMessageDialog(null, message3, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 3 || m1 == 4) && (d1 <= 19)) {
                sign4 = ": ОВЕН";
                message4 += "Знак зодиака: " + sign4 + "\n";
                JOptionPane.showMessageDialog(null, message4, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 4 || m1 == 5) && (d1 <= 21)) {
                sign5 = ": ТЕЛЕЦ";
                message5 += "Знак зодиака: " + sign5 + "\n";
                JOptionPane.showMessageDialog(null, message5, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 5 || m1 == 6) && (d1 <= 21)) {
                sign6 = ": БЛИЗНЕЦЫ";
                message6 += "Знак зодиака: " + sign6 + "\n";
                JOptionPane.showMessageDialog(null, message6, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 6 || m1 == 7) && (d1 <= 23)) {
                sign7 = ": РАК";
                message7 += "Знак зодиака: " + sign7 + "\n";
                JOptionPane.showMessageDialog(null, message7, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 7 || m1 == 8) && (d1 <= 23)) {
                sign8 = ": ЛЕВ";
                message8 += "Знак зодиака: " + sign8 + "\n";
                JOptionPane.showMessageDialog(null, message8, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 8 || m1 == 9) && (d1 <= 23)) {
                sign9 = ": ДЕВА";
                message9 += "Знак зодиака: " + sign9 + "\n";
                JOptionPane.showMessageDialog(null, message9, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 9 || m1 == 10) && (d1 <= 23)) {
                sign10 = ": ВЕСЫ";
                message10 += "Знак зодиака: " + sign10 + "\n";
                JOptionPane.showMessageDialog(null, message10, "output", JOptionPane.PLAIN_MESSAGE);
            } else if ((m1 == 10 || m1 == 11) && (d1 <= 22)) {
                sign11 = ": СКОРПИОН";
                message11 += "Знак зодиака: " + sign11 + "\n";
                JOptionPane.showMessageDialog(null, message11, "output", JOptionPane.PLAIN_MESSAGE);
            } else if (m1 == 12) {
                sign12 = ": СТРЕЛЕЦ";
                message12 += "Знак зодиака: " + sign12 + "\n";
                JOptionPane.showMessageDialog(null, message12, "output", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}