package com.cburch.logisim.statemachine.editor;

import com.cburch.logisim.statemachine.editor.commands.EditorCommand;
import com.cburch.logisim.statemachine.editor.view.FSMView;

public interface IEditorDialog {

	public FSMView getView();
	public EditorCommand getCommand();
}
