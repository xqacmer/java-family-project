import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
public class familyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Member m = new Member();
		for(int i=0;i<m.memberNum;i++)
			System.out.println(m.member[i]);*/
		System.out.println();
		Family f = new Family();
		f.initRoot();
		f.CreateFamilyTree(Family.root);
		//Birthday a = new Birthday(8888,6,11);
		//Family t = f.isAtTree(Family.root, "贾演");
		//System.out.println(t.parents.in);
		//f.birthday(Family.root,a);
		//System.out.println(f.birthday);
		//f.showFamilyTree(Family.root);
		//System.out.println(t.in);
		//System.out.println(f.deleteTree("贾演"));
		//System.out.println(t.parents.in);
		Birthday d1,d2;
		d1 = new Birthday(2,1);
		d2 = new Birthday(3,3);
		Person p1,p2;
		p1=new Person("林四",20,"男",d1,"林如海");
		p2=new Person("张三",25,d2,"林黛玉");
		//System.out.println(f.addMember(p1));
		//System.out.println(f.addMember(p2));
		//System.out.println(f.num);
		//f.showFamilyTree(Family.root);
		//System.out.println(f.modification("王夫", "假贷", 20, d1, true));
		//f.showFamilyTree(Family.root);
		CFrame c=new CFrame(Family.root);
		//f.connectionDB_MySQL("cjtc");
	}
}

class Birthday {
	int year;
	int month;
	int day;
	Birthday() {
		
	}
	
	Birthday(int m,int d) {
		year = 8888;
		month = m;
		day = d;
	}
	
	Birthday(int y,int m,int d) {
		year = y;
		month = m;
		day = d;
	}
	
	public String toString() {
		return month +"-" + day;
	}
}

class Person {
	String name;//姓名
	int age;//年龄
	String sex;//性别
	Birthday ymd;//出生日期
	String fatherName;
	String motherName;
	String spouseName;
	int childNum;
	int levelTemp; //代数
	Boolean isAlive;
	ArrayList<String> brothers_sisters;
	ArrayList<String> children;
	
	Person() {
		name = null;
		age = 0;
		sex = null;
		ymd = null;
		levelTemp = 0;
		fatherName = "无";
		motherName = "无";
		spouseName = null;
		childNum = 0;
		isAlive = true;
		brothers_sisters=null;
		children=null;
	}
	
	Person(String name,int age,String sex,Birthday ymd,String fatherName) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.ymd=ymd;
		this.isAlive=true;
		this.fatherName=fatherName;
	}
	
	Person(String name,int age,Birthday ymd,String spouseName) {
		this.name=name;
		this.age=age;
		this.ymd=ymd;
		this.isAlive=true;
		this.spouseName=spouseName;
	}
	
	Person(String name,int age,String sex,Birthday ymd,String fatherName,String motherName,String spouseName,int childNum,int levelTemp,Boolean isAlive,ArrayList<String> brothers_sisters,ArrayList<String> children) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.ymd = ymd;
		this.levelTemp = levelTemp;
		if(!fatherName.equals("无"))
			this.fatherName = fatherName;
		else this.fatherName = null;
		if(!motherName.equals("无"))
			this.motherName = motherName;
		else this.motherName = null;
		if(!spouseName.equals("无"))	
			this.spouseName = spouseName;
		else this.spouseName = null;
		this.childNum = childNum;
		this.isAlive = isAlive;
		this.brothers_sisters = brothers_sisters;
		this.children = children;
	}
	
	
	public String toString() {
		return "姓名：" + this.name + ",年龄:" + this.age + ",性别:" + this.sex + ",出生日期 :" + this.ymd + ",父亲:" + this.fatherName + ",母亲:" + this.motherName + ",配偶:" + this.spouseName + ",子女个数:" + this.childNum + ",是第  " + this.levelTemp + "  代人" + ",是否健在:" + this.isAlive + ",兄弟姐妹:" + this.brothers_sisters + ",孩子:" + this.children;
	} 
}

class Member {
	Person[] member;

