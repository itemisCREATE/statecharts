package org.eclipselabs.mscript.language.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipselabs.mscript.language.services.MscriptGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMscriptParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REAL", "RULE_INTEGER", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'namespace'", "'{'", "'}'", "'enum'", "','", "'type'", "'='", "';'", "'record'", "':'", "'stateful'", "'func'", "'<'", "'>'", "'('", "')'", "'->'", "'assert'", "'var'", "'functor'", "'real'", "'['", "']'", "'int'", "'complex'", "'gauss'", "'bool'", "'string'", "'?'", "'unit'", "'let'", "'in'", "'if'", "'then'", "'else'", "'switch'", "'default'", "'case'", "'=>'", "'||'", "'&&'", "'is'", "'j'", "'.'", "'|'", "'begin'", "'end'", "'eval'", "'/'", "'*'", "'^'", "'-'", "'info'", "'warning'", "'error'", "'fatal'", "'=='", "'!='", "'<='", "'>='", "'+'", "'.*'", "'./'", "'.^'", "'!'", "'\\''", "'false'", "'true'"
    };
    public static final int RULE_ID=7;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_REAL=4;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_INTEGER=5;
    public static final int RULE_ML_COMMENT=8;

        public InternalMscriptParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g"; }



     	private MscriptGrammarAccess grammarAccess;
     	
        public InternalMscriptParser(TokenStream input, IAstFactory factory, MscriptGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Mscript";	
       	}
       	
       	@Override
       	protected MscriptGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleMscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:78:1: entryRuleMscript returns [EObject current=null] : iv_ruleMscript= ruleMscript EOF ;
    public final EObject entryRuleMscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:79:2: (iv_ruleMscript= ruleMscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:80:2: iv_ruleMscript= ruleMscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleMscript_in_entryRuleMscript75);
            iv_ruleMscript=ruleMscript();
            _fsp--;

             current =iv_ruleMscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMscript85); 

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
    // $ANTLR end entryRuleMscript


    // $ANTLR start ruleMscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:87:1: ruleMscript returns [EObject current=null] : ( (lv_namespaces_0_0= ruleNamespaceDefinition ) )* ;
    public final EObject ruleMscript() throws RecognitionException {
        EObject current = null;

        EObject lv_namespaces_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:92:6: ( ( (lv_namespaces_0_0= ruleNamespaceDefinition ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:93:1: ( (lv_namespaces_0_0= ruleNamespaceDefinition ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:93:1: ( (lv_namespaces_0_0= ruleNamespaceDefinition ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:94:1: (lv_namespaces_0_0= ruleNamespaceDefinition )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:94:1: (lv_namespaces_0_0= ruleNamespaceDefinition )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:95:3: lv_namespaces_0_0= ruleNamespaceDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMscriptAccess().getNamespacesNamespaceDefinitionParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamespaceDefinition_in_ruleMscript130);
            	    lv_namespaces_0_0=ruleNamespaceDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMscriptRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"namespaces",
            	    	        		lv_namespaces_0_0, 
            	    	        		"NamespaceDefinition", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMscript


    // $ANTLR start entryRuleNamespaceDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:125:1: entryRuleNamespaceDefinition returns [EObject current=null] : iv_ruleNamespaceDefinition= ruleNamespaceDefinition EOF ;
    public final EObject entryRuleNamespaceDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespaceDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:126:2: (iv_ruleNamespaceDefinition= ruleNamespaceDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:127:2: iv_ruleNamespaceDefinition= ruleNamespaceDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamespaceDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamespaceDefinition_in_entryRuleNamespaceDefinition166);
            iv_ruleNamespaceDefinition=ruleNamespaceDefinition();
            _fsp--;

             current =iv_ruleNamespaceDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespaceDefinition176); 

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
    // $ANTLR end entryRuleNamespaceDefinition


    // $ANTLR start ruleNamespaceDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:134:1: ruleNamespaceDefinition returns [EObject current=null] : ( 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_members_3_0= ruleNamespaceMember ) )* '}' ) ;
    public final EObject ruleNamespaceDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_name_1_0 = null;

        EObject lv_members_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:139:6: ( ( 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_members_3_0= ruleNamespaceMember ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:140:1: ( 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_members_3_0= ruleNamespaceMember ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:140:1: ( 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_members_3_0= ruleNamespaceMember ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:140:3: 'namespace' ( (lv_name_1_0= ruleQualifiedName ) ) '{' ( (lv_members_3_0= ruleNamespaceMember ) )* '}'
            {
            match(input,12,FOLLOW_12_in_ruleNamespaceDefinition211); 

                    createLeafNode(grammarAccess.getNamespaceDefinitionAccess().getNamespaceKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:144:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:145:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:145:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:146:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamespaceDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamespaceDefinition232);
            lv_name_1_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamespaceDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"QualifiedName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleNamespaceDefinition242); 

                    createLeafNode(grammarAccess.getNamespaceDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:172:1: ( (lv_members_3_0= ruleNamespaceMember ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||LA2_0==15||LA2_0==17||LA2_0==20||(LA2_0>=22 && LA2_0<=23)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:173:1: (lv_members_3_0= ruleNamespaceMember )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:173:1: (lv_members_3_0= ruleNamespaceMember )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:174:3: lv_members_3_0= ruleNamespaceMember
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNamespaceDefinitionAccess().getMembersNamespaceMemberParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamespaceMember_in_ruleNamespaceDefinition263);
            	    lv_members_3_0=ruleNamespaceMember();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNamespaceDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"members",
            	    	        		lv_members_3_0, 
            	    	        		"NamespaceMember", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleNamespaceDefinition274); 

                    createLeafNode(grammarAccess.getNamespaceDefinitionAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNamespaceDefinition


    // $ANTLR start entryRuleNamespaceMember
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:208:1: entryRuleNamespaceMember returns [EObject current=null] : iv_ruleNamespaceMember= ruleNamespaceMember EOF ;
    public final EObject entryRuleNamespaceMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespaceMember = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:209:2: (iv_ruleNamespaceMember= ruleNamespaceMember EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:210:2: iv_ruleNamespaceMember= ruleNamespaceMember EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamespaceMemberRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamespaceMember_in_entryRuleNamespaceMember310);
            iv_ruleNamespaceMember=ruleNamespaceMember();
            _fsp--;

             current =iv_ruleNamespaceMember; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamespaceMember320); 

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
    // $ANTLR end entryRuleNamespaceMember


    // $ANTLR start ruleNamespaceMember
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:217:1: ruleNamespaceMember returns [EObject current=null] : (this_NamespaceDefinition_0= ruleNamespaceDefinition | this_TypeDefinition_1= ruleTypeDefinition ) ;
    public final EObject ruleNamespaceMember() throws RecognitionException {
        EObject current = null;

        EObject this_NamespaceDefinition_0 = null;

        EObject this_TypeDefinition_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:222:6: ( (this_NamespaceDefinition_0= ruleNamespaceDefinition | this_TypeDefinition_1= ruleTypeDefinition ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:223:1: (this_NamespaceDefinition_0= ruleNamespaceDefinition | this_TypeDefinition_1= ruleTypeDefinition )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:223:1: (this_NamespaceDefinition_0= ruleNamespaceDefinition | this_TypeDefinition_1= ruleTypeDefinition )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==15||LA3_0==17||LA3_0==20||(LA3_0>=22 && LA3_0<=23)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("223:1: (this_NamespaceDefinition_0= ruleNamespaceDefinition | this_TypeDefinition_1= ruleTypeDefinition )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:224:5: this_NamespaceDefinition_0= ruleNamespaceDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamespaceMemberAccess().getNamespaceDefinitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamespaceDefinition_in_ruleNamespaceMember367);
                    this_NamespaceDefinition_0=ruleNamespaceDefinition();
                    _fsp--;

                     
                            current = this_NamespaceDefinition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:234:5: this_TypeDefinition_1= ruleTypeDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNamespaceMemberAccess().getTypeDefinitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeDefinition_in_ruleNamespaceMember394);
                    this_TypeDefinition_1=ruleTypeDefinition();
                    _fsp--;

                     
                            current = this_TypeDefinition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNamespaceMember


    // $ANTLR start entryRuleTypeDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:250:1: entryRuleTypeDefinition returns [EObject current=null] : iv_ruleTypeDefinition= ruleTypeDefinition EOF ;
    public final EObject entryRuleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:251:2: (iv_ruleTypeDefinition= ruleTypeDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:252:2: iv_ruleTypeDefinition= ruleTypeDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition429);
            iv_ruleTypeDefinition=ruleTypeDefinition();
            _fsp--;

             current =iv_ruleTypeDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDefinition439); 

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
    // $ANTLR end entryRuleTypeDefinition


    // $ANTLR start ruleTypeDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:259:1: ruleTypeDefinition returns [EObject current=null] : (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition ) ;
    public final EObject ruleTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_DataTypeDefinition_0 = null;

        EObject this_FunctionDefinition_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:264:6: ( (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:265:1: (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:265:1: (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15||LA4_0==17||LA4_0==20) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=22 && LA4_0<=23)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("265:1: (this_DataTypeDefinition_0= ruleDataTypeDefinition | this_FunctionDefinition_1= ruleFunctionDefinition )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:266:5: this_DataTypeDefinition_0= ruleDataTypeDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeDefinitionAccess().getDataTypeDefinitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDataTypeDefinition_in_ruleTypeDefinition486);
                    this_DataTypeDefinition_0=ruleDataTypeDefinition();
                    _fsp--;

                     
                            current = this_DataTypeDefinition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:276:5: this_FunctionDefinition_1= ruleFunctionDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeDefinitionAccess().getFunctionDefinitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFunctionDefinition_in_ruleTypeDefinition513);
                    this_FunctionDefinition_1=ruleFunctionDefinition();
                    _fsp--;

                     
                            current = this_FunctionDefinition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTypeDefinition


    // $ANTLR start entryRuleDataTypeDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:292:1: entryRuleDataTypeDefinition returns [EObject current=null] : iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF ;
    public final EObject entryRuleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:293:2: (iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:294:2: iv_ruleDataTypeDefinition= ruleDataTypeDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeDefinition_in_entryRuleDataTypeDefinition548);
            iv_ruleDataTypeDefinition=ruleDataTypeDefinition();
            _fsp--;

             current =iv_ruleDataTypeDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeDefinition558); 

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
    // $ANTLR end entryRuleDataTypeDefinition


    // $ANTLR start ruleDataTypeDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:301:1: ruleDataTypeDefinition returns [EObject current=null] : (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition ) ;
    public final EObject ruleDataTypeDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_EnumerationDefinition_0 = null;

        EObject this_RecordDefinition_1 = null;

        EObject this_TypeAliasDefinition_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:306:6: ( (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:307:1: (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:307:1: (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt5=1;
                }
                break;
            case 20:
                {
                alt5=2;
                }
                break;
            case 17:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("307:1: (this_EnumerationDefinition_0= ruleEnumerationDefinition | this_RecordDefinition_1= ruleRecordDefinition | this_TypeAliasDefinition_2= ruleTypeAliasDefinition )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:308:5: this_EnumerationDefinition_0= ruleEnumerationDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getEnumerationDefinitionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEnumerationDefinition_in_ruleDataTypeDefinition605);
                    this_EnumerationDefinition_0=ruleEnumerationDefinition();
                    _fsp--;

                     
                            current = this_EnumerationDefinition_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:318:5: this_RecordDefinition_1= ruleRecordDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getRecordDefinitionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRecordDefinition_in_ruleDataTypeDefinition632);
                    this_RecordDefinition_1=ruleRecordDefinition();
                    _fsp--;

                     
                            current = this_RecordDefinition_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:328:5: this_TypeAliasDefinition_2= ruleTypeAliasDefinition
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeDefinitionAccess().getTypeAliasDefinitionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeAliasDefinition_in_ruleDataTypeDefinition659);
                    this_TypeAliasDefinition_2=ruleTypeAliasDefinition();
                    _fsp--;

                     
                            current = this_TypeAliasDefinition_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDataTypeDefinition


    // $ANTLR start entryRuleEnumerationDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:344:1: entryRuleEnumerationDefinition returns [EObject current=null] : iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF ;
    public final EObject entryRuleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:345:2: (iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:346:2: iv_ruleEnumerationDefinition= ruleEnumerationDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition694);
            iv_ruleEnumerationDefinition=ruleEnumerationDefinition();
            _fsp--;

             current =iv_ruleEnumerationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationDefinition704); 

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
    // $ANTLR end entryRuleEnumerationDefinition


    // $ANTLR start ruleEnumerationDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:353:1: ruleEnumerationDefinition returns [EObject current=null] : ( 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' ) ;
    public final EObject ruleEnumerationDefinition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_literals_3_0 = null;

        EObject lv_literals_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:358:6: ( ( 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:359:1: ( 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:359:1: ( 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:359:3: 'enum' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )? '}'
            {
            match(input,15,FOLLOW_15_in_ruleEnumerationDefinition739); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getEnumKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:363:1: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:364:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:364:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:365:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleEnumerationDefinition760);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleEnumerationDefinition770); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:391:1: ( ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID||LA7_0==54) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:391:2: ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) ) ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:391:2: ( (lv_literals_3_0= ruleEnumerationLiteralDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:392:1: (lv_literals_3_0= ruleEnumerationLiteralDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:392:1: (lv_literals_3_0= ruleEnumerationLiteralDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:393:3: lv_literals_3_0= ruleEnumerationLiteralDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralsEnumerationLiteralDeclarationParserRuleCall_3_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition792);
                    lv_literals_3_0=ruleEnumerationLiteralDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"literals",
                    	        		lv_literals_3_0, 
                    	        		"EnumerationLiteralDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:415:2: ( ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:415:4: ',' ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleEnumerationDefinition803); 

                    	            createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getCommaKeyword_3_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:419:1: ( (lv_literals_5_0= ruleEnumerationLiteralDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:420:1: (lv_literals_5_0= ruleEnumerationLiteralDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:420:1: (lv_literals_5_0= ruleEnumerationLiteralDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:421:3: lv_literals_5_0= ruleEnumerationLiteralDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getEnumerationDefinitionAccess().getLiteralsEnumerationLiteralDeclarationParserRuleCall_3_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition824);
                    	    lv_literals_5_0=ruleEnumerationLiteralDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getEnumerationDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"literals",
                    	    	        		lv_literals_5_0, 
                    	    	        		"EnumerationLiteralDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

            match(input,14,FOLLOW_14_in_ruleEnumerationDefinition838); 

                    createLeafNode(grammarAccess.getEnumerationDefinitionAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEnumerationDefinition


    // $ANTLR start entryRuleEnumerationLiteralDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:455:1: entryRuleEnumerationLiteralDeclaration returns [EObject current=null] : iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF ;
    public final EObject entryRuleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationLiteralDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:456:2: (iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:457:2: iv_ruleEnumerationLiteralDeclaration= ruleEnumerationLiteralDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumerationLiteralDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration874);
            iv_ruleEnumerationLiteralDeclaration=ruleEnumerationLiteralDeclaration();
            _fsp--;

             current =iv_ruleEnumerationLiteralDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration884); 

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
    // $ANTLR end entryRuleEnumerationLiteralDeclaration


    // $ANTLR start ruleEnumerationLiteralDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:464:1: ruleEnumerationLiteralDeclaration returns [EObject current=null] : ( (lv_name_0_0= ruleKeywordID ) ) ;
    public final EObject ruleEnumerationLiteralDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:469:6: ( ( (lv_name_0_0= ruleKeywordID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:470:1: ( (lv_name_0_0= ruleKeywordID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:470:1: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:471:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:471:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:472:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumerationLiteralDeclarationAccess().getNameKeywordIDParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleEnumerationLiteralDeclaration929);
            lv_name_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumerationLiteralDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEnumerationLiteralDeclaration


    // $ANTLR start entryRuleTypeAliasDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:502:1: entryRuleTypeAliasDefinition returns [EObject current=null] : iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF ;
    public final EObject entryRuleTypeAliasDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeAliasDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:503:2: (iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:504:2: iv_ruleTypeAliasDefinition= ruleTypeAliasDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeAliasDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeAliasDefinition_in_entryRuleTypeAliasDefinition964);
            iv_ruleTypeAliasDefinition=ruleTypeAliasDefinition();
            _fsp--;

             current =iv_ruleTypeAliasDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeAliasDefinition974); 

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
    // $ANTLR end entryRuleTypeAliasDefinition


    // $ANTLR start ruleTypeAliasDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:511:1: ruleTypeAliasDefinition returns [EObject current=null] : ( 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' ) ;
    public final EObject ruleTypeAliasDefinition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:516:6: ( ( 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:517:1: ( 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:517:1: ( 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:517:3: 'type' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) ) ';'
            {
            match(input,17,FOLLOW_17_in_ruleTypeAliasDefinition1009); 

                    createLeafNode(grammarAccess.getTypeAliasDefinitionAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:521:1: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:522:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:522:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:523:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypeAliasDefinitionAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleTypeAliasDefinition1030);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeAliasDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleTypeAliasDefinition1040); 

                    createLeafNode(grammarAccess.getTypeAliasDefinitionAccess().getEqualsSignKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:549:1: ( (lv_type_3_0= rulePrimitiveTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:550:1: (lv_type_3_0= rulePrimitiveTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:550:1: (lv_type_3_0= rulePrimitiveTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:551:3: lv_type_3_0= rulePrimitiveTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTypeAliasDefinitionAccess().getTypePrimitiveTypeSpecifierParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleTypeAliasDefinition1061);
            lv_type_3_0=rulePrimitiveTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeAliasDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_3_0, 
            	        		"PrimitiveTypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleTypeAliasDefinition1071); 

                    createLeafNode(grammarAccess.getTypeAliasDefinitionAccess().getSemicolonKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTypeAliasDefinition


    // $ANTLR start entryRuleRecordDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:585:1: entryRuleRecordDefinition returns [EObject current=null] : iv_ruleRecordDefinition= ruleRecordDefinition EOF ;
    public final EObject entryRuleRecordDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:586:2: (iv_ruleRecordDefinition= ruleRecordDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:587:2: iv_ruleRecordDefinition= ruleRecordDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecordDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRecordDefinition_in_entryRuleRecordDefinition1107);
            iv_ruleRecordDefinition=ruleRecordDefinition();
            _fsp--;

             current =iv_ruleRecordDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordDefinition1117); 

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
    // $ANTLR end entryRuleRecordDefinition


    // $ANTLR start ruleRecordDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:594:1: ruleRecordDefinition returns [EObject current=null] : ( 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}' ) ;
    public final EObject ruleRecordDefinition() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fields_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:599:6: ( ( 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:600:1: ( 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:600:1: ( 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:600:3: 'record' ( (lv_name_1_0= ruleKeywordID ) ) '{' ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )* '}'
            {
            match(input,20,FOLLOW_20_in_ruleRecordDefinition1152); 

                    createLeafNode(grammarAccess.getRecordDefinitionAccess().getRecordKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:604:1: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:605:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:605:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:606:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRecordDefinitionAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleRecordDefinition1173);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleRecordDefinition1183); 

                    createLeafNode(grammarAccess.getRecordDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:632:1: ( (lv_fields_3_0= ruleRecordFieldDeclaration ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==54) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:633:1: (lv_fields_3_0= ruleRecordFieldDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:633:1: (lv_fields_3_0= ruleRecordFieldDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:634:3: lv_fields_3_0= ruleRecordFieldDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRecordDefinitionAccess().getFieldsRecordFieldDeclarationParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition1204);
            	    lv_fields_3_0=ruleRecordFieldDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRecordDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"fields",
            	    	        		lv_fields_3_0, 
            	    	        		"RecordFieldDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleRecordDefinition1215); 

                    createLeafNode(grammarAccess.getRecordDefinitionAccess().getRightCurlyBracketKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRecordDefinition


    // $ANTLR start entryRuleRecordFieldDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:668:1: entryRuleRecordFieldDeclaration returns [EObject current=null] : iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF ;
    public final EObject entryRuleRecordFieldDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordFieldDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:669:2: (iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:670:2: iv_ruleRecordFieldDeclaration= ruleRecordFieldDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRecordFieldDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleRecordFieldDeclaration_in_entryRuleRecordFieldDeclaration1251);
            iv_ruleRecordFieldDeclaration=ruleRecordFieldDeclaration();
            _fsp--;

             current =iv_ruleRecordFieldDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordFieldDeclaration1261); 

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
    // $ANTLR end entryRuleRecordFieldDeclaration


    // $ANTLR start ruleRecordFieldDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:677:1: ruleRecordFieldDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= ruleKeywordID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';' ) ;
    public final EObject ruleRecordFieldDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_type_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:682:6: ( ( ( (lv_name_0_0= ruleKeywordID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:683:1: ( ( (lv_name_0_0= ruleKeywordID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:683:1: ( ( (lv_name_0_0= ruleKeywordID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:683:2: ( (lv_name_0_0= ruleKeywordID ) ) ':' ( (lv_type_2_0= ruleDataTypeSpecifier ) ) ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:683:2: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:684:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:684:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:685:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRecordFieldDeclarationAccess().getNameKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleRecordFieldDeclaration1307);
            lv_name_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordFieldDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,21,FOLLOW_21_in_ruleRecordFieldDeclaration1317); 

                    createLeafNode(grammarAccess.getRecordFieldDeclarationAccess().getColonKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:711:1: ( (lv_type_2_0= ruleDataTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:712:1: (lv_type_2_0= ruleDataTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:712:1: (lv_type_2_0= ruleDataTypeSpecifier )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:713:3: lv_type_2_0= ruleDataTypeSpecifier
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRecordFieldDeclarationAccess().getTypeDataTypeSpecifierParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRecordFieldDeclaration1338);
            lv_type_2_0=ruleDataTypeSpecifier();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRecordFieldDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_2_0, 
            	        		"DataTypeSpecifier", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleRecordFieldDeclaration1348); 

                    createLeafNode(grammarAccess.getRecordFieldDeclarationAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRecordFieldDeclaration


    // $ANTLR start entryRuleFunctionDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:747:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:748:2: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:749:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctionDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1384);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();
            _fsp--;

             current =iv_ruleFunctionDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctionDefinition1394); 

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
    // $ANTLR end entryRuleFunctionDefinition


    // $ANTLR start ruleFunctionDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:756:1: ruleFunctionDefinition returns [EObject current=null] : ( ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) ( '<' ( (lv_templateParameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameters_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameters_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameters_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertions_18_0= ruleAssertionDeclaration ) ) | ( (lv_functors_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariables_20_0= ruleVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquationDefinition ) ) )* '}' ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_stateful_0_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_templateParameters_4_0 = null;

        EObject lv_templateParameters_6_0 = null;

        EObject lv_inputParameters_9_0 = null;

        EObject lv_inputParameters_11_0 = null;

        EObject lv_outputParameters_14_0 = null;

        EObject lv_outputParameters_16_0 = null;

        EObject lv_assertions_18_0 = null;

        EObject lv_functors_19_0 = null;

        EObject lv_stateVariables_20_0 = null;

        EObject lv_equations_21_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:761:6: ( ( ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) ( '<' ( (lv_templateParameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameters_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameters_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameters_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertions_18_0= ruleAssertionDeclaration ) ) | ( (lv_functors_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariables_20_0= ruleVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquationDefinition ) ) )* '}' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:762:1: ( ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) ( '<' ( (lv_templateParameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameters_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameters_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameters_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertions_18_0= ruleAssertionDeclaration ) ) | ( (lv_functors_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariables_20_0= ruleVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquationDefinition ) ) )* '}' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:762:1: ( ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) ( '<' ( (lv_templateParameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameters_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameters_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameters_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertions_18_0= ruleAssertionDeclaration ) ) | ( (lv_functors_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariables_20_0= ruleVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquationDefinition ) ) )* '}' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:762:2: ( (lv_stateful_0_0= 'stateful' ) )? 'func' ( (lv_name_2_0= ruleKeywordID ) ) ( '<' ( (lv_templateParameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) ) )* '>' )? '(' ( ( (lv_inputParameters_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) ) )* )? ')' '->' ( (lv_outputParameters_14_0= ruleParameterDeclaration ) ) ( ',' ( (lv_outputParameters_16_0= ruleParameterDeclaration ) ) )* '{' ( ( (lv_assertions_18_0= ruleAssertionDeclaration ) ) | ( (lv_functors_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariables_20_0= ruleVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquationDefinition ) ) )* '}'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:762:2: ( (lv_stateful_0_0= 'stateful' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:763:1: (lv_stateful_0_0= 'stateful' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:763:1: (lv_stateful_0_0= 'stateful' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:764:3: lv_stateful_0_0= 'stateful'
                    {
                    lv_stateful_0_0=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleFunctionDefinition1437); 

                            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getStatefulStatefulKeyword_0_0(), "stateful"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "stateful", true, "stateful", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            match(input,23,FOLLOW_23_in_ruleFunctionDefinition1461); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getFuncKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:787:1: ( (lv_name_2_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:788:1: (lv_name_2_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:788:1: (lv_name_2_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:789:3: lv_name_2_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getNameKeywordIDParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleFunctionDefinition1482);
            lv_name_2_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:811:2: ( '<' ( (lv_templateParameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) ) )* '>' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:811:4: '<' ( (lv_templateParameters_4_0= ruleParameterDeclaration ) ) ( ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) ) )* '>'
                    {
                    match(input,24,FOLLOW_24_in_ruleFunctionDefinition1493); 

                            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLessThanSignKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:815:1: ( (lv_templateParameters_4_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:816:1: (lv_templateParameters_4_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:816:1: (lv_templateParameters_4_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:817:3: lv_templateParameters_4_0= ruleParameterDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTemplateParametersParameterDeclarationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1514);
                    lv_templateParameters_4_0=ruleParameterDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"templateParameters",
                    	        		lv_templateParameters_4_0, 
                    	        		"ParameterDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:839:2: ( ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==16) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:839:4: ',' ( (lv_templateParameters_6_0= ruleParameterDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionDefinition1525); 

                    	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:843:1: ( (lv_templateParameters_6_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:844:1: (lv_templateParameters_6_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:844:1: (lv_templateParameters_6_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:845:3: lv_templateParameters_6_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getTemplateParametersParameterDeclarationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1546);
                    	    lv_templateParameters_6_0=ruleParameterDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"templateParameters",
                    	    	        		lv_templateParameters_6_0, 
                    	    	        		"ParameterDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match(input,25,FOLLOW_25_in_ruleFunctionDefinition1558); 

                            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getGreaterThanSignKeyword_3_3(), null); 
                        

                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_ruleFunctionDefinition1570); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:875:1: ( ( (lv_inputParameters_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID||LA13_0==54) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:875:2: ( (lv_inputParameters_9_0= ruleParameterDeclaration ) ) ( ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:875:2: ( (lv_inputParameters_9_0= ruleParameterDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:876:1: (lv_inputParameters_9_0= ruleParameterDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:876:1: (lv_inputParameters_9_0= ruleParameterDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:877:3: lv_inputParameters_9_0= ruleParameterDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getInputParametersParameterDeclarationParserRuleCall_5_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1592);
                    lv_inputParameters_9_0=ruleParameterDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"inputParameters",
                    	        		lv_inputParameters_9_0, 
                    	        		"ParameterDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:899:2: ( ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==16) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:899:4: ',' ( (lv_inputParameters_11_0= ruleParameterDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctionDefinition1603); 

                    	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_5_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:903:1: ( (lv_inputParameters_11_0= ruleParameterDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:904:1: (lv_inputParameters_11_0= ruleParameterDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:904:1: (lv_inputParameters_11_0= ruleParameterDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:905:3: lv_inputParameters_11_0= ruleParameterDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getInputParametersParameterDeclarationParserRuleCall_5_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1624);
                    	    lv_inputParameters_11_0=ruleParameterDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"inputParameters",
                    	    	        		lv_inputParameters_11_0, 
                    	    	        		"ParameterDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_ruleFunctionDefinition1638); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_6(), null); 
                
            match(input,28,FOLLOW_28_in_ruleFunctionDefinition1648); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getHyphenMinusGreaterThanSignKeyword_7(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:935:1: ( (lv_outputParameters_14_0= ruleParameterDeclaration ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:936:1: (lv_outputParameters_14_0= ruleParameterDeclaration )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:936:1: (lv_outputParameters_14_0= ruleParameterDeclaration )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:937:3: lv_outputParameters_14_0= ruleParameterDeclaration
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getOutputParametersParameterDeclarationParserRuleCall_8_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1669);
            lv_outputParameters_14_0=ruleParameterDeclaration();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"outputParameters",
            	        		lv_outputParameters_14_0, 
            	        		"ParameterDeclaration", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:959:2: ( ',' ( (lv_outputParameters_16_0= ruleParameterDeclaration ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==16) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:959:4: ',' ( (lv_outputParameters_16_0= ruleParameterDeclaration ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleFunctionDefinition1680); 

            	            createLeafNode(grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_9_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:963:1: ( (lv_outputParameters_16_0= ruleParameterDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:964:1: (lv_outputParameters_16_0= ruleParameterDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:964:1: (lv_outputParameters_16_0= ruleParameterDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:965:3: lv_outputParameters_16_0= ruleParameterDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getOutputParametersParameterDeclarationParserRuleCall_9_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1701);
            	    lv_outputParameters_16_0=ruleParameterDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"outputParameters",
            	    	        		lv_outputParameters_16_0, 
            	    	        		"ParameterDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleFunctionDefinition1713); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getLeftCurlyBracketKeyword_10(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:991:1: ( ( (lv_assertions_18_0= ruleAssertionDeclaration ) ) | ( (lv_functors_19_0= ruleFunctorDeclaration ) ) | ( (lv_stateVariables_20_0= ruleVariableDeclaration ) ) | ( (lv_equations_21_0= ruleEquationDefinition ) ) )*
            loop15:
            do {
                int alt15=5;
                switch ( input.LA(1) ) {
                case 29:
                    {
                    alt15=1;
                    }
                    break;
                case 31:
                    {
                    alt15=2;
                    }
                    break;
                case 30:
                    {
                    alt15=3;
                    }
                    break;
                case RULE_REAL:
                case RULE_INTEGER:
                case RULE_STRING:
                case RULE_ID:
                case 26:
                case 33:
                case 41:
                case 42:
                case 44:
                case 47:
                case 57:
                case 58:
                case 63:
                case 76:
                case 78:
                case 79:
                    {
                    alt15=4;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:991:2: ( (lv_assertions_18_0= ruleAssertionDeclaration ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:991:2: ( (lv_assertions_18_0= ruleAssertionDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:992:1: (lv_assertions_18_0= ruleAssertionDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:992:1: (lv_assertions_18_0= ruleAssertionDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:993:3: lv_assertions_18_0= ruleAssertionDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getAssertionsAssertionDeclarationParserRuleCall_11_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssertionDeclaration_in_ruleFunctionDefinition1735);
            	    lv_assertions_18_0=ruleAssertionDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"assertions",
            	    	        		lv_assertions_18_0, 
            	    	        		"AssertionDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1016:6: ( (lv_functors_19_0= ruleFunctorDeclaration ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1016:6: ( (lv_functors_19_0= ruleFunctorDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1017:1: (lv_functors_19_0= ruleFunctorDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1017:1: (lv_functors_19_0= ruleFunctorDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1018:3: lv_functors_19_0= ruleFunctorDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getFunctorsFunctorDeclarationParserRuleCall_11_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleFunctorDeclaration_in_ruleFunctionDefinition1762);
            	    lv_functors_19_0=ruleFunctorDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"functors",
            	    	        		lv_functors_19_0, 
            	    	        		"FunctorDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1041:6: ( (lv_stateVariables_20_0= ruleVariableDeclaration ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1041:6: ( (lv_stateVariables_20_0= ruleVariableDeclaration ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1042:1: (lv_stateVariables_20_0= ruleVariableDeclaration )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1042:1: (lv_stateVariables_20_0= ruleVariableDeclaration )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1043:3: lv_stateVariables_20_0= ruleVariableDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getStateVariablesVariableDeclarationParserRuleCall_11_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleFunctionDefinition1789);
            	    lv_stateVariables_20_0=ruleVariableDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"stateVariables",
            	    	        		lv_stateVariables_20_0, 
            	    	        		"VariableDeclaration", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1066:6: ( (lv_equations_21_0= ruleEquationDefinition ) )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1066:6: ( (lv_equations_21_0= ruleEquationDefinition ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1067:1: (lv_equations_21_0= ruleEquationDefinition )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1067:1: (lv_equations_21_0= ruleEquationDefinition )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1068:3: lv_equations_21_0= ruleEquationDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFunctionDefinitionAccess().getEquationsEquationDefinitionParserRuleCall_11_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEquationDefinition_in_ruleFunctionDefinition1816);
            	    lv_equations_21_0=ruleEquationDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFunctionDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"equations",
            	    	        		lv_equations_21_0, 
            	    	        		"EquationDefinition", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleFunctionDefinition1828); 

                    createLeafNode(grammarAccess.getFunctionDefinitionAccess().getRightCurlyBracketKeyword_12(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFunctionDefinition


    // $ANTLR start entryRuleParameterDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1102:1: entryRuleParameterDeclaration returns [EObject current=null] : iv_ruleParameterDeclaration= ruleParameterDeclaration EOF ;
    public final EObject entryRuleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1103:2: (iv_ruleParameterDeclaration= ruleParameterDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1104:2: iv_ruleParameterDeclaration= ruleParameterDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1864);
            iv_ruleParameterDeclaration=ruleParameterDeclaration();
            _fsp--;

             current =iv_ruleParameterDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterDeclaration1874); 

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
    // $ANTLR end entryRuleParameterDeclaration


    // $ANTLR start ruleParameterDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1111:1: ruleParameterDeclaration returns [EObject current=null] : ( (lv_name_0_0= ruleKeywordID ) ) ;
    public final EObject ruleParameterDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1116:6: ( ( (lv_name_0_0= ruleKeywordID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1117:1: ( (lv_name_0_0= ruleKeywordID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1117:1: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1118:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1118:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1119:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParameterDeclarationAccess().getNameKeywordIDParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleParameterDeclaration1919);
            lv_name_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParameterDeclaration


    // $ANTLR start entryRuleAssertionDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1149:1: entryRuleAssertionDeclaration returns [EObject current=null] : iv_ruleAssertionDeclaration= ruleAssertionDeclaration EOF ;
    public final EObject entryRuleAssertionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertionDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1150:2: (iv_ruleAssertionDeclaration= ruleAssertionDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1151:2: iv_ruleAssertionDeclaration= ruleAssertionDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAssertionDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleAssertionDeclaration_in_entryRuleAssertionDeclaration1954);
            iv_ruleAssertionDeclaration=ruleAssertionDeclaration();
            _fsp--;

             current =iv_ruleAssertionDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssertionDeclaration1964); 

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
    // $ANTLR end entryRuleAssertionDeclaration


    // $ANTLR start ruleAssertionDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1158:1: ruleAssertionDeclaration returns [EObject current=null] : ( 'assert' ( (lv_predicate_1_0= ruleExpression ) ) ':' ( (lv_statusKind_3_0= ruleAssertionStatusKind ) ) ( (lv_message_4_0= ruleExpression ) ) ';' ) ;
    public final EObject ruleAssertionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_predicate_1_0 = null;

        Enumerator lv_statusKind_3_0 = null;

        EObject lv_message_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1163:6: ( ( 'assert' ( (lv_predicate_1_0= ruleExpression ) ) ':' ( (lv_statusKind_3_0= ruleAssertionStatusKind ) ) ( (lv_message_4_0= ruleExpression ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1164:1: ( 'assert' ( (lv_predicate_1_0= ruleExpression ) ) ':' ( (lv_statusKind_3_0= ruleAssertionStatusKind ) ) ( (lv_message_4_0= ruleExpression ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1164:1: ( 'assert' ( (lv_predicate_1_0= ruleExpression ) ) ':' ( (lv_statusKind_3_0= ruleAssertionStatusKind ) ) ( (lv_message_4_0= ruleExpression ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1164:3: 'assert' ( (lv_predicate_1_0= ruleExpression ) ) ':' ( (lv_statusKind_3_0= ruleAssertionStatusKind ) ) ( (lv_message_4_0= ruleExpression ) ) ';'
            {
            match(input,29,FOLLOW_29_in_ruleAssertionDeclaration1999); 

                    createLeafNode(grammarAccess.getAssertionDeclarationAccess().getAssertKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1168:1: ( (lv_predicate_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1169:1: (lv_predicate_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1169:1: (lv_predicate_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1170:3: lv_predicate_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssertionDeclarationAccess().getPredicateExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssertionDeclaration2020);
            lv_predicate_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssertionDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"predicate",
            	        		lv_predicate_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,21,FOLLOW_21_in_ruleAssertionDeclaration2030); 

                    createLeafNode(grammarAccess.getAssertionDeclarationAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1196:1: ( (lv_statusKind_3_0= ruleAssertionStatusKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1197:1: (lv_statusKind_3_0= ruleAssertionStatusKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1197:1: (lv_statusKind_3_0= ruleAssertionStatusKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1198:3: lv_statusKind_3_0= ruleAssertionStatusKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssertionDeclarationAccess().getStatusKindAssertionStatusKindEnumRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAssertionStatusKind_in_ruleAssertionDeclaration2051);
            lv_statusKind_3_0=ruleAssertionStatusKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssertionDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"statusKind",
            	        		lv_statusKind_3_0, 
            	        		"AssertionStatusKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1220:2: ( (lv_message_4_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1221:1: (lv_message_4_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1221:1: (lv_message_4_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1222:3: lv_message_4_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAssertionDeclarationAccess().getMessageExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleAssertionDeclaration2072);
            lv_message_4_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAssertionDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"message",
            	        		lv_message_4_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleAssertionDeclaration2082); 

                    createLeafNode(grammarAccess.getAssertionDeclarationAccess().getSemicolonKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAssertionDeclaration


    // $ANTLR start entryRuleVariableDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1256:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1257:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1258:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getVariableDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2118);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();
            _fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration2128); 

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
    // $ANTLR end entryRuleVariableDeclaration


    // $ANTLR start ruleVariableDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1265:1: ruleVariableDeclaration returns [EObject current=null] : ( 'var' ( (lv_name_1_0= ruleKeywordID ) ) ';' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1270:6: ( ( 'var' ( (lv_name_1_0= ruleKeywordID ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1271:1: ( 'var' ( (lv_name_1_0= ruleKeywordID ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1271:1: ( 'var' ( (lv_name_1_0= ruleKeywordID ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1271:3: 'var' ( (lv_name_1_0= ruleKeywordID ) ) ';'
            {
            match(input,30,FOLLOW_30_in_ruleVariableDeclaration2163); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getVarKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1275:1: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1276:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1276:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1277:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleVariableDeclaration2184);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getVariableDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleVariableDeclaration2194); 

                    createLeafNode(grammarAccess.getVariableDeclarationAccess().getSemicolonKeyword_2(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVariableDeclaration


    // $ANTLR start entryRuleFunctorDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1311:1: entryRuleFunctorDeclaration returns [EObject current=null] : iv_ruleFunctorDeclaration= ruleFunctorDeclaration EOF ;
    public final EObject entryRuleFunctorDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctorDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1312:2: (iv_ruleFunctorDeclaration= ruleFunctorDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1313:2: iv_ruleFunctorDeclaration= ruleFunctorDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFunctorDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleFunctorDeclaration_in_entryRuleFunctorDeclaration2230);
            iv_ruleFunctorDeclaration=ruleFunctorDeclaration();
            _fsp--;

             current =iv_ruleFunctorDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunctorDeclaration2240); 

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
    // $ANTLR end entryRuleFunctorDeclaration


    // $ANTLR start ruleFunctorDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1320:1: ruleFunctorDeclaration returns [EObject current=null] : ( 'functor' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArguments_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';' ) ;
    public final EObject ruleFunctorDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_functionName_3_0 = null;

        EObject lv_templateArguments_5_0 = null;

        EObject lv_templateArguments_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1325:6: ( ( 'functor' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArguments_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1326:1: ( 'functor' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArguments_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1326:1: ( 'functor' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArguments_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1326:3: 'functor' ( (lv_name_1_0= ruleKeywordID ) ) '=' ( (lv_functionName_3_0= ruleQualifiedName ) ) ( '<' ( (lv_templateArguments_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) ) )* '>' )? ';'
            {
            match(input,31,FOLLOW_31_in_ruleFunctorDeclaration2275); 

                    createLeafNode(grammarAccess.getFunctorDeclarationAccess().getFunctorKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1330:1: ( (lv_name_1_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1331:1: (lv_name_1_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1331:1: (lv_name_1_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1332:3: lv_name_1_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctorDeclarationAccess().getNameKeywordIDParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleFunctorDeclaration2296);
            lv_name_1_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctorDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleFunctorDeclaration2306); 

                    createLeafNode(grammarAccess.getFunctorDeclarationAccess().getEqualsSignKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1358:1: ( (lv_functionName_3_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1359:1: (lv_functionName_3_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1359:1: (lv_functionName_3_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1360:3: lv_functionName_3_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFunctorDeclarationAccess().getFunctionNameQualifiedNameParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleFunctorDeclaration2327);
            lv_functionName_3_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFunctorDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"functionName",
            	        		lv_functionName_3_0, 
            	        		"QualifiedName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1382:2: ( '<' ( (lv_templateArguments_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) ) )* '>' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1382:4: '<' ( (lv_templateArguments_5_0= ruleArgumentDeclaration ) ) ( ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) ) )* '>'
                    {
                    match(input,24,FOLLOW_24_in_ruleFunctorDeclaration2338); 

                            createLeafNode(grammarAccess.getFunctorDeclarationAccess().getLessThanSignKeyword_4_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1386:1: ( (lv_templateArguments_5_0= ruleArgumentDeclaration ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1387:1: (lv_templateArguments_5_0= ruleArgumentDeclaration )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1387:1: (lv_templateArguments_5_0= ruleArgumentDeclaration )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1388:3: lv_templateArguments_5_0= ruleArgumentDeclaration
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFunctorDeclarationAccess().getTemplateArgumentsArgumentDeclarationParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArgumentDeclaration_in_ruleFunctorDeclaration2359);
                    lv_templateArguments_5_0=ruleArgumentDeclaration();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFunctorDeclarationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"templateArguments",
                    	        		lv_templateArguments_5_0, 
                    	        		"ArgumentDeclaration", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1410:2: ( ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==16) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1410:4: ',' ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleFunctorDeclaration2370); 

                    	            createLeafNode(grammarAccess.getFunctorDeclarationAccess().getCommaKeyword_4_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1414:1: ( (lv_templateArguments_7_0= ruleArgumentDeclaration ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1415:1: (lv_templateArguments_7_0= ruleArgumentDeclaration )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1415:1: (lv_templateArguments_7_0= ruleArgumentDeclaration )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1416:3: lv_templateArguments_7_0= ruleArgumentDeclaration
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFunctorDeclarationAccess().getTemplateArgumentsArgumentDeclarationParserRuleCall_4_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArgumentDeclaration_in_ruleFunctorDeclaration2391);
                    	    lv_templateArguments_7_0=ruleArgumentDeclaration();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFunctorDeclarationRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"templateArguments",
                    	    	        		lv_templateArguments_7_0, 
                    	    	        		"ArgumentDeclaration", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    match(input,25,FOLLOW_25_in_ruleFunctorDeclaration2403); 

                            createLeafNode(grammarAccess.getFunctorDeclarationAccess().getGreaterThanSignKeyword_4_3(), null); 
                        

                    }
                    break;

            }

            match(input,19,FOLLOW_19_in_ruleFunctorDeclaration2415); 

                    createLeafNode(grammarAccess.getFunctorDeclarationAccess().getSemicolonKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFunctorDeclaration


    // $ANTLR start entryRuleArgumentDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1454:1: entryRuleArgumentDeclaration returns [EObject current=null] : iv_ruleArgumentDeclaration= ruleArgumentDeclaration EOF ;
    public final EObject entryRuleArgumentDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentDeclaration = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1455:2: (iv_ruleArgumentDeclaration= ruleArgumentDeclaration EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1456:2: iv_ruleArgumentDeclaration= ruleArgumentDeclaration EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArgumentDeclarationRule(), currentNode); 
            pushFollow(FOLLOW_ruleArgumentDeclaration_in_entryRuleArgumentDeclaration2451);
            iv_ruleArgumentDeclaration=ruleArgumentDeclaration();
            _fsp--;

             current =iv_ruleArgumentDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArgumentDeclaration2461); 

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
    // $ANTLR end entryRuleArgumentDeclaration


    // $ANTLR start ruleArgumentDeclaration
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1463:1: ruleArgumentDeclaration returns [EObject current=null] : ( (lv_name_0_0= ruleKeywordID ) ) ;
    public final EObject ruleArgumentDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1468:6: ( ( (lv_name_0_0= ruleKeywordID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1469:1: ( (lv_name_0_0= ruleKeywordID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1469:1: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1470:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1470:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1471:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArgumentDeclarationAccess().getNameKeywordIDParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleArgumentDeclaration2506);
            lv_name_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArgumentDeclarationRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArgumentDeclaration


    // $ANTLR start entryRuleEquationDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1501:1: entryRuleEquationDefinition returns [EObject current=null] : iv_ruleEquationDefinition= ruleEquationDefinition EOF ;
    public final EObject entryRuleEquationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquationDefinition = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1502:2: (iv_ruleEquationDefinition= ruleEquationDefinition EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1503:2: iv_ruleEquationDefinition= ruleEquationDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEquationDefinitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEquationDefinition_in_entryRuleEquationDefinition2541);
            iv_ruleEquationDefinition=ruleEquationDefinition();
            _fsp--;

             current =iv_ruleEquationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEquationDefinition2551); 

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
    // $ANTLR end entryRuleEquationDefinition


    // $ANTLR start ruleEquationDefinition
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1510:1: ruleEquationDefinition returns [EObject current=null] : ( ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';' ) ;
    public final EObject ruleEquationDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_leftHandSide_0_0 = null;

        EObject lv_rightHandSide_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1515:6: ( ( ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1516:1: ( ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1516:1: ( ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1516:2: ( (lv_leftHandSide_0_0= ruleExpression ) ) '=' ( (lv_rightHandSide_2_0= ruleExpression ) ) ';'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1516:2: ( (lv_leftHandSide_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1517:1: (lv_leftHandSide_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1517:1: (lv_leftHandSide_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1518:3: lv_leftHandSide_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEquationDefinitionAccess().getLeftHandSideExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleEquationDefinition2597);
            lv_leftHandSide_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEquationDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"leftHandSide",
            	        		lv_leftHandSide_0_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleEquationDefinition2607); 

                    createLeafNode(grammarAccess.getEquationDefinitionAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1544:1: ( (lv_rightHandSide_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1545:1: (lv_rightHandSide_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1545:1: (lv_rightHandSide_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1546:3: lv_rightHandSide_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEquationDefinitionAccess().getRightHandSideExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleEquationDefinition2628);
            lv_rightHandSide_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEquationDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"rightHandSide",
            	        		lv_rightHandSide_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,19,FOLLOW_19_in_ruleEquationDefinition2638); 

                    createLeafNode(grammarAccess.getEquationDefinitionAccess().getSemicolonKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEquationDefinition


    // $ANTLR start entryRuleDataTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1582:1: entryRuleDataTypeSpecifier returns [EObject current=null] : iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF ;
    public final EObject entryRuleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1583:2: (iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1584:2: iv_ruleDataTypeSpecifier= ruleDataTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDataTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier2676);
            iv_ruleDataTypeSpecifier=ruleDataTypeSpecifier();
            _fsp--;

             current =iv_ruleDataTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDataTypeSpecifier2686); 

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
    // $ANTLR end entryRuleDataTypeSpecifier


    // $ANTLR start ruleDataTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1591:1: ruleDataTypeSpecifier returns [EObject current=null] : (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) ;
    public final EObject ruleDataTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeSpecifier_0 = null;

        EObject this_NamedTypeSpecifier_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1596:6: ( (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1597:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1597:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32||(LA18_0>=35 && LA18_0<=39)) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ID||LA18_0==54) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1597:1: (this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier | this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier )", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1598:5: this_PrimitiveTypeSpecifier_0= rulePrimitiveTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getPrimitiveTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier2733);
                    this_PrimitiveTypeSpecifier_0=rulePrimitiveTypeSpecifier();
                    _fsp--;

                     
                            current = this_PrimitiveTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1608:5: this_NamedTypeSpecifier_1= ruleNamedTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getDataTypeSpecifierAccess().getNamedTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier2760);
                    this_NamedTypeSpecifier_1=ruleNamedTypeSpecifier();
                    _fsp--;

                     
                            current = this_NamedTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDataTypeSpecifier


    // $ANTLR start entryRulePrimitiveTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1624:1: entryRulePrimitiveTypeSpecifier returns [EObject current=null] : iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF ;
    public final EObject entryRulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1625:2: (iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1626:2: iv_rulePrimitiveTypeSpecifier= rulePrimitiveTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier2795);
            iv_rulePrimitiveTypeSpecifier=rulePrimitiveTypeSpecifier();
            _fsp--;

             current =iv_rulePrimitiveTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier2805); 

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
    // $ANTLR end entryRulePrimitiveTypeSpecifier


    // $ANTLR start rulePrimitiveTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1633:1: rulePrimitiveTypeSpecifier returns [EObject current=null] : (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) ;
    public final EObject rulePrimitiveTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_NumericTypeSpecifier_0 = null;

        EObject this_BooleanTypeSpecifier_1 = null;

        EObject this_StringTypeSpecifier_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1638:6: ( (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1639:1: (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1639:1: (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 32:
            case 35:
            case 36:
            case 37:
                {
                alt19=1;
                }
                break;
            case 38:
                {
                alt19=2;
                }
                break;
            case 39:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1639:1: (this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier | this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier | this_StringTypeSpecifier_2= ruleStringTypeSpecifier )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1640:5: this_NumericTypeSpecifier_0= ruleNumericTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getNumericTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericTypeSpecifier_in_rulePrimitiveTypeSpecifier2852);
                    this_NumericTypeSpecifier_0=ruleNumericTypeSpecifier();
                    _fsp--;

                     
                            current = this_NumericTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1650:5: this_BooleanTypeSpecifier_1= ruleBooleanTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getBooleanTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier2879);
                    this_BooleanTypeSpecifier_1=ruleBooleanTypeSpecifier();
                    _fsp--;

                     
                            current = this_BooleanTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1660:5: this_StringTypeSpecifier_2= ruleStringTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimitiveTypeSpecifierAccess().getStringTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier2906);
                    this_StringTypeSpecifier_2=ruleStringTypeSpecifier();
                    _fsp--;

                     
                            current = this_StringTypeSpecifier_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePrimitiveTypeSpecifier


    // $ANTLR start entryRuleNumericTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1676:1: entryRuleNumericTypeSpecifier returns [EObject current=null] : iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF ;
    public final EObject entryRuleNumericTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1677:2: (iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1678:2: iv_ruleNumericTypeSpecifier= ruleNumericTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericTypeSpecifier_in_entryRuleNumericTypeSpecifier2941);
            iv_ruleNumericTypeSpecifier=ruleNumericTypeSpecifier();
            _fsp--;

             current =iv_ruleNumericTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericTypeSpecifier2951); 

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
    // $ANTLR end entryRuleNumericTypeSpecifier


    // $ANTLR start ruleNumericTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1685:1: ruleNumericTypeSpecifier returns [EObject current=null] : (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) ;
    public final EObject ruleNumericTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject this_RealTypeSpecifier_0 = null;

        EObject this_IntegerTypeSpecifier_1 = null;

        EObject this_ComplexTypeSpecifier_2 = null;

        EObject this_GaussianTypeSpecifier_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1690:6: ( (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1691:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1691:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt20=1;
                }
                break;
            case 35:
                {
                alt20=2;
                }
                break;
            case 36:
                {
                alt20=3;
                }
                break;
            case 37:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1691:1: (this_RealTypeSpecifier_0= ruleRealTypeSpecifier | this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier | this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier | this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier )", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1692:5: this_RealTypeSpecifier_0= ruleRealTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getRealTypeSpecifierParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealTypeSpecifier_in_ruleNumericTypeSpecifier2998);
                    this_RealTypeSpecifier_0=ruleRealTypeSpecifier();
                    _fsp--;

                     
                            current = this_RealTypeSpecifier_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1702:5: this_IntegerTypeSpecifier_1= ruleIntegerTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getIntegerTypeSpecifierParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericTypeSpecifier3025);
                    this_IntegerTypeSpecifier_1=ruleIntegerTypeSpecifier();
                    _fsp--;

                     
                            current = this_IntegerTypeSpecifier_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1712:5: this_ComplexTypeSpecifier_2= ruleComplexTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getComplexTypeSpecifierParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericTypeSpecifier3052);
                    this_ComplexTypeSpecifier_2=ruleComplexTypeSpecifier();
                    _fsp--;

                     
                            current = this_ComplexTypeSpecifier_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1722:5: this_GaussianTypeSpecifier_3= ruleGaussianTypeSpecifier
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericTypeSpecifierAccess().getGaussianTypeSpecifierParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericTypeSpecifier3079);
                    this_GaussianTypeSpecifier_3=ruleGaussianTypeSpecifier();
                    _fsp--;

                     
                            current = this_GaussianTypeSpecifier_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNumericTypeSpecifier


    // $ANTLR start entryRuleRealTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1738:1: entryRuleRealTypeSpecifier returns [EObject current=null] : iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF ;
    public final EObject entryRuleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1739:2: (iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1740:2: iv_ruleRealTypeSpecifier= ruleRealTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier3114);
            iv_ruleRealTypeSpecifier=ruleRealTypeSpecifier();
            _fsp--;

             current =iv_ruleRealTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTypeSpecifier3124); 

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
    // $ANTLR end entryRuleRealTypeSpecifier


    // $ANTLR start ruleRealTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1747:1: ruleRealTypeSpecifier returns [EObject current=null] : ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleRealTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1752:6: ( ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1753:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1753:1: ( () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1753:2: () 'real' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1753:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1754:5: 
            {
             
                    temp=factory.create(grammarAccess.getRealTypeSpecifierAccess().getRealTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getRealTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,32,FOLLOW_32_in_ruleRealTypeSpecifier3168); 

                    createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRealKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1768:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1768:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleRealTypeSpecifier3179); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1772:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1773:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1773:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1774:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier3200);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,27,FOLLOW_27_in_ruleRealTypeSpecifier3210); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1800:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1800:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleRealTypeSpecifier3223); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1804:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1805:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1805:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1806:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3244);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_6_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1828:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==16) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1828:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleRealTypeSpecifier3255); 

                    	            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1832:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1833:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1833:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1834:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRealTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3276);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getRealTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_8_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleRealTypeSpecifier3288); 

                            createLeafNode(grammarAccess.getRealTypeSpecifierAccess().getRightSquareBracketKeyword_3_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRealTypeSpecifier


    // $ANTLR start entryRuleIntegerTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1868:1: entryRuleIntegerTypeSpecifier returns [EObject current=null] : iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF ;
    public final EObject entryRuleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1869:2: (iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1870:2: iv_ruleIntegerTypeSpecifier= ruleIntegerTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier3326);
            iv_ruleIntegerTypeSpecifier=ruleIntegerTypeSpecifier();
            _fsp--;

             current =iv_ruleIntegerTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier3336); 

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
    // $ANTLR end entryRuleIntegerTypeSpecifier


    // $ANTLR start ruleIntegerTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1877:1: ruleIntegerTypeSpecifier returns [EObject current=null] : ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleIntegerTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1882:6: ( ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1883:1: ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1883:1: ( () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1883:2: () 'int' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1883:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1884:5: 
            {
             
                    temp=factory.create(grammarAccess.getIntegerTypeSpecifierAccess().getIntegerTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getIntegerTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,35,FOLLOW_35_in_ruleIntegerTypeSpecifier3380); 

                    createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getIntKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1898:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==26) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1898:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleIntegerTypeSpecifier3391); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1902:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1903:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1903:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1904:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier3412);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,27,FOLLOW_27_in_ruleIntegerTypeSpecifier3422); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1930:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1930:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleIntegerTypeSpecifier3435); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1934:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1935:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1935:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1936:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3456);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_6_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1958:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==16) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1958:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleIntegerTypeSpecifier3467); 

                    	            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1962:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1963:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1963:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1964:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getIntegerTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3488);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getIntegerTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_8_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleIntegerTypeSpecifier3500); 

                            createLeafNode(grammarAccess.getIntegerTypeSpecifierAccess().getRightSquareBracketKeyword_3_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIntegerTypeSpecifier


    // $ANTLR start entryRuleComplexTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1998:1: entryRuleComplexTypeSpecifier returns [EObject current=null] : iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF ;
    public final EObject entryRuleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComplexTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:1999:2: (iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2000:2: iv_ruleComplexTypeSpecifier= ruleComplexTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComplexTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier3538);
            iv_ruleComplexTypeSpecifier=ruleComplexTypeSpecifier();
            _fsp--;

             current =iv_ruleComplexTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComplexTypeSpecifier3548); 

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
    // $ANTLR end entryRuleComplexTypeSpecifier


    // $ANTLR start ruleComplexTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2007:1: ruleComplexTypeSpecifier returns [EObject current=null] : ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleComplexTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2012:6: ( ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2013:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2013:1: ( () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2013:2: () 'complex' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2013:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2014:5: 
            {
             
                    temp=factory.create(grammarAccess.getComplexTypeSpecifierAccess().getComplexTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getComplexTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,36,FOLLOW_36_in_ruleComplexTypeSpecifier3592); 

                    createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getComplexKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2028:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2028:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleComplexTypeSpecifier3603); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2032:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2033:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2033:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2034:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier3624);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getComplexTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,27,FOLLOW_27_in_ruleComplexTypeSpecifier3634); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2060:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==33) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2060:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleComplexTypeSpecifier3647); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2064:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2065:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2065:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2066:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3668);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getComplexTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_6_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2088:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==16) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2088:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleComplexTypeSpecifier3679); 

                    	            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2092:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2093:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2093:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2094:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getComplexTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3700);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getComplexTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_8_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleComplexTypeSpecifier3712); 

                            createLeafNode(grammarAccess.getComplexTypeSpecifierAccess().getRightSquareBracketKeyword_3_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleComplexTypeSpecifier


    // $ANTLR start entryRuleGaussianTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2128:1: entryRuleGaussianTypeSpecifier returns [EObject current=null] : iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF ;
    public final EObject entryRuleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGaussianTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2129:2: (iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2130:2: iv_ruleGaussianTypeSpecifier= ruleGaussianTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getGaussianTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier3750);
            iv_ruleGaussianTypeSpecifier=ruleGaussianTypeSpecifier();
            _fsp--;

             current =iv_ruleGaussianTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier3760); 

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
    // $ANTLR end entryRuleGaussianTypeSpecifier


    // $ANTLR start ruleGaussianTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2137:1: ruleGaussianTypeSpecifier returns [EObject current=null] : ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleGaussianTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_3_0 = null;

        EObject lv_dimensions_6_0 = null;

        EObject lv_dimensions_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2142:6: ( ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2143:1: ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2143:1: ( () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2143:2: () 'gauss' ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2143:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2144:5: 
            {
             
                    temp=factory.create(grammarAccess.getGaussianTypeSpecifierAccess().getGaussianTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getGaussianTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,37,FOLLOW_37_in_ruleGaussianTypeSpecifier3804); 

                    createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getGaussKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2158:1: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==26) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2158:3: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleGaussianTypeSpecifier3815); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2162:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2163:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2163:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2164:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier3836);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGaussianTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,27,FOLLOW_27_in_ruleGaussianTypeSpecifier3846); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2190:3: ( '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==33) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2190:5: '[' ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleGaussianTypeSpecifier3859); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getLeftSquareBracketKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2194:1: ( (lv_dimensions_6_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2195:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2195:1: (lv_dimensions_6_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2196:3: lv_dimensions_6_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3880);
                    lv_dimensions_6_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getGaussianTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_6_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2218:2: ( ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==16) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2218:4: ',' ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleGaussianTypeSpecifier3891); 

                    	            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getCommaKeyword_3_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2222:1: ( (lv_dimensions_8_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2223:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2223:1: (lv_dimensions_8_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2224:3: lv_dimensions_8_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getGaussianTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_3_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3912);
                    	    lv_dimensions_8_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getGaussianTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_8_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleGaussianTypeSpecifier3924); 

                            createLeafNode(grammarAccess.getGaussianTypeSpecifierAccess().getRightSquareBracketKeyword_3_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGaussianTypeSpecifier


    // $ANTLR start entryRuleBooleanTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2258:1: entryRuleBooleanTypeSpecifier returns [EObject current=null] : iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF ;
    public final EObject entryRuleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2259:2: (iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2260:2: iv_ruleBooleanTypeSpecifier= ruleBooleanTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier3962);
            iv_ruleBooleanTypeSpecifier=ruleBooleanTypeSpecifier();
            _fsp--;

             current =iv_ruleBooleanTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier3972); 

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
    // $ANTLR end entryRuleBooleanTypeSpecifier


    // $ANTLR start ruleBooleanTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2267:1: ruleBooleanTypeSpecifier returns [EObject current=null] : ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleBooleanTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2272:6: ( ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2273:1: ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2273:1: ( () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2273:2: () 'bool' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2273:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2274:5: 
            {
             
                    temp=factory.create(grammarAccess.getBooleanTypeSpecifierAccess().getBooleanTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getBooleanTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,38,FOLLOW_38_in_ruleBooleanTypeSpecifier4016); 

                    createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getBoolKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2288:1: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==33) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2288:3: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleBooleanTypeSpecifier4027); 

                            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2292:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2293:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2293:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2294:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier4048);
                    lv_dimensions_3_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBooleanTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_3_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2316:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==16) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2316:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleBooleanTypeSpecifier4059); 

                    	            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2320:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2321:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2321:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2322:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBooleanTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier4080);
                    	    lv_dimensions_5_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBooleanTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_5_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleBooleanTypeSpecifier4092); 

                            createLeafNode(grammarAccess.getBooleanTypeSpecifierAccess().getRightSquareBracketKeyword_2_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanTypeSpecifier


    // $ANTLR start entryRuleStringTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2356:1: entryRuleStringTypeSpecifier returns [EObject current=null] : iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF ;
    public final EObject entryRuleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2357:2: (iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2358:2: iv_ruleStringTypeSpecifier= ruleStringTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier4130);
            iv_ruleStringTypeSpecifier=ruleStringTypeSpecifier();
            _fsp--;

             current =iv_ruleStringTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTypeSpecifier4140); 

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
    // $ANTLR end entryRuleStringTypeSpecifier


    // $ANTLR start ruleStringTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2365:1: ruleStringTypeSpecifier returns [EObject current=null] : ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleStringTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_dimensions_3_0 = null;

        EObject lv_dimensions_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2370:6: ( ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2371:1: ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2371:1: ( () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2371:2: () 'string' ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2371:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2372:5: 
            {
             
                    temp=factory.create(grammarAccess.getStringTypeSpecifierAccess().getStringTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getStringTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,39,FOLLOW_39_in_ruleStringTypeSpecifier4184); 

                    createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getStringKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2386:1: ( '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==33) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2386:3: '[' ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleStringTypeSpecifier4195); 

                            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getLeftSquareBracketKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2390:1: ( (lv_dimensions_3_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2391:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2391:1: (lv_dimensions_3_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2392:3: lv_dimensions_3_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4216);
                    lv_dimensions_3_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getStringTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_3_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2414:2: ( ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==16) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2414:4: ',' ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleStringTypeSpecifier4227); 

                    	            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getCommaKeyword_2_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2418:1: ( (lv_dimensions_5_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2419:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2419:1: (lv_dimensions_5_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2420:3: lv_dimensions_5_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getStringTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_2_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4248);
                    	    lv_dimensions_5_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getStringTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_5_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleStringTypeSpecifier4260); 

                            createLeafNode(grammarAccess.getStringTypeSpecifierAccess().getRightSquareBracketKeyword_2_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStringTypeSpecifier


    // $ANTLR start entryRuleNamedTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2454:1: entryRuleNamedTypeSpecifier returns [EObject current=null] : iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF ;
    public final EObject entryRuleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2455:2: (iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2456:2: iv_ruleNamedTypeSpecifier= ruleNamedTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier4298);
            iv_ruleNamedTypeSpecifier=ruleNamedTypeSpecifier();
            _fsp--;

             current =iv_ruleNamedTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTypeSpecifier4308); 

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
    // $ANTLR end entryRuleNamedTypeSpecifier


    // $ANTLR start ruleNamedTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2463:1: ruleNamedTypeSpecifier returns [EObject current=null] : ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) ;
    public final EObject ruleNamedTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject lv_typeReference_0_0 = null;

        EObject lv_dimensions_2_0 = null;

        EObject lv_dimensions_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2468:6: ( ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2469:1: ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2469:1: ( ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2469:2: ( (lv_typeReference_0_0= ruleQualifiedName ) ) ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2469:2: ( (lv_typeReference_0_0= ruleQualifiedName ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:1: (lv_typeReference_0_0= ruleQualifiedName )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2470:1: (lv_typeReference_0_0= ruleQualifiedName )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2471:3: lv_typeReference_0_0= ruleQualifiedName
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getTypeReferenceQualifiedNameParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNamedTypeSpecifier4354);
            lv_typeReference_0_0=ruleQualifiedName();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"typeReference",
            	        		lv_typeReference_0_0, 
            	        		"QualifiedName", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2493:2: ( '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==33) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2493:4: '[' ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) ) ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )* ']'
                    {
                    match(input,33,FOLLOW_33_in_ruleNamedTypeSpecifier4365); 

                            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getLeftSquareBracketKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2497:1: ( (lv_dimensions_2_0= ruleArrayDimensionSpecification ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2498:1: (lv_dimensions_2_0= ruleArrayDimensionSpecification )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2498:1: (lv_dimensions_2_0= ruleArrayDimensionSpecification )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2499:3: lv_dimensions_2_0= ruleArrayDimensionSpecification
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4386);
                    lv_dimensions_2_0=ruleArrayDimensionSpecification();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"dimensions",
                    	        		lv_dimensions_2_0, 
                    	        		"ArrayDimensionSpecification", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2521:2: ( ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==16) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2521:4: ',' ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleNamedTypeSpecifier4397); 

                    	            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getCommaKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2525:1: ( (lv_dimensions_4_0= ruleArrayDimensionSpecification ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2526:1: (lv_dimensions_4_0= ruleArrayDimensionSpecification )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2526:1: (lv_dimensions_4_0= ruleArrayDimensionSpecification )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2527:3: lv_dimensions_4_0= ruleArrayDimensionSpecification
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getNamedTypeSpecifierAccess().getDimensionsArrayDimensionSpecificationParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4418);
                    	    lv_dimensions_4_0=ruleArrayDimensionSpecification();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getNamedTypeSpecifierRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"dimensions",
                    	    	        		lv_dimensions_4_0, 
                    	    	        		"ArrayDimensionSpecification", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    match(input,34,FOLLOW_34_in_ruleNamedTypeSpecifier4430); 

                            createLeafNode(grammarAccess.getNamedTypeSpecifierAccess().getRightSquareBracketKeyword_1_3(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNamedTypeSpecifier


    // $ANTLR start entryRuleArrayDimensionSpecification
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2561:1: entryRuleArrayDimensionSpecification returns [EObject current=null] : iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF ;
    public final EObject entryRuleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayDimensionSpecification = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2562:2: (iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2563:2: iv_ruleArrayDimensionSpecification= ruleArrayDimensionSpecification EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayDimensionSpecificationRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification4468);
            iv_ruleArrayDimensionSpecification=ruleArrayDimensionSpecification();
            _fsp--;

             current =iv_ruleArrayDimensionSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayDimensionSpecification4478); 

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
    // $ANTLR end entryRuleArrayDimensionSpecification


    // $ANTLR start ruleArrayDimensionSpecification
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2570:1: ruleArrayDimensionSpecification returns [EObject current=null] : ( ( (lv_unspecified_0_0= '?' ) ) | ( (lv_size_1_0= ruleExpression ) ) ) ;
    public final EObject ruleArrayDimensionSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_unspecified_0_0=null;
        EObject lv_size_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2575:6: ( ( ( (lv_unspecified_0_0= '?' ) ) | ( (lv_size_1_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2576:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( (lv_size_1_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2576:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( (lv_size_1_0= ruleExpression ) ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==40) ) {
                alt39=1;
            }
            else if ( ((LA39_0>=RULE_REAL && LA39_0<=RULE_ID)||LA39_0==26||LA39_0==33||(LA39_0>=41 && LA39_0<=42)||LA39_0==44||LA39_0==47||(LA39_0>=57 && LA39_0<=58)||LA39_0==63||LA39_0==76||(LA39_0>=78 && LA39_0<=79)) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("2576:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( (lv_size_1_0= ruleExpression ) ) )", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2576:2: ( (lv_unspecified_0_0= '?' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2576:2: ( (lv_unspecified_0_0= '?' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2577:1: (lv_unspecified_0_0= '?' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2577:1: (lv_unspecified_0_0= '?' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2578:3: lv_unspecified_0_0= '?'
                    {
                    lv_unspecified_0_0=(Token)input.LT(1);
                    match(input,40,FOLLOW_40_in_ruleArrayDimensionSpecification4521); 

                            createLeafNode(grammarAccess.getArrayDimensionSpecificationAccess().getUnspecifiedQuestionMarkKeyword_0_0(), "unspecified"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getArrayDimensionSpecificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "unspecified", true, "?", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2598:6: ( (lv_size_1_0= ruleExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2598:6: ( (lv_size_1_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2599:1: (lv_size_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2599:1: (lv_size_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2600:3: lv_size_1_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getArrayDimensionSpecificationAccess().getSizeExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification4561);
                    lv_size_1_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getArrayDimensionSpecificationRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"size",
                    	        		lv_size_1_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArrayDimensionSpecification


    // $ANTLR start entryRuleUnitTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2630:1: entryRuleUnitTypeSpecifier returns [EObject current=null] : iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF ;
    public final EObject entryRuleUnitTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitTypeSpecifier = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2631:2: (iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2632:2: iv_ruleUnitTypeSpecifier= ruleUnitTypeSpecifier EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitTypeSpecifierRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitTypeSpecifier_in_entryRuleUnitTypeSpecifier4597);
            iv_ruleUnitTypeSpecifier=ruleUnitTypeSpecifier();
            _fsp--;

             current =iv_ruleUnitTypeSpecifier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitTypeSpecifier4607); 

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
    // $ANTLR end entryRuleUnitTypeSpecifier


    // $ANTLR start ruleUnitTypeSpecifier
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2639:1: ruleUnitTypeSpecifier returns [EObject current=null] : ( () 'unit' ) ;
    public final EObject ruleUnitTypeSpecifier() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2644:6: ( ( () 'unit' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2645:1: ( () 'unit' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2645:1: ( () 'unit' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2645:2: () 'unit'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2645:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2646:5: 
            {
             
                    temp=factory.create(grammarAccess.getUnitTypeSpecifierAccess().getUnitTypeSpecifierAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getUnitTypeSpecifierAccess().getUnitTypeSpecifierAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,41,FOLLOW_41_in_ruleUnitTypeSpecifier4651); 

                    createLeafNode(grammarAccess.getUnitTypeSpecifierAccess().getUnitKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitTypeSpecifier


    // $ANTLR start entryRuleExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2668:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2669:2: (iv_ruleExpression= ruleExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2670:2: iv_ruleExpression= ruleExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression4687);
            iv_ruleExpression=ruleExpression();
            _fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression4697); 

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
    // $ANTLR end entryRuleExpression


    // $ANTLR start ruleExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2677:1: ruleExpression returns [EObject current=null] : (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LetExpression_0 = null;

        EObject this_IfExpression_1 = null;

        EObject this_SwitchExpression_2 = null;

        EObject this_RangeExpression_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2682:6: ( (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2683:1: (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2683:1: (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression )
            int alt40=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt40=1;
                }
                break;
            case 44:
                {
                alt40=2;
                }
                break;
            case 47:
                {
                alt40=3;
                }
                break;
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case RULE_ID:
            case 26:
            case 33:
            case 41:
            case 57:
            case 58:
            case 63:
            case 76:
            case 78:
            case 79:
                {
                alt40=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("2683:1: (this_LetExpression_0= ruleLetExpression | this_IfExpression_1= ruleIfExpression | this_SwitchExpression_2= ruleSwitchExpression | this_RangeExpression_3= ruleRangeExpression )", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2684:5: this_LetExpression_0= ruleLetExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getLetExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLetExpression_in_ruleExpression4744);
                    this_LetExpression_0=ruleLetExpression();
                    _fsp--;

                     
                            current = this_LetExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2694:5: this_IfExpression_1= ruleIfExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getIfExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIfExpression_in_ruleExpression4771);
                    this_IfExpression_1=ruleIfExpression();
                    _fsp--;

                     
                            current = this_IfExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2704:5: this_SwitchExpression_2= ruleSwitchExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getSwitchExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSwitchExpression_in_ruleExpression4798);
                    this_SwitchExpression_2=ruleSwitchExpression();
                    _fsp--;

                     
                            current = this_SwitchExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2714:5: this_RangeExpression_3= ruleRangeExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExpressionAccess().getRangeExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRangeExpression_in_ruleExpression4825);
                    this_RangeExpression_3=ruleRangeExpression();
                    _fsp--;

                     
                            current = this_RangeExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExpression


    // $ANTLR start entryRuleLetExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2730:1: entryRuleLetExpression returns [EObject current=null] : iv_ruleLetExpression= ruleLetExpression EOF ;
    public final EObject entryRuleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2731:2: (iv_ruleLetExpression= ruleLetExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2732:2: iv_ruleLetExpression= ruleLetExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLetExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLetExpression_in_entryRuleLetExpression4860);
            iv_ruleLetExpression=ruleLetExpression();
            _fsp--;

             current =iv_ruleLetExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpression4870); 

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
    // $ANTLR end entryRuleLetExpression


    // $ANTLR start ruleLetExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2739:1: ruleLetExpression returns [EObject current=null] : ( 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleLetExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_variables_1_0 = null;

        EObject lv_variables_3_0 = null;

        EObject lv_targetExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2744:6: ( ( 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2745:1: ( 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2745:1: ( 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2745:3: 'let' ( (lv_variables_1_0= ruleLetExpressionVariable ) ) ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )* 'in' ( (lv_targetExpression_5_0= ruleExpression ) )
            {
            match(input,42,FOLLOW_42_in_ruleLetExpression4905); 

                    createLeafNode(grammarAccess.getLetExpressionAccess().getLetKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2749:1: ( (lv_variables_1_0= ruleLetExpressionVariable ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2750:1: (lv_variables_1_0= ruleLetExpressionVariable )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2750:1: (lv_variables_1_0= ruleLetExpressionVariable )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2751:3: lv_variables_1_0= ruleLetExpressionVariable
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLetExpressionAccess().getVariablesLetExpressionVariableParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleLetExpressionVariable_in_ruleLetExpression4926);
            lv_variables_1_0=ruleLetExpressionVariable();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLetExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"variables",
            	        		lv_variables_1_0, 
            	        		"LetExpressionVariable", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2773:2: ( ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==16) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2773:4: ',' ( (lv_variables_3_0= ruleLetExpressionVariable ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleLetExpression4937); 

            	            createLeafNode(grammarAccess.getLetExpressionAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2777:1: ( (lv_variables_3_0= ruleLetExpressionVariable ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2778:1: (lv_variables_3_0= ruleLetExpressionVariable )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2778:1: (lv_variables_3_0= ruleLetExpressionVariable )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2779:3: lv_variables_3_0= ruleLetExpressionVariable
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getLetExpressionAccess().getVariablesLetExpressionVariableParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleLetExpressionVariable_in_ruleLetExpression4958);
            	    lv_variables_3_0=ruleLetExpressionVariable();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getLetExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"variables",
            	    	        		lv_variables_3_0, 
            	    	        		"LetExpressionVariable", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            match(input,43,FOLLOW_43_in_ruleLetExpression4970); 

                    createLeafNode(grammarAccess.getLetExpressionAccess().getInKeyword_3(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2805:1: ( (lv_targetExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2806:1: (lv_targetExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2806:1: (lv_targetExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2807:3: lv_targetExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLetExpressionAccess().getTargetExpressionExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpression4991);
            lv_targetExpression_5_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLetExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"targetExpression",
            	        		lv_targetExpression_5_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLetExpression


    // $ANTLR start entryRuleLetExpressionVariable
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2837:1: entryRuleLetExpressionVariable returns [EObject current=null] : iv_ruleLetExpressionVariable= ruleLetExpressionVariable EOF ;
    public final EObject entryRuleLetExpressionVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpressionVariable = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2838:2: (iv_ruleLetExpressionVariable= ruleLetExpressionVariable EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2839:2: iv_ruleLetExpressionVariable= ruleLetExpressionVariable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLetExpressionVariableRule(), currentNode); 
            pushFollow(FOLLOW_ruleLetExpressionVariable_in_entryRuleLetExpressionVariable5027);
            iv_ruleLetExpressionVariable=ruleLetExpressionVariable();
            _fsp--;

             current =iv_ruleLetExpressionVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpressionVariable5037); 

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
    // $ANTLR end entryRuleLetExpressionVariable


    // $ANTLR start ruleLetExpressionVariable
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2846:1: ruleLetExpressionVariable returns [EObject current=null] : ( ( (lv_name_0_0= ruleKeywordID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleLetExpressionVariable() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_assignedExpression_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2851:6: ( ( ( (lv_name_0_0= ruleKeywordID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2852:1: ( ( (lv_name_0_0= ruleKeywordID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2852:1: ( ( (lv_name_0_0= ruleKeywordID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2852:2: ( (lv_name_0_0= ruleKeywordID ) ) '=' ( (lv_assignedExpression_2_0= ruleExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2852:2: ( (lv_name_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2853:1: (lv_name_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2853:1: (lv_name_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2854:3: lv_name_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLetExpressionVariableAccess().getNameKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleLetExpressionVariable5083);
            lv_name_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLetExpressionVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleLetExpressionVariable5093); 

                    createLeafNode(grammarAccess.getLetExpressionVariableAccess().getEqualsSignKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2880:1: ( (lv_assignedExpression_2_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2881:1: (lv_assignedExpression_2_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2881:1: (lv_assignedExpression_2_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2882:3: lv_assignedExpression_2_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getLetExpressionVariableAccess().getAssignedExpressionExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleLetExpressionVariable5114);
            lv_assignedExpression_2_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getLetExpressionVariableRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"assignedExpression",
            	        		lv_assignedExpression_2_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLetExpressionVariable


    // $ANTLR start entryRuleIfExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2912:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2913:2: (iv_ruleIfExpression= ruleIfExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2914:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIfExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleIfExpression_in_entryRuleIfExpression5150);
            iv_ruleIfExpression=ruleIfExpression();
            _fsp--;

             current =iv_ruleIfExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpression5160); 

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
    // $ANTLR end entryRuleIfExpression


    // $ANTLR start ruleIfExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2921:1: ruleIfExpression returns [EObject current=null] : ( 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_1_0 = null;

        EObject lv_thenExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2926:6: ( ( 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2927:1: ( 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2927:1: ( 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2927:3: 'if' ( (lv_condition_1_0= ruleExpression ) ) 'then' ( (lv_thenExpression_3_0= ruleExpression ) ) 'else' ( (lv_elseExpression_5_0= ruleExpression ) )
            {
            match(input,44,FOLLOW_44_in_ruleIfExpression5195); 

                    createLeafNode(grammarAccess.getIfExpressionAccess().getIfKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2931:1: ( (lv_condition_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2932:1: (lv_condition_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2932:1: (lv_condition_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2933:3: lv_condition_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getConditionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression5216);
            lv_condition_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"condition",
            	        		lv_condition_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,45,FOLLOW_45_in_ruleIfExpression5226); 

                    createLeafNode(grammarAccess.getIfExpressionAccess().getThenKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2959:1: ( (lv_thenExpression_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2960:1: (lv_thenExpression_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2960:1: (lv_thenExpression_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2961:3: lv_thenExpression_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression5247);
            lv_thenExpression_3_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"thenExpression",
            	        		lv_thenExpression_3_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,46,FOLLOW_46_in_ruleIfExpression5257); 

                    createLeafNode(grammarAccess.getIfExpressionAccess().getElseKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2987:1: ( (lv_elseExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2988:1: (lv_elseExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2988:1: (lv_elseExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:2989:3: lv_elseExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionExpressionParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIfExpression5278);
            lv_elseExpression_5_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIfExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"elseExpression",
            	        		lv_elseExpression_5_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIfExpression


    // $ANTLR start entryRuleSwitchExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3019:1: entryRuleSwitchExpression returns [EObject current=null] : iv_ruleSwitchExpression= ruleSwitchExpression EOF ;
    public final EObject entryRuleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3020:2: (iv_ruleSwitchExpression= ruleSwitchExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3021:2: iv_ruleSwitchExpression= ruleSwitchExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSwitchExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression5314);
            iv_ruleSwitchExpression=ruleSwitchExpression();
            _fsp--;

             current =iv_ruleSwitchExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchExpression5324); 

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
    // $ANTLR end entryRuleSwitchExpression


    // $ANTLR start ruleSwitchExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3028:1: ruleSwitchExpression returns [EObject current=null] : ( 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_controlExpression_1_0 = null;

        EObject lv_cases_2_0 = null;

        EObject lv_defaultExpression_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3033:6: ( ( 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3034:1: ( 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3034:1: ( 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3034:3: 'switch' ( (lv_controlExpression_1_0= ruleExpression ) ) ( (lv_cases_2_0= ruleSwitchCase ) )* 'default' ':' ( (lv_defaultExpression_5_0= ruleExpression ) )
            {
            match(input,47,FOLLOW_47_in_ruleSwitchExpression5359); 

                    createLeafNode(grammarAccess.getSwitchExpressionAccess().getSwitchKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3038:1: ( (lv_controlExpression_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3039:1: (lv_controlExpression_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3039:1: (lv_controlExpression_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3040:3: lv_controlExpression_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getControlExpressionExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression5380);
            lv_controlExpression_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"controlExpression",
            	        		lv_controlExpression_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3062:2: ( (lv_cases_2_0= ruleSwitchCase ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==49) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3063:1: (lv_cases_2_0= ruleSwitchCase )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3063:1: (lv_cases_2_0= ruleSwitchCase )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3064:3: lv_cases_2_0= ruleSwitchCase
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getCasesSwitchCaseParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSwitchCase_in_ruleSwitchExpression5401);
            	    lv_cases_2_0=ruleSwitchCase();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"cases",
            	    	        		lv_cases_2_0, 
            	    	        		"SwitchCase", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            match(input,48,FOLLOW_48_in_ruleSwitchExpression5412); 

                    createLeafNode(grammarAccess.getSwitchExpressionAccess().getDefaultKeyword_3(), null); 
                
            match(input,21,FOLLOW_21_in_ruleSwitchExpression5422); 

                    createLeafNode(grammarAccess.getSwitchExpressionAccess().getColonKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3094:1: ( (lv_defaultExpression_5_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3095:1: (lv_defaultExpression_5_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3095:1: (lv_defaultExpression_5_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3096:3: lv_defaultExpression_5_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSwitchExpressionAccess().getDefaultExpressionExpressionParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchExpression5443);
            lv_defaultExpression_5_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSwitchExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"defaultExpression",
            	        		lv_defaultExpression_5_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSwitchExpression


    // $ANTLR start entryRuleSwitchCase
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3126:1: entryRuleSwitchCase returns [EObject current=null] : iv_ruleSwitchCase= ruleSwitchCase EOF ;
    public final EObject entryRuleSwitchCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchCase = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3127:2: (iv_ruleSwitchCase= ruleSwitchCase EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3128:2: iv_ruleSwitchCase= ruleSwitchCase EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSwitchCaseRule(), currentNode); 
            pushFollow(FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase5479);
            iv_ruleSwitchCase=ruleSwitchCase();
            _fsp--;

             current =iv_ruleSwitchCase; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchCase5489); 

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
    // $ANTLR end entryRuleSwitchCase


    // $ANTLR start ruleSwitchCase
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3135:1: ruleSwitchCase returns [EObject current=null] : ( 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleSwitchCase() throws RecognitionException {
        EObject current = null;

        EObject lv_caseExpression_1_0 = null;

        EObject lv_resultExpression_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3140:6: ( ( 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3141:1: ( 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3141:1: ( 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3141:3: 'case' ( (lv_caseExpression_1_0= ruleImpliesExpression ) ) ':' ( (lv_resultExpression_3_0= ruleExpression ) )
            {
            match(input,49,FOLLOW_49_in_ruleSwitchCase5524); 

                    createLeafNode(grammarAccess.getSwitchCaseAccess().getCaseKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3145:1: ( (lv_caseExpression_1_0= ruleImpliesExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3146:1: (lv_caseExpression_1_0= ruleImpliesExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3146:1: (lv_caseExpression_1_0= ruleImpliesExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3147:3: lv_caseExpression_1_0= ruleImpliesExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSwitchCaseAccess().getCaseExpressionImpliesExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleSwitchCase5545);
            lv_caseExpression_1_0=ruleImpliesExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSwitchCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"caseExpression",
            	        		lv_caseExpression_1_0, 
            	        		"ImpliesExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,21,FOLLOW_21_in_ruleSwitchCase5555); 

                    createLeafNode(grammarAccess.getSwitchCaseAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3173:1: ( (lv_resultExpression_3_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3174:1: (lv_resultExpression_3_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3174:1: (lv_resultExpression_3_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3175:3: lv_resultExpression_3_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSwitchCaseAccess().getResultExpressionExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchCase5576);
            lv_resultExpression_3_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSwitchCaseRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"resultExpression",
            	        		lv_resultExpression_3_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSwitchCase


    // $ANTLR start entryRuleRangeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3205:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3206:2: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3207:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRangeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression5612);
            iv_ruleRangeExpression=ruleRangeExpression();
            _fsp--;

             current =iv_ruleRangeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeExpression5622); 

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
    // $ANTLR end entryRuleRangeExpression


    // $ANTLR start ruleRangeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3214:1: ruleRangeExpression returns [EObject current=null] : (this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_end_3_0= ruleImpliesExpression ) ) ( () ':' ( (lv_end_6_0= ruleImpliesExpression ) ) )? )? ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesExpression_0 = null;

        EObject lv_end_3_0 = null;

        EObject lv_end_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3219:6: ( (this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_end_3_0= ruleImpliesExpression ) ) ( () ':' ( (lv_end_6_0= ruleImpliesExpression ) ) )? )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3220:1: (this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_end_3_0= ruleImpliesExpression ) ) ( () ':' ( (lv_end_6_0= ruleImpliesExpression ) ) )? )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3220:1: (this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_end_3_0= ruleImpliesExpression ) ) ( () ':' ( (lv_end_6_0= ruleImpliesExpression ) ) )? )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3221:5: this_ImpliesExpression_0= ruleImpliesExpression ( () ':' ( (lv_end_3_0= ruleImpliesExpression ) ) ( () ':' ( (lv_end_6_0= ruleImpliesExpression ) ) )? )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getImpliesExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5669);
            this_ImpliesExpression_0=ruleImpliesExpression();
            _fsp--;

             
                    current = this_ImpliesExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3229:1: ( () ':' ( (lv_end_3_0= ruleImpliesExpression ) ) ( () ':' ( (lv_end_6_0= ruleImpliesExpression ) ) )? )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==21) ) {
                int LA44_1 = input.LA(2);

                if ( ((LA44_1>=RULE_REAL && LA44_1<=RULE_ID)||LA44_1==26||LA44_1==33||LA44_1==41||(LA44_1>=57 && LA44_1<=58)||LA44_1==63||LA44_1==76||(LA44_1>=78 && LA44_1<=79)) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3229:2: () ':' ( (lv_end_3_0= ruleImpliesExpression ) ) ( () ':' ( (lv_end_6_0= ruleImpliesExpression ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3229:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3230:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRangeExpressionAccess().getRangeExpressionBeginAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "begin", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRangeExpressionAccess().getRangeExpressionBeginAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,21,FOLLOW_21_in_ruleRangeExpression5688); 

                            createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3249:1: ( (lv_end_3_0= ruleImpliesExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3250:1: (lv_end_3_0= ruleImpliesExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3250:1: (lv_end_3_0= ruleImpliesExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3251:3: lv_end_3_0= ruleImpliesExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getEndImpliesExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5709);
                    lv_end_3_0=ruleImpliesExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRangeExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"end",
                    	        		lv_end_3_0, 
                    	        		"ImpliesExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3273:2: ( () ':' ( (lv_end_6_0= ruleImpliesExpression ) ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==21) ) {
                        int LA43_1 = input.LA(2);

                        if ( ((LA43_1>=RULE_REAL && LA43_1<=RULE_ID)||LA43_1==26||LA43_1==33||LA43_1==41||(LA43_1>=57 && LA43_1<=58)||LA43_1==63||LA43_1==76||(LA43_1>=78 && LA43_1<=79)) ) {
                            alt43=1;
                        }
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3273:3: () ':' ( (lv_end_6_0= ruleImpliesExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3273:3: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3274:5: 
                            {
                             
                                    temp=factory.create(grammarAccess.getRangeExpressionAccess().getRangeExpressionIncrementAction_1_3_0().getType().getClassifier());
                                    try {
                                    	factory.set(temp, "increment", current, null /*ParserRule*/, currentNode);
                                    } catch(ValueConverterException vce) {
                                    	handleValueConverterException(vce);
                                    }
                                    current = temp; 
                                    temp = null;
                                    CompositeNode newNode = createCompositeNode(grammarAccess.getRangeExpressionAccess().getRangeExpressionIncrementAction_1_3_0(), currentNode.getParent());
                                newNode.getChildren().add(currentNode);
                                moveLookaheadInfo(currentNode, newNode);
                                currentNode = newNode; 
                                    associateNodeWithAstElement(currentNode, current); 
                                

                            }

                            match(input,21,FOLLOW_21_in_ruleRangeExpression5729); 

                                    createLeafNode(grammarAccess.getRangeExpressionAccess().getColonKeyword_1_3_1(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3293:1: ( (lv_end_6_0= ruleImpliesExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3294:1: (lv_end_6_0= ruleImpliesExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3294:1: (lv_end_6_0= ruleImpliesExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3295:3: lv_end_6_0= ruleImpliesExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRangeExpressionAccess().getEndImpliesExpressionParserRuleCall_1_3_2_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5750);
                            lv_end_6_0=ruleImpliesExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRangeExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"end",
                            	        		lv_end_6_0, 
                            	        		"ImpliesExpression", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRangeExpression


    // $ANTLR start entryRuleImpliesExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3325:1: entryRuleImpliesExpression returns [EObject current=null] : iv_ruleImpliesExpression= ruleImpliesExpression EOF ;
    public final EObject entryRuleImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3326:2: (iv_ruleImpliesExpression= ruleImpliesExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3327:2: iv_ruleImpliesExpression= ruleImpliesExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImpliesExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleImpliesExpression_in_entryRuleImpliesExpression5790);
            iv_ruleImpliesExpression=ruleImpliesExpression();
            _fsp--;

             current =iv_ruleImpliesExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImpliesExpression5800); 

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
    // $ANTLR end entryRuleImpliesExpression


    // $ANTLR start ruleImpliesExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3334:1: ruleImpliesExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleImpliesExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3339:6: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3340:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3340:1: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3341:5: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getImpliesExpressionAccess().getLogicalOrExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5847);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();
            _fsp--;

             
                    current = this_LogicalOrExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3349:1: ( () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==50) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3349:2: () '=>' ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3349:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3350:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getImpliesExpressionAccess().getImpliesExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getImpliesExpressionAccess().getImpliesExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,50,FOLLOW_50_in_ruleImpliesExpression5866); 

                            createLeafNode(grammarAccess.getImpliesExpressionAccess().getEqualsSignGreaterThanSignKeyword_1_1(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3369:1: ( (lv_rightOperand_3_0= ruleLogicalOrExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3370:1: (lv_rightOperand_3_0= ruleLogicalOrExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3370:1: (lv_rightOperand_3_0= ruleLogicalOrExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3371:3: lv_rightOperand_3_0= ruleLogicalOrExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getImpliesExpressionAccess().getRightOperandLogicalOrExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5887);
                    lv_rightOperand_3_0=ruleLogicalOrExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getImpliesExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rightOperand",
                    	        		lv_rightOperand_3_0, 
                    	        		"LogicalOrExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleImpliesExpression


    // $ANTLR start entryRuleLogicalOrExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3401:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3402:2: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3403:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5925);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();
            _fsp--;

             current =iv_ruleLogicalOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalOrExpression5935); 

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
    // $ANTLR end entryRuleLogicalOrExpression


    // $ANTLR start ruleLogicalOrExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3410:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3415:6: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3416:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3416:1: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3417:5: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5982);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();
            _fsp--;

             
                    current = this_LogicalAndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3425:1: ( () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+ )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==51) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3425:2: () ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3425:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3426:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3441:2: ( '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) ) )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==51) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3441:4: '||' ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    {
                    	    match(input,51,FOLLOW_51_in_ruleLogicalOrExpression6002); 

                    	            createLeafNode(grammarAccess.getLogicalOrExpressionAccess().getVerticalLineVerticalLineKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3445:1: ( (lv_operands_3_0= ruleLogicalAndExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3446:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3446:1: (lv_operands_3_0= ruleLogicalAndExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3447:3: lv_operands_3_0= ruleLogicalAndExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getOperandsLogicalAndExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6023);
                    	    lv_operands_3_0=ruleLogicalAndExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getLogicalOrExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operands",
                    	    	        		lv_operands_3_0, 
                    	    	        		"LogicalAndExpression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogicalOrExpression


    // $ANTLR start entryRuleLogicalAndExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3477:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3478:2: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3479:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLogicalAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression6063);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();
            _fsp--;

             current =iv_ruleLogicalAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalAndExpression6073); 

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
    // $ANTLR end entryRuleLogicalAndExpression


    // $ANTLR start ruleLogicalAndExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3486:1: ruleLogicalAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EqualityExpression_0 = null;

        EObject lv_operands_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3491:6: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3492:1: (this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3492:1: (this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3493:5: this_EqualityExpression_0= ruleEqualityExpression ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getEqualityExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression6120);
            this_EqualityExpression_0=ruleEqualityExpression();
            _fsp--;

             
                    current = this_EqualityExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3501:1: ( () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+ )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==52) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3501:2: () ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3501:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3502:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionOperandsAction_1_0().getType().getClassifier());
                            try {
                            	factory.add(temp, "operands", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionOperandsAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3517:2: ( '&&' ( (lv_operands_3_0= ruleEqualityExpression ) ) )+
                    int cnt48=0;
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==52) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3517:4: '&&' ( (lv_operands_3_0= ruleEqualityExpression ) )
                    	    {
                    	    match(input,52,FOLLOW_52_in_ruleLogicalAndExpression6140); 

                    	            createLeafNode(grammarAccess.getLogicalAndExpressionAccess().getAmpersandAmpersandKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3521:1: ( (lv_operands_3_0= ruleEqualityExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3522:1: (lv_operands_3_0= ruleEqualityExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3522:1: (lv_operands_3_0= ruleEqualityExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3523:3: lv_operands_3_0= ruleEqualityExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getOperandsEqualityExpressionParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression6161);
                    	    lv_operands_3_0=ruleEqualityExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getLogicalAndExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"operands",
                    	    	        		lv_operands_3_0, 
                    	    	        		"EqualityExpression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt48 >= 1 ) break loop48;
                                EarlyExitException eee =
                                    new EarlyExitException(48, input);
                                throw eee;
                        }
                        cnt48++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogicalAndExpression


    // $ANTLR start entryRuleEqualityExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3553:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3554:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3555:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEqualityExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression6201);
            iv_ruleEqualityExpression=ruleEqualityExpression();
            _fsp--;

             current =iv_ruleEqualityExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression6211); 

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
    // $ANTLR end entryRuleEqualityExpression


    // $ANTLR start ruleEqualityExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3562:1: ruleEqualityExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3567:6: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3568:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3568:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3569:5: this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getRelationalExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression6258);
            this_RelationalExpression_0=ruleRelationalExpression();
            _fsp--;

             
                    current = this_RelationalExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3577:1: ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=68 && LA50_0<=69)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3577:2: () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3577:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3578:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3593:2: ( (lv_operator_2_0= ruleEqualityOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3594:1: (lv_operator_2_0= ruleEqualityOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3594:1: (lv_operator_2_0= ruleEqualityOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3595:3: lv_operator_2_0= ruleEqualityOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorEqualityOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression6288);
                    lv_operator_2_0=ruleEqualityOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_2_0, 
                    	        		"EqualityOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3617:2: ( (lv_rightOperand_3_0= ruleRelationalExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3618:1: (lv_rightOperand_3_0= ruleRelationalExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3618:1: (lv_rightOperand_3_0= ruleRelationalExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3619:3: lv_rightOperand_3_0= ruleRelationalExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightOperandRelationalExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression6309);
                    lv_rightOperand_3_0=ruleRelationalExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEqualityExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"rightOperand",
                    	        		lv_rightOperand_3_0, 
                    	        		"RelationalExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEqualityExpression


    // $ANTLR start entryRuleRelationalExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3649:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3650:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3651:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRelationalExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6347);
            iv_ruleRelationalExpression=ruleRelationalExpression();
            _fsp--;

             current =iv_ruleRelationalExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression6357); 

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
    // $ANTLR end entryRuleRelationalExpression


    // $ANTLR start ruleRelationalExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3658:1: ruleRelationalExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token lv_typeTest_2_0=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_type_3_0 = null;

        Enumerator lv_operator_4_0 = null;

        EObject lv_rightOperand_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3663:6: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3664:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3664:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3665:5: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getAdditiveExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6404);
            this_AdditiveExpression_0=ruleAdditiveExpression();
            _fsp--;

             
                    current = this_AdditiveExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3673:1: ( () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=24 && LA52_0<=25)||LA52_0==53||(LA52_0>=70 && LA52_0<=71)) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3673:2: () ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3673:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3674:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3689:2: ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==53) ) {
                        alt51=1;
                    }
                    else if ( ((LA51_0>=24 && LA51_0<=25)||(LA51_0>=70 && LA51_0<=71)) ) {
                        alt51=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("3689:2: ( ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) ) | ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) ) )", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3689:3: ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3689:3: ( ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3689:4: ( (lv_typeTest_2_0= 'is' ) ) ( (lv_type_3_0= ruleDataTypeSpecifier ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3689:4: ( (lv_typeTest_2_0= 'is' ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3690:1: (lv_typeTest_2_0= 'is' )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3690:1: (lv_typeTest_2_0= 'is' )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3691:3: lv_typeTest_2_0= 'is'
                            {
                            lv_typeTest_2_0=(Token)input.LT(1);
                            match(input,53,FOLLOW_53_in_ruleRelationalExpression6433); 

                                    createLeafNode(grammarAccess.getRelationalExpressionAccess().getTypeTestIsKeyword_1_1_0_0_0(), "typeTest"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "typeTest", true, "is", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3710:2: ( (lv_type_3_0= ruleDataTypeSpecifier ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3711:1: (lv_type_3_0= ruleDataTypeSpecifier )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3711:1: (lv_type_3_0= ruleDataTypeSpecifier )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3712:3: lv_type_3_0= ruleDataTypeSpecifier
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getTypeDataTypeSpecifierParserRuleCall_1_1_0_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6467);
                            lv_type_3_0=ruleDataTypeSpecifier();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"type",
                            	        		lv_type_3_0, 
                            	        		"DataTypeSpecifier", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3735:6: ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3735:6: ( ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3735:7: ( (lv_operator_4_0= ruleRelationalOperator ) ) ( (lv_rightOperand_5_0= ruleAdditiveExpression ) )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3735:7: ( (lv_operator_4_0= ruleRelationalOperator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3736:1: (lv_operator_4_0= ruleRelationalOperator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3736:1: (lv_operator_4_0= ruleRelationalOperator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3737:3: lv_operator_4_0= ruleRelationalOperator
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_1_0_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6496);
                            lv_operator_4_0=ruleRelationalOperator();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"operator",
                            	        		lv_operator_4_0, 
                            	        		"RelationalOperator", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3759:2: ( (lv_rightOperand_5_0= ruleAdditiveExpression ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3760:1: (lv_rightOperand_5_0= ruleAdditiveExpression )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3760:1: (lv_rightOperand_5_0= ruleAdditiveExpression )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3761:3: lv_rightOperand_5_0= ruleAdditiveExpression
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getRelationalExpressionAccess().getRightOperandAdditiveExpressionParserRuleCall_1_1_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6517);
                            lv_rightOperand_5_0=ruleAdditiveExpression();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getRelationalExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"rightOperand",
                            	        		lv_rightOperand_5_0, 
                            	        		"AdditiveExpression", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRelationalExpression


    // $ANTLR start entryRuleAdditiveExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3791:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3792:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3793:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6557);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();
            _fsp--;

             current =iv_ruleAdditiveExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression6567); 

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
    // $ANTLR end entryRuleAdditiveExpression


    // $ANTLR start ruleAdditiveExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3800:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_rightParts_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3805:6: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3806:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3806:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3807:5: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6614);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();
            _fsp--;

             
                    current = this_MultiplicativeExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3815:1: ( () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+ )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==63||LA54_0==72) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3815:2: () ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3815:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3816:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3831:2: ( (lv_rightParts_2_0= ruleAdditiveExpressionPart ) )+
                    int cnt53=0;
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==63||LA53_0==72) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3832:1: (lv_rightParts_2_0= ruleAdditiveExpressionPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3832:1: (lv_rightParts_2_0= ruleAdditiveExpressionPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3833:3: lv_rightParts_2_0= ruleAdditiveExpressionPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightPartsAdditiveExpressionPartParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6644);
                    	    lv_rightParts_2_0=ruleAdditiveExpressionPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAdditiveExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"rightParts",
                    	    	        		lv_rightParts_2_0, 
                    	    	        		"AdditiveExpressionPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt53 >= 1 ) break loop53;
                                EarlyExitException eee =
                                    new EarlyExitException(53, input);
                                throw eee;
                        }
                        cnt53++;
                    } while (true);


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAdditiveExpression


    // $ANTLR start entryRuleAdditiveExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3863:1: entryRuleAdditiveExpressionPart returns [EObject current=null] : iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF ;
    public final EObject entryRuleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpressionPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3864:2: (iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3865:2: iv_ruleAdditiveExpressionPart= ruleAdditiveExpressionPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAdditiveExpressionPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6683);
            iv_ruleAdditiveExpressionPart=ruleAdditiveExpressionPart();
            _fsp--;

             current =iv_ruleAdditiveExpressionPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6693); 

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
    // $ANTLR end entryRuleAdditiveExpressionPart


    // $ANTLR start ruleAdditiveExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3872:1: ruleAdditiveExpressionPart returns [EObject current=null] : ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) ) ;
    public final EObject ruleAdditiveExpressionPart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3877:6: ( ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3878:1: ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3878:1: ( ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3878:2: ( (lv_operator_0_0= ruleAdditiveOperator ) ) ( (lv_operand_1_0= ruleMultiplicativeExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3878:2: ( (lv_operator_0_0= ruleAdditiveOperator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3879:1: (lv_operator_0_0= ruleAdditiveOperator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3879:1: (lv_operator_0_0= ruleAdditiveOperator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3880:3: lv_operator_0_0= ruleAdditiveOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOperatorAdditiveOperatorEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6739);
            lv_operator_0_0=ruleAdditiveOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAdditiveExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_0_0, 
            	        		"AdditiveOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3902:2: ( (lv_operand_1_0= ruleMultiplicativeExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3903:1: (lv_operand_1_0= ruleMultiplicativeExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3903:1: (lv_operand_1_0= ruleMultiplicativeExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3904:3: lv_operand_1_0= ruleMultiplicativeExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getAdditiveExpressionPartAccess().getOperandMultiplicativeExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6760);
            lv_operand_1_0=ruleMultiplicativeExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAdditiveExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_1_0, 
            	        		"MultiplicativeExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAdditiveExpressionPart


    // $ANTLR start entryRuleMultiplicativeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3934:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3935:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3936:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6796);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();
            _fsp--;

             current =iv_ruleMultiplicativeExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression6806); 

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
    // $ANTLR end entryRuleMultiplicativeExpression


    // $ANTLR start ruleMultiplicativeExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3943:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PowerExpression_0 = null;

        EObject lv_rightParts_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3948:6: ( (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3949:1: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3949:1: (this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3950:5: this_PowerExpression_0= rulePowerExpression ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getPowerExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpression6853);
            this_PowerExpression_0=rulePowerExpression();
            _fsp--;

             
                    current = this_PowerExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3958:1: ( () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+ )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=60 && LA56_0<=61)||(LA56_0>=73 && LA56_0<=74)) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3958:2: () ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3958:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3959:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "leftOperand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3974:2: ( (lv_rightParts_2_0= ruleMultiplicativeExpressionPart ) )+
                    int cnt55=0;
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( ((LA55_0>=60 && LA55_0<=61)||(LA55_0>=73 && LA55_0<=74)) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3975:1: (lv_rightParts_2_0= ruleMultiplicativeExpressionPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3975:1: (lv_rightParts_2_0= ruleMultiplicativeExpressionPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:3976:3: lv_rightParts_2_0= ruleMultiplicativeExpressionPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightPartsMultiplicativeExpressionPartParserRuleCall_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6883);
                    	    lv_rightParts_2_0=ruleMultiplicativeExpressionPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getMultiplicativeExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"rightParts",
                    	    	        		lv_rightParts_2_0, 
                    	    	        		"MultiplicativeExpressionPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMultiplicativeExpression


    // $ANTLR start entryRuleMultiplicativeExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4006:1: entryRuleMultiplicativeExpressionPart returns [EObject current=null] : iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF ;
    public final EObject entryRuleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpressionPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4007:2: (iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4008:2: iv_ruleMultiplicativeExpressionPart= ruleMultiplicativeExpressionPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiplicativeExpressionPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6922);
            iv_ruleMultiplicativeExpressionPart=ruleMultiplicativeExpressionPart();
            _fsp--;

             current =iv_ruleMultiplicativeExpressionPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6932); 

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
    // $ANTLR end entryRuleMultiplicativeExpressionPart


    // $ANTLR start ruleMultiplicativeExpressionPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4015:1: ruleMultiplicativeExpressionPart returns [EObject current=null] : ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) ) ;
    public final EObject ruleMultiplicativeExpressionPart() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4020:6: ( ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4021:1: ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4021:1: ( ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4021:2: ( (lv_operator_0_0= ruleMultiplicativeOperator ) ) ( (lv_operand_1_0= rulePowerExpression ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4021:2: ( (lv_operator_0_0= ruleMultiplicativeOperator ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4022:1: (lv_operator_0_0= ruleMultiplicativeOperator )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4022:1: (lv_operator_0_0= ruleMultiplicativeOperator )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4023:3: lv_operator_0_0= ruleMultiplicativeOperator
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOperatorMultiplicativeOperatorEnumRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6978);
            lv_operator_0_0=ruleMultiplicativeOperator();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicativeExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operator",
            	        		lv_operator_0_0, 
            	        		"MultiplicativeOperator", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4045:2: ( (lv_operand_1_0= rulePowerExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4046:1: (lv_operand_1_0= rulePowerExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4046:1: (lv_operand_1_0= rulePowerExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4047:3: lv_operand_1_0= rulePowerExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiplicativeExpressionPartAccess().getOperandPowerExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpressionPart6999);
            lv_operand_1_0=rulePowerExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMultiplicativeExpressionPartRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_1_0, 
            	        		"PowerExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMultiplicativeExpressionPart


    // $ANTLR start entryRulePowerExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4077:1: entryRulePowerExpression returns [EObject current=null] : iv_rulePowerExpression= rulePowerExpression EOF ;
    public final EObject entryRulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4078:2: (iv_rulePowerExpression= rulePowerExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4079:2: iv_rulePowerExpression= rulePowerExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPowerExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePowerExpression_in_entryRulePowerExpression7035);
            iv_rulePowerExpression=rulePowerExpression();
            _fsp--;

             current =iv_rulePowerExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePowerExpression7045); 

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
    // $ANTLR end entryRulePowerExpression


    // $ANTLR start rulePowerExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4086:1: rulePowerExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? ) ;
    public final EObject rulePowerExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_exponent_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4091:6: ( (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4092:1: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4092:1: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4093:5: this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getUnaryExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleUnaryExpression_in_rulePowerExpression7092);
            this_UnaryExpression_0=ruleUnaryExpression();
            _fsp--;

             
                    current = this_UnaryExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4101:1: ( () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==62||LA57_0==75) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4101:2: () ( (lv_operator_2_0= rulePowerOperator ) ) ( (lv_exponent_3_0= ruleUnaryExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4101:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4102:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPowerExpressionAccess().getPowerExpressionOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "operand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPowerExpressionAccess().getPowerExpressionOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4117:2: ( (lv_operator_2_0= rulePowerOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4118:1: (lv_operator_2_0= rulePowerOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4118:1: (lv_operator_2_0= rulePowerOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4119:3: lv_operator_2_0= rulePowerOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getOperatorPowerOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePowerOperator_in_rulePowerExpression7122);
                    lv_operator_2_0=rulePowerOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPowerExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_2_0, 
                    	        		"PowerOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4141:2: ( (lv_exponent_3_0= ruleUnaryExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4142:1: (lv_exponent_3_0= ruleUnaryExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4142:1: (lv_exponent_3_0= ruleUnaryExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4143:3: lv_exponent_3_0= ruleUnaryExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPowerExpressionAccess().getExponentUnaryExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryExpression_in_rulePowerExpression7143);
                    lv_exponent_3_0=ruleUnaryExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPowerExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exponent",
                    	        		lv_exponent_3_0, 
                    	        		"UnaryExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePowerExpression


    // $ANTLR start entryRuleUnaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4173:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4174:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4175:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression7181);
            iv_ruleUnaryExpression=ruleUnaryExpression();
            _fsp--;

             current =iv_ruleUnaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression7191); 

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
    // $ANTLR end entryRuleUnaryExpression


    // $ANTLR start ruleUnaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4182:1: ruleUnaryExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PostfixExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4187:6: ( (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4188:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4188:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_REAL && LA58_0<=RULE_ID)||LA58_0==26||LA58_0==33||LA58_0==41||(LA58_0>=57 && LA58_0<=58)||(LA58_0>=78 && LA58_0<=79)) ) {
                alt58=1;
            }
            else if ( (LA58_0==63||LA58_0==76) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4188:1: (this_PostfixExpression_0= rulePostfixExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) ) )", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4189:5: this_PostfixExpression_0= rulePostfixExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixExpressionParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression7238);
                    this_PostfixExpression_0=rulePostfixExpression();
                    _fsp--;

                     
                            current = this_PostfixExpression_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4198:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4198:6: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4198:7: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= rulePostfixExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4198:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4199:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryExpressionAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4209:2: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4210:1: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4210:1: (lv_operator_2_0= ruleUnaryOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4211:3: lv_operator_2_0= ruleUnaryOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression7274);
                    lv_operator_2_0=ruleUnaryOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_2_0, 
                    	        		"UnaryOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4233:2: ( (lv_operand_3_0= rulePostfixExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4234:1: (lv_operand_3_0= rulePostfixExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4234:1: (lv_operand_3_0= rulePostfixExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4235:3: lv_operand_3_0= rulePostfixExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnaryExpressionAccess().getOperandPostfixExpressionParserRuleCall_1_2_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePostfixExpression_in_ruleUnaryExpression7295);
                    lv_operand_3_0=rulePostfixExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnaryExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operand",
                    	        		lv_operand_3_0, 
                    	        		"PostfixExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnaryExpression


    // $ANTLR start entryRulePostfixExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4265:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4266:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4267:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPostfixExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression7332);
            iv_rulePostfixExpression=rulePostfixExpression();
            _fsp--;

             current =iv_rulePostfixExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression7342); 

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
    // $ANTLR end entryRulePostfixExpression


    // $ANTLR start rulePostfixExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4274:1: rulePostfixExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4279:6: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4280:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4280:1: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4281:5: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getPostfixExpressionAccess().getPrimaryExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixExpression7389);
            this_PrimaryExpression_0=rulePrimaryExpression();
            _fsp--;

             
                    current = this_PrimaryExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4289:1: ( () ( (lv_operator_2_0= rulePostfixOperator ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==77) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4289:2: () ( (lv_operator_2_0= rulePostfixOperator ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4289:2: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4290:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getPostfixExpressionAccess().getPostfixExpressionOperandAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "operand", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getPostfixExpressionAccess().getPostfixExpressionOperandAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4305:2: ( (lv_operator_2_0= rulePostfixOperator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4306:1: (lv_operator_2_0= rulePostfixOperator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4306:1: (lv_operator_2_0= rulePostfixOperator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4307:3: lv_operator_2_0= rulePostfixOperator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getPostfixExpressionAccess().getOperatorPostfixOperatorEnumRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_rulePostfixOperator_in_rulePostfixExpression7419);
                    lv_operator_2_0=rulePostfixOperator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getPostfixExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"operator",
                    	        		lv_operator_2_0, 
                    	        		"PostfixOperator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePostfixExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4337:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4338:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4339:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7457);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression7467); 

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
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4346:1: rulePrimaryExpression returns [EObject current=null] : (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_UnitConstructionOperator_2 = null;

        EObject this_BeginExpression_3 = null;

        EObject this_EndExpression_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4351:6: ( (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4352:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4352:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression )
            int alt60=5;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
            case RULE_STRING:
            case 78:
            case 79:
                {
                alt60=1;
                }
                break;
            case RULE_ID:
            case 26:
            case 33:
                {
                alt60=2;
                }
                break;
            case 41:
                {
                alt60=3;
                }
                break;
            case 57:
                {
                alt60=4;
                }
                break;
            case 58:
                {
                alt60=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4352:1: (this_Literal_0= ruleLiteral | this_FeatureCall_1= ruleFeatureCall | this_UnitConstructionOperator_2= ruleUnitConstructionOperator | this_BeginExpression_3= ruleBeginExpression | this_EndExpression_4= ruleEndExpression )", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4353:5: this_Literal_0= ruleLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleLiteral_in_rulePrimaryExpression7514);
                    this_Literal_0=ruleLiteral();
                    _fsp--;

                     
                            current = this_Literal_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4363:5: this_FeatureCall_1= ruleFeatureCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureCall_in_rulePrimaryExpression7541);
                    this_FeatureCall_1=ruleFeatureCall();
                    _fsp--;

                     
                            current = this_FeatureCall_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4373:5: this_UnitConstructionOperator_2= ruleUnitConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getUnitConstructionOperatorParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression7568);
                    this_UnitConstructionOperator_2=ruleUnitConstructionOperator();
                    _fsp--;

                     
                            current = this_UnitConstructionOperator_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4383:5: this_BeginExpression_3= ruleBeginExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBeginExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBeginExpression_in_rulePrimaryExpression7595);
                    this_BeginExpression_3=ruleBeginExpression();
                    _fsp--;

                     
                            current = this_BeginExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4393:5: this_EndExpression_4= ruleEndExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getEndExpressionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEndExpression_in_rulePrimaryExpression7622);
                    this_EndExpression_4=ruleEndExpression();
                    _fsp--;

                     
                            current = this_EndExpression_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleCallablePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4409:1: entryRuleCallablePrimaryExpression returns [EObject current=null] : iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF ;
    public final EObject entryRuleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallablePrimaryExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4410:2: (iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4411:2: iv_ruleCallablePrimaryExpression= ruleCallablePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallablePrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression7657);
            iv_ruleCallablePrimaryExpression=ruleCallablePrimaryExpression();
            _fsp--;

             current =iv_ruleCallablePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallablePrimaryExpression7667); 

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
    // $ANTLR end entryRuleCallablePrimaryExpression


    // $ANTLR start ruleCallablePrimaryExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4418:1: ruleCallablePrimaryExpression returns [EObject current=null] : (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_ParenthesizedExpression_1= ruleParenthesizedExpression ) ;
    public final EObject ruleCallablePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MatrixConstructionOperator_0 = null;

        EObject this_ParenthesizedExpression_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4423:6: ( (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_ParenthesizedExpression_1= ruleParenthesizedExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4424:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_ParenthesizedExpression_1= ruleParenthesizedExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4424:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_ParenthesizedExpression_1= ruleParenthesizedExpression )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==33) ) {
                alt61=1;
            }
            else if ( (LA61_0==26) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4424:1: (this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator | this_ParenthesizedExpression_1= ruleParenthesizedExpression )", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4425:5: this_MatrixConstructionOperator_0= ruleMatrixConstructionOperator
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getMatrixConstructionOperatorParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleMatrixConstructionOperator_in_ruleCallablePrimaryExpression7714);
                    this_MatrixConstructionOperator_0=ruleMatrixConstructionOperator();
                    _fsp--;

                     
                            current = this_MatrixConstructionOperator_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4435:5: this_ParenthesizedExpression_1= ruleParenthesizedExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getCallablePrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression7741);
                    this_ParenthesizedExpression_1=ruleParenthesizedExpression();
                    _fsp--;

                     
                            current = this_ParenthesizedExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCallablePrimaryExpression


    // $ANTLR start entryRuleLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4451:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4452:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4453:2: iv_ruleLiteral= ruleLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral7776);
            iv_ruleLiteral=ruleLiteral();
            _fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral7786); 

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
    // $ANTLR end entryRuleLiteral


    // $ANTLR start ruleLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4460:1: ruleLiteral returns [EObject current=null] : (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_NumericLiteral_0 = null;

        EObject this_BooleanLiteral_1 = null;

        EObject this_StringLiteral_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4465:6: ( (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4466:1: (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4466:1: (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )
            int alt62=3;
            switch ( input.LA(1) ) {
            case RULE_REAL:
            case RULE_INTEGER:
                {
                alt62=1;
                }
                break;
            case 78:
            case 79:
                {
                alt62=2;
                }
                break;
            case RULE_STRING:
                {
                alt62=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("4466:1: (this_NumericLiteral_0= ruleNumericLiteral | this_BooleanLiteral_1= ruleBooleanLiteral | this_StringLiteral_2= ruleStringLiteral )", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4467:5: this_NumericLiteral_0= ruleNumericLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getNumericLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNumericLiteral_in_ruleLiteral7833);
                    this_NumericLiteral_0=ruleNumericLiteral();
                    _fsp--;

                     
                            current = this_NumericLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4477:5: this_BooleanLiteral_1= ruleBooleanLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getBooleanLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_ruleLiteral7860);
                    this_BooleanLiteral_1=ruleBooleanLiteral();
                    _fsp--;

                     
                            current = this_BooleanLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4487:5: this_StringLiteral_2= ruleStringLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleLiteral7887);
                    this_StringLiteral_2=ruleStringLiteral();
                    _fsp--;

                     
                            current = this_StringLiteral_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLiteral


    // $ANTLR start entryRuleNumericLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4503:1: entryRuleNumericLiteral returns [EObject current=null] : iv_ruleNumericLiteral= ruleNumericLiteral EOF ;
    public final EObject entryRuleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4504:2: (iv_ruleNumericLiteral= ruleNumericLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4505:2: iv_ruleNumericLiteral= ruleNumericLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNumericLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleNumericLiteral_in_entryRuleNumericLiteral7922);
            iv_ruleNumericLiteral=ruleNumericLiteral();
            _fsp--;

             current =iv_ruleNumericLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericLiteral7932); 

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
    // $ANTLR end entryRuleNumericLiteral


    // $ANTLR start ruleNumericLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4512:1: ruleNumericLiteral returns [EObject current=null] : (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) ;
    public final EObject ruleNumericLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_RealLiteral_0 = null;

        EObject this_IntegerLiteral_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4517:6: ( (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4518:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4518:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_REAL) ) {
                alt63=1;
            }
            else if ( (LA63_0==RULE_INTEGER) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4518:1: (this_RealLiteral_0= ruleRealLiteral | this_IntegerLiteral_1= ruleIntegerLiteral )", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4519:5: this_RealLiteral_0= ruleRealLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericLiteralAccess().getRealLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleRealLiteral_in_ruleNumericLiteral7979);
                    this_RealLiteral_0=ruleRealLiteral();
                    _fsp--;

                     
                            current = this_RealLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4529:5: this_IntegerLiteral_1= ruleIntegerLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNumericLiteralAccess().getIntegerLiteralParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIntegerLiteral_in_ruleNumericLiteral8006);
                    this_IntegerLiteral_1=ruleIntegerLiteral();
                    _fsp--;

                     
                            current = this_IntegerLiteral_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNumericLiteral


    // $ANTLR start entryRuleRealLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4545:1: entryRuleRealLiteral returns [EObject current=null] : iv_ruleRealLiteral= ruleRealLiteral EOF ;
    public final EObject entryRuleRealLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4546:2: (iv_ruleRealLiteral= ruleRealLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4547:2: iv_ruleRealLiteral= ruleRealLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRealLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral8041);
            iv_ruleRealLiteral=ruleRealLiteral();
            _fsp--;

             current =iv_ruleRealLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteral8051); 

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
    // $ANTLR end entryRuleRealLiteral


    // $ANTLR start ruleRealLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4554:1: ruleRealLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleRealLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_imaginary_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4559:6: ( ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4560:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4560:1: ( ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4560:2: ( (lv_value_0_0= RULE_REAL ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4560:2: ( (lv_value_0_0= RULE_REAL ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4561:1: (lv_value_0_0= RULE_REAL )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4561:1: (lv_value_0_0= RULE_REAL )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4562:3: lv_value_0_0= RULE_REAL
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_REAL,FOLLOW_RULE_REAL_in_ruleRealLiteral8093); 

            			createLeafNode(grammarAccess.getRealLiteralAccess().getValueREALTerminalRuleCall_0_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"REAL", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4584:2: ( (lv_imaginary_1_0= 'j' ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==54) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4585:1: (lv_imaginary_1_0= 'j' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4585:1: (lv_imaginary_1_0= 'j' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4586:3: lv_imaginary_1_0= 'j'
                    {
                    lv_imaginary_1_0=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleRealLiteral8116); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getImaginaryJKeyword_1_0(), "imaginary"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "imaginary", true, "j", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4605:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==26) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4605:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleRealLiteral8141); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4609:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4610:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4610:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4611:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRealLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleRealLiteral8162);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRealLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,27,FOLLOW_27_in_ruleRealLiteral8172); 

                            createLeafNode(grammarAccess.getRealLiteralAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRealLiteral


    // $ANTLR start entryRuleIntegerLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4645:1: entryRuleIntegerLiteral returns [EObject current=null] : iv_ruleIntegerLiteral= ruleIntegerLiteral EOF ;
    public final EObject entryRuleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4646:2: (iv_ruleIntegerLiteral= ruleIntegerLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4647:2: iv_ruleIntegerLiteral= ruleIntegerLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIntegerLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral8210);
            iv_ruleIntegerLiteral=ruleIntegerLiteral();
            _fsp--;

             current =iv_ruleIntegerLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerLiteral8220); 

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
    // $ANTLR end entryRuleIntegerLiteral


    // $ANTLR start ruleIntegerLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4654:1: ruleIntegerLiteral returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) ;
    public final EObject ruleIntegerLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_imaginary_1_0=null;
        EObject lv_unit_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4659:6: ( ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4660:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4660:1: ( ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4660:2: ( (lv_value_0_0= RULE_INTEGER ) ) ( (lv_imaginary_1_0= 'j' ) )? ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4660:2: ( (lv_value_0_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4661:1: (lv_value_0_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4661:1: (lv_value_0_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4662:3: lv_value_0_0= RULE_INTEGER
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral8262); 

            			createLeafNode(grammarAccess.getIntegerLiteralAccess().getValueINTEGERTerminalRuleCall_0_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"INTEGER", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4684:2: ( (lv_imaginary_1_0= 'j' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==54) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4685:1: (lv_imaginary_1_0= 'j' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4685:1: (lv_imaginary_1_0= 'j' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4686:3: lv_imaginary_1_0= 'j'
                    {
                    lv_imaginary_1_0=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleIntegerLiteral8285); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getImaginaryJKeyword_1_0(), "imaginary"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "imaginary", true, "j", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4705:3: ( '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==26) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4705:5: '(' ( (lv_unit_3_0= ruleUnitExpression ) ) ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleIntegerLiteral8310); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getLeftParenthesisKeyword_2_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4709:1: ( (lv_unit_3_0= ruleUnitExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4710:1: (lv_unit_3_0= ruleUnitExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4710:1: (lv_unit_3_0= ruleUnitExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4711:3: lv_unit_3_0= ruleUnitExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIntegerLiteralAccess().getUnitUnitExpressionParserRuleCall_2_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral8331);
                    lv_unit_3_0=ruleUnitExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIntegerLiteralRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"unit",
                    	        		lv_unit_3_0, 
                    	        		"UnitExpression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,27,FOLLOW_27_in_ruleIntegerLiteral8341); 

                            createLeafNode(grammarAccess.getIntegerLiteralAccess().getRightParenthesisKeyword_2_2(), null); 
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIntegerLiteral


    // $ANTLR start entryRuleBooleanLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4745:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4746:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4747:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8379);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral8389); 

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
    // $ANTLR end entryRuleBooleanLiteral


    // $ANTLR start ruleBooleanLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4754:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleBooleanKind ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_value_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4759:6: ( ( (lv_value_0_0= ruleBooleanKind ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4760:1: ( (lv_value_0_0= ruleBooleanKind ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4760:1: ( (lv_value_0_0= ruleBooleanKind ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4761:1: (lv_value_0_0= ruleBooleanKind )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4761:1: (lv_value_0_0= ruleBooleanKind )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4762:3: lv_value_0_0= ruleBooleanKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getBooleanLiteralAccess().getValueBooleanKindEnumRuleCall_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral8434);
            lv_value_0_0=ruleBooleanKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"BooleanKind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanLiteral


    // $ANTLR start entryRuleStringLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4792:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4793:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4794:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral8469);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral8479); 

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
    // $ANTLR end entryRuleStringLiteral


    // $ANTLR start ruleStringLiteral
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4801:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4806:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4807:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4807:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4808:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4808:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4809:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral8520); 

            			createLeafNode(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStringLiteral


    // $ANTLR start entryRuleFeatureCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4839:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4840:2: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4841:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall8560);
            iv_ruleFeatureCall=ruleFeatureCall();
            _fsp--;

             current =iv_ruleFeatureCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCall8570); 

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
    // $ANTLR end entryRuleFeatureCall


    // $ANTLR start ruleFeatureCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4848:1: ruleFeatureCall returns [EObject current=null] : ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject this_CallablePrimaryExpression_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_target_4_0 = null;

        EObject lv_parts_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4853:6: ( ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4854:1: ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4854:1: ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==26||LA71_0==33) ) {
                alt71=1;
            }
            else if ( (LA71_0==RULE_ID) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("4854:1: ( (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? ) | ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* ) )", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4854:2: (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4854:2: (this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4855:5: this_CallablePrimaryExpression_0= ruleCallablePrimaryExpression ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )?
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getCallablePrimaryExpressionParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall8618);
                    this_CallablePrimaryExpression_0=ruleCallablePrimaryExpression();
                    _fsp--;

                     
                            current = this_CallablePrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4863:1: ( () ( (lv_parts_2_0= ruleFeatureCallPart ) )+ )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==26||LA69_0==33||LA69_0==55) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4863:2: () ( (lv_parts_2_0= ruleFeatureCallPart ) )+
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4863:2: ()
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4864:5: 
                            {
                             
                                    temp=factory.create(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_0_1_0().getType().getClassifier());
                                    try {
                                    	factory.set(temp, "target", current, null /*ParserRule*/, currentNode);
                                    } catch(ValueConverterException vce) {
                                    	handleValueConverterException(vce);
                                    }
                                    current = temp; 
                                    temp = null;
                                    CompositeNode newNode = createCompositeNode(grammarAccess.getFeatureCallAccess().getFeatureCallTargetAction_0_1_0(), currentNode.getParent());
                                newNode.getChildren().add(currentNode);
                                moveLookaheadInfo(currentNode, newNode);
                                currentNode = newNode; 
                                    associateNodeWithAstElement(currentNode, current); 
                                

                            }

                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4879:2: ( (lv_parts_2_0= ruleFeatureCallPart ) )+
                            int cnt68=0;
                            loop68:
                            do {
                                int alt68=2;
                                int LA68_0 = input.LA(1);

                                if ( (LA68_0==26||LA68_0==33||LA68_0==55) ) {
                                    alt68=1;
                                }


                                switch (alt68) {
                            	case 1 :
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4880:1: (lv_parts_2_0= ruleFeatureCallPart )
                            	    {
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4880:1: (lv_parts_2_0= ruleFeatureCallPart )
                            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4881:3: lv_parts_2_0= ruleFeatureCallPart
                            	    {
                            	     
                            	    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPartsFeatureCallPartParserRuleCall_0_1_1_0(), currentNode); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8648);
                            	    lv_parts_2_0=ruleFeatureCallPart();
                            	    _fsp--;


                            	    	        if (current==null) {
                            	    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	    	        }
                            	    	        try {
                            	    	       		add(
                            	    	       			current, 
                            	    	       			"parts",
                            	    	        		lv_parts_2_0, 
                            	    	        		"FeatureCallPart", 
                            	    	        		currentNode);
                            	    	        } catch (ValueConverterException vce) {
                            	    				handleValueConverterException(vce);
                            	    	        }
                            	    	        currentNode = currentNode.getParent();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt68 >= 1 ) break loop68;
                                        EarlyExitException eee =
                                            new EarlyExitException(68, input);
                                        throw eee;
                                }
                                cnt68++;
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4904:6: ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4904:6: ( () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4904:7: () ( (lv_target_4_0= ruleSimpleName ) ) ( (lv_parts_5_0= ruleFeatureCallPart ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4904:7: ()
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4905:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getFeatureCallAccess().getFeatureCallAction_1_0().getType().getClassifier());
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getFeatureCallAccess().getFeatureCallAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4915:2: ( (lv_target_4_0= ruleSimpleName ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4916:1: (lv_target_4_0= ruleSimpleName )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4916:1: (lv_target_4_0= ruleSimpleName )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4917:3: lv_target_4_0= ruleSimpleName
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getTargetSimpleNameParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleSimpleName_in_ruleFeatureCall8689);
                    lv_target_4_0=ruleSimpleName();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"target",
                    	        		lv_target_4_0, 
                    	        		"SimpleName", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4939:2: ( (lv_parts_5_0= ruleFeatureCallPart ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==26||LA70_0==33||LA70_0==55) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4940:1: (lv_parts_5_0= ruleFeatureCallPart )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4940:1: (lv_parts_5_0= ruleFeatureCallPart )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4941:3: lv_parts_5_0= ruleFeatureCallPart
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getFeatureCallAccess().getPartsFeatureCallPartParserRuleCall_1_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8710);
                    	    lv_parts_5_0=ruleFeatureCallPart();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getFeatureCallRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"parts",
                    	    	        		lv_parts_5_0, 
                    	    	        		"FeatureCallPart", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop70;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFeatureCall


    // $ANTLR start entryRuleSimpleName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4971:1: entryRuleSimpleName returns [EObject current=null] : iv_ruleSimpleName= ruleSimpleName EOF ;
    public final EObject entryRuleSimpleName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4972:2: (iv_ruleSimpleName= ruleSimpleName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4973:2: iv_ruleSimpleName= ruleSimpleName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleName_in_entryRuleSimpleName8748);
            iv_ruleSimpleName=ruleSimpleName();
            _fsp--;

             current =iv_ruleSimpleName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleName8758); 

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
    // $ANTLR end entryRuleSimpleName


    // $ANTLR start ruleSimpleName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4980:1: ruleSimpleName returns [EObject current=null] : ( () ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleName() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4985:6: ( ( () ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4986:1: ( () ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4986:1: ( () ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4986:2: () ( (lv_identifier_1_0= RULE_ID ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4986:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4987:5: 
            {
             
                    temp=factory.create(grammarAccess.getSimpleNameAccess().getSimpleNameAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getSimpleNameAccess().getSimpleNameAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4997:2: ( (lv_identifier_1_0= RULE_ID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4998:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4998:1: (lv_identifier_1_0= RULE_ID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:4999:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleName8809); 

            			createLeafNode(grammarAccess.getSimpleNameAccess().getIdentifierIDTerminalRuleCall_1_0(), "identifier"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"identifier",
            	        		lv_identifier_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSimpleName


    // $ANTLR start entryRuleFeatureCallPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5029:1: entryRuleFeatureCallPart returns [EObject current=null] : iv_ruleFeatureCallPart= ruleFeatureCallPart EOF ;
    public final EObject entryRuleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallPart = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5030:2: (iv_ruleFeatureCallPart= ruleFeatureCallPart EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5031:2: iv_ruleFeatureCallPart= ruleFeatureCallPart EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureCallPartRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart8850);
            iv_ruleFeatureCallPart=ruleFeatureCallPart();
            _fsp--;

             current =iv_ruleFeatureCallPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCallPart8860); 

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
    // $ANTLR end entryRuleFeatureCallPart


    // $ANTLR start ruleFeatureCallPart
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5038:1: ruleFeatureCallPart returns [EObject current=null] : (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall | this_IteratorCall_3= ruleIteratorCall ) ;
    public final EObject ruleFeatureCallPart() throws RecognitionException {
        EObject current = null;

        EObject this_FeatureReference_0 = null;

        EObject this_ArrayElementReference_1 = null;

        EObject this_OperationCall_2 = null;

        EObject this_IteratorCall_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5043:6: ( (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall | this_IteratorCall_3= ruleIteratorCall ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5044:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall | this_IteratorCall_3= ruleIteratorCall )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5044:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall | this_IteratorCall_3= ruleIteratorCall )
            int alt72=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt72=1;
                }
                break;
            case 33:
                {
                alt72=2;
                }
                break;
            case 26:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    int LA72_4 = input.LA(3);

                    if ( (LA72_4==16||LA72_4==21||(LA72_4>=24 && LA72_4<=27)||LA72_4==33||(LA72_4>=50 && LA72_4<=53)||LA72_4==55||(LA72_4>=60 && LA72_4<=63)||(LA72_4>=68 && LA72_4<=75)||LA72_4==77) ) {
                        alt72=3;
                    }
                    else if ( (LA72_4==19||LA72_4==56) ) {
                        alt72=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("5044:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall | this_IteratorCall_3= ruleIteratorCall )", 72, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 54:
                    {
                    alt72=4;
                    }
                    break;
                case RULE_REAL:
                case RULE_INTEGER:
                case RULE_STRING:
                case 26:
                case 27:
                case 33:
                case 41:
                case 42:
                case 44:
                case 47:
                case 57:
                case 58:
                case 63:
                case 76:
                case 78:
                case 79:
                    {
                    alt72=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("5044:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall | this_IteratorCall_3= ruleIteratorCall )", 72, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("5044:1: (this_FeatureReference_0= ruleFeatureReference | this_ArrayElementReference_1= ruleArrayElementReference | this_OperationCall_2= ruleOperationCall | this_IteratorCall_3= ruleIteratorCall )", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5045:5: this_FeatureReference_0= ruleFeatureReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getFeatureReferenceParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFeatureReference_in_ruleFeatureCallPart8907);
                    this_FeatureReference_0=ruleFeatureReference();
                    _fsp--;

                     
                            current = this_FeatureReference_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5055:5: this_ArrayElementReference_1= ruleArrayElementReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getArrayElementReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleArrayElementReference_in_ruleFeatureCallPart8934);
                    this_ArrayElementReference_1=ruleArrayElementReference();
                    _fsp--;

                     
                            current = this_ArrayElementReference_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5065:5: this_OperationCall_2= ruleOperationCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getOperationCallParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOperationCall_in_ruleFeatureCallPart8961);
                    this_OperationCall_2=ruleOperationCall();
                    _fsp--;

                     
                            current = this_OperationCall_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5075:5: this_IteratorCall_3= ruleIteratorCall
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureCallPartAccess().getIteratorCallParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIteratorCall_in_ruleFeatureCallPart8988);
                    this_IteratorCall_3=ruleIteratorCall();
                    _fsp--;

                     
                            current = this_IteratorCall_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFeatureCallPart


    // $ANTLR start entryRuleFeatureReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5091:1: entryRuleFeatureReference returns [EObject current=null] : iv_ruleFeatureReference= ruleFeatureReference EOF ;
    public final EObject entryRuleFeatureReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5092:2: (iv_ruleFeatureReference= ruleFeatureReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5093:2: iv_ruleFeatureReference= ruleFeatureReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference9023);
            iv_ruleFeatureReference=ruleFeatureReference();
            _fsp--;

             current =iv_ruleFeatureReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureReference9033); 

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
    // $ANTLR end entryRuleFeatureReference


    // $ANTLR start ruleFeatureReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5100:1: ruleFeatureReference returns [EObject current=null] : ( '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) ) ) ;
    public final EObject ruleFeatureReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5105:6: ( ( '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5106:1: ( '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5106:1: ( '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5106:3: '.' ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) )
            {
            match(input,55,FOLLOW_55_in_ruleFeatureReference9068); 

                    createLeafNode(grammarAccess.getFeatureReferenceAccess().getFullStopKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5110:1: ( ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5111:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5111:1: ( (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5112:1: (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5112:1: (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID) ) {
                alt73=1;
            }
            else if ( (LA73_0==41) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5112:1: (lv_name_1_1= RULE_ID | lv_name_1_2= 'unit' )", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5113:3: lv_name_1_1= RULE_ID
                    {
                    lv_name_1_1=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureReference9087); 

                    			createLeafNode(grammarAccess.getFeatureReferenceAccess().getNameIDTerminalRuleCall_1_0_0(), "name"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_1_1, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5134:8: lv_name_1_2= 'unit'
                    {
                    lv_name_1_2=(Token)input.LT(1);
                    match(input,41,FOLLOW_41_in_ruleFeatureReference9108); 

                            createLeafNode(grammarAccess.getFeatureReferenceAccess().getNameUnitKeyword_1_0_1(), "name"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getFeatureReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "name", lv_name_1_2, null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFeatureReference


    // $ANTLR start entryRuleArrayElementReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5163:1: entryRuleArrayElementReference returns [EObject current=null] : iv_ruleArrayElementReference= ruleArrayElementReference EOF ;
    public final EObject entryRuleArrayElementReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayElementReference = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5164:2: (iv_ruleArrayElementReference= ruleArrayElementReference EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5165:2: iv_ruleArrayElementReference= ruleArrayElementReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getArrayElementReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleArrayElementReference_in_entryRuleArrayElementReference9160);
            iv_ruleArrayElementReference=ruleArrayElementReference();
            _fsp--;

             current =iv_ruleArrayElementReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayElementReference9170); 

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
    // $ANTLR end entryRuleArrayElementReference


    // $ANTLR start ruleArrayElementReference
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5172:1: ruleArrayElementReference returns [EObject current=null] : ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) ;
    public final EObject ruleArrayElementReference() throws RecognitionException {
        EObject current = null;

        EObject lv_subscripts_1_0 = null;

        EObject lv_subscripts_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5177:6: ( ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5178:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5178:1: ( '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5178:3: '[' ( (lv_subscripts_1_0= ruleSubscript ) ) ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )* ']'
            {
            match(input,33,FOLLOW_33_in_ruleArrayElementReference9205); 

                    createLeafNode(grammarAccess.getArrayElementReferenceAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5182:1: ( (lv_subscripts_1_0= ruleSubscript ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5183:1: (lv_subscripts_1_0= ruleSubscript )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5183:1: (lv_subscripts_1_0= ruleSubscript )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5184:3: lv_subscripts_1_0= ruleSubscript
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getArrayElementReferenceAccess().getSubscriptsSubscriptParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleSubscript_in_ruleArrayElementReference9226);
            lv_subscripts_1_0=ruleSubscript();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getArrayElementReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"subscripts",
            	        		lv_subscripts_1_0, 
            	        		"Subscript", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5206:2: ( ',' ( (lv_subscripts_3_0= ruleSubscript ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==16) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5206:4: ',' ( (lv_subscripts_3_0= ruleSubscript ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleArrayElementReference9237); 

            	            createLeafNode(grammarAccess.getArrayElementReferenceAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5210:1: ( (lv_subscripts_3_0= ruleSubscript ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5211:1: (lv_subscripts_3_0= ruleSubscript )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5211:1: (lv_subscripts_3_0= ruleSubscript )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5212:3: lv_subscripts_3_0= ruleSubscript
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getArrayElementReferenceAccess().getSubscriptsSubscriptParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSubscript_in_ruleArrayElementReference9258);
            	    lv_subscripts_3_0=ruleSubscript();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getArrayElementReferenceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"subscripts",
            	    	        		lv_subscripts_3_0, 
            	    	        		"Subscript", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            match(input,34,FOLLOW_34_in_ruleArrayElementReference9270); 

                    createLeafNode(grammarAccess.getArrayElementReferenceAccess().getRightSquareBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleArrayElementReference


    // $ANTLR start entryRuleOperationCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5246:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5247:2: (iv_ruleOperationCall= ruleOperationCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5248:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleOperationCall_in_entryRuleOperationCall9306);
            iv_ruleOperationCall=ruleOperationCall();
            _fsp--;

             current =iv_ruleOperationCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationCall9316); 

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
    // $ANTLR end entryRuleOperationCall


    // $ANTLR start ruleOperationCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5255:1: ruleOperationCall returns [EObject current=null] : ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5260:6: ( ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5261:1: ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5261:1: ( () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5261:2: () '(' ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )? ')'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5261:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5262:5: 
            {
             
                    temp=factory.create(grammarAccess.getOperationCallAccess().getOperationCallAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getOperationCallAccess().getOperationCallAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,26,FOLLOW_26_in_ruleOperationCall9360); 

                    createLeafNode(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5276:1: ( ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=RULE_REAL && LA76_0<=RULE_ID)||LA76_0==26||LA76_0==33||(LA76_0>=41 && LA76_0<=42)||LA76_0==44||LA76_0==47||(LA76_0>=57 && LA76_0<=58)||LA76_0==63||LA76_0==76||(LA76_0>=78 && LA76_0<=79)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5276:2: ( (lv_arguments_2_0= ruleExpression ) ) ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5276:2: ( (lv_arguments_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5277:1: (lv_arguments_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5277:1: (lv_arguments_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5278:3: lv_arguments_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsExpressionParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall9382);
                    lv_arguments_2_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getOperationCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"arguments",
                    	        		lv_arguments_2_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5300:2: ( ',' ( (lv_arguments_4_0= ruleExpression ) ) )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==16) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5300:4: ',' ( (lv_arguments_4_0= ruleExpression ) )
                    	    {
                    	    match(input,16,FOLLOW_16_in_ruleOperationCall9393); 

                    	            createLeafNode(grammarAccess.getOperationCallAccess().getCommaKeyword_2_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5304:1: ( (lv_arguments_4_0= ruleExpression ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5305:1: (lv_arguments_4_0= ruleExpression )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5305:1: (lv_arguments_4_0= ruleExpression )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5306:3: lv_arguments_4_0= ruleExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsExpressionParserRuleCall_2_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleOperationCall9414);
                    	    lv_arguments_4_0=ruleExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getOperationCallRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"arguments",
                    	    	        		lv_arguments_4_0, 
                    	    	        		"Expression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop75;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,27,FOLLOW_27_in_ruleOperationCall9428); 

                    createLeafNode(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOperationCall


    // $ANTLR start entryRuleIteratorCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5340:1: entryRuleIteratorCall returns [EObject current=null] : iv_ruleIteratorCall= ruleIteratorCall EOF ;
    public final EObject entryRuleIteratorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorCall = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5341:2: (iv_ruleIteratorCall= ruleIteratorCall EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5342:2: iv_ruleIteratorCall= ruleIteratorCall EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIteratorCallRule(), currentNode); 
            pushFollow(FOLLOW_ruleIteratorCall_in_entryRuleIteratorCall9464);
            iv_ruleIteratorCall=ruleIteratorCall();
            _fsp--;

             current =iv_ruleIteratorCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIteratorCall9474); 

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
    // $ANTLR end entryRuleIteratorCall


    // $ANTLR start ruleIteratorCall
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5349:1: ruleIteratorCall returns [EObject current=null] : ( () '(' ( (lv_elementName_2_0= ruleKeywordID ) ) ( ';' ( (lv_accumulatorName_4_0= ruleKeywordID ) ) '=' ( (lv_initialExpression_6_0= ruleExpression ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')' ) ;
    public final EObject ruleIteratorCall() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_elementName_2_0 = null;

        AntlrDatatypeRuleToken lv_accumulatorName_4_0 = null;

        EObject lv_initialExpression_6_0 = null;

        EObject lv_expression_8_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5354:6: ( ( () '(' ( (lv_elementName_2_0= ruleKeywordID ) ) ( ';' ( (lv_accumulatorName_4_0= ruleKeywordID ) ) '=' ( (lv_initialExpression_6_0= ruleExpression ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5355:1: ( () '(' ( (lv_elementName_2_0= ruleKeywordID ) ) ( ';' ( (lv_accumulatorName_4_0= ruleKeywordID ) ) '=' ( (lv_initialExpression_6_0= ruleExpression ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5355:1: ( () '(' ( (lv_elementName_2_0= ruleKeywordID ) ) ( ';' ( (lv_accumulatorName_4_0= ruleKeywordID ) ) '=' ( (lv_initialExpression_6_0= ruleExpression ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5355:2: () '(' ( (lv_elementName_2_0= ruleKeywordID ) ) ( ';' ( (lv_accumulatorName_4_0= ruleKeywordID ) ) '=' ( (lv_initialExpression_6_0= ruleExpression ) ) )? '|' ( (lv_expression_8_0= ruleExpression ) ) ')'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5355:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5356:5: 
            {
             
                    temp=factory.create(grammarAccess.getIteratorCallAccess().getElementDeclarationAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getIteratorCallAccess().getElementDeclarationAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,26,FOLLOW_26_in_ruleIteratorCall9518); 

                    createLeafNode(grammarAccess.getIteratorCallAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5370:1: ( (lv_elementName_2_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5371:1: (lv_elementName_2_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5371:1: (lv_elementName_2_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5372:3: lv_elementName_2_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIteratorCallAccess().getElementNameKeywordIDParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleIteratorCall9539);
            lv_elementName_2_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIteratorCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"elementName",
            	        		lv_elementName_2_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5394:2: ( ';' ( (lv_accumulatorName_4_0= ruleKeywordID ) ) '=' ( (lv_initialExpression_6_0= ruleExpression ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==19) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5394:4: ';' ( (lv_accumulatorName_4_0= ruleKeywordID ) ) '=' ( (lv_initialExpression_6_0= ruleExpression ) )
                    {
                    match(input,19,FOLLOW_19_in_ruleIteratorCall9550); 

                            createLeafNode(grammarAccess.getIteratorCallAccess().getSemicolonKeyword_3_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5398:1: ( (lv_accumulatorName_4_0= ruleKeywordID ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5399:1: (lv_accumulatorName_4_0= ruleKeywordID )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5399:1: (lv_accumulatorName_4_0= ruleKeywordID )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5400:3: lv_accumulatorName_4_0= ruleKeywordID
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIteratorCallAccess().getAccumulatorNameKeywordIDParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeywordID_in_ruleIteratorCall9571);
                    lv_accumulatorName_4_0=ruleKeywordID();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIteratorCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"accumulatorName",
                    	        		lv_accumulatorName_4_0, 
                    	        		"KeywordID", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    match(input,18,FOLLOW_18_in_ruleIteratorCall9581); 

                            createLeafNode(grammarAccess.getIteratorCallAccess().getEqualsSignKeyword_3_2(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5426:1: ( (lv_initialExpression_6_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5427:1: (lv_initialExpression_6_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5427:1: (lv_initialExpression_6_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5428:3: lv_initialExpression_6_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getIteratorCallAccess().getInitialExpressionExpressionParserRuleCall_3_3_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleIteratorCall9602);
                    lv_initialExpression_6_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getIteratorCallRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"initialExpression",
                    	        		lv_initialExpression_6_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,56,FOLLOW_56_in_ruleIteratorCall9614); 

                    createLeafNode(grammarAccess.getIteratorCallAccess().getVerticalLineKeyword_4(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5454:1: ( (lv_expression_8_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5455:1: (lv_expression_8_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5455:1: (lv_expression_8_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5456:3: lv_expression_8_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIteratorCallAccess().getExpressionExpressionParserRuleCall_5_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleIteratorCall9635);
            lv_expression_8_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIteratorCallRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expression",
            	        		lv_expression_8_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,27,FOLLOW_27_in_ruleIteratorCall9645); 

                    createLeafNode(grammarAccess.getIteratorCallAccess().getRightParenthesisKeyword_6(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIteratorCall


    // $ANTLR start entryRuleSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5490:1: entryRuleSubscript returns [EObject current=null] : iv_ruleSubscript= ruleSubscript EOF ;
    public final EObject entryRuleSubscript() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubscript = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5491:2: (iv_ruleSubscript= ruleSubscript EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5492:2: iv_ruleSubscript= ruleSubscript EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubscriptRule(), currentNode); 
            pushFollow(FOLLOW_ruleSubscript_in_entryRuleSubscript9681);
            iv_ruleSubscript=ruleSubscript();
            _fsp--;

             current =iv_ruleSubscript; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubscript9691); 

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
    // $ANTLR end entryRuleSubscript


    // $ANTLR start ruleSubscript
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5499:1: ruleSubscript returns [EObject current=null] : ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleSubscript() throws RecognitionException {
        EObject current = null;

        Token lv_slice_0_0=null;
        EObject lv_expression_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5504:6: ( ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5505:1: ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5505:1: ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==21) ) {
                alt78=1;
            }
            else if ( ((LA78_0>=RULE_REAL && LA78_0<=RULE_ID)||LA78_0==26||LA78_0==33||(LA78_0>=41 && LA78_0<=42)||LA78_0==44||LA78_0==47||(LA78_0>=57 && LA78_0<=58)||LA78_0==63||LA78_0==76||(LA78_0>=78 && LA78_0<=79)) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("5505:1: ( ( (lv_slice_0_0= ':' ) ) | ( (lv_expression_1_0= ruleExpression ) ) )", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5505:2: ( (lv_slice_0_0= ':' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5505:2: ( (lv_slice_0_0= ':' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5506:1: (lv_slice_0_0= ':' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5506:1: (lv_slice_0_0= ':' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5507:3: lv_slice_0_0= ':'
                    {
                    lv_slice_0_0=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleSubscript9734); 

                            createLeafNode(grammarAccess.getSubscriptAccess().getSliceColonKeyword_0_0(), "slice"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubscriptRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "slice", true, ":", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5527:6: ( (lv_expression_1_0= ruleExpression ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5527:6: ( (lv_expression_1_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5528:1: (lv_expression_1_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5528:1: (lv_expression_1_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5529:3: lv_expression_1_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getSubscriptAccess().getExpressionExpressionParserRuleCall_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleSubscript9774);
                    lv_expression_1_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getSubscriptRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression",
                    	        		lv_expression_1_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSubscript


    // $ANTLR start entryRuleMatrixConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5559:1: entryRuleMatrixConstructionOperator returns [EObject current=null] : iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF ;
    public final EObject entryRuleMatrixConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMatrixConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5560:2: (iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5561:2: iv_ruleMatrixConstructionOperator= ruleMatrixConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMatrixConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleMatrixConstructionOperator_in_entryRuleMatrixConstructionOperator9810);
            iv_ruleMatrixConstructionOperator=ruleMatrixConstructionOperator();
            _fsp--;

             current =iv_ruleMatrixConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMatrixConstructionOperator9820); 

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
    // $ANTLR end entryRuleMatrixConstructionOperator


    // $ANTLR start ruleMatrixConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5568:1: ruleMatrixConstructionOperator returns [EObject current=null] : ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) ;
    public final EObject ruleMatrixConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_expressionLists_1_0 = null;

        EObject lv_expressionLists_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5573:6: ( ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5574:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5574:1: ( '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5574:3: '[' ( (lv_expressionLists_1_0= ruleExpressionList ) ) ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )* ']'
            {
            match(input,33,FOLLOW_33_in_ruleMatrixConstructionOperator9855); 

                    createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getLeftSquareBracketKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5578:1: ( (lv_expressionLists_1_0= ruleExpressionList ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5579:1: (lv_expressionLists_1_0= ruleExpressionList )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5579:1: (lv_expressionLists_1_0= ruleExpressionList )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5580:3: lv_expressionLists_1_0= ruleExpressionList
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMatrixConstructionOperatorAccess().getExpressionListsExpressionListParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator9876);
            lv_expressionLists_1_0=ruleExpressionList();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMatrixConstructionOperatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"expressionLists",
            	        		lv_expressionLists_1_0, 
            	        		"ExpressionList", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5602:2: ( ';' ( (lv_expressionLists_3_0= ruleExpressionList ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==19) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5602:4: ';' ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    {
            	    match(input,19,FOLLOW_19_in_ruleMatrixConstructionOperator9887); 

            	            createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getSemicolonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5606:1: ( (lv_expressionLists_3_0= ruleExpressionList ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5607:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5607:1: (lv_expressionLists_3_0= ruleExpressionList )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5608:3: lv_expressionLists_3_0= ruleExpressionList
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMatrixConstructionOperatorAccess().getExpressionListsExpressionListParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator9908);
            	    lv_expressionLists_3_0=ruleExpressionList();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMatrixConstructionOperatorRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressionLists",
            	    	        		lv_expressionLists_3_0, 
            	    	        		"ExpressionList", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

            match(input,34,FOLLOW_34_in_ruleMatrixConstructionOperator9920); 

                    createLeafNode(grammarAccess.getMatrixConstructionOperatorAccess().getRightSquareBracketKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMatrixConstructionOperator


    // $ANTLR start entryRuleExpressionList
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5642:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5643:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5644:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExpressionListRule(), currentNode); 
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList9956);
            iv_ruleExpressionList=ruleExpressionList();
            _fsp--;

             current =iv_ruleExpressionList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList9966); 

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
    // $ANTLR end entryRuleExpressionList


    // $ANTLR start ruleExpressionList
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5651:1: ruleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5656:6: ( ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5657:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5657:1: ( ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5657:2: ( (lv_expressions_0_0= ruleExpression ) ) ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5657:2: ( (lv_expressions_0_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5658:1: (lv_expressions_0_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5658:1: (lv_expressions_0_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5659:3: lv_expressions_0_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10012);
            lv_expressions_0_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getExpressionListRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"expressions",
            	        		lv_expressions_0_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5681:2: ( ',' ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==16) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5681:4: ',' ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleExpressionList10023); 

            	            createLeafNode(grammarAccess.getExpressionListAccess().getCommaKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5685:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5686:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5686:1: (lv_expressions_2_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5687:3: lv_expressions_2_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList10044);
            	    lv_expressions_2_0=ruleExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getExpressionListRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressions",
            	    	        		lv_expressions_2_0, 
            	    	        		"Expression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleExpressionList


    // $ANTLR start entryRuleUnitConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5717:1: entryRuleUnitConstructionOperator returns [EObject current=null] : iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF ;
    public final EObject entryRuleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitConstructionOperator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5718:2: (iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5719:2: iv_ruleUnitConstructionOperator= ruleUnitConstructionOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitConstructionOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10082);
            iv_ruleUnitConstructionOperator=ruleUnitConstructionOperator();
            _fsp--;

             current =iv_ruleUnitConstructionOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitConstructionOperator10092); 

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
    // $ANTLR end entryRuleUnitConstructionOperator


    // $ANTLR start ruleUnitConstructionOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5726:1: ruleUnitConstructionOperator returns [EObject current=null] : ( 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' ) ;
    public final EObject ruleUnitConstructionOperator() throws RecognitionException {
        EObject current = null;

        EObject lv_unit_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5731:6: ( ( 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5732:1: ( 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5732:1: ( 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5732:3: 'unit' '(' ( (lv_unit_2_0= ruleUnitExpression ) ) ')'
            {
            match(input,41,FOLLOW_41_in_ruleUnitConstructionOperator10127); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitKeyword_0(), null); 
                
            match(input,26,FOLLOW_26_in_ruleUnitConstructionOperator10137); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getLeftParenthesisKeyword_1(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5740:1: ( (lv_unit_2_0= ruleUnitExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5741:1: (lv_unit_2_0= ruleUnitExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5741:1: (lv_unit_2_0= ruleUnitExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5742:3: lv_unit_2_0= ruleUnitExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitConstructionOperatorAccess().getUnitUnitExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10158);
            lv_unit_2_0=ruleUnitExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitConstructionOperatorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"unit",
            	        		lv_unit_2_0, 
            	        		"UnitExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,27,FOLLOW_27_in_ruleUnitConstructionOperator10168); 

                    createLeafNode(grammarAccess.getUnitConstructionOperatorAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitConstructionOperator


    // $ANTLR start entryRuleParenthesizedExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5776:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5777:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5778:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParenthesizedExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10204);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();
            _fsp--;

             current =iv_ruleParenthesizedExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression10214); 

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
    // $ANTLR end entryRuleParenthesizedExpression


    // $ANTLR start ruleParenthesizedExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5785:1: ruleParenthesizedExpression returns [EObject current=null] : ( '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5790:6: ( ( '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5791:1: ( '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5791:1: ( '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5791:3: '(' ( (lv_expressions_1_0= ruleExpression ) ) ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )* ')'
            {
            match(input,26,FOLLOW_26_in_ruleParenthesizedExpression10249); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0(), null); 
                
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5795:1: ( (lv_expressions_1_0= ruleExpression ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5796:1: (lv_expressions_1_0= ruleExpression )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5796:1: (lv_expressions_1_0= ruleExpression )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5797:3: lv_expressions_1_0= ruleExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionsExpressionParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression10270);
            lv_expressions_1_0=ruleExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParenthesizedExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"expressions",
            	        		lv_expressions_1_0, 
            	        		"Expression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5819:2: ( ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==16) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5819:4: ',' ( (lv_expressions_3_0= ruleExpression ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleParenthesizedExpression10281); 

            	            createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getCommaKeyword_2_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5823:1: ( (lv_expressions_3_0= ruleExpression ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5824:1: (lv_expressions_3_0= ruleExpression )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5824:1: (lv_expressions_3_0= ruleExpression )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5825:3: lv_expressions_3_0= ruleExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionsExpressionParserRuleCall_2_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression10302);
            	    lv_expressions_3_0=ruleExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getParenthesizedExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"expressions",
            	    	        		lv_expressions_3_0, 
            	    	        		"Expression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

            match(input,27,FOLLOW_27_in_ruleParenthesizedExpression10314); 

                    createLeafNode(grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParenthesizedExpression


    // $ANTLR start entryRuleBeginExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5859:1: entryRuleBeginExpression returns [EObject current=null] : iv_ruleBeginExpression= ruleBeginExpression EOF ;
    public final EObject entryRuleBeginExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeginExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5860:2: (iv_ruleBeginExpression= ruleBeginExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5861:2: iv_ruleBeginExpression= ruleBeginExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBeginExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10350);
            iv_ruleBeginExpression=ruleBeginExpression();
            _fsp--;

             current =iv_ruleBeginExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBeginExpression10360); 

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
    // $ANTLR end entryRuleBeginExpression


    // $ANTLR start ruleBeginExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5868:1: ruleBeginExpression returns [EObject current=null] : ( () 'begin' ) ;
    public final EObject ruleBeginExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5873:6: ( ( () 'begin' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5874:1: ( () 'begin' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5874:1: ( () 'begin' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5874:2: () 'begin'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5874:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5875:5: 
            {
             
                    temp=factory.create(grammarAccess.getBeginExpressionAccess().getBeginExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getBeginExpressionAccess().getBeginExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,57,FOLLOW_57_in_ruleBeginExpression10404); 

                    createLeafNode(grammarAccess.getBeginExpressionAccess().getBeginKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBeginExpression


    // $ANTLR start entryRuleEndExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5897:1: entryRuleEndExpression returns [EObject current=null] : iv_ruleEndExpression= ruleEndExpression EOF ;
    public final EObject entryRuleEndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5898:2: (iv_ruleEndExpression= ruleEndExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5899:2: iv_ruleEndExpression= ruleEndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleEndExpression_in_entryRuleEndExpression10440);
            iv_ruleEndExpression=ruleEndExpression();
            _fsp--;

             current =iv_ruleEndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndExpression10450); 

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
    // $ANTLR end entryRuleEndExpression


    // $ANTLR start ruleEndExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5906:1: ruleEndExpression returns [EObject current=null] : ( () 'end' ) ;
    public final EObject ruleEndExpression() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5911:6: ( ( () 'end' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5912:1: ( () 'end' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5912:1: ( () 'end' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5912:2: () 'end'
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5912:2: ()
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5913:5: 
            {
             
                    temp=factory.create(grammarAccess.getEndExpressionAccess().getEndExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getEndExpressionAccess().getEndExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,58,FOLLOW_58_in_ruleEndExpression10494); 

                    createLeafNode(grammarAccess.getEndExpressionAccess().getEndKeyword_1(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEndExpression


    // $ANTLR start entryRuleQualifiedName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5935:1: entryRuleQualifiedName returns [EObject current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final EObject entryRuleQualifiedName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedName = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5936:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5937:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10530);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;

             current =iv_ruleQualifiedName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10540); 

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
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5944:1: ruleQualifiedName returns [EObject current=null] : ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '.' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* ) ;
    public final EObject ruleQualifiedName() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_identifiers_0_0 = null;

        AntlrDatatypeRuleToken lv_identifiers_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5949:6: ( ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '.' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5950:1: ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '.' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5950:1: ( ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '.' ( (lv_identifiers_2_0= ruleKeywordID ) ) )* )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5950:2: ( (lv_identifiers_0_0= ruleKeywordID ) ) ( '.' ( (lv_identifiers_2_0= ruleKeywordID ) ) )*
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5950:2: ( (lv_identifiers_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5951:1: (lv_identifiers_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5951:1: (lv_identifiers_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5952:3: lv_identifiers_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getIdentifiersKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleQualifiedName10586);
            lv_identifiers_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"identifiers",
            	        		lv_identifiers_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5974:2: ( '.' ( (lv_identifiers_2_0= ruleKeywordID ) ) )*
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==55) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5974:4: '.' ( (lv_identifiers_2_0= ruleKeywordID ) )
            	    {
            	    match(input,55,FOLLOW_55_in_ruleQualifiedName10597); 

            	            createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5978:1: ( (lv_identifiers_2_0= ruleKeywordID ) )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5979:1: (lv_identifiers_2_0= ruleKeywordID )
            	    {
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5979:1: (lv_identifiers_2_0= ruleKeywordID )
            	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:5980:3: lv_identifiers_2_0= ruleKeywordID
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getQualifiedNameAccess().getIdentifiersKeywordIDParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeywordID_in_ruleQualifiedName10618);
            	    lv_identifiers_2_0=ruleKeywordID();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getQualifiedNameRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"identifiers",
            	    	        		lv_identifiers_2_0, 
            	    	        		"KeywordID", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop82;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleQualifiedName


    // $ANTLR start entryRuleUnitExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6010:1: entryRuleUnitExpression returns [EObject current=null] : iv_ruleUnitExpression= ruleUnitExpression EOF ;
    public final EObject entryRuleUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpression = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6011:2: (iv_ruleUnitExpression= ruleUnitExpression EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6012:2: iv_ruleUnitExpression= ruleUnitExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression10656);
            iv_ruleUnitExpression=ruleUnitExpression();
            _fsp--;

             current =iv_ruleUnitExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpression10666); 

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
    // $ANTLR end entryRuleUnitExpression


    // $ANTLR start ruleUnitExpression
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6019:1: ruleUnitExpression returns [EObject current=null] : ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) ) ;
    public final EObject ruleUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_unspecified_0_0=null;
        EObject lv_expression_2_0 = null;

        EObject lv_numerator_3_0 = null;

        EObject lv_denominator_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6024:6: ( ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6025:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6025:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )
            int alt84=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt84=1;
                }
                break;
            case 59:
                {
                alt84=2;
                }
                break;
            case RULE_INTEGER:
            case RULE_ID:
            case 54:
                {
                alt84=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6025:1: ( ( (lv_unspecified_0_0= '?' ) ) | ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) ) | ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? ) )", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6025:2: ( (lv_unspecified_0_0= '?' ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6025:2: ( (lv_unspecified_0_0= '?' ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6026:1: (lv_unspecified_0_0= '?' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6026:1: (lv_unspecified_0_0= '?' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6027:3: lv_unspecified_0_0= '?'
                    {
                    lv_unspecified_0_0=(Token)input.LT(1);
                    match(input,40,FOLLOW_40_in_ruleUnitExpression10709); 

                            createLeafNode(grammarAccess.getUnitExpressionAccess().getUnspecifiedQuestionMarkKeyword_0_0(), "unspecified"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "unspecified", true, "?", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6047:6: ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6047:6: ( 'eval' ( (lv_expression_2_0= ruleExpression ) ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6047:8: 'eval' ( (lv_expression_2_0= ruleExpression ) )
                    {
                    match(input,59,FOLLOW_59_in_ruleUnitExpression10739); 

                            createLeafNode(grammarAccess.getUnitExpressionAccess().getEvalKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6051:1: ( (lv_expression_2_0= ruleExpression ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6052:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6052:1: (lv_expression_2_0= ruleExpression )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6053:3: lv_expression_2_0= ruleExpression
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getExpressionExpressionParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleExpression_in_ruleUnitExpression10760);
                    lv_expression_2_0=ruleExpression();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"expression",
                    	        		lv_expression_2_0, 
                    	        		"Expression", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6076:6: ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6076:6: ( ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )? )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6076:7: ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) ) ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )?
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6076:7: ( (lv_numerator_3_0= ruleUnitExpressionNumerator ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6077:1: (lv_numerator_3_0= ruleUnitExpressionNumerator )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6077:1: (lv_numerator_3_0= ruleUnitExpressionNumerator )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6078:3: lv_numerator_3_0= ruleUnitExpressionNumerator
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getNumeratorUnitExpressionNumeratorParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression10789);
                    lv_numerator_3_0=ruleUnitExpressionNumerator();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"numerator",
                    	        		lv_numerator_3_0, 
                    	        		"UnitExpressionNumerator", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6100:2: ( '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==60) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6100:4: '/' ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) )
                            {
                            match(input,60,FOLLOW_60_in_ruleUnitExpression10800); 

                                    createLeafNode(grammarAccess.getUnitExpressionAccess().getSolidusKeyword_2_1_0(), null); 
                                
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6104:1: ( (lv_denominator_5_0= ruleUnitExpressionDenominator ) )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6105:1: (lv_denominator_5_0= ruleUnitExpressionDenominator )
                            {
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6105:1: (lv_denominator_5_0= ruleUnitExpressionDenominator )
                            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6106:3: lv_denominator_5_0= ruleUnitExpressionDenominator
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionAccess().getDenominatorUnitExpressionDenominatorParserRuleCall_2_1_1_0(), currentNode); 
                            	    
                            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression10821);
                            lv_denominator_5_0=ruleUnitExpressionDenominator();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getUnitExpressionRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"denominator",
                            	        		lv_denominator_5_0, 
                            	        		"UnitExpressionDenominator", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpression


    // $ANTLR start entryRuleUnitExpressionNumerator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6136:1: entryRuleUnitExpressionNumerator returns [EObject current=null] : iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF ;
    public final EObject entryRuleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionNumerator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6137:2: (iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6138:2: iv_ruleUnitExpressionNumerator= ruleUnitExpressionNumerator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionNumeratorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator10860);
            iv_ruleUnitExpressionNumerator=ruleUnitExpressionNumerator();
            _fsp--;

             current =iv_ruleUnitExpressionNumerator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionNumerator10870); 

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
    // $ANTLR end entryRuleUnitExpressionNumerator


    // $ANTLR start ruleUnitExpressionNumerator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6145:1: ruleUnitExpressionNumerator returns [EObject current=null] : ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) ;
    public final EObject ruleUnitExpressionNumerator() throws RecognitionException {
        EObject current = null;

        Token lv_one_0_0=null;
        EObject lv_factors_1_0 = null;

        EObject lv_factors_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6150:6: ( ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6151:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6151:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_INTEGER) ) {
                alt86=1;
            }
            else if ( (LA86_0==RULE_ID||LA86_0==54) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6151:1: ( ( (lv_one_0_0= RULE_INTEGER ) ) | ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* ) )", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6151:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6151:2: ( (lv_one_0_0= RULE_INTEGER ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6152:1: (lv_one_0_0= RULE_INTEGER )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6152:1: (lv_one_0_0= RULE_INTEGER )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6153:3: lv_one_0_0= RULE_INTEGER
                    {
                    lv_one_0_0=(Token)input.LT(1);
                    match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator10912); 

                    			createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getOneINTEGERTerminalRuleCall_0_0(), "one"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionNumeratorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"one",
                    	        		lv_one_0_0, 
                    	        		"INTEGER", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6176:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6176:6: ( ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )* )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6176:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6176:7: ( (lv_factors_1_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6177:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6177:1: (lv_factors_1_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6178:3: lv_factors_1_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator10945);
                    lv_factors_1_0=ruleUnitExpressionFactor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionNumeratorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"factors",
                    	        		lv_factors_1_0, 
                    	        		"UnitExpressionFactor", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6200:2: ( '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) ) )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==61) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6200:4: '*' ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,61,FOLLOW_61_in_ruleUnitExpressionNumerator10956); 

                    	            createLeafNode(grammarAccess.getUnitExpressionNumeratorAccess().getAsteriskKeyword_1_1_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6204:1: ( (lv_factors_3_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6205:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6205:1: (lv_factors_3_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6206:3: lv_factors_3_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionNumeratorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator10977);
                    	    lv_factors_3_0=ruleUnitExpressionFactor();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getUnitExpressionNumeratorRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"factors",
                    	    	        		lv_factors_3_0, 
                    	    	        		"UnitExpressionFactor", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop85;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpressionNumerator


    // $ANTLR start entryRuleUnitExpressionDenominator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6236:1: entryRuleUnitExpressionDenominator returns [EObject current=null] : iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF ;
    public final EObject entryRuleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionDenominator = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6237:2: (iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6238:2: iv_ruleUnitExpressionDenominator= ruleUnitExpressionDenominator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionDenominatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11016);
            iv_ruleUnitExpressionDenominator=ruleUnitExpressionDenominator();
            _fsp--;

             current =iv_ruleUnitExpressionDenominator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11026); 

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
    // $ANTLR end entryRuleUnitExpressionDenominator


    // $ANTLR start ruleUnitExpressionDenominator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6245:1: ruleUnitExpressionDenominator returns [EObject current=null] : ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) ;
    public final EObject ruleUnitExpressionDenominator() throws RecognitionException {
        EObject current = null;

        EObject lv_factors_0_0 = null;

        EObject lv_factors_2_0 = null;

        EObject lv_factors_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6250:6: ( ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6251:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6251:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID||LA88_0==54) ) {
                alt88=1;
            }
            else if ( (LA88_0==26) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6251:1: ( ( (lv_factors_0_0= ruleUnitExpressionFactor ) ) | ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' ) )", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6251:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6251:2: ( (lv_factors_0_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6252:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6252:1: (lv_factors_0_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6253:3: lv_factors_0_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11072);
                    lv_factors_0_0=ruleUnitExpressionFactor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionDenominatorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"factors",
                    	        		lv_factors_0_0, 
                    	        		"UnitExpressionFactor", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6276:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6276:6: ( '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6276:8: '(' ( (lv_factors_2_0= ruleUnitExpressionFactor ) ) ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )* ')'
                    {
                    match(input,26,FOLLOW_26_in_ruleUnitExpressionDenominator11089); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getLeftParenthesisKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6280:1: ( (lv_factors_2_0= ruleUnitExpressionFactor ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6281:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6281:1: (lv_factors_2_0= ruleUnitExpressionFactor )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6282:3: lv_factors_2_0= ruleUnitExpressionFactor
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11110);
                    lv_factors_2_0=ruleUnitExpressionFactor();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionDenominatorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"factors",
                    	        		lv_factors_2_0, 
                    	        		"UnitExpressionFactor", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6304:2: ( '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) ) )*
                    loop87:
                    do {
                        int alt87=2;
                        int LA87_0 = input.LA(1);

                        if ( (LA87_0==61) ) {
                            alt87=1;
                        }


                        switch (alt87) {
                    	case 1 :
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6304:4: '*' ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    {
                    	    match(input,61,FOLLOW_61_in_ruleUnitExpressionDenominator11121); 

                    	            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getAsteriskKeyword_1_2_0(), null); 
                    	        
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6308:1: ( (lv_factors_4_0= ruleUnitExpressionFactor ) )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6309:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    {
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6309:1: (lv_factors_4_0= ruleUnitExpressionFactor )
                    	    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6310:3: lv_factors_4_0= ruleUnitExpressionFactor
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionDenominatorAccess().getFactorsUnitExpressionFactorParserRuleCall_1_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11142);
                    	    lv_factors_4_0=ruleUnitExpressionFactor();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getUnitExpressionDenominatorRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"factors",
                    	    	        		lv_factors_4_0, 
                    	    	        		"UnitExpressionFactor", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop87;
                        }
                    } while (true);

                    match(input,27,FOLLOW_27_in_ruleUnitExpressionDenominator11154); 

                            createLeafNode(grammarAccess.getUnitExpressionDenominatorAccess().getRightParenthesisKeyword_1_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpressionDenominator


    // $ANTLR start entryRuleUnitExpressionFactor
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6344:1: entryRuleUnitExpressionFactor returns [EObject current=null] : iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF ;
    public final EObject entryRuleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionFactor = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6345:2: (iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6346:2: iv_ruleUnitExpressionFactor= ruleUnitExpressionFactor EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionFactorRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11191);
            iv_ruleUnitExpressionFactor=ruleUnitExpressionFactor();
            _fsp--;

             current =iv_ruleUnitExpressionFactor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionFactor11201); 

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
    // $ANTLR end entryRuleUnitExpressionFactor


    // $ANTLR start ruleUnitExpressionFactor
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6353:1: ruleUnitExpressionFactor returns [EObject current=null] : ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) ;
    public final EObject ruleUnitExpressionFactor() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operand_0_0 = null;

        EObject lv_exponent_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6358:6: ( ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6359:1: ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6359:1: ( ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )? )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6359:2: ( (lv_operand_0_0= ruleKeywordID ) ) ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6359:2: ( (lv_operand_0_0= ruleKeywordID ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6360:1: (lv_operand_0_0= ruleKeywordID )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6360:1: (lv_operand_0_0= ruleKeywordID )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6361:3: lv_operand_0_0= ruleKeywordID
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getOperandKeywordIDParserRuleCall_0_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKeywordID_in_ruleUnitExpressionFactor11247);
            lv_operand_0_0=ruleKeywordID();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitExpressionFactorRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"operand",
            	        		lv_operand_0_0, 
            	        		"KeywordID", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6383:2: ( '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==62) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6383:4: '^' ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    {
                    match(input,62,FOLLOW_62_in_ruleUnitExpressionFactor11258); 

                            createLeafNode(grammarAccess.getUnitExpressionFactorAccess().getCircumflexAccentKeyword_1_0(), null); 
                        
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6387:1: ( (lv_exponent_2_0= ruleUnitExpressionExponent ) )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6388:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6388:1: (lv_exponent_2_0= ruleUnitExpressionExponent )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6389:3: lv_exponent_2_0= ruleUnitExpressionExponent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getUnitExpressionFactorAccess().getExponentUnitExpressionExponentParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11279);
                    lv_exponent_2_0=ruleUnitExpressionExponent();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionFactorRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"exponent",
                    	        		lv_exponent_2_0, 
                    	        		"UnitExpressionExponent", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpressionFactor


    // $ANTLR start entryRuleUnitExpressionExponent
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6419:1: entryRuleUnitExpressionExponent returns [EObject current=null] : iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF ;
    public final EObject entryRuleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnitExpressionExponent = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6420:2: (iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6421:2: iv_ruleUnitExpressionExponent= ruleUnitExpressionExponent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnitExpressionExponentRule(), currentNode); 
            pushFollow(FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11317);
            iv_ruleUnitExpressionExponent=ruleUnitExpressionExponent();
            _fsp--;

             current =iv_ruleUnitExpressionExponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnitExpressionExponent11327); 

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
    // $ANTLR end entryRuleUnitExpressionExponent


    // $ANTLR start ruleUnitExpressionExponent
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6428:1: ruleUnitExpressionExponent returns [EObject current=null] : ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) ;
    public final EObject ruleUnitExpressionExponent() throws RecognitionException {
        EObject current = null;

        Token lv_negative_0_0=null;
        Token lv_value_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6433:6: ( ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6434:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6434:1: ( ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6434:2: ( (lv_negative_0_0= '-' ) )? ( (lv_value_1_0= RULE_INTEGER ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6434:2: ( (lv_negative_0_0= '-' ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==63) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6435:1: (lv_negative_0_0= '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6435:1: (lv_negative_0_0= '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6436:3: lv_negative_0_0= '-'
                    {
                    lv_negative_0_0=(Token)input.LT(1);
                    match(input,63,FOLLOW_63_in_ruleUnitExpressionExponent11370); 

                            createLeafNode(grammarAccess.getUnitExpressionExponentAccess().getNegativeHyphenMinusKeyword_0_0(), "negative"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getUnitExpressionExponentRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "negative", true, "-", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6455:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6456:1: (lv_value_1_0= RULE_INTEGER )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6456:1: (lv_value_1_0= RULE_INTEGER )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6457:3: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)input.LT(1);
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11401); 

            			createLeafNode(grammarAccess.getUnitExpressionExponentAccess().getValueINTEGERTerminalRuleCall_1_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnitExpressionExponentRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_1_0, 
            	        		"INTEGER", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnitExpressionExponent


    // $ANTLR start entryRuleKeywordID
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6487:1: entryRuleKeywordID returns [String current=null] : iv_ruleKeywordID= ruleKeywordID EOF ;
    public final String entryRuleKeywordID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKeywordID = null;


        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6488:2: (iv_ruleKeywordID= ruleKeywordID EOF )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6489:2: iv_ruleKeywordID= ruleKeywordID EOF
            {
             currentNode = createCompositeNode(grammarAccess.getKeywordIDRule(), currentNode); 
            pushFollow(FOLLOW_ruleKeywordID_in_entryRuleKeywordID11443);
            iv_ruleKeywordID=ruleKeywordID();
            _fsp--;

             current =iv_ruleKeywordID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeywordID11454); 

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
    // $ANTLR end entryRuleKeywordID


    // $ANTLR start ruleKeywordID
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6496:1: ruleKeywordID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= 'j' ) ;
    public final AntlrDatatypeRuleToken ruleKeywordID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6501:6: ( (this_ID_0= RULE_ID | kw= 'j' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6502:1: (this_ID_0= RULE_ID | kw= 'j' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6502:1: (this_ID_0= RULE_ID | kw= 'j' )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ID) ) {
                alt91=1;
            }
            else if ( (LA91_0==54) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6502:1: (this_ID_0= RULE_ID | kw= 'j' )", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6502:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeywordID11494); 

                    		current.merge(this_ID_0);
                        
                     
                        createLeafNode(grammarAccess.getKeywordIDAccess().getIDTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6511:2: kw= 'j'
                    {
                    kw=(Token)input.LT(1);
                    match(input,54,FOLLOW_54_in_ruleKeywordID11518); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getKeywordIDAccess().getJKeyword_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleKeywordID


    // $ANTLR start ruleAssertionStatusKind
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6524:1: ruleAssertionStatusKind returns [Enumerator current=null] : ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) ) ;
    public final Enumerator ruleAssertionStatusKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6528:6: ( ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6529:1: ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6529:1: ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) )
            int alt92=4;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt92=1;
                }
                break;
            case 65:
                {
                alt92=2;
                }
                break;
            case 66:
                {
                alt92=3;
                }
                break;
            case 67:
                {
                alt92=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6529:1: ( ( 'info' ) | ( 'warning' ) | ( 'error' ) | ( 'fatal' ) )", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6529:2: ( 'info' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6529:2: ( 'info' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6529:4: 'info'
                    {
                    match(input,64,FOLLOW_64_in_ruleAssertionStatusKind11570); 

                            current = grammarAccess.getAssertionStatusKindAccess().getInfoEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssertionStatusKindAccess().getInfoEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6535:6: ( 'warning' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6535:6: ( 'warning' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6535:8: 'warning'
                    {
                    match(input,65,FOLLOW_65_in_ruleAssertionStatusKind11585); 

                            current = grammarAccess.getAssertionStatusKindAccess().getWarningEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssertionStatusKindAccess().getWarningEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6541:6: ( 'error' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6541:6: ( 'error' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6541:8: 'error'
                    {
                    match(input,66,FOLLOW_66_in_ruleAssertionStatusKind11600); 

                            current = grammarAccess.getAssertionStatusKindAccess().getErrorEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssertionStatusKindAccess().getErrorEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6547:6: ( 'fatal' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6547:6: ( 'fatal' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6547:8: 'fatal'
                    {
                    match(input,67,FOLLOW_67_in_ruleAssertionStatusKind11615); 

                            current = grammarAccess.getAssertionStatusKindAccess().getFatalEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAssertionStatusKindAccess().getFatalEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAssertionStatusKind


    // $ANTLR start ruleEqualityOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6557:1: ruleEqualityOperator returns [Enumerator current=null] : ( ( '==' ) | ( '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6561:6: ( ( ( '==' ) | ( '!=' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6562:1: ( ( '==' ) | ( '!=' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6562:1: ( ( '==' ) | ( '!=' ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==68) ) {
                alt93=1;
            }
            else if ( (LA93_0==69) ) {
                alt93=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6562:1: ( ( '==' ) | ( '!=' ) )", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6562:2: ( '==' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6562:2: ( '==' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6562:4: '=='
                    {
                    match(input,68,FOLLOW_68_in_ruleEqualityOperator11658); 

                            current = grammarAccess.getEqualityOperatorAccess().getEqualToEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEqualityOperatorAccess().getEqualToEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6568:6: ( '!=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6568:6: ( '!=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6568:8: '!='
                    {
                    match(input,69,FOLLOW_69_in_ruleEqualityOperator11673); 

                            current = grammarAccess.getEqualityOperatorAccess().getNotEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEqualityOperatorAccess().getNotEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEqualityOperator


    // $ANTLR start ruleRelationalOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6578:1: ruleRelationalOperator returns [Enumerator current=null] : ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6582:6: ( ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6583:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6583:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) )
            int alt94=4;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt94=1;
                }
                break;
            case 70:
                {
                alt94=2;
                }
                break;
            case 25:
                {
                alt94=3;
                }
                break;
            case 71:
                {
                alt94=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6583:1: ( ( '<' ) | ( '<=' ) | ( '>' ) | ( '>=' ) )", 94, 0, input);

                throw nvae;
            }

            switch (alt94) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6583:2: ( '<' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6583:2: ( '<' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6583:4: '<'
                    {
                    match(input,24,FOLLOW_24_in_ruleRelationalOperator11716); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6589:6: ( '<=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6589:6: ( '<=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6589:8: '<='
                    {
                    match(input,70,FOLLOW_70_in_ruleRelationalOperator11731); 

                            current = grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getLessThanOrEqualToEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6595:6: ( '>' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6595:6: ( '>' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6595:8: '>'
                    {
                    match(input,25,FOLLOW_25_in_ruleRelationalOperator11746); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6601:6: ( '>=' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6601:6: ( '>=' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6601:8: '>='
                    {
                    match(input,71,FOLLOW_71_in_ruleRelationalOperator11761); 

                            current = grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getRelationalOperatorAccess().getGreaterThanOrEqualToEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRelationalOperator


    // $ANTLR start ruleAdditiveOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6611:1: ruleAdditiveOperator returns [Enumerator current=null] : ( ( '+' ) | ( '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6615:6: ( ( ( '+' ) | ( '-' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6616:1: ( ( '+' ) | ( '-' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6616:1: ( ( '+' ) | ( '-' ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==72) ) {
                alt95=1;
            }
            else if ( (LA95_0==63) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6616:1: ( ( '+' ) | ( '-' ) )", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6616:2: ( '+' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6616:2: ( '+' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6616:4: '+'
                    {
                    match(input,72,FOLLOW_72_in_ruleAdditiveOperator11804); 

                            current = grammarAccess.getAdditiveOperatorAccess().getAdditionEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getAdditionEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6622:6: ( '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6622:6: ( '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6622:8: '-'
                    {
                    match(input,63,FOLLOW_63_in_ruleAdditiveOperator11819); 

                            current = grammarAccess.getAdditiveOperatorAccess().getSubtractionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getAdditiveOperatorAccess().getSubtractionEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAdditiveOperator


    // $ANTLR start ruleMultiplicativeOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6632:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6636:6: ( ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6637:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6637:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )
            int alt96=4;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt96=1;
                }
                break;
            case 60:
                {
                alt96=2;
                }
                break;
            case 73:
                {
                alt96=3;
                }
                break;
            case 74:
                {
                alt96=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("6637:1: ( ( '*' ) | ( '/' ) | ( '.*' ) | ( './' ) )", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6637:2: ( '*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6637:2: ( '*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6637:4: '*'
                    {
                    match(input,61,FOLLOW_61_in_ruleMultiplicativeOperator11862); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getMultiplicationEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getMultiplicationEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6643:6: ( '/' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6643:6: ( '/' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6643:8: '/'
                    {
                    match(input,60,FOLLOW_60_in_ruleMultiplicativeOperator11877); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getDivisionEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getDivisionEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6649:6: ( '.*' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6649:6: ( '.*' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6649:8: '.*'
                    {
                    match(input,73,FOLLOW_73_in_ruleMultiplicativeOperator11892); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getElementWiseMultiplicationEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getElementWiseMultiplicationEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6655:6: ( './' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6655:6: ( './' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6655:8: './'
                    {
                    match(input,74,FOLLOW_74_in_ruleMultiplicativeOperator11907); 

                            current = grammarAccess.getMultiplicativeOperatorAccess().getElementWiseDivisionEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getMultiplicativeOperatorAccess().getElementWiseDivisionEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleMultiplicativeOperator


    // $ANTLR start rulePowerOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6665:1: rulePowerOperator returns [Enumerator current=null] : ( ( '^' ) | ( '.^' ) ) ;
    public final Enumerator rulePowerOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6669:6: ( ( ( '^' ) | ( '.^' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6670:1: ( ( '^' ) | ( '.^' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6670:1: ( ( '^' ) | ( '.^' ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==62) ) {
                alt97=1;
            }
            else if ( (LA97_0==75) ) {
                alt97=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6670:1: ( ( '^' ) | ( '.^' ) )", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6670:2: ( '^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6670:2: ( '^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6670:4: '^'
                    {
                    match(input,62,FOLLOW_62_in_rulePowerOperator11950); 

                            current = grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getPowerEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6676:6: ( '.^' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6676:6: ( '.^' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6676:8: '.^'
                    {
                    match(input,75,FOLLOW_75_in_rulePowerOperator11965); 

                            current = grammarAccess.getPowerOperatorAccess().getElementWisePowerEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getPowerOperatorAccess().getElementWisePowerEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePowerOperator


    // $ANTLR start ruleUnaryOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6686:1: ruleUnaryOperator returns [Enumerator current=null] : ( ( '-' ) | ( '!' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6690:6: ( ( ( '-' ) | ( '!' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6691:1: ( ( '-' ) | ( '!' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6691:1: ( ( '-' ) | ( '!' ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==63) ) {
                alt98=1;
            }
            else if ( (LA98_0==76) ) {
                alt98=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6691:1: ( ( '-' ) | ( '!' ) )", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6691:2: ( '-' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6691:2: ( '-' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6691:4: '-'
                    {
                    match(input,63,FOLLOW_63_in_ruleUnaryOperator12008); 

                            current = grammarAccess.getUnaryOperatorAccess().getMinusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getMinusEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6697:6: ( '!' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6697:6: ( '!' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6697:8: '!'
                    {
                    match(input,76,FOLLOW_76_in_ruleUnaryOperator12023); 

                            current = grammarAccess.getUnaryOperatorAccess().getLogicalNotEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getUnaryOperatorAccess().getLogicalNotEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleUnaryOperator


    // $ANTLR start rulePostfixOperator
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6707:1: rulePostfixOperator returns [Enumerator current=null] : ( '\\'' ) ;
    public final Enumerator rulePostfixOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6711:6: ( ( '\\'' ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6712:1: ( '\\'' )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6712:1: ( '\\'' )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6712:3: '\\''
            {
            match(input,77,FOLLOW_77_in_rulePostfixOperator12065); 

                    current = grammarAccess.getPostfixOperatorAccess().getTransposeEnumLiteralDeclaration().getEnumLiteral().getInstance();
                    createLeafNode(grammarAccess.getPostfixOperatorAccess().getTransposeEnumLiteralDeclaration(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePostfixOperator


    // $ANTLR start ruleBooleanKind
    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6722:1: ruleBooleanKind returns [Enumerator current=null] : ( ( 'false' ) | ( 'true' ) ) ;
    public final Enumerator ruleBooleanKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6726:6: ( ( ( 'false' ) | ( 'true' ) ) )
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6727:1: ( ( 'false' ) | ( 'true' ) )
            {
            // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6727:1: ( ( 'false' ) | ( 'true' ) )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==78) ) {
                alt99=1;
            }
            else if ( (LA99_0==79) ) {
                alt99=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("6727:1: ( ( 'false' ) | ( 'true' ) )", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6727:2: ( 'false' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6727:2: ( 'false' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6727:4: 'false'
                    {
                    match(input,78,FOLLOW_78_in_ruleBooleanKind12107); 

                            current = grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getFalseEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6733:6: ( 'true' )
                    {
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6733:6: ( 'true' )
                    // ../org.eclipselabs.mscript.language/src-gen/org/eclipselabs/mscript/language/parser/antlr/internal/InternalMscript.g:6733:8: 'true'
                    {
                    match(input,79,FOLLOW_79_in_ruleBooleanKind12122); 

                            current = grammarAccess.getBooleanKindAccess().getTrueEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getBooleanKindAccess().getTrueEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanKind


 

    public static final BitSet FOLLOW_ruleMscript_in_entryRuleMscript75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMscript85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespaceDefinition_in_ruleMscript130 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleNamespaceDefinition_in_entryRuleNamespaceDefinition166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespaceDefinition176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleNamespaceDefinition211 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamespaceDefinition232 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamespaceDefinition242 = new BitSet(new long[]{0x0000000000D2D000L});
    public static final BitSet FOLLOW_ruleNamespaceMember_in_ruleNamespaceDefinition263 = new BitSet(new long[]{0x0000000000D2D000L});
    public static final BitSet FOLLOW_14_in_ruleNamespaceDefinition274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespaceMember_in_entryRuleNamespaceMember310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamespaceMember320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamespaceDefinition_in_ruleNamespaceMember367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_ruleNamespaceMember394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDefinition_in_entryRuleTypeDefinition429 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDefinition439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeDefinition_in_ruleTypeDefinition486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_ruleTypeDefinition513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeDefinition_in_entryRuleDataTypeDefinition548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeDefinition558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_ruleDataTypeDefinition605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordDefinition_in_ruleDataTypeDefinition632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAliasDefinition_in_ruleDataTypeDefinition659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationDefinition_in_entryRuleEnumerationDefinition694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationDefinition704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleEnumerationDefinition739 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleEnumerationDefinition760 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEnumerationDefinition770 = new BitSet(new long[]{0x0040000000004080L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition792 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_16_in_ruleEnumerationDefinition803 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_ruleEnumerationDefinition824 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleEnumerationDefinition838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumerationLiteralDeclaration_in_entryRuleEnumerationLiteralDeclaration874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumerationLiteralDeclaration884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleEnumerationLiteralDeclaration929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeAliasDefinition_in_entryRuleTypeAliasDefinition964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeAliasDefinition974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleTypeAliasDefinition1009 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleTypeAliasDefinition1030 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTypeAliasDefinition1040 = new BitSet(new long[]{0x000000F900000000L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleTypeAliasDefinition1061 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTypeAliasDefinition1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordDefinition_in_entryRuleRecordDefinition1107 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordDefinition1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleRecordDefinition1152 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleRecordDefinition1173 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRecordDefinition1183 = new BitSet(new long[]{0x0040000000004080L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_ruleRecordDefinition1204 = new BitSet(new long[]{0x0040000000004080L});
    public static final BitSet FOLLOW_14_in_ruleRecordDefinition1215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordFieldDeclaration_in_entryRuleRecordFieldDeclaration1251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordFieldDeclaration1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleRecordFieldDeclaration1307 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleRecordFieldDeclaration1317 = new BitSet(new long[]{0x004000F900000080L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRecordFieldDeclaration1338 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRecordFieldDeclaration1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctionDefinition_in_entryRuleFunctionDefinition1384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctionDefinition1394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFunctionDefinition1437 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleFunctionDefinition1461 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleFunctionDefinition1482 = new BitSet(new long[]{0x0000000005000000L});
    public static final BitSet FOLLOW_24_in_ruleFunctionDefinition1493 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1514 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionDefinition1525 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1546 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_25_in_ruleFunctionDefinition1558 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleFunctionDefinition1570 = new BitSet(new long[]{0x0040000008000080L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1592 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionDefinition1603 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1624 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_27_in_ruleFunctionDefinition1638 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleFunctionDefinition1648 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1669 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleFunctionDefinition1680 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_ruleFunctionDefinition1701 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleFunctionDefinition1713 = new BitSet(new long[]{0x86009602E40040F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleAssertionDeclaration_in_ruleFunctionDefinition1735 = new BitSet(new long[]{0x86009602E40040F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleFunctorDeclaration_in_ruleFunctionDefinition1762 = new BitSet(new long[]{0x86009602E40040F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleFunctionDefinition1789 = new BitSet(new long[]{0x86009602E40040F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleEquationDefinition_in_ruleFunctionDefinition1816 = new BitSet(new long[]{0x86009602E40040F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_14_in_ruleFunctionDefinition1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterDeclaration_in_entryRuleParameterDeclaration1864 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterDeclaration1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleParameterDeclaration1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertionDeclaration_in_entryRuleAssertionDeclaration1954 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssertionDeclaration1964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleAssertionDeclaration1999 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssertionDeclaration2020 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleAssertionDeclaration2030 = new BitSet(new long[]{0x0000000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleAssertionStatusKind_in_ruleAssertionDeclaration2051 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssertionDeclaration2072 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAssertionDeclaration2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration2118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleVariableDeclaration2163 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleVariableDeclaration2184 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleVariableDeclaration2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunctorDeclaration_in_entryRuleFunctorDeclaration2230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunctorDeclaration2240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleFunctorDeclaration2275 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleFunctorDeclaration2296 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFunctorDeclaration2306 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFunctorDeclaration2327 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_24_in_ruleFunctorDeclaration2338 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleArgumentDeclaration_in_ruleFunctorDeclaration2359 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_16_in_ruleFunctorDeclaration2370 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleArgumentDeclaration_in_ruleFunctorDeclaration2391 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_25_in_ruleFunctorDeclaration2403 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFunctorDeclaration2415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArgumentDeclaration_in_entryRuleArgumentDeclaration2451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArgumentDeclaration2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleArgumentDeclaration2506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEquationDefinition_in_entryRuleEquationDefinition2541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEquationDefinition2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEquationDefinition2597 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEquationDefinition2607 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleEquationDefinition2628 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleEquationDefinition2638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_entryRuleDataTypeSpecifier2676 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDataTypeSpecifier2686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_ruleDataTypeSpecifier2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_ruleDataTypeSpecifier2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeSpecifier_in_entryRulePrimitiveTypeSpecifier2795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeSpecifier2805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericTypeSpecifier_in_rulePrimitiveTypeSpecifier2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_rulePrimitiveTypeSpecifier2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_rulePrimitiveTypeSpecifier2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericTypeSpecifier_in_entryRuleNumericTypeSpecifier2941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericTypeSpecifier2951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_ruleNumericTypeSpecifier2998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_ruleNumericTypeSpecifier3025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_ruleNumericTypeSpecifier3052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_ruleNumericTypeSpecifier3079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTypeSpecifier_in_entryRuleRealTypeSpecifier3114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTypeSpecifier3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleRealTypeSpecifier3168 = new BitSet(new long[]{0x0000000204000002L});
    public static final BitSet FOLLOW_26_in_ruleRealTypeSpecifier3179 = new BitSet(new long[]{0x08400100000000A0L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealTypeSpecifier3200 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleRealTypeSpecifier3210 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleRealTypeSpecifier3223 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3244 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleRealTypeSpecifier3255 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleRealTypeSpecifier3276 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleRealTypeSpecifier3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTypeSpecifier_in_entryRuleIntegerTypeSpecifier3326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTypeSpecifier3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleIntegerTypeSpecifier3380 = new BitSet(new long[]{0x0000000204000002L});
    public static final BitSet FOLLOW_26_in_ruleIntegerTypeSpecifier3391 = new BitSet(new long[]{0x08400100000000A0L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerTypeSpecifier3412 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleIntegerTypeSpecifier3422 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleIntegerTypeSpecifier3435 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3456 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleIntegerTypeSpecifier3467 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleIntegerTypeSpecifier3488 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleIntegerTypeSpecifier3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComplexTypeSpecifier_in_entryRuleComplexTypeSpecifier3538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComplexTypeSpecifier3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComplexTypeSpecifier3592 = new BitSet(new long[]{0x0000000204000002L});
    public static final BitSet FOLLOW_26_in_ruleComplexTypeSpecifier3603 = new BitSet(new long[]{0x08400100000000A0L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleComplexTypeSpecifier3624 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleComplexTypeSpecifier3634 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleComplexTypeSpecifier3647 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3668 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleComplexTypeSpecifier3679 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleComplexTypeSpecifier3700 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleComplexTypeSpecifier3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGaussianTypeSpecifier_in_entryRuleGaussianTypeSpecifier3750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGaussianTypeSpecifier3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleGaussianTypeSpecifier3804 = new BitSet(new long[]{0x0000000204000002L});
    public static final BitSet FOLLOW_26_in_ruleGaussianTypeSpecifier3815 = new BitSet(new long[]{0x08400100000000A0L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleGaussianTypeSpecifier3836 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleGaussianTypeSpecifier3846 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleGaussianTypeSpecifier3859 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3880 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleGaussianTypeSpecifier3891 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleGaussianTypeSpecifier3912 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleGaussianTypeSpecifier3924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanTypeSpecifier_in_entryRuleBooleanTypeSpecifier3962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanTypeSpecifier3972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleBooleanTypeSpecifier4016 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleBooleanTypeSpecifier4027 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier4048 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleBooleanTypeSpecifier4059 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleBooleanTypeSpecifier4080 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleBooleanTypeSpecifier4092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTypeSpecifier_in_entryRuleStringTypeSpecifier4130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTypeSpecifier4140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleStringTypeSpecifier4184 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleStringTypeSpecifier4195 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4216 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleStringTypeSpecifier4227 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleStringTypeSpecifier4248 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleStringTypeSpecifier4260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTypeSpecifier_in_entryRuleNamedTypeSpecifier4298 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTypeSpecifier4308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNamedTypeSpecifier4354 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ruleNamedTypeSpecifier4365 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4386 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleNamedTypeSpecifier4397 = new BitSet(new long[]{0x86009702040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_ruleNamedTypeSpecifier4418 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleNamedTypeSpecifier4430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayDimensionSpecification_in_entryRuleArrayDimensionSpecification4468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayDimensionSpecification4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleArrayDimensionSpecification4521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleArrayDimensionSpecification4561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitTypeSpecifier_in_entryRuleUnitTypeSpecifier4597 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitTypeSpecifier4607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleUnitTypeSpecifier4651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4687 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression4697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_ruleExpression4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_ruleExpression4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_ruleExpression4798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_ruleExpression4825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpression_in_entryRuleLetExpression4860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpression4870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleLetExpression4905 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleLetExpressionVariable_in_ruleLetExpression4926 = new BitSet(new long[]{0x0000080000010000L});
    public static final BitSet FOLLOW_16_in_ruleLetExpression4937 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleLetExpressionVariable_in_ruleLetExpression4958 = new BitSet(new long[]{0x0000080000010000L});
    public static final BitSet FOLLOW_43_in_ruleLetExpression4970 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpression4991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpressionVariable_in_entryRuleLetExpressionVariable5027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpressionVariable5037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleLetExpressionVariable5083 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleLetExpressionVariable5093 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLetExpressionVariable5114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpression_in_entryRuleIfExpression5150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpression5160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleIfExpression5195 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression5216 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleIfExpression5226 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression5247 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleIfExpression5257 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIfExpression5278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchExpression_in_entryRuleSwitchExpression5314 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchExpression5324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleSwitchExpression5359 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression5380 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_ruleSwitchExpression5401 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_48_in_ruleSwitchExpression5412 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSwitchExpression5422 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchExpression5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase5479 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchCase5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleSwitchCase5524 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleSwitchCase5545 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSwitchCase5555 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchCase5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeExpression_in_entryRuleRangeExpression5612 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeExpression5622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5669 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleRangeExpression5688 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5709 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleRangeExpression5729 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_ruleRangeExpression5750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImpliesExpression_in_entryRuleImpliesExpression5790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImpliesExpression5800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5847 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleImpliesExpression5866 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_ruleImpliesExpression5887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalOrExpression_in_entryRuleLogicalOrExpression5925 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalOrExpression5935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression5982 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_51_in_ruleLogicalOrExpression6002 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_ruleLogicalOrExpression6023 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_ruleLogicalAndExpression_in_entryRuleLogicalAndExpression6063 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalAndExpression6073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression6120 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_ruleLogicalAndExpression6140 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleLogicalAndExpression6161 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression6201 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression6211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression6258 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression6288 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleEqualityExpression6309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression6357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6404 = new BitSet(new long[]{0x0020000003000002L,0x00000000000000C0L});
    public static final BitSet FOLLOW_53_in_ruleRelationalExpression6433 = new BitSet(new long[]{0x004000F900000080L});
    public static final BitSet FOLLOW_ruleDataTypeSpecifier_in_ruleRelationalExpression6467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6496 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleRelationalExpression6517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6557 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression6567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6614 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_ruleAdditiveExpression6644 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleAdditiveExpressionPart_in_entryRuleAdditiveExpressionPart6683 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpressionPart6693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpressionPart6739 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpressionPart6760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression6796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression6806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpression6853 = new BitSet(new long[]{0x3000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_ruleMultiplicativeExpression6883 = new BitSet(new long[]{0x3000000000000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpressionPart_in_entryRuleMultiplicativeExpressionPart6922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpressionPart6932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpressionPart6978 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_rulePowerExpression_in_ruleMultiplicativeExpressionPart6999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePowerExpression_in_entryRulePowerExpression7035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePowerExpression7045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rulePowerExpression7092 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_rulePowerOperator_in_rulePowerExpression7122 = new BitSet(new long[]{0x86000202040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_rulePowerExpression7143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression7181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression7191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression7238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryOperator_in_ruleUnaryExpression7274 = new BitSet(new long[]{0x06000202040000F0L,0x000000000000C000L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_ruleUnaryExpression7295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression7332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression7342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixExpression7389 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_rulePostfixOperator_in_rulePostfixExpression7419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression7457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression7467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_rulePrimaryExpression7514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_rulePrimaryExpression7541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_rulePrimaryExpression7568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_rulePrimaryExpression7595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_rulePrimaryExpression7622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_entryRuleCallablePrimaryExpression7657 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallablePrimaryExpression7667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixConstructionOperator_in_ruleCallablePrimaryExpression7714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleCallablePrimaryExpression7741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral7776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral7786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericLiteral_in_ruleLiteral7833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_ruleLiteral7860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleLiteral7887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericLiteral_in_entryRuleNumericLiteral7922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericLiteral7932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_ruleNumericLiteral7979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_ruleNumericLiteral8006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteral_in_entryRuleRealLiteral8041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteral8051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_in_ruleRealLiteral8093 = new BitSet(new long[]{0x0040000004000002L});
    public static final BitSet FOLLOW_54_in_ruleRealLiteral8116 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleRealLiteral8141 = new BitSet(new long[]{0x08400100000000A0L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleRealLiteral8162 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleRealLiteral8172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerLiteral_in_entryRuleIntegerLiteral8210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerLiteral8220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerLiteral8262 = new BitSet(new long[]{0x0040000004000002L});
    public static final BitSet FOLLOW_54_in_ruleIntegerLiteral8285 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleIntegerLiteral8310 = new BitSet(new long[]{0x08400100000000A0L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleIntegerLiteral8331 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleIntegerLiteral8341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral8389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanKind_in_ruleBooleanLiteral8434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral8469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral8479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral8520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCall_in_entryRuleFeatureCall8560 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCall8570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallablePrimaryExpression_in_ruleFeatureCall8618 = new BitSet(new long[]{0x0080000204000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8648 = new BitSet(new long[]{0x0080000204000002L});
    public static final BitSet FOLLOW_ruleSimpleName_in_ruleFeatureCall8689 = new BitSet(new long[]{0x0080000204000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_ruleFeatureCall8710 = new BitSet(new long[]{0x0080000204000002L});
    public static final BitSet FOLLOW_ruleSimpleName_in_entryRuleSimpleName8748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleName8758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleName8809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCallPart_in_entryRuleFeatureCallPart8850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCallPart8860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_ruleFeatureCallPart8907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementReference_in_ruleFeatureCallPart8934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_ruleFeatureCallPart8961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIteratorCall_in_ruleFeatureCallPart8988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureReference_in_entryRuleFeatureReference9023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureReference9033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleFeatureReference9068 = new BitSet(new long[]{0x0000020000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureReference9087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleFeatureReference9108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayElementReference_in_entryRuleArrayElementReference9160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayElementReference9170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleArrayElementReference9205 = new BitSet(new long[]{0x86009602042000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArrayElementReference9226 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_16_in_ruleArrayElementReference9237 = new BitSet(new long[]{0x86009602042000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleSubscript_in_ruleArrayElementReference9258 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_34_in_ruleArrayElementReference9270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationCall_in_entryRuleOperationCall9306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationCall9316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleOperationCall9360 = new BitSet(new long[]{0x860096020C0000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall9382 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_16_in_ruleOperationCall9393 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleOperationCall9414 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_27_in_ruleOperationCall9428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIteratorCall_in_entryRuleIteratorCall9464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIteratorCall9474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleIteratorCall9518 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleIteratorCall9539 = new BitSet(new long[]{0x0100000000080000L});
    public static final BitSet FOLLOW_19_in_ruleIteratorCall9550 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleIteratorCall9571 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleIteratorCall9581 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIteratorCall9602 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleIteratorCall9614 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIteratorCall9635 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleIteratorCall9645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubscript_in_entryRuleSubscript9681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubscript9691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSubscript9734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSubscript9774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMatrixConstructionOperator_in_entryRuleMatrixConstructionOperator9810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMatrixConstructionOperator9820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleMatrixConstructionOperator9855 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator9876 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_19_in_ruleMatrixConstructionOperator9887 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleMatrixConstructionOperator9908 = new BitSet(new long[]{0x0000000400080000L});
    public static final BitSet FOLLOW_34_in_ruleMatrixConstructionOperator9920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList9956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList9966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10012 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleExpressionList10023 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList10044 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleUnitConstructionOperator_in_entryRuleUnitConstructionOperator10082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitConstructionOperator10092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleUnitConstructionOperator10127 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleUnitConstructionOperator10137 = new BitSet(new long[]{0x08400100000000A0L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_ruleUnitConstructionOperator10158 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleUnitConstructionOperator10168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression10204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression10214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleParenthesizedExpression10249 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression10270 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedExpression10281 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression10302 = new BitSet(new long[]{0x0000000008010000L});
    public static final BitSet FOLLOW_27_in_ruleParenthesizedExpression10314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBeginExpression_in_entryRuleBeginExpression10350 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBeginExpression10360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleBeginExpression10404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndExpression_in_entryRuleEndExpression10440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndExpression10450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleEndExpression10494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleQualifiedName10586 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleQualifiedName10597 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleQualifiedName10618 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpression_in_entryRuleUnitExpression10656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpression10666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUnitExpression10709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleUnitExpression10739 = new BitSet(new long[]{0x86009602040000F0L,0x000000000000D000L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleUnitExpression10760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_ruleUnitExpression10789 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleUnitExpression10800 = new BitSet(new long[]{0x0040000004000080L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_ruleUnitExpression10821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionNumerator_in_entryRuleUnitExpressionNumerator10860 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionNumerator10870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionNumerator10912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator10945 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleUnitExpressionNumerator10956 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionNumerator10977 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionDenominator_in_entryRuleUnitExpressionDenominator11016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionDenominator11026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleUnitExpressionDenominator11089 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11110 = new BitSet(new long[]{0x2000000008000000L});
    public static final BitSet FOLLOW_61_in_ruleUnitExpressionDenominator11121 = new BitSet(new long[]{0x0040000000000080L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_ruleUnitExpressionDenominator11142 = new BitSet(new long[]{0x2000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleUnitExpressionDenominator11154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionFactor_in_entryRuleUnitExpressionFactor11191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionFactor11201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_ruleUnitExpressionFactor11247 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleUnitExpressionFactor11258 = new BitSet(new long[]{0x8000000000000020L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_ruleUnitExpressionFactor11279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnitExpressionExponent_in_entryRuleUnitExpressionExponent11317 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnitExpressionExponent11327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleUnitExpressionExponent11370 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleUnitExpressionExponent11401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeywordID_in_entryRuleKeywordID11443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeywordID11454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeywordID11494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleKeywordID11518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleAssertionStatusKind11570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleAssertionStatusKind11585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleAssertionStatusKind11600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleAssertionStatusKind11615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleEqualityOperator11658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleEqualityOperator11673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleRelationalOperator11716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleRelationalOperator11731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleRelationalOperator11746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleRelationalOperator11761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleAdditiveOperator11804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleAdditiveOperator11819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleMultiplicativeOperator11862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleMultiplicativeOperator11877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleMultiplicativeOperator11892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleMultiplicativeOperator11907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_rulePowerOperator11950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_rulePowerOperator11965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleUnaryOperator12008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleUnaryOperator12023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_rulePostfixOperator12065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleBooleanKind12107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleBooleanKind12122 = new BitSet(new long[]{0x0000000000000002L});

}