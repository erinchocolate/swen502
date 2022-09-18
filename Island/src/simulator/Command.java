package simulator;
/**
* The Command interface define methods needed for staring or pausing island simulation 
*
* @author  Meiqiao
* 
*/
public interface Command {
	public void execute();
	public void pause();
}
