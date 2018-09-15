import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/*********************ɾ����Ա����*****************************/
class deleteMember extends JFrame implements ActionListener,ItemListener {
	JButton deleteAllButton;
	JButton deleteOneButton;
	JButton reseButton;
	JPanel jp;
	Border b1 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder myMessage = BorderFactory.createTitledBorder(b1, "������Ϣ");
	Border b2 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder parentsMessage = BorderFactory.createTitledBorder(b2, "��ĸ��Ϣ");
	JSplitPane sp;
	
	FTFrame FTF2 = new FTFrame("ɾ����Ա");
	Family f;
	deleteMember() {
		/************������*************/
		f = new Family();
	    f.initRoot();
	    f.CreateFamilyTree(Family.root);
		/***********��Ӽ�����***************/
		FTF2.addMember.addActionListener(this); 
		FTF2.modifyMember.addActionListener(this); 
		FTF2.searchMember.addActionListener(this); 
		FTF2.showFamilyTree.addActionListener(this); 
		FTF2.showFamilyTable.addActionListener(this); 
		
		FTF2.jp1 = new JPanel();
		FTF2.jp2 = new JPanel();
		/********��Ӱ�ť*******/
		FTF2.jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		FTF2.jp1.add(FTF2.function);
		FTF2.jp1.add(FTF2.addMember);
		FTF2.jp1.add(FTF2.modifyMember);
		FTF2.jp1.add(FTF2.searchMember);
		FTF2.jp1.add(FTF2.showFamilyTable);
		FTF2.jp1.add(FTF2.showFamilyTree);
		

		/*************��JPanel��������*************/
		FTF2.jp2.setLayout(null);
		FTF2.jp2.setBorder(myMessage);
		
		FTF2.MemberName.setBounds(20,20,80,20);
		FTF2.jp2.add(FTF2.MemberName);
		FTF2.MyName.setBounds(60,20,120,20);
		FTF2.jp2.add(FTF2.MyName);
		FTF2.MemberSex.setBounds(20,60,80,20);
		FTF2.jp2.add(FTF2.MemberSex);
		/************* ��ӵ�ѡ�� *************/
		FTF2.men.setBounds(60,60,80,20);
		FTF2.women.setBounds(140,60,80,20);
		FTF2.men.addItemListener(this);
		FTF2.women.addItemListener(this);
		FTF2.jp2.add(FTF2.men);
		FTF2.jp2.add(FTF2.women);
		
       /********����*********/
		
		FTF2.agebre.setBounds(20,100,80,20);
		FTF2.Agebre.setBounds(60,100,80,20);
		FTF2.jp2.add(FTF2.agebre);
		FTF2.jp2.add(FTF2.Agebre);
		
		/*********��Ӹ�ĸ��Ϣ***********/
		jp = new JPanel();
		jp.setLayout(null);
		jp.setBorder(parentsMessage);
		jp.setBounds(220,0,250,120);
	
		FTF2.FatherName.setBounds(20,20,80,20);
		jp.add(FTF2.FatherName);
		FTF2.FName.setBounds(100,20,120,20);
		jp.add(FTF2.FName);
		
		
		FTF2.MotherName.setBounds(20,80,80,20);
		jp.add(FTF2.MotherName);
		FTF2.MName.setBounds(100,80,120,20);
		jp.add(FTF2.MName);
		FTF2.jp2.add(jp);
		
		deleteAllButton = new JButton("ȫ��ɾ��");
		deleteAllButton.setBounds(80,150,90,25);
		FTF2.jp2.add(deleteAllButton);
		deleteAllButton.addActionListener(this);
		
		deleteOneButton = new JButton("ɾ���Լ�");
		deleteOneButton.setBounds(180,150,90,25);
		FTF2.jp2.add(deleteOneButton);
		deleteOneButton.addActionListener(this);
		
		reseButton = new JButton("����");
		reseButton.setBounds(280,150,90,25);
		FTF2.jp2.add(reseButton);
		reseButton.addActionListener(this);
		
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,FTF2.jp1,FTF2.jp2);
		sp.setBounds(0,0,500,400);
		FTF2.add(sp);
		FTF2.setLocation(240, 240);
		FTF2.setSize(500, 300);
		FTF2.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String name;
		String message = "ȷ��" + FTF2.MyName.getText() + "�ĸ�����Ϣ?";
		if(e.getSource()==deleteOneButton) {
			int reaOne = JOptionPane.showConfirmDialog(this, message, "ɾ����Ϣ", JOptionPane.OK_CANCEL_OPTION);
			if(reaOne == JOptionPane.OK_OPTION) {
				//���ܴ��룬ɾ��������Ϣ
			}
		}
		if(e.getSource()==deleteAllButton) {
			int reaAll = JOptionPane.showConfirmDialog(this, "�Ƿ����Ӵ���Ϣȫ��ɾ��?", "ɾ����Ϣ", JOptionPane.OK_CANCEL_OPTION);
			if(reaAll == JOptionPane.OK_OPTION) {
				name = FTF2.MyName.getText();
				if(f.deleteTree(name)) {
					 JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
				}
				else {
					 JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
				}
			}
		}
		if(e.getSource()==reseButton) {
			FTF2.MyName.setText("");
			FTF2.Agebre.setText("");
			FTF2.FName.setText("");
			FTF2.MName.setText("");
		}
		if(e.getSource()==FTF2.addMember) {//��ӳ�Ա��ť
			AddMember addFrame = new AddMember();
		}
		if(e.getSource()==	FTF2.modifyMember) {//�޸ĳ�Ա��ť
			ModifyMember modifyMemberFrame = new ModifyMember();
		}
		if(e.getSource()==FTF2.searchMember) {//��ѯ��Ա��ť
			searchMember seacherMemberFrame = new searchMember();
		}
		if(e.getSource()==FTF2.showFamilyTree) {//ͼ�δ�ӡ���װ�ť
			
		}
		if(e.getSource()==FTF2.showFamilyTable) {//�����ʾ���װ�ť
			showFamilyTable showtableFrame = new showFamilyTable();
		}
	}
	
	public void itemStateChanged(ItemEvent e) {
		Checkbox JBtemp;
		if(e.getItemSelectable() instanceof Checkbox) {
			JBtemp = (Checkbox)(e.getItemSelectable());
			if(JBtemp.getLabel() == "��") {
				
			}
			if(JBtemp.getLabel() == "Ů") {
				
			}
		}
	}
}
