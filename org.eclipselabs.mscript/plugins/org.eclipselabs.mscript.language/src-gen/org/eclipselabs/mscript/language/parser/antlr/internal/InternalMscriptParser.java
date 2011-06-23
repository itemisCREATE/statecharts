package org.eclipselabs.mscript.language.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipselabs.mscript.language.services.MscriptGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMscriptParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_REAL", "RULE_INTEGER", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'enum'", "'{'", "','", "'}'", "'type'", "'='", "';'", "'record'", "':'", "'stateful'", "'func'", "'<'", "'>'", "'('", "')'", "'->'", "'static'", "'assert'", "'var'", "'fob'", "'real'", "'['", "']'", "'int'", "'complex'", "'gauss'", "'bool'", "'string'", "'let'", "'in'", "'if'", "'then'", "'else'", "'switch'", "'default'", "'case'", "'=>'", "'||'", "'&&'", "'is'", "'.'", "'|'", "'for'", "'$'", "'begin'", "'end'", "'/'", "'*'", "'^'", "'-'", "'info'", "'warning'", "'error'", "'fatal'", "'=='", "'!='", "'<='", "'>='", "'+'", "'.*'", "'./'", "'.^'", "'!'", "'\\''", "'false'", "'true'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_REAL=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int RULE_INTEGER=6;
    public static final int T__77=77;

    // delegates
    // delegators


        public InternalMscriptParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMscriptParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMscriptParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g"; }



     	private MscriptGrammarAccess grammarAccess;
     	
        public InternalMscriptParser(TokenStream input, MscriptGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Module";	
       	}
       	
       	@Override
       	protected MscriptGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModule"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:68:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:69:2: (iv_ruleModule= ruleModule EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:70:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule75);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule85); 

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
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:77:1: ruleModule returns [EObject current=null] : ( (lv_definitions_0_0= ruleDefinition ) )* ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        EObject lv_definitions_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:80:28: ( ( (lv_definitions_0_0= ruleDefinition ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:81:1: ( (lv_definitions_0_0= ruleDefinition ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:81:1: ( (lv_definitions_0_0= ruleDefinition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==16||LA1_0==19||(LA1_0>=21 && LA1_0<=22)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:82:1: (lv_definitions_0_0= ruleDefinition )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:82:1: (lv_definitions_0_0= ruleDefinition )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:83:3: lv_definitions_0_0= ruleDefinition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModuleAccess().getDefinitionsDefinitionParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDefinition_in_ruleModule130);
            	    lv_definitions_0_0=ruleDefinition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"definitions",
            	            		lv_definitions_0_0, 
            	            		"Definition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:107:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:108:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:109:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition166);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition176); 

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
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:116:1: ruleDefinition returns [EObject current=null] : (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeDefinition_0 = null;

        EObject this_FunctionDefinition_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:119:28: ( (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:120:1: (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:120:1: (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12||LA2_0==16||LA2_0==19) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=21 && LA2_0<=22)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:121:5: this_DataTypeDefinition_0= ruleDataTypeDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getDataTypeDefinitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleDataTypeDefinition_in_ruleDefinition223);
                    this_DataTypeDefinition_0=ruleDataTypeDefinition();

                    state._fsp--;

                     
                            current = this_DataTypeDefinition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:131:5: this_FunctionDefinition_1= ruleFunctionDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getFunctionDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleFunctionDefinition_in_ruleDefinition250);
                    this_FunctionDefinition_1=ruleFunctionDefinition();

                    state._fsp--;

                     
                            current = this_FunctionDefinition_1; 
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
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleDataTypeDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:147:1: entryRuleDataTypeDefinition returns [EObject current=null] : iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF ;
    public final EObject entryRuleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:148:2: (iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:149:2: iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF
            {
             newCompositeNode(grammarAccess.getDataTypeDefinitionRule()); 
            pushFollow(FOLLOW_ruleDataTypeDefinition_in_entryRuleDataTypeDefinition285);
            iv_ruleDataTypeDefinition=ruleDataTypeDefinition();

            state._fsp--;

             current =iv_ruleDataTypeDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeDefinition295); 

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
    // $ANTLR end "entryRuleDataTypeDefinition"


    // $ANTLR start "ruleDataTypeDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:156:1: ruleDataTypeDefinition returns [EObject current=null] : (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition ) ;
    public final EObject ruleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_EnumerationDefinition_0 = null;

        EObject this_RecordDefinition_1 = null;

        EObject this_TypeAliasDefinition_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:159:28: ( (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:160:1: (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:160:1: (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                alt3=2;
                }
                break;
            case 16:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:161:5: this_EnumerationDefinition_0= ruleEnumerationDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getEnumerationDefinitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEnumerationDefinition_in_ruleDataTypeDefinition342);
                    this_EnumerationDefinition_0=ruleEnumerationDefinition();

                    state._fsp--;

                     
                            current = this_EnumerationDefinition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:171:5: this_RecordDefinition_1= ruleRecordDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getRecordDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRecordDefinition_in_ruleDataTypeDefinition369);
                    this_RecordDefinition_1=ruleRecordDefinition();

                    state._fsp--;

                     
                            current = this_RecordDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:181:5: this_TypeAliasDefinition_2= ruleTypeAliasDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getTypeAliasDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTypeAliasDefinition_in_ruleDataTypeDefinition396);
                    this_TypeAliasDefinition_2=ruleTypeAliasDefinition();

                    state._fsp--;

                     
                            current = this_TypeAliasDefinition_2; 
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
    // $ANTLR end "ruleDataTypeDefinition"


    // $ANTLR start "entryRuleEnumerationDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:197:1: entryRuleEnumerationDefinition returns [EObject current=null] : iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF ;
    public final EObject entryRuleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:198:2: (iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:199:2: iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF
            {
             newCompositeNode(grammarAccess.getEnumerationDefinitionRule()); 
            pushFollow(FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition431);
            iv_ruleEnumerationDefinition=ruleEnumerationDefinition();

            state._fsp--;

             current =iv_ruleEnumerationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationDefinition441); 

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
    // $ANTLR end "entryRuleEnumerationDefinition"


    // $ANTLR start "ruleEnumerationDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:206:1: ruleEnumerationDefinition returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) (otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_literalDeclarations_3_0 = null;

        EObject lv_literalDeclarations_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:209:28: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) (otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? otherlv_6= '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:210:1: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) (otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? otherlv_6= '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:210:1: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) (otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? otherlv_6= '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:210:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) (otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleEnumerationDefinition478); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumerationDefinitionAccess().getEnumKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:214:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:215:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:215:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:216:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumerationDefinition495); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEnumerationDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumerationDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleEnumerationDefinition512); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumerationDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:236:1: ( ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) (otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:236:2: ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) ) (otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:236:2: ( (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:237:1: (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:237:1: (lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:238:3: lv_literalDeclarations_3_0= ruleEnumerationLiteralDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralDeclarationsEnumerationLiteralDeclarationParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition534);
                    lv_literalDeclarations_3_0=ruleEnumerationLiteralDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEnumerationDefinitionRule());
                    	        }
                           		add(
                           			current, 
                           			"literalDeclarations",
                            		lv_literalDeclarations_3_0, 
                            		"EnumerationLiteralDeclaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:254:2: (otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==14) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:254:4: otherlv_4= ',' ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleEnumerationDefinition547); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getEnumerationDefinitionAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:258:1: ( (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:259:1: (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:259:1: (lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:260:3: lv_literalDeclarations_5_0= ruleEnumerationLiteralDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralDeclarationsEnumerationLiteralDeclarationParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition568);
                    	    lv_literalDeclarations_5_0=ruleEnumerationLiteralDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getEnumerationDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"literalDeclarations",
                    	            		lv_literalDeclarations_5_0, 
                    	            		"EnumerationLiteralDeclaration");
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

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleEnumerationDefinition584); 

                	newLeafNode(otherlv_6, grammarAccess.getEnumerationDefinitionAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleEnumerationDefinition"


    // $ANTLR start "entryRuleEnumerationLiteralDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:288:1: entryRuleEnumerationLiteralDeclaration returns [EObject current=null] : iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF ;
    public final EObject entryRuleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteralDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:289:2: (iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:290:2: iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF
            {
             newCompositeNode(grammarAccess.getEnumerationLiteralDeclarationRule()); 
            pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration620);
            iv_ruleEnumerationLiteralDeclaration=ruleEnumerationLiteralDeclaration();

            state._fsp--;

             current =iv_ruleEnumerationLiteralDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration630); 

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
    // $ANTLR end "entryRuleEnumerationLiteralDeclaration"


    // $ANTLR start "ruleEnumerationLiteralDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:297:1: ruleEnumerationLiteralDeclaration returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:300:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:301:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:301:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:302:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:302:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:303:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEnumerationLiteralDeclaration671); 

            			newLeafNode(lv_name_0_0, grammarAccess.getEnumerationLiteralDeclarationAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumerationLiteralDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleEnumerationLiteralDeclaration"


    // $ANTLR start "entryRuleTypeAliasDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:327:1: entryRuleTypeAliasDefinition returns [EObject current=null] : iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF ;
    public final EObject entryRuleTypeAliasDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAliasDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:328:2: (iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:329:2: iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF
            {
             newCompositeNode(grammarAccess.getTypeAliasDefinitionRule()); 
            pushFollow(FOLLOW_ruleTypeAliasDefinition_in_entryRuleTypeAliasDefinition711);
            iv_ruleTypeAliasDefinition=ruleTypeAliasDefinition();

            state._fsp--;

             current =iv_ruleTypeAliasDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAliasDefinition721); 

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
    // $ANTLR end "entryRuleTypeAliasDefinition"


    // $ANTLR start "ruleTypeAliasDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:336:1: ruleTypeAliasDefinition returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) otherlv_4= ';' ) ;
    public final EObject ruleTypeAliasDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_type_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:339:28: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) otherlv_4= ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:340:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) otherlv_4= ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:340:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) otherlv_4= ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:340:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleTypeAliasDefinition758); 

                	newLeafNode(otherlv_0, grammarAccess.getTypeAliasDefinitionAccess().getTypeKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:344:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:345:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:345:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:346:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeAliasDefinition775); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTypeAliasDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeAliasDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTypeAliasDefinition792); 

                	newLeafNode(otherlv_2, grammarAccess.getTypeAliasDefinitionAccess().getEqualsSignKeyword_2());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:366:1: ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:367:1: (lv_type_3_0= rulePrimitiveTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:367:1: (lv_type_3_0= rulePrimitiveTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:368:3: lv_type_3_0= rulePrimitiveTypeSpecifier
            {
             
            	        newCompositeNode(grammarAccess.getTypeAliasDefinitionAccess().getTypePrimitiveTypeSpecifierParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleTypeAliasDefinition813);
            lv_type_3_0=rulePrimitiveTypeSpecifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTypeAliasDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_3_0, 
                    		"PrimitiveTypeSpecifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleTypeAliasDefinition825); 

                	newLeafNode(otherlv_4, grammarAccess.getTypeAliasDefinitionAccess().getSemicolonKeyword_4());
                

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
    // $ANTLR end "ruleTypeAliasDefinition"


    // $ANTLR start "entryRuleRecordDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:396:1: entryRuleRecordDefinition returns [EObject current=null] : iv_ruleRecordDefinition= ruleRecordDefinition EOF ;
    public final EObject entryRuleRecordDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:397:2: (iv_ruleRecordDefinition= ruleRecordDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:398:2: iv_ruleRecordDefinition= ruleRecordDefinition EOF
            {
             newCompositeNode(grammarAccess.getRecordDefinitionRule()); 
            pushFollow(FOLLOW_ruleRecordDefinition_in_entryRuleRecordDefinition861);
            iv_ruleRecordDefinition=ruleRecordDefinition();

            state._fsp--;

             current =iv_ruleRecordDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordDefinition871); 

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
    // $ANTLR end "entryRuleRecordDefinition"


    // $ANTLR start "ruleRecordDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:405:1: ruleRecordDefinition returns [EObject current=null] : (otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* otherlv_4= '}' ) ;
    public final EObject ruleRecordDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_fieldDeclarations_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:408:28: ( (otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* otherlv_4= '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:409:1: (otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* otherlv_4= '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:409:1: (otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* otherlv_4= '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:409:3: otherlv_0= 'record' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleRecordDefinition908); 

                	newLeafNode(otherlv_0, grammarAccess.getRecordDefinitionAccess().getRecordKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:413:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:414:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:414:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:415:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRecordDefinition925); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRecordDefinitionAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRecordDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleRecordDefinition942); 

                	newLeafNode(otherlv_2, grammarAccess.getRecordDefinitionAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:435:1: ( (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:436:1: (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:436:1: (lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:437:3: lv_fieldDeclarations_3_0= ruleRecordFieldDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordDefinitionAccess().getFieldDeclarationsRecordFieldDeclarationParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition963);
            	    lv_fieldDeclarations_3_0=ruleRecordFieldDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRecordDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fieldDeclarations",
            	            		lv_fieldDeclarations_3_0, 
            	            		"RecordFieldDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleRecordDefinition976); 

                	newLeafNode(otherlv_4, grammarAccess.getRecordDefinitionAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleRecordDefinition"


    // $ANTLR start "entryRuleRecordFieldDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:465:1: entryRuleRecordFieldDeclaration returns [EObject current=null] : iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF ;
    public final EObject entryRuleRecordFieldDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordFieldDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:466:2: (iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:467:2: iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF
            {
             newCompositeNode(grammarAccess.getRecordFieldDeclarationRule()); 
            pushFollow(FOLLOW_ruleRecordFieldDeclaration_in_entryRuleRecordFieldDeclaration1012);
            iv_ruleRecordFieldDeclaration=ruleRecordFieldDeclaration();

            state._fsp--;

             current =iv_ruleRecordFieldDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordFieldDeclaration1022); 

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
    // $ANTLR end "entryRuleRecordFieldDeclaration"


    // $ANTLR start "ruleRecordFieldDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:474:1: ruleRecordFieldDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ';' ) ;
    public final EObject ruleRecordFieldDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:477:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:478:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:478:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:478:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) otherlv_3= ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:478:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:479:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:479:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:480:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRecordFieldDeclaration1064); 

            			newLeafNode(lv_name_0_0, grammarAccess.getRecordFieldDeclarationAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRecordFieldDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleRecordFieldDeclaration1081); 

                	newLeafNode(otherlv_1, grammarAccess.getRecordFieldDeclarationAccess().getColonKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:500:1: ( (lv_type_2_0= ruleDataTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:501:1: (lv_type_2_0= ruleDataTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:501:1: (lv_type_2_0= ruleDataTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:502:3: lv_type_2_0= ruleDataTypeSpecifier
            {
             
            	        newCompositeNode(grammarAccess.getRecordFieldDeclarationAccess().getTypeDataTypeSpecifierParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRecordFieldDeclaration1102);
            lv_type_2_0=ruleDataTypeSpecifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRecordFieldDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_2_0, 
                    		"DataTypeSpecifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleRecordFieldDeclaration1114); 

                	newLeafNode(otherlv_3, grammarAccess.getRecordFieldDeclarationAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleRecordFieldDeclaration"


    // $ANTLR start "entryRuleFunctionDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:530:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:531:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:532:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
             newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1150);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;

             current =iv_ruleFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition1160); 

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
    // $ANTLR end "entryRuleFunctionDefinition"


    // $ANTLR start "ruleFunctionDefinition"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:539:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_stateful_0_0= 'stateful' ) )? otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) (otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) (otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? otherlv_12= ')' otherlv_13= '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) (otherlv_15= ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* otherlv_17= '{' ( ( (lv_assertions_18_0= ruleAssertion ) ) | ( (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquation ) ) )* otherlv_22= '}' ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_stateful_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_22=null;
        EObject lv_templateParameterDeclarations_4_0 = null;

        EObject lv_templateParameterDeclarations_6_0 = null;

        EObject lv_inputParameterDeclarations_9_0 = null;

        EObject lv_inputParameterDeclarations_11_0 = null;

        EObject lv_outputParameterDeclarations_14_0 = null;

        EObject lv_outputParameterDeclarations_16_0 = null;

        EObject lv_assertions_18_0 = null;

        EObject lv_functionObjectDeclarations_19_0 = null;

        EObject lv_stateVariableDeclarations_20_0 = null;

        EObject lv_equations_21_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:542:28: ( ( ( (lv_stateful_0_0= 'stateful' ) )? otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) (otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) (otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? otherlv_12= ')' otherlv_13= '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) (otherlv_15= ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* otherlv_17= '{' ( ( (lv_assertions_18_0= ruleAssertion ) ) | ( (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquation ) ) )* otherlv_22= '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:543:1: ( ( (lv_stateful_0_0= 'stateful' ) )? otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) (otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) (otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? otherlv_12= ')' otherlv_13= '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) (otherlv_15= ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* otherlv_17= '{' ( ( (lv_assertions_18_0= ruleAssertion ) ) | ( (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquation ) ) )* otherlv_22= '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:543:1: ( ( (lv_stateful_0_0= 'stateful' ) )? otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) (otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) (otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? otherlv_12= ')' otherlv_13= '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) (otherlv_15= ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* otherlv_17= '{' ( ( (lv_assertions_18_0= ruleAssertion ) ) | ( (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquation ) ) )* otherlv_22= '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:543:2: ( (lv_stateful_0_0= 'stateful' ) )? otherlv_1= 'func' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) (otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* otherlv_7= '>' )? otherlv_8= '(' ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) (otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )? otherlv_12= ')' otherlv_13= '->' ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) ) (otherlv_15= ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )* otherlv_17= '{' ( ( (lv_assertions_18_0= ruleAssertion ) ) | ( (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquation ) ) )* otherlv_22= '}'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:543:2: ( (lv_stateful_0_0= 'stateful' ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:544:1: (lv_stateful_0_0= 'stateful' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:544:1: (lv_stateful_0_0= 'stateful' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:545:3: lv_stateful_0_0= 'stateful'
                    {
                    lv_stateful_0_0=(Token)match(input,21,FOLLOW_21_in_ruleFunctionDefinition1203); 

                            newLeafNode(lv_stateful_0_0, grammarAccess.getFunctionDefinitionAccess().getStatefulStatefulKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "stateful", true, "stateful");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleFunctionDefinition1229); 

                	newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getFuncKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:562:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:563:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:563:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:564:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionDefinition1246); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionDefinitionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:580:2: (otherlv_3= '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) (otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* otherlv_7= '>' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:580:4: otherlv_3= '<' ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) ) (otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )* otherlv_7= '>'
                    {
                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleFunctionDefinition1264); 

                        	newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getLessThanSignKeyword_3_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:584:1: ( (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:585:1: (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:585:1: (lv_templateParameterDeclarations_4_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:586:3: lv_templateParameterDeclarations_4_0= ruleParameterDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTemplateParameterDeclarationsParameterDeclarationParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1285);
                    lv_templateParameterDeclarations_4_0=ruleParameterDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                    	        }
                           		add(
                           			current, 
                           			"templateParameterDeclarations",
                            		lv_templateParameterDeclarations_4_0, 
                            		"ParameterDeclaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:602:2: (otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==14) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:602:4: otherlv_5= ',' ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) )
                    	    {
                    	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleFunctionDefinition1298); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:606:1: ( (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:607:1: (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:607:1: (lv_templateParameterDeclarations_6_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:608:3: lv_templateParameterDeclarations_6_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTemplateParameterDeclarationsParameterDeclarationParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1319);
                    	    lv_templateParameterDeclarations_6_0=ruleParameterDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"templateParameterDeclarations",
                    	            		lv_templateParameterDeclarations_6_0, 
                    	            		"ParameterDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleFunctionDefinition1333); 

                        	newLeafNode(otherlv_7, grammarAccess.getFunctionDefinitionAccess().getGreaterThanSignKeyword_3_3());
                        

                    }
                    break;

            }

            otherlv_8=(Token)match(input,25,FOLLOW_25_in_ruleFunctionDefinition1347); 

                	newLeafNode(otherlv_8, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_4());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:632:1: ( ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) (otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:632:2: ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) ) (otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:632:2: ( (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:633:1: (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:633:1: (lv_inputParameterDeclarations_9_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:634:3: lv_inputParameterDeclarations_9_0= ruleParameterDeclaration
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getInputParameterDeclarationsParameterDeclarationParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1369);
                    lv_inputParameterDeclarations_9_0=ruleParameterDeclaration();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                    	        }
                           		add(
                           			current, 
                           			"inputParameterDeclarations",
                            		lv_inputParameterDeclarations_9_0, 
                            		"ParameterDeclaration");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:650:2: (otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==14) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:650:4: otherlv_10= ',' ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) )
                    	    {
                    	    otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleFunctionDefinition1382); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:654:1: ( (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:655:1: (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:655:1: (lv_inputParameterDeclarations_11_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:656:3: lv_inputParameterDeclarations_11_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getInputParameterDeclarationsParameterDeclarationParserRuleCall_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1403);
                    	    lv_inputParameterDeclarations_11_0=ruleParameterDeclaration();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"inputParameterDeclarations",
                    	            		lv_inputParameterDeclarations_11_0, 
                    	            		"ParameterDeclaration");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,26,FOLLOW_26_in_ruleFunctionDefinition1419); 

                	newLeafNode(otherlv_12, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_6());
                
            otherlv_13=(Token)match(input,27,FOLLOW_27_in_ruleFunctionDefinition1431); 

                	newLeafNode(otherlv_13, grammarAccess.getFunctionDefinitionAccess().getHyphenMinusGreaterThanSignKeyword_7());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:680:1: ( (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:681:1: (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:681:1: (lv_outputParameterDeclarations_14_0= ruleParameterDeclaration )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:682:3: lv_outputParameterDeclarations_14_0= ruleParameterDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getOutputParameterDeclarationsParameterDeclarationParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1452);
            lv_outputParameterDeclarations_14_0=ruleParameterDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
            	        }
                   		add(
                   			current, 
                   			"outputParameterDeclarations",
                    		lv_outputParameterDeclarations_14_0, 
                    		"ParameterDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:698:2: (otherlv_15= ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:698:4: otherlv_15= ',' ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) )
            	    {
            	    otherlv_15=(Token)match(input,14,FOLLOW_14_in_ruleFunctionDefinition1465); 

            	        	newLeafNode(otherlv_15, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_9_0());
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:702:1: ( (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:703:1: (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:703:1: (lv_outputParameterDeclarations_16_0= ruleParameterDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:704:3: lv_outputParameterDeclarations_16_0= ruleParameterDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getOutputParameterDeclarationsParameterDeclarationParserRuleCall_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1486);
            	    lv_outputParameterDeclarations_16_0=ruleParameterDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"outputParameterDeclarations",
            	            		lv_outputParameterDeclarations_16_0, 
            	            		"ParameterDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_17=(Token)match(input,13,FOLLOW_13_in_ruleFunctionDefinition1500); 

                	newLeafNode(otherlv_17, grammarAccess.getFunctionDefinitionAccess().getLeftCurlyBracketKeyword_10());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:724:1: ( ( (lv_assertions_18_0= ruleAssertion ) ) | ( (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration ) ) | ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquation ) ) )*
            loop13:
            do {
                int alt13=5;
                switch ( input.LA(1) ) {
                case 28:
                    {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2==42||LA13_2==45) ) {
                        alt13=4;
                    }
                    else if ( (LA13_2==29) ) {
                        alt13=1;
                    }


                    }
                    break;
                case 29:
                    {
                    alt13=1;
                    }
                    break;
                case 31:
                    {
                    alt13=2;
                    }
                    break;
                case 30:
                    {
                    alt13=3;
                    }
                    break;
                case RULE_ID:
                case RULE_REAL:
                case RULE_INTEGER:
                case RULE_STRING:
                case 13:
                case 25:
                case 33:
                case 40:
                case 42:
                case 45:
                case 55:
                case 56:
                case 57:
                case 61:
                case 74:
                case 76:
                case 77:
                    {
                    alt13=4;
                    }
                    break;

                }

                switch (alt13) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:724:2: ( (lv_assertions_18_0= ruleAssertion ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:724:2: ( (lv_assertions_18_0= ruleAssertion ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:725:1: (lv_assertions_18_0= ruleAssertion )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:725:1: (lv_assertions_18_0= ruleAssertion )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:726:3: lv_assertions_18_0= ruleAssertion
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getAssertionsAssertionParserRuleCall_11_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssertion_in_ruleFunctionDefinition1522);
            	    lv_assertions_18_0=ruleAssertion();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"assertions",
            	            		lv_assertions_18_0, 
            	            		"Assertion");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:743:6: ( (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:743:6: ( (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:744:1: (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:744:1: (lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:745:3: lv_functionObjectDeclarations_19_0= ruleFunctionObjectDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctionObjectDeclarationsFunctionObjectDeclarationParserRuleCall_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFunctionObjectDeclaration_in_ruleFunctionDefinition1549);
            	    lv_functionObjectDeclarations_19_0=ruleFunctionObjectDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"functionObjectDeclarations",
            	            		lv_functionObjectDeclarations_19_0, 
            	            		"FunctionObjectDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:762:6: ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:762:6: ( (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:763:1: (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:763:1: (lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:764:3: lv_stateVariableDeclarations_20_0= ruleStateVariableDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getStateVariableDeclarationsStateVariableDeclarationParserRuleCall_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStateVariableDeclaration_in_ruleFunctionDefinition1576);
            	    lv_stateVariableDeclarations_20_0=ruleStateVariableDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"stateVariableDeclarations",
            	            		lv_stateVariableDeclarations_20_0, 
            	            		"StateVariableDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:781:6: ( (lv_equations_21_0= ruleEquation ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:781:6: ( (lv_equations_21_0= ruleEquation ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:782:1: (lv_equations_21_0= ruleEquation )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:782:1: (lv_equations_21_0= ruleEquation )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:783:3: lv_equations_21_0= ruleEquation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getEquationsEquationParserRuleCall_11_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEquation_in_ruleFunctionDefinition1603);
            	    lv_equations_21_0=ruleEquation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"equations",
            	            		lv_equations_21_0, 
            	            		"Equation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_22=(Token)match(input,15,FOLLOW_15_in_ruleFunctionDefinition1617); 

                	newLeafNode(otherlv_22, grammarAccess.getFunctionDefinitionAccess().getRightCurlyBracketKeyword_12());
                

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
    // $ANTLR end "ruleFunctionDefinition"


    // $ANTLR start "entryRuleParameterDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:811:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:812:2: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:813:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
             newCompositeNode(grammarAccess.getParameterDeclarationRule()); 
            pushFollow(FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1653);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();

            state._fsp--;

             current =iv_ruleParameterDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterDeclaration1663); 

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
    // $ANTLR end "entryRuleParameterDeclaration"


    // $ANTLR start "ruleParameterDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:820:1: ruleParameterDeclaration returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:823:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:824:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:824:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:825:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:825:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:826:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParameterDeclaration1704); 

            			newLeafNode(lv_name_0_0, grammarAccess.getParameterDeclarationAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleParameterDeclaration"


    // $ANTLR start "entryRuleAssertion"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:850:1: entryRuleAssertion returns [EObject current=null] : iv_ruleAssertion= ruleAssertion EOF ;
    public final EObject entryRuleAssertion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertion = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:851:2: (iv_ruleAssertion= ruleAssertion EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:852:2: iv_ruleAssertion= ruleAssertion EOF
            {
             newCompositeNode(grammarAccess.getAssertionRule()); 
            pushFollow(FOLLOW_ruleAssertion_in_entryRuleAssertion1744);
            iv_ruleAssertion=ruleAssertion();

            state._fsp--;

             current =iv_ruleAssertion; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssertion1754); 

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
    // $ANTLR end "entryRuleAssertion"


    // $ANTLR start "ruleAssertion"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:859:1: ruleAssertion returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'assert' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) otherlv_6= ';' ) ;
    public final EObject ruleAssertion() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_condition_2_0 = null;

        Enumerator lv_statusKind_4_0 = null;

        EObject lv_message_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:862:28: ( ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'assert' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) otherlv_6= ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:863:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'assert' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) otherlv_6= ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:863:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'assert' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) otherlv_6= ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:863:2: ( (lv_static_0_0= 'static' ) )? otherlv_1= 'assert' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ':' ( (lv_statusKind_4_0= ruleAssertionStatusKind ) ) ( (lv_message_5_0= ruleExpression ) ) otherlv_6= ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:863:2: ( (lv_static_0_0= 'static' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:864:1: (lv_static_0_0= 'static' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:864:1: (lv_static_0_0= 'static' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:865:3: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)match(input,28,FOLLOW_28_in_ruleAssertion1797); 

                            newLeafNode(lv_static_0_0, grammarAccess.getAssertionAccess().getStaticStaticKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssertionRule());
                    	        }
                           		setWithLastConsumed(current, "static", true, "static");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleAssertion1823); 

                	newLeafNode(otherlv_1, grammarAccess.getAssertionAccess().getAssertKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:882:1: ( (lv_condition_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:883:1: (lv_condition_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:883:1: (lv_condition_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:884:3: lv_condition_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAssertionAccess().getConditionExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssertion1844);
            lv_condition_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssertionRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleAssertion1856); 

                	newLeafNode(otherlv_3, grammarAccess.getAssertionAccess().getColonKeyword_3());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:904:1: ( (lv_statusKind_4_0= ruleAssertionStatusKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:905:1: (lv_statusKind_4_0= ruleAssertionStatusKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:905:1: (lv_statusKind_4_0= ruleAssertionStatusKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:906:3: lv_statusKind_4_0= ruleAssertionStatusKind
            {
             
            	        newCompositeNode(grammarAccess.getAssertionAccess().getStatusKindAssertionStatusKindEnumRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleAssertionStatusKind_in_ruleAssertion1877);
            lv_statusKind_4_0=ruleAssertionStatusKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssertionRule());
            	        }
                   		set(
                   			current, 
                   			"statusKind",
                    		lv_statusKind_4_0, 
                    		"AssertionStatusKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:922:2: ( (lv_message_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:923:1: (lv_message_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:923:1: (lv_message_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:924:3: lv_message_5_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAssertionAccess().getMessageExpressionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssertion1898);
            lv_message_5_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAssertionRule());
            	        }
                   		set(
                   			current, 
                   			"message",
                    		lv_message_5_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleAssertion1910); 

                	newLeafNode(otherlv_6, grammarAccess.getAssertionAccess().getSemicolonKeyword_6());
                

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
    // $ANTLR end "ruleAssertion"


    // $ANTLR start "entryRuleStateVariableDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:952:1: entryRuleStateVariableDeclaration returns [EObject current=null] : iv_ruleStateVariableDeclaration= ruleStateVariableDeclaration EOF ;
    public final EObject entryRuleStateVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateVariableDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:953:2: (iv_ruleStateVariableDeclaration= ruleStateVariableDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:954:2: iv_ruleStateVariableDeclaration= ruleStateVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getStateVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleStateVariableDeclaration_in_entryRuleStateVariableDeclaration1946);
            iv_ruleStateVariableDeclaration=ruleStateVariableDeclaration();

            state._fsp--;

             current =iv_ruleStateVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStateVariableDeclaration1956); 

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
    // $ANTLR end "entryRuleStateVariableDeclaration"


    // $ANTLR start "ruleStateVariableDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:961:1: ruleStateVariableDeclaration returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleStateVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:964:28: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:965:1: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:965:1: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:965:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleStateVariableDeclaration1993); 

                	newLeafNode(otherlv_0, grammarAccess.getStateVariableDeclarationAccess().getVarKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:969:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:970:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:970:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:971:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStateVariableDeclaration2010); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStateVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStateVariableDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleStateVariableDeclaration2027); 

                	newLeafNode(otherlv_2, grammarAccess.getStateVariableDeclarationAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleStateVariableDeclaration"


    // $ANTLR start "entryRuleFunctionObjectDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:999:1: entryRuleFunctionObjectDeclaration returns [EObject current=null] : iv_ruleFunctionObjectDeclaration= ruleFunctionObjectDeclaration EOF ;
    public final EObject entryRuleFunctionObjectDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionObjectDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1000:2: (iv_ruleFunctionObjectDeclaration= ruleFunctionObjectDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1001:2: iv_ruleFunctionObjectDeclaration= ruleFunctionObjectDeclaration EOF
            {
             newCompositeNode(grammarAccess.getFunctionObjectDeclarationRule()); 
            pushFollow(FOLLOW_ruleFunctionObjectDeclaration_in_entryRuleFunctionObjectDeclaration2063);
            iv_ruleFunctionObjectDeclaration=ruleFunctionObjectDeclaration();

            state._fsp--;

             current =iv_ruleFunctionObjectDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionObjectDeclaration2073); 

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
    // $ANTLR end "entryRuleFunctionObjectDeclaration"


    // $ANTLR start "ruleFunctionObjectDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1008:1: ruleFunctionObjectDeclaration returns [EObject current=null] : (otherlv_0= 'fob' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) (otherlv_4= '<' ( (lv_templateArguments_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) ;
    public final EObject ruleFunctionObjectDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_functionName_3_0 = null;

        EObject lv_templateArguments_5_0 = null;

        EObject lv_templateArguments_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1011:28: ( (otherlv_0= 'fob' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) (otherlv_4= '<' ( (lv_templateArguments_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) ) )* otherlv_8= '>' )? otherlv_9= ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1012:1: (otherlv_0= 'fob' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) (otherlv_4= '<' ( (lv_templateArguments_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1012:1: (otherlv_0= 'fob' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) (otherlv_4= '<' ( (lv_templateArguments_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) ) )* otherlv_8= '>' )? otherlv_9= ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1012:3: otherlv_0= 'fob' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_functionName_3_0= ruleQualifiedName ) ) (otherlv_4= '<' ( (lv_templateArguments_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) ) )* otherlv_8= '>' )? otherlv_9= ';'
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleFunctionObjectDeclaration2110); 

                	newLeafNode(otherlv_0, grammarAccess.getFunctionObjectDeclarationAccess().getFobKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1016:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1017:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1017:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1018:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFunctionObjectDeclaration2127); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFunctionObjectDeclarationAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFunctionObjectDeclarationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleFunctionObjectDeclaration2144); 

                	newLeafNode(otherlv_2, grammarAccess.getFunctionObjectDeclarationAccess().getColonKeyword_2());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1038:1: ( (lv_functionName_3_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1039:1: (lv_functionName_3_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1039:1: (lv_functionName_3_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1040:3: lv_functionName_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getFunctionObjectDeclarationAccess().getFunctionNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleFunctionObjectDeclaration2165);
            lv_functionName_3_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFunctionObjectDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"functionName",
                    		lv_functionName_3_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1056:2: (otherlv_4= '<' ( (lv_templateArguments_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) ) )* otherlv_8= '>' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==23) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1056:4: otherlv_4= '<' ( (lv_templateArguments_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleFunctionObjectDeclaration2178); 

                        	newLeafNode(otherlv_4, grammarAccess.getFunctionObjectDeclarationAccess().getLessThanSignKeyword_4_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1060:1: ( (lv_templateArguments_5_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1061:1: (lv_templateArguments_5_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1061:1: (lv_templateArguments_5_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1062:3: lv_templateArguments_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getFunctionObjectDeclarationAccess().getTemplateArgumentsExpressionParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionObjectDeclaration2199);
                    lv_templateArguments_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFunctionObjectDeclarationRule());
                    	        }
                           		add(
                           			current, 
                           			"templateArguments",
                            		lv_templateArguments_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1078:2: (otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==14) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1078:4: otherlv_6= ',' ( (lv_templateArguments_7_0= ruleExpression ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleFunctionObjectDeclaration2212); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getFunctionObjectDeclarationAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1082:1: ( (lv_templateArguments_7_0= ruleExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1083:1: (lv_templateArguments_7_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1083:1: (lv_templateArguments_7_0= ruleExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1084:3: lv_templateArguments_7_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFunctionObjectDeclarationAccess().getTemplateArgumentsExpressionParserRuleCall_4_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleFunctionObjectDeclaration2233);
                    	    lv_templateArguments_7_0=ruleExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFunctionObjectDeclarationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"templateArguments",
                    	            		lv_templateArguments_7_0, 
                    	            		"Expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleFunctionObjectDeclaration2247); 

                        	newLeafNode(otherlv_8, grammarAccess.getFunctionObjectDeclarationAccess().getGreaterThanSignKeyword_4_3());
                        

                    }
                    break;

            }

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_ruleFunctionObjectDeclaration2261); 

                	newLeafNode(otherlv_9, grammarAccess.getFunctionObjectDeclarationAccess().getSemicolonKeyword_5());
                

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
    // $ANTLR end "ruleFunctionObjectDeclaration"


    // $ANTLR start "entryRuleEquation"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1116:1: entryRuleEquation returns [EObject current=null] : iv_ruleEquation= ruleEquation EOF ;
    public final EObject entryRuleEquation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquation = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1117:2: (iv_ruleEquation= ruleEquation EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1118:2: iv_ruleEquation= ruleEquation EOF
            {
             newCompositeNode(grammarAccess.getEquationRule()); 
            pushFollow(FOLLOW_ruleEquation_in_entryRuleEquation2297);
            iv_ruleEquation=ruleEquation();

            state._fsp--;

             current =iv_ruleEquation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquation2307); 

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
    // $ANTLR end "entryRuleEquation"


    // $ANTLR start "ruleEquation"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1125:1: ruleEquation returns [EObject current=null] : ( ( (lv_leftHandSide_0_0= ruleExpression ) ) otherlv_1= '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleEquation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_leftHandSide_0_0 = null;

        EObject lv_rightHandSide_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1128:28: ( ( ( (lv_leftHandSide_0_0= ruleExpression ) ) otherlv_1= '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1129:1: ( ( (lv_leftHandSide_0_0= ruleExpression ) ) otherlv_1= '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1129:1: ( ( (lv_leftHandSide_0_0= ruleExpression ) ) otherlv_1= '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) otherlv_3= ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1129:2: ( (lv_leftHandSide_0_0= ruleExpression ) ) otherlv_1= '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1129:2: ( (lv_leftHandSide_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1130:1: (lv_leftHandSide_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1130:1: (lv_leftHandSide_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1131:3: lv_leftHandSide_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getEquationAccess().getLeftHandSideExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleEquation2353);
            lv_leftHandSide_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEquationRule());
            	        }
                   		set(
                   			current, 
                   			"leftHandSide",
                    		lv_leftHandSide_0_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleEquation2365); 

                	newLeafNode(otherlv_1, grammarAccess.getEquationAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1151:1: ( (lv_rightHandSide_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1152:1: (lv_rightHandSide_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1152:1: (lv_rightHandSide_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1153:3: lv_rightHandSide_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getEquationAccess().getRightHandSideExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleEquation2386);
            lv_rightHandSide_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEquationRule());
            	        }
                   		set(
                   			current, 
                   			"rightHandSide",
                    		lv_rightHandSide_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleEquation2398); 

                	newLeafNode(otherlv_3, grammarAccess.getEquationAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleEquation"


    // $ANTLR start "entryRuleDataTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1181:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1182:2: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1183:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getDataTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier2434);
            iv_ruleDataTypeSpecifier=ruleDataTypeSpecifier();

            state._fsp--;

             current =iv_ruleDataTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeSpecifier2444); 

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
    // $ANTLR end "entryRuleDataTypeSpecifier"


    // $ANTLR start "ruleDataTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1190:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeSpecifier_0 = null;

        EObject this_NamedTypeSpecifier_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1193:28: ( (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1194:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1194:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==32||(LA17_0>=35 && LA17_0<=39)) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1195:5: this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getPrimitiveTypeSpecifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier2491);
                    this_PrimitiveTypeSpecifier_0=rulePrimitiveTypeSpecifier();

                    state._fsp--;

                     
                            current = this_PrimitiveTypeSpecifier_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1205:5: this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getNamedTypeSpecifierParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier2518);
                    this_NamedTypeSpecifier_1=ruleNamedTypeSpecifier();

                    state._fsp--;

                     
                            current = this_NamedTypeSpecifier_1; 
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
    // $ANTLR end "ruleDataTypeSpecifier"


    // $ANTLR start "entryRulePrimitiveTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1221:1: entryRulePrimitiveTypeSpecifier returns [EObject current=null] : iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF ;
    public final EObject entryRulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1222:2: (iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1223:2: iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeSpecifierRule()); 
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier2553);
            iv_rulePrimitiveTypeSpecifier=rulePrimitiveTypeSpecifier();

            state._fsp--;

             current =iv_rulePrimitiveTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier2563); 

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
    // $ANTLR end "entryRulePrimitiveTypeSpecifier"


    // $ANTLR start "rulePrimitiveTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1230:1: rulePrimitiveTypeSpecifier returns [EObject current=null] : (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) ;
    public final EObject rulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_NumericTypeSpecifier_0 = null;

        EObject this_BooleanTypeSpecifier_1 = null;

        EObject this_StringTypeSpecifier_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1233:28: ( (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1234:1: (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1234:1: (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 32:
            case 35:
            case 36:
            case 37:
                {
                alt18=1;
                }
                break;
            case 38:
                {
                alt18=2;
                }
                break;
            case 39:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1235:5: this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getNumericTypeSpecifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNumericTypeSpecifier_in_rulePrimitiveTypeSpecifier2610);
                    this_NumericTypeSpecifier_0=ruleNumericTypeSpecifier();

                    state._fsp--;

                     
                            current = this_NumericTypeSpecifier_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1245:5: this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getBooleanTypeSpecifierParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier2637);
                    this_BooleanTypeSpecifier_1=ruleBooleanTypeSpecifier();

                    state._fsp--;

                     
                            current = this_BooleanTypeSpecifier_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1255:5: this_StringTypeSpecifier_2= ruleStringTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getStringTypeSpecifierParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier2664);
                    this_StringTypeSpecifier_2=ruleStringTypeSpecifier();

                    state._fsp--;

                     
                            current = this_StringTypeSpecifier_2; 
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
    // $ANTLR end "rulePrimitiveTypeSpecifier"


    // $ANTLR start "entryRuleNumericTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1271:1: entryRuleNumericTypeSpecifier returns [EObject current=null] : iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF ;
    public final EObject entryRuleNumericTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1272:2: (iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1273:2: iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getNumericTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleNumericTypeSpecifier_in_entryRuleNumericTypeSpecifier2699);
            iv_ruleNumericTypeSpecifier=ruleNumericTypeSpecifier();

            state._fsp--;

             current =iv_ruleNumericTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericTypeSpecifier2709); 

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
    // $ANTLR end "entryRuleNumericTypeSpecifier"


    // $ANTLR start "ruleNumericTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1280:1: ruleNumericTypeSpecifier returns [EObject current=null] : (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) ;
    public final EObject ruleNumericTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_RealTypeSpecifier_0 = null;

        EObject this_IntegerTypeSpecifier_1 = null;

        EObject this_ComplexTypeSpecifier_2 = null;

        EObject this_GaussianTypeSpecifier_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1283:28: ( (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1284:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1284:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt19=1;
                }
                break;
            case 35:
                {
                alt19=2;
                }
                break;
            case 36:
                {
                alt19=3;
                }
                break;
            case 37:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1285:5: this_RealTypeSpecifier_0= ruleRealTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getRealTypeSpecifierParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRealTypeSpecifier_in_ruleNumericTypeSpecifier2756);
                    this_RealTypeSpecifier_0=ruleRealTypeSpecifier();

                    state._fsp--;

                     
                            current = this_RealTypeSpecifier_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1295:5: this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getIntegerTypeSpecifierParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericTypeSpecifier2783);
                    this_IntegerTypeSpecifier_1=ruleIntegerTypeSpecifier();

                    state._fsp--;

                     
                            current = this_IntegerTypeSpecifier_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1305:5: this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getComplexTypeSpecifierParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericTypeSpecifier2810);
                    this_ComplexTypeSpecifier_2=ruleComplexTypeSpecifier();

                    state._fsp--;

                     
                            current = this_ComplexTypeSpecifier_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1315:5: this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier
                    {
                     
                            newCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getGaussianTypeSpecifierParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericTypeSpecifier2837);
                    this_GaussianTypeSpecifier_3=ruleGaussianTypeSpecifier();

                    state._fsp--;

                     
                            current = this_GaussianTypeSpecifier_3; 
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
    // $ANTLR end "ruleNumericTypeSpecifier"


    // $ANTLR start "entryRuleRealTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1331:1: entryRuleRealTypeSpecifier returns [EObject current=null] : iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF ;
    public final EObject entryRuleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1332:2: (iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1333:2: iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getRealTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier2872);
            iv_ruleRealTypeSpecifier=ruleRealTypeSpecifier();

            state._fsp--;

             current =iv_ruleRealTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTypeSpecifier2882); 

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
    // $ANTLR end "entryRuleRealTypeSpecifier"


    // $ANTLR start "ruleRealTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1340:1: ruleRealTypeSpecifier returns [EObject current=null] : ( () otherlv_1= 'real' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? ) ;
    public final EObject ruleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1343:28: ( ( () otherlv_1= 'real' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1344:1: ( () otherlv_1= 'real' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1344:1: ( () otherlv_1= 'real' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1344:2: () otherlv_1= 'real' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1344:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1345:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRealTypeSpecifierAccess().getRealTypeSpecifierAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleRealTypeSpecifier2928); 

                	newLeafNode(otherlv_1, grammarAccess.getRealTypeSpecifierAccess().getRealKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1354:1: (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==25) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1354:3: otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleRealTypeSpecifier2941); 

                        	newLeafNode(otherlv_2, grammarAccess.getRealTypeSpecifierAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1358:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1359:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1359:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1360:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier2962);
                    lv_unit_3_0=ruleUnitExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRealTypeSpecifierRule());
                    	        }
                           		set(
                           			current, 
                           			"unit",
                            		lv_unit_3_0, 
                            		"UnitExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleRealTypeSpecifier2974); 

                        	newLeafNode(otherlv_4, grammarAccess.getRealTypeSpecifierAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1380:3: (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==33) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1380:5: otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleRealTypeSpecifier2989); 

                        	newLeafNode(otherlv_5, grammarAccess.getRealTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1384:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1385:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1385:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1386:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3010);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRealTypeSpecifierRule());
                    	        }
                           		add(
                           			current, 
                           			"dimensions",
                            		lv_dimensions_6_0, 
                            		"ArrayDimensionSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1402:2: (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==14) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1402:4: otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleRealTypeSpecifier3023); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getRealTypeSpecifierAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1406:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1407:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1407:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1408:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3044);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRealTypeSpecifierRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dimensions",
                    	            		lv_dimensions_8_0, 
                    	            		"ArrayDimensionSpecification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,34,FOLLOW_34_in_ruleRealTypeSpecifier3058); 

                        	newLeafNode(otherlv_9, grammarAccess.getRealTypeSpecifierAccess().getRightSquareBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleRealTypeSpecifier"


    // $ANTLR start "entryRuleIntegerTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1436:1: entryRuleIntegerTypeSpecifier returns [EObject current=null] : iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF ;
    public final EObject entryRuleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1437:2: (iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1438:2: iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier3096);
            iv_ruleIntegerTypeSpecifier=ruleIntegerTypeSpecifier();

            state._fsp--;

             current =iv_ruleIntegerTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier3106); 

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
    // $ANTLR end "entryRuleIntegerTypeSpecifier"


    // $ANTLR start "ruleIntegerTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1445:1: ruleIntegerTypeSpecifier returns [EObject current=null] : ( () otherlv_1= 'int' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? ) ;
    public final EObject ruleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1448:28: ( ( () otherlv_1= 'int' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1449:1: ( () otherlv_1= 'int' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1449:1: ( () otherlv_1= 'int' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1449:2: () otherlv_1= 'int' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1449:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1450:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getIntegerTypeSpecifierAccess().getIntegerTypeSpecifierAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleIntegerTypeSpecifier3152); 

                	newLeafNode(otherlv_1, grammarAccess.getIntegerTypeSpecifierAccess().getIntKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1459:1: (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==25) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1459:3: otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleIntegerTypeSpecifier3165); 

                        	newLeafNode(otherlv_2, grammarAccess.getIntegerTypeSpecifierAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1463:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1464:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1464:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1465:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier3186);
                    lv_unit_3_0=ruleUnitExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIntegerTypeSpecifierRule());
                    	        }
                           		set(
                           			current, 
                           			"unit",
                            		lv_unit_3_0, 
                            		"UnitExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleIntegerTypeSpecifier3198); 

                        	newLeafNode(otherlv_4, grammarAccess.getIntegerTypeSpecifierAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1485:3: (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==33) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1485:5: otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleIntegerTypeSpecifier3213); 

                        	newLeafNode(otherlv_5, grammarAccess.getIntegerTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1489:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1490:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1490:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1491:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3234);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIntegerTypeSpecifierRule());
                    	        }
                           		add(
                           			current, 
                           			"dimensions",
                            		lv_dimensions_6_0, 
                            		"ArrayDimensionSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1507:2: (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==14) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1507:4: otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleIntegerTypeSpecifier3247); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getIntegerTypeSpecifierAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1511:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1512:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1512:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1513:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3268);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getIntegerTypeSpecifierRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dimensions",
                    	            		lv_dimensions_8_0, 
                    	            		"ArrayDimensionSpecification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,34,FOLLOW_34_in_ruleIntegerTypeSpecifier3282); 

                        	newLeafNode(otherlv_9, grammarAccess.getIntegerTypeSpecifierAccess().getRightSquareBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleIntegerTypeSpecifier"


    // $ANTLR start "entryRuleComplexTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1541:1: entryRuleComplexTypeSpecifier returns [EObject current=null] : iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF ;
    public final EObject entryRuleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1542:2: (iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1543:2: iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getComplexTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier3320);
            iv_ruleComplexTypeSpecifier=ruleComplexTypeSpecifier();

            state._fsp--;

             current =iv_ruleComplexTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexTypeSpecifier3330); 

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
    // $ANTLR end "entryRuleComplexTypeSpecifier"


    // $ANTLR start "ruleComplexTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1550:1: ruleComplexTypeSpecifier returns [EObject current=null] : ( () otherlv_1= 'complex' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? ) ;
    public final EObject ruleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1553:28: ( ( () otherlv_1= 'complex' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1554:1: ( () otherlv_1= 'complex' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1554:1: ( () otherlv_1= 'complex' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1554:2: () otherlv_1= 'complex' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1554:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1555:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getComplexTypeSpecifierAccess().getComplexTypeSpecifierAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleComplexTypeSpecifier3376); 

                	newLeafNode(otherlv_1, grammarAccess.getComplexTypeSpecifierAccess().getComplexKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1564:1: (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1564:3: otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleComplexTypeSpecifier3389); 

                        	newLeafNode(otherlv_2, grammarAccess.getComplexTypeSpecifierAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1568:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1569:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1569:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1570:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier3410);
                    lv_unit_3_0=ruleUnitExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getComplexTypeSpecifierRule());
                    	        }
                           		set(
                           			current, 
                           			"unit",
                            		lv_unit_3_0, 
                            		"UnitExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleComplexTypeSpecifier3422); 

                        	newLeafNode(otherlv_4, grammarAccess.getComplexTypeSpecifierAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1590:3: (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==33) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1590:5: otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleComplexTypeSpecifier3437); 

                        	newLeafNode(otherlv_5, grammarAccess.getComplexTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1594:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1595:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1595:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1596:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3458);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getComplexTypeSpecifierRule());
                    	        }
                           		add(
                           			current, 
                           			"dimensions",
                            		lv_dimensions_6_0, 
                            		"ArrayDimensionSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1612:2: (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==14) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1612:4: otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleComplexTypeSpecifier3471); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getComplexTypeSpecifierAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1616:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1617:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1617:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1618:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3492);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComplexTypeSpecifierRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dimensions",
                    	            		lv_dimensions_8_0, 
                    	            		"ArrayDimensionSpecification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,34,FOLLOW_34_in_ruleComplexTypeSpecifier3506); 

                        	newLeafNode(otherlv_9, grammarAccess.getComplexTypeSpecifierAccess().getRightSquareBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleComplexTypeSpecifier"


    // $ANTLR start "entryRuleGaussianTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1646:1: entryRuleGaussianTypeSpecifier returns [EObject current=null] : iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF ;
    public final EObject entryRuleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGaussianTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1647:2: (iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1648:2: iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getGaussianTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier3544);
            iv_ruleGaussianTypeSpecifier=ruleGaussianTypeSpecifier();

            state._fsp--;

             current =iv_ruleGaussianTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier3554); 

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
    // $ANTLR end "entryRuleGaussianTypeSpecifier"


    // $ANTLR start "ruleGaussianTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1655:1: ruleGaussianTypeSpecifier returns [EObject current=null] : ( () otherlv_1= 'gauss' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? ) ;
    public final EObject ruleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1658:28: ( ( () otherlv_1= 'gauss' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1659:1: ( () otherlv_1= 'gauss' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1659:1: ( () otherlv_1= 'gauss' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1659:2: () otherlv_1= 'gauss' (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1659:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1660:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getGaussianTypeSpecifierAccess().getGaussianTypeSpecifierAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,37,FOLLOW_37_in_ruleGaussianTypeSpecifier3600); 

                	newLeafNode(otherlv_1, grammarAccess.getGaussianTypeSpecifierAccess().getGaussKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1669:1: (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==25) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1669:3: otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleGaussianTypeSpecifier3613); 

                        	newLeafNode(otherlv_2, grammarAccess.getGaussianTypeSpecifierAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1673:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1674:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1674:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1675:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier3634);
                    lv_unit_3_0=ruleUnitExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGaussianTypeSpecifierRule());
                    	        }
                           		set(
                           			current, 
                           			"unit",
                            		lv_unit_3_0, 
                            		"UnitExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleGaussianTypeSpecifier3646); 

                        	newLeafNode(otherlv_4, grammarAccess.getGaussianTypeSpecifierAccess().getRightParenthesisKeyword_2_2());
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1695:3: (otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1695:5: otherlv_5= '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* otherlv_9= ']'
                    {
                    otherlv_5=(Token)match(input,33,FOLLOW_33_in_ruleGaussianTypeSpecifier3661); 

                        	newLeafNode(otherlv_5, grammarAccess.getGaussianTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1699:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1700:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1700:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1701:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3682);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGaussianTypeSpecifierRule());
                    	        }
                           		add(
                           			current, 
                           			"dimensions",
                            		lv_dimensions_6_0, 
                            		"ArrayDimensionSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1717:2: (otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==14) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1717:4: otherlv_7= ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleGaussianTypeSpecifier3695); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getGaussianTypeSpecifierAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1721:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1722:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1722:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1723:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3716);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getGaussianTypeSpecifierRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dimensions",
                    	            		lv_dimensions_8_0, 
                    	            		"ArrayDimensionSpecification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,34,FOLLOW_34_in_ruleGaussianTypeSpecifier3730); 

                        	newLeafNode(otherlv_9, grammarAccess.getGaussianTypeSpecifierAccess().getRightSquareBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleGaussianTypeSpecifier"


    // $ANTLR start "entryRuleBooleanTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1751:1: entryRuleBooleanTypeSpecifier returns [EObject current=null] : iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF ;
    public final EObject entryRuleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1752:2: (iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1753:2: iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier3768);
            iv_ruleBooleanTypeSpecifier=ruleBooleanTypeSpecifier();

            state._fsp--;

             current =iv_ruleBooleanTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier3778); 

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
    // $ANTLR end "entryRuleBooleanTypeSpecifier"


    // $ANTLR start "ruleBooleanTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1760:1: ruleBooleanTypeSpecifier returns [EObject current=null] : ( () otherlv_1= 'bool' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )? ) ;
    public final EObject ruleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1763:28: ( ( () otherlv_1= 'bool' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1764:1: ( () otherlv_1= 'bool' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1764:1: ( () otherlv_1= 'bool' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1764:2: () otherlv_1= 'bool' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1764:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1765:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanTypeSpecifierAccess().getBooleanTypeSpecifierAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleBooleanTypeSpecifier3824); 

                	newLeafNode(otherlv_1, grammarAccess.getBooleanTypeSpecifierAccess().getBoolKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1774:1: (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==33) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1774:3: otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleBooleanTypeSpecifier3837); 

                        	newLeafNode(otherlv_2, grammarAccess.getBooleanTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1778:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1779:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1779:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1780:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier3858);
                    lv_dimensions_3_0=ruleArrayDimensionSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBooleanTypeSpecifierRule());
                    	        }
                           		add(
                           			current, 
                           			"dimensions",
                            		lv_dimensions_3_0, 
                            		"ArrayDimensionSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1796:2: (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==14) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1796:4: otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleBooleanTypeSpecifier3871); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getBooleanTypeSpecifierAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1800:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1801:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1801:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1802:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier3892);
                    	    lv_dimensions_5_0=ruleArrayDimensionSpecification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getBooleanTypeSpecifierRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dimensions",
                    	            		lv_dimensions_5_0, 
                    	            		"ArrayDimensionSpecification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleBooleanTypeSpecifier3906); 

                        	newLeafNode(otherlv_6, grammarAccess.getBooleanTypeSpecifierAccess().getRightSquareBracketKeyword_2_3());
                        

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
    // $ANTLR end "ruleBooleanTypeSpecifier"


    // $ANTLR start "entryRuleStringTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1830:1: entryRuleStringTypeSpecifier returns [EObject current=null] : iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF ;
    public final EObject entryRuleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1831:2: (iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1832:2: iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getStringTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier3944);
            iv_ruleStringTypeSpecifier=ruleStringTypeSpecifier();

            state._fsp--;

             current =iv_ruleStringTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTypeSpecifier3954); 

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
    // $ANTLR end "entryRuleStringTypeSpecifier"


    // $ANTLR start "ruleStringTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1839:1: ruleStringTypeSpecifier returns [EObject current=null] : ( () otherlv_1= 'string' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )? ) ;
    public final EObject ruleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1842:28: ( ( () otherlv_1= 'string' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1843:1: ( () otherlv_1= 'string' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1843:1: ( () otherlv_1= 'string' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1843:2: () otherlv_1= 'string' (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1843:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1844:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStringTypeSpecifierAccess().getStringTypeSpecifierAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleStringTypeSpecifier4000); 

                	newLeafNode(otherlv_1, grammarAccess.getStringTypeSpecifierAccess().getStringKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1853:1: (otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1853:3: otherlv_2= '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_33_in_ruleStringTypeSpecifier4013); 

                        	newLeafNode(otherlv_2, grammarAccess.getStringTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1857:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1858:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1858:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1859:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4034);
                    lv_dimensions_3_0=ruleArrayDimensionSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStringTypeSpecifierRule());
                    	        }
                           		add(
                           			current, 
                           			"dimensions",
                            		lv_dimensions_3_0, 
                            		"ArrayDimensionSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1875:2: (otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==14) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1875:4: otherlv_4= ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleStringTypeSpecifier4047); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getStringTypeSpecifierAccess().getCommaKeyword_2_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1879:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1880:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1880:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1881:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4068);
                    	    lv_dimensions_5_0=ruleArrayDimensionSpecification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStringTypeSpecifierRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dimensions",
                    	            		lv_dimensions_5_0, 
                    	            		"ArrayDimensionSpecification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleStringTypeSpecifier4082); 

                        	newLeafNode(otherlv_6, grammarAccess.getStringTypeSpecifierAccess().getRightSquareBracketKeyword_2_3());
                        

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
    // $ANTLR end "ruleStringTypeSpecifier"


    // $ANTLR start "entryRuleNamedTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1909:1: entryRuleNamedTypeSpecifier returns [EObject current=null] : iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF ;
    public final EObject entryRuleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1910:2: (iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1911:2: iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF
            {
             newCompositeNode(grammarAccess.getNamedTypeSpecifierRule()); 
            pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier4120);
            iv_ruleNamedTypeSpecifier=ruleNamedTypeSpecifier();

            state._fsp--;

             current =iv_ruleNamedTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTypeSpecifier4130); 

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
    // $ANTLR end "entryRuleNamedTypeSpecifier"


    // $ANTLR start "ruleNamedTypeSpecifier"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1918:1: ruleNamedTypeSpecifier returns [EObject current=null] : ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) (otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* otherlv_5= ']' )? ) ;
    public final EObject ruleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_typeReference_0_0 = null;

        EObject lv_dimensions_2_0 = null;

        EObject lv_dimensions_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1921:28: ( ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) (otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* otherlv_5= ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1922:1: ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) (otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* otherlv_5= ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1922:1: ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) (otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* otherlv_5= ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1922:2: ( (lv_typeReference_0_0= ruleQualifiedName ) ) (otherlv_1= '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) (otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* otherlv_5= ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1922:2: ( (lv_typeReference_0_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1923:1: (lv_typeReference_0_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1923:1: (lv_typeReference_0_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1924:3: lv_typeReference_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getTypeReferenceQualifiedNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamedTypeSpecifier4176);
            lv_typeReference_0_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedTypeSpecifierRule());
            	        }
                   		set(
                   			current, 
                   			"typeReference",
                    		lv_typeReference_0_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1940:2: (otherlv_1= '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) (otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* otherlv_5= ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==33) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1940:4: otherlv_1= '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) (otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,33,FOLLOW_33_in_ruleNamedTypeSpecifier4189); 

                        	newLeafNode(otherlv_1, grammarAccess.getNamedTypeSpecifierAccess().getLeftSquareBracketKeyword_1_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1944:1: ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1945:1: (lv_dimensions_2_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1945:1: (lv_dimensions_2_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1946:3: lv_dimensions_2_0= ruleArrayDimensionSpecification
                    {
                     
                    	        newCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4210);
                    lv_dimensions_2_0=ruleArrayDimensionSpecification();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNamedTypeSpecifierRule());
                    	        }
                           		add(
                           			current, 
                           			"dimensions",
                            		lv_dimensions_2_0, 
                            		"ArrayDimensionSpecification");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1962:2: (otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )*
                    loop36:
                    do {
                        int alt36=2;
                        int LA36_0 = input.LA(1);

                        if ( (LA36_0==14) ) {
                            alt36=1;
                        }


                        switch (alt36) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1962:4: otherlv_3= ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleNamedTypeSpecifier4223); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getNamedTypeSpecifierAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1966:1: ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1967:1: (lv_dimensions_4_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1967:1: (lv_dimensions_4_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1968:3: lv_dimensions_4_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4244);
                    	    lv_dimensions_4_0=ruleArrayDimensionSpecification();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getNamedTypeSpecifierRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"dimensions",
                    	            		lv_dimensions_4_0, 
                    	            		"ArrayDimensionSpecification");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleNamedTypeSpecifier4258); 

                        	newLeafNode(otherlv_5, grammarAccess.getNamedTypeSpecifierAccess().getRightSquareBracketKeyword_1_3());
                        

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
    // $ANTLR end "ruleNamedTypeSpecifier"


    // $ANTLR start "entryRuleArrayDimensionSpecification"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1996:1: entryRuleArrayDimensionSpecification returns [EObject current=null] : iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF ;
    public final EObject entryRuleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayDimensionSpecification = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1997:2: (iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1998:2: iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF
            {
             newCompositeNode(grammarAccess.getArrayDimensionSpecificationRule()); 
            pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification4296);
            iv_ruleArrayDimensionSpecification=ruleArrayDimensionSpecification();

            state._fsp--;

             current =iv_ruleArrayDimensionSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayDimensionSpecification4306); 

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
    // $ANTLR end "entryRuleArrayDimensionSpecification"


    // $ANTLR start "ruleArrayDimensionSpecification"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2005:1: ruleArrayDimensionSpecification returns [EObject current=null] : ( () ( (lv_size_1_0= ruleExpression ) )? ) ;
    public final EObject ruleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_size_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2008:28: ( ( () ( (lv_size_1_0= ruleExpression ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2009:1: ( () ( (lv_size_1_0= ruleExpression ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2009:1: ( () ( (lv_size_1_0= ruleExpression ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2009:2: () ( (lv_size_1_0= ruleExpression ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2009:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2010:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayDimensionSpecificationAccess().getArrayDimensionSpecificationAction_0(),
                        current);
                

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2015:2: ( (lv_size_1_0= ruleExpression ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_STRING)||LA38_0==13||LA38_0==25||LA38_0==28||LA38_0==33||LA38_0==40||LA38_0==42||LA38_0==45||(LA38_0>=55 && LA38_0<=57)||LA38_0==61||LA38_0==74||(LA38_0>=76 && LA38_0<=77)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2016:1: (lv_size_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2016:1: (lv_size_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2017:3: lv_size_1_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getSizeExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification4361);
                    lv_size_1_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrayDimensionSpecificationRule());
                    	        }
                           		set(
                           			current, 
                           			"size",
                            		lv_size_1_0, 
                            		"Expression");
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
    // $ANTLR end "ruleArrayDimensionSpecification"


    // $ANTLR start "entryRuleExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2041:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2042:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2043:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4398);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4408); 

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2050:1: ruleExpression returns [EObject current=null] : (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LetExpression_0 = null;

        EObject this_IfExpression_1 = null;

        EObject this_SwitchExpression_2 = null;

        EObject this_RangeExpression_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2053:28: ( (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2054:1: (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2054:1: (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression )
            int alt39=4;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt39=1;
                }
                break;
            case 28:
                {
                int LA39_2 = input.LA(2);

                if ( (LA39_2==42) ) {
                    alt39=2;
                }
                else if ( (LA39_2==45) ) {
                    alt39=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 2, input);

                    throw nvae;
                }
                }
                break;
            case 42:
                {
                alt39=2;
                }
                break;
            case 45:
                {
                alt39=3;
                }
                break;
            case RULE_ID:
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 13:
            case 25:
            case 33:
            case 55:
            case 56:
            case 57:
            case 61:
            case 74:
            case 76:
            case 77:
                {
                alt39=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2055:5: this_LetExpression_0= ruleLetExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getLetExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLetExpression_in_ruleExpression4455);
                    this_LetExpression_0=ruleLetExpression();

                    state._fsp--;

                     
                            current = this_LetExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2065:5: this_IfExpression_1= ruleIfExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getIfExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIfExpression_in_ruleExpression4482);
                    this_IfExpression_1=ruleIfExpression();

                    state._fsp--;

                     
                            current = this_IfExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2075:5: this_SwitchExpression_2= ruleSwitchExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getSwitchExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSwitchExpression_in_ruleExpression4509);
                    this_SwitchExpression_2=ruleSwitchExpression();

                    state._fsp--;

                     
                            current = this_SwitchExpression_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2085:5: this_RangeExpression_3= ruleRangeExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getRangeExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleRangeExpression_in_ruleExpression4536);
                    this_RangeExpression_3=ruleRangeExpression();

                    state._fsp--;

                     
                            current = this_RangeExpression_3; 
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLetExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2101:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2102:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2103:2: iv_ruleLetExpression= ruleLetExpression EOF
            {
             newCompositeNode(grammarAccess.getLetExpressionRule()); 
            pushFollow(FOLLOW_ruleLetExpression_in_entryRuleLetExpression4571);
            iv_ruleLetExpression=ruleLetExpression();

            state._fsp--;

             current =iv_ruleLetExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpression4581); 

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
    // $ANTLR end "entryRuleLetExpression"


    // $ANTLR start "ruleLetExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2110:1: ruleLetExpression returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration ) ) (otherlv_2= ',' ( (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration ) ) )* otherlv_4= 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleLetExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_variableDeclarations_1_0 = null;

        EObject lv_variableDeclarations_3_0 = null;

        EObject lv_targetExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2113:28: ( (otherlv_0= 'let' ( (lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration ) ) (otherlv_2= ',' ( (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration ) ) )* otherlv_4= 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2114:1: (otherlv_0= 'let' ( (lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration ) ) (otherlv_2= ',' ( (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration ) ) )* otherlv_4= 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2114:1: (otherlv_0= 'let' ( (lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration ) ) (otherlv_2= ',' ( (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration ) ) )* otherlv_4= 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2114:3: otherlv_0= 'let' ( (lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration ) ) (otherlv_2= ',' ( (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration ) ) )* otherlv_4= 'in' ( (lv_targetExpression_5_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleLetExpression4618); 

                	newLeafNode(otherlv_0, grammarAccess.getLetExpressionAccess().getLetKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2118:1: ( (lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2119:1: (lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2119:1: (lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2120:3: lv_variableDeclarations_1_0= ruleLetExpressionVariableDeclaration
            {
             
            	        newCompositeNode(grammarAccess.getLetExpressionAccess().getVariableDeclarationsLetExpressionVariableDeclarationParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleLetExpressionVariableDeclaration_in_ruleLetExpression4639);
            lv_variableDeclarations_1_0=ruleLetExpressionVariableDeclaration();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"variableDeclarations",
                    		lv_variableDeclarations_1_0, 
                    		"LetExpressionVariableDeclaration");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2136:2: (otherlv_2= ',' ( (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==14) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2136:4: otherlv_2= ',' ( (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration ) )
            	    {
            	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleLetExpression4652); 

            	        	newLeafNode(otherlv_2, grammarAccess.getLetExpressionAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2140:1: ( (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2141:1: (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2141:1: (lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2142:3: lv_variableDeclarations_3_0= ruleLetExpressionVariableDeclaration
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLetExpressionAccess().getVariableDeclarationsLetExpressionVariableDeclarationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLetExpressionVariableDeclaration_in_ruleLetExpression4673);
            	    lv_variableDeclarations_3_0=ruleLetExpressionVariableDeclaration();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"variableDeclarations",
            	            		lv_variableDeclarations_3_0, 
            	            		"LetExpressionVariableDeclaration");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            otherlv_4=(Token)match(input,41,FOLLOW_41_in_ruleLetExpression4687); 

                	newLeafNode(otherlv_4, grammarAccess.getLetExpressionAccess().getInKeyword_3());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2162:1: ( (lv_targetExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2163:1: (lv_targetExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2163:1: (lv_targetExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2164:3: lv_targetExpression_5_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getLetExpressionAccess().getTargetExpressionExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression4708);
            lv_targetExpression_5_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"targetExpression",
                    		lv_targetExpression_5_0, 
                    		"Expression");
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
    // $ANTLR end "ruleLetExpression"


    // $ANTLR start "entryRuleLetExpressionVariableDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2188:1: entryRuleLetExpressionVariableDeclaration returns [EObject current=null] : iv_ruleLetExpressionVariableDeclaration= ruleLetExpressionVariableDeclaration EOF ;
    public final EObject entryRuleLetExpressionVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpressionVariableDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2189:2: (iv_ruleLetExpressionVariableDeclaration= ruleLetExpressionVariableDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2190:2: iv_ruleLetExpressionVariableDeclaration= ruleLetExpressionVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getLetExpressionVariableDeclarationRule()); 
            pushFollow(FOLLOW_ruleLetExpressionVariableDeclaration_in_entryRuleLetExpressionVariableDeclaration4744);
            iv_ruleLetExpressionVariableDeclaration=ruleLetExpressionVariableDeclaration();

            state._fsp--;

             current =iv_ruleLetExpressionVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpressionVariableDeclaration4754); 

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
    // $ANTLR end "entryRuleLetExpressionVariableDeclaration"


    // $ANTLR start "ruleLetExpressionVariableDeclaration"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2197:1: ruleLetExpressionVariableDeclaration returns [EObject current=null] : ( ( ( (lv_names_0_0= RULE_ID ) ) | (otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')' ) ) otherlv_6= '=' ( (lv_assignedExpression_7_0= ruleExpression ) ) ) ;
    public final EObject ruleLetExpressionVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_names_0_0=null;
        Token otherlv_1=null;
        Token lv_names_2_0=null;
        Token otherlv_3=null;
        Token lv_names_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_assignedExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2200:28: ( ( ( ( (lv_names_0_0= RULE_ID ) ) | (otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')' ) ) otherlv_6= '=' ( (lv_assignedExpression_7_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2201:1: ( ( ( (lv_names_0_0= RULE_ID ) ) | (otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')' ) ) otherlv_6= '=' ( (lv_assignedExpression_7_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2201:1: ( ( ( (lv_names_0_0= RULE_ID ) ) | (otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')' ) ) otherlv_6= '=' ( (lv_assignedExpression_7_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2201:2: ( ( (lv_names_0_0= RULE_ID ) ) | (otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')' ) ) otherlv_6= '=' ( (lv_assignedExpression_7_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2201:2: ( ( (lv_names_0_0= RULE_ID ) ) | (otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                alt42=1;
            }
            else if ( (LA42_0==25) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2201:3: ( (lv_names_0_0= RULE_ID ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2201:3: ( (lv_names_0_0= RULE_ID ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2202:1: (lv_names_0_0= RULE_ID )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2202:1: (lv_names_0_0= RULE_ID )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2203:3: lv_names_0_0= RULE_ID
                    {
                    lv_names_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLetExpressionVariableDeclaration4797); 

                    			newLeafNode(lv_names_0_0, grammarAccess.getLetExpressionVariableDeclarationAccess().getNamesIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLetExpressionVariableDeclarationRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"names",
                            		lv_names_0_0, 
                            		"ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2220:6: (otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2220:6: (otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2220:8: otherlv_1= '(' ( (lv_names_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+ otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleLetExpressionVariableDeclaration4821); 

                        	newLeafNode(otherlv_1, grammarAccess.getLetExpressionVariableDeclarationAccess().getLeftParenthesisKeyword_0_1_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2224:1: ( (lv_names_2_0= RULE_ID ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2225:1: (lv_names_2_0= RULE_ID )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2225:1: (lv_names_2_0= RULE_ID )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2226:3: lv_names_2_0= RULE_ID
                    {
                    lv_names_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLetExpressionVariableDeclaration4838); 

                    			newLeafNode(lv_names_2_0, grammarAccess.getLetExpressionVariableDeclarationAccess().getNamesIDTerminalRuleCall_0_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLetExpressionVariableDeclarationRule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"names",
                            		lv_names_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2242:2: (otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) ) )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==14) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2242:4: otherlv_3= ',' ( (lv_names_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleLetExpressionVariableDeclaration4856); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getLetExpressionVariableDeclarationAccess().getCommaKeyword_0_1_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2246:1: ( (lv_names_4_0= RULE_ID ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2247:1: (lv_names_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2247:1: (lv_names_4_0= RULE_ID )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2248:3: lv_names_4_0= RULE_ID
                    	    {
                    	    lv_names_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLetExpressionVariableDeclaration4873); 

                    	    			newLeafNode(lv_names_4_0, grammarAccess.getLetExpressionVariableDeclarationAccess().getNamesIDTerminalRuleCall_0_1_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getLetExpressionVariableDeclarationRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"names",
                    	            		lv_names_4_0, 
                    	            		"ID");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);

                    otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleLetExpressionVariableDeclaration4892); 

                        	newLeafNode(otherlv_5, grammarAccess.getLetExpressionVariableDeclarationAccess().getRightParenthesisKeyword_0_1_3());
                        

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleLetExpressionVariableDeclaration4906); 

                	newLeafNode(otherlv_6, grammarAccess.getLetExpressionVariableDeclarationAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2272:1: ( (lv_assignedExpression_7_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2273:1: (lv_assignedExpression_7_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2273:1: (lv_assignedExpression_7_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2274:3: lv_assignedExpression_7_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getLetExpressionVariableDeclarationAccess().getAssignedExpressionExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpressionVariableDeclaration4927);
            lv_assignedExpression_7_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetExpressionVariableDeclarationRule());
            	        }
                   		set(
                   			current, 
                   			"assignedExpression",
                    		lv_assignedExpression_7_0, 
                    		"Expression");
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
    // $ANTLR end "ruleLetExpressionVariableDeclaration"


    // $ANTLR start "entryRuleIfExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2298:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2299:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2300:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
             newCompositeNode(grammarAccess.getIfExpressionRule()); 
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression4963);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;

             current =iv_ruleIfExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression4973); 

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
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2307:1: ruleIfExpression returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleExpression ) ) ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_condition_2_0 = null;

        EObject lv_thenExpression_4_0 = null;

        EObject lv_elseExpression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2310:28: ( ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2311:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2311:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2311:2: ( (lv_static_0_0= 'static' ) )? otherlv_1= 'if' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= 'then' ( (lv_thenExpression_4_0= ruleExpression ) ) otherlv_5= 'else' ( (lv_elseExpression_6_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2311:2: ( (lv_static_0_0= 'static' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==28) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2312:1: (lv_static_0_0= 'static' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2312:1: (lv_static_0_0= 'static' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2313:3: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)match(input,28,FOLLOW_28_in_ruleIfExpression5016); 

                            newLeafNode(lv_static_0_0, grammarAccess.getIfExpressionAccess().getStaticStaticKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIfExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "static", true, "static");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,42,FOLLOW_42_in_ruleIfExpression5042); 

                	newLeafNode(otherlv_1, grammarAccess.getIfExpressionAccess().getIfKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2330:1: ( (lv_condition_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2331:1: (lv_condition_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2331:1: (lv_condition_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2332:3: lv_condition_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIfExpressionAccess().getConditionExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression5063);
            lv_condition_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,43,FOLLOW_43_in_ruleIfExpression5075); 

                	newLeafNode(otherlv_3, grammarAccess.getIfExpressionAccess().getThenKeyword_3());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2352:1: ( (lv_thenExpression_4_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2353:1: (lv_thenExpression_4_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2353:1: (lv_thenExpression_4_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2354:3: lv_thenExpression_4_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionExpressionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression5096);
            lv_thenExpression_4_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"thenExpression",
                    		lv_thenExpression_4_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,44,FOLLOW_44_in_ruleIfExpression5108); 

                	newLeafNode(otherlv_5, grammarAccess.getIfExpressionAccess().getElseKeyword_5());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2374:1: ( (lv_elseExpression_6_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2375:1: (lv_elseExpression_6_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2375:1: (lv_elseExpression_6_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2376:3: lv_elseExpression_6_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionExpressionParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression5129);
            lv_elseExpression_6_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"elseExpression",
                    		lv_elseExpression_6_0, 
                    		"Expression");
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
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleSwitchExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2400:1: entryRuleSwitchExpression returns [EObject current=null] : iv_ruleSwitchExpression= ruleSwitchExpression EOF ;
    public final EObject entryRuleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2401:2: (iv_ruleSwitchExpression= ruleSwitchExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2402:2: iv_ruleSwitchExpression= ruleSwitchExpression EOF
            {
             newCompositeNode(grammarAccess.getSwitchExpressionRule()); 
            pushFollow(FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression5165);
            iv_ruleSwitchExpression=ruleSwitchExpression();

            state._fsp--;

             current =iv_ruleSwitchExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchExpression5175); 

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
    // $ANTLR end "entryRuleSwitchExpression"


    // $ANTLR start "ruleSwitchExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2409:1: ruleSwitchExpression returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'switch' ( (lv_controlExpression_2_0= ruleExpression ) ) ( (lv_cases_3_0= ruleSwitchCase ) )* otherlv_4= 'default' otherlv_5= ':' ( (lv_defaultExpression_6_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_controlExpression_2_0 = null;

        EObject lv_cases_3_0 = null;

        EObject lv_defaultExpression_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2412:28: ( ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'switch' ( (lv_controlExpression_2_0= ruleExpression ) ) ( (lv_cases_3_0= ruleSwitchCase ) )* otherlv_4= 'default' otherlv_5= ':' ( (lv_defaultExpression_6_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2413:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'switch' ( (lv_controlExpression_2_0= ruleExpression ) ) ( (lv_cases_3_0= ruleSwitchCase ) )* otherlv_4= 'default' otherlv_5= ':' ( (lv_defaultExpression_6_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2413:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'switch' ( (lv_controlExpression_2_0= ruleExpression ) ) ( (lv_cases_3_0= ruleSwitchCase ) )* otherlv_4= 'default' otherlv_5= ':' ( (lv_defaultExpression_6_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2413:2: ( (lv_static_0_0= 'static' ) )? otherlv_1= 'switch' ( (lv_controlExpression_2_0= ruleExpression ) ) ( (lv_cases_3_0= ruleSwitchCase ) )* otherlv_4= 'default' otherlv_5= ':' ( (lv_defaultExpression_6_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2413:2: ( (lv_static_0_0= 'static' ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==28) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2414:1: (lv_static_0_0= 'static' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2414:1: (lv_static_0_0= 'static' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2415:3: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)match(input,28,FOLLOW_28_in_ruleSwitchExpression5218); 

                            newLeafNode(lv_static_0_0, grammarAccess.getSwitchExpressionAccess().getStaticStaticKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSwitchExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "static", true, "static");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleSwitchExpression5244); 

                	newLeafNode(otherlv_1, grammarAccess.getSwitchExpressionAccess().getSwitchKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2432:1: ( (lv_controlExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2433:1: (lv_controlExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2433:1: (lv_controlExpression_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2434:3: lv_controlExpression_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getSwitchExpressionAccess().getControlExpressionExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression5265);
            lv_controlExpression_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"controlExpression",
                    		lv_controlExpression_2_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2450:2: ( (lv_cases_3_0= ruleSwitchCase ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==47) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2451:1: (lv_cases_3_0= ruleSwitchCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2451:1: (lv_cases_3_0= ruleSwitchCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2452:3: lv_cases_3_0= ruleSwitchCase
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSwitchExpressionAccess().getCasesSwitchCaseParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSwitchCase_in_ruleSwitchExpression5286);
            	    lv_cases_3_0=ruleSwitchCase();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSwitchExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"cases",
            	            		lv_cases_3_0, 
            	            		"SwitchCase");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            otherlv_4=(Token)match(input,46,FOLLOW_46_in_ruleSwitchExpression5299); 

                	newLeafNode(otherlv_4, grammarAccess.getSwitchExpressionAccess().getDefaultKeyword_4());
                
            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleSwitchExpression5311); 

                	newLeafNode(otherlv_5, grammarAccess.getSwitchExpressionAccess().getColonKeyword_5());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2476:1: ( (lv_defaultExpression_6_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2477:1: (lv_defaultExpression_6_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2477:1: (lv_defaultExpression_6_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2478:3: lv_defaultExpression_6_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getSwitchExpressionAccess().getDefaultExpressionExpressionParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression5332);
            lv_defaultExpression_6_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"defaultExpression",
                    		lv_defaultExpression_6_0, 
                    		"Expression");
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
    // $ANTLR end "ruleSwitchExpression"


    // $ANTLR start "entryRuleSwitchCase"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2502:1: entryRuleSwitchCase returns [EObject current=null] : iv_ruleSwitchCase= ruleSwitchCase EOF ;
    public final EObject entryRuleSwitchCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2503:2: (iv_ruleSwitchCase= ruleSwitchCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2504:2: iv_ruleSwitchCase= ruleSwitchCase EOF
            {
             newCompositeNode(grammarAccess.getSwitchCaseRule()); 
            pushFollow(FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase5368);
            iv_ruleSwitchCase=ruleSwitchCase();

            state._fsp--;

             current =iv_ruleSwitchCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchCase5378); 

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
    // $ANTLR end "entryRuleSwitchCase"


    // $ANTLR start "ruleSwitchCase"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2511:1: ruleSwitchCase returns [EObject current=null] : (otherlv_0= 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) otherlv_2= ':' ( (lv_resultExpression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_caseExpression_1_0 = null;

        EObject lv_resultExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2514:28: ( (otherlv_0= 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) otherlv_2= ':' ( (lv_resultExpression_3_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2515:1: (otherlv_0= 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) otherlv_2= ':' ( (lv_resultExpression_3_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2515:1: (otherlv_0= 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) otherlv_2= ':' ( (lv_resultExpression_3_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2515:3: otherlv_0= 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) otherlv_2= ':' ( (lv_resultExpression_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_47_in_ruleSwitchCase5415); 

                	newLeafNode(otherlv_0, grammarAccess.getSwitchCaseAccess().getCaseKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2519:1: ( (lv_caseExpression_1_0= ruleImpliesExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2520:1: (lv_caseExpression_1_0= ruleImpliesExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2520:1: (lv_caseExpression_1_0= ruleImpliesExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2521:3: lv_caseExpression_1_0= ruleImpliesExpression
            {
             
            	        newCompositeNode(grammarAccess.getSwitchCaseAccess().getCaseExpressionImpliesExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleSwitchCase5436);
            lv_caseExpression_1_0=ruleImpliesExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchCaseRule());
            	        }
                   		set(
                   			current, 
                   			"caseExpression",
                    		lv_caseExpression_1_0, 
                    		"ImpliesExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleSwitchCase5448); 

                	newLeafNode(otherlv_2, grammarAccess.getSwitchCaseAccess().getColonKeyword_2());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2541:1: ( (lv_resultExpression_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2542:1: (lv_resultExpression_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2542:1: (lv_resultExpression_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2543:3: lv_resultExpression_3_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getSwitchCaseAccess().getResultExpressionExpressionParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchCase5469);
            lv_resultExpression_3_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSwitchCaseRule());
            	        }
                   		set(
                   			current, 
                   			"resultExpression",
                    		lv_resultExpression_3_0, 
                    		"Expression");
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
    // $ANTLR end "ruleSwitchCase"


    // $ANTLR start "entryRuleRangeExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2567:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2568:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2569:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
             newCompositeNode(grammarAccess.getRangeExpressionRule()); 
            pushFollow(FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression5505);
            iv_ruleRangeExpression=ruleRangeExpression();

            state._fsp--;

             current =iv_ruleRangeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeExpression5515); 

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
    // $ANTLR end "entryRuleRangeExpression"


    // $ANTLR start "ruleRangeExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2576:1: ruleRangeExpression returns [EObject current=null] : (this_ImpliesExpression_0= ruleImpliesExpression ( () otherlv_2= ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) (otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )? ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_ImpliesExpression_0 = null;

        EObject lv_operands_3_0 = null;

        EObject lv_operands_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2579:28: ( (this_ImpliesExpression_0= ruleImpliesExpression ( () otherlv_2= ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) (otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2580:1: (this_ImpliesExpression_0= ruleImpliesExpression ( () otherlv_2= ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) (otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2580:1: (this_ImpliesExpression_0= ruleImpliesExpression ( () otherlv_2= ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) (otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2581:5: this_ImpliesExpression_0= ruleImpliesExpression ( () otherlv_2= ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) (otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )?
            {
             
                    newCompositeNode(grammarAccess.getRangeExpressionAccess().getImpliesExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5562);
            this_ImpliesExpression_0=ruleImpliesExpression();

            state._fsp--;

             
                    current = this_ImpliesExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2589:1: ( () otherlv_2= ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) (otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )? )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==20) ) {
                int LA47_1 = input.LA(2);

                if ( ((LA47_1>=RULE_ID && LA47_1<=RULE_STRING)||LA47_1==13||LA47_1==25||LA47_1==33||(LA47_1>=55 && LA47_1<=57)||LA47_1==61||LA47_1==74||(LA47_1>=76 && LA47_1<=77)) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2589:2: () otherlv_2= ':' ( (lv_operands_3_0= ruleImpliesExpression ) ) (otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2589:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2590:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getRangeExpressionAccess().getRangeExpressionOperandsAction_1_0(),
                                current);
                        

                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleRangeExpression5583); 

                        	newLeafNode(otherlv_2, grammarAccess.getRangeExpressionAccess().getColonKeyword_1_1());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2599:1: ( (lv_operands_3_0= ruleImpliesExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2600:1: (lv_operands_3_0= ruleImpliesExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2600:1: (lv_operands_3_0= ruleImpliesExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2601:3: lv_operands_3_0= ruleImpliesExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRangeExpressionAccess().getOperandsImpliesExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5604);
                    lv_operands_3_0=ruleImpliesExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
                    	        }
                           		add(
                           			current, 
                           			"operands",
                            		lv_operands_3_0, 
                            		"ImpliesExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2617:2: (otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==20) ) {
                        int LA46_1 = input.LA(2);

                        if ( ((LA46_1>=RULE_ID && LA46_1<=RULE_STRING)||LA46_1==13||LA46_1==25||LA46_1==33||(LA46_1>=55 && LA46_1<=57)||LA46_1==61||LA46_1==74||(LA46_1>=76 && LA46_1<=77)) ) {
                            alt46=1;
                        }
                    }
                    switch (alt46) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2617:4: otherlv_4= ':' ( (lv_operands_5_0= ruleImpliesExpression ) )
                            {
                            otherlv_4=(Token)match(input,20,FOLLOW_20_in_ruleRangeExpression5617); 

                                	newLeafNode(otherlv_4, grammarAccess.getRangeExpressionAccess().getColonKeyword_1_3_0());
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2621:1: ( (lv_operands_5_0= ruleImpliesExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2622:1: (lv_operands_5_0= ruleImpliesExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2622:1: (lv_operands_5_0= ruleImpliesExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2623:3: lv_operands_5_0= ruleImpliesExpression
                            {
                             
                            	        newCompositeNode(grammarAccess.getRangeExpressionAccess().getOperandsImpliesExpressionParserRuleCall_1_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5638);
                            lv_operands_5_0=ruleImpliesExpression();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"operands",
                                    		lv_operands_5_0, 
                                    		"ImpliesExpression");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleRangeExpression"


    // $ANTLR start "entryRuleImpliesExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2647:1: entryRuleImpliesExpression returns [EObject current=null] : iv_ruleImpliesExpression= ruleImpliesExpression EOF ;
    public final EObject entryRuleImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2648:2: (iv_ruleImpliesExpression= ruleImpliesExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2649:2: iv_ruleImpliesExpression= ruleImpliesExpression EOF
            {
             newCompositeNode(grammarAccess.getImpliesExpressionRule()); 
            pushFollow(FOLLOW_ruleImpliesExpression_in_entryRuleImpliesExpression5678);
            iv_ruleImpliesExpression=ruleImpliesExpression();

            state._fsp--;

             current =iv_ruleImpliesExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImpliesExpression5688); 

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
    // $ANTLR end "entryRuleImpliesExpression"


    // $ANTLR start "ruleImpliesExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2656:1: ruleImpliesExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleImpliesExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2659:28: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2660:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2660:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2661:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getImpliesExpressionAccess().getLogicalOrExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5735);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;

             
                    current = this_LogicalOrExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2669:1: ( () otherlv_2= '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==48) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2669:2: () otherlv_2= '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2669:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2670:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getImpliesExpressionAccess().getImpliesExpressionLeftOperandAction_1_0(),
                                current);
                        

                    }

                    otherlv_2=(Token)match(input,48,FOLLOW_48_in_ruleImpliesExpression5756); 

                        	newLeafNode(otherlv_2, grammarAccess.getImpliesExpressionAccess().getEqualsSignGreaterThanSignKeyword_1_1());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2679:1: ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2680:1: (lv_rightOperand_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2680:1: (lv_rightOperand_3_0= ruleLogicalOrExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2681:3: lv_rightOperand_3_0= ruleLogicalOrExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getImpliesExpressionAccess().getRightOperandLogicalOrExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5777);
                    lv_rightOperand_3_0=ruleLogicalOrExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getImpliesExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"rightOperand",
                            		lv_rightOperand_3_0, 
                            		"LogicalOrExpression");
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
    // $ANTLR end "ruleImpliesExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2705:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2706:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2707:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5815);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression5825); 

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
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2714:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () (otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2717:28: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () (otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2718:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () (otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2718:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () (otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2719:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () (otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5872);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2727:1: ( () (otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==49) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2727:2: () (otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2727:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2728:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionOperandsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2733:2: (otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    int cnt49=0;
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==49) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2733:4: otherlv_2= '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleLogicalOrExpression5894); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2737:1: ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2738:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2738:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2739:3: lv_operands_3_0= ruleLogicalAndExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandsLogicalAndExpressionParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5915);
                    	    lv_operands_3_0=ruleLogicalAndExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operands",
                    	            		lv_operands_3_0, 
                    	            		"LogicalAndExpression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt49 >= 1 ) break loop49;
                                EarlyExitException eee =
                                    new EarlyExitException(49, input);
                                throw eee;
                        }
                        cnt49++;
                    } while (true);


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
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2763:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2764:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2765:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5955);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression5965); 

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
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2772:1: ruleLogicalAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () (otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_operands_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2775:28: ( (this_EqualityExpression_0= ruleEqualityExpression ( () (otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2776:1: (this_EqualityExpression_0= ruleEqualityExpression ( () (otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2776:1: (this_EqualityExpression_0= ruleEqualityExpression ( () (otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2777:5: this_EqualityExpression_0= ruleEqualityExpression ( () (otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression6012);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;

             
                    current = this_EqualityExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2785:1: ( () (otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==50) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2785:2: () (otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2785:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2786:5: 
                    {

                            current = forceCreateModelElementAndAdd(
                                grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionOperandsAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2791:2: (otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+
                    int cnt51=0;
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==50) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2791:4: otherlv_2= '&&' ( (lv_operands_3_0= ruleEqualityExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,50,FOLLOW_50_in_ruleLogicalAndExpression6034); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2795:1: ( (lv_operands_3_0= ruleEqualityExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2796:1: (lv_operands_3_0= ruleEqualityExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2796:1: (lv_operands_3_0= ruleEqualityExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2797:3: lv_operands_3_0= ruleEqualityExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandsEqualityExpressionParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression6055);
                    	    lv_operands_3_0=ruleEqualityExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"operands",
                    	            		lv_operands_3_0, 
                    	            		"EqualityExpression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt51 >= 1 ) break loop51;
                                EarlyExitException eee =
                                    new EarlyExitException(51, input);
                                throw eee;
                        }
                        cnt51++;
                    } while (true);


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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2821:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2822:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2823:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression6095);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression6105); 

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
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2830:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2833:28: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2834:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2834:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2835:5: this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression6152);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;

             
                    current = this_RelationalExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2843:1: ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=66 && LA53_0<=67)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2843:2: () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2843:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2844:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftOperandAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2849:2: ( (lv_operator_2_0= ruleEqualityOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2850:1: (lv_operator_2_0= ruleEqualityOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2850:1: (lv_operator_2_0= ruleEqualityOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2851:3: lv_operator_2_0= ruleEqualityOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorEqualityOperatorEnumRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression6182);
                    lv_operator_2_0=ruleEqualityOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"operator",
                            		lv_operator_2_0, 
                            		"EqualityOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2867:2: ( (lv_rightOperand_3_0= ruleRelationalExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2868:1: (lv_rightOperand_3_0= ruleRelationalExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2868:1: (lv_rightOperand_3_0= ruleRelationalExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2869:3: lv_rightOperand_3_0= ruleRelationalExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightOperandRelationalExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression6203);
                    lv_rightOperand_3_0=ruleRelationalExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"rightOperand",
                            		lv_rightOperand_3_0, 
                            		"RelationalExpression");
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2893:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2894:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2895:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6241);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression6251); 

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
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2902:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) ) ) | ( () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;

        EObject lv_type_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2905:28: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) ) ) | ( () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2906:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) ) ) | ( () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2906:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) ) ) | ( () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2907:5: this_AdditiveExpression_0= ruleAdditiveExpression ( ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) ) ) | ( () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6298);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;

             
                    current = this_AdditiveExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2915:1: ( ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) ) ) | ( () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) ) ) )?
            int alt54=3;
            switch ( input.LA(1) ) {
                case 23:
                case 68:
                case 69:
                    {
                    alt54=1;
                    }
                    break;
                case 24:
                    {
                    int LA54_2 = input.LA(2);

                    if ( ((LA54_2>=RULE_ID && LA54_2<=RULE_STRING)||LA54_2==13||LA54_2==25||LA54_2==33||(LA54_2>=55 && LA54_2<=57)||LA54_2==61||LA54_2==74||(LA54_2>=76 && LA54_2<=77)) ) {
                        alt54=1;
                    }
                    }
                    break;
                case 51:
                    {
                    alt54=2;
                    }
                    break;
            }

            switch (alt54) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2915:2: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2915:2: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2915:3: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleAdditiveExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2915:3: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2916:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLeftOperandAction_1_0_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2921:2: ( (lv_operator_2_0= ruleRelationalOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2922:1: (lv_operator_2_0= ruleRelationalOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2922:1: (lv_operator_2_0= ruleRelationalOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2923:3: lv_operator_2_0= ruleRelationalOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6329);
                    lv_operator_2_0=ruleRelationalOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"operator",
                            		lv_operator_2_0, 
                            		"RelationalOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2939:2: ( (lv_rightOperand_3_0= ruleAdditiveExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2940:1: (lv_rightOperand_3_0= ruleAdditiveExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2940:1: (lv_rightOperand_3_0= ruleAdditiveExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2941:3: lv_rightOperand_3_0= ruleAdditiveExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightOperandAdditiveExpressionParserRuleCall_1_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6350);
                    lv_rightOperand_3_0=ruleAdditiveExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"rightOperand",
                            		lv_rightOperand_3_0, 
                            		"AdditiveExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2958:6: ( () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2958:6: ( () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2958:7: () otherlv_5= 'is' ( (lv_type_6_0= ruleDataTypeSpecifier ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2958:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2959:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getRelationalExpressionAccess().getTypeTestExpressionExpressionAction_1_1_0(),
                                current);
                        

                    }

                    otherlv_5=(Token)match(input,51,FOLLOW_51_in_ruleRelationalExpression6379); 

                        	newLeafNode(otherlv_5, grammarAccess.getRelationalExpressionAccess().getIsKeyword_1_1_1());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2968:1: ( (lv_type_6_0= ruleDataTypeSpecifier ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2969:1: (lv_type_6_0= ruleDataTypeSpecifier )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2969:1: (lv_type_6_0= ruleDataTypeSpecifier )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2970:3: lv_type_6_0= ruleDataTypeSpecifier
                    {
                     
                    	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_1_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6400);
                    lv_type_6_0=ruleDataTypeSpecifier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_6_0, 
                            		"DataTypeSpecifier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


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
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2994:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2995:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2996:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6439);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression6449); 

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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3003:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_rightParts_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3006:28: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3007:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3007:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3008:5: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6496);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;

             
                    current = this_MultiplicativeExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3016:1: ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==61||LA56_0==70) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3016:2: () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3016:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3017:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftOperandAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3022:2: ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+
                    int cnt55=0;
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==61||LA55_0==70) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3023:1: (lv_rightParts_2_0= ruleAdditiveExpressionPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3023:1: (lv_rightParts_2_0= ruleAdditiveExpressionPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3024:3: lv_rightParts_2_0= ruleAdditiveExpressionPart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightPartsAdditiveExpressionPartParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6526);
                    	    lv_rightParts_2_0=ruleAdditiveExpressionPart();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"rightParts",
                    	            		lv_rightParts_2_0, 
                    	            		"AdditiveExpressionPart");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt55 >= 1 ) break loop55;
                                EarlyExitException eee =
                                    new EarlyExitException(55, input);
                                throw eee;
                        }
                        cnt55++;
                    } while (true);


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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveExpressionPart"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3048:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3049:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3050:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
             newCompositeNode(grammarAccess.getAdditiveExpressionPartRule()); 
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6565);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();

            state._fsp--;

             current =iv_ruleAdditiveExpressionPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6575); 

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
    // $ANTLR end "entryRuleAdditiveExpressionPart"


    // $ANTLR start "ruleAdditiveExpressionPart"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3057:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3060:28: ( ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3061:1: ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3061:1: ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3061:2: ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3061:2: ( (lv_operator_0_0= ruleAdditiveOperator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3062:1: (lv_operator_0_0= ruleAdditiveOperator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3062:1: (lv_operator_0_0= ruleAdditiveOperator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3063:3: lv_operator_0_0= ruleAdditiveOperator
            {
             
            	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOperatorAdditiveOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6621);
            lv_operator_0_0=ruleAdditiveOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionPartRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"AdditiveOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3079:2: ( (lv_operand_1_0= ruleMultiplicativeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3080:1: (lv_operand_1_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3080:1: (lv_operand_1_0= ruleMultiplicativeExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3081:3: lv_operand_1_0= ruleMultiplicativeExpression
            {
             
            	        newCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOperandMultiplicativeExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6642);
            lv_operand_1_0=ruleMultiplicativeExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionPartRule());
            	        }
                   		set(
                   			current, 
                   			"operand",
                    		lv_operand_1_0, 
                    		"MultiplicativeExpression");
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
    // $ANTLR end "ruleAdditiveExpressionPart"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3105:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3106:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3107:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6678);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6688); 

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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3114:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        EObject lv_rightParts_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3117:28: ( (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3118:1: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3118:1: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3119:5: this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )?
            {
             
                    newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getPowerExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpression6735);
            this_PowerExpression_0=rulePowerExpression();

            state._fsp--;

             
                    current = this_PowerExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3127:1: ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=58 && LA58_0<=59)||(LA58_0>=71 && LA58_0<=72)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3127:2: () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3127:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3128:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftOperandAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3133:2: ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+
                    int cnt57=0;
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( ((LA57_0>=58 && LA57_0<=59)||(LA57_0>=71 && LA57_0<=72)) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3134:1: (lv_rightParts_2_0= ruleMultiplicativeExpressionPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3134:1: (lv_rightParts_2_0= ruleMultiplicativeExpressionPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3135:3: lv_rightParts_2_0= ruleMultiplicativeExpressionPart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightPartsMultiplicativeExpressionPartParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6765);
                    	    lv_rightParts_2_0=ruleMultiplicativeExpressionPart();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"rightParts",
                    	            		lv_rightParts_2_0, 
                    	            		"MultiplicativeExpressionPart");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt57 >= 1 ) break loop57;
                                EarlyExitException eee =
                                    new EarlyExitException(57, input);
                                throw eee;
                        }
                        cnt57++;
                    } while (true);


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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleMultiplicativeExpressionPart"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3159:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3160:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3161:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
             newCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule()); 
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6804);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();

            state._fsp--;

             current =iv_ruleMultiplicativeExpressionPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6814); 

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
    // $ANTLR end "entryRuleMultiplicativeExpressionPart"


    // $ANTLR start "ruleMultiplicativeExpressionPart"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3168:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3171:28: ( ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3172:1: ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3172:1: ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3172:2: ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3172:2: ( (lv_operator_0_0= ruleMultiplicativeOperator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3173:1: (lv_operator_0_0= ruleMultiplicativeOperator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3173:1: (lv_operator_0_0= ruleMultiplicativeOperator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3174:3: lv_operator_0_0= ruleMultiplicativeOperator
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOperatorMultiplicativeOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6860);
            lv_operator_0_0=ruleMultiplicativeOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionPartRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"MultiplicativeOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3190:2: ( (lv_operand_1_0= rulePowerExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3191:1: (lv_operand_1_0= rulePowerExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3191:1: (lv_operand_1_0= rulePowerExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3192:3: lv_operand_1_0= rulePowerExpression
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOperandPowerExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpressionPart6881);
            lv_operand_1_0=rulePowerExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionPartRule());
            	        }
                   		set(
                   			current, 
                   			"operand",
                    		lv_operand_1_0, 
                    		"PowerExpression");
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
    // $ANTLR end "ruleMultiplicativeExpressionPart"


    // $ANTLR start "entryRulePowerExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3216:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3217:2: (iv_rulePowerExpression= rulePowerExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3218:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             newCompositeNode(grammarAccess.getPowerExpressionRule()); 
            pushFollow(FOLLOW_rulePowerExpression_in_entryRulePowerExpression6917);
            iv_rulePowerExpression=rulePowerExpression();

            state._fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePowerExpression6927); 

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
    // $ANTLR end "entryRulePowerExpression"


    // $ANTLR start "rulePowerExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3225:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_exponent_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3228:28: ( (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3229:1: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3229:1: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3230:5: this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleUnaryExpression_in_rulePowerExpression6974);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;

             
                    current = this_UnaryExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3238:1: ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==60||LA59_0==73) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3238:2: () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3238:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3239:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getPowerExpressionAccess().getPowerExpressionOperandAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3244:2: ( (lv_operator_2_0= rulePowerOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3245:1: (lv_operator_2_0= rulePowerOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3245:1: (lv_operator_2_0= rulePowerOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3246:3: lv_operator_2_0= rulePowerOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getPowerExpressionAccess().getOperatorPowerOperatorEnumRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePowerOperator_in_rulePowerExpression7004);
                    lv_operator_2_0=rulePowerOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPowerExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"operator",
                            		lv_operator_2_0, 
                            		"PowerOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3262:2: ( (lv_exponent_3_0= ruleUnaryExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3263:1: (lv_exponent_3_0= ruleUnaryExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3263:1: (lv_exponent_3_0= ruleUnaryExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3264:3: lv_exponent_3_0= ruleUnaryExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getPowerExpressionAccess().getExponentUnaryExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_rulePowerExpression7025);
                    lv_exponent_3_0=ruleUnaryExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPowerExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"exponent",
                            		lv_exponent_3_0, 
                            		"UnaryExpression");
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
    // $ANTLR end "rulePowerExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3288:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3289:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3290:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression7063);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression7073); 

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
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3297:1: ruleUnaryExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PostfixExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3300:28: ( (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3301:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3301:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( ((LA60_0>=RULE_ID && LA60_0<=RULE_STRING)||LA60_0==13||LA60_0==25||LA60_0==33||(LA60_0>=55 && LA60_0<=57)||(LA60_0>=76 && LA60_0<=77)) ) {
                alt60=1;
            }
            else if ( (LA60_0==61||LA60_0==74) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3302:5: this_PostfixExpression_0= rulePostfixExpression
                    {
                     
                            newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression7120);
                    this_PostfixExpression_0=rulePostfixExpression();

                    state._fsp--;

                     
                            current = this_PostfixExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3311:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3311:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3311:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3311:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3312:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3317:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3318:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3318:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3319:3: lv_operator_2_0= ruleUnaryOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression7156);
                    lv_operator_2_0=ruleUnaryOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"operator",
                            		lv_operator_2_0, 
                            		"UnaryOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3335:2: ( (lv_operand_3_0= rulePostfixExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3336:1: (lv_operand_3_0= rulePostfixExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3336:1: (lv_operand_3_0= rulePostfixExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3337:3: lv_operand_3_0= rulePostfixExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperandPostfixExpressionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression7177);
                    lv_operand_3_0=rulePostfixExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"operand",
                            		lv_operand_3_0, 
                            		"PostfixExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


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
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePostfixExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3361:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3362:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3363:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
             newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression7214);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;

             current =iv_rulePostfixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression7224); 

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
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3370:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3373:28: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3374:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3374:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3375:5: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )?
            {
             
                    newCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0()); 
                
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression7271);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;

             
                    current = this_PrimaryExpression_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3383:1: ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==75) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3383:2: () ( (lv_operator_2_0= rulePostfixOperator ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3383:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3384:5: 
                    {

                            current = forceCreateModelElementAndSet(
                                grammarAccess.getPostfixExpressionAccess().getPostfixExpressionOperandAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3389:2: ( (lv_operator_2_0= rulePostfixOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3390:1: (lv_operator_2_0= rulePostfixOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3390:1: (lv_operator_2_0= rulePostfixOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3391:3: lv_operator_2_0= rulePostfixOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getOperatorPostfixOperatorEnumRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePostfixOperator_in_rulePostfixExpression7301);
                    lv_operator_2_0=rulePostfixOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"operator",
                            		lv_operator_2_0, 
                            		"PostfixOperator");
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
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3415:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3416:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3417:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7339);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression7349); 

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3424:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_UnitConstructionOperator_2 = null;

        EObject this_BeginExpression_3 = null;

        EObject this_EndExpression_4 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3427:28: ( (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3428:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3428:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression )
            int alt62=5;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 76:
            case 77:
                {
                alt62=1;
                }
                break;
            case RULE_ID:
            case 13:
            case 25:
            case 33:
                {
                alt62=2;
                }
                break;
            case 55:
                {
                alt62=3;
                }
                break;
            case 56:
                {
                alt62=4;
                }
                break;
            case 57:
                {
                alt62=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3429:5: this_Literal_0= ruleLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression7396);
                    this_Literal_0=ruleLiteral();

                    state._fsp--;

                     
                            current = this_Literal_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3439:5: this_FeatureCall_1= ruleFeatureCall
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePrimaryExpression7423);
                    this_FeatureCall_1=ruleFeatureCall();

                    state._fsp--;

                     
                            current = this_FeatureCall_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3449:5: this_UnitConstructionOperator_2= ruleUnitConstructionOperator
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnitConstructionOperatorParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression7450);
                    this_UnitConstructionOperator_2=ruleUnitConstructionOperator();

                    state._fsp--;

                     
                            current = this_UnitConstructionOperator_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3459:5: this_BeginExpression_3= ruleBeginExpression
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBeginExpressionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleBeginExpression_in_rulePrimaryExpression7477);
                    this_BeginExpression_3=ruleBeginExpression();

                    state._fsp--;

                     
                            current = this_BeginExpression_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3469:5: this_EndExpression_4= ruleEndExpression
                    {
                     
                            newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEndExpressionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleEndExpression_in_rulePrimaryExpression7504);
                    this_EndExpression_4=ruleEndExpression();

                    state._fsp--;

                     
                            current = this_EndExpression_4; 
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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleCallablePrimaryExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3485:1: entryRuleCallablePrimaryExpression returns [EObject current=null] : iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF ;
    public final EObject entryRuleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallablePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3486:2: (iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3487:2: iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF
            {
             newCompositeNode(grammarAccess.getCallablePrimaryExpressionRule()); 
            pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression7539);
            iv_ruleCallablePrimaryExpression=ruleCallablePrimaryExpression();

            state._fsp--;

             current =iv_ruleCallablePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallablePrimaryExpression7549); 

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
    // $ANTLR end "entryRuleCallablePrimaryExpression"


    // $ANTLR start "ruleCallablePrimaryExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3494:1: ruleCallablePrimaryExpression returns [EObject current=null] : (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) ;
    public final EObject ruleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ArrayConstructionOperator_0 = null;

        EObject this_ArrayConcatenationOperator_1 = null;

        EObject this_ParenthesizedExpression_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3497:28: ( (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3498:1: (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3498:1: (this_ArrayConstructionOperator_0= ruleArrayConstructionOperator | this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            int alt63=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt63=1;
                }
                break;
            case 33:
                {
                alt63=2;
                }
                break;
            case 25:
                {
                alt63=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3499:5: this_ArrayConstructionOperator_0= ruleArrayConstructionOperator
                    {
                     
                            newCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getArrayConstructionOperatorParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleArrayConstructionOperator_in_ruleCallablePrimaryExpression7596);
                    this_ArrayConstructionOperator_0=ruleArrayConstructionOperator();

                    state._fsp--;

                     
                            current = this_ArrayConstructionOperator_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3509:5: this_ArrayConcatenationOperator_1= ruleArrayConcatenationOperator
                    {
                     
                            newCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getArrayConcatenationOperatorParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArrayConcatenationOperator_in_ruleCallablePrimaryExpression7623);
                    this_ArrayConcatenationOperator_1=ruleArrayConcatenationOperator();

                    state._fsp--;

                     
                            current = this_ArrayConcatenationOperator_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3519:5: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                     
                            newCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression7650);
                    this_ParenthesizedExpression_2=ruleParenthesizedExpression();

                    state._fsp--;

                     
                            current = this_ParenthesizedExpression_2; 
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
    // $ANTLR end "ruleCallablePrimaryExpression"


    // $ANTLR start "entryRuleLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3535:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3536:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3537:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral7685);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral7695); 

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3544:1: ruleLiteral returns [EObject current=null] : (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumericLiteral_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3547:28: ( (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3548:1: (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3548:1: (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt64=3;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
                {
                alt64=1;
                }
                break;
            case 76:
            case 77:
                {
                alt64=2;
                }
                break;
            case RULE_STRING:
                {
                alt64=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3549:5: this_NumericLiteral_0= ruleNumericLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getNumericLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNumericLiteral_in_ruleLiteral7742);
                    this_NumericLiteral_0=ruleNumericLiteral();

                    state._fsp--;

                     
                            current = this_NumericLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3559:5: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral7769);
                    this_BooleanLiteral_1=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3569:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral7796);
                    this_StringLiteral_2=ruleStringLiteral();

                    state._fsp--;

                     
                            current = this_StringLiteral_2; 
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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleNumericLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3585:1: entryRuleNumericLiteral returns [EObject current=null] : iv_ruleNumericLiteral= ruleNumericLiteral EOF ;
    public final EObject entryRuleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3586:2: (iv_ruleNumericLiteral= ruleNumericLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3587:2: iv_ruleNumericLiteral= ruleNumericLiteral EOF
            {
             newCompositeNode(grammarAccess.getNumericLiteralRule()); 
            pushFollow(FOLLOW_ruleNumericLiteral_in_entryRuleNumericLiteral7831);
            iv_ruleNumericLiteral=ruleNumericLiteral();

            state._fsp--;

             current =iv_ruleNumericLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericLiteral7841); 

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
    // $ANTLR end "entryRuleNumericLiteral"


    // $ANTLR start "ruleNumericLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3594:1: ruleNumericLiteral returns [EObject current=null] : (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) ;
    public final EObject ruleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3597:28: ( (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3598:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3598:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_REAL) ) {
                alt65=1;
            }
            else if ( (LA65_0==RULE_INTEGER) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3599:5: this_RealLiteral_0= ruleRealLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumericLiteralAccess().getRealLiteralParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumericLiteral7888);
                    this_RealLiteral_0=ruleRealLiteral();

                    state._fsp--;

                     
                            current = this_RealLiteral_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3609:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getNumericLiteralAccess().getIntegerLiteralParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteral_in_ruleNumericLiteral7915);
                    this_IntegerLiteral_1=ruleIntegerLiteral();

                    state._fsp--;

                     
                            current = this_IntegerLiteral_1; 
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
    // $ANTLR end "ruleNumericLiteral"


    // $ANTLR start "entryRuleRealLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3625:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3626:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3627:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             newCompositeNode(grammarAccess.getRealLiteralRule()); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral7950);
            iv_ruleRealLiteral=ruleRealLiteral();

            state._fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral7960); 

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
    // $ANTLR end "entryRuleRealLiteral"


    // $ANTLR start "ruleRealLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3634:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_modifier_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_unit_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3637:28: ( ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3638:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3638:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3638:2: ( (lv_value_0_0= RULE_REAL ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3638:2: ( (lv_value_0_0= RULE_REAL ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3639:1: (lv_value_0_0= RULE_REAL )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3639:1: (lv_value_0_0= RULE_REAL )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3640:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleRealLiteral8002); 

            			newLeafNode(lv_value_0_0, grammarAccess.getRealLiteralAccess().getValueREALTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRealLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"REAL");
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3656:2: ( (lv_modifier_1_0= RULE_ID ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3657:1: (lv_modifier_1_0= RULE_ID )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3657:1: (lv_modifier_1_0= RULE_ID )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3658:3: lv_modifier_1_0= RULE_ID
                    {
                    lv_modifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealLiteral8024); 

                    			newLeafNode(lv_modifier_1_0, grammarAccess.getRealLiteralAccess().getModifierIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRealLiteralRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"modifier",
                            		lv_modifier_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3674:3: (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==25) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3674:5: otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleRealLiteral8043); 

                        	newLeafNode(otherlv_2, grammarAccess.getRealLiteralAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3678:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3679:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3679:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3680:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRealLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealLiteral8064);
                    lv_unit_3_0=ruleUnitExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRealLiteralRule());
                    	        }
                           		set(
                           			current, 
                           			"unit",
                            		lv_unit_3_0, 
                            		"UnitExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleRealLiteral8076); 

                        	newLeafNode(otherlv_4, grammarAccess.getRealLiteralAccess().getRightParenthesisKeyword_2_2());
                        

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
    // $ANTLR end "ruleRealLiteral"


    // $ANTLR start "entryRuleIntegerLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3708:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3709:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3710:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             newCompositeNode(grammarAccess.getIntegerLiteralRule()); 
            pushFollow(FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral8114);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();

            state._fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteral8124); 

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
    // $ANTLR end "entryRuleIntegerLiteral"


    // $ANTLR start "ruleIntegerLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3717:1: ruleIntegerLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_modifier_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_unit_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3720:28: ( ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3721:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3721:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3721:2: ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_modifier_1_0= RULE_ID ) )? (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3721:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3722:1: (lv_value_0_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3722:1: (lv_value_0_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3723:3: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral8166); 

            			newLeafNode(lv_value_0_0, grammarAccess.getIntegerLiteralAccess().getValueINTEGERTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"INTEGER");
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3739:2: ( (lv_modifier_1_0= RULE_ID ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3740:1: (lv_modifier_1_0= RULE_ID )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3740:1: (lv_modifier_1_0= RULE_ID )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3741:3: lv_modifier_1_0= RULE_ID
                    {
                    lv_modifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerLiteral8188); 

                    			newLeafNode(lv_modifier_1_0, grammarAccess.getIntegerLiteralAccess().getModifierIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntegerLiteralRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"modifier",
                            		lv_modifier_1_0, 
                            		"ID");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3757:3: (otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==25) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3757:5: otherlv_2= '(' ( (lv_unit_3_0= ruleUnitExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleIntegerLiteral8207); 

                        	newLeafNode(otherlv_2, grammarAccess.getIntegerLiteralAccess().getLeftParenthesisKeyword_2_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3761:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3762:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3762:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3763:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getIntegerLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral8228);
                    lv_unit_3_0=ruleUnitExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIntegerLiteralRule());
                    	        }
                           		set(
                           			current, 
                           			"unit",
                            		lv_unit_3_0, 
                            		"UnitExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleIntegerLiteral8240); 

                        	newLeafNode(otherlv_4, grammarAccess.getIntegerLiteralAccess().getRightParenthesisKeyword_2_2());
                        

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
    // $ANTLR end "ruleIntegerLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3791:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3792:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3793:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8278);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral8288); 

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
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3800:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleBooleanKind ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3803:28: ( ( (lv_value_0_0= ruleBooleanKind ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3804:1: ( (lv_value_0_0= ruleBooleanKind ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3804:1: ( (lv_value_0_0= ruleBooleanKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3805:1: (lv_value_0_0= ruleBooleanKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3805:1: (lv_value_0_0= ruleBooleanKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3806:3: lv_value_0_0= ruleBooleanKind
            {
             
            	        newCompositeNode(grammarAccess.getBooleanLiteralAccess().getValueBooleanKindEnumRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral8333);
            lv_value_0_0=ruleBooleanKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBooleanLiteralRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"BooleanKind");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3830:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3831:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3832:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral8368);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral8378); 

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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3839:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3842:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3843:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3843:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3844:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3844:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3845:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral8419); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringLiteralRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleSimpleName"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3869:1: entryRuleSimpleName returns [EObject current=null] : iv_ruleSimpleName= ruleSimpleName EOF ;
    public final EObject entryRuleSimpleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3870:2: (iv_ruleSimpleName= ruleSimpleName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3871:2: iv_ruleSimpleName= ruleSimpleName EOF
            {
             newCompositeNode(grammarAccess.getSimpleNameRule()); 
            pushFollow(FOLLOW_ruleSimpleName_in_entryRuleSimpleName8459);
            iv_ruleSimpleName=ruleSimpleName();

            state._fsp--;

             current =iv_ruleSimpleName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleName8469); 

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
    // $ANTLR end "entryRuleSimpleName"


    // $ANTLR start "ruleSimpleName"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3878:1: ruleSimpleName returns [EObject current=null] : ( () ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleName() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3881:28: ( ( () ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3882:1: ( () ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3882:1: ( () ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3882:2: () ( (lv_identifier_1_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3882:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3883:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSimpleNameAccess().getSimpleNameAction_0(),
                        current);
                

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3888:2: ( (lv_identifier_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3889:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3889:1: (lv_identifier_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3890:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleName8520); 

            			newLeafNode(lv_identifier_1_0, grammarAccess.getSimpleNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleNameRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"identifier",
                    		lv_identifier_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleSimpleName"


    // $ANTLR start "entryRuleFeatureCall"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3914:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3915:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3916:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
             newCompositeNode(grammarAccess.getFeatureCallRule()); 
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall8561);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;

             current =iv_ruleFeatureCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall8571); 

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
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3923:1: ruleFeatureCall returns [EObject current=null] : ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_CallablePrimaryExpression_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_target_4_0 = null;

        EObject lv_parts_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3926:28: ( ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3927:1: ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3927:1: ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==13||LA73_0==25||LA73_0==33) ) {
                alt73=1;
            }
            else if ( (LA73_0==RULE_ID) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3927:2: (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3927:2: (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3928:5: this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )?
                    {
                     
                            newCompositeNode(grammarAccess.getFeatureCallAccess().getCallablePrimaryExpressionParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall8619);
                    this_CallablePrimaryExpression_0=ruleCallablePrimaryExpression();

                    state._fsp--;

                     
                            current = this_CallablePrimaryExpression_0; 
                            afterParserOrEnumRuleCall();
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3936:1: ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==25||LA71_0==33||LA71_0==52) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3936:2: () ( (lv_parts_2_0= ruleFeatureCallPart ) )+
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3936:2: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3937:5: 
                            {

                                    current = forceCreateModelElementAndSet(
                                        grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_0_1_0(),
                                        current);
                                

                            }

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3942:2: ( (lv_parts_2_0= ruleFeatureCallPart ) )+
                            int cnt70=0;
                            loop70:
                            do {
                                int alt70=2;
                                int LA70_0 = input.LA(1);

                                if ( (LA70_0==25||LA70_0==33||LA70_0==52) ) {
                                    alt70=1;
                                }


                                switch (alt70) {
                            	case 1 :
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3943:1: (lv_parts_2_0= ruleFeatureCallPart )
                            	    {
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3943:1: (lv_parts_2_0= ruleFeatureCallPart )
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3944:3: lv_parts_2_0= ruleFeatureCallPart
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getFeatureCallAccess().getPartsFeatureCallPartParserRuleCall_0_1_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8649);
                            	    lv_parts_2_0=ruleFeatureCallPart();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"parts",
                            	            		lv_parts_2_0, 
                            	            		"FeatureCallPart");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt70 >= 1 ) break loop70;
                                        EarlyExitException eee =
                                            new EarlyExitException(70, input);
                                        throw eee;
                                }
                                cnt70++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3961:6: ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3961:6: ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3961:7: () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3961:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3962:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getFeatureCallAccess().getFeatureCallAction_1_0(),
                                current);
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3967:2: ( (lv_target_4_0= ruleSimpleName ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3968:1: (lv_target_4_0= ruleSimpleName )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3968:1: (lv_target_4_0= ruleSimpleName )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3969:3: lv_target_4_0= ruleSimpleName
                    {
                     
                    	        newCompositeNode(grammarAccess.getFeatureCallAccess().getTargetSimpleNameParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSimpleName_in_ruleFeatureCall8690);
                    lv_target_4_0=ruleSimpleName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_4_0, 
                            		"SimpleName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3985:2: ( (lv_parts_5_0= ruleFeatureCallPart ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==25||LA72_0==33||LA72_0==52) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3986:1: (lv_parts_5_0= ruleFeatureCallPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3986:1: (lv_parts_5_0= ruleFeatureCallPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3987:3: lv_parts_5_0= ruleFeatureCallPart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureCallAccess().getPartsFeatureCallPartParserRuleCall_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8711);
                    	    lv_parts_5_0=ruleFeatureCallPart();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureCallRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parts",
                    	            		lv_parts_5_0, 
                    	            		"FeatureCallPart");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop72;
                        }
                    } while (true);


                    }


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
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleFeatureCallPart"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4011:1: entryRuleFeatureCallPart returns [EObject current=null] : iv_ruleFeatureCallPart= ruleFeatureCallPart EOF ;
    public final EObject entryRuleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4012:2: (iv_ruleFeatureCallPart= ruleFeatureCallPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4013:2: iv_ruleFeatureCallPart= ruleFeatureCallPart EOF
            {
             newCompositeNode(grammarAccess.getFeatureCallPartRule()); 
            pushFollow(FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart8749);
            iv_ruleFeatureCallPart=ruleFeatureCallPart();

            state._fsp--;

             current =iv_ruleFeatureCallPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallPart8759); 

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
    // $ANTLR end "entryRuleFeatureCallPart"


    // $ANTLR start "ruleFeatureCallPart"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4020:1: ruleFeatureCallPart returns [EObject current=null] : (this_NameComponent_0= ruleNameComponent | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationArgumentList_2= ruleOperationArgumentList | this_IterationCall_3= ruleIterationCall ) ;
    public final EObject ruleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject this_NameComponent_0 = null;

        EObject this_ArrayElementAccess_1 = null;

        EObject this_OperationArgumentList_2 = null;

        EObject this_IterationCall_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4023:28: ( (this_NameComponent_0= ruleNameComponent | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationArgumentList_2= ruleOperationArgumentList | this_IterationCall_3= ruleIterationCall ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4024:1: (this_NameComponent_0= ruleNameComponent | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationArgumentList_2= ruleOperationArgumentList | this_IterationCall_3= ruleIterationCall )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4024:1: (this_NameComponent_0= ruleNameComponent | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationArgumentList_2= ruleOperationArgumentList | this_IterationCall_3= ruleIterationCall )
            int alt74=4;
            alt74 = dfa74.predict(input);
            switch (alt74) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4025:5: this_NameComponent_0= ruleNameComponent
                    {
                     
                            newCompositeNode(grammarAccess.getFeatureCallPartAccess().getNameComponentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNameComponent_in_ruleFeatureCallPart8806);
                    this_NameComponent_0=ruleNameComponent();

                    state._fsp--;

                     
                            current = this_NameComponent_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4035:5: this_ArrayElementAccess_1= ruleArrayElementAccess
                    {
                     
                            newCompositeNode(grammarAccess.getFeatureCallPartAccess().getArrayElementAccessParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArrayElementAccess_in_ruleFeatureCallPart8833);
                    this_ArrayElementAccess_1=ruleArrayElementAccess();

                    state._fsp--;

                     
                            current = this_ArrayElementAccess_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4045:5: this_OperationArgumentList_2= ruleOperationArgumentList
                    {
                     
                            newCompositeNode(grammarAccess.getFeatureCallPartAccess().getOperationArgumentListParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleOperationArgumentList_in_ruleFeatureCallPart8860);
                    this_OperationArgumentList_2=ruleOperationArgumentList();

                    state._fsp--;

                     
                            current = this_OperationArgumentList_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4055:5: this_IterationCall_3= ruleIterationCall
                    {
                     
                            newCompositeNode(grammarAccess.getFeatureCallPartAccess().getIterationCallParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleIterationCall_in_ruleFeatureCallPart8887);
                    this_IterationCall_3=ruleIterationCall();

                    state._fsp--;

                     
                            current = this_IterationCall_3; 
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
    // $ANTLR end "ruleFeatureCallPart"


    // $ANTLR start "entryRuleNameComponent"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4071:1: entryRuleNameComponent returns [EObject current=null] : iv_ruleNameComponent= ruleNameComponent EOF ;
    public final EObject entryRuleNameComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameComponent = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4072:2: (iv_ruleNameComponent= ruleNameComponent EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4073:2: iv_ruleNameComponent= ruleNameComponent EOF
            {
             newCompositeNode(grammarAccess.getNameComponentRule()); 
            pushFollow(FOLLOW_ruleNameComponent_in_entryRuleNameComponent8922);
            iv_ruleNameComponent=ruleNameComponent();

            state._fsp--;

             current =iv_ruleNameComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameComponent8932); 

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
    // $ANTLR end "entryRuleNameComponent"


    // $ANTLR start "ruleNameComponent"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4080:1: ruleNameComponent returns [EObject current=null] : (otherlv_0= '.' ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNameComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4083:28: ( (otherlv_0= '.' ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4084:1: (otherlv_0= '.' ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4084:1: (otherlv_0= '.' ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4084:3: otherlv_0= '.' ( (lv_identifier_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleNameComponent8969); 

                	newLeafNode(otherlv_0, grammarAccess.getNameComponentAccess().getFullStopKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4088:1: ( (lv_identifier_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4089:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4089:1: (lv_identifier_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4090:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameComponent8986); 

            			newLeafNode(lv_identifier_1_0, grammarAccess.getNameComponentAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNameComponentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"identifier",
                    		lv_identifier_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleNameComponent"


    // $ANTLR start "entryRuleArrayElementAccess"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4114:1: entryRuleArrayElementAccess returns [EObject current=null] : iv_ruleArrayElementAccess= ruleArrayElementAccess EOF ;
    public final EObject entryRuleArrayElementAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayElementAccess = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4115:2: (iv_ruleArrayElementAccess= ruleArrayElementAccess EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4116:2: iv_ruleArrayElementAccess= ruleArrayElementAccess EOF
            {
             newCompositeNode(grammarAccess.getArrayElementAccessRule()); 
            pushFollow(FOLLOW_ruleArrayElementAccess_in_entryRuleArrayElementAccess9027);
            iv_ruleArrayElementAccess=ruleArrayElementAccess();

            state._fsp--;

             current =iv_ruleArrayElementAccess; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayElementAccess9037); 

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
    // $ANTLR end "entryRuleArrayElementAccess"


    // $ANTLR start "ruleArrayElementAccess"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4123:1: ruleArrayElementAccess returns [EObject current=null] : (otherlv_0= '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) (otherlv_2= ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleArrayElementAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_subscripts_1_0 = null;

        EObject lv_subscripts_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4126:28: ( (otherlv_0= '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) (otherlv_2= ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* otherlv_4= ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4127:1: (otherlv_0= '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) (otherlv_2= ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* otherlv_4= ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4127:1: (otherlv_0= '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) (otherlv_2= ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* otherlv_4= ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4127:3: otherlv_0= '[' ( (lv_subscripts_1_0= ruleArraySubscript ) ) (otherlv_2= ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleArrayElementAccess9074); 

                	newLeafNode(otherlv_0, grammarAccess.getArrayElementAccessAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4131:1: ( (lv_subscripts_1_0= ruleArraySubscript ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4132:1: (lv_subscripts_1_0= ruleArraySubscript )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4132:1: (lv_subscripts_1_0= ruleArraySubscript )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4133:3: lv_subscripts_1_0= ruleArraySubscript
            {
             
            	        newCompositeNode(grammarAccess.getArrayElementAccessAccess().getSubscriptsArraySubscriptParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleArraySubscript_in_ruleArrayElementAccess9095);
            lv_subscripts_1_0=ruleArraySubscript();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrayElementAccessRule());
            	        }
                   		add(
                   			current, 
                   			"subscripts",
                    		lv_subscripts_1_0, 
                    		"ArraySubscript");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4149:2: (otherlv_2= ',' ( (lv_subscripts_3_0= ruleArraySubscript ) ) )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==14) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4149:4: otherlv_2= ',' ( (lv_subscripts_3_0= ruleArraySubscript ) )
            	    {
            	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleArrayElementAccess9108); 

            	        	newLeafNode(otherlv_2, grammarAccess.getArrayElementAccessAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4153:1: ( (lv_subscripts_3_0= ruleArraySubscript ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4154:1: (lv_subscripts_3_0= ruleArraySubscript )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4154:1: (lv_subscripts_3_0= ruleArraySubscript )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4155:3: lv_subscripts_3_0= ruleArraySubscript
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getArrayElementAccessAccess().getSubscriptsArraySubscriptParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleArraySubscript_in_ruleArrayElementAccess9129);
            	    lv_subscripts_3_0=ruleArraySubscript();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getArrayElementAccessRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"subscripts",
            	            		lv_subscripts_3_0, 
            	            		"ArraySubscript");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

            otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleArrayElementAccess9143); 

                	newLeafNode(otherlv_4, grammarAccess.getArrayElementAccessAccess().getRightSquareBracketKeyword_3());
                

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
    // $ANTLR end "ruleArrayElementAccess"


    // $ANTLR start "entryRuleArraySubscript"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4183:1: entryRuleArraySubscript returns [EObject current=null] : iv_ruleArraySubscript= ruleArraySubscript EOF ;
    public final EObject entryRuleArraySubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArraySubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4184:2: (iv_ruleArraySubscript= ruleArraySubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4185:2: iv_ruleArraySubscript= ruleArraySubscript EOF
            {
             newCompositeNode(grammarAccess.getArraySubscriptRule()); 
            pushFollow(FOLLOW_ruleArraySubscript_in_entryRuleArraySubscript9179);
            iv_ruleArraySubscript=ruleArraySubscript();

            state._fsp--;

             current =iv_ruleArraySubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArraySubscript9189); 

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
    // $ANTLR end "entryRuleArraySubscript"


    // $ANTLR start "ruleArraySubscript"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4192:1: ruleArraySubscript returns [EObject current=null] : ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleArraySubscript() throws RecognitionException {
        EObject current = null;

        Token lv_slice_0_0=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4195:28: ( ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4196:1: ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4196:1: ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==20) ) {
                alt76=1;
            }
            else if ( ((LA76_0>=RULE_ID && LA76_0<=RULE_STRING)||LA76_0==13||LA76_0==25||LA76_0==28||LA76_0==33||LA76_0==40||LA76_0==42||LA76_0==45||(LA76_0>=55 && LA76_0<=57)||LA76_0==61||LA76_0==74||(LA76_0>=76 && LA76_0<=77)) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4196:2: ( (lv_slice_0_0= ':' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4196:2: ( (lv_slice_0_0= ':' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4197:1: (lv_slice_0_0= ':' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4197:1: (lv_slice_0_0= ':' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4198:3: lv_slice_0_0= ':'
                    {
                    lv_slice_0_0=(Token)match(input,20,FOLLOW_20_in_ruleArraySubscript9232); 

                            newLeafNode(lv_slice_0_0, grammarAccess.getArraySubscriptAccess().getSliceColonKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArraySubscriptRule());
                    	        }
                           		setWithLastConsumed(current, "slice", true, ":");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4212:6: ( (lv_expression_1_0= ruleExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4212:6: ( (lv_expression_1_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4213:1: (lv_expression_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4213:1: (lv_expression_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4214:3: lv_expression_1_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getArraySubscriptAccess().getExpressionExpressionParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleArraySubscript9272);
                    lv_expression_1_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArraySubscriptRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_1_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


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
    // $ANTLR end "ruleArraySubscript"


    // $ANTLR start "entryRuleOperationArgumentList"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4238:1: entryRuleOperationArgumentList returns [EObject current=null] : iv_ruleOperationArgumentList= ruleOperationArgumentList EOF ;
    public final EObject entryRuleOperationArgumentList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationArgumentList = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4239:2: (iv_ruleOperationArgumentList= ruleOperationArgumentList EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4240:2: iv_ruleOperationArgumentList= ruleOperationArgumentList EOF
            {
             newCompositeNode(grammarAccess.getOperationArgumentListRule()); 
            pushFollow(FOLLOW_ruleOperationArgumentList_in_entryRuleOperationArgumentList9308);
            iv_ruleOperationArgumentList=ruleOperationArgumentList();

            state._fsp--;

             current =iv_ruleOperationArgumentList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationArgumentList9318); 

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
    // $ANTLR end "entryRuleOperationArgumentList"


    // $ANTLR start "ruleOperationArgumentList"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4247:1: ruleOperationArgumentList returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleOperationArgumentList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4250:28: ( ( () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4251:1: ( () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4251:1: ( () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4251:2: () otherlv_1= '(' ( ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? otherlv_5= ')'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4251:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4252:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOperationArgumentListAccess().getOperationArgumentListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleOperationArgumentList9364); 

                	newLeafNode(otherlv_1, grammarAccess.getOperationArgumentListAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4261:1: ( ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=RULE_ID && LA78_0<=RULE_STRING)||LA78_0==13||LA78_0==25||LA78_0==28||LA78_0==33||LA78_0==40||LA78_0==42||LA78_0==45||(LA78_0>=55 && LA78_0<=57)||LA78_0==61||LA78_0==74||(LA78_0>=76 && LA78_0<=77)) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4261:2: ( (lv_arguments_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4261:2: ( (lv_arguments_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4262:1: (lv_arguments_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4262:1: (lv_arguments_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4263:3: lv_arguments_2_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationArgumentListAccess().getArgumentsExpressionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleOperationArgumentList9386);
                    lv_arguments_2_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationArgumentListRule());
                    	        }
                           		add(
                           			current, 
                           			"arguments",
                            		lv_arguments_2_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4279:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==14) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4279:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleOperationArgumentList9399); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getOperationArgumentListAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4283:1: ( (lv_arguments_4_0= ruleExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4284:1: (lv_arguments_4_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4284:1: (lv_arguments_4_0= ruleExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4285:3: lv_arguments_4_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getOperationArgumentListAccess().getArgumentsExpressionParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleOperationArgumentList9420);
                    	    lv_arguments_4_0=ruleExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getOperationArgumentListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"arguments",
                    	            		lv_arguments_4_0, 
                    	            		"Expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleOperationArgumentList9436); 

                	newLeafNode(otherlv_5, grammarAccess.getOperationArgumentListAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleOperationArgumentList"


    // $ANTLR start "entryRuleIterationCall"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4313:1: entryRuleIterationCall returns [EObject current=null] : iv_ruleIterationCall= ruleIterationCall EOF ;
    public final EObject entryRuleIterationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4314:2: (iv_ruleIterationCall= ruleIterationCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4315:2: iv_ruleIterationCall= ruleIterationCall EOF
            {
             newCompositeNode(grammarAccess.getIterationCallRule()); 
            pushFollow(FOLLOW_ruleIterationCall_in_entryRuleIterationCall9472);
            iv_ruleIterationCall=ruleIterationCall();

            state._fsp--;

             current =iv_ruleIterationCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIterationCall9482); 

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
    // $ANTLR end "entryRuleIterationCall"


    // $ANTLR start "ruleIterationCall"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4322:1: ruleIterationCall returns [EObject current=null] : (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_variables_3_0= ruleIterationVariable ) ) (otherlv_4= ',' ( (lv_variables_5_0= ruleIterationVariable ) ) )* (otherlv_6= ';' ( (lv_accumulator_7_0= ruleIterationAccumulator ) ) )? (otherlv_8= ';' ( (lv_breakCondition_9_0= ruleExpression ) ) )? otherlv_10= '|' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ')' ) ;
    public final EObject ruleIterationCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_variables_3_0 = null;

        EObject lv_variables_5_0 = null;

        EObject lv_accumulator_7_0 = null;

        EObject lv_breakCondition_9_0 = null;

        EObject lv_expression_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4325:28: ( (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_variables_3_0= ruleIterationVariable ) ) (otherlv_4= ',' ( (lv_variables_5_0= ruleIterationVariable ) ) )* (otherlv_6= ';' ( (lv_accumulator_7_0= ruleIterationAccumulator ) ) )? (otherlv_8= ';' ( (lv_breakCondition_9_0= ruleExpression ) ) )? otherlv_10= '|' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4326:1: (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_variables_3_0= ruleIterationVariable ) ) (otherlv_4= ',' ( (lv_variables_5_0= ruleIterationVariable ) ) )* (otherlv_6= ';' ( (lv_accumulator_7_0= ruleIterationAccumulator ) ) )? (otherlv_8= ';' ( (lv_breakCondition_9_0= ruleExpression ) ) )? otherlv_10= '|' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4326:1: (otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_variables_3_0= ruleIterationVariable ) ) (otherlv_4= ',' ( (lv_variables_5_0= ruleIterationVariable ) ) )* (otherlv_6= ';' ( (lv_accumulator_7_0= ruleIterationAccumulator ) ) )? (otherlv_8= ';' ( (lv_breakCondition_9_0= ruleExpression ) ) )? otherlv_10= '|' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4326:3: otherlv_0= '.' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_variables_3_0= ruleIterationVariable ) ) (otherlv_4= ',' ( (lv_variables_5_0= ruleIterationVariable ) ) )* (otherlv_6= ';' ( (lv_accumulator_7_0= ruleIterationAccumulator ) ) )? (otherlv_8= ';' ( (lv_breakCondition_9_0= ruleExpression ) ) )? otherlv_10= '|' ( (lv_expression_11_0= ruleExpression ) ) otherlv_12= ')'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleIterationCall9519); 

                	newLeafNode(otherlv_0, grammarAccess.getIterationCallAccess().getFullStopKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4330:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4331:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4331:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4332:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIterationCall9536); 

            			newLeafNode(lv_name_1_0, grammarAccess.getIterationCallAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIterationCallRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleIterationCall9553); 

                	newLeafNode(otherlv_2, grammarAccess.getIterationCallAccess().getLeftParenthesisKeyword_2());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4352:1: ( (lv_variables_3_0= ruleIterationVariable ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4353:1: (lv_variables_3_0= ruleIterationVariable )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4353:1: (lv_variables_3_0= ruleIterationVariable )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4354:3: lv_variables_3_0= ruleIterationVariable
            {
             
            	        newCompositeNode(grammarAccess.getIterationCallAccess().getVariablesIterationVariableParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleIterationVariable_in_ruleIterationCall9574);
            lv_variables_3_0=ruleIterationVariable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIterationCallRule());
            	        }
                   		add(
                   			current, 
                   			"variables",
                    		lv_variables_3_0, 
                    		"IterationVariable");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4370:2: (otherlv_4= ',' ( (lv_variables_5_0= ruleIterationVariable ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==14) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4370:4: otherlv_4= ',' ( (lv_variables_5_0= ruleIterationVariable ) )
            	    {
            	    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleIterationCall9587); 

            	        	newLeafNode(otherlv_4, grammarAccess.getIterationCallAccess().getCommaKeyword_4_0());
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4374:1: ( (lv_variables_5_0= ruleIterationVariable ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4375:1: (lv_variables_5_0= ruleIterationVariable )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4375:1: (lv_variables_5_0= ruleIterationVariable )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4376:3: lv_variables_5_0= ruleIterationVariable
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getIterationCallAccess().getVariablesIterationVariableParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleIterationVariable_in_ruleIterationCall9608);
            	    lv_variables_5_0=ruleIterationVariable();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getIterationCallRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"variables",
            	            		lv_variables_5_0, 
            	            		"IterationVariable");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4392:4: (otherlv_6= ';' ( (lv_accumulator_7_0= ruleIterationAccumulator ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==18) ) {
                int LA80_1 = input.LA(2);

                if ( (LA80_1==RULE_ID) ) {
                    int LA80_3 = input.LA(3);

                    if ( (LA80_3==17) ) {
                        alt80=1;
                    }
                }
            }
            switch (alt80) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4392:6: otherlv_6= ';' ( (lv_accumulator_7_0= ruleIterationAccumulator ) )
                    {
                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleIterationCall9623); 

                        	newLeafNode(otherlv_6, grammarAccess.getIterationCallAccess().getSemicolonKeyword_5_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4396:1: ( (lv_accumulator_7_0= ruleIterationAccumulator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4397:1: (lv_accumulator_7_0= ruleIterationAccumulator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4397:1: (lv_accumulator_7_0= ruleIterationAccumulator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4398:3: lv_accumulator_7_0= ruleIterationAccumulator
                    {
                     
                    	        newCompositeNode(grammarAccess.getIterationCallAccess().getAccumulatorIterationAccumulatorParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIterationAccumulator_in_ruleIterationCall9644);
                    lv_accumulator_7_0=ruleIterationAccumulator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIterationCallRule());
                    	        }
                           		set(
                           			current, 
                           			"accumulator",
                            		lv_accumulator_7_0, 
                            		"IterationAccumulator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4414:4: (otherlv_8= ';' ( (lv_breakCondition_9_0= ruleExpression ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==18) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4414:6: otherlv_8= ';' ( (lv_breakCondition_9_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleIterationCall9659); 

                        	newLeafNode(otherlv_8, grammarAccess.getIterationCallAccess().getSemicolonKeyword_6_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4418:1: ( (lv_breakCondition_9_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4419:1: (lv_breakCondition_9_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4419:1: (lv_breakCondition_9_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4420:3: lv_breakCondition_9_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getIterationCallAccess().getBreakConditionExpressionParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleIterationCall9680);
                    lv_breakCondition_9_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIterationCallRule());
                    	        }
                           		set(
                           			current, 
                           			"breakCondition",
                            		lv_breakCondition_9_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,53,FOLLOW_53_in_ruleIterationCall9694); 

                	newLeafNode(otherlv_10, grammarAccess.getIterationCallAccess().getVerticalLineKeyword_7());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4440:1: ( (lv_expression_11_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4441:1: (lv_expression_11_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4441:1: (lv_expression_11_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4442:3: lv_expression_11_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIterationCallAccess().getExpressionExpressionParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIterationCall9715);
            lv_expression_11_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIterationCallRule());
            	        }
                   		set(
                   			current, 
                   			"expression",
                    		lv_expression_11_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_12=(Token)match(input,26,FOLLOW_26_in_ruleIterationCall9727); 

                	newLeafNode(otherlv_12, grammarAccess.getIterationCallAccess().getRightParenthesisKeyword_9());
                

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
    // $ANTLR end "ruleIterationCall"


    // $ANTLR start "entryRuleIterationVariable"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4470:1: entryRuleIterationVariable returns [EObject current=null] : iv_ruleIterationVariable= ruleIterationVariable EOF ;
    public final EObject entryRuleIterationVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationVariable = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4471:2: (iv_ruleIterationVariable= ruleIterationVariable EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4472:2: iv_ruleIterationVariable= ruleIterationVariable EOF
            {
             newCompositeNode(grammarAccess.getIterationVariableRule()); 
            pushFollow(FOLLOW_ruleIterationVariable_in_entryRuleIterationVariable9763);
            iv_ruleIterationVariable=ruleIterationVariable();

            state._fsp--;

             current =iv_ruleIterationVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIterationVariable9773); 

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
    // $ANTLR end "entryRuleIterationVariable"


    // $ANTLR start "ruleIterationVariable"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4479:1: ruleIterationVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleIterationVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4482:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4483:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4483:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4484:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4484:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4485:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIterationVariable9814); 

            			newLeafNode(lv_name_0_0, grammarAccess.getIterationVariableAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIterationVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleIterationVariable"


    // $ANTLR start "entryRuleIterationAccumulator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4509:1: entryRuleIterationAccumulator returns [EObject current=null] : iv_ruleIterationAccumulator= ruleIterationAccumulator EOF ;
    public final EObject entryRuleIterationAccumulator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterationAccumulator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4510:2: (iv_ruleIterationAccumulator= ruleIterationAccumulator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4511:2: iv_ruleIterationAccumulator= ruleIterationAccumulator EOF
            {
             newCompositeNode(grammarAccess.getIterationAccumulatorRule()); 
            pushFollow(FOLLOW_ruleIterationAccumulator_in_entryRuleIterationAccumulator9854);
            iv_ruleIterationAccumulator=ruleIterationAccumulator();

            state._fsp--;

             current =iv_ruleIterationAccumulator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIterationAccumulator9864); 

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
    // $ANTLR end "entryRuleIterationAccumulator"


    // $ANTLR start "ruleIterationAccumulator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4518:1: ruleIterationAccumulator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_initializer_2_0= ruleExpression ) ) ) ;
    public final EObject ruleIterationAccumulator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_initializer_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4521:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_initializer_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4522:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_initializer_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4522:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_initializer_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4522:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_initializer_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4522:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4523:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4523:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4524:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIterationAccumulator9906); 

            			newLeafNode(lv_name_0_0, grammarAccess.getIterationAccumulatorAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIterationAccumulatorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleIterationAccumulator9923); 

                	newLeafNode(otherlv_1, grammarAccess.getIterationAccumulatorAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4544:1: ( (lv_initializer_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4545:1: (lv_initializer_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4545:1: (lv_initializer_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4546:3: lv_initializer_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getIterationAccumulatorAccess().getInitializerExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIterationAccumulator9944);
            lv_initializer_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIterationAccumulatorRule());
            	        }
                   		set(
                   			current, 
                   			"initializer",
                    		lv_initializer_2_0, 
                    		"Expression");
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
    // $ANTLR end "ruleIterationAccumulator"


    // $ANTLR start "entryRuleArrayConstructionOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4570:1: entryRuleArrayConstructionOperator returns [EObject current=null] : iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF ;
    public final EObject entryRuleArrayConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4571:2: (iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4572:2: iv_ruleArrayConstructionOperator= ruleArrayConstructionOperator EOF
            {
             newCompositeNode(grammarAccess.getArrayConstructionOperatorRule()); 
            pushFollow(FOLLOW_ruleArrayConstructionOperator_in_entryRuleArrayConstructionOperator9980);
            iv_ruleArrayConstructionOperator=ruleArrayConstructionOperator();

            state._fsp--;

             current =iv_ruleArrayConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConstructionOperator9990); 

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
    // $ANTLR end "entryRuleArrayConstructionOperator"


    // $ANTLR start "ruleArrayConstructionOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4579:1: ruleArrayConstructionOperator returns [EObject current=null] : (otherlv_0= '{' ( (lv_expressions_1_0= ruleExpression ) ) ( (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | (otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) otherlv_8= '}' ) ;
    public final EObject ruleArrayConstructionOperator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_3_0 = null;

        EObject lv_iterationClauses_5_0 = null;

        EObject lv_iterationClauses_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4582:28: ( (otherlv_0= '{' ( (lv_expressions_1_0= ruleExpression ) ) ( (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | (otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) otherlv_8= '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4583:1: (otherlv_0= '{' ( (lv_expressions_1_0= ruleExpression ) ) ( (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | (otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) otherlv_8= '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4583:1: (otherlv_0= '{' ( (lv_expressions_1_0= ruleExpression ) ) ( (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | (otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) otherlv_8= '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4583:3: otherlv_0= '{' ( (lv_expressions_1_0= ruleExpression ) ) ( (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | (otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleArrayConstructionOperator10027); 

                	newLeafNode(otherlv_0, grammarAccess.getArrayConstructionOperatorAccess().getLeftCurlyBracketKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4587:1: ( (lv_expressions_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4588:1: (lv_expressions_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4588:1: (lv_expressions_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4589:3: lv_expressions_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getExpressionsExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleArrayConstructionOperator10048);
            lv_expressions_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrayConstructionOperatorRule());
            	        }
                   		add(
                   			current, 
                   			"expressions",
                    		lv_expressions_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4605:2: ( (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* | (otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* ) )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=14 && LA84_0<=15)) ) {
                alt84=1;
            }
            else if ( (LA84_0==54) ) {
                alt84=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4605:3: (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4605:3: (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==14) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4605:5: otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleArrayConstructionOperator10062); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getArrayConstructionOperatorAccess().getCommaKeyword_2_0_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4609:1: ( (lv_expressions_3_0= ruleExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4610:1: (lv_expressions_3_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4610:1: (lv_expressions_3_0= ruleExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4611:3: lv_expressions_3_0= ruleExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getExpressionsExpressionParserRuleCall_2_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleArrayConstructionOperator10083);
                    	    lv_expressions_3_0=ruleExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getArrayConstructionOperatorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"expressions",
                    	            		lv_expressions_3_0, 
                    	            		"Expression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop82;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4628:6: (otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4628:6: (otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4628:8: otherlv_4= 'for' ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) ) (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )*
                    {
                    otherlv_4=(Token)match(input,54,FOLLOW_54_in_ruleArrayConstructionOperator10104); 

                        	newLeafNode(otherlv_4, grammarAccess.getArrayConstructionOperatorAccess().getForKeyword_2_1_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4632:1: ( (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4633:1: (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4633:1: (lv_iterationClauses_5_0= ruleArrayConstructionIterationClause )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4634:3: lv_iterationClauses_5_0= ruleArrayConstructionIterationClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getIterationClausesArrayConstructionIterationClauseParserRuleCall_2_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayConstructionIterationClause_in_ruleArrayConstructionOperator10125);
                    lv_iterationClauses_5_0=ruleArrayConstructionIterationClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrayConstructionOperatorRule());
                    	        }
                           		add(
                           			current, 
                           			"iterationClauses",
                            		lv_iterationClauses_5_0, 
                            		"ArrayConstructionIterationClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4650:2: (otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) ) )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==14) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4650:4: otherlv_6= ',' ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) )
                    	    {
                    	    otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleArrayConstructionOperator10138); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getArrayConstructionOperatorAccess().getCommaKeyword_2_1_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4654:1: ( (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4655:1: (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4655:1: (lv_iterationClauses_7_0= ruleArrayConstructionIterationClause )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4656:3: lv_iterationClauses_7_0= ruleArrayConstructionIterationClause
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getArrayConstructionOperatorAccess().getIterationClausesArrayConstructionIterationClauseParserRuleCall_2_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayConstructionIterationClause_in_ruleArrayConstructionOperator10159);
                    	    lv_iterationClauses_7_0=ruleArrayConstructionIterationClause();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getArrayConstructionOperatorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"iterationClauses",
                    	            		lv_iterationClauses_7_0, 
                    	            		"ArrayConstructionIterationClause");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleArrayConstructionOperator10175); 

                	newLeafNode(otherlv_8, grammarAccess.getArrayConstructionOperatorAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleArrayConstructionOperator"


    // $ANTLR start "entryRuleArrayConstructionIterationClause"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4684:1: entryRuleArrayConstructionIterationClause returns [EObject current=null] : iv_ruleArrayConstructionIterationClause= ruleArrayConstructionIterationClause EOF ;
    public final EObject entryRuleArrayConstructionIterationClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConstructionIterationClause = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4685:2: (iv_ruleArrayConstructionIterationClause= ruleArrayConstructionIterationClause EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4686:2: iv_ruleArrayConstructionIterationClause= ruleArrayConstructionIterationClause EOF
            {
             newCompositeNode(grammarAccess.getArrayConstructionIterationClauseRule()); 
            pushFollow(FOLLOW_ruleArrayConstructionIterationClause_in_entryRuleArrayConstructionIterationClause10211);
            iv_ruleArrayConstructionIterationClause=ruleArrayConstructionIterationClause();

            state._fsp--;

             current =iv_ruleArrayConstructionIterationClause; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConstructionIterationClause10221); 

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
    // $ANTLR end "entryRuleArrayConstructionIterationClause"


    // $ANTLR start "ruleArrayConstructionIterationClause"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4693:1: ruleArrayConstructionIterationClause returns [EObject current=null] : ( ( (lv_variableName_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_collectionExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleArrayConstructionIterationClause() throws RecognitionException {
        EObject current = null;

        Token lv_variableName_0_0=null;
        Token otherlv_1=null;
        EObject lv_collectionExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4696:28: ( ( ( (lv_variableName_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_collectionExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4697:1: ( ( (lv_variableName_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_collectionExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4697:1: ( ( (lv_variableName_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_collectionExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4697:2: ( (lv_variableName_0_0= RULE_ID ) ) otherlv_1= 'in' ( (lv_collectionExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4697:2: ( (lv_variableName_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4698:1: (lv_variableName_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4698:1: (lv_variableName_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4699:3: lv_variableName_0_0= RULE_ID
            {
            lv_variableName_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArrayConstructionIterationClause10263); 

            			newLeafNode(lv_variableName_0_0, grammarAccess.getArrayConstructionIterationClauseAccess().getVariableNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getArrayConstructionIterationClauseRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"variableName",
                    		lv_variableName_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleArrayConstructionIterationClause10280); 

                	newLeafNode(otherlv_1, grammarAccess.getArrayConstructionIterationClauseAccess().getInKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4719:1: ( (lv_collectionExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4720:1: (lv_collectionExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4720:1: (lv_collectionExpression_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4721:3: lv_collectionExpression_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getArrayConstructionIterationClauseAccess().getCollectionExpressionExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleArrayConstructionIterationClause10301);
            lv_collectionExpression_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrayConstructionIterationClauseRule());
            	        }
                   		set(
                   			current, 
                   			"collectionExpression",
                    		lv_collectionExpression_2_0, 
                    		"Expression");
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
    // $ANTLR end "ruleArrayConstructionIterationClause"


    // $ANTLR start "entryRuleArrayConcatenationOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4745:1: entryRuleArrayConcatenationOperator returns [EObject current=null] : iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF ;
    public final EObject entryRuleArrayConcatenationOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayConcatenationOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4746:2: (iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4747:2: iv_ruleArrayConcatenationOperator= ruleArrayConcatenationOperator EOF
            {
             newCompositeNode(grammarAccess.getArrayConcatenationOperatorRule()); 
            pushFollow(FOLLOW_ruleArrayConcatenationOperator_in_entryRuleArrayConcatenationOperator10337);
            iv_ruleArrayConcatenationOperator=ruleArrayConcatenationOperator();

            state._fsp--;

             current =iv_ruleArrayConcatenationOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayConcatenationOperator10347); 

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
    // $ANTLR end "entryRuleArrayConcatenationOperator"


    // $ANTLR start "ruleArrayConcatenationOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4754:1: ruleArrayConcatenationOperator returns [EObject current=null] : (otherlv_0= '[' ( (lv_rows_1_0= ruleExpressionList ) ) (otherlv_2= ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleArrayConcatenationOperator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_rows_1_0 = null;

        EObject lv_rows_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4757:28: ( (otherlv_0= '[' ( (lv_rows_1_0= ruleExpressionList ) ) (otherlv_2= ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* otherlv_4= ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4758:1: (otherlv_0= '[' ( (lv_rows_1_0= ruleExpressionList ) ) (otherlv_2= ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* otherlv_4= ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4758:1: (otherlv_0= '[' ( (lv_rows_1_0= ruleExpressionList ) ) (otherlv_2= ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* otherlv_4= ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4758:3: otherlv_0= '[' ( (lv_rows_1_0= ruleExpressionList ) ) (otherlv_2= ';' ( (lv_rows_3_0= ruleExpressionList ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleArrayConcatenationOperator10384); 

                	newLeafNode(otherlv_0, grammarAccess.getArrayConcatenationOperatorAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4762:1: ( (lv_rows_1_0= ruleExpressionList ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4763:1: (lv_rows_1_0= ruleExpressionList )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4763:1: (lv_rows_1_0= ruleExpressionList )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4764:3: lv_rows_1_0= ruleExpressionList
            {
             
            	        newCompositeNode(grammarAccess.getArrayConcatenationOperatorAccess().getRowsExpressionListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator10405);
            lv_rows_1_0=ruleExpressionList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrayConcatenationOperatorRule());
            	        }
                   		add(
                   			current, 
                   			"rows",
                    		lv_rows_1_0, 
                    		"ExpressionList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4780:2: (otherlv_2= ';' ( (lv_rows_3_0= ruleExpressionList ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==18) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4780:4: otherlv_2= ';' ( (lv_rows_3_0= ruleExpressionList ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleArrayConcatenationOperator10418); 

            	        	newLeafNode(otherlv_2, grammarAccess.getArrayConcatenationOperatorAccess().getSemicolonKeyword_2_0());
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4784:1: ( (lv_rows_3_0= ruleExpressionList ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4785:1: (lv_rows_3_0= ruleExpressionList )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4785:1: (lv_rows_3_0= ruleExpressionList )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4786:3: lv_rows_3_0= ruleExpressionList
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getArrayConcatenationOperatorAccess().getRowsExpressionListParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator10439);
            	    lv_rows_3_0=ruleExpressionList();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getArrayConcatenationOperatorRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rows",
            	            		lv_rows_3_0, 
            	            		"ExpressionList");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);

            otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleArrayConcatenationOperator10453); 

                	newLeafNode(otherlv_4, grammarAccess.getArrayConcatenationOperatorAccess().getRightSquareBracketKeyword_3());
                

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
    // $ANTLR end "ruleArrayConcatenationOperator"


    // $ANTLR start "entryRuleExpressionList"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4814:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4815:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4816:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
             newCompositeNode(grammarAccess.getExpressionListRule()); 
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList10489);
            iv_ruleExpressionList=ruleExpressionList();

            state._fsp--;

             current =iv_ruleExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList10499); 

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
    // $ANTLR end "entryRuleExpressionList"


    // $ANTLR start "ruleExpressionList"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4823:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4826:28: ( ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4827:1: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4827:1: ( ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4827:2: ( (lv_expressions_0_0= ruleExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4827:2: ( (lv_expressions_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4828:1: (lv_expressions_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4828:1: (lv_expressions_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4829:3: lv_expressions_0_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10545);
            lv_expressions_0_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionListRule());
            	        }
                   		add(
                   			current, 
                   			"expressions",
                    		lv_expressions_0_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4845:2: (otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==14) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4845:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleExpressionList10558); 

            	        	newLeafNode(otherlv_1, grammarAccess.getExpressionListAccess().getCommaKeyword_1_0());
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4849:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4850:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4850:1: (lv_expressions_2_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4851:3: lv_expressions_2_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10579);
            	    lv_expressions_2_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressions",
            	            		lv_expressions_2_0, 
            	            		"Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
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
    // $ANTLR end "ruleExpressionList"


    // $ANTLR start "entryRuleUnitConstructionOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4875:1: entryRuleUnitConstructionOperator returns [EObject current=null] : iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF ;
    public final EObject entryRuleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4876:2: (iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4877:2: iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF
            {
             newCompositeNode(grammarAccess.getUnitConstructionOperatorRule()); 
            pushFollow(FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10617);
            iv_ruleUnitConstructionOperator=ruleUnitConstructionOperator();

            state._fsp--;

             current =iv_ruleUnitConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitConstructionOperator10627); 

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
    // $ANTLR end "entryRuleUnitConstructionOperator"


    // $ANTLR start "ruleUnitConstructionOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4884:1: ruleUnitConstructionOperator returns [EObject current=null] : (otherlv_0= '$' otherlv_1= '(' ( (lv_unit_2_0= ruleUnitExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_unit_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4887:28: ( (otherlv_0= '$' otherlv_1= '(' ( (lv_unit_2_0= ruleUnitExpression ) ) otherlv_3= ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4888:1: (otherlv_0= '$' otherlv_1= '(' ( (lv_unit_2_0= ruleUnitExpression ) ) otherlv_3= ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4888:1: (otherlv_0= '$' otherlv_1= '(' ( (lv_unit_2_0= ruleUnitExpression ) ) otherlv_3= ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4888:3: otherlv_0= '$' otherlv_1= '(' ( (lv_unit_2_0= ruleUnitExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleUnitConstructionOperator10664); 

                	newLeafNode(otherlv_0, grammarAccess.getUnitConstructionOperatorAccess().getDollarSignKeyword_0());
                
            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleUnitConstructionOperator10676); 

                	newLeafNode(otherlv_1, grammarAccess.getUnitConstructionOperatorAccess().getLeftParenthesisKeyword_1());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4896:1: ( (lv_unit_2_0= ruleUnitExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4897:1: (lv_unit_2_0= ruleUnitExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4897:1: (lv_unit_2_0= ruleUnitExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4898:3: lv_unit_2_0= ruleUnitExpression
            {
             
            	        newCompositeNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitUnitExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10697);
            lv_unit_2_0=ruleUnitExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUnitConstructionOperatorRule());
            	        }
                   		set(
                   			current, 
                   			"unit",
                    		lv_unit_2_0, 
                    		"UnitExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleUnitConstructionOperator10709); 

                	newLeafNode(otherlv_3, grammarAccess.getUnitConstructionOperatorAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleUnitConstructionOperator"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4926:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4927:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4928:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10745);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression10755); 

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
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4935:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4938:28: ( (otherlv_0= '(' ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* otherlv_4= ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4939:1: (otherlv_0= '(' ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* otherlv_4= ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4939:1: (otherlv_0= '(' ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* otherlv_4= ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4939:3: otherlv_0= '(' ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleParenthesizedExpression10792); 

                	newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4943:1: ( (lv_expressions_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4944:1: (lv_expressions_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4944:1: (lv_expressions_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4945:3: lv_expressions_1_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionsExpressionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression10813);
            lv_expressions_1_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
            	        }
                   		add(
                   			current, 
                   			"expressions",
                    		lv_expressions_1_0, 
                    		"Expression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4961:2: (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==14) ) {
                    alt87=1;
                }


                switch (alt87) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4961:4: otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) )
            	    {
            	    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleParenthesizedExpression10826); 

            	        	newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getCommaKeyword_2_0());
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4965:1: ( (lv_expressions_3_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4966:1: (lv_expressions_3_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4966:1: (lv_expressions_3_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4967:3: lv_expressions_3_0= ruleExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionsExpressionParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression10847);
            	    lv_expressions_3_0=ruleExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressions",
            	            		lv_expressions_3_0, 
            	            		"Expression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            otherlv_4=(Token)match(input,26,FOLLOW_26_in_ruleParenthesizedExpression10861); 

                	newLeafNode(otherlv_4, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleBeginExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4995:1: entryRuleBeginExpression returns [EObject current=null] : iv_ruleBeginExpression= ruleBeginExpression EOF ;
    public final EObject entryRuleBeginExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeginExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4996:2: (iv_ruleBeginExpression= ruleBeginExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4997:2: iv_ruleBeginExpression= ruleBeginExpression EOF
            {
             newCompositeNode(grammarAccess.getBeginExpressionRule()); 
            pushFollow(FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10897);
            iv_ruleBeginExpression=ruleBeginExpression();

            state._fsp--;

             current =iv_ruleBeginExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBeginExpression10907); 

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
    // $ANTLR end "entryRuleBeginExpression"


    // $ANTLR start "ruleBeginExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5004:1: ruleBeginExpression returns [EObject current=null] : ( () otherlv_1= 'begin' ) ;
    public final EObject ruleBeginExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5007:28: ( ( () otherlv_1= 'begin' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5008:1: ( () otherlv_1= 'begin' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5008:1: ( () otherlv_1= 'begin' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5008:2: () otherlv_1= 'begin'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5008:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5009:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBeginExpressionAccess().getBeginExpressionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,56,FOLLOW_56_in_ruleBeginExpression10953); 

                	newLeafNode(otherlv_1, grammarAccess.getBeginExpressionAccess().getBeginKeyword_1());
                

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
    // $ANTLR end "ruleBeginExpression"


    // $ANTLR start "entryRuleEndExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5026:1: entryRuleEndExpression returns [EObject current=null] : iv_ruleEndExpression= ruleEndExpression EOF ;
    public final EObject entryRuleEndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5027:2: (iv_ruleEndExpression= ruleEndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5028:2: iv_ruleEndExpression= ruleEndExpression EOF
            {
             newCompositeNode(grammarAccess.getEndExpressionRule()); 
            pushFollow(FOLLOW_ruleEndExpression_in_entryRuleEndExpression10989);
            iv_ruleEndExpression=ruleEndExpression();

            state._fsp--;

             current =iv_ruleEndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndExpression10999); 

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
    // $ANTLR end "entryRuleEndExpression"


    // $ANTLR start "ruleEndExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5035:1: ruleEndExpression returns [EObject current=null] : ( () otherlv_1= 'end' ) ;
    public final EObject ruleEndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5038:28: ( ( () otherlv_1= 'end' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5039:1: ( () otherlv_1= 'end' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5039:1: ( () otherlv_1= 'end' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5039:2: () otherlv_1= 'end'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5039:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5040:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEndExpressionAccess().getEndExpressionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleEndExpression11045); 

                	newLeafNode(otherlv_1, grammarAccess.getEndExpressionAccess().getEndKeyword_1());
                

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
    // $ANTLR end "ruleEndExpression"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5057:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5058:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5059:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName11081);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName11091); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5066:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_identifiers_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_identifiers_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        Token lv_identifiers_0_0=null;
        Token otherlv_1=null;
        Token lv_identifiers_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5069:28: ( ( ( (lv_identifiers_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_identifiers_2_0= RULE_ID ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5070:1: ( ( (lv_identifiers_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_identifiers_2_0= RULE_ID ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5070:1: ( ( (lv_identifiers_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_identifiers_2_0= RULE_ID ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5070:2: ( (lv_identifiers_0_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_identifiers_2_0= RULE_ID ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5070:2: ( (lv_identifiers_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5071:1: (lv_identifiers_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5071:1: (lv_identifiers_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5072:3: lv_identifiers_0_0= RULE_ID
            {
            lv_identifiers_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName11133); 

            			newLeafNode(lv_identifiers_0_0, grammarAccess.getQualifiedNameAccess().getIdentifiersIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"identifiers",
                    		lv_identifiers_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5088:2: (otherlv_1= '.' ( (lv_identifiers_2_0= RULE_ID ) ) )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==52) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5088:4: otherlv_1= '.' ( (lv_identifiers_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,52,FOLLOW_52_in_ruleQualifiedName11151); 

            	        	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5092:1: ( (lv_identifiers_2_0= RULE_ID ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5093:1: (lv_identifiers_2_0= RULE_ID )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5093:1: (lv_identifiers_2_0= RULE_ID )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5094:3: lv_identifiers_2_0= RULE_ID
            	    {
            	    lv_identifiers_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName11168); 

            	    			newLeafNode(lv_identifiers_2_0, grammarAccess.getQualifiedNameAccess().getIdentifiersIDTerminalRuleCall_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getQualifiedNameRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"identifiers",
            	            		lv_identifiers_2_0, 
            	            		"ID");
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop88;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleUnitExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5118:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5119:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5120:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             newCompositeNode(grammarAccess.getUnitExpressionRule()); 
            pushFollow(FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression11211);
            iv_ruleUnitExpression=ruleUnitExpression();

            state._fsp--;

             current =iv_ruleUnitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpression11221); 

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
    // $ANTLR end "entryRuleUnitExpression"


    // $ANTLR start "ruleUnitExpression"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5127:1: ruleUnitExpression returns [EObject current=null] : ( () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) (otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )? ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_numerator_1_0 = null;

        EObject lv_denominator_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5130:28: ( ( () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) (otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5131:1: ( () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) (otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5131:1: ( () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) (otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5131:2: () ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) (otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5131:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5132:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnitExpressionAccess().getUnitExpressionAction_0(),
                        current);
                

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5137:2: ( ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) (otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )? )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_ID||LA90_0==RULE_INTEGER) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5137:3: ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) ) (otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5137:3: ( (lv_numerator_1_0= ruleUnitExpressionNumerator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5138:1: (lv_numerator_1_0= ruleUnitExpressionNumerator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5138:1: (lv_numerator_1_0= ruleUnitExpressionNumerator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5139:3: lv_numerator_1_0= ruleUnitExpressionNumerator
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnitExpressionAccess().getNumeratorUnitExpressionNumeratorParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression11277);
                    lv_numerator_1_0=ruleUnitExpressionNumerator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnitExpressionRule());
                    	        }
                           		set(
                           			current, 
                           			"numerator",
                            		lv_numerator_1_0, 
                            		"UnitExpressionNumerator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5155:2: (otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==58) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5155:4: otherlv_2= '/' ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) )
                            {
                            otherlv_2=(Token)match(input,58,FOLLOW_58_in_ruleUnitExpression11290); 

                                	newLeafNode(otherlv_2, grammarAccess.getUnitExpressionAccess().getSolidusKeyword_1_1_0());
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5159:1: ( (lv_denominator_3_0= ruleUnitExpressionDenominator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5160:1: (lv_denominator_3_0= ruleUnitExpressionDenominator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5160:1: (lv_denominator_3_0= ruleUnitExpressionDenominator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5161:3: lv_denominator_3_0= ruleUnitExpressionDenominator
                            {
                             
                            	        newCompositeNode(grammarAccess.getUnitExpressionAccess().getDenominatorUnitExpressionDenominatorParserRuleCall_1_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression11311);
                            lv_denominator_3_0=ruleUnitExpressionDenominator();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getUnitExpressionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"denominator",
                                    		lv_denominator_3_0, 
                                    		"UnitExpressionDenominator");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

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
    // $ANTLR end "ruleUnitExpression"


    // $ANTLR start "entryRuleUnitExpressionNumerator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5185:1: entryRuleUnitExpressionNumerator returns [EObject current=null] : iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF ;
    public final EObject entryRuleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionNumerator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5186:2: (iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5187:2: iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF
            {
             newCompositeNode(grammarAccess.getUnitExpressionNumeratorRule()); 
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator11351);
            iv_ruleUnitExpressionNumerator=ruleUnitExpressionNumerator();

            state._fsp--;

             current =iv_ruleUnitExpressionNumerator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionNumerator11361); 

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
    // $ANTLR end "entryRuleUnitExpressionNumerator"


    // $ANTLR start "ruleUnitExpressionNumerator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5194:1: ruleUnitExpressionNumerator returns [EObject current=null] : ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) (otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) ;
    public final EObject ruleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        Token lv_one_0_0=null;
        Token otherlv_2=null;
        EObject lv_factors_1_0 = null;

        EObject lv_factors_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5197:28: ( ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) (otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5198:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) (otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5198:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) (otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_INTEGER) ) {
                alt92=1;
            }
            else if ( (LA92_0==RULE_ID) ) {
                alt92=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5198:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5198:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5199:1: (lv_one_0_0= RULE_INTEGER )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5199:1: (lv_one_0_0= RULE_INTEGER )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5200:3: lv_one_0_0= RULE_INTEGER
                    {
                    lv_one_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator11403); 

                    			newLeafNode(lv_one_0_0, grammarAccess.getUnitExpressionNumeratorAccess().getOneINTEGERTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getUnitExpressionNumeratorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"one",
                            		lv_one_0_0, 
                            		"INTEGER");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5217:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) (otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5217:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) (otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5217:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) (otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5217:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5218:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5218:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5219:3: lv_factors_1_0= ruleUnitExpressionFactor
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11436);
                    lv_factors_1_0=ruleUnitExpressionFactor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnitExpressionNumeratorRule());
                    	        }
                           		add(
                           			current, 
                           			"factors",
                            		lv_factors_1_0, 
                            		"UnitExpressionFactor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5235:2: (otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    loop91:
                    do {
                        int alt91=2;
                        int LA91_0 = input.LA(1);

                        if ( (LA91_0==59) ) {
                            alt91=1;
                        }


                        switch (alt91) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5235:4: otherlv_2= '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    otherlv_2=(Token)match(input,59,FOLLOW_59_in_ruleUnitExpressionNumerator11449); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getUnitExpressionNumeratorAccess().getAsteriskKeyword_1_1_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5239:1: ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5240:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5240:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5241:3: lv_factors_3_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11470);
                    	    lv_factors_3_0=ruleUnitExpressionFactor();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getUnitExpressionNumeratorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"factors",
                    	            		lv_factors_3_0, 
                    	            		"UnitExpressionFactor");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop91;
                        }
                    } while (true);


                    }


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
    // $ANTLR end "ruleUnitExpressionNumerator"


    // $ANTLR start "entryRuleUnitExpressionDenominator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5265:1: entryRuleUnitExpressionDenominator returns [EObject current=null] : iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF ;
    public final EObject entryRuleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionDenominator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5266:2: (iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5267:2: iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF
            {
             newCompositeNode(grammarAccess.getUnitExpressionDenominatorRule()); 
            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11509);
            iv_ruleUnitExpressionDenominator=ruleUnitExpressionDenominator();

            state._fsp--;

             current =iv_ruleUnitExpressionDenominator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11519); 

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
    // $ANTLR end "entryRuleUnitExpressionDenominator"


    // $ANTLR start "ruleUnitExpressionDenominator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5274:1: ruleUnitExpressionDenominator returns [EObject current=null] : ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | (otherlv_1= '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) (otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* otherlv_5= ')' ) ) ;
    public final EObject ruleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_factors_0_0 = null;

        EObject lv_factors_2_0 = null;

        EObject lv_factors_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5277:28: ( ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | (otherlv_1= '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) (otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* otherlv_5= ')' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5278:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | (otherlv_1= '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) (otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* otherlv_5= ')' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5278:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | (otherlv_1= '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) (otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* otherlv_5= ')' ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_ID) ) {
                alt94=1;
            }
            else if ( (LA94_0==25) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5278:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5278:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5279:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5279:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5280:3: lv_factors_0_0= ruleUnitExpressionFactor
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11565);
                    lv_factors_0_0=ruleUnitExpressionFactor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnitExpressionDenominatorRule());
                    	        }
                           		add(
                           			current, 
                           			"factors",
                            		lv_factors_0_0, 
                            		"UnitExpressionFactor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5297:6: (otherlv_1= '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) (otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* otherlv_5= ')' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5297:6: (otherlv_1= '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) (otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* otherlv_5= ')' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5297:8: otherlv_1= '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) (otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleUnitExpressionDenominator11584); 

                        	newLeafNode(otherlv_1, grammarAccess.getUnitExpressionDenominatorAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5301:1: ( (lv_factors_2_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5302:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5302:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5303:3: lv_factors_2_0= ruleUnitExpressionFactor
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11605);
                    lv_factors_2_0=ruleUnitExpressionFactor();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnitExpressionDenominatorRule());
                    	        }
                           		add(
                           			current, 
                           			"factors",
                            		lv_factors_2_0, 
                            		"UnitExpressionFactor");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5319:2: (otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )*
                    loop93:
                    do {
                        int alt93=2;
                        int LA93_0 = input.LA(1);

                        if ( (LA93_0==59) ) {
                            alt93=1;
                        }


                        switch (alt93) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5319:4: otherlv_3= '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    otherlv_3=(Token)match(input,59,FOLLOW_59_in_ruleUnitExpressionDenominator11618); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getUnitExpressionDenominatorAccess().getAsteriskKeyword_1_2_0());
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5323:1: ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5324:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5324:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5325:3: lv_factors_4_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11639);
                    	    lv_factors_4_0=ruleUnitExpressionFactor();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getUnitExpressionDenominatorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"factors",
                    	            		lv_factors_4_0, 
                    	            		"UnitExpressionFactor");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop93;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,26,FOLLOW_26_in_ruleUnitExpressionDenominator11653); 

                        	newLeafNode(otherlv_5, grammarAccess.getUnitExpressionDenominatorAccess().getRightParenthesisKeyword_1_3());
                        

                    }


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
    // $ANTLR end "ruleUnitExpressionDenominator"


    // $ANTLR start "entryRuleUnitExpressionFactor"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5353:1: entryRuleUnitExpressionFactor returns [EObject current=null] : iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF ;
    public final EObject entryRuleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionFactor = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5354:2: (iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5355:2: iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF
            {
             newCompositeNode(grammarAccess.getUnitExpressionFactorRule()); 
            pushFollow(FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11690);
            iv_ruleUnitExpressionFactor=ruleUnitExpressionFactor();

            state._fsp--;

             current =iv_ruleUnitExpressionFactor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionFactor11700); 

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
    // $ANTLR end "entryRuleUnitExpressionFactor"


    // $ANTLR start "ruleUnitExpressionFactor"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5362:1: ruleUnitExpressionFactor returns [EObject current=null] : ( ( (lv_operand_0_0= RULE_ID ) ) (otherlv_1= '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) ;
    public final EObject ruleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        Token lv_operand_0_0=null;
        Token otherlv_1=null;
        EObject lv_exponent_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5365:28: ( ( ( (lv_operand_0_0= RULE_ID ) ) (otherlv_1= '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5366:1: ( ( (lv_operand_0_0= RULE_ID ) ) (otherlv_1= '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5366:1: ( ( (lv_operand_0_0= RULE_ID ) ) (otherlv_1= '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5366:2: ( (lv_operand_0_0= RULE_ID ) ) (otherlv_1= '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5366:2: ( (lv_operand_0_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5367:1: (lv_operand_0_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5367:1: (lv_operand_0_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5368:3: lv_operand_0_0= RULE_ID
            {
            lv_operand_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUnitExpressionFactor11742); 

            			newLeafNode(lv_operand_0_0, grammarAccess.getUnitExpressionFactorAccess().getOperandIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnitExpressionFactorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"operand",
                    		lv_operand_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5384:2: (otherlv_1= '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==60) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5384:4: otherlv_1= '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    {
                    otherlv_1=(Token)match(input,60,FOLLOW_60_in_ruleUnitExpressionFactor11760); 

                        	newLeafNode(otherlv_1, grammarAccess.getUnitExpressionFactorAccess().getCircumflexAccentKeyword_1_0());
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5388:1: ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5389:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5389:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5390:3: lv_exponent_2_0= ruleUnitExpressionExponent
                    {
                     
                    	        newCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getExponentUnitExpressionExponentParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11781);
                    lv_exponent_2_0=ruleUnitExpressionExponent();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getUnitExpressionFactorRule());
                    	        }
                           		set(
                           			current, 
                           			"exponent",
                            		lv_exponent_2_0, 
                            		"UnitExpressionExponent");
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
    // $ANTLR end "ruleUnitExpressionFactor"


    // $ANTLR start "entryRuleUnitExpressionExponent"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5414:1: entryRuleUnitExpressionExponent returns [EObject current=null] : iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF ;
    public final EObject entryRuleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionExponent = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5415:2: (iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5416:2: iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF
            {
             newCompositeNode(grammarAccess.getUnitExpressionExponentRule()); 
            pushFollow(FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11819);
            iv_ruleUnitExpressionExponent=ruleUnitExpressionExponent();

            state._fsp--;

             current =iv_ruleUnitExpressionExponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionExponent11829); 

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
    // $ANTLR end "entryRuleUnitExpressionExponent"


    // $ANTLR start "ruleUnitExpressionExponent"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5423:1: ruleUnitExpressionExponent returns [EObject current=null] : ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        Token lv_negative_0_0=null;
        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5426:28: ( ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5427:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5427:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5427:2: ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5427:2: ( (lv_negative_0_0= '-' ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==61) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5428:1: (lv_negative_0_0= '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5428:1: (lv_negative_0_0= '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5429:3: lv_negative_0_0= '-'
                    {
                    lv_negative_0_0=(Token)match(input,61,FOLLOW_61_in_ruleUnitExpressionExponent11872); 

                            newLeafNode(lv_negative_0_0, grammarAccess.getUnitExpressionExponentAccess().getNegativeHyphenMinusKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getUnitExpressionExponentRule());
                    	        }
                           		setWithLastConsumed(current, "negative", true, "-");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5442:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5443:1: (lv_value_1_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5443:1: (lv_value_1_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5444:3: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11903); 

            			newLeafNode(lv_value_1_0, grammarAccess.getUnitExpressionExponentAccess().getValueINTEGERTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnitExpressionExponentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"INTEGER");
            	    

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
    // $ANTLR end "ruleUnitExpressionExponent"


    // $ANTLR start "ruleAssertionStatusKind"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5468:1: ruleAssertionStatusKind returns [Enumerator current=null] : ( (enumLiteral_0= 'info' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'error' ) | (enumLiteral_3= 'fatal' ) ) ;
    public final Enumerator ruleAssertionStatusKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5470:28: ( ( (enumLiteral_0= 'info' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'error' ) | (enumLiteral_3= 'fatal' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5471:1: ( (enumLiteral_0= 'info' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'error' ) | (enumLiteral_3= 'fatal' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5471:1: ( (enumLiteral_0= 'info' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'error' ) | (enumLiteral_3= 'fatal' ) )
            int alt97=4;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt97=1;
                }
                break;
            case 63:
                {
                alt97=2;
                }
                break;
            case 64:
                {
                alt97=3;
                }
                break;
            case 65:
                {
                alt97=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5471:2: (enumLiteral_0= 'info' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5471:2: (enumLiteral_0= 'info' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5471:4: enumLiteral_0= 'info'
                    {
                    enumLiteral_0=(Token)match(input,62,FOLLOW_62_in_ruleAssertionStatusKind11958); 

                            current = grammarAccess.getAssertionStatusKindAccess().getInfoEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAssertionStatusKindAccess().getInfoEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5477:6: (enumLiteral_1= 'warning' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5477:6: (enumLiteral_1= 'warning' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5477:8: enumLiteral_1= 'warning'
                    {
                    enumLiteral_1=(Token)match(input,63,FOLLOW_63_in_ruleAssertionStatusKind11975); 

                            current = grammarAccess.getAssertionStatusKindAccess().getWarningEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAssertionStatusKindAccess().getWarningEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5483:6: (enumLiteral_2= 'error' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5483:6: (enumLiteral_2= 'error' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5483:8: enumLiteral_2= 'error'
                    {
                    enumLiteral_2=(Token)match(input,64,FOLLOW_64_in_ruleAssertionStatusKind11992); 

                            current = grammarAccess.getAssertionStatusKindAccess().getErrorEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getAssertionStatusKindAccess().getErrorEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5489:6: (enumLiteral_3= 'fatal' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5489:6: (enumLiteral_3= 'fatal' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5489:8: enumLiteral_3= 'fatal'
                    {
                    enumLiteral_3=(Token)match(input,65,FOLLOW_65_in_ruleAssertionStatusKind12009); 

                            current = grammarAccess.getAssertionStatusKindAccess().getFatalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getAssertionStatusKindAccess().getFatalEnumLiteralDeclaration_3()); 
                        

                    }


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
    // $ANTLR end "ruleAssertionStatusKind"


    // $ANTLR start "ruleEqualityOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5499:1: ruleEqualityOperator returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5501:28: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5502:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5502:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==66) ) {
                alt98=1;
            }
            else if ( (LA98_0==67) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5502:2: (enumLiteral_0= '==' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5502:2: (enumLiteral_0= '==' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5502:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_66_in_ruleEqualityOperator12054); 

                            current = grammarAccess.getEqualityOperatorAccess().getEqualToEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getEqualityOperatorAccess().getEqualToEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5508:6: (enumLiteral_1= '!=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5508:6: (enumLiteral_1= '!=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5508:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_67_in_ruleEqualityOperator12071); 

                            current = grammarAccess.getEqualityOperatorAccess().getNotEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getEqualityOperatorAccess().getNotEqualToEnumLiteralDeclaration_1()); 
                        

                    }


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
    // $ANTLR end "ruleEqualityOperator"


    // $ANTLR start "ruleRelationalOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5518:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5520:28: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5521:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5521:1: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) )
            int alt99=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt99=1;
                }
                break;
            case 68:
                {
                alt99=2;
                }
                break;
            case 24:
                {
                alt99=3;
                }
                break;
            case 69:
                {
                alt99=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5521:2: (enumLiteral_0= '<' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5521:2: (enumLiteral_0= '<' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5521:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,23,FOLLOW_23_in_ruleRelationalOperator12116); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5527:6: (enumLiteral_1= '<=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5527:6: (enumLiteral_1= '<=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5527:8: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_68_in_ruleRelationalOperator12133); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5533:6: (enumLiteral_2= '>' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5533:6: (enumLiteral_2= '>' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5533:8: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,24,FOLLOW_24_in_ruleRelationalOperator12150); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5539:6: (enumLiteral_3= '>=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5539:6: (enumLiteral_3= '>=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5539:8: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,69,FOLLOW_69_in_ruleRelationalOperator12167); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3()); 
                        

                    }


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
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5549:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5551:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5552:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5552:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==70) ) {
                alt100=1;
            }
            else if ( (LA100_0==61) ) {
                alt100=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5552:2: (enumLiteral_0= '+' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5552:2: (enumLiteral_0= '+' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5552:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_70_in_ruleAdditiveOperator12212); 

                            current = grammarAccess.getAdditiveOperatorAccess().getAdditionEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getAdditionEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5558:6: (enumLiteral_1= '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5558:6: (enumLiteral_1= '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5558:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_61_in_ruleAdditiveOperator12229); 

                            current = grammarAccess.getAdditiveOperatorAccess().getSubtractionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOperatorAccess().getSubtractionEnumLiteralDeclaration_1()); 
                        

                    }


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
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5568:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '.*' ) | (enumLiteral_3= './' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5570:28: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '.*' ) | (enumLiteral_3= './' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5571:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '.*' ) | (enumLiteral_3= './' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5571:1: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '.*' ) | (enumLiteral_3= './' ) )
            int alt101=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt101=1;
                }
                break;
            case 58:
                {
                alt101=2;
                }
                break;
            case 71:
                {
                alt101=3;
                }
                break;
            case 72:
                {
                alt101=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5571:2: (enumLiteral_0= '*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5571:2: (enumLiteral_0= '*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5571:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,59,FOLLOW_59_in_ruleMultiplicativeOperator12274); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getMultiplicationEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMultiplicationEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5577:6: (enumLiteral_1= '/' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5577:6: (enumLiteral_1= '/' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5577:8: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_58_in_ruleMultiplicativeOperator12291); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getDivisionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDivisionEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5583:6: (enumLiteral_2= '.*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5583:6: (enumLiteral_2= '.*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5583:8: enumLiteral_2= '.*'
                    {
                    enumLiteral_2=(Token)match(input,71,FOLLOW_71_in_ruleMultiplicativeOperator12308); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getElementWiseMultiplicationEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getMultiplicativeOperatorAccess().getElementWiseMultiplicationEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5589:6: (enumLiteral_3= './' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5589:6: (enumLiteral_3= './' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5589:8: enumLiteral_3= './'
                    {
                    enumLiteral_3=(Token)match(input,72,FOLLOW_72_in_ruleMultiplicativeOperator12325); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getElementWiseDivisionEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getMultiplicativeOperatorAccess().getElementWiseDivisionEnumLiteralDeclaration_3()); 
                        

                    }


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
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "rulePowerOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5599:1: rulePowerOperator returns [Enumerator current=null] : ( (enumLiteral_0= '^' ) | (enumLiteral_1= '.^' ) ) ;
    public final Enumerator rulePowerOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5601:28: ( ( (enumLiteral_0= '^' ) | (enumLiteral_1= '.^' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5602:1: ( (enumLiteral_0= '^' ) | (enumLiteral_1= '.^' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5602:1: ( (enumLiteral_0= '^' ) | (enumLiteral_1= '.^' ) )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==60) ) {
                alt102=1;
            }
            else if ( (LA102_0==73) ) {
                alt102=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5602:2: (enumLiteral_0= '^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5602:2: (enumLiteral_0= '^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5602:4: enumLiteral_0= '^'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_60_in_rulePowerOperator12370); 

                            current = grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5608:6: (enumLiteral_1= '.^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5608:6: (enumLiteral_1= '.^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5608:8: enumLiteral_1= '.^'
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_73_in_rulePowerOperator12387); 

                            current = grammarAccess.getPowerOperatorAccess().getElementWisePowerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getPowerOperatorAccess().getElementWisePowerEnumLiteralDeclaration_1()); 
                        

                    }


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
    // $ANTLR end "rulePowerOperator"


    // $ANTLR start "ruleUnaryOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5618:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '-' ) | (enumLiteral_1= '!' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5620:28: ( ( (enumLiteral_0= '-' ) | (enumLiteral_1= '!' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5621:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '!' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5621:1: ( (enumLiteral_0= '-' ) | (enumLiteral_1= '!' ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==61) ) {
                alt103=1;
            }
            else if ( (LA103_0==74) ) {
                alt103=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5621:2: (enumLiteral_0= '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5621:2: (enumLiteral_0= '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5621:4: enumLiteral_0= '-'
                    {
                    enumLiteral_0=(Token)match(input,61,FOLLOW_61_in_ruleUnaryOperator12432); 

                            current = grammarAccess.getUnaryOperatorAccess().getMinusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getMinusEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5627:6: (enumLiteral_1= '!' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5627:6: (enumLiteral_1= '!' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5627:8: enumLiteral_1= '!'
                    {
                    enumLiteral_1=(Token)match(input,74,FOLLOW_74_in_ruleUnaryOperator12449); 

                            current = grammarAccess.getUnaryOperatorAccess().getLogicalNotEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getLogicalNotEnumLiteralDeclaration_1()); 
                        

                    }


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
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "rulePostfixOperator"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5637:1: rulePostfixOperator returns [Enumerator current=null] : (enumLiteral_0= '\\'' ) ;
    public final Enumerator rulePostfixOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5639:28: ( (enumLiteral_0= '\\'' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5640:1: (enumLiteral_0= '\\'' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5640:1: (enumLiteral_0= '\\'' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5640:3: enumLiteral_0= '\\''
            {
            enumLiteral_0=(Token)match(input,75,FOLLOW_75_in_rulePostfixOperator12493); 

                    current = grammarAccess.getPostfixOperatorAccess().getTransposeEnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getPostfixOperatorAccess().getTransposeEnumLiteralDeclaration()); 
                

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
    // $ANTLR end "rulePostfixOperator"


    // $ANTLR start "ruleBooleanKind"
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5650:1: ruleBooleanKind returns [Enumerator current=null] : ( (enumLiteral_0= 'false' ) | (enumLiteral_1= 'true' ) ) ;
    public final Enumerator ruleBooleanKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5652:28: ( ( (enumLiteral_0= 'false' ) | (enumLiteral_1= 'true' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5653:1: ( (enumLiteral_0= 'false' ) | (enumLiteral_1= 'true' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5653:1: ( (enumLiteral_0= 'false' ) | (enumLiteral_1= 'true' ) )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==76) ) {
                alt104=1;
            }
            else if ( (LA104_0==77) ) {
                alt104=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5653:2: (enumLiteral_0= 'false' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5653:2: (enumLiteral_0= 'false' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5653:4: enumLiteral_0= 'false'
                    {
                    enumLiteral_0=(Token)match(input,76,FOLLOW_76_in_ruleBooleanKind12537); 

                            current = grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5659:6: (enumLiteral_1= 'true' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5659:6: (enumLiteral_1= 'true' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5659:8: enumLiteral_1= 'true'
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_77_in_ruleBooleanKind12554); 

                            current = grammarAccess.getBooleanKindAccess().getTrueEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getBooleanKindAccess().getTrueEnumLiteralDeclaration_1()); 
                        

                    }


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
    // $ANTLR end "ruleBooleanKind"

    // Delegated rules


    protected DFA74 dfa74 = new DFA74(this);
    static final String DFA74_eotS =
        "\13\uffff";
    static final String DFA74_eofS =
        "\4\uffff\1\6\6\uffff";
    static final String DFA74_minS =
        "\1\31\1\4\2\uffff\1\16\1\4\1\uffff\1\16\1\4\1\uffff\1\16";
    static final String DFA74_maxS =
        "\1\64\1\4\2\uffff\1\113\1\115\1\uffff\1\113\1\115\1\uffff\1\113";
    static final String DFA74_acceptS =
        "\2\uffff\1\2\1\3\2\uffff\1\1\2\uffff\1\4\1\uffff";
    static final String DFA74_specialS =
        "\13\uffff}>";
    static final String[] DFA74_transitionS = {
            "\1\3\7\uffff\1\2\22\uffff\1\1",
            "\1\4",
            "",
            "",
            "\2\6\1\uffff\2\6\1\uffff\1\6\2\uffff\2\6\1\5\1\6\6\uffff\2"+
            "\6\6\uffff\1\6\1\uffff\2\6\1\uffff\11\6\3\uffff\4\6\4\uffff"+
            "\10\6\1\uffff\1\6",
            "\1\7\3\6\5\uffff\1\6\13\uffff\2\6\1\uffff\1\6\4\uffff\1\6\6"+
            "\uffff\1\6\1\uffff\1\6\2\uffff\1\6\11\uffff\3\6\3\uffff\1\6"+
            "\14\uffff\1\6\1\uffff\2\6",
            "",
            "\1\10\3\uffff\1\11\1\uffff\1\6\2\uffff\4\6\6\uffff\1\6\16\uffff"+
            "\5\6\1\11\4\uffff\4\6\4\uffff\10\6\1\uffff\1\6",
            "\1\12\3\6\5\uffff\1\6\13\uffff\1\6\2\uffff\1\6\4\uffff\1\6"+
            "\6\uffff\1\6\1\uffff\1\6\2\uffff\1\6\11\uffff\3\6\3\uffff\1"+
            "\6\14\uffff\1\6\1\uffff\2\6",
            "",
            "\1\10\3\uffff\1\11\1\uffff\1\6\2\uffff\4\6\6\uffff\1\6\16\uffff"+
            "\5\6\1\11\4\uffff\4\6\4\uffff\10\6\1\uffff\1\6"
    };

    static final short[] DFA74_eot = DFA.unpackEncodedString(DFA74_eotS);
    static final short[] DFA74_eof = DFA.unpackEncodedString(DFA74_eofS);
    static final char[] DFA74_min = DFA.unpackEncodedStringToUnsignedChars(DFA74_minS);
    static final char[] DFA74_max = DFA.unpackEncodedStringToUnsignedChars(DFA74_maxS);
    static final short[] DFA74_accept = DFA.unpackEncodedString(DFA74_acceptS);
    static final short[] DFA74_special = DFA.unpackEncodedString(DFA74_specialS);
    static final short[][] DFA74_transition;

    static {
        int numStates = DFA74_transitionS.length;
        DFA74_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA74_transition[i] = DFA.unpackEncodedString(DFA74_transitionS[i]);
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = DFA74_eot;
            this.eof = DFA74_eof;
            this.min = DFA74_min;
            this.max = DFA74_max;
            this.accept = DFA74_accept;
            this.special = DFA74_special;
            this.transition = DFA74_transition;
        }
        public String getDescription() {
            return "4024:1: (this_NameComponent_0= ruleNameComponent | this_ArrayElementAccess_1= ruleArrayElementAccess | this_OperationArgumentList_2= ruleOperationArgumentList | this_IterationCall_3= ruleIterationCall )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleModule130 = new BitSet(new long[]{0x0000000000691002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeDefinition_in_ruleDefinition223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_ruleDefinition250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeDefinition_in_entryRuleDataTypeDefinition285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeDefinition295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_ruleDataTypeDefinition342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordDefinition_in_ruleDataTypeDefinition369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAliasDefinition_in_ruleDataTypeDefinition396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationDefinition441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleEnumerationDefinition478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationDefinition495 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEnumerationDefinition512 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition534 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleEnumerationDefinition547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition568 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleEnumerationDefinition584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEnumerationLiteralDeclaration671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAliasDefinition_in_entryRuleTypeAliasDefinition711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAliasDefinition721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleTypeAliasDefinition758 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeAliasDefinition775 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTypeAliasDefinition792 = new BitSet(new long[]{0x000000F900000000L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleTypeAliasDefinition813 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTypeAliasDefinition825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordDefinition_in_entryRuleRecordDefinition861 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordDefinition871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleRecordDefinition908 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRecordDefinition925 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRecordDefinition942 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition963 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_15_in_ruleRecordDefinition976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_entryRuleRecordFieldDeclaration1012 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordFieldDeclaration1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRecordFieldDeclaration1064 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleRecordFieldDeclaration1081 = new BitSet(new long[]{0x000000F900000010L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRecordFieldDeclaration1102 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRecordFieldDeclaration1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFunctionDefinition1203 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFunctionDefinition1229 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionDefinition1246 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_23_in_ruleFunctionDefinition1264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1285 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14_in_ruleFunctionDefinition1298 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1319 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_24_in_ruleFunctionDefinition1333 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleFunctionDefinition1347 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1369 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleFunctionDefinition1382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1403 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleFunctionDefinition1419 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleFunctionDefinition1431 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1452 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleFunctionDefinition1465 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1486 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleFunctionDefinition1500 = new BitSet(new long[]{0x23802502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleAssertion_in_ruleFunctionDefinition1522 = new BitSet(new long[]{0x23802502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleFunctionObjectDeclaration_in_ruleFunctionDefinition1549 = new BitSet(new long[]{0x23802502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleStateVariableDeclaration_in_ruleFunctionDefinition1576 = new BitSet(new long[]{0x23802502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleEquation_in_ruleFunctionDefinition1603 = new BitSet(new long[]{0x23802502F200A0F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_15_in_ruleFunctionDefinition1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1653 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterDeclaration1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParameterDeclaration1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertion_in_entryRuleAssertion1744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssertion1754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleAssertion1797 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleAssertion1823 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssertion1844 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleAssertion1856 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleAssertionStatusKind_in_ruleAssertion1877 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssertion1898 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleAssertion1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStateVariableDeclaration_in_entryRuleStateVariableDeclaration1946 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStateVariableDeclaration1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleStateVariableDeclaration1993 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStateVariableDeclaration2010 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleStateVariableDeclaration2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionObjectDeclaration_in_entryRuleFunctionObjectDeclaration2063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionObjectDeclaration2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleFunctionObjectDeclaration2110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFunctionObjectDeclaration2127 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFunctionObjectDeclaration2144 = new BitSet(new long[]{0x000000F900000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFunctionObjectDeclaration2165 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_23_in_ruleFunctionObjectDeclaration2178 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionObjectDeclaration2199 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_14_in_ruleFunctionObjectDeclaration2212 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleFunctionObjectDeclaration2233 = new BitSet(new long[]{0x0000000001004000L});
    public static final BitSet FOLLOW_24_in_ruleFunctionObjectDeclaration2247 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFunctionObjectDeclaration2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquation_in_entryRuleEquation2297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquation2307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEquation2353 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEquation2365 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEquation2386 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEquation2398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier2434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeSpecifier2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier2553 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericTypeSpecifier_in_rulePrimitiveTypeSpecifier2610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericTypeSpecifier_in_entryRuleNumericTypeSpecifier2699 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericTypeSpecifier2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_ruleNumericTypeSpecifier2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericTypeSpecifier2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericTypeSpecifier2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericTypeSpecifier2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier2872 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTypeSpecifier2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleRealTypeSpecifier2928 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_25_in_ruleRealTypeSpecifier2941 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier2962 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleRealTypeSpecifier2974 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleRealTypeSpecifier2989 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3010 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleRealTypeSpecifier3023 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3044 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleRealTypeSpecifier3058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier3096 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier3106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleIntegerTypeSpecifier3152 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_25_in_ruleIntegerTypeSpecifier3165 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier3186 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIntegerTypeSpecifier3198 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleIntegerTypeSpecifier3213 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3234 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleIntegerTypeSpecifier3247 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3268 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleIntegerTypeSpecifier3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier3320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeSpecifier3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComplexTypeSpecifier3376 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_25_in_ruleComplexTypeSpecifier3389 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier3410 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleComplexTypeSpecifier3422 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleComplexTypeSpecifier3437 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3458 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleComplexTypeSpecifier3471 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3492 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleComplexTypeSpecifier3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier3544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleGaussianTypeSpecifier3600 = new BitSet(new long[]{0x0000000202000002L});
    public static final BitSet FOLLOW_25_in_ruleGaussianTypeSpecifier3613 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier3634 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleGaussianTypeSpecifier3646 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleGaussianTypeSpecifier3661 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3682 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleGaussianTypeSpecifier3695 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3716 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleGaussianTypeSpecifier3730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier3768 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleBooleanTypeSpecifier3824 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleBooleanTypeSpecifier3837 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier3858 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleBooleanTypeSpecifier3871 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier3892 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleBooleanTypeSpecifier3906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier3944 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTypeSpecifier3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleStringTypeSpecifier4000 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleStringTypeSpecifier4013 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4034 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleStringTypeSpecifier4047 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4068 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleStringTypeSpecifier4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier4120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTypeSpecifier4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamedTypeSpecifier4176 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleNamedTypeSpecifier4189 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4210 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleNamedTypeSpecifier4223 = new BitSet(new long[]{0x23802506F20060F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4244 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleNamedTypeSpecifier4258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification4296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayDimensionSpecification4306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification4361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_ruleExpression4455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_ruleExpression4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_ruleExpression4509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_ruleExpression4536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_entryRuleLetExpression4571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpression4581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleLetExpression4618 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_ruleLetExpressionVariableDeclaration_in_ruleLetExpression4639 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_14_in_ruleLetExpression4652 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_ruleLetExpressionVariableDeclaration_in_ruleLetExpression4673 = new BitSet(new long[]{0x0000020000004000L});
    public static final BitSet FOLLOW_41_in_ruleLetExpression4687 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression4708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpressionVariableDeclaration_in_entryRuleLetExpressionVariableDeclaration4744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpressionVariableDeclaration4754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLetExpressionVariableDeclaration4797 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_25_in_ruleLetExpressionVariableDeclaration4821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLetExpressionVariableDeclaration4838 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleLetExpressionVariableDeclaration4856 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLetExpressionVariableDeclaration4873 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleLetExpressionVariableDeclaration4892 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleLetExpressionVariableDeclaration4906 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpressionVariableDeclaration4927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression4963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression4973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleIfExpression5016 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleIfExpression5042 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression5063 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleIfExpression5075 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression5096 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleIfExpression5108 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression5129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression5165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchExpression5175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleSwitchExpression5218 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleSwitchExpression5244 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression5265 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_ruleSwitchExpression5286 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_46_in_ruleSwitchExpression5299 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSwitchExpression5311 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression5332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase5368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchCase5378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSwitchCase5415 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleSwitchCase5436 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSwitchCase5448 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchCase5469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression5505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeExpression5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5562 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleRangeExpression5583 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5604 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleRangeExpression5617 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_entryRuleImpliesExpression5678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImpliesExpression5688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5735 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_ruleImpliesExpression5756 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5815 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression5825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5872 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleLogicalOrExpression5894 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5915 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression5955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression5965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression6012 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleLogicalAndExpression6034 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression6055 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression6095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression6105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression6152 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression6182 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression6203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression6251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6298 = new BitSet(new long[]{0x0008000001800002L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6329 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleRelationalExpression6379 = new BitSet(new long[]{0x000000F900000010L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression6449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6496 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6526 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6621 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6678 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpression6735 = new BitSet(new long[]{0x0C00000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6765 = new BitSet(new long[]{0x0C00000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6804 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6860 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpressionPart6881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_entryRulePowerExpression6917 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePowerExpression6927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rulePowerExpression6974 = new BitSet(new long[]{0x1000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_rulePowerOperator_in_rulePowerExpression7004 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rulePowerExpression7025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression7063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression7073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression7120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression7156 = new BitSet(new long[]{0x03800002020020F0L,0x0000000000003000L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression7177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression7214 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression7224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression7271 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_rulePostfixOperator_in_rulePostfixExpression7301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression7349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression7396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePrimaryExpression7423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression7450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_rulePrimaryExpression7477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_rulePrimaryExpression7504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression7539 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallablePrimaryExpression7549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionOperator_in_ruleCallablePrimaryExpression7596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConcatenationOperator_in_ruleCallablePrimaryExpression7623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression7650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral7685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral7695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericLiteral_in_ruleLiteral7742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral7769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral7796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericLiteral_in_entryRuleNumericLiteral7831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericLiteral7841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumericLiteral7888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_ruleNumericLiteral7915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral7950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral7960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleRealLiteral8002 = new BitSet(new long[]{0x0000000002000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealLiteral8024 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleRealLiteral8043 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealLiteral8064 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleRealLiteral8076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral8114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteral8124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral8166 = new BitSet(new long[]{0x0000000002000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerLiteral8188 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleIntegerLiteral8207 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral8228 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIntegerLiteral8240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral8288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral8333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral8368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral8378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral8419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleName_in_entryRuleSimpleName8459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleName8469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleName8520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall8561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall8571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall8619 = new BitSet(new long[]{0x0010000202000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8649 = new BitSet(new long[]{0x0010000202000002L});
    public static final BitSet FOLLOW_ruleSimpleName_in_ruleFeatureCall8690 = new BitSet(new long[]{0x0010000202000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8711 = new BitSet(new long[]{0x0010000202000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart8749 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallPart8759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameComponent_in_ruleFeatureCallPart8806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementAccess_in_ruleFeatureCallPart8833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationArgumentList_in_ruleFeatureCallPart8860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIterationCall_in_ruleFeatureCallPart8887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameComponent_in_entryRuleNameComponent8922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameComponent8932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleNameComponent8969 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameComponent8986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementAccess_in_entryRuleArrayElementAccess9027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayElementAccess9037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleArrayElementAccess9074 = new BitSet(new long[]{0x23802502F21020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArraySubscript_in_ruleArrayElementAccess9095 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_14_in_ruleArrayElementAccess9108 = new BitSet(new long[]{0x23802502F21020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleArraySubscript_in_ruleArrayElementAccess9129 = new BitSet(new long[]{0x0000000400004000L});
    public static final BitSet FOLLOW_34_in_ruleArrayElementAccess9143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArraySubscript_in_entryRuleArraySubscript9179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArraySubscript9189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleArraySubscript9232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArraySubscript9272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationArgumentList_in_entryRuleOperationArgumentList9308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationArgumentList9318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleOperationArgumentList9364 = new BitSet(new long[]{0x23802502F60020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationArgumentList9386 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleOperationArgumentList9399 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationArgumentList9420 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleOperationArgumentList9436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIterationCall_in_entryRuleIterationCall9472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIterationCall9482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleIterationCall9519 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIterationCall9536 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleIterationCall9553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIterationVariable_in_ruleIterationCall9574 = new BitSet(new long[]{0x0020000000044000L});
    public static final BitSet FOLLOW_14_in_ruleIterationCall9587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIterationVariable_in_ruleIterationCall9608 = new BitSet(new long[]{0x0020000000044000L});
    public static final BitSet FOLLOW_18_in_ruleIterationCall9623 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIterationAccumulator_in_ruleIterationCall9644 = new BitSet(new long[]{0x0020000000040000L});
    public static final BitSet FOLLOW_18_in_ruleIterationCall9659 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIterationCall9680 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleIterationCall9694 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIterationCall9715 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleIterationCall9727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIterationVariable_in_entryRuleIterationVariable9763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIterationVariable9773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIterationVariable9814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIterationAccumulator_in_entryRuleIterationAccumulator9854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIterationAccumulator9864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIterationAccumulator9906 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleIterationAccumulator9923 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIterationAccumulator9944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionOperator_in_entryRuleArrayConstructionOperator9980 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConstructionOperator9990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleArrayConstructionOperator10027 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayConstructionOperator10048 = new BitSet(new long[]{0x004000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleArrayConstructionOperator10062 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayConstructionOperator10083 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_54_in_ruleArrayConstructionOperator10104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArrayConstructionIterationClause_in_ruleArrayConstructionOperator10125 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleArrayConstructionOperator10138 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleArrayConstructionIterationClause_in_ruleArrayConstructionOperator10159 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleArrayConstructionOperator10175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConstructionIterationClause_in_entryRuleArrayConstructionIterationClause10211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConstructionIterationClause10221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArrayConstructionIterationClause10263 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleArrayConstructionIterationClause10280 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayConstructionIterationClause10301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayConcatenationOperator_in_entryRuleArrayConcatenationOperator10337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayConcatenationOperator10347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleArrayConcatenationOperator10384 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator10405 = new BitSet(new long[]{0x0000000400040000L});
    public static final BitSet FOLLOW_18_in_ruleArrayConcatenationOperator10418 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleArrayConcatenationOperator10439 = new BitSet(new long[]{0x0000000400040000L});
    public static final BitSet FOLLOW_34_in_ruleArrayConcatenationOperator10453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList10489 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList10499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10545 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleExpressionList10558 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10579 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10617 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitConstructionOperator10627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleUnitConstructionOperator10664 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleUnitConstructionOperator10676 = new BitSet(new long[]{0x0000000004000050L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10697 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleUnitConstructionOperator10709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression10755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleParenthesizedExpression10792 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression10813 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_14_in_ruleParenthesizedExpression10826 = new BitSet(new long[]{0x23802502F20020F0L,0x0000000000003400L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression10847 = new BitSet(new long[]{0x0000000004004000L});
    public static final BitSet FOLLOW_26_in_ruleParenthesizedExpression10861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBeginExpression10907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleBeginExpression10953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_entryRuleEndExpression10989 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndExpression10999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleEndExpression11045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName11081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName11091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName11133 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_ruleQualifiedName11151 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName11168 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression11211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpression11221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression11277 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_ruleUnitExpression11290 = new BitSet(new long[]{0x0000000002000050L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression11311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator11351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionNumerator11361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator11403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11436 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleUnitExpressionNumerator11449 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator11470 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleUnitExpressionDenominator11584 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11605 = new BitSet(new long[]{0x0800000004000000L});
    public static final BitSet FOLLOW_59_in_ruleUnitExpressionDenominator11618 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11639 = new BitSet(new long[]{0x0800000004000000L});
    public static final BitSet FOLLOW_26_in_ruleUnitExpressionDenominator11653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionFactor11700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUnitExpressionFactor11742 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleUnitExpressionFactor11760 = new BitSet(new long[]{0x2000000000000040L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11819 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionExponent11829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUnitExpressionExponent11872 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleAssertionStatusKind11958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAssertionStatusKind11975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleAssertionStatusKind11992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAssertionStatusKind12009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleEqualityOperator12054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleEqualityOperator12071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleRelationalOperator12116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleRelationalOperator12133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleRelationalOperator12150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleRelationalOperator12167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleAdditiveOperator12212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleAdditiveOperator12229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleMultiplicativeOperator12274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleMultiplicativeOperator12291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleMultiplicativeOperator12308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleMultiplicativeOperator12325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_rulePowerOperator12370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_rulePowerOperator12387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUnaryOperator12432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleUnaryOperator12449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_rulePostfixOperator12493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleBooleanKind12537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleBooleanKind12554 = new BitSet(new long[]{0x0000000000000002L});

}