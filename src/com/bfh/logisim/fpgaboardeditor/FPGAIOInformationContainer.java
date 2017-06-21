/*******************************************************************************
 * This file is part of logisim-evolution.
 *
 *   logisim-evolution is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   logisim-evolution is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   Original code by Carl Burch (http://www.cburch.com), 2011.
 *   Subsequent modifications by :
 *     + Haute École Spécialisée Bernoise
 *       http://www.bfh.ch
 *     + Haute École du paysage, d'ingénierie et d'architecture de Genève
 *       http://hepia.hesge.ch/
 *     + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 *       http://www.heig-vd.ch/
 *   The project is currently maintained by :
 *     + REDS Institute - HEIG-VD
 *       Yverdon-les-Bains, Switzerland
 *       http://reds.heig-vd.ch
 *******************************************************************************/

package com.bfh.logisim.fpgaboardeditor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.help.UnsupportedOperationException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.antlr.grammar.v3.ANTLRv3Parser.throwsSpec_return;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.bfh.logisim.hdlgenerator.HDLGeneratorFactory;
import com.cburch.logisim.proj.Projects;
import com.cburch.logisim.std.io.DipSwitch;
import com.cburch.logisim.std.io.PortIO;
import com.cburch.logisim.std.io.RGBLed;
import com.cburch.logisim.std.io.ReptarLocalBus;
import com.cburch.logisim.std.io.SevenSegment;

public class FPGAIOInformationContainer {

	public static enum IOComponentTypes {

		LED, Button, Pin, SevenSegment, DIPSwitch, KeyPad, RGBLED, PortIO, LocalBus, Bus, Unknown;
		
		public static IOComponentTypes getEnumFromString(String str) {
			for (IOComponentTypes elem : KnownComponentSet) {
				if (elem.name().equalsIgnoreCase(str)) {
					return elem;
				}
			}
			return IOComponentTypes.Unknown;
		}

		public static final int GetFPGAInOutRequirement(IOComponentTypes comp) {
			switch (comp) {
			case PortIO:
				return nbSwitch;
			case KeyPad:
				return 0;
			case LocalBus:
				return 16;
			default:
				return 0;
			}
		}

		public static final int GetFPGAInputRequirement(IOComponentTypes comp) {
			switch (comp) {
			case Button:
				return 1;
			case KeyPad:
				return 4;
			case DIPSwitch:
				return nbSwitch;
			case LocalBus:
				return 12;
			default:
				return 0;
			}
		}

		public static final int GetFPGAOutputRequirement(IOComponentTypes comp) {
			switch (comp) {
			case LED:
				return 1;
			case SevenSegment:
				return 8;
			case KeyPad:
				return 4;
			case RGBLED:
				return 3;
			case LocalBus:
				return 2;
			default:
				return 0;
			}
		}

		public static final int GetNrOfFPGAPins(IOComponentTypes comp) {
			switch (comp) {
			case LED:
			case Button:
			case Pin:
				return 1;
			case KeyPad:
				//FIXEM
				return 8;
			case DIPSwitch:
			case PortIO:
				return nbSwitch;
			case SevenSegment:
				return 8;
			case RGBLED:
				return 3;
			case LocalBus:
				return 30;
			default:
				return 0;
			}
		}

		public static final EnumSet<IOComponentTypes> KnownComponentSet = EnumSet
				.range(IOComponentTypes.LED, IOComponentTypes.LocalBus);

		public static final EnumSet<IOComponentTypes> SimpleInputSet = EnumSet
				.range(IOComponentTypes.LED, IOComponentTypes.LocalBus);

		public static final EnumSet<IOComponentTypes> InputComponentSet = EnumSet
				.of(IOComponentTypes.Button, IOComponentTypes.Pin,
						IOComponentTypes.DIPSwitch);

		public static final EnumSet<IOComponentTypes> OutputComponentSet = EnumSet
				.of(IOComponentTypes.LED, IOComponentTypes.Pin,
						IOComponentTypes.RGBLED, IOComponentTypes.SevenSegment);

		public static final EnumSet<IOComponentTypes> InOutComponentSet = EnumSet
				.of(IOComponentTypes.Pin, IOComponentTypes.PortIO);

		private static int nbSwitch = 8;

		private void setNbSwitch(int nb) {
			nbSwitch = nb;
		}
	}

	/*
	 * Bus is just a placeholder for a multi-bit pin. It should not be used for
	 * mappable components
	 */

