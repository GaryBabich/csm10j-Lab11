import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Program extends JFrame{	
	private JLabel label1;
        private JLabel label2;
	private JTextField tfG1;
        private JTextField tfG2;
        private JTextField tfG3;
        private JTextField tfG4;
        private JTextField tfW1;
        private JTextField tfW2;
        private JTextField tfW3;
        private JTextField tfW4;
        private JTextField tfCalc;
	private JButton button;
	private CalculateButtonListener cbListener;
	
	public Program(){
		this.setTitle("Grade Ap");
		this.setSize(400,600);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setup(){		
		label1 = new JLabel("Grade %", SwingConstants.CENTER);
		label2 = new JLabel("Weight", SwingConstants.CENTER);
		tfG1 = new JTextField(10);
		tfW1 = new JTextField(10);
		tfG2 = new JTextField(10);
		tfW2 = new JTextField(10);
		tfG3 = new JTextField(10);
		tfW3 = new JTextField(10);
		tfG4 = new JTextField(10);
		tfW4 = new JTextField(10);
		tfCalc = new JTextField(10);
		this.tfG1.setEditable(true);
		this.tfW1.setEditable(true);
		this.tfG2.setEditable(true);
		this.tfW2.setEditable(true);
		this.tfG3.setEditable(true);
		this.tfW3.setEditable(true);
		this.tfG4.setEditable(true);
		this.tfW4.setEditable(true);
		this.tfCalc.setEditable(false);
		button = new JButton("Calculate");
		this.cbListener = new CalculateButtonListener();
		this.button.addActionListener(cbListener);
                Container pane = this.getContentPane();
		pane.setLayout(new GridLayout(6,2));
		pane.add(label1);
		pane.add(label2);
		pane.add(tfG1);
		pane.add(tfW1);
		pane.add(tfG2);
		pane.add(tfW2);
		pane.add(tfG3);
		pane.add(tfW3);
		pane.add(tfG4);
		pane.add(tfW4);
		pane.add(button);
		pane.add(tfCalc);
	}
	
	private class CalculateButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
			try{
				double grade1;
                                double grade2;
                                double grade3;
                                double grade4;
                                double weight1;
                                double weight2;
                                double weight3;
                                double weight4;
                                double weightedAverage;
                                weight1 = Double.parseDouble(tfW1.getText());
				weight2 = Double.parseDouble(tfW2.getText());
				weight3 = Double.parseDouble(tfW3.getText());
				weight4 = Double.parseDouble(tfW3.getText());
                                grade1 = Double.parseDouble(tfG1.getText());
				grade2 = Double.parseDouble(tfG2.getText());
				grade3 = Double.parseDouble(tfG3.getText());
				grade4 = Double.parseDouble(tfG4.getText());
                                weightedAverage = ((grade1 * weight1) + (grade2 * weight2) + (grade3 * weight3) + (grade4 * weight4));
				tfCalc.setText(String.format("%.2f", weightedAverage));
			}catch(Exception ex){
				tfCalc.setText("N/A");
			}
		}
	}
	public static void main(String[] args){
		Program p = new Program();
		p.setup();
		p.setSize(200,300);
		p.setVisible(true);
	}
}
