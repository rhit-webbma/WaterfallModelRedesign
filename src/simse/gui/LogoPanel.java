/* File generated by: simse.codegenerator.guigenerator.LogoPanelGenerator */
package simse.gui;

import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;

import javafx.scene.layout.Pane;

import java.awt.Color;

import simse.SimSE;
import simse.engine.*;
import simse.state.*;
import simse.logic.*;

public class LogoPanel extends Pane implements MouseListener {
	private String path = "/simse/gui/images/layout/";

	private TabPanel tabPane;

	private JButton artifactButton;
	private JButton customerButton;
	private JButton employeeButton;
	private JButton projectButton;
	private JButton toolButton;
	private JButton aboutButton;
	private JButton infoButton;
	private JButton resetButton;

	private int selectedTabIndex = -1;

	private GridBagLayout gbl;

	private ImageIcon[] inactiveButton;
	private ImageIcon[] activeButton;
	private SimSEGUI gui;

	public LogoPanel(SimSEGUI g) {
		gui = g;
		gbl = new GridBagLayout();
		setLayout(gbl);

		// loads the tab buttons
		createButtonImageSet();

		// create the buttons
		artifactButton = new JButton(inactiveButton[0]);
		artifactButton.setMinimumSize(new Dimension(120, 16));
		customerButton = new JButton(inactiveButton[1]);
		customerButton.setMinimumSize(new Dimension(120, 16));
		employeeButton = new JButton(inactiveButton[2]);
		employeeButton.setMinimumSize(new Dimension(120, 16));
		projectButton = new JButton(inactiveButton[3]);
		projectButton.setMinimumSize(new Dimension(120, 16));
		toolButton = new JButton(inactiveButton[4]);
		toolButton.setMinimumSize(new Dimension(120, 16));

		// create the layout:
		createLayout();
	}

	public void setTabPanel(TabPanel tab) {
		if (tabPane == null)
			tabPane = tab;
	}

	public void createButtonImageSet() {
		inactiveButton = new ImageIcon[5];
		activeButton = new ImageIcon[5];

		inactiveButton[0] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnArtifact.gif"));
		inactiveButton[1] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnCustomer.gif"));
		inactiveButton[2] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnEmployee.gif"));
		inactiveButton[3] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnProject.gif"));
		inactiveButton[4] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnTool.gif"));

		activeButton[0] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnArtifactClicked.gif"));
		activeButton[1] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnCustomerClicked.gif"));
		activeButton[2] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnEmployeeClicked.gif"));
		activeButton[3] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnProjectClicked.gif"));
		activeButton[4] = new ImageIcon(ImageLoader.getImageFromURL(path
				+ "btnToolClicked.gif"));
	}

	public int getSelectedTabIndex() {
		return selectedTabIndex;
	}

