import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/************************ ������ *************************/
public class FTFrame extends JFrame implements ActionListener {
	JMenuBar menuManagerBar; // �˵���
	JMenu menuFile, menuEdit, menuHelp, Show_Family, Select_Member; // ���˵�
	JMenuItem File_Open, File_Save, Exit; // �ļ��˵��е��Ӳ˵�
	JMenuItem Add_Member, Delete_Member, Modify_Member;// �༭�˵����Ӳ˵�
	JMenuItem Show_Law;// �����˵��µ��Ӳ˵�
	JMenuItem Show_NTable, Show_Tree;// ��ʾ��Ϣ���Ӳ˵�
	JMenuItem Show_All, Select_Brithday, Select_Relationship;// ��ѯ�µ��Ӳ˵�
	Family f = new Family();

	/******************* ���캯�� **************************/
	FTFrame() {
		createMenu();
		setTitle("���׹���ϵͳ");
		setLayout(new BorderLayout());
		setLocation(200, 200);
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	FTFrame(String s) {
		setTitle(s);
		setResizable(false);
	}

	/************************ ����˵����� ****************************/
	void createMenu() {
		menuManagerBar = new JMenuBar();
		menuFile = new JMenu("�ļ�");
		menuEdit = new JMenu("�༭");
		menuHelp = new JMenu("����");
		File_Open = new JMenuItem("�������ݿ�");
		File_Save = new JMenuItem("����");
		Exit = new JMenuItem("�˳�");
		Show_Family = new JMenu("��ʾ����");
		Add_Member = new JMenuItem("��ӳ�Ա");
		Select_Member = new JMenu("��ѯ");
		Delete_Member = new JMenuItem("ɾ��");
		Modify_Member = new JMenuItem("�޸�");
		Show_Law = new JMenuItem("ʹ�ù���");
		Show_Tree = new JMenuItem("ͼ����ʾ");
		Show_NTable = new JMenuItem("��ʾ��n������Ϣ");
		Show_All = new JMenuItem("�����ʾ������Ϣ");
		Select_Brithday = new JMenuItem("������ͬ��Ա");
		Select_Relationship = new JMenuItem("��ϵ��ѯ");

		/*********** ��ʼ�����ļ��˵� *******************/
		menuFile.add(File_Open);
		menuFile.add(File_Save);
		menuFile.addSeparator();// ��һ��������
		menuFile.add(Exit);

		/************ ��ʼ�����༭�˵� ******************/
		Show_Family.add(Show_Tree);
		Show_Family.addSeparator();
		Show_Family.add(Show_NTable);
		Select_Member.add(Show_All);
		Select_Member.addSeparator();
		Select_Member.add(Select_Brithday);
		Select_Member.addSeparator();
		Select_Member.add(Select_Relationship);
		menuEdit.add(Show_Family);
		menuEdit.addSeparator();
		menuEdit.add(Add_Member);
		menuEdit.addSeparator();
		menuEdit.add(Select_Member);
		menuEdit.addSeparator();
		menuEdit.add(Delete_Member);
		menuEdit.add(Modify_Member);

		/**************** �����˵����� ******************/
		menuHelp.add(Show_Law);

		/****************** ���˵��Ĺ��� ******************/
		menuManagerBar.add(menuFile);
		menuManagerBar.add(menuEdit);
		menuManagerBar.add(menuHelp);
		setJMenuBar(menuManagerBar);

		/***************** ����¼������� ********************/
		File_Open.addActionListener(this);
		File_Save.addActionListener(this);
		Exit.addActionListener(this);
		Add_Member.addActionListener(this);
		Delete_Member.addActionListener(this);
		Modify_Member.addActionListener(this);
		Show_Law.addActionListener(this);
		Show_Tree.addActionListener(this);
		Show_NTable.addActionListener(this);
		Show_All.addActionListener(this);
		Select_Brithday.addActionListener(this);
		Select_Relationship.addActionListener(this);
	}
	
	/*********************�������************************/
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JPanel jp4;
	JLabel line1;
	JLabel line2;
	JLabel line3;
	JLabel line4;
	JLabel line5;
	JLabel picture;
	JLabel function = new JLabel("���ܿ�ݼ�:");
	JLabel MemberBrithday = new JLabel("�������ڣ�");
	JLabel MemberSex = new JLabel("�Ա�:");
	JLabel MemberName = new JLabel("������");
	JLabel Age = new JLabel("����:");
	JLabel FatherName = new JLabel("����������"); 
	JLabel MotherName = new JLabel("ĸ��������");
	JLabel agebre = new JLabel("������");
	JLabel childSum = new JLabel("��������");
	JLabel spousename = new JLabel("��ż������");
	JLabel isAlive = new JLabel("�Ƿ��ڣ�");
	
	JTextField MyName = new JTextField();
	JTextField FName = new JTextField();
	JTextField MName = new JTextField();
	JTextField spouseName = new JTextField();
	JTextField age = new JTextField();
	JTextField child_Sum = new JTextField();
	JTextField Agebre = new JTextField();
	JTextArea law = new JTextArea(5,15);
	
	/******** ��ѡ�� ********/
	/******** ��ѡ�� ********/
	CheckboxGroup bg = new CheckboxGroup();
	Checkbox men = new Checkbox("��",true,bg);
	Checkbox women = new Checkbox("Ů",false,bg);
	/******** �����б� *******/
	Object[] year = new Object[] { "2012", "2011", "2010", "2009", "2008",
			"2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
			"1999", "1998", "1997", "1996", "1995" };
	Object[] month = new Object[] { "12", "11", "10", "9", "8", "7", "6", "5",
			"4", "3", "2", "1" };
	Object[] day = new Object[] { "31", "30", "29", "28", "27", "26", "25",
			"24", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14",
			"13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1" };
	Object[] Y_N = new Object[]{"��","��"};
	JComboBox y_n = new JComboBox(Y_N);
	JComboBox Byear = new JComboBox(year);
	JComboBox Bmonth = new JComboBox(month);
	JComboBox Bday = new JComboBox(day);
	
	/***********Сͼ��**************/
	ImageIcon add = new ImageIcon("add.jpg");
	ImageIcon delete = new ImageIcon("delete.jpg");
	ImageIcon modify = new ImageIcon("modify.jpg");
	ImageIcon search = new ImageIcon("search.jpg");
	ImageIcon showtree = new ImageIcon("showtree.jpg");
	ImageIcon showtable = new ImageIcon("showtable.jpg");
	ImageIcon face = new ImageIcon("face.jpg");
	
	/***********��ͼ��İ�ť***************/
	JButton addMember = new JButton(add); 
	JButton deleteMember = new JButton(delete);
	JButton modifyMember = new JButton(modify);
	JButton searchMember = new JButton(search);
	JButton showFamilyTree = new JButton(showtree);
	JButton showFamilyTable = new JButton(showtable);
	/***********���*************/
	/***********���*************/
	Border border = BorderFactory.createEtchedBorder(Color.green,
            Color.blue);
	TitledBorder title = BorderFactory.createTitledBorder(border, "���չ�����", TitledBorder.LEFT, TitledBorder.TOP);
	
	/********����һ����ż�ͥ��Ա��Ϣ�Ķ�ά���鼰һ�������趨���ı�ͷ************/
	Object[][] rowData = new Object[100][7];
	Object[] rowdata = new Object[10];
	Object[] columnNames = new Object[]{"����","�Ա�","��������","�Ƿ���","��ż����","����","������"};
	int rowCount;
	Rectangle rect;
	
	JTable tab = new JTable(rowData,columnNames);//����һ��JTable���
	JScrollPane sp = new JScrollPane(tab);//����һ���������
	
	JTextArea showBrithday;
	int i = 0;
	String BrithdayMessage;
	public void Layout() {
		jp1 = new JPanel();
		this.add(jp1,BorderLayout.NORTH);
		jp2 = new JPanel();
		this.add(jp2,BorderLayout.CENTER);
		jp2.setLayout(new GridLayout(1,2));
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp2.add(jp3);
		jp2.add(jp4);
		
		line1 = new JLabel("|");
		line2 = new JLabel("|");
		line3 = new JLabel("|");
		line4 = new JLabel("|");
		line5 = new JLabel("|");
		picture = new JLabel(face);
		picture.setSize(400,500);
		
		showBrithday = new JTextArea(32,60);
		f.initRoot();
		f.CreateFamilyTree(Family.root);
		jp1.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp1.add(addMember);jp1.add(line1);
		jp1.add(deleteMember);jp1.add(line2);
		jp1.add(modifyMember);jp1.add(line3);
		jp1.add(searchMember);jp1.add(line4);
		jp1.add(showFamilyTree);jp1.add(line5);
		jp1.add(showFamilyTable);
		jp3.setBorder(title);jp3.add(showBrithday);
		jp4.add(picture);
		addMember.addActionListener(this); 
		deleteMember.addActionListener(this); 
		modifyMember.addActionListener(this); 
		searchMember.addActionListener(this); 
		showFamilyTree.addActionListener(this); 
		showFamilyTable.addActionListener(this); 
	}
	
	public void initrowData(Family root) {
		if(root!=null) {
			rowData[i][0] = root.in.name;
			rowData[i][1] = root.in.sex;
			rowData[i][2] = root.in.ymd;
			rowData[i][3] = root.in.isAlive;
			rowData[i][4] = root.in.spouseName;
			rowData[i][5] = root.in.levelTemp;
			rowData[i][6] = root.in.childNum;
			i++;
		}
		if(root.bro_sis != null)initrowData(root.bro_sis);
		if(root.spouse != null) initrowData(root.spouse);
		if(root.child != null)initrowData(root.child);
	}
	public void initrowDataT(ArrayList<Person> p) {
		if(p!=null) {
			for(int i=0;i<p.size();i++) {
				rowData[i][0] = p.get(i).name;
				rowData[i][1] = p.get(i).sex;
				rowData[i][2] = p.get(i).ymd;
				rowData[i][3] = p.get(i).isAlive;
				rowData[i][4] = p.get(i).spouseName;
				rowData[i][5] = p.get(i).levelTemp;
				rowData[i][6] = p.get(i).childNum;
			}
		}
	}
	
	public void init() {
		rowCount = tab.getRowCount();
		tab.getSelectionModel().setSelectionInterval(rowCount-1, rowCount-1);
		rect = tab.getCellRect(rowCount-70, 0, true);
		tab.scrollRectToVisible(rect);
	}
	
	public void initrowDataTH(ArrayList<Person> p) {
		if(p!=null) {
			for(int i=0;i<p.size();i++) {
				rowData[i][0] = p.get(i).name;
				rowData[i][1] = p.get(i).sex;
				rowData[i][2] = p.get(i).ymd;
				rowData[i][3] = p.get(i).isAlive;
				rowData[i][4] = p.get(i).spouseName;
				rowData[i][5] = p.get(i).levelTemp;
				rowData[i][6] = p.get(i).childNum;
			}
		}
	}
	
	public void initrowDataF(String name) {
		Family f1 = f.isAtTree(Family.root, name);
		if(f1!=null) {
			
			rowData[i][0] = f1.in.name;
			rowData[i][1] = f1.in.sex;
			rowData[i][2] = f1.in.ymd;
			rowData[i][3] = f1.in.isAlive;
			rowData[i][4] = f1.in.spouseName;
			rowData[i][5] = f1.in.levelTemp;
			rowData[i][6] = f1.in.childNum;
			
			i++;
		}
	}
	public void initrowDataFI(ArrayList<Person> p) {
		if(p!=null) {
			for(int i=0;i<p.size();i++) {
				rowdata[i] = p.get(i).name;
			}
		}
	}
	
	public void showBrithday() {
		Date d = new Date();
		DateFormat month = new SimpleDateFormat("MM");
		DateFormat day = new SimpleDateFormat("dd");
		f.birthday(Family.root, new Birthday(Integer.parseInt(month.format(d)),Integer.parseInt(day.format(d))));
		this.initrowDataFI(f.birthday);
		if(rowdata.length != -1) {
			this.showBrithday.setText("������" + month.format(d)+ "-" +  day.format(d) + "��" + '\n' 
										+"����" + rowdata[i] +"������" + '\n');
			i++;
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Add_Member || e.getSource()==addMember) {// ��ӳ�Ա�¼�
			AddMember addFrame = new AddMember();
			
		}
		if(e.getSource()==deleteMember || e.getSource()==Delete_Member) {//ɾ����Ա�¼�
			deleteMember deleteFrame = new deleteMember();
		}
		if(e.getSource()==showFamilyTable || e.getSource()==Show_All) {
			showFamilyTable showtableFrame = new showFamilyTable();
		}
		if(e.getSource()==searchMember || e.getSource()==Select_Brithday || e.getSource()==Select_Relationship) {
			searchMember seacherMemberFrame = new searchMember();
		}
		if(e.getSource()==modifyMember  || e.getSource()==Modify_Member) {//�޸ĳ�Ա�¼�
			ModifyMember modifyMemberFrame = new ModifyMember();
		}
		if(e.getSource()==Show_NTable) {//��ʾ��n���˵���Ϣ
			ShowNMessage showFrame = new ShowNMessage();
		}
		if(e.getSource()==File_Open) {
			int reaAll = JOptionPane.showConfirmDialog(this, "�Ƿ��������ݿ�?", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
			if(reaAll == JOptionPane.OK_OPTION) {
				GetDataBase getDB = new GetDataBase();
				getDB.setVisible(true);
			}
		}
		if(e.getSource()==showFamilyTree || e.getSource()==Show_Tree) {
			CFrame cf = new CFrame(f.root);
			
		}
		if(e.getSource()==Exit) {
			System.exit(0);
		}
	}

	
}

