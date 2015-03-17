package com.mrcrayfish.modelcreator.panels;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.mrcrayfish.modelcreator.Cube;
import com.mrcrayfish.modelcreator.IValueUpdater;
import com.mrcrayfish.modelcreator.ModelCreator;

public class PropertiesTabs extends JTabbedPane
{
	private static final long serialVersionUID = 1L;

	private ModelCreator creator;

	public PropertiesTabs(ModelCreator creator)
	{
		this.creator = creator;
	}

	public void updateValues()
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			Component component = getComponentAt(i);
			if (component != null)
			{
				if (component instanceof TabPanel)
				{
					TabPanel tab = (TabPanel) component;
					JPanel panel = tab.getPanel();
					if (panel instanceof IValueUpdater)
					{
						IValueUpdater updater = (IValueUpdater) panel;
						Cube cube = creator.getSelectedCube();
						if (cube != null)
						{
							updater.updateValues(cube);
						}
					}
				}
			}
		}
	}
}
