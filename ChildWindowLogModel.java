import java.util.ArrayList;
import java.util.List;

public class ChildWindowLogModel {

	private List<ChildWindowLog> data;
	private ChildWindowLogController controller;

	public ChildWindowLogModel() {
		this.data = new ArrayList<>();
		controller = null;
	}

	public ChildWindowLogModel sendModel() {
		return this;
	}

	public void setController(ChildWindowLogController controller) {
		this.controller = controller;
	}
	
	
	public List<ChildWindowLog> getData() {
		return data;
	}

	public void dumpData(String message) {
		data.add(new ChildWindowLog(message));
	}	
}