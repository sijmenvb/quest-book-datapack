package gui;

/* interface for ui elements that need to be updated.
 * this is our observer for this observer pattern.
 */
public interface UpdatableGUI {
	public void update(int currentPage, int noPages,int currentElemnt,int noElements);
}
