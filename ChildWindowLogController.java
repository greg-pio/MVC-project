import javax.swing.JLabel;

public class ChildWindowLogController {

	private ChildWindowLogModel model;
	private ChildWindowLogView view;
	private StartWindow start;

	public ChildWindowLogController(StartWindow start) {
		this.start = start;
		model = Main.model.sendModel();
		model.setController(this);
		this.view = new ChildWindowLogView(this, model);
		view.showData(model.getData());
	}

	public void addChildWindowLog(String message) {
		model.dumpData(message);
		view.showData(model.getData());
		start.refreshView();
	}
	
	public void update() {
		view.showData(model.getData());
	}
}
