import java.awt.event.ItemEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/***************** ��ӳ�Ա���� ***********************/
public class AddMember implements ActionListener,ItemListener {
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	
	JButton submitButtonO;
	JButton submitButtonT;
	JButton reseButton;
	
	JLabel Name;
	JTextField name;
	
	/*************��һ��������*************/
	String Oyear,Omonth,Oday;//����
	int Oage;//����
	
	/************�ڶ���������************/
	String Tyear,Tmonth,Tday;//����
	int Tage;//����

	String sex;//�Ա�
	
	String myname;
	String fname;
	String Myname;
	String spouseName;
	/***********���*************/
	Border b1 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder myMessage = BorderFactory.createTitledBorder(b1, "������Ϣ");
	Border b2 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder addOne = BorderFactory.createTitledBorder(b2, "���<һ>");
	Border b3 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder addTwo = BorderFactory.createTitledBorder(b2, "���<��>");
	Border b4 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.GREEN);
	TitledBorder law = BorderFactory.createTitledBorder(b4, "ʹ����֪");
	
	FTFrame FTF1 = new FTFrame("��ӳ�Ա");
	FTFrame FTF= new FTFrame("��ӳ�Ա");
	JSplitPane sp;
	
	Family f;
	Person p;
	Person p1;
	AddMember() {
		/************������*************/
		f = new Family();
	    f.initRoot();
	    f.CreateFamilyTree(Family.root);
	    
		
	    FTF1.deleteMember.addActionListener(this); 
		FTF1.modifyMember.addActionListener(this); 
		FTF1.searchMember.addActionListener(this); 
		FTF1.showFamilyTree.addActionListener(this); 
		FTF1.showFamilyTable.addActionListener(this); 
		
		FTF1.jp1 = new JPanel();
		FTF1.jp2 = new JPanel();
		/********��Ӱ�ť*******/
		FTF1.jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		FTF1.jp1.add(FTF1.function);
		FTF1.jp1.add(FTF1.deleteMember);
		FTF1.jp1.add(FTF1.modifyMember);
		FTF1.jp1.add(FTF1.searchMember);
		FTF1.jp1.add(FTF1.showFamilyTable);
		FTF1.jp1.add(FTF1.showFamilyTree);
		
		/*************��һ��������*************/
		FTF1.jp2.setLayout(null);
		FTF1.jp2.setBorder(myMessage);
		jp1 = new JPanel();
		jp1.setLayout(null);
		jp1.setBounds(20,20,350,180);
		jp1.setBorder(addOne);
		FTF.MemberName.setBounds(20,20,80,20);
		jp1.add(FTF.MemberName);
		FTF.MyName.setBounds(60,20,120,20);
		jp1.add(FTF.MyName);
		FTF.Age.setBounds(190,20,80,20);
		jp1.add(FTF.Age);
		FTF.age.setBounds(230,20,100,20);
		jp1.add(FTF.age);
		FTF.FatherName.setBounds(20,60,80,20);
		jp1.add(FTF.FatherName);
		FTF.FName.setBounds(100,60,120,20);
		jp1.add(FTF.FName);
		FTF.MemberSex.setBounds(20,100,80,20);
		jp1.add(FTF.MemberSex);
		/************* ��ӵ�ѡ�� *************/
		FTF.men.setBounds(60,100,80,20);
		FTF.women.setBounds(140,100,80,20);
		FTF.men.addItemListener(this);
		FTF.women.addItemListener(this);
		jp1.add(FTF.men);
		jp1.add(FTF.women);
		
		/********** ��������б� *************/
	
		FTF.MemberBrithday.setBounds(20, 140, 80, 20);
		jp1.add(FTF.MemberBrithday);
		FTF.Byear.setBounds(100, 140, 60, 20);
		FTF.Byear.addItemListener(this);
		jp1.add(FTF.Byear);
		FTF.Bmonth.setBounds(160, 140, 60, 20);
		FTF.Bmonth.addItemListener(this);
		jp1.add(FTF.Bmonth);
		FTF.Bday.setBounds(220, 140, 60, 20);
		FTF.Bday.addItemListener(this);
		jp1.add(FTF.Bday);
		
		
		FTF1.jp2.add(jp1);
		/*********�ڶ���������***********/
		jp2 = new JPanel();
		jp2.setLayout(null);
		jp2.setBorder(addTwo);
		jp2.setBounds(400,0,350,200);
		FTF1.MemberName.setBounds(20,20,80,20);
		jp2.add(FTF1.MemberName);
		FTF1.MyName.setBounds(60,20,120,20);
		jp2.add(FTF1.MyName);
		FTF1.Age.setBounds(190,20,80,20);
		jp2.add(FTF1.Age);
		FTF1.age.setBounds(230,20,100,20);
		jp2.add(FTF1.age);
		Name = new JLabel("��ż������");
		Name.setBounds(20,60,80,20);
		jp2.add(Name);
		name = new JTextField();
		name.setBounds(100,60,120,20);
		jp2.add(name);
		FTF1.MemberSex.setBounds(20,100,80,20);
		jp2.add(FTF1.MemberSex);
		/************* ��ӵ�ѡ�� *************/
		FTF1.men.setBounds(60,100,80,20);
		FTF1.women.setBounds(140,100,80,20);
		FTF1.men.addItemListener(this);
		FTF1.women.addItemListener(this);
		jp2.add(FTF1.men);
		jp2.add(FTF1.women);
		FTF1.MemberBrithday.setBounds(20, 140, 80, 20);
		jp2.add(FTF1.MemberBrithday);
		FTF1.Byear.setBounds(100, 140, 60, 20);
		FTF1.Byear.addItemListener(this);
		jp2.add(FTF1.Byear);
		FTF1.Bmonth.setBounds(160, 140, 60, 20);
		FTF1.Bmonth.addItemListener(this);
		jp2.add(FTF1.Bmonth);
		FTF1.Bday.setBounds(220, 140, 60, 20);
		FTF1.Bday.addItemListener(this);
		jp2.add(FTF1.Bday);
		FTF1.jp2.add(jp2);
		
		/*************ʹ��ϸ��*************/
		jp3 = new JPanel();
		jp3.setLayout(null);
		jp3.setBorder(law);
		jp3.setBounds(20,200,700,200);
		FTF1.law.append("(1)����ӳ������������ѡ�"+ '\n' + "(2)��һ��Ϊ���ݸ��������ӣ�" + '\n' + "(3)�ڶ���Ϊ������ż�����ӣ�" 
		        		+ '\n' + "(4)��ʹ���߸����������ѡ����ӣ�" + '\n' + "(5)����д��Ϣ����󣬿ɰ��ύ��ť��ӣ�" + '\n' 
		        		+ "(6)�����д��Ϣ���󣬿ɰ����ð�ť�����Ϣ��" + '\n' + "(7)���ף��ʹ����죡");//���ʹ��ϸ��
		FTF1.law.setEditable(false);
		FTF1.law.setBounds(50,25,600,150);
		jp3.add(FTF1.law);
		FTF1.jp2.add(jp3);
		
		/*************��Ӱ�ť*****************/
		submitButtonO = new JButton("�ύ<һ>");
		submitButtonO.setBounds(150, 450, 60, 30);
		FTF1.jp2.add(submitButtonO);
		submitButtonT = new JButton("�ύ<��>");
		submitButtonT.setBounds(600, 450, 60, 30);
		FTF1.jp2.add(submitButtonT);
		reseButton = new JButton("����");
		reseButton.setBounds(380, 450, 60, 30);
		FTF1.jp2.add(reseButton);
		submitButtonO.addActionListener(this);// ��Ӽ�����
		submitButtonT.addActionListener(this);
		reseButton.addActionListener(this);
		
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,FTF1.jp1,FTF1.jp2);
		sp.setBounds(0,0,800,600);
		FTF1.add(sp);
		
		
		FTF1.setLocation(240, 240);
		FTF1.setSize(800, 600);
		FTF1.setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {
		Checkbox JBtemp;
		if(e.getItemSelectable() instanceof Checkbox) {
			JBtemp = (Checkbox)(e.getItemSelectable());
			if(JBtemp.getLabel() == "��") {
				sex = "��";
			}
			if(JBtemp.getLabel() == "Ů") {
				sex = "Ů";
			}
		}
		if(e.getStateChange() == ItemEvent.SELECTED) {//��������ʱ����Ӧ
			if(e.getSource()==FTF.Byear) {
				Oyear = FTF.Byear.getSelectedItem().toString();
			}
			if(e.getSource()==FTF.Bmonth) {
				Omonth = FTF.Bmonth.getSelectedItem().toString();
			}
			if(e.getSource()==FTF.Bday) {
				Oday = FTF.Bday.getSelectedItem().toString();
			}
			if(e.getSource()==FTF1.Byear) {
				Tyear = FTF1.Byear.getSelectedItem().toString(); 
			}
			if(e.getSource()==FTF1.Bmonth) {
				Tmonth = FTF1.Bmonth.getSelectedItem().toString();
			}
			if(e.getSource()==FTF1.Bday) {
				Tday = FTF1.Bday.getSelectedItem().toString();
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		/**************��ݹ��ܼ���Ӧ�¼�****************/
		if(e.getSource()==FTF1.deleteMember) {//ɾ����Ա��ť
			deleteMember deleteFrame = new deleteMember();
		}
		if(e.getSource()==	FTF1.modifyMember) {//�޸ĳ�Ա��ť
			ModifyMember modifyMemberFrame = new ModifyMember();
		}
		if(e.getSource()==FTF1.searchMember) {//��ѯ��ť
			searchMember seacherMemberFrame = new searchMember();
		}
		if(e.getSource()==FTF1.showFamilyTree) {//ͼ�δ�ӡ���װ�ť
			
		}
		if(e.getSource()==FTF1.showFamilyTable) {//�����ʾ���װ�ť
			showFamilyTable showtableFrame = new showFamilyTable();
		}
		if (e.getSource() == submitButtonO) {//ȷ�ϰ�ť
			myname = FTF.MyName.getText();
			fname = FTF.FName.getText();
			Oage = Integer.parseInt(FTF.age.getText());
			p = new Person(myname,Oage,sex,new Birthday(Integer.parseInt(Omonth),Integer.parseInt(Oday)),fname);
			String s = f.addMember(p);
			if(s.equals("����ɹ�")) {
				 JOptionPane.showMessageDialog(null,"��ӳɹ�");
			}
			else {
				JOptionPane.showMessageDialog(null,s);
			}	
		}
		if (e.getSource() == submitButtonT) {//ȷ�ϰ�ť
			Myname = FTF1.MyName.getText();
			spouseName = name.getText();
			Tage = Integer.parseInt(FTF1.age.getText());
			p = new Person(Myname,Tage,new Birthday(Integer.parseInt(Tmonth),Integer.parseInt(Tday)),spouseName);
			String s = f.addMember(p);
			if(s.equals("����ɹ�")) {
				 JOptionPane.showMessageDialog(null,"��ӳɹ�");
			}
			else {
				JOptionPane.showMessageDialog(null,s);
			}
		}
		
		if (e.getSource() == reseButton) {
			FTF.MyName.setText("");
			FTF.FName.setText("");
			FTF1.MyName.setText("");
			FTF.age.setText("");
			FTF1.age.setText("");
			name.setText("");
		}	
	}
}

