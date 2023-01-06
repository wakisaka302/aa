package create3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class button1 extends JPanel implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JPanel falseimage;
	int count = 0;
	int lisetC = 0;
	String s="";
	int count2=0;
	
	
//	private JPanel contentPane;
	
	/**
	 * Create the panel.
	 */
	public button1() {
		ArrayList<String> list = new ArrayList<String>();
		textField = new JTextField("運命を切り開け");
		textField.setColumns(10);
		
		textField_1 = new JTextField("満足");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("不満足");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField("リセット");
		textField_3.setColumns(10);
		
		//int count = 0;
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				s = nitaku();
				textField.setText(s);
				count++;
				count2++;
				System.out.println(count+"回目："+s);
//				list.add(s);
//				System.out.println(list.get(list.size()-1));
				
			}
		});
		if(count2==0) {
			btnNewButton.setEnabled(true);
		} else {
			btnNewButton.setEnabled(false);
			
		}
		
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\3030747\\Desktop\\push1.jpg"));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\3030747\\Desktop\\push1.jpg"));
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("trueimage");
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\3030747\\Desktop\\push1.jpg"));
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setActionCommand("falseimage");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(s.equals("右")) {
					System.out.println("true "+count+"回目：左");
					list.add("左");
					System.out.println(list.get(list.size()-1));
				} else {
					System.out.println("true "+count+"回目：右");
					list.add("右");
					System.out.println(list.get(list.size()-1));
				}
				
			}
		});
		
		
		
		 JButton btnNewButton_3 = new JButton("");
		 btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\3030747\\Desktop\\push1.jpg"));
		 btnNewButton_3.addActionListener(this);
		 btnNewButton_3.setActionCommand("backgroundimage");
		 btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText("運命を切り開け");
				}
			});	
		 
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_2)
							.addGap(18)
							.addComponent(btnNewButton_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(24))
		);
		setLayout(groupLayout);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("backgroundimage")) {
			Main1.panel.add(new backgroundimage(), "backgroundimage");
		} else if(cmd.equals("trueimage")) {
			Main1.panel.add(new trueimage(), "trueimage");
		}
		else if(cmd.equals("falseimage")) {
			Main1.panel.add(new falseimage(), "falseimage");
		}
		
		Main1.layout.show(Main1.panel, cmd);
	}
	
	
	public static String nitaku() {
		Random rand = new Random();
		int num = rand.nextInt(100);
		if(num%2==0) {
			return "右";
		} else {
			return "左";
		}
		
	}
	
	public static boolean isLiset() {
		return true;
	}
	
	
}