	public static LinkedList<String> GetComponentTypes() {
		LinkedList<String> result = new LinkedList<String>();
		for (IOComponentTypes comp : IOComponentTypes.KnownComponentSet) {
			result.add(comp.toString());
		}
		return result;
	};

	final static Logger logger = LoggerFactory
			.getLogger(FPGAIOInformationContainer.class);

	private IOComponentTypes type;
	private long identifier;
	private BoardRectangle rectangle;
	private Map<Integer, String> inputPinLocations;
	private Map<Integer, String> outputPinLocations;
	private Map<Integer, String> inoutPinLocations;
	
	private int nrOfPins;
	private char pullBehavior;
	private char activityLevel;
	private char pinIOStandard;
	private char driveStrength;

	private boolean abort = false;


	public FPGAIOInformationContainer() {
		type = IOComponentTypes.Unknown;
		identifier = -1;
		rectangle = null;
		inputPinLocations =new HashMap<Integer, String>();
		outputPinLocations =new HashMap<Integer, String>();
		inoutPinLocations =   new HashMap<Integer, String>();
		
		nrOfPins = 0;
		pullBehavior = PullBehaviors.Unknown;
		activityLevel = PinActivity.Unknown;
		pinIOStandard = IoStandards.Unknown;
		driveStrength = DriveStrength.Unknown;
	}

	public FPGAIOInformationContainer(IOComponentTypes Type,
			BoardRectangle rect, BoardDialog parent) {
		type = Type;
		identifier = -1;
		rectangle = rect;
		inputPinLocations =new HashMap<Integer, String>();
		outputPinLocations =new HashMap<Integer, String>();
		inoutPinLocations =   new HashMap<Integer, String>();
		nrOfPins = 0;
		pullBehavior = PullBehaviors.Unknown;
		activityLevel = PinActivity.Unknown;
		pinIOStandard = IoStandards.Unknown;
		driveStrength = DriveStrength.Unknown;
		if (IOComponentTypes.SimpleInputSet.contains(Type)) {
			if (type.equals(IOComponentTypes.DIPSwitch)
					|| type.equals(IOComponentTypes.PortIO)) {
				GetSizeInformationDialog(parent);
			}
			GetSimpleInformationDialog(parent);
			return;
		}

		type = IOComponentTypes.Unknown;
	}


