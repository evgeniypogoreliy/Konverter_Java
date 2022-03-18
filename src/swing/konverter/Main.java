package swing.konverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class Main extends JFrame {

    public static void main(String[] args) {
        JFrame wind =new JFrame();

        JButton conv = new JButton("Convert");
        JButton swap = new JButton("Swap");

        JTextField from = new JTextField();

        JTextField to = new JTextField();

        JLabel t = new JLabel();

        JComboBox velFrom = new JComboBox();

        JComboBox velTo = new JComboBox();

        JComboBox convChoice = new JComboBox();
        convChoice.addItem((String)"Длина");
        convChoice.addItem((String)"Вес");

        JPanel workPanel = new JPanel(new GridLayout(2, 1));
        workPanel.setSize(200, 200);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(conv);
        buttonPanel.add(swap);
        buttonPanel.add(convChoice);

        workPanel.add(velFrom);
        workPanel.add(velTo);
        workPanel.add(from);
        workPanel.add(to);
        //workPanel.add(t)

        HashMap map = new HashMap();

        convChoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String h = (String) convChoice.getSelectedItem();
                switch (h) {
                    case("Длина"):
                        map.clear();
                        map.put("mm", 1);
                        map.put("sm", 10);
                        map.put("dm", 100);
                        map.put("m", 1000);
                        map.put("km", 1000000);
                        map.put("mile", 1609344);
                        velFrom.removeAllItems();
                        velFrom.addItem((String) "mm");
                        velFrom.addItem((String) "sm");
                        velFrom.addItem((String) "dm");
                        velFrom.addItem((String) "m");
                        velFrom.addItem((String) "km");
                        velFrom.addItem((String) "mile");
                        velTo.removeAllItems();
                        velTo.addItem((String) "mm");
                        velTo.addItem((String) "sm");
                        velTo.addItem((String) "dm");
                        velTo.addItem((String) "m");
                        velTo.addItem((String) "km");
                        velTo.addItem((String) "mile");
                        break;

                    case("Вес"):
                        map.clear();
                        map.put("g", 1);
                        map.put("kg", 10);
                        map.put("t", 1000000);
                        map.put("lb", 453.6);
                        map.put("oz", 283);
                        velFrom.removeAllItems();
                        velFrom.addItem((String)"g");
                        velFrom.addItem((String)"kg");
                        velFrom.addItem((String)"t");
                        velFrom.addItem((String)"lb");
                        velFrom.addItem((String)"oz");
                        velTo.removeAllItems();
                        velTo.addItem((String)"g");
                        velTo.addItem((String)"kg");
                        velTo.addItem((String)"t");
                        velTo.addItem((String)"lb");
                        velTo.addItem((String)"oz");
                        break;
                }
            }
        });

        conv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = (String) velFrom.getSelectedItem();
                String b = (String) velTo.getSelectedItem();
                String c = from.getText();
                int first = (int) map.get(a);
                int second = (int) map.get(b);
                int three = Integer.parseInt(c);
                double res = Double.parseDouble(String.valueOf(three))
                        * Double.parseDouble(String.valueOf(first))
                        / Double.parseDouble(String.valueOf(second));
                to.setText(String.valueOf(res));
            }
        });

        swap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String h = (String) velFrom.getSelectedItem();
                String k = (String) velTo.getSelectedItem();
                velFrom.setSelectedItem(k);
                velTo.setSelectedItem(h);

            }
        });

        wind.add(buttonPanel, BorderLayout.SOUTH);
        wind.add(workPanel, BorderLayout.NORTH);
        wind.setTitle("Конвертер");
        wind.setBounds(500, 200, 400, 160);
        wind.setDefaultCloseOperation(EXIT_ON_CLOSE);
        wind.setVisible(true);

    }
}
