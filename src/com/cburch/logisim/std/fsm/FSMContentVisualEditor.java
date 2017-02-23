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

package com.cburch.logisim.std.fsm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.cburch.logisim.proj.Project;
import com.cburch.logisim.statemachine.editor.view.FSMValidation;
import com.cburch.logisim.util.FileUtil;
import com.cburch.logisim.util.JInputDialog;
import com.cburch.logisim.util.LocaleListener;
import com.cburch.logisim.util.LocaleManager;

public class FSMContentVisualEditor extends JDialog implements JInputDialog, IFSMEditor {


	public FSMContent getContent() {
		return content;
	}

	public void setContent(FSMContent content) {
		this.content = content;
	}

	private class FrameListener extends WindowAdapter implements ActionListener, LocaleListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			if (source == validate) {  
				FSMValidation validator = new FSMValidation(content.getFsm());
				validator.validate(content.getFsm());
				String message = validator.getErrors().stream().map((x)->("Error:"+x)).reduce((x,y)->(x+'\n'+y)).get();
				message+=validator.getErrors().stream().map((x)->("Warning :"+x)).reduce((x,y)->(x+'\n'+y)).get();
				JOptionPane.showMessageDialog(FSMContentVisualEditor.this,
						message,
						Strings.get("fsmValidationWarning"),
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (source == switchView) {
				JOptionPane.showMessageDialog(FSMContentVisualEditor.this,
						"Switch to Text editor",
						Strings.get("fsmSaveError"),
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (source == close) { 
				dispose();
			}
		}

		@Override
		public void localeChanged() {
			setTitle(Strings.get("fsmFrameTitle"));
			open.setText(Strings.get("openButton"));
			save.setText(Strings.get("saveButton"));
			validate.setText(Strings.get("validateButton"));
			close.setText(Strings.get("closeButton"));
			switchView.setText(Strings.get("switchButton"));
		}

		@Override
		public void windowClosing(WindowEvent e) {
			dispose();

		}

	}

	private class ModelListener implements FSMModelListener {

		@Override
		public void contentSet(FSMContent source) {
			validate.setEnabled(false);
		}  

	}

	public static boolean confirmImport(Component parent) {
		String[] options = { Strings.get("importOption"),
				Strings.get("cancelOption") };
		return JOptionPane.showOptionDialog(parent,
				Strings.get("importMessage"), Strings.get("importTitle"), 0,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0;
	}


	private static final long serialVersionUID = 1L;


	private static final String EXPORT_DIR = null;


	private final int APPLET_WIDTH = 800, APPLET_HEIGHT = 700;



  

	
	private FrameListener frameListener = new FrameListener();
	private ModelListener modelListener = new ModelListener();

	private FSMContent content;
	private Project project;
	private FSMEditorWindow editor;

	private JButton open = new JButton();
	private JButton save = new JButton();
	private JButton validate = new JButton();
	private JButton switchView = new JButton();
	private JButton close = new JButton();


	public FSMContentVisualEditor(Dialog parent, Project proj, FSMContent model) {
		super(parent, Strings.get("hdlFrameTitle"), true);
		configure(proj, model);
	}

	public FSMContentVisualEditor(Frame parent, Project proj, FSMContent model) {
		super(parent, Strings.get("hdlFrameTitle"), true);
		configure(proj, model);
	}


	private void configure(Project proj, FSMContent model) {
		this.project = proj;
		this.content = model;
		this.content.addFSMModelListener(modelListener);
		this.addWindowListener(frameListener);

		System.out.println(this.toString()+":"+getWidth()+"x"+getHeight());
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(open);
		buttonsPanel.add(save);
		buttonsPanel.add(validate);
		buttonsPanel.add(close);
		buttonsPanel.add(switchView);
		
		open.addActionListener(frameListener);
		save.addActionListener(frameListener);
		close.addActionListener(frameListener);
		validate.addActionListener(frameListener);
		switchView.addActionListener(frameListener);
		
		editor = new FSMEditorWindow(model);		
		
		add(buttonsPanel, BorderLayout.SOUTH);
		add(editor, BorderLayout.CENTER);

		LocaleManager.addLocaleListener(frameListener);
		frameListener.localeChanged();
		setSize(APPLET_WIDTH, APPLET_HEIGHT);	

		pack(); 
		System.out.println(this.toString()+":"+getWidth()+"x"+getHeight());

	}

	private File getDefaultExportFile(File defaultFile) {
		File projectFile = project.getLogisimFile().getLoader().getMainFile();
		if (projectFile == null) {
			if (defaultFile == null)
				return new File(content.getName() + ".fsm");
			return defaultFile;
		}

		File compFolder;
		try {
			compFolder = new File(FileUtil.correctPath(projectFile
					.getParentFile().getCanonicalPath()) + EXPORT_DIR);
			if (!compFolder.exists()
					|| (compFolder.exists() && !compFolder.isDirectory()))
				compFolder.mkdir();
			return new File(FileUtil.correctPath(compFolder.getCanonicalPath())
					+ content.getName() + ".fsm");
		} catch (IOException ex) {
			return defaultFile;
		}
	}

	private File getDefaultImportFile(File defaultFile) {
		File projectFile = project.getLogisimFile().getLoader().getMainFile();
		if (projectFile == null)
			return defaultFile;

		File compFolder;
		try {
			compFolder = new File(FileUtil.correctPath(projectFile
					.getParentFile().getCanonicalPath()) + EXPORT_DIR);
			if (!compFolder.exists()
					|| (compFolder.exists() && !compFolder.isDirectory()))
				compFolder.mkdir();
			return new File(FileUtil.correctPath(compFolder.getCanonicalPath()));
		} catch (IOException ex) {
			return defaultFile;
		}
	}

	@Override
	public Object getValue() {
		return content.getContent();
	}

	@Override
	public void setValue(Object value) {
		content.updateContent(value.toString());
		
	}



}
