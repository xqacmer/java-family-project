import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GetDataBase extends JFrame implements ActionListener {
	
	JLabel UTxt;
	JLabel PTxt;
	JTextField uTxt;
	JPasswordField pText;
	JButton submitButton;
	JButton reseButton;
	Family f;
	GetDataBase() {
		/************创建树*************/
		f = new Family();
	    f.initRoot();
	    f.CreateFamilyTree(Family.root);
	    
		this.setSize(300,200);
		setLocation(600, 500);
		this.setTitle("数据库登录");
		this.setLayout(null);
		UTxt = new JLabel("用户名：");
		UTxt.setBounds(20,20,80,20);
		add(UTxt);
		uTxt = new JTextField();
		uTxt.setBounds(80,20,150,20);
		add(uTxt);
		PTxt = new JLabel("密码：");
		PTxt.setBounds(20,60,80,20);
		add(PTxt);
		pText = new JPasswordField();
		pText.setBounds(80,60,150,20);
		add(pText);
		submitButton = new JButton("登录");
		submitButton.setBounds(30,120,60,30);
		submitButton.addActionListener(this);
		add(submitButton);
		reseButton = new JButton("重置");
		reseButton.addActionListener(this);
		reseButton.setBounds(200,120,60,30);
		add(reseButton);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reseButton) {
			uTxt.setText("");
			pText.setText("");
		}
		if(e.getSource()==submitButton) {
			f.connectionDB_MySQL(pText.getPassword().toString());
		}
	}

}

