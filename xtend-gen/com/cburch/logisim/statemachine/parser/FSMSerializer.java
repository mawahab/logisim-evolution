package com.cburch.logisim.statemachine.parser;

import com.cburch.logisim.statemachine.FSMDSLStandaloneSetup;
import com.cburch.logisim.statemachine.fSMDSL.FSM;
import com.cburch.logisim.statemachine.fSMDSL.FSMDSLPackage;
import com.cburch.logisim.statemachine.fSMDSL.Port;
import com.google.inject.Injector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * GecosScilabFrontend is a sample module. When the script evaluator encounters
 * the 'GecosScilabFrontend' function, it calls the compute method.
 */
@SuppressWarnings("all")
public class FSMSerializer {
  public static String saveAsString(final FSM fsm) {
    try {
      final ByteArrayOutputStream bos = new ByteArrayOutputStream();
      FSMSerializer.save(fsm, bos);
      byte[] _byteArray = bos.toByteArray();
      Charset _defaultCharset = Charset.defaultCharset();
      return new String(_byteArray, _defaultCharset);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        throw new RuntimeException("Could not serialize current Model to string");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static void saveToFile(final FSM fsm, final File f) {
    try {
      final FileOutputStream bos = new FileOutputStream(f);
      FSMSerializer.save(fsm, bos);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        throw new RuntimeException("Could not serialize current Model to string");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static void save(final FSM fsm, final OutputStream os) {
    try {
      FSMDSLStandaloneSetup instance = new FSMDSLStandaloneSetup();
      Injector injector = instance.createInjectorAndDoEMFRegistration();
      FSMDSLStandaloneSetup.doSetup();
      IResourceFactory factory = injector.<IResourceFactory>getInstance(IResourceFactory.class);
      URI _createURI = URI.createURI("internal.test");
      Resource _createResource = factory.createResource(_createURI);
      XtextResource resource = ((XtextResource) _createResource);
      EList<EObject> _contents = resource.getContents();
      _contents.add(fsm);
      HashMap saveOptions = new HashMap<Object, Object>();
      saveOptions.put(XtextResource.OPTION_FORMAT, Boolean.TRUE);
      resource.save(os, saveOptions);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        throw new RuntimeException("Could not serialize current Model to string");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static EObject parsePredicate(final FSM fsm, final String in) throws IOException {
    EList<Port> _in = fsm.getIn();
    final Function1<Port, String> _function = (Port p) -> {
      String _name = p.getName();
      String _plus = (_name + "[");
      int _width = p.getWidth();
      String _plus_1 = (_plus + Integer.valueOf(_width));
      return (_plus_1 + "]");
    };
    List<String> _map = ListExtensions.<Port, String>map(_in, _function);
    List<String> _list = IterableExtensions.<String>toList(_map);
    String _plus = ("" + _list);
    String _plus_1 = (_plus + in);
    String input = (_plus_1 + ";");
    byte[] _bytes = input.getBytes(StandardCharsets.UTF_8);
    InputStream fis = new ByteArrayInputStream(_bytes);
    return FSMSerializer.parse(fis);
  }
  
  public static EObject parseCommandList(final FSM fsm, final String in) throws IOException {
    EList<Port> _in = fsm.getIn();
    final Function1<Port, String> _function = (Port p) -> {
      String _name = p.getName();
      String _plus = (_name + "[");
      int _width = p.getWidth();
      String _plus_1 = (_plus + Integer.valueOf(_width));
      return (_plus_1 + "]");
    };
    List<String> _map = ListExtensions.<Port, String>map(_in, _function);
    List<String> _list = IterableExtensions.<String>toList(_map);
    String _plus = ("" + _list);
    EList<Port> _out = fsm.getOut();
    final Function1<Port, String> _function_1 = (Port p) -> {
      String _name = p.getName();
      String _plus_1 = (_name + "[");
      int _width = p.getWidth();
      String _plus_2 = (_plus_1 + Integer.valueOf(_width));
      return (_plus_2 + "]");
    };
    List<String> _map_1 = ListExtensions.<Port, String>map(_out, _function_1);
    List<String> _list_1 = IterableExtensions.<String>toList(_map_1);
    String _plus_1 = (_plus + _list_1);
    String _plus_2 = (_plus_1 + in);
    String input = (_plus_2 + ";");
    byte[] _bytes = input.getBytes(StandardCharsets.UTF_8);
    InputStream fis = new ByteArrayInputStream(_bytes);
    return FSMSerializer.parse(fis);
  }
  
  public static FSM load(final String in) throws IOException {
    byte[] _bytes = in.getBytes(StandardCharsets.UTF_8);
    InputStream fis = new ByteArrayInputStream(_bytes);
    EObject _parse = FSMSerializer.parse(fis);
    FSM fsm = ((FSM) _parse);
    return fsm;
  }
  
  public static FSM load(final File in) throws IOException {
    InputStream fis = new FileInputStream(in);
    EObject _parse = FSMSerializer.parse(fis);
    FSM fsm = ((FSM) _parse);
    return fsm;
  }
  
  public static EObject parse(final InputStream in) throws IOException {
    FSMDSLStandaloneSetup instance = new FSMDSLStandaloneSetup();
    Injector injector = instance.createInjectorAndDoEMFRegistration();
    FSMDSLStandaloneSetup.doSetup();
    XtextResourceSet rs = injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
    IResourceFactory factory = injector.<IResourceFactory>getInstance(IResourceFactory.class);
    URI _createURI = URI.createURI("internal.test");
    Resource _createResource = factory.createResource(_createURI);
    XtextResource r = ((XtextResource) _createResource);
    EPackage.Registry.INSTANCE.put(FSMDSLPackage.eNS_URI, FSMDSLPackage.eINSTANCE);
    EList<Resource> _resources = rs.getResources();
    _resources.add(r);
    r.load(in, null);
    EcoreUtil.resolveAll(r);
    EList<Resource.Diagnostic> _errors = r.getErrors();
    for (final Resource.Diagnostic error : _errors) {
      {
        System.err.println(error);
        StringConcatenation _builder = new StringConcatenation();
        String _message = error.getMessage();
        _builder.append(_message, "");
        _builder.append(" ");
        int _line = error.getLine();
        _builder.append(_line, "");
        throw new RuntimeException(_builder.toString());
      }
    }
    IParseResult _parseResult = r.getParseResult();
    _parseResult.getRootNode();
    IParseResult _parseResult_1 = r.getParseResult();
    EObject root = _parseResult_1.getRootASTElement();
    return root;
  }
}
