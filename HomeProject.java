import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Home extends JFrame implements ActionListener{
	JTextArea ta;
	Home(){
		setSize(500,400);
		ta = new JTextArea();
		ta.setFont(new Font("Lucida Sans Typewriter",Font.BOLD,20));
		JScrollPane text_pane = new JScrollPane(ta);
		add(text_pane);
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newitem = new JMenuItem("New");
		newitem.addActionListener(this);
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(this);
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(this);
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		file.add(newitem);
		file.addSeparator();
		file.add(open);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(exit);
		JMenu edit = new JMenu("Edit");
		JMenu format = new JMenu("Format");
		JMenuItem font = new JMenuItem("Font");
		font.addActionListener(this);
		JMenuItem color = new JMenuItem("Color");
		color.addActionListener(this);
		format.add(font);
		format.addSeparator();
		format.add(color);
		JMenu help = new JMenu("Help");
		mb.add(file);
		mb.add(edit);
		mb.add(format);
		mb.add(help);
		setJMenuBar(mb);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		String val = ae.getActionCommand();
		System.out.println(val);
		if(val.equals("New")){
			ta.setText("");
			setTitle("Untitled");
		}
		if(val.equals("Open")){
			JFileChooser chooser = new JFileChooser();
			int k = chooser.showOpenDialog(this);
			if(k==JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				String path = file.getPath();
				setTitle(path);
				try{
					FileReader fr = new FileReader(path);
					BufferedReader br = new BufferedReader(fr);
					while(true){
						String data = br.readLine();
						if(data==null){
							break;
						}
						ta.append(data+'\n');
					}
				}
				catch(Exception e){
					
				}
			}
		}
		if(val.equals("Save")){
			JFileChooser chooser = new JFileChooser();
			int k = chooser.showSaveDialog(this);
			if(k==JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				String path = file.getPath();
				setTitle(path);
				try{
					FileWriter fw = new FileWriter(path,true);
					PrintWriter pw = new PrintWriter(fw);
					String data = ta.getText();
					pw.println(data);
					fw.close();
				}
				catch(Exception e){
					
				}
			}
		}
		if(val.equals("Exit")){
			System.exit(0);
		}
		if(val.equals("Color")){
			Color col = JColorChooser.showDialog(this,"Choose Color",Color.GREEN);
			ta.setForeground(col);
		}
	}
}
class HomeProject{
	public static void main(String args[]){
		Home h = new Home();
	}
}