	public FPGAIOInformationContainer(Node DocumentInfo) {
		/*
		 * This constructor is used to create an element during the reading of a
		 * board information xml file
		 */
		type = IOComponentTypes.Unknown;
		identifier = -1;
		rectangle = null;
		inputPinLocations =new HashMap<Integer, String>();
		outputPinLocations =new HashMap<Integer, String>();
		inoutPinLocations =   new HashMap<Integer, String>();

		nrOfPins = 0;
		pullBehavior = PullBehaviors.Unknown;
		activityLevel = PinActivity.Unknown;
		pinIOStandard = IoStandards.Unknown;
		driveStrength = DriveStrength.Unknown;
		IOComponentTypes SetId = IOComponentTypes
				.getEnumFromString(DocumentInfo.getNodeName());
		if (IOComponentTypes.KnownComponentSet.contains(SetId)) {
			type = SetId;
		} else {
			return;
		}
		NamedNodeMap Attrs = DocumentInfo.getAttributes();
		int x = -1, y = -1, width = -1, height = -1;
		for (int i = 0; i < Attrs.getLength(); i++) {
			Node ThisAttr = Attrs.item(i);
			String nodeName = ThisAttr.getNodeName();
			String nodeValue = ThisAttr.getNodeValue();
			if (nodeName.equals(BoardWriterClass.LocationXString)) {
				x = Integer.parseInt(nodeValue);
			}
			if (nodeName.equals(BoardWriterClass.LocationYString)) {
				y = Integer.parseInt(nodeValue);
			}
			if (nodeName.equals(BoardWriterClass.WidthString)) {
				width = Integer.parseInt(nodeValue);
			}
			if (nodeName.equals(BoardWriterClass.HeightString)) {
				height = Integer.parseInt(nodeValue);
			}
			if (nodeName.equals(BoardWriterClass.PinLocationString)) {
				nrOfPins = 1;
				String nodeval = nodeValue;
				if (nodeval.startsWith("IN:")) {
					nodeval=nodeval.substring(3);
					inputPinLocations.put(0,nodeval);
				} else if (nodeval.startsWith("OUT:")) {
					nodeval=nodeval.substring(4);
					outputPinLocations.put(0,nodeval);
				} else if (nodeval.startsWith("INOUT:")) {
					nodeval=nodeval.substring(6);
					inoutPinLocations.put(0,nodeval);
				} else {
					inoutPinLocations.put(0,nodeval);
					System.err.println("[WARNING] no I/O direction for "+nodeval);
				}
		
			}
			if (nodeName.equals(
					BoardWriterClass.MultiPinInformationString)) {
				nrOfPins = Integer.parseInt(nodeValue);
			}
			if (nodeName.startsWith(
					BoardWriterClass.MultiPinPrefixString)) {
				String Id = nodeName.substring(
						BoardWriterClass.MultiPinPrefixString.length());
				String nodeval = nodeValue;
				int id = Integer.parseInt(Id);
				if (nodeval.startsWith("IN:")) {
					nodeval=nodeval.substring(3);
					inputPinLocations.put(id,nodeval);
				} else if (nodeval.startsWith("OUT:")) {
					nodeval=nodeval.substring(4);
					outputPinLocations.put(id,nodeval);
				} else if (nodeval.startsWith("INOUT:")) {
					nodeval=nodeval.substring(6);
					inoutPinLocations.put(id,nodeval);
				} else {
					inoutPinLocations.put(id,nodeval);
					System.err.println("[WARNING] no I/O direction for "+nodeval);
				}
			}
			if (nodeName.equals(
					DriveStrength.DriveAttributeString)) {
				driveStrength = DriveStrength.getId(nodeValue);
			}
			if (nodeName.equals(PullBehaviors.PullAttributeString)) {
				pullBehavior = PullBehaviors.getId(nodeValue);
			}
			if (nodeName.equals(IoStandards.IOAttributeString)) {
				pinIOStandard = IoStandards.getId(nodeValue);
			}
			if (nodeName.equals(PinActivity.ActivityAttributeString)) {
				activityLevel = PinActivity.getId(nodeValue);
			}
		}
		if ((x < 0) || (y < 0) || (width < 1) || (height < 1)) {
			type = IOComponentTypes.Unknown;
			return;
		}
		boolean PinsComplete = true;
		for (int i = 0; i < nrOfPins; i++) {
			boolean outDefined = outputPinLocations.containsKey(i);
			boolean inoutDefined = inoutPinLocations.containsKey(i);
			boolean inputDefined = inputPinLocations.containsKey(i);
			if (!outDefined && !inoutDefined && !inputDefined ) {
				logger.warn("Bizar missing pin {} of component!", i);
				PinsComplete = false;
			}
		}
		if (!PinsComplete) {
			type = IOComponentTypes.Unknown;
			return;
		}
		if (type.equals(IOComponentTypes.DIPSwitch)
				|| type.equals(IOComponentTypes.PortIO)) {
			type.setNbSwitch(nrOfPins);
		}
		if (type.equals(IOComponentTypes.Pin))
			activityLevel = PinActivity.ActiveHigh;
		rectangle = new BoardRectangle(x, y, width, height);
	}
	
	public void edit(BoardDialog parent) {
		if (!defined())
			return;
		if (type.equals(IOComponentTypes.DIPSwitch)
				|| type.equals(IOComponentTypes.PortIO)) {
			GetSizeInformationDialog(parent);
		}
		GetSimpleInformationDialog(parent);
	}

	public Boolean defined() {
		return identifier != -1;
	}

	public char GetActivityLevel() {
		return activityLevel;
	}

	private String getPinLocation(int i) {
		if (inputPinLocations.containsKey(i)) {
			return inputPinLocations.get(i);
		}
		if (inoutPinLocations.containsKey(i)) {
			return inoutPinLocations.get(i);
		}
		if (outputPinLocations.containsKey(i)) {
			return outputPinLocations.get(i);
		}
		return null;
	}
	
