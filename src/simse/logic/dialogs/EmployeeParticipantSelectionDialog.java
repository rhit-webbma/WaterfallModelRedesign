/* File generated by: simse.codegenerator.logicgenerator.dialoggenerator.EmployeeParticipantSelectionDialogGenerator */
package simse.logic.dialogs;

import simse.gui.ImageLoader;
import simse.gui.TabPanel;
import simse.state.*;
import simse.adts.objects.*;
import simse.adts.actions.*;
import java.util.*;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EmployeeParticipantSelectionDialog extends Dialog implements EventHandler<MouseEvent> {
	private String partName;
	private Vector<SSObject> participants;
	private simse.adts.actions.Action action;
	private State state;
	private Employee selectedEmp;
	private int minNumParts;
	private int maxNumParts;
	private Vector<CheckBox> checkBoxes;
	private Button checkAllButton;
	private Button clearAllButton;
	private Button okButton;
	private Button cancelButton;
	private boolean actionCancelled;

	public EmployeeParticipantSelectionDialog(Stage owner, String pName,
			Vector<SSObject> parts, simse.adts.actions.Action act, State s,
			Employee emp) {
		partName = pName;
		participants = parts;
		action = act;
		state = s;
		selectedEmp = emp;
		actionCancelled = false;
		setMinAndMax();
		if (((selectedEmp != null) && (maxNumParts > 0) && (participants.size() > 0))
				|| ((selectedEmp == null) && (participants.size() > minNumParts))) {
			checkBoxes = new Vector<CheckBox>();
			setTitle("Participant Selection");
			VBox mainPane = new VBox();
			Pane topPane = new Pane();
			String title = "Choose ";
			if (selectedEmp != null) // selected emp already added in this
										// participant role
			{
				title = title.concat("other ");
			}
			title = title.concat(partName + " participant(s) (");
			if (minNumParts == maxNumParts) {
				title = title.concat("exactly " + minNumParts);
			} else {
				title = title.concat("at least " + minNumParts);
				if (maxNumParts < 999999) // not boundless
				{
					title = title.concat(", at most " + maxNumParts);
				}
			}
			title = title.concat("):");
			topPane.getChildren().add(new Label(title));
			GridPane middlePane = new GridPane();
			for (int i = 0; i < participants.size(); i++) {
				SSObject tempObj = participants.elementAt(i);
				String label = new String();
				if (tempObj instanceof SoftwareEngineer) {
					label = ("SoftwareEngineer ("
							+ ((SoftwareEngineer) tempObj).getName() + ")");
				} else if (tempObj instanceof RequirementsDocument) {
					label = ("RequirementsDocument ("
							+ ((RequirementsDocument) tempObj).getName() + ")");
				} else if (tempObj instanceof DesignDocument) {
					label = ("DesignDocument ("
							+ ((DesignDocument) tempObj).getName() + ")");
				} else if (tempObj instanceof Code) {
					label = ("Code (" + ((Code) tempObj).getName() + ")");
				} else if (tempObj instanceof SystemTestPlan) {
					label = ("SystemTestPlan ("
							+ ((SystemTestPlan) tempObj).getName() + ")");
				} else if (tempObj instanceof SEProject) {
					label = ("SEProject ("
							+ ((SEProject) tempObj).getDescription() + ")");
				} else if (tempObj instanceof RequirementsCaptureTool) {
					label = ("RequirementsCaptureTool ("
							+ ((RequirementsCaptureTool) tempObj).getName() + ")");
				} else if (tempObj instanceof DesignEnvironment) {
					label = ("DesignEnvironment ("
							+ ((DesignEnvironment) tempObj).getName() + ")");
				} else if (tempObj instanceof IDE) {
					label = ("IDE (" + ((IDE) tempObj).getName() + ")");
				} else if (tempObj instanceof AutomatedTestingTool) {
					label = ("AutomatedTestingTool ("
							+ ((AutomatedTestingTool) tempObj).getName() + ")");
				} else if (tempObj instanceof ACustomer) {
					label = ("ACustomer (" + ((ACustomer) tempObj).getName() + ")");
				}
				BorderPane tempPane = new BorderPane();
				CheckBox tempCheckBox = new CheckBox(label);
				tempPane.setLeft(tempCheckBox);
				checkBoxes.add(tempCheckBox);
				ImageView icon = ImageLoader.getImageFromURL(TabPanel.getImage(tempObj));
				tempPane.setRight(new Label("", icon));
				middlePane.getChildren().add(tempPane);
			}
			Pane checkPane = new Pane();
			checkAllButton = new Button("Check All");
			checkAllButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
			checkPane.getChildren().add(checkAllButton);
			clearAllButton = new Button("Clear All");
			clearAllButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
			checkPane.getChildren().add(clearAllButton);
			Pane bottomPane = new Pane();
			okButton = new Button("OK");
			okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
			bottomPane.getChildren().add(okButton);
			cancelButton = new Button("Cancel");
			cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
			bottomPane.getChildren().add(cancelButton);
			mainPane.getChildren().addAll(topPane, middlePane);
			Separator separator1 = new Separator();
			separator1.setMaxSize(900, 1);
			mainPane.getChildren().addAll(separator1, checkPane);
			Separator separator2 = new Separator();
			separator2.setMaxSize(900, 1);
			mainPane.getChildren().addAll(separator2, bottomPane);
			this.setOnCloseRequest(new ExitListener());
//			setContentPane(mainPane);
//			validate();
//			pack();
//			repaint();
//			toFront();
			Point2D ownerLoc = new Point2D(owner.getX(), owner.getY());
			Point2D thisLoc = new Point2D((ownerLoc.getX() + (owner.getWidth() / 2) - (this.getWidth() / 2)),
					(ownerLoc.getY() + (owner.getHeight() / 2) - (this.getHeight() / 2)));
			this.setX(thisLoc.getX());
			this.setY(thisLoc.getY());
			show();
		} else if ((selectedEmp == null)
				&& (participants.size() == minNumParts)) {
			for (int i = 0; i < participants.size(); i++) {
				Employee tempEmp = (Employee) participants.elementAt(i);
				if (action instanceof CreateRequirementsAction) {
					if (partName.equals("Emp")) {
						((CreateRequirementsAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof ReviewRequirementsAction) {
					if (partName.equals("Emp")) {
						((ReviewRequirementsAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof CorrectRequirementsAction) {
					if (partName.equals("Emp")) {
						((CorrectRequirementsAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof CreateDesignAction) {
					if (partName.equals("Emp")) {
						((CreateDesignAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof ReviewDesignAction) {
					if (partName.equals("Emp")) {
						((ReviewDesignAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof CorrectDesignAction) {
					if (partName.equals("Emp")) {
						((CorrectDesignAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof CreateCodeAction) {
					if (partName.equals("Emp")) {
						((CreateCodeAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof InspectCodeAction) {
					if (partName.equals("Emp")) {
						((InspectCodeAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof CorrectCodeAction) {
					if (partName.equals("Emp")) {
						((CorrectCodeAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof IntegrateCodeAction) {
					if (partName.equals("Emp")) {
						((IntegrateCodeAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof SystemTestAction) {
					if (partName.equals("Emp")) {
						((SystemTestAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof CreateSystemTestPlanAction) {
					if (partName.equals("Emp")) {
						((CreateSystemTestPlanAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof ReviewSystemTestPlanAction) {
					if (partName.equals("Emp")) {
						((ReviewSystemTestPlanAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof CorrectSystemTestPlanAction) {
					if (partName.equals("Emp")) {
						((CorrectSystemTestPlanAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof DeliverProductAction) {
					if (partName.equals("Emp")) {
						((DeliverProductAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof ChangePayRateAction) {
					if (partName.equals("Emp")) {
						((ChangePayRateAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof GiveBonusAction) {
					if (partName.equals("Emp")) {
						((GiveBonusAction) action).addEmp(tempEmp);
					}
				} else if (action instanceof FireAction) {
					if (partName.equals("FiredPerson")) {
						((FireAction) action).addFiredPerson(tempEmp);
					}
				} else if (action instanceof PurchaseToolAction) {
					if (partName.equals("EmpWhoseMenuClickedOn")) {
						((PurchaseToolAction) action)
								.addEmpWhoseMenuClickedOn(tempEmp);
					}
				}
			}
		}
		if (selectedEmp != null) {
			if (action instanceof CreateRequirementsAction) {
				if (partName.equals("Emp")) {
					((CreateRequirementsAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof ReviewRequirementsAction) {
				if (partName.equals("Emp")) {
					((ReviewRequirementsAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof CorrectRequirementsAction) {
				if (partName.equals("Emp")) {
					((CorrectRequirementsAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof CreateDesignAction) {
				if (partName.equals("Emp")) {
					((CreateDesignAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof ReviewDesignAction) {
				if (partName.equals("Emp")) {
					((ReviewDesignAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof CorrectDesignAction) {
				if (partName.equals("Emp")) {
					((CorrectDesignAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof CreateCodeAction) {
				if (partName.equals("Emp")) {
					((CreateCodeAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof InspectCodeAction) {
				if (partName.equals("Emp")) {
					((InspectCodeAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof CorrectCodeAction) {
				if (partName.equals("Emp")) {
					((CorrectCodeAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof IntegrateCodeAction) {
				if (partName.equals("Emp")) {
					((IntegrateCodeAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof SystemTestAction) {
				if (partName.equals("Emp")) {
					((SystemTestAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof CreateSystemTestPlanAction) {
				if (partName.equals("Emp")) {
					((CreateSystemTestPlanAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof ReviewSystemTestPlanAction) {
				if (partName.equals("Emp")) {
					((ReviewSystemTestPlanAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof CorrectSystemTestPlanAction) {
				if (partName.equals("Emp")) {
					((CorrectSystemTestPlanAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof DeliverProductAction) {
				if (partName.equals("Emp")) {
					((DeliverProductAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof ChangePayRateAction) {
				if (partName.equals("Emp")) {
					((ChangePayRateAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof GiveBonusAction) {
				if (partName.equals("Emp")) {
					((GiveBonusAction) action).addEmp(selectedEmp);
				}
			} else if (action instanceof FireAction) {
				if (partName.equals("FiredPerson")) {
					((FireAction) action).addFiredPerson(selectedEmp);
				}
			} else if (action instanceof PurchaseToolAction) {
				if (partName.equals("EmpWhoseMenuClickedOn")) {
					((PurchaseToolAction) action)
							.addEmpWhoseMenuClickedOn(selectedEmp);
				}
			}
		}
	}

	@Override
	public void handle(MouseEvent evt) {
		Object source = evt.getSource();
		if (source == cancelButton) {
			actionCancelled = true;
			close();
		} else if (source == okButton) {
			Vector<CheckBox> checkedBoxes = new Vector<CheckBox>();
			for (int i = 0; i < checkBoxes.size(); i++) {
				CheckBox tempCBox = checkBoxes.elementAt(i);
				if (tempCBox.isSelected()) {
					checkedBoxes.add(tempCBox);
				}
			}
			if (checkedBoxes.size() < minNumParts) {
				Alert alert = new Alert(AlertType.WARNING, "You must choose at least one action");
				alert.setTitle("Invalid Input");
				alert.show();
			} else if (checkedBoxes.size() > maxNumParts) {
				Alert alert = new Alert(AlertType.WARNING, "You may only choose at most " + maxNumParts + " participants");
				alert.setTitle("Invalid Input");
				alert.show();
			} else {
				for (int i = 0; i < checkedBoxes.size(); i++) {
					CheckBox checkedBox = checkedBoxes.elementAt(i);
					String cBoxText = checkedBox.getText();
					String objTypeName = cBoxText.substring(0,
							(cBoxText.indexOf('(') - 1));
					String keyValStr = cBoxText.substring(
							(cBoxText.indexOf('(') + 1),
							cBoxText.lastIndexOf(')'));

					addParticipant(objTypeName, keyValStr);
				}
				close();
			}
		} else if (source == checkAllButton) {
			for (int i = 0; i < checkBoxes.size(); i++) {
				checkBoxes.elementAt(i).setSelected(true);
			}
		} else if (source == clearAllButton) {
			for (int i = 0; i < checkBoxes.size(); i++) {
				checkBoxes.elementAt(i).setSelected(false);
			}
		}
	}

	private void addParticipant(String objTypeName, String keyValStr) {
		if (objTypeName.equals("SoftwareEngineer")) {
			SoftwareEngineer a = state.getEmployeeStateRepository()
					.getSoftwareEngineerStateRepository().get(keyValStr);
			if (a != null) {
				if (action instanceof CreateRequirementsAction) {
					if (partName.equals("Emp")) {
						((CreateRequirementsAction) action).addEmp(a);
					}
				} else if (action instanceof ReviewRequirementsAction) {
					if (partName.equals("Emp")) {
						((ReviewRequirementsAction) action).addEmp(a);
					}
				} else if (action instanceof CorrectRequirementsAction) {
					if (partName.equals("Emp")) {
						((CorrectRequirementsAction) action).addEmp(a);
					}
				} else if (action instanceof CreateDesignAction) {
					if (partName.equals("Emp")) {
						((CreateDesignAction) action).addEmp(a);
					}
				} else if (action instanceof ReviewDesignAction) {
					if (partName.equals("Emp")) {
						((ReviewDesignAction) action).addEmp(a);
					}
				} else if (action instanceof CorrectDesignAction) {
					if (partName.equals("Emp")) {
						((CorrectDesignAction) action).addEmp(a);
					}
				} else if (action instanceof CreateCodeAction) {
					if (partName.equals("Emp")) {
						((CreateCodeAction) action).addEmp(a);
					}
				} else if (action instanceof InspectCodeAction) {
					if (partName.equals("Emp")) {
						((InspectCodeAction) action).addEmp(a);
					}
				} else if (action instanceof CorrectCodeAction) {
					if (partName.equals("Emp")) {
						((CorrectCodeAction) action).addEmp(a);
					}
				} else if (action instanceof IntegrateCodeAction) {
					if (partName.equals("Emp")) {
						((IntegrateCodeAction) action).addEmp(a);
					}
				} else if (action instanceof SystemTestAction) {
					if (partName.equals("Emp")) {
						((SystemTestAction) action).addEmp(a);
					}
				} else if (action instanceof CreateSystemTestPlanAction) {
					if (partName.equals("Emp")) {
						((CreateSystemTestPlanAction) action).addEmp(a);
					}
				} else if (action instanceof ReviewSystemTestPlanAction) {
					if (partName.equals("Emp")) {
						((ReviewSystemTestPlanAction) action).addEmp(a);
					}
				} else if (action instanceof CorrectSystemTestPlanAction) {
					if (partName.equals("Emp")) {
						((CorrectSystemTestPlanAction) action).addEmp(a);
					}
				} else if (action instanceof DeliverProductAction) {
					if (partName.equals("Emp")) {
						((DeliverProductAction) action).addEmp(a);
					}
				} else if (action instanceof ChangePayRateAction) {
					if (partName.equals("Emp")) {
						((ChangePayRateAction) action).addEmp(a);
					}
				} else if (action instanceof GiveBonusAction) {
					if (partName.equals("Emp")) {
						((GiveBonusAction) action).addEmp(a);
					}
				} else if (action instanceof FireAction) {
					if (partName.equals("FiredPerson")) {
						((FireAction) action).addFiredPerson(a);
					}
				} else if (action instanceof PurchaseToolAction) {
					if (partName.equals("EmpWhoseMenuClickedOn")) {
						((PurchaseToolAction) action)
								.addEmpWhoseMenuClickedOn(a);
					}
				}
			}
		}
	}

	private void setMinAndMax() {
		if (action instanceof CreateRequirementsAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("ReqDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("RequirementsCaptureTool")) {
				minNumParts = 0;
				maxNumParts = 999999;
			} else if (partName.equals("AssociatedCodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedDesignDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedSystemTestPlan")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof ReviewRequirementsAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("RequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof CorrectRequirementsAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("RequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("RequirementsCaptureTool")) {
				minNumParts = 0;
				maxNumParts = 999999;
			}
		} else if (action instanceof CreateDesignAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("DesignDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("DesignEnvironment")) {
				minNumParts = 0;
				maxNumParts = 999999;
			} else if (partName.equals("AssociatedCodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof ReviewDesignAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("DesignDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof CorrectDesignAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("DesignDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("DesignEnvironment")) {
				minNumParts = 0;
				maxNumParts = 999999;
			}
		} else if (action instanceof CreateCodeAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("CodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedDesignDocument")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("DevelopmentEnvironment")) {
				minNumParts = 0;
				maxNumParts = 999999;
			} else if (partName.equals("AssociatedSystemTestPlan")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof InspectCodeAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 3;
					maxNumParts = 999999;
				} else {
					minNumParts = 3 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("CodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedDesignDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof CorrectCodeAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("CodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedDesignDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("DevelopmentEnvironment")) {
				minNumParts = 0;
				maxNumParts = 999999;
			}
		} else if (action instanceof IntegrateCodeAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("CodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedDesignDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("DevelopmentEnvironment")) {
				minNumParts = 0;
				maxNumParts = 999999;
			}
		} else if (action instanceof SystemTestAction) {
			if (partName.equals("CodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("AssociatedSystemTestPlan")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("TestingTool")) {
				minNumParts = 0;
				maxNumParts = 999999;
			}
		} else if (action instanceof CreateSystemTestPlanAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("AssociatedCodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("SystemTestPlanDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("TestingTool")) {
				minNumParts = 0;
				maxNumParts = 999999;
			}
		} else if (action instanceof ReviewSystemTestPlanAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("TestPlan")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof CorrectSystemTestPlanAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("TestPlan")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("TestingTool")) {
				minNumParts = 0;
				maxNumParts = 999999;
			}
		} else if (action instanceof DeliverProductAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 1;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 1 - 1;
				}

			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("CodeDoc")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Cust")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof BreakAction) {
			if (partName.equals("Breaker")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 1;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 1 - 1;
				}

			}
		} else if (action instanceof GetSickAction) {
			if (partName.equals("SickPerson")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 1;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 1 - 1;
				}

			}
		} else if (action instanceof QuitAction) {
			if (partName.equals("Quitter")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 1;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 1 - 1;
				}

			}
		} else if (action instanceof IntroduceNewRequirementsAction) {
			if (partName.equals("Cust")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedRequirementsDocument")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("EmpWOverheadText")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			} else if (partName.equals("AssociatedCode")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedDesignDocument")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("AssociatedSystemTestPlan")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof UpdateProjectAttributesAction) {
			if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			}
		} else if (action instanceof ChangePayRateAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 1;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 1 - 1;
				}

			}
		} else if (action instanceof GiveBonusAction) {
			if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 1;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 1 - 1;
				}

			} else if (partName.equals("ProjectWithBudget")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof FireAction) {
			if (partName.equals("FiredPerson")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 1;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 1 - 1;
				}

			}
		} else if (action instanceof PurchaseToolAction) {
			if (partName.equals("EmpWhoseMenuClickedOn")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 1;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 1 - 1;
				}

			} else if (partName.equals("SETool")) {
				minNumParts = 1;
				maxNumParts = 999999;
			} else if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			}
		} else if (action instanceof SuggestedRequirementsPhaseDurationAction) {
			if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			}
		} else if (action instanceof SuggestedDesignPhaseDurationAction) {
			if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			}
		} else if (action instanceof SuggestedImplIntegrationPhaseDurationAction) {
			if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			}
		} else if (action instanceof SuggestedTestingPhaseDurationAction) {
			if (partName.equals("Proj")) {
				minNumParts = 1;
				maxNumParts = 1;
			} else if (partName.equals("Emp")) {
				if (selectedEmp == null) {
					minNumParts = 1;
					maxNumParts = 999999;
				} else {
					minNumParts = 1 - 1;
					maxNumParts = 999999;
				}

			}
		}
	}

	public boolean actionCancelled() {
		return actionCancelled;
	}

	public class ExitListener implements EventHandler<WindowEvent> {
		@Override
		public void handle(WindowEvent evt) {
			actionCancelled = true;
		}
	}

}
