package project;


	




	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;

	public class Othello extends JFrame implements ActionListener {
	    
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		char count ='0';
		Boolean test=false;
		JPanel[] row = new JPanel[9];
	    JButton[] button = new JButton[64];
	    String[] buttonString = {" "," "," "," "," "," "," "," ",
	    						 " "," "," "," "," "," "," "," ",
	    						 " "," "," "," "," "," "," "," ",
	    						 " "," "," ","0","1"," "," "," ",
	    						 " "," "," ","1","0"," "," "," ",
	    						 " "," "," "," "," "," "," "," ",
	    						 " "," "," "," "," "," "," "," ",
	    						 " "," "," "," "," "," "," "," "};
	    int[] dimW = {50,50,50,50};
	    int[] dimH = {40, 40};
	    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
	    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
	    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
	    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
	    boolean[] function = new boolean[8];
	    double[] temporary = {0, 0};
	    //remove or display result
	    JTextArea display = new JTextArea(1,20);
	    Font font = new Font("Times new Roman", Font.BOLD, 14);
	    
	    Ireverse() {
	        super("My First Game in java");
	        setDesign();
	        setSize(500, 500);
	        setResizable(false);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        GridLayout grid = new GridLayout(9,8);
	        setLayout(grid);
	        
	        for(int i = 0; i < 8; i++)
	            function[i] = false;
	        
	        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
	        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);
	        for(int i = 0; i < 9; i++)
	            row[i] = new JPanel();
	        row[0].setLayout(f1);
	        for(int i = 1; i < 9; i++)
	            row[i].setLayout(f2);
	        
	        for(int i = 0; i < 64; i++) {
	            button[i] = new JButton();
	            button[i].setText(buttonString[i]);
	            button[i].setFont(font);
	            button[i].addActionListener(this);
	        }
	        
	        display.setFont(font);
	        display.setEditable(false);
	        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        display.setPreferredSize(displayDimension);
	        for(int i = 0; i < 64; i++)
	            button[i].setPreferredSize(regularDimension);
	       /* for(int i = 14; i < 18; i++)
	            button[i].setPreferredSize(rColumnDimension);
	        button[18].setPreferredSize(zeroButDimension);*/
	        
	        row[0].add(display);
	        add(row[0]);
	        
	        for(int i = 0; i < 8; i++)
	            row[1].add(button[i]);
	       // row[1].add(button[14]);
	        add(row[1]);
	        
	        for(int i = 8; i < 16; i++)
	            row[2].add(button[i]);
	        //row[2].add(button[15]);
	        add(row[2]);
	        
	        for(int i = 16; i < 24; i++)
	            row[3].add(button[i]);
	        //row[3].add(button[16]);
	        add(row[3]);
	        
	        //row[4].add(button[18]);
	        for(int i = 24; i < 32; i++)
	            row[4].add(button[i]);
	        //row[4].add(button[17]);
	        add(row[4]);
	        for(int i = 32; i < 40; i++)
	            row[5].add(button[i]);
	       // row[1].add(button[14]);
	        add(row[5]);
	        for(int i = 40; i < 48; i++)
	            row[6].add(button[i]);
	       // row[1].add(button[14]);
	        add(row[6]);
	        for(int i = 48; i < 56; i++)
	            row[7].add(button[i]);
	       // row[1].add(button[14]);
	        add(row[7]);
	        for(int i = 56; i < 64; i++)
	            row[8].add(button[i]);
	       // row[1].add(button[14]);
	        add(row[8]);
	        
	        
	        setVisible(true);
	    }
	    //TODO
	    
	   
	    
	    public final void setDesign() {
	        try {
	            UIManager.setLookAndFeel(
	                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch(Exception e) {   
	        }
	    }
	    
	    @Override
	    public void actionPerformed(ActionEvent ae) {
	    	for(int i=0;i<64;i++)
	    	{
	    		if(ae.getSource()==button[i])
	    		{
	    			display.setText("");

		        	if(test)
		        	{
		        		button[i].setText("0");
		        		test=!test;
		        	}
		        	else
		        	{
		        		button[i].setText("1");
		        		test=!test;
		        	}
	    			int[]arr={i-8,i-7,i+1,i+9,i+8,i+7,i-1,i-9};
	    			Boolean[]firstTime={true,true,true,true,true,true,true,true};
	    			Boolean[]isCompleted={false,false,false,false,false,false,false,false};
	    			boolean completed=false;
	    			while(!completed)
	    			{
	    			for(int j=0;j<8;j++)
	    			{
	    				if(arr[j]>=64||arr[j]<0)
	    				{
	    					isCompleted[j]=true;
	    					continue;
	    				}
	    				int count=0;
	    				
	    				if(button[arr[j]].getText()==button[i].getText())
	    				{
	    					isCompleted[j]=true;
	    					if(firstTime[j])
	    					{
	    						
	    						
	    					}
	    					else
	    					{
	    						if(j==0)
	    							for(int z=i-8;z>arr[j];z=z-8)
	    							{
	    								button[z].setText(button[i].getText());
	    							}
	    						if(j==1)
	    							for(int z=i-7;z>arr[j];z=z-7)
	    							{
	    								button[z].setText(button[i].getText());
	    							}
	    						if(j==2)
	    							for(int z=i+1;z<arr[j];z=z+1)
	    							{
	    								button[z].setText(button[i].getText());
	    							}
	    						if(j==3)
	    							for(int z=i+9;z<arr[j];z=z+9)
	    							{
	    								button[z].setText(button[i].getText());
	    							}
	    						if(j==4)
	    							for(int z=i+8;z<arr[j];z=z+8)
	    							{
	    								button[z].setText(button[i].getText());
	    							}
	    						if(j==5)
	    							for(int z=i+7;z<arr[j];z=z+7)
	    							{
	    								button[z].setText(button[i].getText());
	    							}
	    						if(j==6)
	    							for(int z=i-1;z>arr[j];z=z-1)
	    							{
	    								button[z].setText(button[i].getText());
	    							}
	    						if(j==7)
	    							for(int z=i-9;z>arr[j];z=z-9)
	    							{
	    								button[z].setText(button[i].getText());
	    							}
	    					}
	    					
	    				}
	    				else
    					{	if(button[arr[j]].getText()!=" ")
    						{
    						firstTime[j]=false;
    						if(j==0)
    							arr[j]=arr[j]-8;
    						if(j==1)
    							arr[j]=arr[j]-7;
    						if(j==2)
    							arr[j]=arr[j]+1;
    						if(j==3)
    							arr[j]=arr[j]+9;
    						if(j==4)
    							arr[j]=arr[j]+8;
    						if(j==5)
    							arr[j]=arr[j]+7;
    						if(j==6)
    							arr[j]=arr[j]-1;
    						if(j==7)
    							arr[j]=arr[j]-9;
    						}
    					else
    					{
    						isCompleted[j]=true;
    						firstTime[j]=true;
    					}
    					}
	    			}
	    			int checking=0;
	    			int checkingF=0;
	    			for(Boolean p:firstTime)
	    			{
	    				
	    				if(p)
	    				{
	    					checkingF++;
	    				}
	    			}
	    			if(checkingF==8)
	    			{
	    				test=!test;
	    				button[i].setText(" ");
	    				display.setText("invalid move");
	    			}
	    			for(Boolean p:isCompleted)
	    			{
	    				
	    				if(p)
	    				{
	    					checking++;
	    				}
	    			}
	    			if(checking==8)
	    			{
	    				completed=true;
	    			}
	    			
	    		}
	    	}
	    	}
	    }
	    
	    public static void main(String[] arguments) {
	        Ireverse c = new Ireverse();
	    }
	}







