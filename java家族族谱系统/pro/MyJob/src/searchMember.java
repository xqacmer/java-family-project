import java.awt.event.ItemEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/********************查找窗口****************************/
public class searchMember implements ActionListener,ItemListener {
	
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JLabel brithday;
	JLabel MemberName;
	JLabel agebre;
	JLabel Relationship;
	
	JTextField MyName;
	JTextField Agebre;
	
	JTextArea relation;
	
	JButton searchSameBrithday;//查询相同生日的成员按钮
	JButton searchRelationship;//查询两人关系的成员按钮
	
	Border b1 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder Search = BorderFactory.createTitledBorder(b1, "查询");
	Border b2 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.darkGray);
	TitledBorder SameBrithdaySearch = BorderFactory.createTitledBorder(b2, "生日相同查询");
	Border b3 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder RelationshipSearch = BorderFactory.createTitledBorder(b2, "关系查询");
	Border b4 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.BLACK);
	TitledBorder table = BorderFactory.createTitledBorder(b4, "所有同一天生日的人");
	JSplitPane sp;
	
	FTFrame FTF4 = new FTFrame("查询");
	Family f;
	String month , day;
	searchMember() {
		/************创建树*************/
		f = new Family();
	    f.initRoot();
	    f.CreateFamilyTree(Family.root);
		/***********添加监听器***************/
		FTF4.addMember.addActionListener(this);
		FTF4.deleteMember.addActionListener(this); 
		FTF4.modifyMember.addActionListener(this); 
		FTF4.showFamilyTable.addActionListener(this); 
		FTF4.showFamilyTree.addActionListener(this); 
		
		FTF4.jp1 = new JPanel();
		FTF4.jp2 = new JPanel();
		
		/********添加按钮*******/
		FTF4.jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		FTF4.jp1.add(FTF4.function);
		FTF4.jp1.add(FTF4.addMember);
		FTF4.jp1.add(FTF4.deleteMember);
		FTF4.jp1.add(FTF4.modifyMember);
		FTF4.jp1.add(FTF4.showFamilyTable);
		FTF4.jp1.add(FTF4.showFamilyTree);
		
		/*************在JPanel中添加组件*************/
		FTF4.jp2.setLayout(null);
		FTF4.jp2.setBorder(Search);
		jp1 = new JPanel();
		jp1.setBounds(20,20,350,380);
		jp1.setLayout(null);
		jp1.setBorder(SameBrithdaySearch);
		/********** 添加下拉列表 *************/
		brithday = new JLabel("生日:");
		brithday.setBounds(20, 20, 40, 25);
		jp1.add(brithday);
		FTF4.Bmonth.setBounds(60, 20, 60, 25);
		FTF4.Bmonth.addItemListener(this);
		jp1.add(FTF4.Bmonth);
		FTF4.Bday.setBounds(120, 20, 60, 25);
		FTF4.Bday.addItemListener(this);
		jp1.add(FTF4.Bday);
		searchSameBrithday = new JButton("查询");
		searchSameBrithday.setBounds(190,20,80,25);
		jp1.add(searchSameBrithday);
		searchSameBrithday.addActionListener(this);
		/*************添加表格*************/
		jp2 = new JPanel();
		jp2.setBounds(20,50,300,320);
		jp2.setLayout(null);
		jp2.setBorder(table);
		FTF4.sp.setBounds(20,20,260,280);
		jp2.add(FTF4.sp);
		jp1.add(jp2);
		FTF4.jp2.add(jp1);
		/************关系查询部分*************/
		
		jp3 = new JPanel();
		jp3.setBounds(380,20,200,380);
		jp3.setLayout(null);
		jp3.setBorder(RelationshipSearch);
		FTF4.MemberName.setBounds(20,20,80,20);
		jp3.add(FTF4.MemberName);
		FTF4.MyName.setBounds(60,20,120,20);
		jp3.add(FTF4.MyName);
         /********代数*********/
		
		FTF4.agebre.setBounds(20,60,80,20);
		FTF4.Agebre.setBounds(60,60,80,20);
		jp3.add(FTF4.agebre);
		jp3.add(FTF4.Agebre);
		
		MemberName = new JLabel("姓名：");
		MemberName.setBounds(20,100,80,20);
		jp3.add(MemberName);
		MyName = new JTextField();
		MyName.setBounds(60,100,120,20);
		jp3.add(MyName);
         /********代数*********/
		agebre = new JLabel("代数：");
		agebre.setBounds(20,140,80,20);
		Agebre = new JTextField();
		Agebre.setBounds(60,140,80,20);
		jp3.add(agebre);
		jp3.add(Agebre);
		FTF4.jp2.add(jp3);
		
		/***********显示关系*************/
		Relationship = new JLabel("关系：");
		Relationship.setBounds(20,180,80,20);
		jp3.add(Relationship);
		relation = new JTextArea(2,5);
		relation.setBounds(60,180,120,40);
		jp3.add(relation);
		
		searchRelationship = new JButton("查询关系");
		searchRelationship.addActionListener(this);
		searchRelationship.setBounds(50,250,100,30);
		jp3.add(searchRelationship);
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,FTF4.jp1,FTF4.jp2);
		sp.setBounds(0,0,600,400);
		FTF4.add(sp);
		FTF4.setLocation(240, 240);
		FTF4.setSize(600, 500);
		FTF4.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==FTF4.addMember) {//添加成员事件响应
			AddMember addFrame = new AddMember();
		}
		if(e.getSource()==FTF4.deleteMember) {//删除成员事件响应
			deleteMember deleteFrame = new deleteMember();
		}
		if(e.getSource()==FTF4.modifyMember) {//修改成员事件响应
			ModifyMember modifyMemberFrame = new ModifyMember();
		}
		if(e.getSource()==FTF4.showFamilyTable) {//图像显示图谱事件响应
			showFamilyTable showtableFrame = new showFamilyTable();
		}
		if(e.getSource()==FTF4.showFamilyTree) {
			
		}
		if(e.getSource()==searchRelationship) {//关系查询按钮响应事件
			String name = FTF4.MyName.getText();
			String Name = MyName.getText();
			relation.setText(f.relationship(name, Name));//查询开始
		}
		if(e.getSource()==searchSameBrithday) {//生日相同成员查询
			f.birthday(Family.root, new Birthday(Integer.parseInt(month),Integer.parseInt(day)));
			FTF4.initrowDataTH(f.birthday);
			FTF4.init();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {//出生日期时间响应
			if(e.getSource()==FTF4.Bmonth) {
				month = FTF4.Bmonth.getSelectedItem().toString();
			}
			if(e.getSource()==FTF4.Bday) {
				day = FTF4.Bday.getSelectedItem().toString();
			}
		}
	}
}

