import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.event.*;

class Font1 extends JFrame implements ActionListener, ListSelectionListener{
	JList<String> font_list;
	JList<String> style_list;
	JList<Integer> size_list;
	String font_type;
	String style_f;
	int style_i = 0;
	int size_f = 0;
	JTextArea ta;
	JTextField tf;
	Font1(JTextArea ta){
		this.ta = ta;
		setSize(450,300);
		setLayout(new FlowLayout());
		setTitle("Font");
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
		gbc.fill = gbc.HORIZONTAL;
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String font_arr[] = ge.getAvailableFontFamilyNames();
		font_list = new JList<String>(font_arr);
		JScrollPane font_pane = new JScrollPane(font_list);
		font_list.setVisibleRowCount(6);
		font_list.setFixedCellWidth(150);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(font_pane,gbc);
		font_pane.setBorder(new TitledBorder("Font:"));
		font_list.addListSelectionListener(this);
		
		String style_arr[] = {"Regular","Italic","Bold","Bold Italic"};
		style_list = new JList<String>(style_arr);
		style_list.setFixedCellWidth(100);
		style_list.setVisibleRowCount(6);
		JScrollPane style_pane = new JScrollPane(style_list);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(style_pane,gbc);
		style_pane.setBorder(new TitledBorder("Style:"));
		style_list.addListSelectionListener(this);
		
		Integer size_arr[] = {10,11,12,14,16,18,20,22,24,28,36,48,60,72,100,125};
		size_list = new JList<Integer>(size_arr);
		JScrollPane size_pane = new JScrollPane(size_list);
		size_list.setVisibleRowCount(6);
		size_list.setFixedCellWidth(50);
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(size_pane,gbc);
		size_pane.setBorder(new TitledBorder("Size:"));
		size_list.addListSelectionListener(this);
		
		tf = new JTextField("AaBbCc",8);
		tf.setEditable(false);
		tf.setBorder(new TitledBorder("Preview"));
		
		JButton ok_bt = new JButton("OK");
		gbc.gridx = 2;
		gbc.gridy = 1;
		panel.add(ok_bt,gbc);
		ok_bt.addActionListener(this);
		
		add(panel);
		add(tf);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if(font_list.isSelectionEmpty())
			font_type = ta.getFont().getFontName();
		else
			font_type = (String)font_list.getSelectedValue();
		if(style_list.isSelectionEmpty())
			style_i = ta.getFont().getStyle();
		else{
			style_f = (String)style_list.getSelectedValue();
			if(style_f.equals("Regular"))
				style_i = Font.PLAIN;
			else if(style_f.equals("Italic"))
				style_i = Font.ITALIC;
			else if(style_f.equals("Bold"))
				style_i = Font.BOLD;
			else if(style_f.equals("Bold Italic"))
				style_i = Font.BOLD+Font.ITALIC;
		}
		if(size_list.isSelectionEmpty())
			size_f = ta.getFont().getSize();
		else
			size_f = (int)size_list.getSelectedValue();
		ta.setFont(new Font(font_type,style_i,size_f));
		setVisible(false);
	}
	public void valueChanged(ListSelectionEvent e){
		if(font_list.isSelectionEmpty())
			font_type = ta.getFont().getFontName();
		else
			font_type = (String)font_list.getSelectedValue();
		if(style_list.isSelectionEmpty())
			style_i = ta.getFont().getStyle();
		else{
			style_f = (String)style_list.getSelectedValue();
			if(style_f.equals("Regular"))
				style_i = Font.PLAIN;
			else if(style_f.equals("Italic"))
				style_i = Font.ITALIC;
			else if(style_f.equals("Bold"))
				style_i = Font.BOLD;
			else if(style_f.equals("Bold Italic"))
				style_i = Font.BOLD+Font.ITALIC;
		}
		if(size_list.isSelectionEmpty())
			size_f = ta.getFont().getSize();
		else
			size_f = (int)size_list.getSelectedValue();
		tf.setFont(new Font(font_type,style_i,size_f));
		if(size_f>19 && size_f<37)
			tf.setSize(size_f*5,size_f*2);
		else if(size_f>36)
			tf.setSize(180,72);
		else if(size_f<19)
			tf.setSize(100,40);
	}
}