	private ArrayList<String> GetAlteraPinStrings(String direction, int StartId) {
		/*
		 * for the time being we ignore the InputPins variable. It has to be
		 * implemented for more complex components
		 */
		String baseNetName =  "";
		ArrayList<String> Contents = new ArrayList<String>();
		int nbInputs = inputPinLocations.size();
		int nbOutputs = outputPinLocations.size();
		int nbInoutputs = inoutPinLocations.size();
		int offset = 0;
		Map<Integer, String> pinLocMap =null;
		if (direction == "in") {
			baseNetName = HDLGeneratorFactory.FPGAInputPinName + "_";
			pinLocMap = inputPinLocations;
		} else if (direction == "inout") {
			baseNetName = HDLGeneratorFactory.FPGAInOutPinName + "_";
			pinLocMap = inoutPinLocations;
			offset = nbInputs;
		} else if (direction == "out") {
			baseNetName = HDLGeneratorFactory.FPGAOutputPinName + "_";
			pinLocMap = outputPinLocations;
			offset = nbInputs+nbInoutputs;
		}
		
		for (int i : pinLocMap.keySet()) {
			String netName = baseNetName + Integer.toString(StartId + i-offset);
			String pinloc = pinLocMap.get(i);
			Contents.add("    set_location_assignment " + pinloc + " -to " + netName);
			System.out.println("Warning : "+direction+" pin "+pinloc+" found for index "+i+ " and mapped to "+netName);
	
			if (pullBehavior == PullBehaviors.PullUp) {
				Contents.add("    set_instance_assignment -name WEAK_PULL_UP_RESISTOR ON -to " + netName);
			}
		}
		return Contents;
	}

	public Element GetDocumentElement(Document doc) {
		if (type.equals(IOComponentTypes.Unknown)) {
			return null;
		}
		try {
			Element result = doc.createElement(type.toString());
			result.setAttribute(BoardWriterClass.LocationXString,
					Integer.toString(rectangle.getXpos()));
			Attr ypos = doc.createAttribute(BoardWriterClass.LocationYString);
			ypos.setValue(Integer.toString(rectangle.getYpos()));
			result.setAttributeNode(ypos);
			Attr width = doc.createAttribute(BoardWriterClass.WidthString);
			width.setValue(Integer.toString(rectangle.getWidth()));
			result.setAttributeNode(width);
			Attr height = doc.createAttribute(BoardWriterClass.HeightString);
			height.setValue(Integer.toString(rectangle.getHeight()));
			result.setAttributeNode(height);
			if (nrOfPins == 1) {
				Attr loc = doc.createAttribute(BoardWriterClass.PinLocationString);
				//throw new UnsupportedOperationException("FIXME ");
				if (inoutPinLocations.containsKey(0)) {
					loc.setValue(inputPinLocations.get(0));
				} else if (outputPinLocations.containsKey(0)) {
					loc.setValue(outputPinLocations.get(0));
				} else if (inoutPinLocations.containsKey(0)) {
					loc.setValue(inputPinLocations.get(0));
				}
				result.setAttributeNode(loc);
			} else {
				Attr NrPins = doc
						.createAttribute(BoardWriterClass.MultiPinInformationString);
				NrPins.setValue(""+nrOfPins);
				result.setAttributeNode(NrPins);
				for (int i = 0; i < nrOfPins; i++) {
					String PinName = BoardWriterClass.MultiPinPrefixString+ Integer.toString(i);
					Attr PinX = doc.createAttribute(PinName);
					if (inoutPinLocations.containsKey(0)) {
						PinX.setValue(inputPinLocations.get(0));
					} else if (outputPinLocations.containsKey(0)) {
						PinX.setValue(outputPinLocations.get(0));
					} else if (inoutPinLocations.containsKey(0)) {
						PinX.setValue(inputPinLocations.get(0));
					}
					result.setAttributeNode(PinX);
				}
			}
			if (driveStrength != DriveStrength.Unknown) {
				Attr drive = doc
						.createAttribute(DriveStrength.DriveAttributeString);
				drive.setValue(DriveStrength.Behavior_strings[driveStrength]);
				result.setAttributeNode(drive);
			}
			if (pullBehavior != PullBehaviors.Unknown) {
				Attr pull = doc
						.createAttribute(PullBehaviors.PullAttributeString);
				pull.setValue(PullBehaviors.Behavior_strings[pullBehavior]);
				result.setAttributeNode(pull);
			}
			if (pinIOStandard != IoStandards.Unknown) {
				Attr stand = doc.createAttribute(IoStandards.IOAttributeString);
				stand.setValue(IoStandards.Behavior_strings[pinIOStandard]);
				result.setAttributeNode(stand);
			}
			if (activityLevel != PinActivity.Unknown) {
				Attr act = doc
						.createAttribute(PinActivity.ActivityAttributeString);
				act.setValue(PinActivity.Behavior_strings[activityLevel]);
				result.setAttributeNode(act);
			}
			return result;
		} catch (Exception e) {
			/* TODO: handle exceptions */
			logger.error(
					"Exceptions not handled yet in GetDocumentElement(), but got an exception: {}",
					e.getMessage());
		}
		return null;
	}

