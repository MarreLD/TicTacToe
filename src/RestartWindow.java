import javax.swing.JFrame;
//This is the super class for all the subclasses, extends the JFRAME in order to use its function
public abstract class RestartWindow extends JFrame implements Window{
	public RestartWindow(int width, int height, String windowTitle) {
		// TODO Auto-generated constructor stub
		  this.setSize(width,height);
	      this.setTitle(windowTitle);
	}
	
}
