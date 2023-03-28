/* File generated by: simse.codegenerator.logicgenerator.dialoggenerator.EmployeeParticipantSelectionDialogGenerator */
package simse.logic.dialogs;

import java.util.Vector;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import simse.adts.actions.Action;
import simse.adts.actions.BreakAction;
import simse.adts.actions.ChangePayRateAction;
import simse.adts.actions.CorrectCodeAction;
import simse.adts.actions.CorrectDesignAction;
import simse.adts.actions.CorrectRequirementsAction;
import simse.adts.actions.CorrectSystemTestPlanAction;
import simse.adts.actions.CreateCodeAction;
import simse.adts.actions.CreateDesignAction;
import simse.adts.actions.CreateRequirementsAction;
import simse.adts.actions.CreateSystemTestPlanAction;
import simse.adts.actions.DeliverProductAction;
import simse.adts.actions.FireAction;
import simse.adts.actions.GetSickAction;
import simse.adts.actions.GiveBonusAction;
import simse.adts.actions.InspectCodeAction;
import simse.adts.actions.IntegrateCodeAction;
import simse.adts.actions.IntroduceNewRequirementsAction;
import simse.adts.actions.PurchaseToolAction;
import simse.adts.actions.QuitAction;
import simse.adts.actions.ReviewDesignAction;
import simse.adts.actions.ReviewRequirementsAction;
import simse.adts.actions.ReviewSystemTestPlanAction;
import simse.adts.actions.SuggestedDesignPhaseDurationAction;
import simse.adts.actions.SuggestedImplIntegrationPhaseDurationAction;
import simse.adts.actions.SuggestedRequirementsPhaseDurationAction;
import simse.adts.actions.SuggestedTestingPhaseDurationAction;
import simse.adts.actions.SystemTestAction;
import simse.adts.actions.UpdateProjectAttributesAction;
import simse.adts.objects.ACustomer;
import simse.adts.objects.AutomatedTestingTool;
import simse.adts.objects.Code;
import simse.adts.objects.DesignDocument;
import simse.adts.objects.DesignEnvironment;
import simse.adts.objects.Employee;
import simse.adts.objects.IDE;
import simse.adts.objects.RequirementsCaptureTool;
import simse.adts.objects.RequirementsDocument;
import simse.adts.objects.SEProject;
import simse.adts.objects.SSObject;
import simse.adts.objects.SoftwareEngineer;
import simse.adts.objects.SystemTestPlan;
import simse.gui.ImageLoader;
import simse.gui.TabPanel;
import simse.state.State;

public class EmployeeParticipantSelectionDialog extends Dialog<Action> implements EventHandler<MouseEvent> {
	private String partName;
	private Vector<SSObject> participants;
	private Action action;
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
	private boolean dialogAccepted;

	public EmployeeParticipantSelectionDialog(Stage owner, String pName,
			Vector<SSObject> parts, Action act, State s,
			Employee emp) {
		partName = pName;
		participants = parts;
		action = act;
		state = s;
		selectedEmp = emp;
		actionCancelled = false;
		dialogAccepted = false;
		setMinAndMax();
		if (((selectedEmp != null) && (maxNumParts > 0) && (participants.size() > 0))
				|| ((selectedEmp == null) && (participants.size() > minNumParts))) {
			checkBoxes = new Vector<CheckBox>();
			setTitle("Participant Selection");
			VBox mainPane = new VBox();
			VBox topPane = new VBox();
			String title = "Choose ";
			if (selectedEmp != null) {
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
			topPane.setMinWidth(400);
			VBox middlePane = new VBox();
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
//				ImageView icon = ImageLoader.getImageFromURL(TabPanel.getImage(tempObj));
				Vector<Employee> allEmp = state.getEmployeeStateRepository().getAll();
				for(int k = 0; k < allEmp.size(); k++) {
					if(allEmp.get(k).getName().equals(((SoftwareEngineer) tempObj).getName())) {
						ImageView icon = allEmp.get(k).getCharacterModel().getDisplayedCharacter(true);
						icon.setScaleX(1.5);
						icon.setScaleY(1.5);
						tempPane.setRight(new Label("", icon));
						middlePane.getChildren().add(tempPane);
					}
				}

			}			
			HBox checkPane = new HBox();
			checkAllButton = new Button("Check All");
			checkAllButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
			checkAllButton.setMinWidth(75);
			checkPane.getChildren().add(checkAllButton);
			clearAllButton = new Button("Clear All");
			clearAllButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
			clearAllButton.setMinWidth(75);
			checkPane.getChildren().add(clearAllButton);
			HBox bottomPane = new HBox();
			okButton = new Button("OK");
			okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
			okButton.setMinWidth(75);
			bottomPane.getChildren().add(okButton);
			cancelButton = new Button("Cancel");
			cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
			cancelButton.setMinWidth(75);
			bottomPane.getChildren().add(cancelButton);
			mainPane.getChildren().addAll(topPane, middlePane);
			Separator separator1 = new Separator();
			separator1.setMaxSize(900, 5);
			mainPane.getChildren().addAll(separator1, checkPane);
			Separator separator2 = new Separator();
			separator2.setMaxSize(900, 5);
			mainPane.getChildren().addAll(separator2, bottomPane);
			this.getDialogPane().getChildren().add(mainPane);
			this.getDialogPane().setPrefSize(400, 400);
			this.getDialogPane().getScene().getWindow().setOnCloseRequest(new ExitListener());
			
			Point2D ownerLoc = new Point2D(owner.getX(), owner.getY());
			Point2D thisLoc = new Point2D((ownerLoc.getX() + (owner.getWidth() / 2) - (this.getWidth() / 2)),
					(ownerLoc.getY() + (owner.getHeight() / 2) - (this.getHeight() / 2)));
			this.setX(thisLoc.getX());
			this.setY(thisLoc.getY());
			
			showAndWait();
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

	private void closeDialog(boolean accepted) {
		dialogAccepted = accepted;
		Window window = this.getDialogPane().getScene().getWindow();
		window.fireEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
	
	@Override
	public void handle(MouseEvent evt) {
		Object source = evt.getSource();
		if (source == cancelButton) {
			actionCancelled = true;
			closeDialog(false);
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
				alert.setHeaderText(null);
				alert.showAndWait();
			} else if (checkedBoxes.size() > maxNumParts) {
				Alert alert = new Alert(AlertType.WARNING, "You may only choose at most " + maxNumParts + " participants");
				alert.setTitle("Invalid Input");
				alert.setHeaderText(null);
				alert.showAndWait();
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
				closeDialog(true);
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
			if (!dialogAccepted) {
				actionCancelled = true;
			}
			close();
		}
	}

}