	public char GetDrive() {
		return driveStrength;
	}

	public long GetId() {
		return identifier;
	}

	public char GetIOStandard() {
		return pinIOStandard;
	}

	public int getNrOfPins() {
		return nrOfPins;
	}

	public ArrayList<String> GetPinlocStrings(int Vendor, String direction,
			int StartId) {
		if (Vendor == FPGAClass.VendorXilinx) {
			return GetXilinxUCFStrings(direction, StartId);
		}
		if (Vendor == FPGAClass.VendorAltera) {
			return GetAlteraPinStrings(direction, StartId);
		}
		if (Vendor == FPGAClass.VendorVivado) {
			return GetVivadoXDCStrings(direction, StartId);
		}
		return new ArrayList<String>();
	}

	public char GetPullBehavior() {
		return pullBehavior;
	}

	public BoardRectangle GetRectangle() {
		return rectangle;
	}

	private void GetSimpleInformationDialog(BoardDialog parent) {
		int NrOfDevicePins = IOComponentTypes.GetNrOfFPGAPins(type);
		final JDialog selWindow = new JDialog(parent.GetPanel(), type
				+ " properties");
		JComboBox<String> DriveInput = new JComboBox<>(
				DriveStrength.Behavior_strings);
		JComboBox<String> PullInput = new JComboBox<>(
				PullBehaviors.Behavior_strings);
		JComboBox<String> ActiveInput = new JComboBox<>(
				PinActivity.Behavior_strings);
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("cancel")) {
					type = IOComponentTypes.Unknown;
					abort = true;
				}
				selWindow.setVisible(false);
			}
		};
		GridBagLayout dialogLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		selWindow.setLayout(dialogLayout);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridy = -1;
		ArrayList<JTextField> LocInputs = new ArrayList<JTextField>();
		ArrayList<String> PinLabels;
		switch (type) {
		case SevenSegment:
			PinLabels = SevenSegment.GetLabels();
			break;
		case RGBLED:
			PinLabels = RGBLed.GetLabels();
			break;
		case DIPSwitch:
			PinLabels = DipSwitch.GetLabels(NrOfDevicePins);
			break;
		case KeyPad:
			PinLabels = DipSwitch.GetLabels(NrOfDevicePins);
			break;
		case PortIO:
			PinLabels = PortIO.GetLabels(NrOfDevicePins);
			break;
		case LocalBus:
			PinLabels = ReptarLocalBus.GetLabels();
			break;
		default:
			PinLabels = new ArrayList<String>();
			if (NrOfDevicePins == 1) {
				PinLabels.add("FPGA pin");
			} else {
				for (int i = 0; i < NrOfDevicePins; i++) {
					PinLabels.add("pin " + i);
				}
			}
		}
		int offset = 0;
		int oldY = c.gridy;
		int maxY = -1;
		for (int i = 0; i < NrOfDevicePins; i++) {
			if (i % 32 == 0) {
				offset = (i / 32) * 2;
				c.gridy = oldY;
			}
			JLabel LocText = new JLabel("Specify " + PinLabels.get(i)
					+ " location:");
			c.gridx = 0 + offset;
			c.gridy++;
			selWindow.add(LocText, c);
			JTextField txt = new JTextField(6);
			if (defined()) {
				throw new UnsupportedOperationException("NYI");
				//txt.setText(pinLocations.get(i));
			}
			LocInputs.add(txt);
			c.gridx = 1 + offset;
			selWindow.add(LocInputs.get(i), c);
			maxY = c.gridy > maxY ? c.gridy : maxY;
		}
		c.gridy = maxY;

		JLabel StandardText = new JLabel("Specify FPGA pin standard:");
		c.gridy++;
		c.gridx = 0;
		selWindow.add(StandardText, c);
		JComboBox<String> StandardInput = new JComboBox<>(
				IoStandards.Behavior_strings);
		if (defined())
			StandardInput.setSelectedIndex(pinIOStandard);
		else
			StandardInput.setSelectedIndex(parent.GetDefaultStandard());
		c.gridx = 1;
		selWindow.add(StandardInput, c);

		if (IOComponentTypes.OutputComponentSet.contains(type)) {
			JLabel DriveText = new JLabel("Specify FPGA pin drive strength:");
			c.gridy++;
			c.gridx = 0;
			selWindow.add(DriveText, c);
			if (defined())
				DriveInput.setSelectedIndex(driveStrength);
			else
				DriveInput.setSelectedIndex(parent.GetDefaultDriveStrength());
			c.gridx = 1;
			selWindow.add(DriveInput, c);
		}

		if (IOComponentTypes.InputComponentSet.contains(type)) {
			JLabel PullText = new JLabel("Specify FPGA pin pull behavior:");
			c.gridy++;
			c.gridx = 0;
			selWindow.add(PullText, c);
			if (defined())
				PullInput.setSelectedIndex(pullBehavior);
			else
				PullInput.setSelectedIndex(parent.GetDefaultPullSelection());
			c.gridx = 1;
			selWindow.add(PullInput, c);
		}

		if (!IOComponentTypes.InOutComponentSet.contains(type)) {
			JLabel ActiveText = new JLabel("Specify " + type + " activity:");
			c.gridy++;
			c.gridx = 0;
			selWindow.add(ActiveText, c);
			if (defined())
				ActiveInput.setSelectedIndex(activityLevel);
			else
				ActiveInput.setSelectedIndex(parent.GetDefaultActivity());
			c.gridx = 1;
			selWindow.add(ActiveInput, c);
		}

		JButton OkayButton = new JButton("Done and Store");
		OkayButton.setActionCommand("done");
		OkayButton.addActionListener(actionListener);
		c.gridx = 0;
		c.gridy++;
		selWindow.add(OkayButton, c);

		JButton CancelButton = new JButton("Cancel");
		CancelButton.setActionCommand("cancel");
		CancelButton.addActionListener(actionListener);
		c.gridx = 1;
		selWindow.add(CancelButton, c);
		selWindow.pack();
		selWindow.setLocation(Projects.getCenteredLoc(selWindow.getWidth(),
				selWindow.getHeight()));
		// PointerInfo mouseloc = MouseInfo.getPointerInfo();
		// Point mlocation = mouseloc.getLocation();
		// selWindow.setLocation(mlocation.x, mlocation.y);
		selWindow.setModal(true);
		selWindow.setResizable(false);
		selWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		selWindow.setAlwaysOnTop(true);
		abort = false;
		while (!abort) {
			selWindow.setVisible(true);
			if (!abort) {
				boolean correct = true;
				for (int i = 0; i < NrOfDevicePins; i++) {
					if (LocInputs.get(i).getText().isEmpty()) {
						correct = false;
						showDialogNotification(selWindow, "Error",
								"<html>You have to specify a location for "
										+ PinLabels.get(i) + "!</html>");
						continue;
					}
				}
				if (correct) {
					parent.SetDefaultStandard(StandardInput.getSelectedIndex());
					nrOfPins = NrOfDevicePins;
					for (int i = 0; i < NrOfDevicePins; i++) {
						throw new UnsupportedOperationException("NYI");
						//pinLocations.put(i, LocInputs.get(i).getText());
					}
					pinIOStandard = IoStandards.getId(StandardInput
							.getSelectedItem().toString());
					if (IOComponentTypes.OutputComponentSet.contains(type)) {
						parent.SetDefaultDriveStrength(DriveInput
								.getSelectedIndex());
						driveStrength = DriveStrength.getId(DriveInput
								.getSelectedItem().toString());
					}
					if (IOComponentTypes.InputComponentSet.contains(type)) {
						parent.SetDefaultPullSelection(PullInput
								.getSelectedIndex());
						pullBehavior = PullBehaviors.getId(PullInput
								.getSelectedItem().toString());
					}
					if (!IOComponentTypes.InOutComponentSet.contains(type)) {
						parent.SetDefaultActivity(ActiveInput
								.getSelectedIndex());
						activityLevel = PinActivity.getId(ActiveInput
								.getSelectedItem().toString());
					}
					abort = true;
				}
			}
		}
		selWindow.dispose();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void GetSizeInformationDialog(BoardDialog parent) {
		int NrOfDevicePins = IOComponentTypes.GetNrOfFPGAPins(type);
		int min = 1;
		int max = 1;
		String text = "null";

		switch (type) {
		case DIPSwitch:
			min = DipSwitch.MIN_SWITCH;
			max = DipSwitch.MAX_SWITCH;
			text = "switch";
			break;
		case PortIO:
			min = PortIO.MIN_IO;
			max = PortIO.MAX_IO;
			text = "pins";
			break;
		default:
			break;
		}

		final JDialog selWindow = new JDialog(parent.GetPanel(), type
				+ " number of " + text);
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("next")) {
					type.setNbSwitch(Integer.valueOf(((JComboBox) (selWindow
							.getContentPane().getComponents()[1]))
							.getSelectedItem().toString()));
					// setNrOfPins(Integer.valueOf(((JComboBox)(selWindow.getContentPane().getComponents()[1])).getSelectedItem().toString()));
					selWindow.dispose();
				}
				selWindow.setVisible(false);
			}
		};

		JComboBox size = new JComboBox<>();
		for (int i = min; i <= max; i++) {
			size.addItem(i);
		}
		size.setSelectedItem(NrOfDevicePins);
		GridBagLayout dialogLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		selWindow.setLayout(dialogLayout);
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel sizeText = new JLabel("Specify number of " + text + ": ");
		c.gridx = 0;
		c.gridy = 0;
		selWindow.add(sizeText, c);

		c.gridx = 1;
		selWindow.add(size, c);

		JButton nextButton = new JButton("Next");
		nextButton.setActionCommand("next");
		nextButton.addActionListener(actionListener);
		c.gridy++;
		selWindow.add(nextButton, c);
		selWindow.pack();
		selWindow.setLocation(Projects.getCenteredLoc(selWindow.getWidth(),
				selWindow.getHeight()));
		// PointerInfo mouseloc = MouseInfo.getPointerInfo();
		// Point mlocation = mouseloc.getLocation();
		// selWindow.setLocation(mlocation.x, mlocation.y);
		selWindow.setModal(true);
		selWindow.setResizable(false);
		selWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		selWindow.setAlwaysOnTop(true);
		selWindow.setVisible(true);
	}

	public IOComponentTypes GetType() {
		return type;
	}

	private ArrayList<String> GetXilinxUCFStrings(String direction, int StartId) {
		ArrayList<String> Contents = new ArrayList<String>();
		StringBuffer Temp = new StringBuffer();
		Integer start = 0;
		Integer end = nrOfPins;
		ArrayList<String> labels = null;
		if (type.equals(IOComponentTypes.PortIO)) {
			labels = PortIO.GetLabels(IOComponentTypes.GetNrOfFPGAPins(type));
		} else if (type.equals(IOComponentTypes.LocalBus)) {
			labels = ReptarLocalBus.GetLabels();
			if (direction.equals("in")) {
				end = IOComponentTypes.GetFPGAInputRequirement(type);
			} else if (direction.equals("out")) {
				// TODO: YSY
				Contents.add("NET \"FPGA_LB_OUT_0\" LOC = \"R24\" | IOSTANDARD = LVCMOS18 ; # SP6_LB_WAIT3_o");
				Contents.add("NET \"FPGA_LB_OUT_1\" LOC = \"AB30\" | IOSTANDARD = LVCMOS18 ; # IRQ_o");
				return Contents;
				// start = IOComponentTypes.GetFPGAInputRequirement(MyType);
				// end = start +
				// IOComponentTypes.GetFPGAOutputRequirement(MyType);
			} else if (direction.equals("inout")) {
				start = IOComponentTypes.GetFPGAInputRequirement(type)
						+ IOComponentTypes.GetFPGAOutputRequirement(type);
				end = start + IOComponentTypes.GetFPGAInOutRequirement(type);
			}
		} else if (type.equals(IOComponentTypes.DIPSwitch)) {
			labels = DipSwitch.GetLabels(IOComponentTypes
					.GetNrOfFPGAPins(type));
		} else if (type.equals(IOComponentTypes.SevenSegment)) {
			labels = SevenSegment.GetLabels();
		} else if (type.equals(IOComponentTypes.RGBLED)) {
			labels = RGBLed.GetLabels();
		}
		for (int i = start; i < end; i++) {
			Temp.setLength(0);
			
			Temp.append("LOC = \"" + getPinLocation(i) + "\" ");
			
			if (pullBehavior != PullBehaviors.Unknown
					&& pullBehavior != PullBehaviors.Float) {
				Temp.append("| "
						+ PullBehaviors
								.getContraintedPullString(pullBehavior) + " ");
			}
			if (driveStrength != DriveStrength.Unknown
					&& driveStrength != DriveStrength.DefaulStength) {
				Temp.append("| DRIVE = "
						+ DriveStrength
								.GetContraintedDriveStrength(driveStrength)
						+ " ");
			}
			if (pinIOStandard != IoStandards.Unknown
					&& pinIOStandard != IoStandards.DefaulStandard) {
				Temp.append("| IOSTANDARD = "
						+ IoStandards.GetConstraintedIoStandard(pinIOStandard)
						+ " ");
			}
			Temp.append(";");
			if (labels != null) {
				Temp.append(" # " + labels.get(i));
			}
			String NetName = "";
			if (direction == "in") {
				NetName = HDLGeneratorFactory.FPGAInputPinName + "_"
						+ Integer.toString(StartId + i - start);
			} else if (direction == "inout") {
				NetName = HDLGeneratorFactory.FPGAInOutPinName + "_"
						+ Integer.toString(StartId + i - start);
			} else {
				NetName = HDLGeneratorFactory.FPGAOutputPinName + "_"
						+ Integer.toString(StartId + i - start);
			}
			// String NetName = (InputPins) ?
			// HDLGeneratorFactory.FPGAInputPinName + "_" +
			// Integer.toString(StartId + i)
			// : HDLGeneratorFactory.FPGAOutputPinName + "_" +
			// Integer.toString(StartId + i);
			Contents.add("NET \"" + NetName + "\" " + Temp.toString());
		}
		return Contents;
	}

	private ArrayList<String> GetVivadoXDCStrings(String direction, int StartId) {
		ArrayList<String> contents = new ArrayList<String>();
		for (int i = 0; i < nrOfPins; i++) {
			String netName = "";
			if (direction.equals("in")) {
				netName = HDLGeneratorFactory.FPGAInputPinName + "_"
						+ Integer.toString(StartId + i);
			} else if (direction.equals("inout")) {
				netName = HDLGeneratorFactory.FPGAInOutPinName + "_"
						+ Integer.toString(StartId + i);
			} else {
				netName = HDLGeneratorFactory.FPGAOutputPinName + "_"
						+ Integer.toString(StartId + i);
			}
			contents.add("set_property PACKAGE_PIN " + getPinLocation(i) +
					" [get_ports {" + netName + "}]");
			contents.add("    set_property IOSTANDARD LVCMOS33 [get_ports {" + netName + "}]");
		}
		return contents;
	}

	public boolean IsInput() {
		return IOComponentTypes.InputComponentSet.contains(type);
	}

	public boolean IsInputOutput() {
		return IOComponentTypes.InOutComponentSet.contains(type);
	}

	public boolean IsKnownComponent() {
		return IOComponentTypes.KnownComponentSet.contains(type);
	}

	public boolean IsOutput() {
		return IOComponentTypes.OutputComponentSet.contains(type);
	}

	public void SetId(long id) {
		identifier = id;
	}

	public void setNrOfPins(int count) {
		if (GetType().equals(IOComponentTypes.DIPSwitch)
				|| GetType().equals(IOComponentTypes.PortIO)) {
			nrOfPins = count;
		}
	}

	private void showDialogNotification(JDialog parent, String type,
			String string) {
		final JDialog dialog = new JDialog(parent, type);
		JLabel pic = new JLabel();
		if (type.equals("Warning")) {
			pic.setIcon(new ImageIcon(getClass().getResource(
					BoardDialog.pictureWarning)));
		} else {
			pic.setIcon(new ImageIcon(getClass().getResource(
					BoardDialog.pictureError)));
		}
		GridBagLayout dialogLayout = new GridBagLayout();
		dialog.setLayout(dialogLayout);
		GridBagConstraints c = new GridBagConstraints();
		JLabel message = new JLabel(string);
		JButton close = new JButton("close");
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// panel.setAlwaysOnTop(true);
				dialog.dispose();
			}
		};
		close.addActionListener(actionListener);

		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 20;
		dialog.add(pic, c);

		c.gridx = 1;
		c.gridy = 0;
		dialog.add(message, c);

		c.gridx = 1;
		c.gridy = 1;
		dialog.add(close, c);
		dialog.pack();
		dialog.setLocationRelativeTo(parent);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);

	}
}
