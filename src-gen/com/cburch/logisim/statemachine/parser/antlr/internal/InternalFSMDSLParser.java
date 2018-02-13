package com.cburch.logisim.statemachine.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.cburch.logisim.statemachine.services.FSMDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalFSMDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_BIN", "RULE_HEX", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "','", "']'", "';'", "'fsm'", "'state_machine'", "'{'", "'in'", "'out'", "'codeWidth'", "'='", "'reset'", "'}'", "'commands'", "'@'", "'state'", "'transitions'", "':'", "'set'", "'goto'", "'when'", "'->'", "'#'", "'default'", "'+'", "'.'", "'=='", "'/='", "'('", "')'", "'/'", "'define'"
    };
    public static final int RULE_HEX=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_BIN=6;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__44=44;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalFSMDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalFSMDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalFSMDSLParser.tokenNames; }
    public String getGrammarFileName() { return "../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g"; }



     	private FSMDSLGrammarAccess grammarAccess;
     	
        public InternalFSMDSLParser(TokenStream input, FSMDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TOP";	
       	}
       	
       	@Override
       	protected FSMDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTOP"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:67:1: entryRuleTOP returns [EObject current=null] : iv_ruleTOP= ruleTOP EOF ;
    public final EObject entryRuleTOP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTOP = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:68:2: (iv_ruleTOP= ruleTOP EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:69:2: iv_ruleTOP= ruleTOP EOF
            {
             newCompositeNode(grammarAccess.getTOPRule()); 
            pushFollow(FOLLOW_ruleTOP_in_entryRuleTOP75);
            iv_ruleTOP=ruleTOP();

            state._fsp--;

             current =iv_ruleTOP; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTOP85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTOP"


    // $ANTLR start "ruleTOP"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:76:1: ruleTOP returns [EObject current=null] : (this_FSM_0= ruleFSM | this_ConstantDefList_1= ruleConstantDefList | this_CommandStmt_2= ruleCommandStmt | this_PredicateStmt_3= rulePredicateStmt ) ;
    public final EObject ruleTOP() throws RecognitionException {
        EObject current = null;

        EObject this_FSM_0 = null;

        EObject this_ConstantDefList_1 = null;

        EObject this_CommandStmt_2 = null;

        EObject this_PredicateStmt_3 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:79:28: ( (this_FSM_0= ruleFSM | this_ConstantDefList_1= ruleConstantDefList | this_CommandStmt_2= ruleCommandStmt | this_PredicateStmt_3= rulePredicateStmt ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:80:1: (this_FSM_0= ruleFSM | this_ConstantDefList_1= ruleConstantDefList | this_CommandStmt_2= ruleCommandStmt | this_PredicateStmt_3= rulePredicateStmt )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:80:1: (this_FSM_0= ruleFSM | this_ConstantDefList_1= ruleConstantDefList | this_CommandStmt_2= ruleCommandStmt | this_PredicateStmt_3= rulePredicateStmt )
            int alt1=4;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:81:5: this_FSM_0= ruleFSM
                    {
                     
                            newCompositeNode(grammarAccess.getTOPAccess().getFSMParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFSM_in_ruleTOP132);
                    this_FSM_0=ruleFSM();

                    state._fsp--;

                     
                            current = this_FSM_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:91:5: this_ConstantDefList_1= ruleConstantDefList
                    {
                     
                            newCompositeNode(grammarAccess.getTOPAccess().getConstantDefListParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleConstantDefList_in_ruleTOP159);
                    this_ConstantDefList_1=ruleConstantDefList();

                    state._fsp--;

                     
                            current = this_ConstantDefList_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:101:5: this_CommandStmt_2= ruleCommandStmt
                    {
                     
                            newCompositeNode(grammarAccess.getTOPAccess().getCommandStmtParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCommandStmt_in_ruleTOP186);
                    this_CommandStmt_2=ruleCommandStmt();

                    state._fsp--;

                     
                            current = this_CommandStmt_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:111:5: this_PredicateStmt_3= rulePredicateStmt
                    {
                     
                            newCompositeNode(grammarAccess.getTOPAccess().getPredicateStmtParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_rulePredicateStmt_in_ruleTOP213);
                    this_PredicateStmt_3=rulePredicateStmt();

                    state._fsp--;

                     
                            current = this_PredicateStmt_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTOP"


    // $ANTLR start "entryRuleCommandStmt"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:127:1: entryRuleCommandStmt returns [EObject current=null] : iv_ruleCommandStmt= ruleCommandStmt EOF ;
    public final EObject entryRuleCommandStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandStmt = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:128:2: (iv_ruleCommandStmt= ruleCommandStmt EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:129:2: iv_ruleCommandStmt= ruleCommandStmt EOF
            {
             newCompositeNode(grammarAccess.getCommandStmtRule()); 
            pushFollow(FOLLOW_ruleCommandStmt_in_entryRuleCommandStmt248);
            iv_ruleCommandStmt=ruleCommandStmt();

            state._fsp--;

             current =iv_ruleCommandStmt; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandStmt258); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandStmt"


    // $ANTLR start "ruleCommandStmt"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:136:1: ruleCommandStmt returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' otherlv_10= '[' ( ( (lv_out_11_0= ruleShortOutputPort ) ) (otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) ) )* )? otherlv_14= ']' ( ( (lv_commands_15_0= ruleCommand ) ) (otherlv_16= ';' )? ) ( ( (lv_commands_17_0= ruleCommand ) ) (otherlv_18= ';' )? )* ) ;
    public final EObject ruleCommandStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_cst_1_0 = null;

        EObject lv_cst_3_0 = null;

        EObject lv_in_6_0 = null;

        EObject lv_in_8_0 = null;

        EObject lv_out_11_0 = null;

        EObject lv_out_13_0 = null;

        EObject lv_commands_15_0 = null;

        EObject lv_commands_17_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:139:28: ( (otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' otherlv_10= '[' ( ( (lv_out_11_0= ruleShortOutputPort ) ) (otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) ) )* )? otherlv_14= ']' ( ( (lv_commands_15_0= ruleCommand ) ) (otherlv_16= ';' )? ) ( ( (lv_commands_17_0= ruleCommand ) ) (otherlv_18= ';' )? )* ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:140:1: (otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' otherlv_10= '[' ( ( (lv_out_11_0= ruleShortOutputPort ) ) (otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) ) )* )? otherlv_14= ']' ( ( (lv_commands_15_0= ruleCommand ) ) (otherlv_16= ';' )? ) ( ( (lv_commands_17_0= ruleCommand ) ) (otherlv_18= ';' )? )* )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:140:1: (otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' otherlv_10= '[' ( ( (lv_out_11_0= ruleShortOutputPort ) ) (otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) ) )* )? otherlv_14= ']' ( ( (lv_commands_15_0= ruleCommand ) ) (otherlv_16= ';' )? ) ( ( (lv_commands_17_0= ruleCommand ) ) (otherlv_18= ';' )? )* )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:140:3: otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' otherlv_10= '[' ( ( (lv_out_11_0= ruleShortOutputPort ) ) (otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) ) )* )? otherlv_14= ']' ( ( (lv_commands_15_0= ruleCommand ) ) (otherlv_16= ';' )? ) ( ( (lv_commands_17_0= ruleCommand ) ) (otherlv_18= ';' )? )*
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleCommandStmt295); 

                	newLeafNode(otherlv_0, grammarAccess.getCommandStmtAccess().getLeftSquareBracketKeyword_0());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:144:1: ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==44) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:144:2: ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )*
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:144:2: ( (lv_cst_1_0= ruleConstantDef ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:145:1: (lv_cst_1_0= ruleConstantDef )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:145:1: (lv_cst_1_0= ruleConstantDef )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:146:3: lv_cst_1_0= ruleConstantDef
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommandStmtAccess().getCstConstantDefParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConstantDef_in_ruleCommandStmt317);
                    lv_cst_1_0=ruleConstantDef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCommandStmtRule());
                    	        }
                           		add(
                           			current, 
                           			"cst",
                            		lv_cst_1_0, 
                            		"ConstantDef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:162:2: (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==14) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:162:4: otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) )
                    	    {
                    	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleCommandStmt330); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getCommandStmtAccess().getCommaKeyword_1_1_0());
                    	        
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:166:1: ( (lv_cst_3_0= ruleConstantDef ) )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:167:1: (lv_cst_3_0= ruleConstantDef )
                    	    {
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:167:1: (lv_cst_3_0= ruleConstantDef )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:168:3: lv_cst_3_0= ruleConstantDef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandStmtAccess().getCstConstantDefParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConstantDef_in_ruleCommandStmt351);
                    	    lv_cst_3_0=ruleConstantDef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCommandStmtRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"cst",
                    	            		lv_cst_3_0, 
                    	            		"ConstantDef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleCommandStmt367); 

                	newLeafNode(otherlv_4, grammarAccess.getCommandStmtAccess().getRightSquareBracketKeyword_2());
                
            otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleCommandStmt379); 

                	newLeafNode(otherlv_5, grammarAccess.getCommandStmtAccess().getLeftSquareBracketKeyword_3());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:192:1: ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:192:2: ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )*
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:192:2: ( (lv_in_6_0= ruleShortInputPort ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:193:1: (lv_in_6_0= ruleShortInputPort )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:193:1: (lv_in_6_0= ruleShortInputPort )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:194:3: lv_in_6_0= ruleShortInputPort
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommandStmtAccess().getInShortInputPortParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShortInputPort_in_ruleCommandStmt401);
                    lv_in_6_0=ruleShortInputPort();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCommandStmtRule());
                    	        }
                           		add(
                           			current, 
                           			"in",
                            		lv_in_6_0, 
                            		"ShortInputPort");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:210:2: (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==14) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:210:4: otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleCommandStmt414); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getCommandStmtAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:214:1: ( (lv_in_8_0= ruleShortInputPort ) )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:215:1: (lv_in_8_0= ruleShortInputPort )
                    	    {
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:215:1: (lv_in_8_0= ruleShortInputPort )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:216:3: lv_in_8_0= ruleShortInputPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandStmtAccess().getInShortInputPortParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleShortInputPort_in_ruleCommandStmt435);
                    	    lv_in_8_0=ruleShortInputPort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCommandStmtRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"in",
                    	            		lv_in_8_0, 
                    	            		"ShortInputPort");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleCommandStmt451); 

                	newLeafNode(otherlv_9, grammarAccess.getCommandStmtAccess().getRightSquareBracketKeyword_5());
                
            otherlv_10=(Token)match(input,13,FOLLOW_13_in_ruleCommandStmt463); 

                	newLeafNode(otherlv_10, grammarAccess.getCommandStmtAccess().getLeftSquareBracketKeyword_6());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:240:1: ( ( (lv_out_11_0= ruleShortOutputPort ) ) (otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:240:2: ( (lv_out_11_0= ruleShortOutputPort ) ) (otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) ) )*
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:240:2: ( (lv_out_11_0= ruleShortOutputPort ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:241:1: (lv_out_11_0= ruleShortOutputPort )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:241:1: (lv_out_11_0= ruleShortOutputPort )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:242:3: lv_out_11_0= ruleShortOutputPort
                    {
                     
                    	        newCompositeNode(grammarAccess.getCommandStmtAccess().getOutShortOutputPortParserRuleCall_7_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShortOutputPort_in_ruleCommandStmt485);
                    lv_out_11_0=ruleShortOutputPort();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCommandStmtRule());
                    	        }
                           		add(
                           			current, 
                           			"out",
                            		lv_out_11_0, 
                            		"ShortOutputPort");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:258:2: (otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==14) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:258:4: otherlv_12= ',' ( (lv_out_13_0= ruleShortOutputPort ) )
                    	    {
                    	    otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleCommandStmt498); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getCommandStmtAccess().getCommaKeyword_7_1_0());
                    	        
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:262:1: ( (lv_out_13_0= ruleShortOutputPort ) )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:263:1: (lv_out_13_0= ruleShortOutputPort )
                    	    {
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:263:1: (lv_out_13_0= ruleShortOutputPort )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:264:3: lv_out_13_0= ruleShortOutputPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCommandStmtAccess().getOutShortOutputPortParserRuleCall_7_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleShortOutputPort_in_ruleCommandStmt519);
                    	    lv_out_13_0=ruleShortOutputPort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCommandStmtRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"out",
                    	            		lv_out_13_0, 
                    	            		"ShortOutputPort");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_14=(Token)match(input,15,FOLLOW_15_in_ruleCommandStmt535); 

                	newLeafNode(otherlv_14, grammarAccess.getCommandStmtAccess().getRightSquareBracketKeyword_8());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:284:1: ( ( (lv_commands_15_0= ruleCommand ) ) (otherlv_16= ';' )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:284:2: ( (lv_commands_15_0= ruleCommand ) ) (otherlv_16= ';' )?
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:284:2: ( (lv_commands_15_0= ruleCommand ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:285:1: (lv_commands_15_0= ruleCommand )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:285:1: (lv_commands_15_0= ruleCommand )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:286:3: lv_commands_15_0= ruleCommand
            {
             
            	        newCompositeNode(grammarAccess.getCommandStmtAccess().getCommandsCommandParserRuleCall_9_0_0()); 
            	    
            pushFollow(FOLLOW_ruleCommand_in_ruleCommandStmt557);
            lv_commands_15_0=ruleCommand();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandStmtRule());
            	        }
                   		add(
                   			current, 
                   			"commands",
                    		lv_commands_15_0, 
                    		"Command");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:302:2: (otherlv_16= ';' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:302:4: otherlv_16= ';'
                    {
                    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleCommandStmt570); 

                        	newLeafNode(otherlv_16, grammarAccess.getCommandStmtAccess().getSemicolonKeyword_9_1());
                        

                    }
                    break;

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:306:4: ( ( (lv_commands_17_0= ruleCommand ) ) (otherlv_18= ';' )? )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:306:5: ( (lv_commands_17_0= ruleCommand ) ) (otherlv_18= ';' )?
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:306:5: ( (lv_commands_17_0= ruleCommand ) )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:307:1: (lv_commands_17_0= ruleCommand )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:307:1: (lv_commands_17_0= ruleCommand )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:308:3: lv_commands_17_0= ruleCommand
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCommandStmtAccess().getCommandsCommandParserRuleCall_10_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleCommandStmt595);
            	    lv_commands_17_0=ruleCommand();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCommandStmtRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"commands",
            	            		lv_commands_17_0, 
            	            		"Command");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:324:2: (otherlv_18= ';' )?
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==16) ) {
            	        alt9=1;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:324:4: otherlv_18= ';'
            	            {
            	            otherlv_18=(Token)match(input,16,FOLLOW_16_in_ruleCommandStmt608); 

            	                	newLeafNode(otherlv_18, grammarAccess.getCommandStmtAccess().getSemicolonKeyword_10_1());
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandStmt"


    // $ANTLR start "entryRuleConstantDefList"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:336:1: entryRuleConstantDefList returns [EObject current=null] : iv_ruleConstantDefList= ruleConstantDefList EOF ;
    public final EObject entryRuleConstantDefList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefList = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:337:2: (iv_ruleConstantDefList= ruleConstantDefList EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:338:2: iv_ruleConstantDefList= ruleConstantDefList EOF
            {
             newCompositeNode(grammarAccess.getConstantDefListRule()); 
            pushFollow(FOLLOW_ruleConstantDefList_in_entryRuleConstantDefList648);
            iv_ruleConstantDefList=ruleConstantDefList();

            state._fsp--;

             current =iv_ruleConstantDefList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDefList658); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantDefList"


    // $ANTLR start "ruleConstantDefList"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:345:1: ruleConstantDefList returns [EObject current=null] : ( ( ( (lv_constants_0_0= ruleConstantDef ) ) (otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) ) )* ) otherlv_3= ';' )? ;
    public final EObject ruleConstantDefList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_constants_0_0 = null;

        EObject lv_constants_2_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:348:28: ( ( ( ( (lv_constants_0_0= ruleConstantDef ) ) (otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) ) )* ) otherlv_3= ';' )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:349:1: ( ( ( (lv_constants_0_0= ruleConstantDef ) ) (otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) ) )* ) otherlv_3= ';' )?
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:349:1: ( ( ( (lv_constants_0_0= ruleConstantDef ) ) (otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) ) )* ) otherlv_3= ';' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==44) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:349:2: ( ( (lv_constants_0_0= ruleConstantDef ) ) (otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) ) )* ) otherlv_3= ';'
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:349:2: ( ( (lv_constants_0_0= ruleConstantDef ) ) (otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) ) )* )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:349:3: ( (lv_constants_0_0= ruleConstantDef ) ) (otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) ) )*
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:349:3: ( (lv_constants_0_0= ruleConstantDef ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:350:1: (lv_constants_0_0= ruleConstantDef )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:350:1: (lv_constants_0_0= ruleConstantDef )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:351:3: lv_constants_0_0= ruleConstantDef
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstantDefListAccess().getConstantsConstantDefParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConstantDef_in_ruleConstantDefList705);
                    lv_constants_0_0=ruleConstantDef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConstantDefListRule());
                    	        }
                           		add(
                           			current, 
                           			"constants",
                            		lv_constants_0_0, 
                            		"ConstantDef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:367:2: (otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==16) ) {
                            int LA11_1 = input.LA(2);

                            if ( (LA11_1==44) ) {
                                alt11=1;
                            }


                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:367:4: otherlv_1= ';' ( (lv_constants_2_0= ruleConstantDef ) )
                    	    {
                    	    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleConstantDefList718); 

                    	        	newLeafNode(otherlv_1, grammarAccess.getConstantDefListAccess().getSemicolonKeyword_0_1_0());
                    	        
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:371:1: ( (lv_constants_2_0= ruleConstantDef ) )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:372:1: (lv_constants_2_0= ruleConstantDef )
                    	    {
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:372:1: (lv_constants_2_0= ruleConstantDef )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:373:3: lv_constants_2_0= ruleConstantDef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConstantDefListAccess().getConstantsConstantDefParserRuleCall_0_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConstantDef_in_ruleConstantDefList739);
                    	    lv_constants_2_0=ruleConstantDef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConstantDefListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constants",
                    	            		lv_constants_2_0, 
                    	            		"ConstantDef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }

                    otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleConstantDefList754); 

                        	newLeafNode(otherlv_3, grammarAccess.getConstantDefListAccess().getSemicolonKeyword_1());
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantDefList"


    // $ANTLR start "entryRulePredicateStmt"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:401:1: entryRulePredicateStmt returns [EObject current=null] : iv_rulePredicateStmt= rulePredicateStmt EOF ;
    public final EObject entryRulePredicateStmt() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateStmt = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:402:2: (iv_rulePredicateStmt= rulePredicateStmt EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:403:2: iv_rulePredicateStmt= rulePredicateStmt EOF
            {
             newCompositeNode(grammarAccess.getPredicateStmtRule()); 
            pushFollow(FOLLOW_rulePredicateStmt_in_entryRulePredicateStmt791);
            iv_rulePredicateStmt=rulePredicateStmt();

            state._fsp--;

             current =iv_rulePredicateStmt; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePredicateStmt801); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicateStmt"


    // $ANTLR start "rulePredicateStmt"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:410:1: rulePredicateStmt returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' ( (lv_predicate_10_0= rulePredicate ) ) otherlv_11= ';' ) ;
    public final EObject rulePredicateStmt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_cst_1_0 = null;

        EObject lv_cst_3_0 = null;

        EObject lv_in_6_0 = null;

        EObject lv_in_8_0 = null;

        EObject lv_predicate_10_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:413:28: ( (otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' ( (lv_predicate_10_0= rulePredicate ) ) otherlv_11= ';' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:414:1: (otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' ( (lv_predicate_10_0= rulePredicate ) ) otherlv_11= ';' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:414:1: (otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' ( (lv_predicate_10_0= rulePredicate ) ) otherlv_11= ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:414:3: otherlv_0= '[' ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )? otherlv_4= ']' otherlv_5= '[' ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )? otherlv_9= ']' ( (lv_predicate_10_0= rulePredicate ) ) otherlv_11= ';'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePredicateStmt838); 

                	newLeafNode(otherlv_0, grammarAccess.getPredicateStmtAccess().getLeftSquareBracketKeyword_0());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:418:1: ( ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==44) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:418:2: ( (lv_cst_1_0= ruleConstantDef ) ) (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )*
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:418:2: ( (lv_cst_1_0= ruleConstantDef ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:419:1: (lv_cst_1_0= ruleConstantDef )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:419:1: (lv_cst_1_0= ruleConstantDef )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:420:3: lv_cst_1_0= ruleConstantDef
                    {
                     
                    	        newCompositeNode(grammarAccess.getPredicateStmtAccess().getCstConstantDefParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleConstantDef_in_rulePredicateStmt860);
                    lv_cst_1_0=ruleConstantDef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPredicateStmtRule());
                    	        }
                           		add(
                           			current, 
                           			"cst",
                            		lv_cst_1_0, 
                            		"ConstantDef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:436:2: (otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==14) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:436:4: otherlv_2= ',' ( (lv_cst_3_0= ruleConstantDef ) )
                    	    {
                    	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePredicateStmt873); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getPredicateStmtAccess().getCommaKeyword_1_1_0());
                    	        
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:440:1: ( (lv_cst_3_0= ruleConstantDef ) )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:441:1: (lv_cst_3_0= ruleConstantDef )
                    	    {
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:441:1: (lv_cst_3_0= ruleConstantDef )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:442:3: lv_cst_3_0= ruleConstantDef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPredicateStmtAccess().getCstConstantDefParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConstantDef_in_rulePredicateStmt894);
                    	    lv_cst_3_0=ruleConstantDef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPredicateStmtRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"cst",
                    	            		lv_cst_3_0, 
                    	            		"ConstantDef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePredicateStmt910); 

                	newLeafNode(otherlv_4, grammarAccess.getPredicateStmtAccess().getRightSquareBracketKeyword_2());
                
            otherlv_5=(Token)match(input,13,FOLLOW_13_in_rulePredicateStmt922); 

                	newLeafNode(otherlv_5, grammarAccess.getPredicateStmtAccess().getLeftSquareBracketKeyword_3());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:466:1: ( ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:466:2: ( (lv_in_6_0= ruleShortInputPort ) ) (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )*
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:466:2: ( (lv_in_6_0= ruleShortInputPort ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:467:1: (lv_in_6_0= ruleShortInputPort )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:467:1: (lv_in_6_0= ruleShortInputPort )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:468:3: lv_in_6_0= ruleShortInputPort
                    {
                     
                    	        newCompositeNode(grammarAccess.getPredicateStmtAccess().getInShortInputPortParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShortInputPort_in_rulePredicateStmt944);
                    lv_in_6_0=ruleShortInputPort();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPredicateStmtRule());
                    	        }
                           		add(
                           			current, 
                           			"in",
                            		lv_in_6_0, 
                            		"ShortInputPort");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:484:2: (otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==14) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:484:4: otherlv_7= ',' ( (lv_in_8_0= ruleShortInputPort ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_14_in_rulePredicateStmt957); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getPredicateStmtAccess().getCommaKeyword_4_1_0());
                    	        
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:488:1: ( (lv_in_8_0= ruleShortInputPort ) )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:489:1: (lv_in_8_0= ruleShortInputPort )
                    	    {
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:489:1: (lv_in_8_0= ruleShortInputPort )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:490:3: lv_in_8_0= ruleShortInputPort
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getPredicateStmtAccess().getInShortInputPortParserRuleCall_4_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleShortInputPort_in_rulePredicateStmt978);
                    	    lv_in_8_0=ruleShortInputPort();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getPredicateStmtRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"in",
                    	            		lv_in_8_0, 
                    	            		"ShortInputPort");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_15_in_rulePredicateStmt994); 

                	newLeafNode(otherlv_9, grammarAccess.getPredicateStmtAccess().getRightSquareBracketKeyword_5());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:510:1: ( (lv_predicate_10_0= rulePredicate ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:511:1: (lv_predicate_10_0= rulePredicate )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:511:1: (lv_predicate_10_0= rulePredicate )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:512:3: lv_predicate_10_0= rulePredicate
            {
             
            	        newCompositeNode(grammarAccess.getPredicateStmtAccess().getPredicatePredicateParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_rulePredicate_in_rulePredicateStmt1015);
            lv_predicate_10_0=rulePredicate();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPredicateStmtRule());
            	        }
                   		set(
                   			current, 
                   			"predicate",
                    		lv_predicate_10_0, 
                    		"Predicate");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,16,FOLLOW_16_in_rulePredicateStmt1027); 

                	newLeafNode(otherlv_11, grammarAccess.getPredicateStmtAccess().getSemicolonKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicateStmt"


    // $ANTLR start "entryRuleFSM"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:540:1: entryRuleFSM returns [EObject current=null] : iv_ruleFSM= ruleFSM EOF ;
    public final EObject entryRuleFSM() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFSM = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:541:2: (iv_ruleFSM= ruleFSM EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:542:2: iv_ruleFSM= ruleFSM EOF
            {
             newCompositeNode(grammarAccess.getFSMRule()); 
            pushFollow(FOLLOW_ruleFSM_in_entryRuleFSM1063);
            iv_ruleFSM=ruleFSM();

            state._fsp--;

             current =iv_ruleFSM; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFSM1073); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFSM"


    // $ANTLR start "ruleFSM"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:549:1: ruleFSM returns [EObject current=null] : ( () (otherlv_1= 'fsm' | otherlv_2= 'state_machine' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= '{' ( ( (lv_constants_6_0= ruleConstantDef ) ) otherlv_7= ';' )* ( (otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+ ) | (otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+ ) )+ (otherlv_12= 'codeWidth' otherlv_13= '=' ( (lv_width_14_0= RULE_INT ) ) otherlv_15= ';' ) (otherlv_16= 'reset' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) otherlv_19= ';' ) ( ( (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState ) ) )* otherlv_21= '}' ) ;
    public final EObject ruleFSM() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_width_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject lv_layout_4_0 = null;

        EObject lv_constants_6_0 = null;

        EObject lv_in_9_0 = null;

        EObject lv_out_11_0 = null;

        EObject lv_states_20_1 = null;

        EObject lv_states_20_2 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:552:28: ( ( () (otherlv_1= 'fsm' | otherlv_2= 'state_machine' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= '{' ( ( (lv_constants_6_0= ruleConstantDef ) ) otherlv_7= ';' )* ( (otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+ ) | (otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+ ) )+ (otherlv_12= 'codeWidth' otherlv_13= '=' ( (lv_width_14_0= RULE_INT ) ) otherlv_15= ';' ) (otherlv_16= 'reset' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) otherlv_19= ';' ) ( ( (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState ) ) )* otherlv_21= '}' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:553:1: ( () (otherlv_1= 'fsm' | otherlv_2= 'state_machine' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= '{' ( ( (lv_constants_6_0= ruleConstantDef ) ) otherlv_7= ';' )* ( (otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+ ) | (otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+ ) )+ (otherlv_12= 'codeWidth' otherlv_13= '=' ( (lv_width_14_0= RULE_INT ) ) otherlv_15= ';' ) (otherlv_16= 'reset' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) otherlv_19= ';' ) ( ( (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState ) ) )* otherlv_21= '}' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:553:1: ( () (otherlv_1= 'fsm' | otherlv_2= 'state_machine' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= '{' ( ( (lv_constants_6_0= ruleConstantDef ) ) otherlv_7= ';' )* ( (otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+ ) | (otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+ ) )+ (otherlv_12= 'codeWidth' otherlv_13= '=' ( (lv_width_14_0= RULE_INT ) ) otherlv_15= ';' ) (otherlv_16= 'reset' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) otherlv_19= ';' ) ( ( (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState ) ) )* otherlv_21= '}' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:553:2: () (otherlv_1= 'fsm' | otherlv_2= 'state_machine' ) ( (lv_name_3_0= RULE_ID ) ) ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= '{' ( ( (lv_constants_6_0= ruleConstantDef ) ) otherlv_7= ';' )* ( (otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+ ) | (otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+ ) )+ (otherlv_12= 'codeWidth' otherlv_13= '=' ( (lv_width_14_0= RULE_INT ) ) otherlv_15= ';' ) (otherlv_16= 'reset' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) otherlv_19= ';' ) ( ( (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState ) ) )* otherlv_21= '}'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:553:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:554:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getFSMAccess().getFSMAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:559:2: (otherlv_1= 'fsm' | otherlv_2= 'state_machine' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==17) ) {
                alt17=1;
            }
            else if ( (LA17_0==18) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:559:4: otherlv_1= 'fsm'
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleFSM1120); 

                        	newLeafNode(otherlv_1, grammarAccess.getFSMAccess().getFsmKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:564:7: otherlv_2= 'state_machine'
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleFSM1138); 

                        	newLeafNode(otherlv_2, grammarAccess.getFSMAccess().getState_machineKeyword_1_1());
                        

                    }
                    break;

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:568:2: ( (lv_name_3_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:569:1: (lv_name_3_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:569:1: (lv_name_3_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:570:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFSM1156); 

            			newLeafNode(lv_name_3_0, grammarAccess.getFSMAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFSMRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:586:2: ( (lv_layout_4_0= ruleLayoutInfo ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:587:1: (lv_layout_4_0= ruleLayoutInfo )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:587:1: (lv_layout_4_0= ruleLayoutInfo )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:588:3: lv_layout_4_0= ruleLayoutInfo
            {
             
            	        newCompositeNode(grammarAccess.getFSMAccess().getLayoutLayoutInfoParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLayoutInfo_in_ruleFSM1182);
            lv_layout_4_0=ruleLayoutInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFSMRule());
            	        }
                   		set(
                   			current, 
                   			"layout",
                    		lv_layout_4_0, 
                    		"LayoutInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleFSM1194); 

                	newLeafNode(otherlv_5, grammarAccess.getFSMAccess().getLeftCurlyBracketKeyword_4());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:608:1: ( ( (lv_constants_6_0= ruleConstantDef ) ) otherlv_7= ';' )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==44) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:608:2: ( (lv_constants_6_0= ruleConstantDef ) ) otherlv_7= ';'
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:608:2: ( (lv_constants_6_0= ruleConstantDef ) )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:609:1: (lv_constants_6_0= ruleConstantDef )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:609:1: (lv_constants_6_0= ruleConstantDef )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:610:3: lv_constants_6_0= ruleConstantDef
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFSMAccess().getConstantsConstantDefParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConstantDef_in_ruleFSM1216);
            	    lv_constants_6_0=ruleConstantDef();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFSMRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"constants",
            	            		lv_constants_6_0, 
            	            		"ConstantDef");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleFSM1228); 

            	        	newLeafNode(otherlv_7, grammarAccess.getFSMAccess().getSemicolonKeyword_5_1());
            	        

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:630:3: ( (otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+ ) | (otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+ ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==20) ) {
                    alt21=1;
                }
                else if ( (LA21_0==21) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:630:4: (otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+ )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:630:4: (otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+ )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:630:6: otherlv_8= 'in' ( (lv_in_9_0= ruleInputPort ) )+
            	    {
            	    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleFSM1244); 

            	        	newLeafNode(otherlv_8, grammarAccess.getFSMAccess().getInKeyword_6_0_0());
            	        
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:634:1: ( (lv_in_9_0= ruleInputPort ) )+
            	    int cnt19=0;
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==RULE_ID) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:635:1: (lv_in_9_0= ruleInputPort )
            	    	    {
            	    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:635:1: (lv_in_9_0= ruleInputPort )
            	    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:636:3: lv_in_9_0= ruleInputPort
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFSMAccess().getInInputPortParserRuleCall_6_0_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleInputPort_in_ruleFSM1265);
            	    	    lv_in_9_0=ruleInputPort();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFSMRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"in",
            	    	            		lv_in_9_0, 
            	    	            		"InputPort");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt19 >= 1 ) break loop19;
            	                EarlyExitException eee =
            	                    new EarlyExitException(19, input);
            	                throw eee;
            	        }
            	        cnt19++;
            	    } while (true);


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:653:6: (otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+ )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:653:6: (otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+ )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:653:8: otherlv_10= 'out' ( (lv_out_11_0= ruleOutputPort ) )+
            	    {
            	    otherlv_10=(Token)match(input,21,FOLLOW_21_in_ruleFSM1286); 

            	        	newLeafNode(otherlv_10, grammarAccess.getFSMAccess().getOutKeyword_6_1_0());
            	        
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:657:1: ( (lv_out_11_0= ruleOutputPort ) )+
            	    int cnt20=0;
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==RULE_ID) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:658:1: (lv_out_11_0= ruleOutputPort )
            	    	    {
            	    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:658:1: (lv_out_11_0= ruleOutputPort )
            	    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:659:3: lv_out_11_0= ruleOutputPort
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getFSMAccess().getOutOutputPortParserRuleCall_6_1_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleOutputPort_in_ruleFSM1307);
            	    	    lv_out_11_0=ruleOutputPort();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getFSMRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"out",
            	    	            		lv_out_11_0, 
            	    	            		"OutputPort");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt20 >= 1 ) break loop20;
            	                EarlyExitException eee =
            	                    new EarlyExitException(20, input);
            	                throw eee;
            	        }
            	        cnt20++;
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:675:6: (otherlv_12= 'codeWidth' otherlv_13= '=' ( (lv_width_14_0= RULE_INT ) ) otherlv_15= ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:675:8: otherlv_12= 'codeWidth' otherlv_13= '=' ( (lv_width_14_0= RULE_INT ) ) otherlv_15= ';'
            {
            otherlv_12=(Token)match(input,22,FOLLOW_22_in_ruleFSM1324); 

                	newLeafNode(otherlv_12, grammarAccess.getFSMAccess().getCodeWidthKeyword_7_0());
                
            otherlv_13=(Token)match(input,23,FOLLOW_23_in_ruleFSM1336); 

                	newLeafNode(otherlv_13, grammarAccess.getFSMAccess().getEqualsSignKeyword_7_1());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:683:1: ( (lv_width_14_0= RULE_INT ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:684:1: (lv_width_14_0= RULE_INT )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:684:1: (lv_width_14_0= RULE_INT )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:685:3: lv_width_14_0= RULE_INT
            {
            lv_width_14_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleFSM1353); 

            			newLeafNode(lv_width_14_0, grammarAccess.getFSMAccess().getWidthINTTerminalRuleCall_7_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFSMRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"width",
                    		lv_width_14_0, 
                    		"INT");
            	    

            }


            }

            otherlv_15=(Token)match(input,16,FOLLOW_16_in_ruleFSM1370); 

                	newLeafNode(otherlv_15, grammarAccess.getFSMAccess().getSemicolonKeyword_7_3());
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:705:2: (otherlv_16= 'reset' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) otherlv_19= ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:705:4: otherlv_16= 'reset' otherlv_17= '=' ( (otherlv_18= RULE_ID ) ) otherlv_19= ';'
            {
            otherlv_16=(Token)match(input,24,FOLLOW_24_in_ruleFSM1384); 

                	newLeafNode(otherlv_16, grammarAccess.getFSMAccess().getResetKeyword_8_0());
                
            otherlv_17=(Token)match(input,23,FOLLOW_23_in_ruleFSM1396); 

                	newLeafNode(otherlv_17, grammarAccess.getFSMAccess().getEqualsSignKeyword_8_1());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:713:1: ( (otherlv_18= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:714:1: (otherlv_18= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:714:1: (otherlv_18= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:715:3: otherlv_18= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFSMRule());
            	        }
                    
            otherlv_18=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFSM1416); 

            		newLeafNode(otherlv_18, grammarAccess.getFSMAccess().getStartStateCrossReference_8_2_0()); 
            	

            }


            }

            otherlv_19=(Token)match(input,16,FOLLOW_16_in_ruleFSM1428); 

                	newLeafNode(otherlv_19, grammarAccess.getFSMAccess().getSemicolonKeyword_8_3());
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:730:2: ( ( (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==28) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:731:1: ( (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState ) )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:731:1: ( (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState ) )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:732:1: (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:732:1: (lv_states_20_1= ruleLongState | lv_states_20_2= ruleShortState )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==28) ) {
            	        int LA22_1 = input.LA(2);

            	        if ( (LA22_1==RULE_ID) ) {
            	            int LA22_2 = input.LA(3);

            	            if ( (LA22_2==19||LA22_2==23||LA22_2==27) ) {
            	                alt22=1;
            	            }
            	            else if ( (LA22_2==13||LA22_2==30) ) {
            	                alt22=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 22, 2, input);

            	                throw nvae;
            	            }
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 22, 1, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:733:3: lv_states_20_1= ruleLongState
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getFSMAccess().getStatesLongStateParserRuleCall_9_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleLongState_in_ruleFSM1452);
            	            lv_states_20_1=ruleLongState();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getFSMRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"states",
            	                    		lv_states_20_1, 
            	                    		"LongState");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:748:8: lv_states_20_2= ruleShortState
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getFSMAccess().getStatesShortStateParserRuleCall_9_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleShortState_in_ruleFSM1471);
            	            lv_states_20_2=ruleShortState();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getFSMRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"states",
            	                    		lv_states_20_2, 
            	                    		"ShortState");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_21=(Token)match(input,25,FOLLOW_25_in_ruleFSM1487); 

                	newLeafNode(otherlv_21, grammarAccess.getFSMAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFSM"


    // $ANTLR start "entryRuleShortInputPort"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:782:1: entryRuleShortInputPort returns [EObject current=null] : iv_ruleShortInputPort= ruleShortInputPort EOF ;
    public final EObject entryRuleShortInputPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShortInputPort = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:783:2: (iv_ruleShortInputPort= ruleShortInputPort EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:784:2: iv_ruleShortInputPort= ruleShortInputPort EOF
            {
             newCompositeNode(grammarAccess.getShortInputPortRule()); 
            pushFollow(FOLLOW_ruleShortInputPort_in_entryRuleShortInputPort1527);
            iv_ruleShortInputPort=ruleShortInputPort();

            state._fsp--;

             current =iv_ruleShortInputPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShortInputPort1537); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShortInputPort"


    // $ANTLR start "ruleShortInputPort"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:791:1: ruleShortInputPort returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleShortInputPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_width_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:794:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:795:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:795:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:795:2: () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:795:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:796:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getShortInputPortAccess().getInputPortAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:801:2: ( (lv_name_1_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:802:1: (lv_name_1_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:802:1: (lv_name_1_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:803:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShortInputPort1588); 

            			newLeafNode(lv_name_1_0, grammarAccess.getShortInputPortAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getShortInputPortRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:819:2: (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==13) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:819:4: otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleShortInputPort1606); 

                        	newLeafNode(otherlv_2, grammarAccess.getShortInputPortAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:823:1: ( (lv_width_3_0= RULE_INT ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:824:1: (lv_width_3_0= RULE_INT )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:824:1: (lv_width_3_0= RULE_INT )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:825:3: lv_width_3_0= RULE_INT
                    {
                    lv_width_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleShortInputPort1623); 

                    			newLeafNode(lv_width_3_0, grammarAccess.getShortInputPortAccess().getWidthINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShortInputPortRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"width",
                            		lv_width_3_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleShortInputPort1640); 

                        	newLeafNode(otherlv_4, grammarAccess.getShortInputPortAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShortInputPort"


    // $ANTLR start "entryRuleShortOutputPort"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:853:1: entryRuleShortOutputPort returns [EObject current=null] : iv_ruleShortOutputPort= ruleShortOutputPort EOF ;
    public final EObject entryRuleShortOutputPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShortOutputPort = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:854:2: (iv_ruleShortOutputPort= ruleShortOutputPort EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:855:2: iv_ruleShortOutputPort= ruleShortOutputPort EOF
            {
             newCompositeNode(grammarAccess.getShortOutputPortRule()); 
            pushFollow(FOLLOW_ruleShortOutputPort_in_entryRuleShortOutputPort1678);
            iv_ruleShortOutputPort=ruleShortOutputPort();

            state._fsp--;

             current =iv_ruleShortOutputPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShortOutputPort1688); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShortOutputPort"


    // $ANTLR start "ruleShortOutputPort"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:862:1: ruleShortOutputPort returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ) ;
    public final EObject ruleShortOutputPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_width_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:865:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:866:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:866:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:866:2: () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )?
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:866:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:867:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getShortOutputPortAccess().getOutputPortAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:872:2: ( (lv_name_1_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:873:1: (lv_name_1_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:873:1: (lv_name_1_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:874:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShortOutputPort1739); 

            			newLeafNode(lv_name_1_0, grammarAccess.getShortOutputPortAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getShortOutputPortRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:890:2: (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==13) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:890:4: otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleShortOutputPort1757); 

                        	newLeafNode(otherlv_2, grammarAccess.getShortOutputPortAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:894:1: ( (lv_width_3_0= RULE_INT ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:895:1: (lv_width_3_0= RULE_INT )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:895:1: (lv_width_3_0= RULE_INT )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:896:3: lv_width_3_0= RULE_INT
                    {
                    lv_width_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleShortOutputPort1774); 

                    			newLeafNode(lv_width_3_0, grammarAccess.getShortOutputPortAccess().getWidthINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShortOutputPortRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"width",
                            		lv_width_3_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleShortOutputPort1791); 

                        	newLeafNode(otherlv_4, grammarAccess.getShortOutputPortAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShortOutputPort"


    // $ANTLR start "entryRuleInputPort"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:924:1: entryRuleInputPort returns [EObject current=null] : iv_ruleInputPort= ruleInputPort EOF ;
    public final EObject entryRuleInputPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInputPort = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:925:2: (iv_ruleInputPort= ruleInputPort EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:926:2: iv_ruleInputPort= ruleInputPort EOF
            {
             newCompositeNode(grammarAccess.getInputPortRule()); 
            pushFollow(FOLLOW_ruleInputPort_in_entryRuleInputPort1829);
            iv_ruleInputPort=ruleInputPort();

            state._fsp--;

             current =iv_ruleInputPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInputPort1839); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInputPort"


    // $ANTLR start "ruleInputPort"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:933:1: ruleInputPort returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' ) ;
    public final EObject ruleInputPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_width_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_layout_5_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:936:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:937:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:937:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:937:2: () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:937:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:938:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInputPortAccess().getInputPortAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:943:2: ( (lv_name_1_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:944:1: (lv_name_1_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:944:1: (lv_name_1_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:945:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInputPort1890); 

            			newLeafNode(lv_name_1_0, grammarAccess.getInputPortAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInputPortRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:961:2: (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==13) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:961:4: otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleInputPort1908); 

                        	newLeafNode(otherlv_2, grammarAccess.getInputPortAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:965:1: ( (lv_width_3_0= RULE_INT ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:966:1: (lv_width_3_0= RULE_INT )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:966:1: (lv_width_3_0= RULE_INT )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:967:3: lv_width_3_0= RULE_INT
                    {
                    lv_width_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleInputPort1925); 

                    			newLeafNode(lv_width_3_0, grammarAccess.getInputPortAccess().getWidthINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInputPortRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"width",
                            		lv_width_3_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleInputPort1942); 

                        	newLeafNode(otherlv_4, grammarAccess.getInputPortAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:987:3: ( (lv_layout_5_0= ruleLayoutInfo ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:988:1: (lv_layout_5_0= ruleLayoutInfo )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:988:1: (lv_layout_5_0= ruleLayoutInfo )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:989:3: lv_layout_5_0= ruleLayoutInfo
            {
             
            	        newCompositeNode(grammarAccess.getInputPortAccess().getLayoutLayoutInfoParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLayoutInfo_in_ruleInputPort1965);
            lv_layout_5_0=ruleLayoutInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInputPortRule());
            	        }
                   		set(
                   			current, 
                   			"layout",
                    		lv_layout_5_0, 
                    		"LayoutInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleInputPort1977); 

                	newLeafNode(otherlv_6, grammarAccess.getInputPortAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputPort"


    // $ANTLR start "entryRuleOutputPort"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1017:1: entryRuleOutputPort returns [EObject current=null] : iv_ruleOutputPort= ruleOutputPort EOF ;
    public final EObject entryRuleOutputPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutputPort = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1018:2: (iv_ruleOutputPort= ruleOutputPort EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1019:2: iv_ruleOutputPort= ruleOutputPort EOF
            {
             newCompositeNode(grammarAccess.getOutputPortRule()); 
            pushFollow(FOLLOW_ruleOutputPort_in_entryRuleOutputPort2013);
            iv_ruleOutputPort=ruleOutputPort();

            state._fsp--;

             current =iv_ruleOutputPort; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutputPort2023); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutputPort"


    // $ANTLR start "ruleOutputPort"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1026:1: ruleOutputPort returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' ) ;
    public final EObject ruleOutputPort() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_width_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_layout_5_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1029:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1030:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1030:1: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1030:2: () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1030:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1031:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOutputPortAccess().getOutputPortAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1036:2: ( (lv_name_1_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1037:1: (lv_name_1_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1037:1: (lv_name_1_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1038:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleOutputPort2074); 

            			newLeafNode(lv_name_1_0, grammarAccess.getOutputPortAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOutputPortRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1054:2: (otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==13) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1054:4: otherlv_2= '[' ( (lv_width_3_0= RULE_INT ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleOutputPort2092); 

                        	newLeafNode(otherlv_2, grammarAccess.getOutputPortAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1058:1: ( (lv_width_3_0= RULE_INT ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1059:1: (lv_width_3_0= RULE_INT )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1059:1: (lv_width_3_0= RULE_INT )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1060:3: lv_width_3_0= RULE_INT
                    {
                    lv_width_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleOutputPort2109); 

                    			newLeafNode(lv_width_3_0, grammarAccess.getOutputPortAccess().getWidthINTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getOutputPortRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"width",
                            		lv_width_3_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleOutputPort2126); 

                        	newLeafNode(otherlv_4, grammarAccess.getOutputPortAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1080:3: ( (lv_layout_5_0= ruleLayoutInfo ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1081:1: (lv_layout_5_0= ruleLayoutInfo )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1081:1: (lv_layout_5_0= ruleLayoutInfo )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1082:3: lv_layout_5_0= ruleLayoutInfo
            {
             
            	        newCompositeNode(grammarAccess.getOutputPortAccess().getLayoutLayoutInfoParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLayoutInfo_in_ruleOutputPort2149);
            lv_layout_5_0=ruleLayoutInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOutputPortRule());
            	        }
                   		set(
                   			current, 
                   			"layout",
                    		lv_layout_5_0, 
                    		"LayoutInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleOutputPort2161); 

                	newLeafNode(otherlv_6, grammarAccess.getOutputPortAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputPort"


    // $ANTLR start "entryRuleCommandList"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1110:1: entryRuleCommandList returns [EObject current=null] : iv_ruleCommandList= ruleCommandList EOF ;
    public final EObject entryRuleCommandList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommandList = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1111:2: (iv_ruleCommandList= ruleCommandList EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1112:2: iv_ruleCommandList= ruleCommandList EOF
            {
             newCompositeNode(grammarAccess.getCommandListRule()); 
            pushFollow(FOLLOW_ruleCommandList_in_entryRuleCommandList2197);
            iv_ruleCommandList=ruleCommandList();

            state._fsp--;

             current =iv_ruleCommandList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommandList2207); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommandList"


    // $ANTLR start "ruleCommandList"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1119:1: ruleCommandList returns [EObject current=null] : ( () (otherlv_1= 'commands' ( (lv_layout_2_0= ruleLayoutInfo ) ) otherlv_3= '{' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= '}' ) ) ;
    public final EObject ruleCommandList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_layout_2_0 = null;

        EObject lv_commands_4_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1122:28: ( ( () (otherlv_1= 'commands' ( (lv_layout_2_0= ruleLayoutInfo ) ) otherlv_3= '{' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= '}' ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1123:1: ( () (otherlv_1= 'commands' ( (lv_layout_2_0= ruleLayoutInfo ) ) otherlv_3= '{' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= '}' ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1123:1: ( () (otherlv_1= 'commands' ( (lv_layout_2_0= ruleLayoutInfo ) ) otherlv_3= '{' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= '}' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1123:2: () (otherlv_1= 'commands' ( (lv_layout_2_0= ruleLayoutInfo ) ) otherlv_3= '{' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= '}' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1123:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1124:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCommandListAccess().getCommandListAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1129:2: (otherlv_1= 'commands' ( (lv_layout_2_0= ruleLayoutInfo ) ) otherlv_3= '{' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= '}' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1129:4: otherlv_1= 'commands' ( (lv_layout_2_0= ruleLayoutInfo ) ) otherlv_3= '{' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= '}'
            {
            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleCommandList2254); 

                	newLeafNode(otherlv_1, grammarAccess.getCommandListAccess().getCommandsKeyword_1_0());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1133:1: ( (lv_layout_2_0= ruleLayoutInfo ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1134:1: (lv_layout_2_0= ruleLayoutInfo )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1134:1: (lv_layout_2_0= ruleLayoutInfo )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1135:3: lv_layout_2_0= ruleLayoutInfo
            {
             
            	        newCompositeNode(grammarAccess.getCommandListAccess().getLayoutLayoutInfoParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleLayoutInfo_in_ruleCommandList2275);
            lv_layout_2_0=ruleLayoutInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandListRule());
            	        }
                   		set(
                   			current, 
                   			"layout",
                    		lv_layout_2_0, 
                    		"LayoutInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleCommandList2287); 

                	newLeafNode(otherlv_3, grammarAccess.getCommandListAccess().getLeftCurlyBracketKeyword_1_2());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1155:1: ( (lv_commands_4_0= ruleCommand ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1156:1: (lv_commands_4_0= ruleCommand )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1156:1: (lv_commands_4_0= ruleCommand )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1157:3: lv_commands_4_0= ruleCommand
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCommandListAccess().getCommandsCommandParserRuleCall_1_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleCommandList2308);
            	    lv_commands_4_0=ruleCommand();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCommandListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"commands",
            	            		lv_commands_4_0, 
            	            		"Command");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleCommandList2321); 

                	newLeafNode(otherlv_5, grammarAccess.getCommandListAccess().getRightCurlyBracketKeyword_1_4());
                

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommandList"


    // $ANTLR start "entryRuleLayoutInfo"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1185:1: entryRuleLayoutInfo returns [EObject current=null] : iv_ruleLayoutInfo= ruleLayoutInfo EOF ;
    public final EObject entryRuleLayoutInfo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLayoutInfo = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1186:2: (iv_ruleLayoutInfo= ruleLayoutInfo EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1187:2: iv_ruleLayoutInfo= ruleLayoutInfo EOF
            {
             newCompositeNode(grammarAccess.getLayoutInfoRule()); 
            pushFollow(FOLLOW_ruleLayoutInfo_in_entryRuleLayoutInfo2358);
            iv_ruleLayoutInfo=ruleLayoutInfo();

            state._fsp--;

             current =iv_ruleLayoutInfo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLayoutInfo2368); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLayoutInfo"


    // $ANTLR start "ruleLayoutInfo"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1194:1: ruleLayoutInfo returns [EObject current=null] : ( () (otherlv_1= '@' otherlv_2= '[' ( (lv_x_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_y_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) ) )? otherlv_10= ']' )? ) ;
    public final EObject ruleLayoutInfo() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_x_3_0=null;
        Token otherlv_4=null;
        Token lv_y_5_0=null;
        Token otherlv_6=null;
        Token lv_width_7_0=null;
        Token otherlv_8=null;
        Token lv_height_9_0=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1197:28: ( ( () (otherlv_1= '@' otherlv_2= '[' ( (lv_x_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_y_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) ) )? otherlv_10= ']' )? ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1198:1: ( () (otherlv_1= '@' otherlv_2= '[' ( (lv_x_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_y_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) ) )? otherlv_10= ']' )? )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1198:1: ( () (otherlv_1= '@' otherlv_2= '[' ( (lv_x_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_y_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) ) )? otherlv_10= ']' )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1198:2: () (otherlv_1= '@' otherlv_2= '[' ( (lv_x_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_y_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) ) )? otherlv_10= ']' )?
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1198:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1199:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLayoutInfoAccess().getLayoutInfoAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1204:2: (otherlv_1= '@' otherlv_2= '[' ( (lv_x_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_y_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) ) )? otherlv_10= ']' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==27) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1204:4: otherlv_1= '@' otherlv_2= '[' ( (lv_x_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_y_5_0= RULE_INT ) ) (otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) ) )? otherlv_10= ']'
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleLayoutInfo2415); 

                        	newLeafNode(otherlv_1, grammarAccess.getLayoutInfoAccess().getCommercialAtKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleLayoutInfo2427); 

                        	newLeafNode(otherlv_2, grammarAccess.getLayoutInfoAccess().getLeftSquareBracketKeyword_1_1());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1212:1: ( (lv_x_3_0= RULE_INT ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1213:1: (lv_x_3_0= RULE_INT )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1213:1: (lv_x_3_0= RULE_INT )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1214:3: lv_x_3_0= RULE_INT
                    {
                    lv_x_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLayoutInfo2444); 

                    			newLeafNode(lv_x_3_0, grammarAccess.getLayoutInfoAccess().getXINTTerminalRuleCall_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLayoutInfoRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"x",
                            		lv_x_3_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleLayoutInfo2461); 

                        	newLeafNode(otherlv_4, grammarAccess.getLayoutInfoAccess().getCommaKeyword_1_3());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1234:1: ( (lv_y_5_0= RULE_INT ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1235:1: (lv_y_5_0= RULE_INT )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1235:1: (lv_y_5_0= RULE_INT )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1236:3: lv_y_5_0= RULE_INT
                    {
                    lv_y_5_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLayoutInfo2478); 

                    			newLeafNode(lv_y_5_0, grammarAccess.getLayoutInfoAccess().getYINTTerminalRuleCall_1_4_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLayoutInfoRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"y",
                            		lv_y_5_0, 
                            		"INT");
                    	    

                    }


                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1252:2: (otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==14) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1252:4: otherlv_6= ',' ( (lv_width_7_0= RULE_INT ) ) otherlv_8= ',' ( (lv_height_9_0= RULE_INT ) )
                            {
                            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleLayoutInfo2496); 

                                	newLeafNode(otherlv_6, grammarAccess.getLayoutInfoAccess().getCommaKeyword_1_5_0());
                                
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1256:1: ( (lv_width_7_0= RULE_INT ) )
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1257:1: (lv_width_7_0= RULE_INT )
                            {
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1257:1: (lv_width_7_0= RULE_INT )
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1258:3: lv_width_7_0= RULE_INT
                            {
                            lv_width_7_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLayoutInfo2513); 

                            			newLeafNode(lv_width_7_0, grammarAccess.getLayoutInfoAccess().getWidthINTTerminalRuleCall_1_5_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getLayoutInfoRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"width",
                                    		lv_width_7_0, 
                                    		"INT");
                            	    

                            }


                            }

                            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleLayoutInfo2530); 

                                	newLeafNode(otherlv_8, grammarAccess.getLayoutInfoAccess().getCommaKeyword_1_5_2());
                                
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1278:1: ( (lv_height_9_0= RULE_INT ) )
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1279:1: (lv_height_9_0= RULE_INT )
                            {
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1279:1: (lv_height_9_0= RULE_INT )
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1280:3: lv_height_9_0= RULE_INT
                            {
                            lv_height_9_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLayoutInfo2547); 

                            			newLeafNode(lv_height_9_0, grammarAccess.getLayoutInfoAccess().getHeightINTTerminalRuleCall_1_5_3_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getLayoutInfoRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"height",
                                    		lv_height_9_0, 
                                    		"INT");
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleLayoutInfo2566); 

                        	newLeafNode(otherlv_10, grammarAccess.getLayoutInfoAccess().getRightSquareBracketKeyword_1_6());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLayoutInfo"


    // $ANTLR start "entryRuleLongState"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1308:1: entryRuleLongState returns [EObject current=null] : iv_ruleLongState= ruleLongState EOF ;
    public final EObject entryRuleLongState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongState = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1309:2: (iv_ruleLongState= ruleLongState EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1310:2: iv_ruleLongState= ruleLongState EOF
            {
             newCompositeNode(grammarAccess.getLongStateRule()); 
            pushFollow(FOLLOW_ruleLongState_in_entryRuleLongState2604);
            iv_ruleLongState=ruleLongState();

            state._fsp--;

             current =iv_ruleLongState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLongState2614); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongState"


    // $ANTLR start "ruleLongState"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1317:1: ruleLongState returns [EObject current=null] : ( () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_code_4_0= RULE_BIN ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= '{' ( (lv_commandList_7_0= ruleCommandList ) )? (otherlv_8= 'transitions' otherlv_9= '{' ( (lv_transition_10_0= ruleDotTransition ) )* otherlv_11= '}' )? otherlv_12= '}' ) ;
    public final EObject ruleLongState() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_code_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_layout_5_0 = null;

        EObject lv_commandList_7_0 = null;

        EObject lv_transition_10_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1320:28: ( ( () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_code_4_0= RULE_BIN ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= '{' ( (lv_commandList_7_0= ruleCommandList ) )? (otherlv_8= 'transitions' otherlv_9= '{' ( (lv_transition_10_0= ruleDotTransition ) )* otherlv_11= '}' )? otherlv_12= '}' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1321:1: ( () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_code_4_0= RULE_BIN ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= '{' ( (lv_commandList_7_0= ruleCommandList ) )? (otherlv_8= 'transitions' otherlv_9= '{' ( (lv_transition_10_0= ruleDotTransition ) )* otherlv_11= '}' )? otherlv_12= '}' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1321:1: ( () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_code_4_0= RULE_BIN ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= '{' ( (lv_commandList_7_0= ruleCommandList ) )? (otherlv_8= 'transitions' otherlv_9= '{' ( (lv_transition_10_0= ruleDotTransition ) )* otherlv_11= '}' )? otherlv_12= '}' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1321:2: () otherlv_1= 'state' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_code_4_0= RULE_BIN ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= '{' ( (lv_commandList_7_0= ruleCommandList ) )? (otherlv_8= 'transitions' otherlv_9= '{' ( (lv_transition_10_0= ruleDotTransition ) )* otherlv_11= '}' )? otherlv_12= '}'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1321:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1322:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLongStateAccess().getStateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleLongState2660); 

                	newLeafNode(otherlv_1, grammarAccess.getLongStateAccess().getStateKeyword_1());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1331:1: ( (lv_name_2_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1332:1: (lv_name_2_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1332:1: (lv_name_2_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1333:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLongState2677); 

            			newLeafNode(lv_name_2_0, grammarAccess.getLongStateAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLongStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1349:2: (otherlv_3= '=' ( (lv_code_4_0= RULE_BIN ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==23) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1349:4: otherlv_3= '=' ( (lv_code_4_0= RULE_BIN ) )
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleLongState2695); 

                        	newLeafNode(otherlv_3, grammarAccess.getLongStateAccess().getEqualsSignKeyword_3_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1353:1: ( (lv_code_4_0= RULE_BIN ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1354:1: (lv_code_4_0= RULE_BIN )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1354:1: (lv_code_4_0= RULE_BIN )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1355:3: lv_code_4_0= RULE_BIN
                    {
                    lv_code_4_0=(Token)match(input,RULE_BIN,FOLLOW_RULE_BIN_in_ruleLongState2712); 

                    			newLeafNode(lv_code_4_0, grammarAccess.getLongStateAccess().getCodeBINTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLongStateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"code",
                            		lv_code_4_0, 
                            		"BIN");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1371:4: ( (lv_layout_5_0= ruleLayoutInfo ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1372:1: (lv_layout_5_0= ruleLayoutInfo )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1372:1: (lv_layout_5_0= ruleLayoutInfo )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1373:3: lv_layout_5_0= ruleLayoutInfo
            {
             
            	        newCompositeNode(grammarAccess.getLongStateAccess().getLayoutLayoutInfoParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLayoutInfo_in_ruleLongState2740);
            lv_layout_5_0=ruleLayoutInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLongStateRule());
            	        }
                   		set(
                   			current, 
                   			"layout",
                    		lv_layout_5_0, 
                    		"LayoutInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleLongState2752); 

                	newLeafNode(otherlv_6, grammarAccess.getLongStateAccess().getLeftCurlyBracketKeyword_5());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1393:1: ( (lv_commandList_7_0= ruleCommandList ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==26) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1394:1: (lv_commandList_7_0= ruleCommandList )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1394:1: (lv_commandList_7_0= ruleCommandList )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1395:3: lv_commandList_7_0= ruleCommandList
                    {
                     
                    	        newCompositeNode(grammarAccess.getLongStateAccess().getCommandListCommandListParserRuleCall_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCommandList_in_ruleLongState2773);
                    lv_commandList_7_0=ruleCommandList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLongStateRule());
                    	        }
                           		set(
                           			current, 
                           			"commandList",
                            		lv_commandList_7_0, 
                            		"CommandList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1411:3: (otherlv_8= 'transitions' otherlv_9= '{' ( (lv_transition_10_0= ruleDotTransition ) )* otherlv_11= '}' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==29) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1411:5: otherlv_8= 'transitions' otherlv_9= '{' ( (lv_transition_10_0= ruleDotTransition ) )* otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleLongState2787); 

                        	newLeafNode(otherlv_8, grammarAccess.getLongStateAccess().getTransitionsKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,19,FOLLOW_19_in_ruleLongState2799); 

                        	newLeafNode(otherlv_9, grammarAccess.getLongStateAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1419:1: ( (lv_transition_10_0= ruleDotTransition ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID||LA33_0==34) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1420:1: (lv_transition_10_0= ruleDotTransition )
                    	    {
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1420:1: (lv_transition_10_0= ruleDotTransition )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1421:3: lv_transition_10_0= ruleDotTransition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLongStateAccess().getTransitionDotTransitionParserRuleCall_7_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleDotTransition_in_ruleLongState2820);
                    	    lv_transition_10_0=ruleDotTransition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getLongStateRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"transition",
                    	            		lv_transition_10_0, 
                    	            		"DotTransition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,25,FOLLOW_25_in_ruleLongState2833); 

                        	newLeafNode(otherlv_11, grammarAccess.getLongStateAccess().getRightCurlyBracketKeyword_7_3());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleLongState2847); 

                	newLeafNode(otherlv_12, grammarAccess.getLongStateAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongState"


    // $ANTLR start "entryRuleShortState"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1453:1: entryRuleShortState returns [EObject current=null] : iv_ruleShortState= ruleShortState EOF ;
    public final EObject entryRuleShortState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShortState = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1454:2: (iv_ruleShortState= ruleShortState EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1455:2: iv_ruleShortState= ruleShortState EOF
            {
             newCompositeNode(grammarAccess.getShortStateRule()); 
            pushFollow(FOLLOW_ruleShortState_in_entryRuleShortState2883);
            iv_ruleShortState=ruleShortState();

            state._fsp--;

             current =iv_ruleShortState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShortState2893); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShortState"


    // $ANTLR start "ruleShortState"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1462:1: ruleShortState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_code_3_0= RULE_BIN ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_layout_6_0= ruleLayoutInfo ) ) ( (lv_commandList_7_0= ruleShortCommandList ) ) ( (lv_transition_8_0= ruleGotoTransition ) )* ) ;
    public final EObject ruleShortState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_code_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_layout_6_0 = null;

        EObject lv_commandList_7_0 = null;

        EObject lv_transition_8_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1465:28: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_code_3_0= RULE_BIN ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_layout_6_0= ruleLayoutInfo ) ) ( (lv_commandList_7_0= ruleShortCommandList ) ) ( (lv_transition_8_0= ruleGotoTransition ) )* ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1466:1: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_code_3_0= RULE_BIN ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_layout_6_0= ruleLayoutInfo ) ) ( (lv_commandList_7_0= ruleShortCommandList ) ) ( (lv_transition_8_0= ruleGotoTransition ) )* )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1466:1: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_code_3_0= RULE_BIN ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_layout_6_0= ruleLayoutInfo ) ) ( (lv_commandList_7_0= ruleShortCommandList ) ) ( (lv_transition_8_0= ruleGotoTransition ) )* )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1466:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_code_3_0= RULE_BIN ) ) otherlv_4= ']' )? otherlv_5= ':' ( (lv_layout_6_0= ruleLayoutInfo ) ) ( (lv_commandList_7_0= ruleShortCommandList ) ) ( (lv_transition_8_0= ruleGotoTransition ) )*
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleShortState2930); 

                	newLeafNode(otherlv_0, grammarAccess.getShortStateAccess().getStateKeyword_0());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1470:1: ( (lv_name_1_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1471:1: (lv_name_1_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1471:1: (lv_name_1_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1472:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShortState2947); 

            			newLeafNode(lv_name_1_0, grammarAccess.getShortStateAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getShortStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1488:2: (otherlv_2= '[' ( (lv_code_3_0= RULE_BIN ) ) otherlv_4= ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1488:4: otherlv_2= '[' ( (lv_code_3_0= RULE_BIN ) ) otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleShortState2965); 

                        	newLeafNode(otherlv_2, grammarAccess.getShortStateAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1492:1: ( (lv_code_3_0= RULE_BIN ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1493:1: (lv_code_3_0= RULE_BIN )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1493:1: (lv_code_3_0= RULE_BIN )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1494:3: lv_code_3_0= RULE_BIN
                    {
                    lv_code_3_0=(Token)match(input,RULE_BIN,FOLLOW_RULE_BIN_in_ruleShortState2982); 

                    			newLeafNode(lv_code_3_0, grammarAccess.getShortStateAccess().getCodeBINTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShortStateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"code",
                            		lv_code_3_0, 
                            		"BIN");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleShortState2999); 

                        	newLeafNode(otherlv_4, grammarAccess.getShortStateAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleShortState3013); 

                	newLeafNode(otherlv_5, grammarAccess.getShortStateAccess().getColonKeyword_3());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1518:1: ( (lv_layout_6_0= ruleLayoutInfo ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1519:1: (lv_layout_6_0= ruleLayoutInfo )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1519:1: (lv_layout_6_0= ruleLayoutInfo )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1520:3: lv_layout_6_0= ruleLayoutInfo
            {
             
            	        newCompositeNode(grammarAccess.getShortStateAccess().getLayoutLayoutInfoParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleLayoutInfo_in_ruleShortState3034);
            lv_layout_6_0=ruleLayoutInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getShortStateRule());
            	        }
                   		set(
                   			current, 
                   			"layout",
                    		lv_layout_6_0, 
                    		"LayoutInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1536:2: ( (lv_commandList_7_0= ruleShortCommandList ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1537:1: (lv_commandList_7_0= ruleShortCommandList )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1537:1: (lv_commandList_7_0= ruleShortCommandList )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1538:3: lv_commandList_7_0= ruleShortCommandList
            {
             
            	        newCompositeNode(grammarAccess.getShortStateAccess().getCommandListShortCommandListParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleShortCommandList_in_ruleShortState3055);
            lv_commandList_7_0=ruleShortCommandList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getShortStateRule());
            	        }
                   		set(
                   			current, 
                   			"commandList",
                    		lv_commandList_7_0, 
                    		"ShortCommandList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1554:2: ( (lv_transition_8_0= ruleGotoTransition ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==32) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1555:1: (lv_transition_8_0= ruleGotoTransition )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1555:1: (lv_transition_8_0= ruleGotoTransition )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1556:3: lv_transition_8_0= ruleGotoTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getShortStateAccess().getTransitionGotoTransitionParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleGotoTransition_in_ruleShortState3076);
            	    lv_transition_8_0=ruleGotoTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getShortStateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transition",
            	            		lv_transition_8_0, 
            	            		"GotoTransition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShortState"


    // $ANTLR start "entryRuleShortCommandList"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1580:1: entryRuleShortCommandList returns [EObject current=null] : iv_ruleShortCommandList= ruleShortCommandList EOF ;
    public final EObject entryRuleShortCommandList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShortCommandList = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1581:2: (iv_ruleShortCommandList= ruleShortCommandList EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1582:2: iv_ruleShortCommandList= ruleShortCommandList EOF
            {
             newCompositeNode(grammarAccess.getShortCommandListRule()); 
            pushFollow(FOLLOW_ruleShortCommandList_in_entryRuleShortCommandList3113);
            iv_ruleShortCommandList=ruleShortCommandList();

            state._fsp--;

             current =iv_ruleShortCommandList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShortCommandList3123); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShortCommandList"


    // $ANTLR start "ruleShortCommandList"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1589:1: ruleShortCommandList returns [EObject current=null] : ( () (otherlv_1= 'set' ( (lv_commands_2_0= ruleCommand ) )+ ( (lv_layout_3_0= ruleLayoutInfo ) ) )? ) ;
    public final EObject ruleShortCommandList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_commands_2_0 = null;

        EObject lv_layout_3_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1592:28: ( ( () (otherlv_1= 'set' ( (lv_commands_2_0= ruleCommand ) )+ ( (lv_layout_3_0= ruleLayoutInfo ) ) )? ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1593:1: ( () (otherlv_1= 'set' ( (lv_commands_2_0= ruleCommand ) )+ ( (lv_layout_3_0= ruleLayoutInfo ) ) )? )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1593:1: ( () (otherlv_1= 'set' ( (lv_commands_2_0= ruleCommand ) )+ ( (lv_layout_3_0= ruleLayoutInfo ) ) )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1593:2: () (otherlv_1= 'set' ( (lv_commands_2_0= ruleCommand ) )+ ( (lv_layout_3_0= ruleLayoutInfo ) ) )?
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1593:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1594:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getShortCommandListAccess().getCommandListAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1599:2: (otherlv_1= 'set' ( (lv_commands_2_0= ruleCommand ) )+ ( (lv_layout_3_0= ruleLayoutInfo ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==31) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1599:4: otherlv_1= 'set' ( (lv_commands_2_0= ruleCommand ) )+ ( (lv_layout_3_0= ruleLayoutInfo ) )
                    {
                    otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleShortCommandList3170); 

                        	newLeafNode(otherlv_1, grammarAccess.getShortCommandListAccess().getSetKeyword_1_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1603:1: ( (lv_commands_2_0= ruleCommand ) )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==RULE_ID) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1604:1: (lv_commands_2_0= ruleCommand )
                    	    {
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1604:1: (lv_commands_2_0= ruleCommand )
                    	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1605:3: lv_commands_2_0= ruleCommand
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getShortCommandListAccess().getCommandsCommandParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCommand_in_ruleShortCommandList3191);
                    	    lv_commands_2_0=ruleCommand();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getShortCommandListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"commands",
                    	            		lv_commands_2_0, 
                    	            		"Command");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1621:3: ( (lv_layout_3_0= ruleLayoutInfo ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1622:1: (lv_layout_3_0= ruleLayoutInfo )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1622:1: (lv_layout_3_0= ruleLayoutInfo )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1623:3: lv_layout_3_0= ruleLayoutInfo
                    {
                     
                    	        newCompositeNode(grammarAccess.getShortCommandListAccess().getLayoutLayoutInfoParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLayoutInfo_in_ruleShortCommandList3213);
                    lv_layout_3_0=ruleLayoutInfo();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getShortCommandListRule());
                    	        }
                           		set(
                           			current, 
                           			"layout",
                            		lv_layout_3_0, 
                            		"LayoutInfo");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShortCommandList"


    // $ANTLR start "entryRuleGotoTransition"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1647:1: entryRuleGotoTransition returns [EObject current=null] : iv_ruleGotoTransition= ruleGotoTransition EOF ;
    public final EObject entryRuleGotoTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGotoTransition = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1648:2: (iv_ruleGotoTransition= ruleGotoTransition EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1649:2: iv_ruleGotoTransition= ruleGotoTransition EOF
            {
             newCompositeNode(grammarAccess.getGotoTransitionRule()); 
            pushFollow(FOLLOW_ruleGotoTransition_in_entryRuleGotoTransition3251);
            iv_ruleGotoTransition=ruleGotoTransition();

            state._fsp--;

             current =iv_ruleGotoTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGotoTransition3261); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGotoTransition"


    // $ANTLR start "ruleGotoTransition"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1656:1: ruleGotoTransition returns [EObject current=null] : (otherlv_0= 'goto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'when' ( (lv_predicate_3_0= rulePredicate ) ) )? ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= ';' ) ;
    public final EObject ruleGotoTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_layout_4_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1659:28: ( (otherlv_0= 'goto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'when' ( (lv_predicate_3_0= rulePredicate ) ) )? ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= ';' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1660:1: (otherlv_0= 'goto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'when' ( (lv_predicate_3_0= rulePredicate ) ) )? ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= ';' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1660:1: (otherlv_0= 'goto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'when' ( (lv_predicate_3_0= rulePredicate ) ) )? ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1660:3: otherlv_0= 'goto' ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'when' ( (lv_predicate_3_0= rulePredicate ) ) )? ( (lv_layout_4_0= ruleLayoutInfo ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleGotoTransition3298); 

                	newLeafNode(otherlv_0, grammarAccess.getGotoTransitionAccess().getGotoKeyword_0());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1664:1: ( (otherlv_1= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1665:1: (otherlv_1= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1665:1: (otherlv_1= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1666:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getGotoTransitionRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGotoTransition3318); 

            		newLeafNode(otherlv_1, grammarAccess.getGotoTransitionAccess().getDstStateCrossReference_1_0()); 
            	

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1677:2: (otherlv_2= 'when' ( (lv_predicate_3_0= rulePredicate ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==33) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1677:4: otherlv_2= 'when' ( (lv_predicate_3_0= rulePredicate ) )
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleGotoTransition3331); 

                        	newLeafNode(otherlv_2, grammarAccess.getGotoTransitionAccess().getWhenKeyword_2_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1681:1: ( (lv_predicate_3_0= rulePredicate ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1682:1: (lv_predicate_3_0= rulePredicate )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1682:1: (lv_predicate_3_0= rulePredicate )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1683:3: lv_predicate_3_0= rulePredicate
                    {
                     
                    	        newCompositeNode(grammarAccess.getGotoTransitionAccess().getPredicatePredicateParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePredicate_in_ruleGotoTransition3352);
                    lv_predicate_3_0=rulePredicate();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGotoTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"predicate",
                            		lv_predicate_3_0, 
                            		"Predicate");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1699:4: ( (lv_layout_4_0= ruleLayoutInfo ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1700:1: (lv_layout_4_0= ruleLayoutInfo )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1700:1: (lv_layout_4_0= ruleLayoutInfo )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1701:3: lv_layout_4_0= ruleLayoutInfo
            {
             
            	        newCompositeNode(grammarAccess.getGotoTransitionAccess().getLayoutLayoutInfoParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLayoutInfo_in_ruleGotoTransition3375);
            lv_layout_4_0=ruleLayoutInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getGotoTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"layout",
                    		lv_layout_4_0, 
                    		"LayoutInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_16_in_ruleGotoTransition3387); 

                	newLeafNode(otherlv_5, grammarAccess.getGotoTransitionAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGotoTransition"


    // $ANTLR start "entryRuleDotTransition"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1729:1: entryRuleDotTransition returns [EObject current=null] : iv_ruleDotTransition= ruleDotTransition EOF ;
    public final EObject entryRuleDotTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDotTransition = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1730:2: (iv_ruleDotTransition= ruleDotTransition EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1731:2: iv_ruleDotTransition= ruleDotTransition EOF
            {
             newCompositeNode(grammarAccess.getDotTransitionRule()); 
            pushFollow(FOLLOW_ruleDotTransition_in_entryRuleDotTransition3423);
            iv_ruleDotTransition=ruleDotTransition();

            state._fsp--;

             current =iv_ruleDotTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDotTransition3433); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDotTransition"


    // $ANTLR start "ruleDotTransition"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1738:1: ruleDotTransition returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) )? otherlv_1= '->' ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'when' ( (lv_predicate_4_0= rulePredicate ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' ) ;
    public final EObject ruleDotTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_predicate_4_0 = null;

        EObject lv_layout_5_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1741:28: ( ( ( ( (otherlv_0= RULE_ID ) )? otherlv_1= '->' ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'when' ( (lv_predicate_4_0= rulePredicate ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1742:1: ( ( ( (otherlv_0= RULE_ID ) )? otherlv_1= '->' ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'when' ( (lv_predicate_4_0= rulePredicate ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1742:1: ( ( ( (otherlv_0= RULE_ID ) )? otherlv_1= '->' ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'when' ( (lv_predicate_4_0= rulePredicate ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1742:2: ( ( (otherlv_0= RULE_ID ) )? otherlv_1= '->' ) ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'when' ( (lv_predicate_4_0= rulePredicate ) ) )? ( (lv_layout_5_0= ruleLayoutInfo ) ) otherlv_6= ';'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1742:2: ( ( (otherlv_0= RULE_ID ) )? otherlv_1= '->' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1742:3: ( (otherlv_0= RULE_ID ) )? otherlv_1= '->'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1742:3: ( (otherlv_0= RULE_ID ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1743:1: (otherlv_0= RULE_ID )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1743:1: (otherlv_0= RULE_ID )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1744:3: otherlv_0= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDotTransitionRule());
                    	        }
                            
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDotTransition3479); 

                    		newLeafNode(otherlv_0, grammarAccess.getDotTransitionAccess().getSrcStateCrossReference_0_0_0()); 
                    	

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleDotTransition3492); 

                	newLeafNode(otherlv_1, grammarAccess.getDotTransitionAccess().getHyphenMinusGreaterThanSignKeyword_0_1());
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1759:2: ( (otherlv_2= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1760:1: (otherlv_2= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1760:1: (otherlv_2= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1761:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDotTransitionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDotTransition3513); 

            		newLeafNode(otherlv_2, grammarAccess.getDotTransitionAccess().getDstStateCrossReference_1_0()); 
            	

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1772:2: (otherlv_3= 'when' ( (lv_predicate_4_0= rulePredicate ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==33) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1772:4: otherlv_3= 'when' ( (lv_predicate_4_0= rulePredicate ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleDotTransition3526); 

                        	newLeafNode(otherlv_3, grammarAccess.getDotTransitionAccess().getWhenKeyword_2_0());
                        
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1776:1: ( (lv_predicate_4_0= rulePredicate ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1777:1: (lv_predicate_4_0= rulePredicate )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1777:1: (lv_predicate_4_0= rulePredicate )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1778:3: lv_predicate_4_0= rulePredicate
                    {
                     
                    	        newCompositeNode(grammarAccess.getDotTransitionAccess().getPredicatePredicateParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePredicate_in_ruleDotTransition3547);
                    lv_predicate_4_0=rulePredicate();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDotTransitionRule());
                    	        }
                           		set(
                           			current, 
                           			"predicate",
                            		lv_predicate_4_0, 
                            		"Predicate");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1794:4: ( (lv_layout_5_0= ruleLayoutInfo ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1795:1: (lv_layout_5_0= ruleLayoutInfo )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1795:1: (lv_layout_5_0= ruleLayoutInfo )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1796:3: lv_layout_5_0= ruleLayoutInfo
            {
             
            	        newCompositeNode(grammarAccess.getDotTransitionAccess().getLayoutLayoutInfoParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleLayoutInfo_in_ruleDotTransition3570);
            lv_layout_5_0=ruleLayoutInfo();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDotTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"layout",
                    		lv_layout_5_0, 
                    		"LayoutInfo");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleDotTransition3582); 

                	newLeafNode(otherlv_6, grammarAccess.getDotTransitionAccess().getSemicolonKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDotTransition"


    // $ANTLR start "entryRuleCommand"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1824:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1825:2: (iv_ruleCommand= ruleCommand EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1826:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand3618);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand3628); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1833:1: ruleCommand returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleOr ) ) otherlv_3= ';' ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1836:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleOr ) ) otherlv_3= ';' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1837:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleOr ) ) otherlv_3= ';' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1837:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleOr ) ) otherlv_3= ';' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1837:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleOr ) ) otherlv_3= ';'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1837:2: ( (otherlv_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1838:1: (otherlv_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1838:1: (otherlv_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1839:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand3673); 

            		newLeafNode(otherlv_0, grammarAccess.getCommandAccess().getNameOutputPortCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleCommand3685); 

                	newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getEqualsSignKeyword_1());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1854:1: ( (lv_value_2_0= ruleOr ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1855:1: (lv_value_2_0= ruleOr )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1855:1: (lv_value_2_0= ruleOr )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1856:3: lv_value_2_0= ruleOr
            {
             
            	        newCompositeNode(grammarAccess.getCommandAccess().getValueOrParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleOr_in_ruleCommand3706);
            lv_value_2_0=ruleOr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCommandRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Or");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleCommand3718); 

                	newLeafNode(otherlv_3, grammarAccess.getCommandAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleConcatExpr"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1884:1: entryRuleConcatExpr returns [EObject current=null] : iv_ruleConcatExpr= ruleConcatExpr EOF ;
    public final EObject entryRuleConcatExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatExpr = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1885:2: (iv_ruleConcatExpr= ruleConcatExpr EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1886:2: iv_ruleConcatExpr= ruleConcatExpr EOF
            {
             newCompositeNode(grammarAccess.getConcatExprRule()); 
            pushFollow(FOLLOW_ruleConcatExpr_in_entryRuleConcatExpr3754);
            iv_ruleConcatExpr=ruleConcatExpr();

            state._fsp--;

             current =iv_ruleConcatExpr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcatExpr3764); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcatExpr"


    // $ANTLR start "ruleConcatExpr"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1893:1: ruleConcatExpr returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_args_2_0= ruleOr ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleOr ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleConcatExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1896:28: ( ( () otherlv_1= '{' ( (lv_args_2_0= ruleOr ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleOr ) ) )* otherlv_5= '}' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1897:1: ( () otherlv_1= '{' ( (lv_args_2_0= ruleOr ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleOr ) ) )* otherlv_5= '}' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1897:1: ( () otherlv_1= '{' ( (lv_args_2_0= ruleOr ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleOr ) ) )* otherlv_5= '}' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1897:2: () otherlv_1= '{' ( (lv_args_2_0= ruleOr ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleOr ) ) )* otherlv_5= '}'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1897:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1898:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConcatExprAccess().getConcatExprAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleConcatExpr3810); 

                	newLeafNode(otherlv_1, grammarAccess.getConcatExprAccess().getLeftCurlyBracketKeyword_1());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1907:1: ( (lv_args_2_0= ruleOr ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1908:1: (lv_args_2_0= ruleOr )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1908:1: (lv_args_2_0= ruleOr )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1909:3: lv_args_2_0= ruleOr
            {
             
            	        newCompositeNode(grammarAccess.getConcatExprAccess().getArgsOrParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleOr_in_ruleConcatExpr3831);
            lv_args_2_0=ruleOr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConcatExprRule());
            	        }
                   		add(
                   			current, 
                   			"args",
                    		lv_args_2_0, 
                    		"Or");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1925:2: (otherlv_3= ',' ( (lv_args_4_0= ruleOr ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==14) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1925:4: otherlv_3= ',' ( (lv_args_4_0= ruleOr ) )
            	    {
            	    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleConcatExpr3844); 

            	        	newLeafNode(otherlv_3, grammarAccess.getConcatExprAccess().getCommaKeyword_3_0());
            	        
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1929:1: ( (lv_args_4_0= ruleOr ) )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1930:1: (lv_args_4_0= ruleOr )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1930:1: (lv_args_4_0= ruleOr )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1931:3: lv_args_4_0= ruleOr
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConcatExprAccess().getArgsOrParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOr_in_ruleConcatExpr3865);
            	    lv_args_4_0=ruleOr();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConcatExprRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"args",
            	            		lv_args_4_0, 
            	            		"Or");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleConcatExpr3879); 

                	newLeafNode(otherlv_5, grammarAccess.getConcatExprAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcatExpr"


    // $ANTLR start "entryRulePortRef"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1959:1: entryRulePortRef returns [EObject current=null] : iv_rulePortRef= rulePortRef EOF ;
    public final EObject entryRulePortRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortRef = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1960:2: (iv_rulePortRef= rulePortRef EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1961:2: iv_rulePortRef= rulePortRef EOF
            {
             newCompositeNode(grammarAccess.getPortRefRule()); 
            pushFollow(FOLLOW_rulePortRef_in_entryRulePortRef3915);
            iv_rulePortRef=rulePortRef();

            state._fsp--;

             current =iv_rulePortRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePortRef3925); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortRef"


    // $ANTLR start "rulePortRef"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1968:1: rulePortRef returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_range_2_0= ruleRange ) )? ) ;
    public final EObject rulePortRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_range_2_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1971:28: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_range_2_0= ruleRange ) )? ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1972:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_range_2_0= ruleRange ) )? )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1972:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_range_2_0= ruleRange ) )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1972:2: () ( (otherlv_1= RULE_ID ) ) ( (lv_range_2_0= ruleRange ) )?
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1972:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1973:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPortRefAccess().getPortRefAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1978:2: ( (otherlv_1= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1979:1: (otherlv_1= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1979:1: (otherlv_1= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1980:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPortRefRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePortRef3979); 

            		newLeafNode(otherlv_1, grammarAccess.getPortRefAccess().getPortPortCrossReference_1_0()); 
            	

            }


            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1991:2: ( (lv_range_2_0= ruleRange ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==13) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1992:1: (lv_range_2_0= ruleRange )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1992:1: (lv_range_2_0= ruleRange )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:1993:3: lv_range_2_0= ruleRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getPortRefAccess().getRangeRangeParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRange_in_rulePortRef4000);
                    lv_range_2_0=ruleRange();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPortRefRule());
                    	        }
                           		set(
                           			current, 
                           			"range",
                            		lv_range_2_0, 
                            		"Range");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortRef"


    // $ANTLR start "entryRuleConstRef"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2017:1: entryRuleConstRef returns [EObject current=null] : iv_ruleConstRef= ruleConstRef EOF ;
    public final EObject entryRuleConstRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstRef = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2018:2: (iv_ruleConstRef= ruleConstRef EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2019:2: iv_ruleConstRef= ruleConstRef EOF
            {
             newCompositeNode(grammarAccess.getConstRefRule()); 
            pushFollow(FOLLOW_ruleConstRef_in_entryRuleConstRef4037);
            iv_ruleConstRef=ruleConstRef();

            state._fsp--;

             current =iv_ruleConstRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstRef4047); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstRef"


    // $ANTLR start "ruleConstRef"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2026:1: ruleConstRef returns [EObject current=null] : ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleConstRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2029:28: ( ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2030:1: ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2030:1: ( () otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2030:2: () otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2030:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2031:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConstRefAccess().getConstRefAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleConstRef4093); 

                	newLeafNode(otherlv_1, grammarAccess.getConstRefAccess().getNumberSignKeyword_1());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2040:1: ( (otherlv_2= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2041:1: (otherlv_2= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2041:1: (otherlv_2= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2042:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConstRefRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstRef4113); 

            		newLeafNode(otherlv_2, grammarAccess.getConstRefAccess().getConstConstantDefCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstRef"


    // $ANTLR start "entryRuleRange"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2061:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2062:2: (iv_ruleRange= ruleRange EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2063:2: iv_ruleRange= ruleRange EOF
            {
             newCompositeNode(grammarAccess.getRangeRule()); 
            pushFollow(FOLLOW_ruleRange_in_entryRuleRange4149);
            iv_ruleRange=ruleRange();

            state._fsp--;

             current =iv_ruleRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRange4159); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2070:1: ruleRange returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_ub_1_0= RULE_INT ) ) otherlv_2= ':' )? ( (lv_lb_3_0= RULE_INT ) ) otherlv_4= ']' ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_ub_1_0=null;
        Token otherlv_2=null;
        Token lv_lb_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2073:28: ( (otherlv_0= '[' ( ( (lv_ub_1_0= RULE_INT ) ) otherlv_2= ':' )? ( (lv_lb_3_0= RULE_INT ) ) otherlv_4= ']' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2074:1: (otherlv_0= '[' ( ( (lv_ub_1_0= RULE_INT ) ) otherlv_2= ':' )? ( (lv_lb_3_0= RULE_INT ) ) otherlv_4= ']' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2074:1: (otherlv_0= '[' ( ( (lv_ub_1_0= RULE_INT ) ) otherlv_2= ':' )? ( (lv_lb_3_0= RULE_INT ) ) otherlv_4= ']' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2074:3: otherlv_0= '[' ( ( (lv_ub_1_0= RULE_INT ) ) otherlv_2= ':' )? ( (lv_lb_3_0= RULE_INT ) ) otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleRange4196); 

                	newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getLeftSquareBracketKeyword_0());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2078:1: ( ( (lv_ub_1_0= RULE_INT ) ) otherlv_2= ':' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_INT) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==30) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2078:2: ( (lv_ub_1_0= RULE_INT ) ) otherlv_2= ':'
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2078:2: ( (lv_ub_1_0= RULE_INT ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2079:1: (lv_ub_1_0= RULE_INT )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2079:1: (lv_ub_1_0= RULE_INT )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2080:3: lv_ub_1_0= RULE_INT
                    {
                    lv_ub_1_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRange4214); 

                    			newLeafNode(lv_ub_1_0, grammarAccess.getRangeAccess().getUbINTTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRangeRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"ub",
                            		lv_ub_1_0, 
                            		"INT");
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleRange4231); 

                        	newLeafNode(otherlv_2, grammarAccess.getRangeAccess().getColonKeyword_1_1());
                        

                    }
                    break;

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2100:3: ( (lv_lb_3_0= RULE_INT ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2101:1: (lv_lb_3_0= RULE_INT )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2101:1: (lv_lb_3_0= RULE_INT )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2102:3: lv_lb_3_0= RULE_INT
            {
            lv_lb_3_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleRange4250); 

            			newLeafNode(lv_lb_3_0, grammarAccess.getRangeAccess().getLbINTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRangeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"lb",
                    		lv_lb_3_0, 
                    		"INT");
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleRange4267); 

                	newLeafNode(otherlv_4, grammarAccess.getRangeAccess().getRightSquareBracketKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRulePredicate"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2130:1: entryRulePredicate returns [EObject current=null] : iv_rulePredicate= rulePredicate EOF ;
    public final EObject entryRulePredicate() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicate = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2131:2: (iv_rulePredicate= rulePredicate EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2132:2: iv_rulePredicate= rulePredicate EOF
            {
             newCompositeNode(grammarAccess.getPredicateRule()); 
            pushFollow(FOLLOW_rulePredicate_in_entryRulePredicate4303);
            iv_rulePredicate=rulePredicate();

            state._fsp--;

             current =iv_rulePredicate; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePredicate4313); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePredicate"


    // $ANTLR start "rulePredicate"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2139:1: rulePredicate returns [EObject current=null] : (this_Default_0= ruleDefault | this_Or_1= ruleOr ) ;
    public final EObject rulePredicate() throws RecognitionException {
        EObject current = null;

        EObject this_Default_0 = null;

        EObject this_Or_1 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2142:28: ( (this_Default_0= ruleDefault | this_Or_1= ruleOr ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2143:1: (this_Default_0= ruleDefault | this_Or_1= ruleOr )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2143:1: (this_Default_0= ruleDefault | this_Or_1= ruleOr )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==36) ) {
                alt45=1;
            }
            else if ( (LA45_0==RULE_ID||(LA45_0>=RULE_BIN && LA45_0<=RULE_HEX)||LA45_0==19||LA45_0==35||LA45_0==41||LA45_0==43) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2144:5: this_Default_0= ruleDefault
                    {
                     
                            newCompositeNode(grammarAccess.getPredicateAccess().getDefaultParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDefault_in_rulePredicate4360);
                    this_Default_0=ruleDefault();

                    state._fsp--;

                     
                            current = this_Default_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2154:5: this_Or_1= ruleOr
                    {
                     
                            newCompositeNode(grammarAccess.getPredicateAccess().getOrParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleOr_in_rulePredicate4387);
                    this_Or_1=ruleOr();

                    state._fsp--;

                     
                            current = this_Or_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePredicate"


    // $ANTLR start "entryRuleDefault"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2170:1: entryRuleDefault returns [EObject current=null] : iv_ruleDefault= ruleDefault EOF ;
    public final EObject entryRuleDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefault = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2171:2: (iv_ruleDefault= ruleDefault EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2172:2: iv_ruleDefault= ruleDefault EOF
            {
             newCompositeNode(grammarAccess.getDefaultRule()); 
            pushFollow(FOLLOW_ruleDefault_in_entryRuleDefault4422);
            iv_ruleDefault=ruleDefault();

            state._fsp--;

             current =iv_ruleDefault; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefault4432); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefault"


    // $ANTLR start "ruleDefault"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2179:1: ruleDefault returns [EObject current=null] : ( () otherlv_1= 'default' ) ;
    public final EObject ruleDefault() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2182:28: ( ( () otherlv_1= 'default' ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2183:1: ( () otherlv_1= 'default' )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2183:1: ( () otherlv_1= 'default' )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2183:2: () otherlv_1= 'default'
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2183:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2184:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDefaultAccess().getDefaultPredicateAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleDefault4478); 

                	newLeafNode(otherlv_1, grammarAccess.getDefaultAccess().getDefaultKeyword_1());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefault"


    // $ANTLR start "entryRuleOr"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2201:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2202:2: (iv_ruleOr= ruleOr EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2203:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_ruleOr_in_entryRuleOr4514);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOr4524); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2210:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= '+' ( (lv_args_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2213:28: ( (this_And_0= ruleAnd ( () otherlv_2= '+' ( (lv_args_3_0= ruleAnd ) ) )* ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2214:1: (this_And_0= ruleAnd ( () otherlv_2= '+' ( (lv_args_3_0= ruleAnd ) ) )* )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2214:1: (this_And_0= ruleAnd ( () otherlv_2= '+' ( (lv_args_3_0= ruleAnd ) ) )* )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2215:5: this_And_0= ruleAnd ( () otherlv_2= '+' ( (lv_args_3_0= ruleAnd ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAnd_in_ruleOr4571);
            this_And_0=ruleAnd();

            state._fsp--;

             
                    current = this_And_0; 
                    afterParserOrEnumRuleCall();
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2223:1: ( () otherlv_2= '+' ( (lv_args_3_0= ruleAnd ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==37) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2223:2: () otherlv_2= '+' ( (lv_args_3_0= ruleAnd ) )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2223:2: ()
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2224:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getOrAccess().getOrExprArgsAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,37,FOLLOW_37_in_ruleOr4592); 

            	        	newLeafNode(otherlv_2, grammarAccess.getOrAccess().getPlusSignKeyword_1_1());
            	        
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2233:1: ( (lv_args_3_0= ruleAnd ) )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2234:1: (lv_args_3_0= ruleAnd )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2234:1: (lv_args_3_0= ruleAnd )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2235:3: lv_args_3_0= ruleAnd
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOrAccess().getArgsAndParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAnd_in_ruleOr4613);
            	    lv_args_3_0=ruleAnd();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOrRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"args",
            	            		lv_args_3_0, 
            	            		"And");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2259:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2260:2: (iv_ruleAnd= ruleAnd EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2261:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_ruleAnd_in_entryRuleAnd4651);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAnd4661); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2268:1: ruleAnd returns [EObject current=null] : (this_Cmp_0= ruleCmp ( () otherlv_2= '.' ( (lv_args_3_0= ruleCmp ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Cmp_0 = null;

        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2271:28: ( (this_Cmp_0= ruleCmp ( () otherlv_2= '.' ( (lv_args_3_0= ruleCmp ) ) )* ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2272:1: (this_Cmp_0= ruleCmp ( () otherlv_2= '.' ( (lv_args_3_0= ruleCmp ) ) )* )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2272:1: (this_Cmp_0= ruleCmp ( () otherlv_2= '.' ( (lv_args_3_0= ruleCmp ) ) )* )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2273:5: this_Cmp_0= ruleCmp ( () otherlv_2= '.' ( (lv_args_3_0= ruleCmp ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getAndAccess().getCmpParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleCmp_in_ruleAnd4708);
            this_Cmp_0=ruleCmp();

            state._fsp--;

             
                    current = this_Cmp_0; 
                    afterParserOrEnumRuleCall();
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2281:1: ( () otherlv_2= '.' ( (lv_args_3_0= ruleCmp ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==38) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2281:2: () otherlv_2= '.' ( (lv_args_3_0= ruleCmp ) )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2281:2: ()
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2282:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getAndAccess().getAndExprArgsAction_1_0(),
            	                current);
            	        

            	    }

            	    otherlv_2=(Token)match(input,38,FOLLOW_38_in_ruleAnd4729); 

            	        	newLeafNode(otherlv_2, grammarAccess.getAndAccess().getFullStopKeyword_1_1());
            	        
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2291:1: ( (lv_args_3_0= ruleCmp ) )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2292:1: (lv_args_3_0= ruleCmp )
            	    {
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2292:1: (lv_args_3_0= ruleCmp )
            	    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2293:3: lv_args_3_0= ruleCmp
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAndAccess().getArgsCmpParserRuleCall_1_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCmp_in_ruleAnd4750);
            	    lv_args_3_0=ruleCmp();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAndRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"args",
            	            		lv_args_3_0, 
            	            		"Cmp");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleCmp"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2317:1: entryRuleCmp returns [EObject current=null] : iv_ruleCmp= ruleCmp EOF ;
    public final EObject entryRuleCmp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCmp = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2318:2: (iv_ruleCmp= ruleCmp EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2319:2: iv_ruleCmp= ruleCmp EOF
            {
             newCompositeNode(grammarAccess.getCmpRule()); 
            pushFollow(FOLLOW_ruleCmp_in_entryRuleCmp4788);
            iv_ruleCmp=ruleCmp();

            state._fsp--;

             current =iv_ruleCmp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCmp4798); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCmp"


    // $ANTLR start "ruleCmp"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2326:1: ruleCmp returns [EObject current=null] : (this_Primary_0= rulePrimary ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) ) ) ( (lv_args_3_0= rulePrimary ) ) )? ) ;
    public final EObject ruleCmp() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Primary_0 = null;

        EObject lv_args_3_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2329:28: ( (this_Primary_0= rulePrimary ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) ) ) ( (lv_args_3_0= rulePrimary ) ) )? ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2330:1: (this_Primary_0= rulePrimary ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) ) ) ( (lv_args_3_0= rulePrimary ) ) )? )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2330:1: (this_Primary_0= rulePrimary ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) ) ) ( (lv_args_3_0= rulePrimary ) ) )? )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2331:5: this_Primary_0= rulePrimary ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) ) ) ( (lv_args_3_0= rulePrimary ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getCmpAccess().getPrimaryParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulePrimary_in_ruleCmp4845);
            this_Primary_0=rulePrimary();

            state._fsp--;

             
                    current = this_Primary_0; 
                    afterParserOrEnumRuleCall();
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2339:1: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) ) ) ( (lv_args_3_0= rulePrimary ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=39 && LA49_0<=40)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2339:2: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) ) ) ( (lv_args_3_0= rulePrimary ) )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2339:2: ()
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2340:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getCmpAccess().getCmpExprArgsAction_1_0(),
                                current);
                        

                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2345:2: ( ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2346:1: ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2346:1: ( (lv_op_2_1= '==' | lv_op_2_2= '/=' ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2347:1: (lv_op_2_1= '==' | lv_op_2_2= '/=' )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2347:1: (lv_op_2_1= '==' | lv_op_2_2= '/=' )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==39) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==40) ) {
                        alt48=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }
                    switch (alt48) {
                        case 1 :
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2348:3: lv_op_2_1= '=='
                            {
                            lv_op_2_1=(Token)match(input,39,FOLLOW_39_in_ruleCmp4874); 

                                    newLeafNode(lv_op_2_1, grammarAccess.getCmpAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCmpRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_2_1, null);
                            	    

                            }
                            break;
                        case 2 :
                            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2360:8: lv_op_2_2= '/='
                            {
                            lv_op_2_2=(Token)match(input,40,FOLLOW_40_in_ruleCmp4903); 

                                    newLeafNode(lv_op_2_2, grammarAccess.getCmpAccess().getOpSolidusEqualsSignKeyword_1_1_0_1());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getCmpRule());
                            	        }
                                   		setWithLastConsumed(current, "op", lv_op_2_2, null);
                            	    

                            }
                            break;

                    }


                    }


                    }

                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2375:2: ( (lv_args_3_0= rulePrimary ) )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2376:1: (lv_args_3_0= rulePrimary )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2376:1: (lv_args_3_0= rulePrimary )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2377:3: lv_args_3_0= rulePrimary
                    {
                     
                    	        newCompositeNode(grammarAccess.getCmpAccess().getArgsPrimaryParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimary_in_ruleCmp4940);
                    lv_args_3_0=rulePrimary();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCmpRule());
                    	        }
                           		add(
                           			current, 
                           			"args",
                            		lv_args_3_0, 
                            		"Primary");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCmp"


    // $ANTLR start "entryRulePrimary"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2401:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2402:2: (iv_rulePrimary= rulePrimary EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2403:2: iv_rulePrimary= rulePrimary EOF
            {
             newCompositeNode(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_rulePrimary_in_entryRulePrimary4978);
            iv_rulePrimary=rulePrimary();

            state._fsp--;

             current =iv_rulePrimary; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimary4988); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2410:1: rulePrimary returns [EObject current=null] : ( (otherlv_0= '(' this_Or_1= ruleOr otherlv_2= ')' ) | this_Constant_3= ruleConstant | this_Not_4= ruleNot | this_ConcatExpr_5= ruleConcatExpr | this_PortRef_6= rulePortRef | this_ConstRef_7= ruleConstRef ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Or_1 = null;

        EObject this_Constant_3 = null;

        EObject this_Not_4 = null;

        EObject this_ConcatExpr_5 = null;

        EObject this_PortRef_6 = null;

        EObject this_ConstRef_7 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2413:28: ( ( (otherlv_0= '(' this_Or_1= ruleOr otherlv_2= ')' ) | this_Constant_3= ruleConstant | this_Not_4= ruleNot | this_ConcatExpr_5= ruleConcatExpr | this_PortRef_6= rulePortRef | this_ConstRef_7= ruleConstRef ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2414:1: ( (otherlv_0= '(' this_Or_1= ruleOr otherlv_2= ')' ) | this_Constant_3= ruleConstant | this_Not_4= ruleNot | this_ConcatExpr_5= ruleConcatExpr | this_PortRef_6= rulePortRef | this_ConstRef_7= ruleConstRef )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2414:1: ( (otherlv_0= '(' this_Or_1= ruleOr otherlv_2= ')' ) | this_Constant_3= ruleConstant | this_Not_4= ruleNot | this_ConcatExpr_5= ruleConcatExpr | this_PortRef_6= rulePortRef | this_ConstRef_7= ruleConstRef )
            int alt50=6;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt50=1;
                }
                break;
            case RULE_BIN:
            case RULE_HEX:
                {
                alt50=2;
                }
                break;
            case 43:
                {
                alt50=3;
                }
                break;
            case 19:
                {
                alt50=4;
                }
                break;
            case RULE_ID:
                {
                alt50=5;
                }
                break;
            case 35:
                {
                alt50=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2414:2: (otherlv_0= '(' this_Or_1= ruleOr otherlv_2= ')' )
                    {
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2414:2: (otherlv_0= '(' this_Or_1= ruleOr otherlv_2= ')' )
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2414:4: otherlv_0= '(' this_Or_1= ruleOr otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,41,FOLLOW_41_in_rulePrimary5026); 

                        	newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
                        
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getOrParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleOr_in_rulePrimary5048);
                    this_Or_1=ruleOr();

                    state._fsp--;

                     
                            current = this_Or_1; 
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,42,FOLLOW_42_in_rulePrimary5059); 

                        	newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2433:5: this_Constant_3= ruleConstant
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getConstantParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleConstant_in_rulePrimary5088);
                    this_Constant_3=ruleConstant();

                    state._fsp--;

                     
                            current = this_Constant_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2443:5: this_Not_4= ruleNot
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getNotParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleNot_in_rulePrimary5115);
                    this_Not_4=ruleNot();

                    state._fsp--;

                     
                            current = this_Not_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2453:5: this_ConcatExpr_5= ruleConcatExpr
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getConcatExprParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleConcatExpr_in_rulePrimary5142);
                    this_ConcatExpr_5=ruleConcatExpr();

                    state._fsp--;

                     
                            current = this_ConcatExpr_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2463:5: this_PortRef_6= rulePortRef
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getPortRefParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_rulePortRef_in_rulePrimary5169);
                    this_PortRef_6=rulePortRef();

                    state._fsp--;

                     
                            current = this_PortRef_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2473:5: this_ConstRef_7= ruleConstRef
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryAccess().getConstRefParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleConstRef_in_rulePrimary5196);
                    this_ConstRef_7=ruleConstRef();

                    state._fsp--;

                     
                            current = this_ConstRef_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleNot"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2489:1: entryRuleNot returns [EObject current=null] : iv_ruleNot= ruleNot EOF ;
    public final EObject entryRuleNot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNot = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2490:2: (iv_ruleNot= ruleNot EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2491:2: iv_ruleNot= ruleNot EOF
            {
             newCompositeNode(grammarAccess.getNotRule()); 
            pushFollow(FOLLOW_ruleNot_in_entryRuleNot5231);
            iv_ruleNot=ruleNot();

            state._fsp--;

             current =iv_ruleNot; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNot5241); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNot"


    // $ANTLR start "ruleNot"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2498:1: ruleNot returns [EObject current=null] : ( () otherlv_1= '/' ( (lv_args_2_0= rulePrimary ) ) ) ;
    public final EObject ruleNot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_args_2_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2501:28: ( ( () otherlv_1= '/' ( (lv_args_2_0= rulePrimary ) ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2502:1: ( () otherlv_1= '/' ( (lv_args_2_0= rulePrimary ) ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2502:1: ( () otherlv_1= '/' ( (lv_args_2_0= rulePrimary ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2502:2: () otherlv_1= '/' ( (lv_args_2_0= rulePrimary ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2502:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2503:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNotAccess().getNotExprAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleNot5287); 

                	newLeafNode(otherlv_1, grammarAccess.getNotAccess().getSolidusKeyword_1());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2512:1: ( (lv_args_2_0= rulePrimary ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2513:1: (lv_args_2_0= rulePrimary )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2513:1: (lv_args_2_0= rulePrimary )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2514:3: lv_args_2_0= rulePrimary
            {
             
            	        newCompositeNode(grammarAccess.getNotAccess().getArgsPrimaryParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_rulePrimary_in_ruleNot5308);
            lv_args_2_0=rulePrimary();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNotRule());
            	        }
                   		add(
                   			current, 
                   			"args",
                    		lv_args_2_0, 
                    		"Primary");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNot"


    // $ANTLR start "entryRuleConstant"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2538:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2539:2: (iv_ruleConstant= ruleConstant EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2540:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant5344);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant5354); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2547:1: ruleConstant returns [EObject current=null] : ( () ( ( (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX ) ) ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;

         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2550:28: ( ( () ( ( (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX ) ) ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2551:1: ( () ( ( (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX ) ) ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2551:1: ( () ( ( (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX ) ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2551:2: () ( ( (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX ) ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2551:2: ()
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2552:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConstantAccess().getConstantAction_0(),
                        current);
                

            }

            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2557:2: ( ( (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2558:1: ( (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2558:1: ( (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2559:1: (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2559:1: (lv_value_1_1= RULE_BIN | lv_value_1_2= RULE_HEX )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_BIN) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_HEX) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2560:3: lv_value_1_1= RULE_BIN
                    {
                    lv_value_1_1=(Token)match(input,RULE_BIN,FOLLOW_RULE_BIN_in_ruleConstant5407); 

                    			newLeafNode(lv_value_1_1, grammarAccess.getConstantAccess().getValueBINTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_1_1, 
                            		"BIN");
                    	    

                    }
                    break;
                case 2 :
                    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2575:8: lv_value_1_2= RULE_HEX
                    {
                    lv_value_1_2=(Token)match(input,RULE_HEX,FOLLOW_RULE_HEX_in_ruleConstant5427); 

                    			newLeafNode(lv_value_1_2, grammarAccess.getConstantAccess().getValueHEXTerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_1_2, 
                            		"HEX");
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleConstantDef"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2601:1: entryRuleConstantDef returns [EObject current=null] : iv_ruleConstantDef= ruleConstantDef EOF ;
    public final EObject entryRuleConstantDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDef = null;


        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2602:2: (iv_ruleConstantDef= ruleConstantDef EOF )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2603:2: iv_ruleConstantDef= ruleConstantDef EOF
            {
             newCompositeNode(grammarAccess.getConstantDefRule()); 
            pushFollow(FOLLOW_ruleConstantDef_in_entryRuleConstantDef5471);
            iv_ruleConstantDef=ruleConstantDef();

            state._fsp--;

             current =iv_ruleConstantDef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDef5481); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantDef"


    // $ANTLR start "ruleConstantDef"
    // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2610:1: ruleConstantDef returns [EObject current=null] : (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleConstant ) ) ) ;
    public final EObject ruleConstantDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2613:28: ( (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleConstant ) ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2614:1: (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleConstant ) ) )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2614:1: (otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleConstant ) ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2614:3: otherlv_0= 'define' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleConstant ) )
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleConstantDef5518); 

                	newLeafNode(otherlv_0, grammarAccess.getConstantDefAccess().getDefineKeyword_0());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2618:1: ( (lv_name_1_0= RULE_ID ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2619:1: (lv_name_1_0= RULE_ID )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2619:1: (lv_name_1_0= RULE_ID )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2620:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstantDef5535); 

            			newLeafNode(lv_name_1_0, grammarAccess.getConstantDefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantDefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleConstantDef5552); 

                	newLeafNode(otherlv_2, grammarAccess.getConstantDefAccess().getEqualsSignKeyword_2());
                
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2640:1: ( (lv_value_3_0= ruleConstant ) )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2641:1: (lv_value_3_0= ruleConstant )
            {
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2641:1: (lv_value_3_0= ruleConstant )
            // ../logisim-evolution/src-gen/com/cburch/logisim/statemachine/parser/antlr/internal/InternalFSMDSL.g:2642:3: lv_value_3_0= ruleConstant
            {
             
            	        newCompositeNode(grammarAccess.getConstantDefAccess().getValueConstantParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleConstant_in_ruleConstantDef5573);
            lv_value_3_0=ruleConstant();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDefRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"Constant");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantDef"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\35\uffff";
    static final String DFA1_eofS =
        "\1\2\34\uffff";
    static final String DFA1_minS =
        "\1\15\2\uffff\1\17\1\4\1\15\1\27\1\4\1\6\1\15\1\4\2\16\1\5\1\4\2\uffff\1\54\1\17\1\15\1\4\1\16\1\5\1\27\1\17\1\6\3\16";
    static final String DFA1_maxS =
        "\1\54\2\uffff\1\54\1\4\1\15\1\27\1\17\1\7\1\17\1\53\2\17\1\5\1\4\2\uffff\1\54\2\17\1\4\1\17\1\5\1\27\1\17\1\7\3\17";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\14\uffff\1\4\1\3\14\uffff";
    static final String DFA1_specialS =
        "\35\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\3\3\uffff\2\1\31\uffff\1\2",
            "",
            "",
            "\1\5\34\uffff\1\4",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11\12\uffff\1\12",
            "\1\13\1\14",
            "\1\15\1\16\1\12",
            "\1\17\1\uffff\2\17\5\uffff\1\20\5\uffff\1\17\17\uffff\2\17\4\uffff\1\17\1\uffff\1\17",
            "\1\21\1\5",
            "\1\21\1\5",
            "\1\22",
            "\1\23",
            "",
            "",
            "\1\24",
            "\1\25",
            "\1\26\1\16\1\12",
            "\1\27",
            "\1\16\1\12",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33\1\34",
            "\1\16\1\12",
            "\1\21\1\5",
            "\1\21\1\5"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "80:1: (this_FSM_0= ruleFSM | this_ConstantDefList_1= ruleConstantDefList | this_CommandStmt_2= ruleCommandStmt | this_PredicateStmt_3= rulePredicateStmt )";
        }
    }
 

    public static final BitSet FOLLOW_ruleTOP_in_entryRuleTOP75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTOP85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFSM_in_ruleTOP132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefList_in_ruleTOP159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandStmt_in_ruleTOP186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicateStmt_in_ruleTOP213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandStmt_in_entryRuleCommandStmt248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandStmt258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleCommandStmt295 = new BitSet(new long[]{0x0000100000008000L});
    public static final BitSet FOLLOW_ruleConstantDef_in_ruleCommandStmt317 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleCommandStmt330 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleConstantDef_in_ruleCommandStmt351 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleCommandStmt367 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCommandStmt379 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleShortInputPort_in_ruleCommandStmt401 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleCommandStmt414 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleShortInputPort_in_ruleCommandStmt435 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleCommandStmt451 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCommandStmt463 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleShortOutputPort_in_ruleCommandStmt485 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleCommandStmt498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleShortOutputPort_in_ruleCommandStmt519 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleCommandStmt535 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleCommandStmt557 = new BitSet(new long[]{0x0000000000010012L});
    public static final BitSet FOLLOW_16_in_ruleCommandStmt570 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleCommandStmt595 = new BitSet(new long[]{0x0000000000010012L});
    public static final BitSet FOLLOW_16_in_ruleCommandStmt608 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleConstantDefList_in_entryRuleConstantDefList648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDefList658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDef_in_ruleConstantDefList705 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConstantDefList718 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleConstantDef_in_ruleConstantDefList739 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConstantDefList754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicateStmt_in_entryRulePredicateStmt791 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePredicateStmt801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePredicateStmt838 = new BitSet(new long[]{0x0000100000008000L});
    public static final BitSet FOLLOW_ruleConstantDef_in_rulePredicateStmt860 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_rulePredicateStmt873 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleConstantDef_in_rulePredicateStmt894 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_rulePredicateStmt910 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePredicateStmt922 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleShortInputPort_in_rulePredicateStmt944 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_rulePredicateStmt957 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleShortInputPort_in_rulePredicateStmt978 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_rulePredicateStmt994 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_rulePredicate_in_rulePredicateStmt1015 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulePredicateStmt1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFSM_in_entryRuleFSM1063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFSM1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleFSM1120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_18_in_ruleFSM1138 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFSM1156 = new BitSet(new long[]{0x0000000008080000L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleFSM1182 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFSM1194 = new BitSet(new long[]{0x0000100000300000L});
    public static final BitSet FOLLOW_ruleConstantDef_in_ruleFSM1216 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFSM1228 = new BitSet(new long[]{0x0000100000300000L});
    public static final BitSet FOLLOW_20_in_ruleFSM1244 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleInputPort_in_ruleFSM1265 = new BitSet(new long[]{0x0000000000700010L});
    public static final BitSet FOLLOW_21_in_ruleFSM1286 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleOutputPort_in_ruleFSM1307 = new BitSet(new long[]{0x0000000000700010L});
    public static final BitSet FOLLOW_22_in_ruleFSM1324 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleFSM1336 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleFSM1353 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFSM1370 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFSM1384 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleFSM1396 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFSM1416 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFSM1428 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_ruleLongState_in_ruleFSM1452 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_ruleShortState_in_ruleFSM1471 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_25_in_ruleFSM1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShortInputPort_in_entryRuleShortInputPort1527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShortInputPort1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShortInputPort1588 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleShortInputPort1606 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleShortInputPort1623 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleShortInputPort1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShortOutputPort_in_entryRuleShortOutputPort1678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShortOutputPort1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShortOutputPort1739 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleShortOutputPort1757 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleShortOutputPort1774 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleShortOutputPort1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInputPort_in_entryRuleInputPort1829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInputPort1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInputPort1890 = new BitSet(new long[]{0x0000000008012000L});
    public static final BitSet FOLLOW_13_in_ruleInputPort1908 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleInputPort1925 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleInputPort1942 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleInputPort1965 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleInputPort1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutputPort_in_entryRuleOutputPort2013 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutputPort2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleOutputPort2074 = new BitSet(new long[]{0x0000000008012000L});
    public static final BitSet FOLLOW_13_in_ruleOutputPort2092 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleOutputPort2109 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleOutputPort2126 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleOutputPort2149 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleOutputPort2161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommandList_in_entryRuleCommandList2197 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommandList2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleCommandList2254 = new BitSet(new long[]{0x0000000008080000L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleCommandList2275 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleCommandList2287 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleCommandList2308 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_ruleCommandList2321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_entryRuleLayoutInfo2358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLayoutInfo2368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleLayoutInfo2415 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLayoutInfo2427 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLayoutInfo2444 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLayoutInfo2461 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLayoutInfo2478 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleLayoutInfo2496 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLayoutInfo2513 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLayoutInfo2530 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLayoutInfo2547 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleLayoutInfo2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLongState_in_entryRuleLongState2604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLongState2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleLongState2660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLongState2677 = new BitSet(new long[]{0x0000000008880000L});
    public static final BitSet FOLLOW_23_in_ruleLongState2695 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_BIN_in_ruleLongState2712 = new BitSet(new long[]{0x0000000008080000L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleLongState2740 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleLongState2752 = new BitSet(new long[]{0x0000000026000000L});
    public static final BitSet FOLLOW_ruleCommandList_in_ruleLongState2773 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_29_in_ruleLongState2787 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleLongState2799 = new BitSet(new long[]{0x0000000402000010L});
    public static final BitSet FOLLOW_ruleDotTransition_in_ruleLongState2820 = new BitSet(new long[]{0x0000000402000010L});
    public static final BitSet FOLLOW_25_in_ruleLongState2833 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleLongState2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShortState_in_entryRuleShortState2883 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShortState2893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleShortState2930 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShortState2947 = new BitSet(new long[]{0x0000000040002000L});
    public static final BitSet FOLLOW_13_in_ruleShortState2965 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_BIN_in_ruleShortState2982 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleShortState2999 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleShortState3013 = new BitSet(new long[]{0x0000000188000000L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleShortState3034 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_ruleShortCommandList_in_ruleShortState3055 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleGotoTransition_in_ruleShortState3076 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleShortCommandList_in_entryRuleShortCommandList3113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShortCommandList3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleShortCommandList3170 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleShortCommandList3191 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleShortCommandList3213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGotoTransition_in_entryRuleGotoTransition3251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGotoTransition3261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleGotoTransition3298 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGotoTransition3318 = new BitSet(new long[]{0x0000000208010000L});
    public static final BitSet FOLLOW_33_in_ruleGotoTransition3331 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_rulePredicate_in_ruleGotoTransition3352 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleGotoTransition3375 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleGotoTransition3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDotTransition_in_entryRuleDotTransition3423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDotTransition3433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDotTransition3479 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleDotTransition3492 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDotTransition3513 = new BitSet(new long[]{0x0000000208010000L});
    public static final BitSet FOLLOW_33_in_ruleDotTransition3526 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_rulePredicate_in_ruleDotTransition3547 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_ruleLayoutInfo_in_ruleDotTransition3570 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleDotTransition3582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand3618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand3673 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleCommand3685 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_ruleOr_in_ruleCommand3706 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleCommand3718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpr_in_entryRuleConcatExpr3754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcatExpr3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleConcatExpr3810 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_ruleOr_in_ruleConcatExpr3831 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_14_in_ruleConcatExpr3844 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_ruleOr_in_ruleConcatExpr3865 = new BitSet(new long[]{0x0000000002004000L});
    public static final BitSet FOLLOW_25_in_ruleConcatExpr3879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortRef_in_entryRulePortRef3915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePortRef3925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePortRef3979 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleRange_in_rulePortRef4000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstRef_in_entryRuleConstRef4037 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstRef4047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleConstRef4093 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstRef4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRange_in_entryRuleRange4149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRange4159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleRange4196 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRange4214 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleRange4231 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleRange4250 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRange4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicate_in_entryRulePredicate4303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePredicate4313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefault_in_rulePredicate4360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOr_in_rulePredicate4387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefault_in_entryRuleDefault4422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefault4432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleDefault4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOr_in_entryRuleOr4514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOr4524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAnd_in_ruleOr4571 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleOr4592 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_ruleAnd_in_ruleOr4613 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleAnd_in_entryRuleAnd4651 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAnd4661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCmp_in_ruleAnd4708 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleAnd4729 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_ruleCmp_in_ruleAnd4750 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_ruleCmp_in_entryRuleCmp4788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCmp4798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleCmp4845 = new BitSet(new long[]{0x0000018000000002L});
    public static final BitSet FOLLOW_39_in_ruleCmp4874 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_40_in_ruleCmp4903 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleCmp4940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimary_in_entryRulePrimary4978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimary4988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rulePrimary5026 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_ruleOr_in_rulePrimary5048 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_rulePrimary5059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_rulePrimary5088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNot_in_rulePrimary5115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpr_in_rulePrimary5142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePortRef_in_rulePrimary5169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstRef_in_rulePrimary5196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNot_in_entryRuleNot5231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNot5241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleNot5287 = new BitSet(new long[]{0x00000A18000800D0L});
    public static final BitSet FOLLOW_rulePrimary_in_ruleNot5308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant5344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant5354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BIN_in_ruleConstant5407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEX_in_ruleConstant5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDef_in_entryRuleConstantDef5471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDef5481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleConstantDef5518 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstantDef5535 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleConstantDef5552 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleConstantDef5573 = new BitSet(new long[]{0x0000000000000002L});

}