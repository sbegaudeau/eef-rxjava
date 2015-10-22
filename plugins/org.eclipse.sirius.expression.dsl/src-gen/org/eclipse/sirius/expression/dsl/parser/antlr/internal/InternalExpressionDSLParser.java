package org.eclipse.sirius.expression.dsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.sirius.expression.dsl.services.ExpressionDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ML_COMMENT", "RULE_ID", "RULE_INT", "RULE_WS", "'package'", "'{'", "'}'", "'class'", "'var'", "':'", "'.'", "'exp'", "'('", "','", "')'", "'['", "'..'", "']'", "'contextableElements'", "'='", "'optional'", "'-'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int RULE_ID=5;
    public static final int RULE_WS=7;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=4;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalExpressionDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExpressionDSL.g"; }



     	private ExpressionDSLGrammarAccess grammarAccess;
     	
        public InternalExpressionDSLParser(TokenStream input, ExpressionDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SiriusExpressionPackage";	
       	}
       	
       	@Override
       	protected ExpressionDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSiriusExpressionPackage"
    // InternalExpressionDSL.g:67:1: entryRuleSiriusExpressionPackage returns [EObject current=null] : iv_ruleSiriusExpressionPackage= ruleSiriusExpressionPackage EOF ;
    public final EObject entryRuleSiriusExpressionPackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSiriusExpressionPackage = null;


        try {
            // InternalExpressionDSL.g:68:2: (iv_ruleSiriusExpressionPackage= ruleSiriusExpressionPackage EOF )
            // InternalExpressionDSL.g:69:2: iv_ruleSiriusExpressionPackage= ruleSiriusExpressionPackage EOF
            {
             newCompositeNode(grammarAccess.getSiriusExpressionPackageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSiriusExpressionPackage=ruleSiriusExpressionPackage();

            state._fsp--;

             current =iv_ruleSiriusExpressionPackage; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSiriusExpressionPackage"


    // $ANTLR start "ruleSiriusExpressionPackage"
    // InternalExpressionDSL.g:76:1: ruleSiriusExpressionPackage returns [EObject current=null] : (otherlv_0= 'package' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_expressionClasses_3_0= ruleSiriusExpressionClass ) )* otherlv_4= '}' ) ;
    public final EObject ruleSiriusExpressionPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expressionClasses_3_0 = null;


         enterRule(); 
            
        try {
            // InternalExpressionDSL.g:79:28: ( (otherlv_0= 'package' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_expressionClasses_3_0= ruleSiriusExpressionClass ) )* otherlv_4= '}' ) )
            // InternalExpressionDSL.g:80:1: (otherlv_0= 'package' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_expressionClasses_3_0= ruleSiriusExpressionClass ) )* otherlv_4= '}' )
            {
            // InternalExpressionDSL.g:80:1: (otherlv_0= 'package' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_expressionClasses_3_0= ruleSiriusExpressionClass ) )* otherlv_4= '}' )
            // InternalExpressionDSL.g:80:3: otherlv_0= 'package' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_expressionClasses_3_0= ruleSiriusExpressionClass ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,8,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSiriusExpressionPackageAccess().getPackageKeyword_0());
                
            // InternalExpressionDSL.g:84:1: ( ( ruleFQN ) )
            // InternalExpressionDSL.g:85:1: ( ruleFQN )
            {
            // InternalExpressionDSL.g:85:1: ( ruleFQN )
            // InternalExpressionDSL.g:86:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSiriusExpressionPackageRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSiriusExpressionPackageAccess().getEPackageEPackageCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,9,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getSiriusExpressionPackageAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalExpressionDSL.g:103:1: ( (lv_expressionClasses_3_0= ruleSiriusExpressionClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalExpressionDSL.g:104:1: (lv_expressionClasses_3_0= ruleSiriusExpressionClass )
            	    {
            	    // InternalExpressionDSL.g:104:1: (lv_expressionClasses_3_0= ruleSiriusExpressionClass )
            	    // InternalExpressionDSL.g:105:3: lv_expressionClasses_3_0= ruleSiriusExpressionClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSiriusExpressionPackageAccess().getExpressionClassesSiriusExpressionClassParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_expressionClasses_3_0=ruleSiriusExpressionClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSiriusExpressionPackageRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressionClasses",
            	            		lv_expressionClasses_3_0, 
            	            		"org.eclipse.sirius.expression.dsl.ExpressionDSL.SiriusExpressionClass");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_4=(Token)match(input,10,FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getSiriusExpressionPackageAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleSiriusExpressionPackage"


    // $ANTLR start "entryRuleSiriusExpressionClass"
    // InternalExpressionDSL.g:133:1: entryRuleSiriusExpressionClass returns [EObject current=null] : iv_ruleSiriusExpressionClass= ruleSiriusExpressionClass EOF ;
    public final EObject entryRuleSiriusExpressionClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSiriusExpressionClass = null;


        try {
            // InternalExpressionDSL.g:134:2: (iv_ruleSiriusExpressionClass= ruleSiriusExpressionClass EOF )
            // InternalExpressionDSL.g:135:2: iv_ruleSiriusExpressionClass= ruleSiriusExpressionClass EOF
            {
             newCompositeNode(grammarAccess.getSiriusExpressionClassRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSiriusExpressionClass=ruleSiriusExpressionClass();

            state._fsp--;

             current =iv_ruleSiriusExpressionClass; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSiriusExpressionClass"


    // $ANTLR start "ruleSiriusExpressionClass"
    // InternalExpressionDSL.g:142:1: ruleSiriusExpressionClass returns [EObject current=null] : (otherlv_0= 'class' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleSiriusVariable ) )* ( (lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription ) )* otherlv_5= '}' ) ;
    public final EObject ruleSiriusExpressionClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_variables_3_0 = null;

        EObject lv_expressionDescriptions_4_0 = null;


         enterRule(); 
            
        try {
            // InternalExpressionDSL.g:145:28: ( (otherlv_0= 'class' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleSiriusVariable ) )* ( (lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription ) )* otherlv_5= '}' ) )
            // InternalExpressionDSL.g:146:1: (otherlv_0= 'class' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleSiriusVariable ) )* ( (lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription ) )* otherlv_5= '}' )
            {
            // InternalExpressionDSL.g:146:1: (otherlv_0= 'class' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleSiriusVariable ) )* ( (lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription ) )* otherlv_5= '}' )
            // InternalExpressionDSL.g:146:3: otherlv_0= 'class' ( ( ruleFQN ) ) otherlv_2= '{' ( (lv_variables_3_0= ruleSiriusVariable ) )* ( (lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSiriusExpressionClassAccess().getClassKeyword_0());
                
            // InternalExpressionDSL.g:150:1: ( ( ruleFQN ) )
            // InternalExpressionDSL.g:151:1: ( ruleFQN )
            {
            // InternalExpressionDSL.g:151:1: ( ruleFQN )
            // InternalExpressionDSL.g:152:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSiriusExpressionClassRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSiriusExpressionClassAccess().getEClassEClassCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,9,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getSiriusExpressionClassAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalExpressionDSL.g:169:1: ( (lv_variables_3_0= ruleSiriusVariable ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ML_COMMENT||LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalExpressionDSL.g:170:1: (lv_variables_3_0= ruleSiriusVariable )
            	    {
            	    // InternalExpressionDSL.g:170:1: (lv_variables_3_0= ruleSiriusVariable )
            	    // InternalExpressionDSL.g:171:3: lv_variables_3_0= ruleSiriusVariable
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSiriusExpressionClassAccess().getVariablesSiriusVariableParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_variables_3_0=ruleSiriusVariable();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSiriusExpressionClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"variables",
            	            		lv_variables_3_0, 
            	            		"org.eclipse.sirius.expression.dsl.ExpressionDSL.SiriusVariable");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalExpressionDSL.g:187:3: ( (lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalExpressionDSL.g:188:1: (lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription )
            	    {
            	    // InternalExpressionDSL.g:188:1: (lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription )
            	    // InternalExpressionDSL.g:189:3: lv_expressionDescriptions_4_0= ruleSiriusExpressionDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSiriusExpressionClassAccess().getExpressionDescriptionsSiriusExpressionDescriptionParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_7);
            	    lv_expressionDescriptions_4_0=ruleSiriusExpressionDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSiriusExpressionClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"expressionDescriptions",
            	            		lv_expressionDescriptions_4_0, 
            	            		"org.eclipse.sirius.expression.dsl.ExpressionDSL.SiriusExpressionDescription");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,10,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getSiriusExpressionClassAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleSiriusExpressionClass"


    // $ANTLR start "entryRuleSiriusVariable"
    // InternalExpressionDSL.g:217:1: entryRuleSiriusVariable returns [EObject current=null] : iv_ruleSiriusVariable= ruleSiriusVariable EOF ;
    public final EObject entryRuleSiriusVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSiriusVariable = null;


        try {
            // InternalExpressionDSL.g:218:2: (iv_ruleSiriusVariable= ruleSiriusVariable EOF )
            // InternalExpressionDSL.g:219:2: iv_ruleSiriusVariable= ruleSiriusVariable EOF
            {
             newCompositeNode(grammarAccess.getSiriusVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSiriusVariable=ruleSiriusVariable();

            state._fsp--;

             current =iv_ruleSiriusVariable; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSiriusVariable"


    // $ANTLR start "ruleSiriusVariable"
    // InternalExpressionDSL.g:226:1: ruleSiriusVariable returns [EObject current=null] : ( ( (lv_documentation_0_0= RULE_ML_COMMENT ) )? otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( ruleFQN ) ) ) ;
    public final EObject ruleSiriusVariable() throws RecognitionException {
        EObject current = null;

        Token lv_documentation_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalExpressionDSL.g:229:28: ( ( ( (lv_documentation_0_0= RULE_ML_COMMENT ) )? otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( ruleFQN ) ) ) )
            // InternalExpressionDSL.g:230:1: ( ( (lv_documentation_0_0= RULE_ML_COMMENT ) )? otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( ruleFQN ) ) )
            {
            // InternalExpressionDSL.g:230:1: ( ( (lv_documentation_0_0= RULE_ML_COMMENT ) )? otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( ruleFQN ) ) )
            // InternalExpressionDSL.g:230:2: ( (lv_documentation_0_0= RULE_ML_COMMENT ) )? otherlv_1= 'var' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( ( ruleFQN ) )
            {
            // InternalExpressionDSL.g:230:2: ( (lv_documentation_0_0= RULE_ML_COMMENT ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ML_COMMENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalExpressionDSL.g:231:1: (lv_documentation_0_0= RULE_ML_COMMENT )
                    {
                    // InternalExpressionDSL.g:231:1: (lv_documentation_0_0= RULE_ML_COMMENT )
                    // InternalExpressionDSL.g:232:3: lv_documentation_0_0= RULE_ML_COMMENT
                    {
                    lv_documentation_0_0=(Token)match(input,RULE_ML_COMMENT,FOLLOW_8); 

                    			newLeafNode(lv_documentation_0_0, grammarAccess.getSiriusVariableAccess().getDocumentationML_COMMENTTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSiriusVariableRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"documentation",
                            		lv_documentation_0_0, 
                            		"org.eclipse.sirius.expression.dsl.ExpressionDSL.ML_COMMENT");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,12,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getSiriusVariableAccess().getVarKeyword_1());
                
            // InternalExpressionDSL.g:252:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalExpressionDSL.g:253:1: (lv_name_2_0= RULE_ID )
            {
            // InternalExpressionDSL.g:253:1: (lv_name_2_0= RULE_ID )
            // InternalExpressionDSL.g:254:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_9); 

            			newLeafNode(lv_name_2_0, grammarAccess.getSiriusVariableAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSiriusVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.sirius.expression.dsl.ExpressionDSL.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_3); 

                	newLeafNode(otherlv_3, grammarAccess.getSiriusVariableAccess().getColonKeyword_3());
                
            // InternalExpressionDSL.g:274:1: ( ( ruleFQN ) )
            // InternalExpressionDSL.g:275:1: ( ruleFQN )
            {
            // InternalExpressionDSL.g:275:1: ( ruleFQN )
            // InternalExpressionDSL.g:276:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSiriusVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSiriusVariableAccess().getETypeEClassifierCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             
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
    // $ANTLR end "ruleSiriusVariable"


    // $ANTLR start "entryRuleFQN"
    // InternalExpressionDSL.g:297:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalExpressionDSL.g:298:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalExpressionDSL.g:299:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalExpressionDSL.g:306:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalExpressionDSL.g:309:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalExpressionDSL.g:310:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalExpressionDSL.g:310:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalExpressionDSL.g:310:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalExpressionDSL.g:317:1: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalExpressionDSL.g:318:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,14,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_10); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleSiriusExpressionDescription"
    // InternalExpressionDSL.g:338:1: entryRuleSiriusExpressionDescription returns [EObject current=null] : iv_ruleSiriusExpressionDescription= ruleSiriusExpressionDescription EOF ;
    public final EObject entryRuleSiriusExpressionDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSiriusExpressionDescription = null;


        try {
            // InternalExpressionDSL.g:339:2: (iv_ruleSiriusExpressionDescription= ruleSiriusExpressionDescription EOF )
            // InternalExpressionDSL.g:340:2: iv_ruleSiriusExpressionDescription= ruleSiriusExpressionDescription EOF
            {
             newCompositeNode(grammarAccess.getSiriusExpressionDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSiriusExpressionDescription=ruleSiriusExpressionDescription();

            state._fsp--;

             current =iv_ruleSiriusExpressionDescription; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSiriusExpressionDescription"


    // $ANTLR start "ruleSiriusExpressionDescription"
    // InternalExpressionDSL.g:347:1: ruleSiriusExpressionDescription returns [EObject current=null] : (otherlv_0= 'exp' ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFQN ) ) otherlv_9= '[' ( (lv_lowerBound_10_0= ruleBound ) ) otherlv_11= '..' ( (lv_upperBound_12_0= ruleBound ) ) otherlv_13= ']' otherlv_14= '{' otherlv_15= 'contextableElements' otherlv_16= '=' otherlv_17= '[' ( ( ( ruleFQN ) ) (otherlv_19= ',' ( ( ruleFQN ) ) )* )? otherlv_21= ']' otherlv_22= '}' ) ;
    public final EObject ruleSiriusExpressionDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        AntlrDatatypeRuleToken lv_lowerBound_10_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_12_0 = null;


         enterRule(); 
            
        try {
            // InternalExpressionDSL.g:350:28: ( (otherlv_0= 'exp' ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFQN ) ) otherlv_9= '[' ( (lv_lowerBound_10_0= ruleBound ) ) otherlv_11= '..' ( (lv_upperBound_12_0= ruleBound ) ) otherlv_13= ']' otherlv_14= '{' otherlv_15= 'contextableElements' otherlv_16= '=' otherlv_17= '[' ( ( ( ruleFQN ) ) (otherlv_19= ',' ( ( ruleFQN ) ) )* )? otherlv_21= ']' otherlv_22= '}' ) )
            // InternalExpressionDSL.g:351:1: (otherlv_0= 'exp' ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFQN ) ) otherlv_9= '[' ( (lv_lowerBound_10_0= ruleBound ) ) otherlv_11= '..' ( (lv_upperBound_12_0= ruleBound ) ) otherlv_13= ']' otherlv_14= '{' otherlv_15= 'contextableElements' otherlv_16= '=' otherlv_17= '[' ( ( ( ruleFQN ) ) (otherlv_19= ',' ( ( ruleFQN ) ) )* )? otherlv_21= ']' otherlv_22= '}' )
            {
            // InternalExpressionDSL.g:351:1: (otherlv_0= 'exp' ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFQN ) ) otherlv_9= '[' ( (lv_lowerBound_10_0= ruleBound ) ) otherlv_11= '..' ( (lv_upperBound_12_0= ruleBound ) ) otherlv_13= ']' otherlv_14= '{' otherlv_15= 'contextableElements' otherlv_16= '=' otherlv_17= '[' ( ( ( ruleFQN ) ) (otherlv_19= ',' ( ( ruleFQN ) ) )* )? otherlv_21= ']' otherlv_22= '}' )
            // InternalExpressionDSL.g:351:3: otherlv_0= 'exp' ( ( ruleFQN ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFQN ) ) otherlv_9= '[' ( (lv_lowerBound_10_0= ruleBound ) ) otherlv_11= '..' ( (lv_upperBound_12_0= ruleBound ) ) otherlv_13= ']' otherlv_14= '{' otherlv_15= 'contextableElements' otherlv_16= '=' otherlv_17= '[' ( ( ( ruleFQN ) ) (otherlv_19= ',' ( ( ruleFQN ) ) )* )? otherlv_21= ']' otherlv_22= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getSiriusExpressionDescriptionAccess().getExpKeyword_0());
                
            // InternalExpressionDSL.g:355:1: ( ( ruleFQN ) )
            // InternalExpressionDSL.g:356:1: ( ruleFQN )
            {
            // InternalExpressionDSL.g:356:1: ( ruleFQN )
            // InternalExpressionDSL.g:357:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSiriusExpressionDescriptionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSiriusExpressionDescriptionAccess().getExpressionEAttributeCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_11);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_12); 

                	newLeafNode(otherlv_2, grammarAccess.getSiriusExpressionDescriptionAccess().getLeftParenthesisKeyword_2());
                
            // InternalExpressionDSL.g:374:1: ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID||LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalExpressionDSL.g:374:2: ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    {
                    // InternalExpressionDSL.g:374:2: ( (lv_parameters_3_0= ruleParameter ) )
                    // InternalExpressionDSL.g:375:1: (lv_parameters_3_0= ruleParameter )
                    {
                    // InternalExpressionDSL.g:375:1: (lv_parameters_3_0= ruleParameter )
                    // InternalExpressionDSL.g:376:3: lv_parameters_3_0= ruleParameter
                    {
                     
                    	        newCompositeNode(grammarAccess.getSiriusExpressionDescriptionAccess().getParametersParameterParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_13);
                    lv_parameters_3_0=ruleParameter();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSiriusExpressionDescriptionRule());
                    	        }
                           		add(
                           			current, 
                           			"parameters",
                            		lv_parameters_3_0, 
                            		"org.eclipse.sirius.expression.dsl.ExpressionDSL.Parameter");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalExpressionDSL.g:392:2: (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==17) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalExpressionDSL.g:392:4: otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_14); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getSiriusExpressionDescriptionAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // InternalExpressionDSL.g:396:1: ( (lv_parameters_5_0= ruleParameter ) )
                    	    // InternalExpressionDSL.g:397:1: (lv_parameters_5_0= ruleParameter )
                    	    {
                    	    // InternalExpressionDSL.g:397:1: (lv_parameters_5_0= ruleParameter )
                    	    // InternalExpressionDSL.g:398:3: lv_parameters_5_0= ruleParameter
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSiriusExpressionDescriptionAccess().getParametersParameterParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_13);
                    	    lv_parameters_5_0=ruleParameter();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSiriusExpressionDescriptionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameters",
                    	            		lv_parameters_5_0, 
                    	            		"org.eclipse.sirius.expression.dsl.ExpressionDSL.Parameter");
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

            otherlv_6=(Token)match(input,18,FOLLOW_9); 

                	newLeafNode(otherlv_6, grammarAccess.getSiriusExpressionDescriptionAccess().getRightParenthesisKeyword_4());
                
            otherlv_7=(Token)match(input,13,FOLLOW_3); 

                	newLeafNode(otherlv_7, grammarAccess.getSiriusExpressionDescriptionAccess().getColonKeyword_5());
                
            // InternalExpressionDSL.g:422:1: ( ( ruleFQN ) )
            // InternalExpressionDSL.g:423:1: ( ruleFQN )
            {
            // InternalExpressionDSL.g:423:1: ( ruleFQN )
            // InternalExpressionDSL.g:424:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSiriusExpressionDescriptionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSiriusExpressionDescriptionAccess().getTypeEClassifierCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_15);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_9=(Token)match(input,19,FOLLOW_16); 

                	newLeafNode(otherlv_9, grammarAccess.getSiriusExpressionDescriptionAccess().getLeftSquareBracketKeyword_7());
                
            // InternalExpressionDSL.g:441:1: ( (lv_lowerBound_10_0= ruleBound ) )
            // InternalExpressionDSL.g:442:1: (lv_lowerBound_10_0= ruleBound )
            {
            // InternalExpressionDSL.g:442:1: (lv_lowerBound_10_0= ruleBound )
            // InternalExpressionDSL.g:443:3: lv_lowerBound_10_0= ruleBound
            {
             
            	        newCompositeNode(grammarAccess.getSiriusExpressionDescriptionAccess().getLowerBoundBoundParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_17);
            lv_lowerBound_10_0=ruleBound();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSiriusExpressionDescriptionRule());
            	        }
                   		set(
                   			current, 
                   			"lowerBound",
                    		lv_lowerBound_10_0, 
                    		"org.eclipse.sirius.expression.dsl.ExpressionDSL.Bound");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,20,FOLLOW_16); 

                	newLeafNode(otherlv_11, grammarAccess.getSiriusExpressionDescriptionAccess().getFullStopFullStopKeyword_9());
                
            // InternalExpressionDSL.g:463:1: ( (lv_upperBound_12_0= ruleBound ) )
            // InternalExpressionDSL.g:464:1: (lv_upperBound_12_0= ruleBound )
            {
            // InternalExpressionDSL.g:464:1: (lv_upperBound_12_0= ruleBound )
            // InternalExpressionDSL.g:465:3: lv_upperBound_12_0= ruleBound
            {
             
            	        newCompositeNode(grammarAccess.getSiriusExpressionDescriptionAccess().getUpperBoundBoundParserRuleCall_10_0()); 
            	    
            pushFollow(FOLLOW_18);
            lv_upperBound_12_0=ruleBound();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSiriusExpressionDescriptionRule());
            	        }
                   		set(
                   			current, 
                   			"upperBound",
                    		lv_upperBound_12_0, 
                    		"org.eclipse.sirius.expression.dsl.ExpressionDSL.Bound");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_13=(Token)match(input,21,FOLLOW_4); 

                	newLeafNode(otherlv_13, grammarAccess.getSiriusExpressionDescriptionAccess().getRightSquareBracketKeyword_11());
                
            otherlv_14=(Token)match(input,9,FOLLOW_19); 

                	newLeafNode(otherlv_14, grammarAccess.getSiriusExpressionDescriptionAccess().getLeftCurlyBracketKeyword_12());
                
            otherlv_15=(Token)match(input,22,FOLLOW_20); 

                	newLeafNode(otherlv_15, grammarAccess.getSiriusExpressionDescriptionAccess().getContextableElementsKeyword_13());
                
            otherlv_16=(Token)match(input,23,FOLLOW_15); 

                	newLeafNode(otherlv_16, grammarAccess.getSiriusExpressionDescriptionAccess().getEqualsSignKeyword_14());
                
            otherlv_17=(Token)match(input,19,FOLLOW_21); 

                	newLeafNode(otherlv_17, grammarAccess.getSiriusExpressionDescriptionAccess().getLeftSquareBracketKeyword_15());
                
            // InternalExpressionDSL.g:501:1: ( ( ( ruleFQN ) ) (otherlv_19= ',' ( ( ruleFQN ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalExpressionDSL.g:501:2: ( ( ruleFQN ) ) (otherlv_19= ',' ( ( ruleFQN ) ) )*
                    {
                    // InternalExpressionDSL.g:501:2: ( ( ruleFQN ) )
                    // InternalExpressionDSL.g:502:1: ( ruleFQN )
                    {
                    // InternalExpressionDSL.g:502:1: ( ruleFQN )
                    // InternalExpressionDSL.g:503:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSiriusExpressionDescriptionRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSiriusExpressionDescriptionAccess().getContextableElementsEClassCrossReference_16_0_0()); 
                    	    
                    pushFollow(FOLLOW_22);
                    ruleFQN();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalExpressionDSL.g:516:2: (otherlv_19= ',' ( ( ruleFQN ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==17) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalExpressionDSL.g:516:4: otherlv_19= ',' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_19=(Token)match(input,17,FOLLOW_3); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getSiriusExpressionDescriptionAccess().getCommaKeyword_16_1_0());
                    	        
                    	    // InternalExpressionDSL.g:520:1: ( ( ruleFQN ) )
                    	    // InternalExpressionDSL.g:521:1: ( ruleFQN )
                    	    {
                    	    // InternalExpressionDSL.g:521:1: ( ruleFQN )
                    	    // InternalExpressionDSL.g:522:3: ruleFQN
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSiriusExpressionDescriptionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSiriusExpressionDescriptionAccess().getContextableElementsEClassCrossReference_16_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_22);
                    	    ruleFQN();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_21=(Token)match(input,21,FOLLOW_23); 

                	newLeafNode(otherlv_21, grammarAccess.getSiriusExpressionDescriptionAccess().getRightSquareBracketKeyword_17());
                
            otherlv_22=(Token)match(input,10,FOLLOW_2); 

                	newLeafNode(otherlv_22, grammarAccess.getSiriusExpressionDescriptionAccess().getRightCurlyBracketKeyword_18());
                

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
    // $ANTLR end "ruleSiriusExpressionDescription"


    // $ANTLR start "entryRuleParameter"
    // InternalExpressionDSL.g:551:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalExpressionDSL.g:552:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalExpressionDSL.g:553:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalExpressionDSL.g:560:1: ruleParameter returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( ( ruleFQN ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;

         enterRule(); 
            
        try {
            // InternalExpressionDSL.g:563:28: ( ( ( (lv_optional_0_0= 'optional' ) )? ( ( ruleFQN ) ) ) )
            // InternalExpressionDSL.g:564:1: ( ( (lv_optional_0_0= 'optional' ) )? ( ( ruleFQN ) ) )
            {
            // InternalExpressionDSL.g:564:1: ( ( (lv_optional_0_0= 'optional' ) )? ( ( ruleFQN ) ) )
            // InternalExpressionDSL.g:564:2: ( (lv_optional_0_0= 'optional' ) )? ( ( ruleFQN ) )
            {
            // InternalExpressionDSL.g:564:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==24) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalExpressionDSL.g:565:1: (lv_optional_0_0= 'optional' )
                    {
                    // InternalExpressionDSL.g:565:1: (lv_optional_0_0= 'optional' )
                    // InternalExpressionDSL.g:566:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,24,FOLLOW_3); 

                            newLeafNode(lv_optional_0_0, grammarAccess.getParameterAccess().getOptionalOptionalKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getParameterRule());
                    	        }
                           		setWithLastConsumed(current, "optional", true, "optional");
                    	    

                    }


                    }
                    break;

            }

            // InternalExpressionDSL.g:579:3: ( ( ruleFQN ) )
            // InternalExpressionDSL.g:580:1: ( ruleFQN )
            {
            // InternalExpressionDSL.g:580:1: ( ruleFQN )
            // InternalExpressionDSL.g:581:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getVariableSiriusVariableCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            ruleFQN();

            state._fsp--;

             
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleBound"
    // InternalExpressionDSL.g:602:1: entryRuleBound returns [String current=null] : iv_ruleBound= ruleBound EOF ;
    public final String entryRuleBound() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBound = null;


        try {
            // InternalExpressionDSL.g:603:2: (iv_ruleBound= ruleBound EOF )
            // InternalExpressionDSL.g:604:2: iv_ruleBound= ruleBound EOF
            {
             newCompositeNode(grammarAccess.getBoundRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBound=ruleBound();

            state._fsp--;

             current =iv_ruleBound.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleBound"


    // $ANTLR start "ruleBound"
    // InternalExpressionDSL.g:611:1: ruleBound returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleBound() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // InternalExpressionDSL.g:614:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalExpressionDSL.g:615:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalExpressionDSL.g:615:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalExpressionDSL.g:615:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalExpressionDSL.g:615:2: (kw= '-' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalExpressionDSL.g:616:2: kw= '-'
                    {
                    kw=(Token)match(input,25,FOLLOW_24); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getBoundAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getBoundAccess().getINTTerminalRuleCall_1()); 
                

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
    // $ANTLR end "ruleBound"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000009410L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008400L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001040020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000200020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000220000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000040L});

}