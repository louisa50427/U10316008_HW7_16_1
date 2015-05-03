import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DeckOfCards extends JFrame{
	JButton jbt = new JButton("Refresh");//建立按鈕
	JPanel panel = new JPanel();//建立畫布1
	JPanel panel2 = new JPanel();//建立畫布2
	ImageIcon[] deck = new ImageIcon[52];//建立一個陣列存52張牌
	JLabel IM1;
	JLabel IM2;
	JLabel IM3;
	JLabel IM4;
	
	public DeckOfCards(){
		//在陣列中存圖片	
		for(int i = 0 ; i <52 ;i++){
			deck[i] = new ImageIcon((getClass().getResource("card/"+(i+1)+".png")));
		}
		int[] array = new  int[4];
		//隨機抽4張不同的排
		for(int i=0;i < 4;i++){
   			array[i] =  (int)(Math.random()* 52);
			for(int j=0;j<i;j++){ 
      				while(array[i]==array[j]){
             				array[i] =  (int)(Math.random()* 52);
           			}
     			 } 
  		}
		
		//四張牌給圖跟印出
		panel.setLayout(new GridLayout(1,4,7,7));
		IM1 = new JLabel(deck[array[0]]);
		IM2 = new JLabel(deck[array[1]]);
		IM3 = new JLabel(deck[array[2]]);
		IM4 = new JLabel(deck[array[3]]);
		
		panel.add(IM1);
		panel.add(IM2);
		panel.add(IM3);
		panel.add(IM4);
		
		//畫布的位置
		this.add(panel2,BorderLayout.SOUTH);
		this.add(panel,BorderLayout.CENTER);
		jbt.addActionListener(new Refresh());//按鈕的動作
		panel2.add(jbt,BorderLayout.SOUTH);//按鈕的位置
	}
	
	

	
	//main method
	public static void main(String[] args){
			
		
		//建立物件
		DeckOfCards frame = new DeckOfCards();

		//設定各種條件
		frame.setTitle("Pick four cards");
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
	
		
	
	}
		
	//按鈕的動作
	class Refresh implements ActionListener{
		int[] array = new  int[4];
		@Override
		public void actionPerformed(ActionEvent E){
			for(int i=0;i < 4;i++){
   				array[i] =  (int)(Math.random()* 52);
				for(int j=0;j<i;j++){ 
      					while(array[i]==array[j]){
             					array[i] =  (int)(Math.random()* 52);
           				}
     				 } 
  			}
		
		
			panel.repaint();
			IM1.setIcon(deck[array[0]);
			IM2.setIcon(deck[array[1]);
			IM3.setIcon(deck[array[2]);
			IM4.setIcon(deck[array[3]);	
		}
	}
}