	public void createLayout() {
		JPanel pnl = new JPanel(gbl);
		pnl.setOpaque(false);
		pnl.setBackground(new Color(0, 0, 0, 0));
		GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 5, 0, 0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 0), 0, 0);
		gbl.setConstraints(pnl, gbc);
		add(pnl);
		infoButton = new JButton();
		infoButton.setBackground(new Color(0, 0, 0, 0));
		infoButton.setOpaque(false);
		infoButton.setMinimumSize(new Dimension(24, 40));
		infoButton.setPreferredSize(new Dimension(24, 40));
		infoButton.setBorder(null);
		infoButton.addMouseListener(this);
		gbc = new GridBagConstraints(0, 0, 1, 1, 1, 1,
				GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(0, 0, 5, 0), 0, 0);
		gbl.setConstraints(infoButton, gbc);
		pnl.add(infoButton);
		resetButton = new JButton();
		resetButton.setBackground(new Color(0, 0, 0, 0));
		resetButton.setOpaque(false);
		resetButton.setMinimumSize(new Dimension(24, 40));
		resetButton.setPreferredSize(new Dimension(24, 40));
		resetButton.setBorder(null);
		resetButton.addMouseListener(this);
		gbc = new GridBagConstraints(0, 1, 1, 1, 1, 0,
				GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(5, 0, 0, 0), 0, 0);
		gbl.setConstraints(resetButton, gbc);
		pnl.add(resetButton);
		aboutButton = new JButton();
		aboutButton.setBackground(new Color(0, 0, 0, 0));
		aboutButton.setOpaque(false);
		aboutButton.setMinimumSize(new Dimension(170, 88));
		aboutButton.setPreferredSize(new Dimension(170, 88));
		addButton(aboutButton, 1, 0, 1, 5, 0, 1);
		// spacers to get the angled tab effect:
		JLabel lblCustSpacer1 = new JLabel("--");
		JLabel lblEmpSpacer1 = new JLabel("--");
		JLabel lblEmpSpacer2 = new JLabel("--");
		JLabel lblProjSpacer1 = new JLabel("--");

		addButton(artifactButton, 2, 0, 3, 1, 1, 0);

		addLabel(lblCustSpacer1, 2, 1, 1, 1, 0, 0);
		addButton(customerButton, 3, 1, 2, 1, 1, 0);

		addLabel(lblEmpSpacer1, 2, 2, 1, 1, 0, 0);
		addLabel(lblEmpSpacer2, 3, 2, 1, 1, 0, 0);
		addButton(employeeButton, 4, 2, 1, 1, 1, 0);

		addLabel(lblProjSpacer1, 2, 3, 1, 1, 0, 0);
		addButton(projectButton, 3, 3, 2, 1, 1, 0);

		addButton(toolButton, 2, 4, 3, 1, 1, 1);
	}

	public void addLabel(JLabel lb, int x, int y, int rowspan, int colspan,
			double wx, double wy) {
		GridBagConstraints gbc = new GridBagConstraints(x, y, rowspan, colspan,
				wx, wy, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0);
		gbl.setConstraints(lb, gbc);
		lb.setForeground(new Color(0, 0, 0, 0));
		add(lb);
	}

	public void addButton(JButton jb, int x, int y, int rowspan, int colspan,
			double wx, double wy) {
		GridBagConstraints gbc = new GridBagConstraints(x, y, rowspan, colspan,
				wx, wy, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(1, 1, 1, 1), 0, 0);
		jb.setBorder(null);
		jb.addMouseListener(this);
		jb.setOpaque(false);
		gbl.setConstraints(jb, gbc);
		add(jb);
	}

	public void paintComponent(Graphics g) {
		Image logo = ImageLoader.getImageFromURL(path + "simselogo.gif");
		g.setColor(new Color(102, 102, 102, 255));
		g.fillRect(0, 0, 340, 100);
		g.drawImage(logo, 0, 0, this);
	}

	public void mouseClicked(MouseEvent me) {
		Object source = me.getSource();

		if (source.equals(aboutButton)) {
			Point p = new Point(300, 300);
			JFrame f = null;
			SimSEAboutDialog about = new SimSEAboutDialog(f);
			about.setLocation(p);
			about.setVisible(true);
		} else if (source.equals(infoButton)) {
			new StartingNarrativeDialog(gui);
		} else if (source.equals(resetButton)) {
			int response = JOptionPane.showConfirmDialog(gui,
					"Are You Sure You Want To Reset?", "Reset Game?",
					JOptionPane.YES_NO_OPTION);
			if (response == JOptionPane.OK_OPTION) {
				// reset:
				if (gui.getEngine().getTimer() != null) {
					gui.getEngine().getTimer().stop();
				}
				gui.close();
				gui.dispose();
				SimSE.main(new String[] {});
			}

		} else {
			// clear all buttons to default setting:
			if (source instanceof JButton) {
				artifactButton.setIcon(inactiveButton[0]);
				customerButton.setIcon(inactiveButton[1]);
				employeeButton.setIcon(inactiveButton[2]);
				projectButton.setIcon(inactiveButton[3]);
				toolButton.setIcon(inactiveButton[4]);
			}

			if (source.equals(artifactButton)) {
				artifactButton.setIcon(activeButton[0]);
				selectedTabIndex = 0;
			} else if (source.equals(customerButton)) {
				customerButton.setIcon(activeButton[1]);
				selectedTabIndex = 1;
			} else if (source.equals(employeeButton)) {
				employeeButton.setIcon(activeButton[2]);
				selectedTabIndex = 2;
			} else if (source.equals(projectButton)) {
				projectButton.setIcon(activeButton[3]);
				selectedTabIndex = 3;
			} else if (source.equals(toolButton)) {
				toolButton.setIcon(activeButton[4]);
				selectedTabIndex = 4;
			}
		}

		tabPane.setGUIChanged();
		if (tabPane != null)
			tabPane.update();

		repaint();
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
		Object source = me.getSource();

		if (source instanceof JButton) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}

	public void mouseExited(MouseEvent me) {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}