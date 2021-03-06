package group6.view;
import javax.swing.*;

import group6.controller.AircraftManagementDatabase;
import group6.util.UISettings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An interface to SAAMS:
 * Refuelling Supervisor Screen:
 * Inputs events from the Refuelling Supervisor, and displays aircraft information.
 * This class is a controller for the AircraftManagementDatabase: sending it messages to change the aircraft status information.
 * This class also registers as an observer of the AircraftManagementDatabase, and is notified whenever any change occurs in that <<model>> element.
 * See written documentation.
 * @stereotype boundary/view/controller
 * @url element://model:project::SAAMS/design:view:::id15rnfcko4qme4cko4swib
 * @url element://model:project::SAAMS/design:node:::id15rnfcko4qme4cko4swib.node107
 * @url element://model:project::SAAMS/design:view:::id3y5z3cko4qme4cko4sw81
 */

public class RefuellingSupervisor extends JFrame implements ActionListener {

	private final AircraftManagementDatabase aircraftManagementDatabase;
	/**
	 * Refuelling Supervisor interface has access to the AircraftManagementDatabase.
	 * 
	 * @supplierCardinality 1
	 * @clientCardinality 1
	 * @label accesses/observes
	 * @directed
	 */

	private JButton refuellingWait;
	private JButton refuellingComplete;

	public RefuellingSupervisor(AircraftManagementDatabase aircraftManagementDatabase) {
		this.aircraftManagementDatabase = aircraftManagementDatabase;
		
		setTitle("Refuelling Supervisor");
		setLocation(UISettings.RefuelingSupervisorPosition);
		setSize(UISettings.VIEW_WIDTH, UISettings.VIEW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout());
		
	        refuellingWait = new JButton("Await Refuelling");
	        window.add(refuellingWait);
	        refuellingWait.addActionListener(this);
		
	        refuellingComplete = new JButton("Done Refuelling");
	        window.add(refuellingComplete);
	        refuellingComplete.addActionListener(this);
		
	}

  @Override
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == refuellingWait) {
        managementRecord.getStatus();
        managementRecord.getFlightCode();
        display.setText(ManagementRecord.getStatus());
        display.setText(ManagementRecord.getFlightCode());
      }
       else if (e.getSource() == refuellingComplete) {
       }
  }
}