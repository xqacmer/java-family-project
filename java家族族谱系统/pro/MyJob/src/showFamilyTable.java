import java.awt.event.ItemEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/*************************ͼ����ʾ���г�Ա����********************************/
public class showFamilyTable implements ActionListener {
	JSplitPane sp;
	JButton show;
	FTFrame FTF3 = new FTFrame("��ͥ��Ա��Ϣ��");
	Border b1 = BorderFactory.createEtchedBorder(Color.cyan,
            Color.blue);
	TitledBorder AllMessage = BorderFactory.createTitledBorder(b1, "��ͥ��Ա��");
	Family f;
	showFamilyTable() {
		/************������*************/
		f = new Family();
	    f.initRoot();
	    f.CreateFamilyTree(Family.root);
		/***********��Ӽ�����***************/
		FTF3.addMember.addActionListener(this);
		FTF3.deleteMember.addActionListener(this); 
		FTF3.modifyMember.addActionListener(this); 
		FTF3.searchMember.addActionListener(this); 
		FTF3.showFamilyTable.addActionListener(this); 
		
		FTF3.jp1 = new JPanel();
		FTF3.jp2 = new JPanel();
		show = new JButton("��ʾ");
		show.addActionListener(this);
		
		/********��Ӱ�ť*******/
		FTF3.jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		FTF3.jp1.add(FTF3.function);
		FTF3.jp1.add(FTF3.addMember);
		FTF3.jp1.add(FTF3.deleteMember);
		FTF3.jp1.add(FTF3.modifyMember);
		FTF3.jp1.add(FTF3.searchMember);
		FTF3.jp1.add(FTF3.showFamilyTree);
		FTF3.jp1.add(show);
		
		/*************��ӱ��*************/
		FTF3.jp2.setLayout(null);
		FTF3.jp2.setBorder(AllMessage);
		FTF3.sp.setBounds(20,20,460,280);
		FTF3.jp2.add(FTF3.sp);
		//FTF3.initrowData();
		
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,FTF3.jp1,FTF3.jp2);
		sp.setBounds(0,0,500,400);
		FTF3.add(sp);
		FTF3.setLocation(240, 240);
		FTF3.setSize(500, 400);
		FTF3.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==FTF3.addMember) {//��ӳ�Ա�¼���Ӧ
			AddMember addFrame = new AddMember();
		}
		if(e.getSource()==FTF3.deleteMember) {//ɾ����Ա�¼���Ӧ
			deleteMember deleteFrame = new deleteMember();
		}
		if(e.getSource()==FTF3.modifyMember) {//�޸ĳ�Ա�¼���Ӧ
			ModifyMember modifyMemberFrame = new ModifyMember();
		}
		if(e.getSource()==FTF3.searchMember) {//��ѯ��Ա�¼���Ӧ
			searchMember seacherMemberFrame = new searchMember();
		}
		if(e.getSource()==FTF3.showFamilyTable) {//ͼ����ʾͼ���¼���Ӧ
			
		}
		if(e.getSource()==show) {
			FTF3.initrowData(Family.root);
			FTF3.init();
		}
	}
	
}
