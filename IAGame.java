import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
	//Start Class
public class IAGame extends JFrame implements WindowListener,ActionListener {
Random randomGenerator = new Random();
JTextField text = new JTextField();
JTextField text2 = new JTextField();
JTextField text3 = new JTextField();
JTextField text4 = new JTextField();
JTextField text5 = new JTextField();
JTextField text6 = new JTextField();
JTextField money = new JTextField();
JTextField name = new JTextField("Lemons : 200");
JTextField name2 = new JTextField("Caffeine : 700");
JTextField name3 = new JTextField("Sweetener : 1000");
JTextField name4 = new JTextField("Workers : 1000");
JTextField name5 = new JTextField("Cashiers : 2000");
JTextField name6 = new JTextField("Sugar : 200");
double quality = 50;
JTextField qualityField = new JTextField("Quality = "+quality);
Button b;
Button b2;
Button b3;
Button b4;
Button b5;
Button b6;
Button click;
Button saveButton;
Button loadButton;
Button finishgame;
private double count = 1000;
int[] boundsText={165,125,150,30};
int[] boundsButton={90,110,60,60};
int lemonCount=0;
int CaffeineCount=0;
int SweetenerCount=0;
int workerCount=0;
int cashierCount=0;
int sugarCount=0;
int lemonCost=200;
int CaffeineCost=700;
int SweetenerCost=1000;
int workerCost=1000;
int cashierCost=2000;
int sugarCost=200;
int SweetenerTurn = 0;
double multi = 1+((workerCount*2)+(CaffeineCount/4))*(quality/50);
double gain = 200+((SweetenerCount+SweetenerTurn)*50)+(lemonCount+sugarCount*100);
int coffee=1000;
int coffeegain=1000;
JTextField competitor = new JTextField("Cafe Coffee : $"+coffee+".0");
String difficulty="easy";

//GUI Class
public IAGame(String title) throws Exception{
super(title);
System.out.println("Welcome to Lemonade Stand, the game! In this game, you are attempting to make a lemonade stand to compete against your competitor, \"Cafe Coffee\"."+
"\n\n"+" There are 6 different purchasable additions to your stand. Extra Lemons, Factory Caffeine, Special Sweetener, Workers, Cashiers, and Sugar\n");
System.out.println("Lemons : Adds quality to your lemonade, which indicates how much of your maximum profit you are generating.\n");
System.out.println("Caffeine : Caffeine increases your production and decreases your quality. \n");
System.out.println("Sweetener : Sweetener has small immediate effects and is expensive. However, as your game progresses, it adds quality to your lemonade.\n");
System.out.println("Workers : Workers increase your profit significantly. However, your overworking will put them on strike! Try to keep your number of Workers low, or you could lose them.\n");
System.out.println("Cashiers : Cashiers add an extra turn to your lemonade stand by stealing customers and profit from Cafe Coffee.\n");
System.out.println("Cups : Sugar, when kept at a 1:1 ratio with Extra Lemons, increases your production.\n");
System.out.println("Objective of the game : Build profit to 100,000$ faster than your competitor. Then, purchase the \"Win!\" addition.\n");
System.out.println("The algorith for the game is...\n");
System.out.println("Profit=[200+(SweetenerTurn*50)+(lemonCount+sugarCount*100)] * [1+((workerCount)+(CaffeineCount/4))*(quality/50)]");
System.out.println("Please type a difficulty : Easy, Medium, Hard, or Insane");
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
difficulty = input.readLine();
setLayout(null);
addWindowListener(this);
BufferedImage bf = ImageIO.read(new File("background1.jpg"));
this.setContentPane(new backImage(bf));
b = new Button("Buy");
b2 = new Button("Buy");
b3 = new Button("Buy");
b4 = new Button("Buy");
b5 = new Button("Buy");
b6 = new Button("Buy");

finishgame = new Button("Final Upgrade : 100,000");
click = new Button("Sell Lemonade!");
text.setBounds(boundsText[0],boundsText[1],boundsText[2],boundsText[3]);
b.setBounds(boundsButton[0],boundsButton[1],boundsButton[2],boundsButton[3]);
boundsText[0]=boundsText[0]+300;
boundsButton[0]=boundsButton[0]+300;
text2.setBounds(boundsText[0],boundsText[1],boundsText[2],boundsText[3]);
b2.setBounds(boundsButton[0],boundsButton[1],boundsButton[2],boundsButton[3]);
boundsText[0]=boundsText[0]+300;
boundsButton[0]=boundsButton[0]+300;
text3.setBounds(boundsText[0],boundsText[1],boundsText[2],boundsText[3]);
b3.setBounds(boundsButton[0],boundsButton[1],boundsButton[2],boundsButton[3]);
boundsText[0]=boundsText[0]-600;
boundsButton[0]=boundsButton[0]-600;
boundsText[1]=boundsText[1]+300;
boundsButton[1]=boundsButton[1]+300;
text4.setBounds(boundsText[0],boundsText[1],boundsText[2],boundsText[3]);
b4.setBounds(boundsButton[0],boundsButton[1],boundsButton[2],boundsButton[3]);
boundsText[0]=boundsText[0]+300;
boundsButton[0]=boundsButton[0]+300;
text5.setBounds(boundsText[0],boundsText[1],boundsText[2],boundsText[3]);
b5.setBounds(boundsButton[0],boundsButton[1],boundsButton[2],boundsButton[3]);
boundsText[0]=boundsText[0]+300;
boundsButton[0]=boundsButton[0]+300;
text6.setBounds(boundsText[0],boundsText[1],boundsText[2],boundsText[3]);
b6.setBounds(boundsButton[0],boundsButton[1],boundsButton[2],boundsButton[3]);
click.setBounds(90,550,150,150);
finishgame.setBounds(390,550,150,150);
qualityField.setBounds(240,550,100,30);
competitor.setBounds(600,550,150,30);
name.setBounds(90,70,150,30);
name2.setBounds(300+90,60,150,30);
name3.setBounds(300+300+90,60,150,30);
name4.setBounds(90,300+60,150,30);
name5.setBounds(300+90,300+60,150,30);
name6.setBounds(300+300+90,300+70,150,30);
money.setBounds(600,600,150,30);
money.setText("Your Money : $"+ count+"");

add(b);
add(b2);
add(b3);
add(b4);
add(b5);
add(b6);
add(click);
add(text);
add(text2);
add(text3);
add(text4);
add(text5);
add(text6);
add(qualityField);
add(money);
add(name);
add(name2);
add(name3);
add(name4);
add(name5);
add(name6);
add(competitor);
add(finishgame);
text.setEditable(false);
text2.setEditable(false);
text3.setEditable(false);
text4.setEditable(false);
text5.setEditable(false);
text6.setEditable(false);
qualityField.setEditable(false);
money.setEditable(false);
name.setEditable(false);
name2.setEditable(false);
name3.setEditable(false);
name4.setEditable(false);
name5.setEditable(false);
name6.setEditable(false);
competitor.setEditable(false);
b.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
click.addActionListener(this);
finishgame.addActionListener(this);
}

//Background Image Class
class backImage extends JComponent {
Image i;

//Creating Constructer
public backImage(Image i) {
this.i = i;
}
//Overriding the paintComponent method
@Override
public void paintComponent(Graphics g) {
g.drawImage(i, 0, 0, null);  // Drawing image using drawImage method
}
}

//Button Action Class
public void actionPerformed(ActionEvent e) {
if (e.getSource()==b&&count>=lemonCost&&lemonCount<=sugarCount+1){
	lemonCount++;
	text.setText("Lemon Count : "+lemonCount);
	count=count-lemonCost;
	if (quality<100)
		quality=quality+5;
		lemonCost=lemonCost+100;
	qualityField.setText("Quality = "+quality);
	int countInt;
	countInt = (int)count;
	money.setText("Your Money : $"+countInt+".0");
	name.setText("Lemon : "+lemonCost);
}

if (e.getSource()==b2&&count>=CaffeineCost){
	CaffeineCount++;
	text2.setText("Caffeine Count " + CaffeineCount);
	count=count-CaffeineCost;
	CaffeineCost=CaffeineCost+300;
	quality=quality-10;
	qualityField.setText("Quality = "+quality);
	int countInt;
	countInt = (int)count;
	money.setText("Your Money : $"+countInt+".0");
	name2.setText("Caffeine : "+CaffeineCost);
}

if(e.getSource()==b3&&count>=SweetenerCost){
	SweetenerCount++;
	count=count-SweetenerCost;
	SweetenerCost=SweetenerCost*2;
	if (SweetenerTurn==0)
		SweetenerTurn=1;
	name3.setText("Sweetener : "+SweetenerCost);
	text3.setText("Sweetener Count : " +SweetenerCount);
	int countInt;
	countInt = (int)count;
	money.setText("Your Money : $"+countInt+".0");
		 	}

if(e.getSource()==b4&&count>=workerCost){
 	workerCount++;
 	count=count-workerCost;
 	workerCost=workerCost+1000;
 	int workerRandom = randomGenerator.nextInt(10-workerCount);
 	if (workerRandom==1)
 		workerCount=0;
 	int countInt;
	countInt = (int)count;
	money.setText("Your Money : $"+countInt+".0");
 	text4.setText("Worker Count : "+workerCount);
 	name4.setText("Worker : "+workerCost);
		 	}

if(e.getSource()==b5&&count>=cashierCost){
cashierCount++;
	text5.setText("Cashiers used : "+cashierCount);
	coffee=coffee-2000;
	count=count-cashierCost;
	cashierCost=cashierCost+1000;
	name5.setText("Cashier : "+cashierCost);
	int countInt;
	countInt = (int)count;
	money.setText("Your Money : $"+countInt+".0");
	competitor.setText("Cafe Coffee : $"+coffee+".0");
		 	}
if(e.getSource()==b6&&count>=sugarCost&&sugarCount<=lemonCount+1){
		 		sugarCount++;
		 		text6.setText("Sugar Count : "+sugarCount);
		 		count=count-sugarCost;
		 		sugarCost=sugarCost+100;
		 		int countInt;
	countInt = (int)count;
	money.setText("Your Money : $"+countInt+".0");
		 		name6.setText("Sugar : "+sugarCost);
		 	}

if(e.getSource()==finishgame&&count>=100000){
JOptionPane.showMessageDialog(null,"You crushed the competition! Nice job winning on "+difficulty+" difficulty!");
System.exit(0);
System.out.println("You crushed the competition! Nice job winning on "+difficulty+" difficulty!");
		 	}

if (e.getSource()==click){
   double multi = 1+((workerCount)+(CaffeineCount/4))*(quality/50);
double gain = 200+(SweetenerTurn*50)+(lemonCount+sugarCount*100);
  SweetenerTurn=SweetenerTurn+(SweetenerCount/2);
System.out.println("Your profit generated this turn: "+(gain*multi));
count=count+(gain*multi);
int countInt;
countInt = (int)count;
money.setText("Your Money : $"+countInt+".0");
if (difficulty.equalsIgnoreCase("easy"))
	coffee=coffee+1000;
if (difficulty.equalsIgnoreCase("medium"))
	coffee=coffee+2000;
if (difficulty.equalsIgnoreCase("hard"))
	coffee=coffee+3000;
if (difficulty.equalsIgnoreCase("insane"))
	coffee=coffee+4000;
competitor.setText("Cafe Coffee : $"+coffee+".0");
if (coffee>=100000){
	JOptionPane.showMessageDialog(null,"Cafe Coffee beat you to $100,000! You lose this time.");
	System.exit(0);
}
}
}
public void windowClosing(WindowEvent e) {
dispose();
System.exit(0);
}
public void windowOpened(WindowEvent e) {}
public void windowActivated(WindowEvent e) {}
public void windowIconified(WindowEvent e) {}
public void windowDeiconified(WindowEvent e) {}
public void windowDeactivated(WindowEvent e) {}
public void windowClosed(WindowEvent e) {}
//Main Method
public static void main(String[] args) throws Exception{
IAGame myWindow = new IAGame("Lemonade");
myWindow.setSize(1024,768);
myWindow.setVisible(true);
	}
	}
