import java.awt.event.ItemEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/*****************��ʾ���е�n���˵���Ϣ********************/
public class ShowNMessage implements ActionListener {
	JPanel jp1;
	JPanel jp2;
	JButton search;//��ѯ
	int agebre;//����
	
	JSplitPane sp;
	
	FTFrame FTF6 = new FTFrame("��ʾ��n����Ϣ");
	Border b1 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder AllMessage = BorderFactory.createTitledBorder(b1, "��Ա��");
	Family f;
	ShowNMessage() {
		/************������*************/
		f = new Family();
	    f.initRoot();
	    f.CreateFamilyTree(Family.root);
	    //f.showFamilyTree(Family.root);
	    
		/***********��Ӽ�����***************/
		FTF6.addMember.addActionListener(this);
		FTF6.deleteMember.addActionListener(this); 
		FTF6.modifyMember.addActionListener(this); 
		FTF6.searchMember.addActionListener(this); 
		FTF6.showFamilyTable.addActionListener(this); 
		FTF6.showFamilyTree.addActionListener(this); 
		
		FTF6.jp1 = new JPanel();
		FTF6.jp2 = new JPanel();
		
		/********��Ӱ�ť*******/
		FTF6.jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		FTF6.jp1.add(FTF6.function);
		FTF6.jp1.add(FTF6.addMember);
		FTF6.jp1.add(FTF6.deleteMember);
		FTF6.jp1.add(FTF6.modifyMember);
		FTF6.jp1.add(FTF6.searchMember);
		FTF6.jp1.add(FTF6.showFamilyTable);
		FTF6.jp1.add(FTF6.showFamilyTree);
		
		FTF6.jp2.setLayout(null);
		jp1 = new JPanel();
		jp1.setBounds(20,20,400,30);
		jp1.setLayout(null);
		FTF6.agebre.setBounds(0,0,80,20);
		jp1.add(FTF6.agebre);
		FTF6.Agebre.setBounds(60,0,100,20);
		jp1.add(FTF6.Agebre);
		search = new JButton("��ѯ");
		search.setBounds(170,0,60,20);
		jp1.add(search);
		search.addActionListener(this);
		/*************��ӱ��*************/
		jp2 = new JPanel();
		jp2.setBounds(20,60,450,250);
		jp2.setLayout(null);
		jp2.setBorder(AllMessage);
		FTF6.sp.setBounds(40,20,380,220);
		jp2.add(FTF6.sp);
	
		FTF6.jp2.setBorder(AllMessage);
		FTF6.jp2.add(jp1);
		FTF6.jp2.add(jp2);
	
		
		
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,FTF6.jp1,FTF6.jp2);
		sp.setBounds(0,0,450,380);
		FTF6.add(sp);
		FTF6.setLocation(240, 240);
		FTF6.setSize(500, 400);
		FTF6.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==FTF6.addMember) {//��ӳ�Ա�¼���Ӧ
			AddMember addFrame = new AddMember();
		}
		if(e.getSource()==FTF6.deleteMember) {//ɾ����Ա�¼���Ӧ
			deleteMember deleteFrame = new deleteMember();
		}
		if(e.getSource()==FTF6.searchMember) {//��ѯ��Ա�¼���Ӧ
			searchMember seacherMemberFrame = new searchMember();
		}
		if(e.getSource()==	FTF6.modifyMember) {//�޸ĳ�Ա��ť
			ModifyMember modifyMemberFrame = new ModifyMember();
		}
		if(e.getSource()==FTF6.showFamilyTable) {//ͼ����ʾͼ���¼���Ӧ
			showFamilyTable showtableFrame = new showFamilyTable();
		}
		if(e.getSource()==FTF6.showFamilyTree) {
			
		}
		if(e.getSource()==search) {//���ҵ�n����Ա��Ϣ
			agebre = Integer.parseInt(FTF6.Agebre.getText());
			f.inquire_N(f.root,agebre);
			FTF6.initrowDataT(f.n_People);
			FTF6.init();
			
		}
	}
	
}

