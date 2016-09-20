import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator1 extends JFrame implements ActionListener{
	JTextArea ta;
	int f = 0, f1 = 0;
	double val_1=0 , val_2=0 , val_3=0;
	String v3;
	Calculator1(){
		setSize(225,275);
		setTitle("Calculator");
		setResizable(false);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		ta = new JTextArea();
		ta.setColumns(15);
		ta.setFont(new Font("Times New Roman",Font.PLAIN,18));
		add(ta);
		
		JPanel panel_bt = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20,4,4,4);
		
		JButton bt_7 = new JButton("7");
		JButton bt_8 = new JButton("8");
		JButton bt_9 = new JButton("9");
		JButton bt_4 = new JButton("4");
		JButton bt_5 = new JButton("5");
		JButton bt_6 = new JButton("6");
		JButton bt_1 = new JButton("1");
		JButton bt_2 = new JButton("2");
		JButton bt_3 = new JButton("3");
		JButton bt_0 = new JButton("0");
		JButton bt_add = new JButton("+");
		JButton bt_sub = new JButton("-");
		JButton bt_mul = new JButton("*");
		JButton bt_div = new JButton("/");
		JButton bt_dot = new JButton(".");
		JButton bt_equal = new JButton("=");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel_bt.add(bt_7,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel_bt.add(bt_8,gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel_bt.add(bt_9,gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		panel_bt.add(bt_div,gbc);
		gbc.insets = new Insets(4,4,4,4);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel_bt.add(bt_4,gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel_bt.add(bt_5,gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		panel_bt.add(bt_6,gbc);
		gbc.gridx = 3;
		gbc.gridy = 1;
		panel_bt.add(bt_mul,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel_bt.add(bt_1,gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel_bt.add(bt_2,gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		panel_bt.add(bt_3,gbc);
		gbc.gridx = 3;
		gbc.gridy = 2;
		panel_bt.add(bt_sub,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel_bt.add(bt_0,gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel_bt.add(bt_dot,gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		panel_bt.add(bt_equal,gbc);
		gbc.gridx = 3;
		gbc.gridy = 3;
		panel_bt.add(bt_add,gbc);
		
		bt_0.addActionListener(this);
		bt_1.addActionListener(this);
		bt_2.addActionListener(this);
		bt_3.addActionListener(this);
		bt_4.addActionListener(this);
		bt_5.addActionListener(this);
		bt_6.addActionListener(this);
		bt_7.addActionListener(this);
		bt_8.addActionListener(this);
		bt_9.addActionListener(this);
		bt_dot.addActionListener(this);
		bt_add.addActionListener(this);
		bt_sub.addActionListener(this);
		bt_mul.addActionListener(this);
		bt_div.addActionListener(this);
		bt_equal.addActionListener(this);
		
		
		add(panel_bt);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		String val = ae.getActionCommand();
		try{
			if((f1==0) && (val.equals("0") || val.equals("1") || val.equals("2") || val.equals("3") || val.equals("4") || val.equals("5") || val.equals("6") || val.equals("7") || val.equals("8") || val.equals("9") || val.equals("."))){ 
				ta.setText(ta.getText()+val);
			}
			else if((f1==1) && (val.equals("0") || val.equals("1") || val.equals("2") || val.equals("3") || val.equals("4") || val.equals("5") || val.equals("6") || val.equals("7") || val.equals("8") || val.equals("9") || val.equals("."))){ 
				ta.setText(val);
				f1=0;
			}
			if(val.equals("+")){
				val_1 = Double.parseDouble(ta.getText());
				f=1;
				f1=1;
			}
			if(val.equals("-")){
				val_1 = Double.parseDouble(ta.getText());
				f=2;
				f1=1;
			}
			if(val.equals("*")){
				val_1 = Double.parseDouble(ta.getText());
				f=3;
				f1=1;
			}
			if(val.equals("/")){
				val_1 = Double.parseDouble(ta.getText());
				f=4;
				f1=1;
			}
			if(val.equals("=")){
				if(f==0){
					JOptionPane.showMessageDialog(this,"Enter Correct Values");
				}
				else if(f==1){
					val_2 = Double.parseDouble(ta.getText());
					val_3 = val_1+val_2;
					v3 = String.valueOf(val_3);
					ta.setText(v3);
				}
				else if(f==2){
					val_2 = Double.parseDouble(ta.getText());
					val_3 = val_1-val_2;
					v3 = String.valueOf(val_3);
					ta.setText(v3);
				}
				else if(f==3){
					val_2 = Double.parseDouble(ta.getText());
					val_3 = val_1*val_2;
					v3 = String.valueOf(val_3);
					ta.setText(v3);
				}
				else if(f==4){
					val_2 = Double.parseDouble(ta.getText());
					val_3 = val_1/val_2;
					v3 = String.valueOf(val_3);
					ta.setText(v3);
				}
				f1=1;
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "Enter Correct Values");
			ta.setText("");
		}
	}
}

class Calculator{
	public static void main(String args[]){
		Calculator1 c = new Calculator1();
	}
}