	int memberNum = 0;
	public final int MaxSize =  100;
	Member() {
		member = new Person[MaxSize];
		String s = "家谱管理系统成员.txt";
		String line;
		try {
			BufferedReader in = new BufferedReader( new FileReader(s));
			line = in.readLine();
			while(line != null) {
				String[] t;
				String[] time;
				String[] bsNum;
				String[] cNum;
				ArrayList<String> bro_sis = new ArrayList<String>();
				ArrayList<String> child = new ArrayList<String>();
				Boolean bl;
				t = line.split(",");
				time = t[3].split("-");
				Birthday b = new Birthday(8888,Integer.parseInt(time[0]),Integer.parseInt(time[1]));
				if(t[9] == "FALSE") bl = false;
				else bl = true;
				bsNum = t[10].split(";");
				cNum = t[11].split(";");
				if(bsNum[0].equals("无"))
					bro_sis = null;
				else {
					for(int i=0;i<bsNum.length;i++)
						bro_sis.add(bsNum[i]);
				}
				if(cNum[0].equals("无"))
					child = null;
				else {
					for(int i=0;i<cNum.length;i++)
						child.add(cNum[i]);
				}
				member[memberNum] = new Person(t[0],Integer.parseInt(t[1]),t[2],b,t[4],t[5],t[6],Integer.parseInt(t[7]),Integer.parseInt(t[8]),bl,bro_sis,child);
				memberNum ++;
				line = in.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

class XY {
	int x,y;
	XY() {
		
	}
	XY(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

class Family {
	static int num = 0;
	Person in;  //数据域
	Family  parents; //指向父亲的引用
	Family  spouse;//指向配偶的引用
	Family  child;//指向孩子的引用
	Family  bro_sis;
	Member mem = new Member();
	ArrayList<Person> birthday = new ArrayList<Person>();
	ArrayList<Person> n_People = new ArrayList<Person>();
	XY location;//坐标
	String dbUL="jdbc:mysql://localhost/dbgoods";
	String dbNewUL = "jdbc:mysql://localhost/";
	String userName = "root";
	String userPwd;
	Connection dbConn;
	Connection newConn;
	Statement stmt;
	ResultSet rs;
	static Family root = new Family();
	
	void initRoot() {
		root.in.age = 9999;
		root.in.name = "祖先";
		root.in.fatherName = null;
		root.in.spouseName = null;
		root.in.sex = "男";
		root.in.children = new ArrayList<String>();
		root.in.children.add("黄老");
		root.in.children.add("贾演");
		root.in.childNum = root.in.children.size();
		root.in.ymd = new Birthday(888,888,888);
		root.in.isAlive=false;
		root.location= new XY();
	}
	
	Family() {
		in = new Person();
		parents = null;
		spouse = null;
		child = null;
		bro_sis = null;
		this.location=new XY();
	}
	
	Family(Person p) {
		in = p;
		parents = null;
		spouse = null;
		child = null;
		bro_sis = null;
		this.location=new XY();
	}
	
	public void CreateFamilyTree(Family root) {                     //创建家族树
		if(root != null) {
			Family parents,spouse,child,bro_sis;
			//找root双亲节点
			if(root.in.fatherName != null || root.in.motherName != null) {
				parents= this.isAtTree(this.root, root.in.fatherName);       //找root的双亲节点是否已经存在于家族树中
				if(parents != null) {
					root.parents = parents;
				}
				else {
					parents = this.isAtTree(this.root, root.in.motherName);
					if(parents != null) {
						root.parents = parents;
					}
				}
			}	
			
			//找root的兄弟姐妹节点
			if(root.in.brothers_sisters != null) {	
				for(int i=0;i<root.in.brothers_sisters.size();i++) {
					bro_sis = this.isAtTree(this.root,root.in.brothers_sisters.get(i));	
					if(bro_sis == null) {
						Person p_bs = this.inqureMember(root.in.brothers_sisters.get(i));			
						bro_sis = new Family(p_bs);
						Family t = root;
						while(t.bro_sis != null) {
							t = t.bro_sis; 
						}
						t.bro_sis = bro_sis;
						num++;
					}
				}
			}
			
			//找root的配偶节点
			if(root.in.spouseName != null) {	
				spouse = this.isAtTree(this.root, root.in.spouseName);            //找root的配偶节点是否已经存在于家族树中					
				if(spouse == null) {
						Person p_spouse;
						p_spouse = this.inqureMember(root.in.spouseName);		
						if(p_spouse != null) {
							spouse = new Family(p_spouse);
							root.spouse = spouse;
							num++;
						}
					}
				}
			
			if(root.in.children != null) {
				child = this.isAtTree(this.root,root.in.children.get(0));				
				if(child == null) {
					Person p_child = this.inqureMember(root.in.children.get(0));
					if(p_child != null) {	
						child = new Family(p_child);
						root.child = child;				
						num++;
					}
				}
			}
			if(root.bro_sis != null)
				CreateFamilyTree(root.bro_sis);
			if(root.spouse != null)
				CreateFamilyTree(root.spouse);
			if(root.child != null)
				CreateFamilyTree(root.child);
		}
	}

	public Family isAtTree(Family r,String name) {         //判断节点是否在家族树中
			if(r.in.name != null) {
				if(r.in.name.equals(name)) {
					return r;
				}
				else {
					if(r.bro_sis != null) {
						Family p = isAtTree(r.bro_sis,name); //从兄弟姐妹节点找
						if(p != null) return p;
					}
					if(r.spouse != null) {
						Family p = isAtTree(r.spouse,name);  //从配偶节点找
						if(p != null) return p;
					}
					if(r.child != null) {
						Family p = isAtTree(r.child,name);  //从孩子节点找
						if(p != null) return p;
					}
				}
			}
			return null;
	}
	
	
	public Person inqureMember(String name) {           //根据姓名查找家族成员
		for(int i=0;i<mem.memberNum;i++) 
			if(mem.member[i].name.equals(name))
				return mem.member[i];
		 return null;
	}
	
	
	public void showFamilyTree(Family r) {              //显示家族所有成员
		if(r != null) {
			System.out.println(r.in);
			if(r.bro_sis != null)
				showFamilyTree(r.bro_sis);
			if(r.spouse != null)
				showFamilyTree(r.spouse);
			if(r.child != null)
				showFamilyTree(r.child);
		}
	}
	
	public void birthday(Family r,Birthday a) {              //查找过生日的人
		if(r != null) {
			if(r.in.ymd.month == a.month && r.in.ymd.day == a.day) this.birthday.add(r.in);
			if(r.bro_sis != null) birthday(r.bro_sis,a);
			if(r.spouse != null) birthday(r.spouse,a);
			if(r.child != null) birthday(r.child,a);
		}
	}
	
	public String relationship(String name1,String name2) {               //判断两人的关系
		if(name1 != null && name2 != null && !name1.equals("") && !name2.equals("")) {
			Family f1,f2;
			f1 = this.isAtTree(this.root,name1);
			f2 = this.isAtTree(this.root,name2);
			if(f1 != null && f2 != null) {
				if(f1.parents != null && f2.parents !=null &&f1.parents == f2.parents) {
					if(f1 == f2)
						return "输入的两人是同一个人！";
					if(f1.in.age > f2.in.age) {
						if(f1.in.sex.equals("男") && f2.in.sex.equals("女"))
							return f1.in.name + "与" + f2.in.name + "为兄妹关系" + "，且" + f1.in.name + "为兄，" +f2.in.name + "为妹。";
						if(f1.in.sex.equals("男") && f2.in.sex.equals("男"))
							return f1.in.name + "与" + f2.in.name + "为兄弟关系" + "，且" + f1.in.name + "为兄，" +f2.in.name + "为弟。";
						if(f1.in.sex.equals("女") && f2.in.sex.equals("男"))
							return f1.in.name + "与" + f2.in.name + "为姐弟关系" + "，且" + f1.in.name + "为姐，" +f2.in.name + "为弟。";
						if(f1.in.sex.equals("女") && f2.in.sex.equals("女"))
							return f1.in.name + "与" + f2.in.name + "为姐妹关系" + "，且" + f1.in.name + "为姐，" +f2.in.name + "为妹。";
					}
					else {
						if(f1.in.sex.equals("男") && f2.in.sex.equals("女"))
							return f1.in.name + "与" + f2.in.name + "为姐弟关系" + "，且" + f1.in.name + "为弟，" +f2.in.name + "为姐。";
						if(f1.in.sex.equals("男") && f2.in.sex.equals("男"))
							return f1.in.name + "与" + f2.in.name + "为兄弟关系" + "，且" + f1.in.name + "为弟，" +f2.in.name + "为兄。";
						if(f1.in.sex.equals("女") && f2.in.sex.equals("男"))
							return f1.in.name + "与" + f2.in.name + "为兄妹关系" + "，且" + f1.in.name + "为妹，" +f2.in.name + "为兄。";
						if(f1.in.sex.equals("女") && f2.in.sex.equals("女"))
							return f1.in.name + "与" + f2.in.name + "为姐妹关系" + "，且" + f1.in.name + "为妹，" +f2.in.name + "为姐。";
					}
				}
				else if(f1.in.sex.equals("男") && f2.in.sex.equals("男")) {
					if(f1.parents !=null && f1.parents == f2) 
						return f1.in.name + "与" + f2.in.name + "为父子关系" + "，且" + f1.in.name + "为儿子，" +f2.in.name + "为父亲。";
					if(f2.parents !=null && f2.parents == f1)
						return f1.in.name + "与" + f2.in.name + "为父子关系" + "，且" + f1.in.name + "为父亲，" +f2.in.name + "为儿子。";
					if(f1.parents!=null && f1.parents.bro_sis == f2) {
						if(f1.parents.in.age >f2.in.age) return f1.in.name + "为侄子，" +f2.in.name + "为叔父。";
						else return f1.in.name + "为侄子，" +f2.in.name + "为伯父。";
					}
					if(f2.parents!=null && f2.parents.bro_sis == f1) {
						if(f2.parents.in.age >f1.in.age) return f1.in.name + "为叔父，" +f2.in.name + "为侄子。";
						else return f1.in.name + "为伯父，" +f2.in.name + "为侄子。";
					}
					if(f1.parents !=null && f1.parents.parents != null && f1.parents.parents == f2)
						return f1.in.name + "与" + f2.in.name + "为爷孙关系" + "，且" + f1.in.name + "为孙子，" +f2.in.name + "为爷爷。";
					if(f2.parents !=null && f2.parents.parents !=null && f2.parents.parents == f1)
						return f1.in.name + "与" + f2.in.name + "为爷孙关系" + "，且" + f1.in.name + "为爷爷，" +f2.in.name + "为孙子。";
					return "无法考证！";
				}
				else if(f1.in.sex.equals("男") && f2.in.sex.equals("女")) {
					if(f1.parents !=null && f1.parents.spouse == f2) 
						return f1.in.name + "与" + f2.in.name + "为母子关系" + "，且" + f1.in.name + "为儿子，" +f2.in.name + "为母亲。";
					if(f2.parents !=null && f2.parents == f1)
						return f1.in.name + "与" + f2.in.name + "为父女关系" + "，且" + f1.in.name + "为父亲，" +f2.in.name + "为女儿。";
					if(f1.in!=null && f1.in.spouseName!=null&&f1.in.spouseName.equals(f2.in.name)) 
						return f1.in.name + "与" + f2.in.name + "为夫妻关系" + "，且" + f1.in.name + "为丈夫，" +f2.in.name + "为妻子。";
					if(f1.parents!=null && f1.parents.bro_sis!=null && f1.parents.bro_sis.spouse == f2) {
						if(f1.parents.in.age>f1.parents.bro_sis.in.age)
							return f1.in.name + "为侄子，" +f2.in.name + "为婶婶。";
						else return f1.in.name + "为侄子，" +f2.in.name + "为伯母。";
					}
					if(f2.parents!=null && f2.parents.spouse == null) {
						Family f_mother = this.isAtTree(this.root, f2.in.motherName);
						if(f_mother != null&&f_mother.in.brothers_sisters!=null) {
							for(int i=0;i<f_mother.in.brothers_sisters.size();i++) {
								Family f_m_bs = this.isAtTree(this.root, f_mother.in.brothers_sisters.get(i));
								if(f_m_bs!=null) {
									if(f_m_bs.in.sex.equals("男") && f_m_bs==f1) 
										return f1.in.name + "为舅舅，" +f2.in.name + "为外甥女。";
								}
							}
						}
					}
					if(f1.parents != null && f1.parents.parents != null && f1.parents.parents.spouse == f2)
						return f1.in.name + "为孙子，" +f2.in.name + "为奶奶。";
					if(f2.parents != null && f2.parents.parents == f1) 
						return f1.in.name + "为爷爷，" +f2.in.name + "为孙女。";
					if(f2.parents!=null && f2.parents.spouse == null) {
						Family f_mother = this.isAtTree(this.root, f2.in.motherName);
						if(f_mother!=null&&f_mother.parents == f1)
							return f1.in.name + "为外公，" +f2.in.name + "为外孙女。";
					}
					return "无法考证！";
				}
				else if(f1.in.sex.equals("女") && f2.in.sex.equals("男")) {
					if(f1.parents !=null && f1.parents == f2)
						return f1.in.name + "与" + f2.in.name + "为父女关系" + "，且" + f1.in.name + "为女儿，" +f2.in.name + "为父亲。";
					if(f2.parents != null && f2.parents.spouse == f1)
						return f1.in.name + "与" + f2.in.name + "为母子关系" + "，且" + f1.in.name + "为母亲，" +f2.in.name + "为儿子。";
					if(f1.in.spouseName != null&&f1.in.spouseName.equals(f2.in.name))
						return f1.in.name + "与" + f2.in.name + "为夫妻关系" + "，且" + f1.in.name + "为妻子，" +f2.in.name + "为丈夫。";
					if(f2.parents!=null && f2.parents.bro_sis!=null && f2.parents.bro_sis.spouse == f1) {
						if(f2.parents.in.age>f2.parents.bro_sis.in.age)
							return f1.in.name + "为婶婶，" +f2.in.name + "为侄子。";
						else return f1.in.name + "为伯母，" +f2.in.name + "为侄子。";
					}
					if(f1.parents!=null && f1.parents.spouse == null) {
						Family f_mother = this.isAtTree(this.root, f1.in.motherName);
						if(f_mother != null&&f_mother.in.brothers_sisters!=null) {
							for(int i=0;i<f_mother.in.brothers_sisters.size();i++) {
								Family f_m_bs = this.isAtTree(this.root, f_mother.in.brothers_sisters.get(i));
								if(f_m_bs!=null) {
									if(f_m_bs.in.sex.equals("男") && f_m_bs==f2) 
										return f1.in.name + "为外甥女，" +f2.in.name + "为舅舅。";
								}
							}
						}
					}
					if(f1.parents != null && f1.parents.parents == f2) 
						return f1.in.name + "与" + f2.in.name + "为爷孙关系" + "，且" + f1.in.name + "为孙女，" +f2.in.name + "为爷爷。";
					if(f2.parents != null && f2.parents.parents != null && f2.parents.parents.spouse == f1)
						return f1.in.name + "为奶奶，" +f2.in.name + "为孙子。";
					if(f1.parents!=null && f1.parents.spouse == null) {
						Family f_mother = this.isAtTree(this.root, f1.in.motherName);
						if(f_mother!=null&&f_mother.parents == f2)
							return f1.in.name + "为外孙女，" +f2.in.name + "为外公。";
					}
					return "无法考证！";
				}
				else if(f1.in.sex.equals("女") && f2.in.sex.equals("女")) {
					if(f1.parents!= null && f1.parents.spouse == f2) 
						return f1.in.name + "与" + f2.in.name + "为母女关系" + "，且" + f1.in.name + "为女儿，" +f2.in.name + "为母亲。";
					if(f2.parents!=null && f2.parents.spouse == f1)
						return f1.in.name + "与" + f2.in.name + "为母女关系" + "，且" + f1.in.name + "为母亲，" +f2.in.name + "为女儿。";
					if(f1.in.motherName !=null&&f1.in.motherName.equals(f2.in.name ))
						return f1.in.name + "与" + f2.in.name + "为母女关系" + "，且" + f1.in.name + "为女儿，" +f2.in.name + "为母亲。";
					if(f2.in.motherName !=null&&f2.in.motherName.equals(f1.in.name ))
						return f1.in.name + "与" + f2.in.name + "为母女关系" + "，且" + f1.in.name + "为母亲，" +f2.in.name + "为女儿。";
					if(f1.parents!=null && f1.parents.spouse == null) {
						Family f_mother = this.isAtTree(this.root, f1.in.motherName);
						if(f_mother != null&&f_mother.in.brothers_sisters!=null) {
							for(int i=0;i<f_mother.in.brothers_sisters.size();i++) {
								Family f_m_bs = this.isAtTree(this.root, f_mother.in.brothers_sisters.get(i));
								if(f_m_bs!=null) {
									if(f_m_bs.in.sex.equals("女") && f_m_bs==f2) 
										return f1.in.name + "为外甥女，" +f2.in.name + "为姑姑。";
								}
							}
						}
					}
					if(f2.parents!=null && f2.parents.spouse == null) {
						Family f_mother = this.isAtTree(this.root, f2.in.motherName);
						if(f_mother != null&&f_mother.in.brothers_sisters!=null) {
							for(int i=0;i<f_mother.in.brothers_sisters.size();i++) {
								Family f_m_bs = this.isAtTree(this.root, f_mother.in.brothers_sisters.get(i));
								if(f_m_bs!=null) {
									if(f_m_bs.in.sex.equals("女") && f_m_bs==f1) 
										return f1.in.name + "为姑姑，" +f2.in.name + "为外甥女。";
								}
							}
						}
					}
					if(f1.parents!=null && f1.parents.parents!=null && f1.parents.parents.spouse == f2)
						return f1.in.name + "为孙女，" +f2.in.name + "为奶奶。";
					if(f2.parents!=null && f2.parents.parents!=null && f2.parents.parents.spouse == f1) 
						return f1.in.name + "为奶奶，" +f2.in.name + "为孙女。";
					if(f1.parents!=null && f1.parents.spouse == null) {
						Family f_mother = this.isAtTree(this.root, f1.in.motherName);
						if(f_mother!=null&&f_mother.parents != null && f_mother.parents.spouse == f2)
							return f1.in.name + "为外孙女，" +f2.in.name + "为外婆。";
					}
					if(f2.parents!=null && f2.parents.spouse == null) {
						Family f_mother = this.isAtTree(this.root, f2.in.motherName);
						if(f_mother!=null&&f_mother.parents != null && f_mother.parents.spouse == f1)
							return f1.in.name + "为外婆，" +f2.in.name + "为外孙女。";
					}
					return "无法考证！";
				}
			}
			else return "输入的名字不在家族中！";
		}
		return "传进来的参数有误！";
	}
	
	public int bianliNum(Family r) {
		int c=0;
		if(r!=null) {
			c++;
			if(r.bro_sis != null)
				 c=c+bianliNum(r.bro_sis);
			if(r.spouse != null)
				 c=c+bianliNum(r.spouse);
			if(r.child != null)
				 c=c+bianliNum(r.child);
		}
		return c;
	}
	
	public boolean deleteTree(String name) {            //根据姓名删除家族成员
		Family f = this.isAtTree(this.root, name);
		int number=0;
		if(f != null) {
			if(f.in.childNum != 0) {
				if(f.child == null) {
					Family t = this.isAtTree(this.root, f.in.spouseName);
					if(t!=null) {
						Family s=t.child;
						t.spouse = null;
						while(s!=null) {
							s.parents=null;
							s=s.bro_sis;
						}
						t.child=null;
						t.in.spouseName=null;
						t.in.children.clear();
						t.in.childNum=0;
						this.num = this.bianliNum(this.root)-1;
						return true;
					}
				}
				else {
					if(f.bro_sis != null) {
						if(f.parents.child == f) {
							Family t;
							t=f.parents.child.bro_sis;
							f.parents.child = f.bro_sis;
							if(f.parents.in.name=="祖先") {
								f.parents.in.childNum--;
								f.parents.in.children.remove(f.in.name);
							} 
							else {
								if(f.parents.spouse!=null) {
									f.parents.in.childNum--;
									f.parents.in.children.remove(f.in.name);
									f.parents.spouse.in.children.remove(f.in.name);
									f.parents.spouse.in.childNum--;
								}
								else {
									Family a=this.isAtTree(this.root,f.in.motherName );
									if(a!=null) {
										a.in.childNum--;
										a.in.children.remove(f.in.name);
										a.spouse.in.childNum--;
										a.spouse.in.children.remove(f.in.name);
									}
								}
							}
							f.parents = null;
							f.bro_sis = null;
							while(t!=null) {
								t.in.brothers_sisters.remove(f.in.name);
								t=t.bro_sis;
							}
							this.num = this.bianliNum(this.root)-1;
							return true;
						}
						else {
							Family t,s;
							t=f.parents.child;
							s=t;
							while(t.bro_sis != f) {
								t=t.bro_sis;
							}
							if(f.parents.spouse!=null) {
								f.parents.in.childNum--;
								f.parents.in.children.remove(f.in.name);
								f.parents.spouse.in.children.remove(f.in.name);
								f.parents.spouse.in.childNum--;
							}
							else {
								Family a=this.isAtTree(this.root,f.in.motherName );
								if(a!=null) {
									a.in.childNum--;
									a.in.children.remove(f.in.name);
									a.spouse.in.childNum--;
									a.spouse.in.children.remove(f.in.name);
								}
							}
							t.bro_sis=f.bro_sis;
							f.bro_sis=null;
							f.parents = null;
							while(s!=null) {
								s.in.brothers_sisters.remove(f.in.name);
								s=s.bro_sis;
							}
							this.num = this.bianliNum(this.root)-1;
							return true;
						}
					}
					else {
							Family s,t = f.parents.child;
							if(f.parents.child==f) {
								f.parents.child=null;
								if(f.parents.spouse!=null) {
									f.parents.in.childNum--;
									f.parents.in.children.remove(f.in.name);
									f.parents.spouse.in.children.remove(f.in.name);
									f.parents.spouse.in.childNum--;
								}
								else {
									Family a=this.isAtTree(this.root,f.in.motherName );
									if(a!=null) {
										a.in.childNum--;
										a.in.children.remove(f.in.name);
										a.spouse.in.childNum--;
										a.spouse.in.children.remove(f.in.name);
									}
								}
								f.parents=null;
								this.num = this.bianliNum(this.root)-1;
								return true;
							}
							else {
								s=t;
								while(t.bro_sis!=f) {
									t=t.bro_sis;
								}
								t.bro_sis=null;
								if(f.parents.in.name=="祖先") {
									f.parents.in.childNum--;
									f.parents.in.children.remove(f.in.name);
								} 
								else {
									if(f.parents.spouse!=null) {
										f.parents.in.childNum--;
										f.parents.in.children.remove(f.in.name);
										f.parents.spouse.in.children.remove(f.in.name);
										f.parents.spouse.in.childNum--;
									}
									else {
										Family a=this.isAtTree(this.root,f.in.motherName );
										if(a!=null) {
											a.in.childNum--;
											a.in.children.remove(f.in.name);
											a.spouse.in.childNum--;
											a.spouse.in.children.remove(f.in.name);
										}
									}
								}
								while(s!=null) {
									s.in.brothers_sisters.remove(f.in.name);
									s=s.bro_sis;
								}
								f.parents = null;
								this.num = this.bianliNum(this.root)-1;
								return true;
							}
					}
				}
			}
			else {
				if(f.in.spouseName!=null&&f.spouse==null) {
					Family t = this.isAtTree(this.root, f.in.spouseName);
					if(t!=null) {
						t.spouse = null;
						t.in.spouseName=null;
						this.num = this.bianliNum(this.root)-1;
						return true;
					}
				}
				else if(f.bro_sis!=null) {
					if(f.parents.child != f) {
						Family s,t = f.parents.child;
						s=t;
						while(t.bro_sis!=f) {
							t=t.bro_sis;
						}
						t.bro_sis=f.bro_sis;
						f.bro_sis=null;
						if(f.parents.spouse!=null) {
							f.parents.in.childNum--;
							f.parents.in.children.remove(f.in.name);
							f.parents.spouse.in.children.remove(f.in.name);
							f.parents.spouse.in.childNum--;
						}
						else {
							Family a=this.isAtTree(this.root,f.in.motherName );
							if(a!=null) {
								a.in.childNum--;
								a.in.children.remove(f.in.name);
								a.spouse.in.childNum--;
								a.spouse.in.children.remove(f.in.name);
							}
						}
						while(s!=null) {
							s.in.brothers_sisters.remove(f.in.name);
							s=s.bro_sis;
						}
						f.parents=null;
						this.num = this.bianliNum(this.root)-1;
						return true;
					}
					else {
						Family t;
						t=f.parents.child.bro_sis;
						f.parents.child = f.bro_sis;
						if(f.parents.spouse!=null) {
							f.parents.in.childNum--;
							f.parents.in.children.remove(f.in.name);
							f.parents.spouse.in.children.remove(f.in.name);
							f.parents.spouse.in.childNum--;
						}
						else {
							Family a=this.isAtTree(this.root,f.in.motherName);
							if(a!=null) {
								a.in.childNum--;
								a.in.children.remove(f.in.name);
								a.spouse.in.childNum--;
								a.spouse.in.children.remove(f.in.name);
							}
						}
						f.parents = null;
						f.bro_sis = null;
						while(t!=null) {
							t.in.brothers_sisters.remove(f.in.name);
							t=t.bro_sis;
						}
						this.num = this.bianliNum(this.root)-1;
						return true;
					}
				}
				else{
					if(f.in.brothers_sisters!=null) {
						Family s,t = f.parents.child;
						s=t;
						while(t.bro_sis!= f) {
							t=t.bro_sis;
						}
						if(f.parents.spouse!=null) {
							f.parents.in.childNum--;
							f.parents.in.children.remove(f.in.name);
							f.parents.spouse.in.children.remove(f.in.name);
							f.parents.spouse.in.childNum--;
						}
						else {
							Family a=this.isAtTree(this.root,f.in.motherName );
							if(a!=null) {
								a.in.childNum--;
								a.in.children.remove(f.in.name);
								a.spouse.in.childNum--;
								a.spouse.in.children.remove(f.in.name);
							}
						}
						while(s!=null) {
							s.in.brothers_sisters.remove(f.in.name);
							s=s.bro_sis;
						}
						t.bro_sis=null;
						f.parents=null;
						this.num = this.bianliNum(this.root)-1;
						return true;
					}
					else {
						if(f.parents.spouse==null) {
							Family t = this.isAtTree(this.root, f.parents.in.spouseName);
							t.child=null;
							if(f.parents.spouse!=null) {
								f.parents.in.childNum--;
								f.parents.in.children.remove(f.in.name);
								f.parents.spouse.in.children.remove(f.in.name);
								f.parents.spouse.in.childNum--;
							}
							else {
								Family a=this.isAtTree(this.root,f.in.motherName );
								if(a!=null) {
									a.in.childNum--;
									a.in.children.remove(f.in.name);
									a.spouse.in.childNum--;
									a.spouse.in.children.remove(f.in.name);
								}
							}
							f.parents=null;
							this.num = this.bianliNum(this.root)-1;
							return true;
						}
						else {
							f.parents.child = null;
							if(f.parents.spouse!=null) {
								f.parents.in.childNum--;
								f.parents.in.children.remove(f.in.name);
								f.parents.spouse.in.children.remove(f.in.name);
								f.parents.spouse.in.childNum--;
							}
							else {
								Family a=this.isAtTree(this.root,f.in.motherName );
								if(a!=null) {
									a.in.childNum--;
									a.in.children.remove(f.in.name);
									a.spouse.in.childNum--;
									a.spouse.in.children.remove(f.in.name);
								}
							}
							f.parents=null;
							this.num = this.bianliNum(this.root)-1;
							return true;
						}
					}
				}
			}
		}
		else return false;
		return false;
	}
	
	public void inquire_N(Family r,int level) {         //查询第N代的人
		if(r != null) {
			if(r.in.levelTemp==level)
				this.n_People.add(r.in);
			if(r.bro_sis != null)
				inquire_N(r.bro_sis,level);
			if(r.spouse != null)
				inquire_N(r.spouse,level);
			if(r.child != null)
				inquire_N(r.child,level);
		}
	}
	
	public String addMember(Person p) {        //添加成员
		if(p!=null) {
			Family a = new Family(p),s,t;
			if(p.fatherName!=null) {
				Family fa = this.isAtTree(this.root, p.fatherName);
				if(fa!=null) {
					if(fa.in.sex.equals("女"))return "输入的父亲姓名有误！（性别错误）";
					if(fa.spouse==null) {
						Family mo = this.isAtTree(this.root, fa.in.spouseName);
						a.parents=fa;
						s=mo.child;
						t=s;
						if(s!=null) {
							while(s.bro_sis!=null) {
								s=s.bro_sis;
							}
							s.bro_sis=a;
							if(mo.in.children!=null&&fa.in.children!=null) {
								mo.in.children.add(a.in.name);
								fa.in.children.add(a.in.name);
							}
							while(t!=a) {
								if(t.in.brothers_sisters==null) {
									t.in.brothers_sisters=new ArrayList<String>();
									t.in.brothers_sisters.add(a.in.name);
								}
								if(a.in.brothers_sisters==null) {
									a.in.brothers_sisters=new ArrayList<String>();
									a.in.brothers_sisters.add(t.in.name);
								}
								t=t.bro_sis;
							}
						}
						else {
							mo.child=a;
							mo.in.children=new ArrayList<String>();
							fa.in.children=new ArrayList<String>();
							mo.in.children.add(a.in.name);
							fa.in.children.add(a.in.name);
						}
						fa.in.childNum=fa.in.children.size();
						mo.in.childNum=mo.in.children.size();
						a.in.levelTemp=fa.in.levelTemp+1;
						a.in.motherName = mo.in.name;
						this.num++;
						return "加入成功！";
					}
					else{
						a.parents=fa;
						s=fa.child;
						Family mo = this.isAtTree(this.root, fa.in.spouseName);
						if(s!=null) {
							while(s.bro_sis!=null) {
								a.in.brothers_sisters.add(s.in.name);
								s=s.bro_sis;
							}
							s.bro_sis=a;
							if(mo.in.children!=null&&fa.in.children!=null) {
								mo.in.children.add(a.in.name);
								fa.in.children.add(a.in.name);
							}
						}
						else {
							fa.child=a;
							mo.in.children=new ArrayList<String>();
							fa.in.children=new ArrayList<String>();
							mo.in.children.add(a.in.name);
							fa.in.children.add(a.in.name);
						}
						fa.in.childNum=fa.in.children.size();
						mo.in.childNum=mo.in.children.size();
						a.in.levelTemp=fa.in.levelTemp+1;
						a.in.motherName = mo.in.name;
						this.num++;
						return "加入成功！";
					}
				}
				else return "输入的父亲不在家族中";
			}
			else{
				Family sp = this.isAtTree(this.root, a.in.spouseName);
				if(sp!=null) {
					if(sp.in.spouseName==null) {
						sp.spouse=a;
						sp.in.spouseName=a.in.name;
						if(sp.in.sex.equals("男")) {
							a.in.sex="女";
						}
						else a.in.sex="男";
						a.in.levelTemp=sp.in.levelTemp;
						this.num++;
						return "加入成功！";
					}
					else return a.in.name+"的夫妻：”"+a.in.spouseName+"” 已有伴侣，插入不成功！";
				}
				else return a.in.name+"的夫妻：”"+a.in.spouseName+"” 不在家族中，无法插入！";
			}
		}
		return "无法加入（空指针异常）";
	}
	
	public void connectionDB_MySQL(String passNum) {
		String dbName = "Family";
		userPwd = passNum;
		 String tablesql = "create table member(" +
		      		"name varchar(8) primary key," +
		      		"age int not null," +
		      		"sex varchar(4) not null," +
		      		"birthday varchar(8) not null," +
		      		"father varchar(8) not null," +
		      		"mother varchar(8) not null," +
		      		"spouse varchar(8) not null," +
		      		"childNum int not null," +
		      		"level int not null," +
		      		"isAlive varchar(8) not null," +
		      		"bro_sis varchar(255) not null," +
		      		"children varchar(255) not null);";
		try {
			Class.forName("com.mysql.jdbc.Driver");//装载驱动程序
			dbConn = DriverManager.getConnection(dbUL,userName,userPwd);
			 String databaseSql = "create database " + dbName;
			  if(dbConn!=null)  {
		             System.out.println("Succeeded connecting to the Database!");
		             stmt = dbConn.createStatement();
		             stmt.executeUpdate("Drop database "+dbName+";");
		             stmt.executeUpdate(databaseSql);
		             newConn = DriverManager.getConnection(dbNewUL + dbName,
		            	       userName, userPwd);
		             if (newConn != null) {
		            	  System.out.println("已经连接到新创建的数据库：" + dbName);
		            	  Statement newSmt = newConn.createStatement();
		            	  int i = newSmt.executeUpdate(tablesql);//DDL语句返回值为0;
		            	   if (i == 0) {
		            	       System.out.println(tablesql + "表已经创建成功！");
		            	    }
		            	   try {
		            		   String s = "家谱管理系统成员.txt";
		            		   String line;
		            		   BufferedReader in = new BufferedReader( new FileReader(s));
		           				line = in.readLine();
		           				while(line != null) {
		           					String[] st = line.split(",");
		           					newSmt.executeUpdate("insert into member values ('"
		           							+st[0]+"',"
		           							+Integer.parseInt(st[1])+",'"
		           							+st[2]+"','"
		           							+st[3]+"','"
		           							+st[4]+"','"
		           							+st[5]+"','"
		           							+st[6]+"',"
		           							+Integer.parseInt(st[7])+","
		           							+Integer.parseInt(st[8])+",'"
		           							+st[9]+"','"
		           							+st[10]+"','"
		           							+st[11]+"');");
		           					line=in.readLine();
		           				}	
		            	   }catch(IOException e) {
		            		   e.printStackTrace();
		            	   }
		             }
		            	  
			  }
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			
		}finally {
			try {
				if(rs!=null) {
					rs.close();
					rs=null;
				}
				if(stmt!=null) {
					stmt.close();
					stmt=null;
				}
				if(dbConn!=null) {
					dbConn.close();
					dbConn=null;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String modification(String name,String new_name,int new_age,Birthday ymd,Boolean new_isAlive) {
		Family f = this.isAtTree(Family.root, name);
		if(f!=null) {
			if(f.parents!=null) {
				f.in.name=new_name;
				f.in.age=new_age;
				f.in.ymd=ymd;
				f.in.isAlive=new_isAlive;
				int i;
				i=f.parents.in.children.indexOf(name);
				f.parents.in.children.remove(name);
				f.parents.in.children.add(i, new_name);
				f.spouse.in.spouseName=new_name;
				Family t=f.parents.child,s;
				s=t;
				while(s!=null) {
					if(s!=f) {
						i=s.in.brothers_sisters.indexOf(name);
						s.in.brothers_sisters.remove(name);
						s.in.brothers_sisters.add(i, new_name);
					}
					s=s.bro_sis;
				}
				s=f.child;
				while(s!=null) {
					if(f.in.sex.equals("男"))
						s.in.fatherName=new_name;
					else s.in.motherName=new_name;
					s=s.bro_sis;
				}
				return "修改完成！";
			}
			else {
				Family spouse = this.isAtTree(Family.root, f.in.spouseName);
				if(spouse!=null) {
					f.in.name=new_name;
					f.in.age=new_age;
					f.in.ymd=ymd;
					f.in.isAlive=new_isAlive;
					spouse.in.spouseName=new_name;
					int i;
					Family s;
					s=spouse.child;
					while(s!=null) {
						if(f.in.sex.equals("男"))
							s.in.fatherName=new_name;
						else s.in.motherName=new_name;
						s=s.bro_sis;
					}
					return "修改完成！";
				}
			}
		}
		return "查无此人！修改失败";
	}
}


class MyCanvas extends Canvas {
	Family root;
	int x,y,w,h;
	Graphics g;
	ArrayList<Shape> shapes = new ArrayList<Shape>();  
	 
	
	public MyCanvas() {
		
	}
	
    public ArrayList<Shape> getShapes() {  
        return shapes;  
    }  
    
	public void printTree(Family root,int w) {
		this.root=root;
		root.location.x=w-500-40;
		root.location.y=20;
		this.w=w;
		this.setBackground(new Color(245,235,225));
		this.drawFamilyTree(root);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(int i=0;i<shapes.size();i++) {
			Shape s = shapes.get(i);
			s.draw(g);
		}
	}
	
	public void drawFamilyTree(Family root) {
		if(root!=null) {
			if(root.in.sex.equals("男")) {
				Rect rect = new Rect(root.location.x,root.location.y,50,30);
				if(root.in.isAlive==false)
					rect.setColor(Color.black);
				else rect.setColor(Color.red);
					this.getShapes().add(rect);
			}
			else {
				Oval oval = new Oval(root.location.x,root.location.y,50,30);
				if(root.in.isAlive==false)
					oval.setColor(Color.black);
				else oval.setColor(Color.red);
					this.getShapes().add(oval);
			}
			Word word = new Word(root.in.name,root.location.x+25-12,root.location.y+15+5);
			word.setColor(Color.blue);
			this.getShapes().add(word);
			if(root.spouse!=null) {
				if(root.bro_sis!=null) {
					Line line = new Line(root.location.x,root.location.y+15,root.location.x-30,root.location.y+15);
					line.setColor(Color.red);
					this.getShapes().add(line);
					root.spouse.location.x=root.location.x-30-50;
					root.spouse.location.y=root.location.y;
					drawFamilyTree(root.spouse);
				}
				else {
					Line line = new Line(root.location.x+50,root.location.y+15,root.location.x+30+50,root.location.y+15);
					line.setColor(Color.red);
					this.getShapes().add(line);
					root.spouse.location.x=root.location.x+30+50;
					root.spouse.location.y=root.location.y;
					drawFamilyTree(root.spouse);
				}
			}
			if(root.bro_sis!=null) {
				int i=root.parents.in.childNum;
				if(root.in.levelTemp<=1)
					root.bro_sis.location.x=root.location.x+500/(i-1);
				else if(root.in.levelTemp<4)
					root.bro_sis.location.x=root.location.x+300/(i-1);
				else root.bro_sis.location.x=root.location.x+220/(i-1);
				root.bro_sis.location.y=root.location.y;
				this.drawFamilyTree(root.bro_sis);
			}
			if(root.child!=null) {
				if(root.spouse!=null) {
					if(root.bro_sis!=null) {
						Line line1 = new Line(root.location.x-15,root.location.y+15,root.location.x-15,root.location.y+15+50);
						line1.setColor(Color.black);
						this.getShapes().add(line1);
						if(root.in.childNum<=1&&root.in.childNum>0) {
							root.child.location.x=root.location.x-15-25;
							root.child.location.y=root.location.y+15+50;
							this.drawFamilyTree(root.child);
						}
						if(root.in.childNum>1) {
							int k=root.in.childNum-1;
							int m;
							if(root.in.levelTemp<=0) m=500;
							else if(root.in.levelTemp<3) m=300;
							else m=220;
							int i=m/k;
							Line l1,l2;
							l1=new Line(root.location.x-15,root.location.y+15+50,root.location.x-15-m/2,root.location.y+15+50);
							l2=new Line(root.location.x-15,root.location.y+15+50,root.location.x-15+m/2,root.location.y+15+50); 
							l1.setColor(Color.black);
							l1.setColor(Color.black);
							this.getShapes().add(l1);
							this.getShapes().add(l2);
							for(int j=0;j<k+1;j++) {
								Line l3 = new Line(root.location.x-15-m/2+j*i,root.location.y+15+50,root.location.x-15-m/2+j*i,root.location.y+15+50+50);
								l3.setColor(Color.black);
								this.getShapes().add(l3);
							}
							root.child.location.x=root.location.x-m/2-15-25;
							root.child.location.y=root.location.y+15+50+50;
							this.drawFamilyTree(root.child);
						}
					}
					else {
						Line line1 = new Line(root.location.x+15+50,root.location.y+15,root.location.x+15+50,root.location.y+15+90);
						line1.setColor(Color.black);
						this.getShapes().add(line1);
						if(root.in.childNum<=1&&root.in.childNum>0) {
							root.child.location.x=root.location.x+40;
							root.child.location.y=root.location.y+15+90;
							this.drawFamilyTree(root.child);
						}
						if(root.in.childNum>1) {
							int k=root.in.childNum-1;
							int m;
							if(root.in.levelTemp<=0) m=500;
							else if(root.in.levelTemp<3) m=300;
							else m=220;
							int i=m/k;
							Line l1,l2;
							l1=new Line(root.location.x+15+50,root.location.y+15+90,root.location.x+15+50-m/2,root.location.y+15+90);
							l2=new Line(root.location.x+15+50,root.location.y+15+90,root.location.x+15+50+m/2,root.location.y+15+90); 
							l1.setColor(Color.black);
							l1.setColor(Color.black);
							this.getShapes().add(l1);
							this.getShapes().add(l2);
							for(int j=0;j<k+1;j++) {
								Line l3 = new Line(root.location.x+15+50-m/2+j*i,root.location.y+15+90,root.location.x+15+50-m/2+j*i,root.location.y+15+50+90);
								l3.setColor(Color.black);
								this.getShapes().add(l3);
							}
							root.child.location.x=root.location.x-m/2+40;
							root.child.location.y=root.location.y+15+50+90;
							this.drawFamilyTree(root.child);
						}
					}
				}
				if(root.in.name=="祖先") {
					Line line1 = new Line(root.location.x+25,root.location.y+30,root.location.x+25,root.location.y+30+50);
					line1.setColor(Color.black);
					this.getShapes().add(line1);
					if(root.in.childNum<=1&&root.in.childNum>0) {
						root.child.location.x=root.location.x;
						root.child.location.y=root.location.y+30+50;
						this.drawFamilyTree(root.child);
					}
					if(root.in.childNum>1) {
						int k=root.in.childNum-1;
						int i=500/k;
						Line l1,l2;
						l1=new Line(root.location.x+25,root.location.y+30+50,root.location.x+25-250,root.location.y+30+50);
						l2=new Line(root.location.x+25,root.location.y+30+50,root.location.x+25+250,root.location.y+30+50); 
						l1.setColor(Color.black);
						l1.setColor(Color.black);
						this.getShapes().add(l1);
						this.getShapes().add(l2);
						for(int j=0;j<root.in.childNum;j++) {
							Line l3 = new Line(root.location.x+25-250+j*i,root.location.y+30+50,root.location.x+25-250+j*i,root.location.y+30+50+50);
							l3.setColor(Color.black);
							this.getShapes().add(l3);
						}
						root.child.location.x=root.location.x+25-250-25;
						root.child.location.y=root.location.y+30+50+50;
						this.drawFamilyTree(root.child);
					}
				}
			}
		}
	}
}



class CFrame extends JFrame {
	JScrollPane sp;
	MyCanvas my;
	CFrame() {
		
	}
	CFrame(Family root) {
		this.setSize(1200,600);
		this.setTitle("家谱图");
		this.setLayout(null);
		my = new MyCanvas();
		my.printTree(root, 1200);
		my.setBounds(0, 0, 1200, 1500);
		sp = new JScrollPane(my);
		JScrollBar jsb=sp.getVerticalScrollBar();
		sp.setBounds(10, 10, 1400, 1500);
		jsb.setValue(jsb.getMaximum());
		this.add(sp);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

abstract class Shape {          //图形
	private Color c;
	public void setColor(Color c) {
		this.c = c;
	}
	public Color getColor() {
		return c;
	}
	  /** 
     * 绘制的方法 
     * @param g 
     */ 
	public abstract void draw(Graphics g);
}

class Word extends Shape {

	String s;
	int x,y;
	
	public Word(String s,int x,int y) {
		this.s=s;
		this.x=x;
		this.y=y;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawString(s, x, y);
	}
	
}

class Line extends Shape {
	int x1,x2;
	int y1,y2;
	public Line(int x1,int y1,int x2,int y2) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawLine(x1, y1, x2, y2);
	}
}

class Rect extends Shape {
	int x,y,w,h;
	public Rect(int x,int y,int w,int h) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawRect(x, y, w, h);
	}
}


class Oval extends Shape {
	int x,y,w,h;
	
	public Oval(int x,int y,int w,int h) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawOval(x, y, w, h);
	}
}




