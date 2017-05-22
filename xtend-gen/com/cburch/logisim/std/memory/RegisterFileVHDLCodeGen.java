package com.cburch.logisim.std.memory;

import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class RegisterFileVHDLCodeGen {
  /**
   * Constructor. Initialize the color to the default color and create the
   * ArrayList to hold the shapes.
   * @param defaultColor
   */
  public RegisterFileVHDLCodeGen() {
  }
  
  public void export(final FSM fsm, final File f) throws FileNotFoundException {
    final PrintStream ps = new PrintStream(f);
    CharSequence _generate = this.generate(fsm);
    ps.append(_generate);
    ps.close();
  }
  
  protected CharSequence _generate(final FSM e) {
    CharSequence _xblockexpression = null;
    {
      ArrayList<Port> ios = new ArrayList<Port>();
      EList<Port> _in = e.getIn();
      ios.addAll(_in);
      EList<Port> _out = e.getOut();
      ios.addAll(_out);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("library IEEE;");
      _builder.newLine();
      _builder.append("use IEEE.STD_LOGIC_1164.ALL;");
      _builder.newLine();
      _builder.append("use IEEE.NUMERIC_STD.ALL;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("entity REGFILE is port (");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("clk : in std_logic;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("rst : in std_logic;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("WE  : in std_logic;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("WAD  : in std_logic_vector(4 downto 0);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("DI  : in std_logic_vector(31 downto 0);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("RA0 : in std_logic_vector(4 downto 0);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("RA1 : in std_logic_vector(4 downto 0);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("DO0 : out std_logic_vector(31 downto 0);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("DO1 : out std_logic_vector(31 downto 0)");
      _builder.newLine();
      _builder.append(");");
      _builder.newLine();
      _builder.append("end entity;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("architecture RTL of REGFILE is");
      _builder.newLine();
      _builder.newLine();
      _builder.append(" \t\t\t");
      _builder.append("type RAM_type is ARRAY(0 to 31) of STD_LOGIC_VECTOR(31 downto 0);");
      _builder.newLine();
      _builder.append("    \t\t");
      _builder.append("signal RAM : RAM_type := (others => (others => \'0\'));");
      _builder.newLine();
      _builder.append("    \t\t");
      _builder.newLine();
      _builder.append("begin");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("DO0 <= RAM(to_integer(unsigned(RA0)));");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("DO1 <= RAM(to_integer(unsigned(RA1)));");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("process(CLK, RST) is");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("begin");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if rising_edge(CLK)  THEN");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("if (RST = \'1\') THEN");
      _builder.newLine();
      _builder.append("               \t");
      _builder.append("RAM <= (others => (others => \'0\'));");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("ELSIF (WE = \'1\') THEN");
      _builder.newLine();
      _builder.append("               \t");
      _builder.append("RAM(to_integer(unsigned(WAD))) <= DI;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("end if;");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("end if;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("end process;\t\t\t");
      _builder.newLine();
      _builder.newLine();
      _builder.append("end RTL;");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence generate(final FSM e) {
    return _generate(e);
  }
}
