import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.*;

class Notepad1 extends JFrame implements ActionListener{
	JTextArea ta;
	String copy_txt;
	JMenuItem paste;
	int ww = 2;
	Notepad1(){
		setSize(600,400);
		setLocationRelativeTo(null);
		setTitle("Untitled");
		ta = new JTextArea();
		JScrollPane ta_sp = new JScrollPane(ta);
		add(ta_sp);
		
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu file = new JMenu("File");
		menubar.add(file);
		JMenuItem newi = new JMenuItem("New");
		file.add(newi);
		newi.addActionListener(this);
		JMenuItem open = new JMenuItem("Open");
		file.add(open);
		open.addActionListener(this);
		JMenuItem save = new JMenuItem("Save");
		file.add(save);
		save.addActionListener(this);
		JMenuItem exit = new JMenuItem("Exit");
		file.addSeparator();
		file.add(exit);
		exit.addActionListener(this);
		
		JMenu edit = new JMenu("Edit");
		menubar.add(edit);
		JMenuItem cut = new JMenuItem("Cut");
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		edit.add(cut);
		cut.addActionListener(this);
		JMenuItem copy = new JMenuItem("Copy");
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		edit.add(copy);
		copy.addActionListener(this);
		paste = new JMenuItem("Paste");
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		edit.add(paste);
		paste.setEnabled(false);
		paste.addActionListener(this);
		
		JMenu format = new JMenu("Format");
		menubar.add(format);
		JMenuItem wordwrap = new JMenuItem("WordWrap");
		format.add(wordwrap);
		wordwrap.addActionListener(this);
		JMenuItem font0 = new JMenuItem("Font");
		format.add(font0);
		font0.addActionListener(this);
		
		JMenu help = new JMenu("Help");
		menubar.add(help);
		JMenuItem about = new JMenuItem("About");
		help.add(about);
		about.addActionListener(this);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		String val = ae.getActionCommand();
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
						if(data == null)
							break;
						ta.append(data+'\n');
					}
				}
				catch(Exception ex){
					
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
				catch(Exception ex){
					
				}
			}
		}
		if(val.equals("Cut")){
			if(ta.getSelectedText().equals(null));
			else{
				copy_txt = ta.getSelectedText();
				ta.replaceSelection("");
				paste.setEnabled(true);
			}
		}
		if(val.equals("Copy")){
			if(ta.getSelectedText().equals(null));
			else{
				copy_txt = ta.getSelectedText();
				paste.setEnabled(true);
			}
		}
		if(val.equals("Paste")){
			ta.insert(copy_txt,ta.getCaretPosition());
		}
		if(val.equals("WordWrap")){
			if((ww%2)==0){
				ta.setLineWrap(true);
				ww++;
			}
			else{
				ta.setLineWrap(false);
				ww++;
			}
		}
		if(val.equals("Font")){
			Font1 f = new Font1(ta);
		}
		if(val.equals("About")){
			JOptionPane.showMessageDialog(this,"Made By Abhishek");
		}
		if(val.equals("Exit")){
			System.exit(0);
		}
	}
}
class Notepad{
	public static void main(String args[]){
		Notepad1 np = new Notepad1();
	}
}