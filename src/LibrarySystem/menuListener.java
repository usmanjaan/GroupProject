package LibrarySystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuListener implements ActionListener {

	SearchScreen ss;
	public menuListener(SearchScreen ml)
	{
		ss = ml;
	}
	
	//newbook,editbook,retirebook,allbook,bookloan,odbook,
	//addcust,editcust,delcust,scult,allcult,cwbol,cwob,
	//lbook,rbook,allloan,oloan;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	String actionCommend = e.getActionCommand();
	if(actionCommend.equals("newbook"))
	{
		ss.setTitle("Item 1 selected");
	}
	{
		
	}
	
	
	}

}
