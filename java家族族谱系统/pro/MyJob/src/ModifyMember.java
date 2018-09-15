import java.awt.event.ItemEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/*******************修改窗口*********************/
public class ModifyMember implements ActionListener,ItemListener {
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JPanel jp4;
	JButton submitButton;
	JButton reseButton;
	JButton searchMember;
	JLabel newName;
	JTextField newname;
	
	String year,month,day;//日期
	String islive;
	
	/***********组框*************/
	Border b1 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder myMessage = BorderFactory.createTitledBorder(b1, "修改信息");
	Border b2 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.green);
	Border b3 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.red);
	TitledBorder search = BorderFactory.createTitledBorder(b1, "查询");
	TitledBorder law = BorderFactory.createTitledBorder(b2, "使用须知");
	TitledBorder mymessage = BorderFactory.createTitledBorder(b1, "个人信息");
	TitledBorder table = BorderFactory.createTitledBorder(b3, "信息表");
	
	FTFrame FTF5 = new FTFrame("修改成员");
	FTFrame FTF= new FTFrame("修改成员");
	JSplitPane sp;
	Family f;
	
	ModifyMember() {
		/************创建树*************/
		f = new Family();
	    f.initRoot();
	    f.CreateFamilyTree(Family.root);
		FTF5.addMember.addActionListener(this); 
		FTF5.deleteMember.addActionListener(this); 
		FTF5.searchMember.addActionListener(this); 
		FTF5.showFamilyTree.addActionListener(this); 
		FTF5.showFamilyTable.addActionListener(this); 
		
		FTF5.jp1 = new JPanel();
		FTF5.jp2 = new JPanel();
		/********添加按钮*******/
		FTF5.jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		FTF5.jp1.add(FTF5.function);
		FTF5.jp1.add(FTF5.deleteMember);
		FTF5.jp1.add(FTF5.addMember);
		FTF5.jp1.add(FTF5.searchMember);
		FTF5.jp1.add(FTF5.showFamilyTable);
		FTF5.jp1.add(FTF5.showFamilyTree);
		
		/*************在JPanel中添加组件*************/
		FTF5.jp2.setLayout(null);
		FTF5.jp2.setBorder(myMessage);
		jp1 = new JPanel();
		jp1.setBounds(20,20,500,350);
		jp1.setLayout(null);
		jp1.setBorder(mymessage);
		FTF5.MemberName.setBounds(20,20,80,20);
		jp1.add(FTF5.MemberName);
		FTF5.MyName.setBounds(60,20,100,20);
		jp1.add(FTF5.MyName);
		newName = new JLabel("修改名：");
		newName.setBounds(170,20,80,20);
		jp1.add(newName);
		newname = new JTextField();
		newname.setBounds(230,20,100,20);
		jp1.add(newname);
		FTF5.Age.setBounds(340,20,80,20);
		jp1.add(FTF5.Age);
		FTF5.age.setBounds(380,20,100,20);
		jp1.add(FTF5.age);
		FTF5.MemberBrithday.setBounds(20,70,80,20);
		jp1.add(FTF5.MemberBrithday);
		FTF5.Byear.setBounds(100, 70, 60, 20);
		FTF5.Byear.addItemListener(this);
		jp1.add(FTF5.Byear);
		FTF5.Bmonth.setBounds(160, 70, 60, 20);
		FTF5.Bmonth.addItemListener(this);
		jp1.add(FTF5.Bmonth);
		FTF5.Bday.setBounds(220, 70, 60, 20);
		FTF5.Bday.addItemListener(this);
		jp1.add(FTF5.Bday);
		FTF5.isAlive.setBounds(310,70,80,20);
		jp1.add(FTF5.isAlive);
		FTF5.y_n.setBounds(380,70,80,20);
		FTF5.y_n.addItemListener(this);
		jp1.add(FTF5.y_n);
		
		/*************添加按钮*****************/
		submitButton = new JButton("提交");
		submitButton.setBounds(100, 120, 60, 30);
		jp1.add(submitButton);
		reseButton = new JButton("重置");
		reseButton.setBounds(340, 120, 60, 30);
		jp1.add(reseButton);
		submitButton.addActionListener(this);// 添加监听器
		reseButton.addActionListener(this);
		FTF5.jp2.add(jp1);
		
		/*******************jp2*********************/
		jp2 = new JPanel();
		jp2.setBounds(530,20,440,350);
		jp2.setLayout(null);
		jp2.setBorder(search);
		FTF.MemberName.setBounds(20,20,80,30);
		jp2.add(FTF.MemberName);
		FTF.MyName.setBounds(60,20,100,30);
		jp2.add(FTF.MyName);
		searchMember = new JButton("查询");
		searchMember.setBounds(170,20,60,30);
		searchMember.addActionListener(this);
		jp2.add(searchMember);
		jp3 = new JPanel();
		jp3.setBounds(20,50,410,280);
		jp3.setLayout(null);
		jp3.setBorder(table);
		FTF5.sp.setBounds(20,20,380,240);
		jp3.add(FTF5.sp);
		jp2.add(jp3);
		FTF5.jp2.add(jp2);
		
		
		/*************使用细则*************/
		jp4 = new JPanel();
		jp4.setLayout(null);
		jp4.setBorder(law);
		jp4.setBounds(20,150,450,200);
		FTF5.law.append("(1)本修改界面共有两大功能！" + '\n' + "(2)第一位修改功能！" + '\n' + "(3)第二为查找功能！" + '\n' 
						+ "(4)修改成员信息时，必须先进行查找，否则无法进行修改！" + '\n' + "(5)查找功能为按信息查找！" + '\n' 
						+ "(6)请你按说明操作，谢谢！");//添加使用细则
		FTF5.law.setEditable(false);
		FTF5.law.setBounds(50,25,350,150);
		jp4.add(FTF5.law);
		jp1.add(jp4);
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,FTF5.jp1,FTF5.jp2);
		sp.setBounds(0,0,800,400);
		FTF5.add(sp);
		FTF5.setLocation(240, 240);
		FTF5.setSize(1000, 500);
		FTF5.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==FTF5.addMember) {//添加成员事件响应
			AddMember addFrame = new AddMember();
		}
		if(e.getSource()==FTF5.deleteMember) {//删除成员事件响应
			deleteMember deleteFrame = new deleteMember();
		}
		if(e.getSource()==FTF5.searchMember) {//查询成员事件响应
			searchMember seacherMemberFrame = new searchMember();
		}
		
		if(e.getSource()==FTF5.showFamilyTable) {//图像显示图谱事件响应
			showFamilyTable showtableFrame = new showFamilyTable();
		}
		if(e.getSource()==FTF5.showFamilyTree) {
			CFrame cf = new CFrame(f.root);
		}
		if (e.getSource() == submitButton) {//确认按钮
			String s = f.modification(FTF5.MyName.getText(),newname.getText(),Integer.parseInt(FTF5.age.getText()),new Birthday(Integer.parseInt(month),Integer.parseInt(day)),Boolean.parseBoolean(islive));
			if(s.equals("修改完成")) {
				 JOptionPane.showMessageDialog(null,"修改成功");
			}
			else {
				JOptionPane.showMessageDialog(null,s);
			}	
		}
		if(e.getSource()==searchMember) {
			FTF5.initrowDataF(FTF.MyName.getText());
		}
		if (e.getSource() == reseButton) {
			FTF5.MyName.setText("");
			FTF5.Agebre.setText("");
			FTF5.child_Sum.setText("");
			FTF5.FName.setText("");
			FTF5.MName.setText("");
		}	
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {//出生日期时间响应
			if(e.getSource()==FTF5.Byear) {
				year = FTF5.Byear.getSelectedItem().toString();
			}
			if(e.getSource()==FTF5.Bmonth) {
				month = FTF5.Bmonth.getSelectedItem().toString();
			}
			if(e.getSource()==FTF5.Bday) {
				day = FTF5.Bday.getSelectedItem().toString();
			}
			if(e.getSource()==FTF5.y_n) {
				islive = FTF5.y_n.getSelectedItem().toString();
			}
		}
	}
}


