import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class ChildWindowLogView extends JFrame {

	private ChildWindowLogController controller;
	private ChildWindowLogModel model;
	public JPanel jPanel;

	public ChildWindowLogView(ChildWindowLogController controller, ChildWindowLogModel model) {
		this.controller = controller;
		this.model = model;
		init();
	}

	public void init() {

		setVisible(true);
		setTitle("ChildWindow");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		jPanel.setPreferredSize(new Dimension(500, 1000));

		JScrollPane jScroll = new JScrollPane(jPanel);
		
		JPanel bottomPane = new JPanel();

		JTextField jTextField1 = new JTextField();
		jTextField1.setPreferredSize(new Dimension(450, 20));

		JButton jButton2 = new JButton("Add");

		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addChildWindowLog(jTextField1.getText());
			}
		});
		
		add(jScroll);
		bottomPane.add(jTextField1);
		bottomPane.add(jButton2);
		add(bottomPane);	
		
		pack();
				
	}

	public void showData(List<ChildWindowLog> data) {
		
		jPanel.removeAll();

		for (ChildWindowLog log : data) {
			JLabel jLabel = new JLabel(log.getMessage());
			jPanel.add(jLabel); 
		}
		
		pack();
		setSize(800, 600);
		
	}
}
