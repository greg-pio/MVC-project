import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class StartWindow extends JFrame {

	public ArrayList<ChildWindowLogController> controllerList = new ArrayList<ChildWindowLogController>();
	
	StartWindow() {

		setVisible(true);
		setTitle("StartWindow");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JLabel jLabel1 = new JLabel("Hello in my GUI application");
		jLabel1.setAlignmentX(CENTER_ALIGNMENT);

		JButton jButton1 = new JButton("Open window");
		jButton1.setAlignmentX(CENTER_ALIGNMENT);

		this.add(Box.createRigidArea(new Dimension(0, 20)));
		add(jLabel1);
		this.add(Box.createRigidArea(new Dimension(0, 40)));
		add(jButton1);
		
		StartWindow self = this;

		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChildWindowLogController cont = new ChildWindowLogController(self);
				controllerList.add(cont);
			}
		});

		pack();
		setSize(300, 200);
	}	
	
	public void refreshView() {
		for (ChildWindowLogController contr : controllerList) {
			contr.update();
		}
	}
}
