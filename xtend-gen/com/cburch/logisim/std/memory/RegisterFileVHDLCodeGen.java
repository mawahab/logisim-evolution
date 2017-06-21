package com.cburch.logisim.std.memory;

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
  
  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("library IEEE;");
    _builder.newLine();
    _builder.append("use IEEE.STD_LOGIC_1164.ALL;");
    _builder.newLine();
    _builder.append("use IEEE.NUMERIC_STD.ALL;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("architecture RTL of REGISTER_FILE is");
    _builder.newLine();
    _builder.newLine();
    _builder.append("type RAM_type is ARRAY(0 to 31) of STD_LOGIC_VECTOR(31 downto 0);");
    _builder.newLine();
    _builder.append("signal RAM : RAM_type := (others => (others => \'0\'));");
    _builder.newLine();
    _builder.newLine();
    _builder.append("begin");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("DO0 <= RAM(to_integer(unsigned(RAD0)));");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("DO1 <= RAM(to_integer(unsigned(RAD1)));");
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
    _builder.append("ELSIF (WE = \'1\' and Tick=\'1\') THEN");
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
    return _builder;
  }
}
